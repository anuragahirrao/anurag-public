/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluewolf;

import java.util.HashSet;

/**
 *
 * @author anuragahirrao
 */
public class BlueWolf {

    /**
     * @param args the command line arguments
     */
    public static void main(int[] arr) {

        //****************
        //for testing:
        //a[1000] = 5;
        //*****************
        
        HashSet<Integer> hs = new HashSet<>();
        int flag = 0;
        for (int i = 0; i < 1000000; i++) {

            if (!hs.add(arr[i])) {
                flag = 1;
                System.out.println("Element duplicate: " + arr[i]);
            }

        }
        if (flag == 0) {
            System.out.print("No duplicates present \n");
        }

    }

}
