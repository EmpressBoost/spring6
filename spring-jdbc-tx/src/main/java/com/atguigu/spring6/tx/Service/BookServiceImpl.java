package com.atguigu.spring6.tx.Service;

import com.atguigu.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //TODO 模拟超时效果
       /* try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //1 根据图书id 查询价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新图书库存-1
        bookDao.updateStock(bookId);
        //更新用户余额 -图书价格
        bookDao.updateUserBalance(userId,price);
//        System.out.println(1/0);
    }
}
