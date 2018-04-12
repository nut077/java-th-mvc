package com.nutfreedom.controller;

import com.nutfreedom.dao.BooksDao;
import com.nutfreedom.dao.BooksDaoImpl;
import com.nutfreedom.db.Database;
import com.nutfreedom.model.Books;
import com.nutfreedom.view.ShowBooks;

import java.util.List;

public class ShowBooksController {
    private ShowBooks showBooks;
    private Database database;
    BooksDao booksDao;

    public ShowBooksController(ShowBooks showBooks) {
        this.showBooks = showBooks;
        this.showBooks.setVisible(true);

        database = new Database();
        booksDao = new BooksDaoImpl(database);
        showBooks();
        database.close();
    }

    public void showBooks() {
        List<Books> booksList = booksDao.getAllBooks();
        showBooks.showBooks(booksList);
    }

}
