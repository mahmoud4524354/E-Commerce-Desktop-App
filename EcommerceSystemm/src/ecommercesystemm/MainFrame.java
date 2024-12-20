/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommercesystemm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Cart.CartManager;
import Factories.ProductFactory;
import Models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private JComboBox<String> categoryComboBox;
    private JTable productsTable;
    private JTable cartTable;
    private JButton addButton;
    private JButton payButton;

    private Map<String, List<String>> productData;

    public MainFrame() {
        initProductData(); // تهيئة المنتجات
        initComponents();
    }

    private void initProductData() {
        productData = new HashMap<>();

        // منتجات الإلكترونيات
        List<String> electronics = new ArrayList<>();
        electronics.add("Smartphone");
        electronics.add("Laptop");
        electronics.add("Tablet");
        electronics.add("Headphones");
        productData.put("Electronics", electronics);

        // منتجات الملابس
        List<String> clothing = new ArrayList<>();
        clothing.add("T-shirt");
        clothing.add("Jeans");
        clothing.add("Jacket");
        clothing.add("Sneakers");
        productData.put("Clothing", clothing);

        // منتجات الأدوات المنزلية
        List<String> homeAppliances = new ArrayList<>();
        homeAppliances.add("Microwave");
        homeAppliances.add("Vacuum Cleaner");
        homeAppliances.add("Refrigerator");
        homeAppliances.add("Washing Machine");
        productData.put("Home Appliance", homeAppliances);
    }

    private void initComponents() {
        setTitle("E-Commerce System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);

        categoryComboBox = new JComboBox<>(new String[]{"Electronics", "Clothing", "Home Appliance"});
        productsTable = new JTable(new DefaultTableModel(new Object[]{"Product Name"}, 0));
        cartTable = new JTable(new DefaultTableModel(new Object[]{"Cart Items"}, 0));
        addButton = new JButton("Add to Cart");
        payButton = new JButton("Pay");

        categoryComboBox.addActionListener(evt -> updateProductsTable());

        addButton.addActionListener(evt -> addProductToCart());

        payButton.addActionListener(evt -> payButtonActionPerformed(evt));

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Category:"));
        topPanel.add(categoryComboBox);
        topPanel.add(addButton);
        topPanel.add(payButton);

        JScrollPane productsScrollPane = new JScrollPane(productsTable);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, productsScrollPane, cartScrollPane);
        splitPane.setDividerLocation(250);

        add(topPanel, "North");
        add(splitPane, "Center");

     
        updateProductsTable();
    }

    private void updateProductsTable() {
        String selectedCategory = categoryComboBox.getSelectedItem().toString();
        List<String> products = productData.get(selectedCategory);

        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.setRowCount(0); 

        for (String product : products) {
            model.addRow(new Object[]{product});
        }
    }

    private void addProductToCart() {
        int selectedRow = productsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
            return;
        }

        String productName = productsTable.getValueAt(selectedRow, 0).toString();
        CartManager.getInstance().addItem(productName);
        updateCartTable();
    }

    private void updateCartTable() {
        List<String> cartItems = CartManager.getInstance().getItems();
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0); 

        for (String item : cartItems) {
            model.addRow(new Object[]{item});
        }
    }

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (CartManager.getInstance().getItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty. Add items to cart before proceeding to payment.");
            return;
        }

        double amount = CartManager.getInstance().getItems().size() * 50.0; // افتراض مبلغ لكل منتج
        JOptionPane.showMessageDialog(this, "Payment Successful! Total Amount: $" + amount);

        CartManager.getInstance().getItems().clear();
        updateCartTable();
    }
}