/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluewolf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anuragahirrao
 */
public class BlueWolfTest {
    
    public BlueWolfTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BlueWolf.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        int[] a = new int[1000000];

        for (int i = 0; i < 1000000; i++) {
            a[i] = i + 1;
        }
        a[1001]=6;
        
        BlueWolf.main(a);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
