/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.Serializable;

/**
 *
 * @author hunglv
 */
public class Student implements Serializable{
    String ten;
    public Student(String ten) {
        this.ten = ten;
    }
    public String toString() {
        return ten;
    }
}
