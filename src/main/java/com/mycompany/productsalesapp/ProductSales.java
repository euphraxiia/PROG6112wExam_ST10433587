
package com.mycompany.productsalesapp;

public class ProductSales implements IProductSales {
    private int[][] sales;
    private final int SALES_LIMIT = 500;
    
    public ProductSales() {
        // Initialize with sample data
        sales = new int[][] {
            {300, 150, 700},  // Year 1: Microphone, Speakers, Mixing Desk
            {250, 200, 600}   // Year 2: Microphone, Speakers, Mixing Desk
        };
    }
    
    @Override
    public int[][] GetProductSales() {
        return sales;
    }
    
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : sales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }
    
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int sale : year) {
                if (sale > SALES_LIMIT) count++;
            }
        }
        return count;
    }
    
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int sale : year) {
                if (sale < SALES_LIMIT) count++;
            }
        }
        return count;
    }
    
    public int getYearsProcessed() {
        return sales.length;
    }
    
    public int getAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] year : sales) {
            count += year.length;
        }
        return count > 0 ? total / count : 0;
    }
}

