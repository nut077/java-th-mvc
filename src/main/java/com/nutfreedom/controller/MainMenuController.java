package com.nutfreedom.controller;

import com.nutfreedom.model.Books;
import com.nutfreedom.view.AddBook;
import com.nutfreedom.view.MainMenu;
import com.nutfreedom.view.ShowBooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
    private MainMenu mainMenu;

    public MainMenuController(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.setVisible(true);

        mainMenu.getBtnShowBooks().setActionCommand("show");
        mainMenu.getBtnAddBook().setActionCommand("add");

        mainMenu.getBtnShowBooks().addActionListener(this);
        mainMenu.getBtnAddBook().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("show")) {
            ShowBooks view = new ShowBooks();
            new ShowBooksController(view);
        } else if (command.equals("add")) {
            Books model = new Books();
            AddBook view = new AddBook();
            new AddBookController(model, view);
        }
    }
}
