package com.atguigu.spring6.bean;

import com.atguigu.spring6.anno.Bean;
import com.atguigu.spring6.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{
    //创建map集合 放bean对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //传递有参构造，传递包路径，设置包扫描的规则
    //当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化放到map中
    public AnnotationApplicationContext(String basePackge) throws Exception{
//    public static void pathdemo1(String basePackge){
        //com.atgui.spring6
        try {
            //1.把.替换成\
            String packagePath = basePackge.replaceAll("\\.", "\\\\");
            //2.获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                //绝对路径
                URL url = urls.nextElement();
                String filepath = URLDecoder.decode(url.getFile(), "utf-8");
                //获取包前面的路径部分，字符串截取
                rootPath = filepath.substring(0, filepath.length() - packagePath.length());
                this.loadBean(new File(filepath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //属性注入
        loadDi();
    }

    //包扫描过程，创建bean
    private void loadBean(File file) throws Exception {
        //1.判断当前的是否文件夹
        if (file.isDirectory()) {
            //2.获取文件夹里面的内容
            File[] childrenFiles = file.listFiles();
            //3.判断文件夹的内容为空，直接返回
            if (childrenFiles == null || childrenFiles.length==0){
                return;
            }
            //4.如果文件夹不为空，遍历所有内容，
            for (File child : childrenFiles) {
                //4.1遍历每个得到的file对象，继续判断，如果还是文件夹，递归
                if(child.isDirectory()){
                    loadBean(child);
                }else {
                    //4.2遍历得到file对象不是文件夹，是文件，
                    //4.3得到包路径+类名称部分 -字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4判断当前文件类型是否.class类型
                    if(pathWithClass.contains(".class")){
                        //4.5如果是.class类型，把路径\替换. 把.class去掉
                        //com.atguigu.service.UserServiceImpl

                        String allName = pathWithClass.replaceAll("\\\\", ".").replaceAll(".class", "");

                        //4.6判断类上面是否有注解@Bean 如果有则实例化
                        //4.6.1 获取类的Class
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2 判断不是接口
                        if(!clazz.isInterface()){
                            //4.6.3判断类上面是否有注解@Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                //4.6.4 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                //4.7把对象实例化之后，放到map集合beanFactory
                                //4.7.1判断当前类如果有接口，让接口class作为map的key
                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else {
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }

                    }

                }

            }

        }
    }

    //属性注入
    private void loadDi(){
        //实例化的对象在beanFactory的map集合里面
        //1.遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            //2.获取map集合的每个对象（value），每个对象的属性获取到
            Object obj = entry.getValue();
            //获取Class对象
            Class<?> clazz = obj.getClass();
            //获取每个对象属性
            Field[] fields = clazz.getDeclaredFields();
            //3.遍历得到的每个属性的数组，得到每个属性
            for (Field field : fields) {
                //4.判断属性上面是否有@Di注解
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null){
                    //如果是私有属性，设置可以设置值
                    field.setAccessible(true);
                    //5.如果有@Di注解，把对象进行设置（注入)
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
