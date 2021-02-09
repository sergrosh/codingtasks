package com.coding.patterns.decorator;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class FileDataSource implements DataSource {

    private String fileName;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String data) {
        File file = new File(fileName);
        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(file))) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String read() {

        char[] buffer = null;
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }

//    public static void main(String[] args) {
//        DataSource dataSource = new FileDataSource("some.txt");
//        String testString = "Test string";
//        dataSource.write(testString);
//        System.out.println(dataSource.read());
//    }
}
