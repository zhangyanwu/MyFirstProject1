package com.example.mycomputer.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/30.
 */
public class BookContent {
    public static class Book
    {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();

    public static Map<Integer,Book> ITEM_MAP = new HashMap<Integer,Book>();

    static
    {
        addItem(new Book(1,"java基础","略懂！"));
        addItem(new Book(2,"JavaEE","略懂！"));
        addItem(new Book(3,"Android","略懂！"));
    }

    private static void addItem(Book book)
    {
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
