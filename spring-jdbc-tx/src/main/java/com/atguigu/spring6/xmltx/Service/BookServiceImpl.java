package com.atguigu.spring6.xmltx.Service;

import com.atguigu.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //1 根据图书id 查询价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书库存-1
        bookDao.updateStock(bookId);
        //更新用户余额 -图书价格
        bookDao.updateUserBalance(userId,price);
    }
}
