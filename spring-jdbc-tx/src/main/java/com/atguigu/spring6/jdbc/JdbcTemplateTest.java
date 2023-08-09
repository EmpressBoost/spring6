package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.Map;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询：返回对象
    @Test
    public void testSelectObject(){
      /*  //方法1
        //1.编写sql
        String sql="select * from t_emp WHERE id=?";
        Emp empRel = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 1);
        System.out.println(empRel);*/
        //方法2
        String sql="select * from t_emp WHERE id=?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp);
    }
    //查询：返回list集合
    @Test
    public void testSelectList(){
        String sql="select * from t_emp";
        List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(emps);
    }

    //查询：返回单个值

    @Test
    public void testSelectValue(){
        String sql="select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

//    添加 修改 删除
    @Test
    public void testUpdate(){
      /*  //add
        //1.编写sql
        String sql="INSERT INTO t_emp VALUES(NULL,?,?,?)";
        //2.调用jdbcTemplate方法，传入相关参数
      *//*  Object[] params ={"东方不败", 20, "未知"};
        int rows = jdbcTemplate.update(sql, params;*//*

        int rows = jdbcTemplate.update(sql, "林平之", 40, "未知");
        */

     /*   //update
        //1.编写sql
        String sql="UPDATE t_emp SET NAME=? WHERE id=?";
        //2.调用jdbcTemplate方法，传入相关参数
        int rows = jdbcTemplate.update(sql, "林平之atguigu", 3);*/

        //delete
        //1.编写sql
        String sql="DELETE FROM t_emp WHERE id=?";
        //2.调用jdbcTemplate方法，传入相关参数
        int rows = jdbcTemplate.update(sql, 3);


        System.out.println(rows);
    }

}
