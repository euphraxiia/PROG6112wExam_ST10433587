
package com.mycompany.productsalesapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {
    
    private ProductSales productSales;
    
    public ProductSalesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        // Runs once before all tests
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Runs once after all tests
    }
    
    @BeforeEach
    public void setUp() {
        // Runs before each test - initialize ProductSales object
        productSales = new ProductSales();
    }
    
    @AfterEach
    public void tearDown() {
        // Runs after each test - cleanup
        productSales = null;
    }
    
    // test to determine that the correct values are returned when the 
    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        System.out.println("GetSalesOverLimit");
        
        // Act
        int result = productSales.GetSalesOverLimit();
        
        // Assert
        assertEquals(2, result, "Expected 2 sales over limit (700 and 600)");
    }
    
    // test to determine that the correct values are returned when the 
    
    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        System.out.println("GetSalesUnderLimit");
        
        // Act
        int result = productSales.GetSalesUnderLimit();
        
        // Assert
        assertEquals(4, result, "Expected 4 sales under limit");
    }
    
    // test to determine correct value returned 
    @Test
    public void GetTotalSales_ReturnsCorrectTotal() {
        System.out.println("GetTotalSales");
        
        // Act
        int result = productSales.GetTotalSales();
        
        // Assert
        assertEquals(2200, result, "Total should be 2200");
    }
    
    // test to determine correct average returned 
    
    @Test
    public void GetAverageSales_ReturnsCorrectAverage() {
        System.out.println("getAverageSales");
        
        // Act
        int result = productSales.getAverageSales();
        
        // Assert
        assertEquals(366, result, "Average should be 366 (2200/6)");
    }
    
    // Test of GetProductSales method, of class ProductSales.
     
    @Test
    public void GetProductSales_ReturnsArrayOfSales() {
        System.out.println("GetProductSales");
        
        // Act
        int[][] result = productSales.GetProductSales();
        
        // Assert
        assertNotNull(result, "Sales array should not be null");
        assertEquals(2, result.length, "Should have 2 years");
        assertEquals(3, result[0].length, "Year 1 should have 3 products");
    }
    
    
    @Test
    public void GetYearsProcessed_ReturnsCorrectCount() {
        System.out.println("getYearsProcessed");
        
        // Act
        int result = productSales.getYearsProcessed();
        
        // Assert
        assertEquals(2, result, "Should have processed 2 years");
    }
}