/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author anuragahirrao
 */
public class BCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        JSONParser parser = new JSONParser();

        try {

            JSONArray fileArray = (JSONArray) parser.parse(new FileReader("/Users/anuragahirrao/Desktop/family-tree.json"));
            int marriedCount = 0;//for married
            int withoutChildenCount = 0;//for people without children
            int threeOrMoreChildren = 0;//for people with 3 or more children

            marriedCount = calcMarriedPeople(fileArray, marriedCount);
            withoutChildenCount = calcPeopleWOChildren(fileArray, withoutChildenCount);
            threeOrMoreChildren = calcPeopleWThreeorMoreChildren(fileArray, threeOrMoreChildren);

            System.out.println("Number of Married People is " + marriedCount);
            System.out.println("Number of People without children is " + withoutChildenCount);
            System.out.println("Number of People with 3 or more children is " + threeOrMoreChildren);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static int calcMarriedPeople(JSONArray ja, int calcMarriedCount) {

        //main 'for' loop
        for (Object o : ja) {

            JSONObject jsonObject = (JSONObject) o;
            //counting married
            long id = (Long) jsonObject.get("spouseId");
            if (id != -1) {//if not unmarried,increase counter
                calcMarriedCount++;
            }

        }
        return calcMarriedCount;
    }

    private static int calcPeopleWOChildren(JSONArray ja, int withoutChildenCount) {

        //main 'for' loop
        for (Object o : ja) {

            JSONObject jsonObject = (JSONObject) o;

            JSONArray children = (JSONArray) jsonObject.get("childrenIds");
            int childCounter = 0;
            for (Object child : children) {//counting children 
                childCounter++;
            }
            if (childCounter == 0) {//if no children,increase respective counter
                withoutChildenCount++;
            }

        }
        return withoutChildenCount;
    }

    private static int calcPeopleWThreeorMoreChildren(JSONArray ja, int threeOrMoreChildren) {
        //main 'for' loop
        for (Object o : ja) {

            JSONObject jsonObject = (JSONObject) o;

            JSONArray children = (JSONArray) jsonObject.get("childrenIds");
            int childCounter = 0;
            for (Object child : children) {//counting children 
                childCounter++;
            }

            if (childCounter >= 3) {//if three or more children, increase respective counter
                threeOrMoreChildren++;
            }

        }
        return threeOrMoreChildren;
    }

}
