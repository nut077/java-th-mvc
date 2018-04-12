package com.nutfreedom.view;

import com.nutfreedom.util.FileImages;
import lombok.Data;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;

@Data
public class AddBook extends JFrame {

    private JTextField txtPrice;
    private JTextField txtTitle;
    private JButton btnSave;

    public AddBook() {
        initComponents();
    }

    private void initComponents() {
        JPanel jPanel = new JPanel();
        txtPrice = new JTextField();
        txtTitle = new JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        btnSave = new JButton();
        JLabel bg = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("เพิ่มหนังสือ");

        jPanel.setLayout(new AbsoluteLayout());

        txtPrice.setFont(new Font("TH K2D July8", Font.PLAIN, 18));
        txtPrice.setForeground(new Color(0, 101, 68));
        txtPrice.setHorizontalAlignment(JTextField.CENTER);
        txtPrice.setBorder(null);
        jPanel.add(txtPrice, new AbsoluteConstraints(40, 190, 320, 40));

        txtTitle.setFont(new Font("TH K2D July8", Font.PLAIN, 18));
        txtTitle.setForeground(new Color(0, 101, 68));
        txtTitle.setHorizontalAlignment(JTextField.CENTER);
        txtTitle.setBorder(null);
        jPanel.add(txtTitle, new AbsoluteConstraints(40, 120, 320, 40));

        jLabel1.setFont(new Font("TH K2D July8", Font.PLAIN, 24));
        jLabel1.setForeground(new Color(0, 2, 98));
        jLabel1.setText("ชื่อหนังสือ");
        jPanel.add(jLabel1, new AbsoluteConstraints(40, 90, 320, 30));

        jLabel2.setFont(new Font("TH K2D July8", Font.PLAIN, 24));
        jLabel2.setForeground(new Color(0, 2, 98));
        jLabel2.setText("ราคา");
        jPanel.add(jLabel2, new AbsoluteConstraints(40, 160, 320, 30));

        btnSave.setBackground(new Color(177, 231, 223));
        btnSave.setFont(new Font("TH K2D July8", Font.PLAIN, 24));
        btnSave.setForeground(new Color(0, 101, 68));
        btnSave.setText("บันทึก");
        btnSave.setFocusPainted(false);
        jPanel.add(btnSave, new AbsoluteConstraints(140, 250, 120, 40));

        String imageIcon = FileImages.getFileImages("bg.png");
        if (!imageIcon.equals("")) {
            bg.setIcon(new ImageIcon(imageIcon));
            jPanel.add(bg, new AbsoluteConstraints(0, 0, -1, -1));
        }

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
}
