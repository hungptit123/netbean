/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hunglv
 */
public class Find_File {
    public static void main(String[] args) {
        String path = "/home/hunglv/workspace/";
        String des_file = "Find_File.txt";
        List<String> result_path = new ArrayList();
        find_File(des_file, path, result_path);
        for (String result: result_path) {
            System.out.println(result);
        }
    }
    private static void find_File(String des_file, String path, List<String> result_path) {
        File dir = new File(path);
        File []fileList = dir.listFiles();
        for (File name_file: fileList){
            if (name_file.isDirectory()) {
                String path_next = Paths.get(path, name_file.getName()).toString();
                find_File(des_file, path_next, result_path);
            }
            if (name_file.isFile()==true && name_file.getName().compareTo(des_file)==0) {
                result_path.add(Paths.get(path, name_file.getName()).toString());
            }
        }
    }
}
