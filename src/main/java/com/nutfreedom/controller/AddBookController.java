package com.nutfreedom.controller;

import com.nutfreedom.dao.BooksDao;
import com.nutfreedom.dao.BooksDaoImpl;
import com.nutfreedom.db.Database;
import com.nutfreedom.model.Books;
import com.nutfreedom.view.AddBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookController implements ActionListener {
    private Books model;
    private AddBook view;
    private Database database;
    private BooksDao booksDao;

    public AddBookController(Books books, AddBook addBook) {
        this.model = books;
        this.view = addBook;

        addBook.setVisible(true);
        addBook.getBtnSave().setActionCommand("save");
        addBook.getBtnSave().addActionListener(this);

        database = new Database();
        booksDao = new BooksDaoImpl(database);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            String title = view.getTxtTitle().getText().trim();
            String price = view.getTxtPrice().getText().trim();

            model.setTitle(title);
            model.setPrice(Integer.parseInt(price));
            save();
            database.close();
        }
    }

    public void save() {
        if (booksDao.isAddBook(model)) {
            JOptionPane.showMessageDialog(view, "บันทึกสำเร็จ", "ผลลัพธ์", 1);
            view.getTxtTitle().setText("");
            view.getTxtPrice().setText("");
        } else {
            JOptionPane.showMessageDialog(view, "บันทึกไม่สำเร็จ", "ผลลัพธ์", 0);
            System.exit(0);
        }
    }
}
