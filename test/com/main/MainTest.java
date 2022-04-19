package com.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void EquivalencePartitioning() throws Exception {

        // tests for exceptions
        assertTrue(Main.func(10, new int[]{4, 7, 2, 6, 9, 2, 3, 3, 7, 9}, 9, 6));  //C_1111

        assertFalse(Main.func(11, new int[]{3, 7, 4, 9, 1, 2, 1, 6, 7, 3, 3}, 3, 4));  //C_1112

        Exception e = assertThrows(Exception.class, ()->{
            Main.func(4, new int[]{3, 7, 4, 9}, 2, -1);  // C_112
        });
        assertEquals("d is lower or equal 0", e.getMessage());

        Exception f = assertThrows(Exception.class, ()->{
            Main.func(5, new int[]{3, 7, 4, 9, 7}, 0, 3);  // C_12
        });
        assertEquals("m is lower or equal 1", f.getMessage());

        Exception g = assertThrows(Exception.class, ()->{
            Main.func(5, new int[]{3, 7, 4, 9, 7}, 9, 3);  // C_13
        });
        assertEquals("m is bigger or equal n", g.getMessage());

        Exception h = assertThrows(Exception.class, ()->{
            Main.func(-5, new int[]{3, 7, 4, 9}, 2, 5); // C_2
        });
        assertEquals("n is lower than 1", h.getMessage());

        Exception i = assertThrows(Exception.class, ()->{
            Main.func(102, new int[]{3, 7, 4, 9}, 2, 5);// C_3
        });
        assertEquals("n is bigger than 99", i.getMessage());

        Exception j = assertThrows(Exception.class, ()->{
            Main.func(4, new int[]{1, 2, 3}, 2, 5);// C_4
        });
        assertEquals("n is bigger than 99", i.getMessage());
    }

    @Test
    public void BoundaryValueAnalysis() throws Exception {
        // tests for exceptions
        Exception e1 = assertThrows(Exception.class, ()->{
            Main.func(1, new int[]{1}, 1, 1);  // C_111
        });
        assertEquals("m is lower or equal 1", e1.getMessage());

        Exception e2 = assertThrows(Exception.class, ()->{
            Main.func(99, new int[]{1}, 1, 1);  // C_121
        });
        assertEquals("length of s is not equal with n", e2.getMessage());

        Exception e3 = assertThrows(Exception.class, ()->{
            Main.func(100, new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}, 1, 1);  // C_311
        });
        assertEquals("n is bigger than 99", e3.getMessage());

        Exception e4 = assertThrows(Exception.class, ()->{
            Main.func(0, new int[]{}, 1, 1); // C_211
        });
        assertEquals("n is lower than 1", e4.getMessage());


    }

    @Test
    public void CauseEffectGraphing () throws Exception{

        Exception e1 = assertThrows(Exception.class, ()->{
            Main.func(0, new int[]{}, 1, 1); //T1
        });
        assertEquals("n is lower than 1", e1.getMessage());

        Exception e2 = assertThrows(Exception.class, ()->{
            Main.func(100, new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}, 7, 3); //T2
        });
        assertEquals("n is bigger than 99", e2.getMessage());

        Exception e3 = assertThrows(Exception.class, ()->{
            Main.func(4, new int[]{1,2,3,4,5}, 2, 3); //T3
        });
        assertEquals("length of s is not equal with n", e3.getMessage());

        Exception e4 = assertThrows(Exception.class, ()->{
            Main.func(3, new int[]{1,2,3}, 1, 7); //T4
        });
        assertEquals("m is lower or equal 1", e4.getMessage());

        Exception e5 = assertThrows(Exception.class, ()->{
            Main.func(5, new int[]{1,2,3,4,5}, 5, 3); //T5
        });
        assertEquals("m is bigger or equal n", e5.getMessage());

        Exception e6 = assertThrows(Exception.class, ()->{
            Main.func(8, new int[]{1,2,3,4,5,6,7,8}, 3, -1); //T6
        });
        assertEquals("d is lower or equal 0", e6.getMessage());

        assertTrue(Main.func(5, new int[]{1,2,3,4,5}, 4, 4)); //T7
    }
   

}