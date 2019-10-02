/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong1;

import java.util.ArrayList;

/**
 *
 * @author hunglv
 */
public class Control {
    Components components;

    public Control(Components components) {
        this.components = components;
    }

    public Control() {
        
    }
    public double implement_operator() {
        if (components == null) 
            return 0.0;
        
        return 0.0;
    }
    public double operating(String name_operating) {
        String s = "";
        ArrayList<Double> list_num = new ArrayList<>();
        ArrayList<Character> list_operator = new ArrayList<>();
        for(int i=0; i<name_operating.length(); i++) {
           char c = name_operating.charAt(i);
           int check = check_char(c);
           if(check == 1) {
               s += c;           
            }
           if (check==0 || i==name_operating.length()-1) {
               try {
                    double num = Double.parseDouble(s);
                    list_num.add(num);
               } catch (Exception e) {
                   System.out.println("input false");
               }
               s = "";
               list_operator.add(c);
           }
           if (check==-1) {
               System.out.println("err");
               return 0.0;
           }
        }
        return (float) 0.0;
    }
    public int check_char(char c) {
        int position = c;
        if (position >= 49 && position <= 58) 
            return 0;
        if (position == '.') {
            return 0;
        }
        char[] arr_char = {'*', '/', '+', '-'};
        for(int i=0; i<arr_char.length; i++) {
            if(c==arr_char[i]) {
                return 1;
            }
        }
        return -1;
    }

}
