package ru.gb;

import java.io.File;

public class Tree {
    public static void print(File file, String indent, boolean islast) {
        System.out.print(indent);
        if (islast) {
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│  ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files == null){
            return;
        }

        int subDitTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDitTotal++;
            }
        }

        int subDirCounter =0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDitTotal);
            }
        }

    }
}
