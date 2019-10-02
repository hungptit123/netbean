/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author hunglv
 */
public class Copy_File {
    public static void main(String[] args) {
        String source_file = "/home/hunglv/Downloads/Master IELTS.rar";
        String des_file = "/home/hunglv/workspace/Master_IELTS.rar";
        Copy copy = new Copy();
        copy.implement_copy(source_file, des_file);
    }
}

class Copy {
    private String source_file;
    private String des_file;
    
    public Copy(){
        
    }

    public Copy(String source_file, String des_file) {
        this.source_file = source_file;
        this.des_file = des_file;
    }
    
    private byte[] read_data(String source_file) {
        try (FileInputStream fis = new FileInputStream(source_file);
                BufferedInputStream bufins = new BufferedInputStream(fis)){
            byte []data = new byte[(int)fis.getChannel().size()];
            System.out.println("size: " + fis.getChannel().size());
            while (bufins.available()>0) {
                bufins.read(data);
            }
            bufins.close();
            fis.close();
            return data;
        }catch (Exception e){
            System.out.println("err " + e.getMessage());
        }
        return null;
    }
    
    public void implement_copy(String source_file, String des_file) {
        byte [] data = read_data(source_file);
        try (FileOutputStream fos = new FileOutputStream(des_file);
                BufferedOutputStream bufouts = new BufferedOutputStream(fos)){
            bufouts.write(data);
            bufouts.close();
            fos.close();
        }catch (Exception e){
            System.out.println("err " + e.getMessage());
        }
    }
    
    public String getSource_file() {
        return source_file;
    }

    public void setSource_file(String source_file) {
        this.source_file = source_file;
    }

    public String getDes_file() {
        return des_file;
    }

    public void setDes_file(String des_file) {
        this.des_file = des_file;
    }
    
};
