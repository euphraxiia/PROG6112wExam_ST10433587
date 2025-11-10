package com.mycompany.productsalesapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private ProductSales productSales;
    private JTextArea displayArea;
    private JLabel yearsLabel;
    private JButton loadButton, saveButton;
    
    public ProductSalesApp() {
        productSales = new ProductSales();
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        
        // Create menu bar
        createMenuBar();
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));
        
        loadButton = new JButton("Load Product Data");
        saveButton = new JButton("Save Product Data");
        
        loadButton.addActionListener(e -> loadProductData());
        saveButton.addActionListener(e -> saveProductData());
        
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        
        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        // Years label
        yearsLabel = new JLabel("Years Processed: " + productSales.getYearsProcessed());
        yearsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Add components to main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(yearsLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());
        
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void loadProductData() {
        int totalSales = productSales.GetTotalSales();
        int avgSales = productSales.getAverageSales();
        int overLimit = productSales.GetSalesOverLimit();
        int underLimit = productSales.GetSalesUnderLimit();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Total Sales: ").append(totalSales).append("\n");
        sb.append("Average Sales: ").append(avgSales).append("\n");
        sb.append("Sales over limit: ").append(overLimit).append("\n");
        sb.append("Sales under limit: ").append(underLimit).append("\n");
        
        displayArea.setText(sb.toString());
        yearsLabel.setText("Years Processed: " + productSales.getYearsProcessed());
    }
    
    private void saveProductData() {
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("DATA LOG\n");
            writer.write("*************************************\n");
            writer.write("Total Sales: " + productSales.GetTotalSales() + "\n");
            writer.write("Average Sales: " + productSales.getAverageSales() + "\n");
            writer.write("Sales over limit: " + productSales.GetSalesOverLimit() + "\n");
            writer.write("Sales under limit: " + productSales.GetSalesUnderLimit() + "\n");
            writer.write("*************************************\n");
            writer.close();
            
            JOptionPane.showMessageDialog(this, 
                "Data saved successfully to data.txt", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error saving data: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearData() {
        displayArea.setText("");
        yearsLabel.setText("Years Processed: 0");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductSalesApp app = new ProductSalesApp();
            app.setVisible(true);
        });
    }
}