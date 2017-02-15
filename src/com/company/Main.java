package com.company;

import datamanager.CustomClassLoader;
import datamanager.DataManager;

import java.io.*;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws Exception {

        String url = "https://github.com/svidu/jar/raw/master/animal1.jar";
        OutputStream os = new FileOutputStream("animalFromUrl1.jar");

        InputStream is = new URL(url).openStream();
        byte buffer[] = new byte[1000000];
        int i = is.read(buffer);
        while (i != -1) {
            os.write(buffer, 0, i);
            i = is.read(buffer);
        }
        os.close();


        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class animal = customClassLoader.loadClass("Animal", "animalFromUrl1.jar");
        Object obj = animal.newInstance();

        DataManager.serialize(obj);


    }
}
