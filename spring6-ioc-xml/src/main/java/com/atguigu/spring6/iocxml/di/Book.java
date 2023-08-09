package com.atguigu.spring6.iocxml.di;

public class Book {
    private String bname;
    private String author;
    private String others;

    public Book() {
        
    }
    public Book(String bname, String author,String others) {
        System.out.println("有参构造执行了。。。。。");
        this.bname = bname;
        this.author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("尚硅谷");

        new Book("java", "尚硅谷",null);

    }
}
