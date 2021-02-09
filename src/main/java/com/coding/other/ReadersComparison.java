package com.coding.other;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class ReadersComparison {
    public static void main(String[] args) throws IOException {
        ReadersComparison readersComparison = new ReadersComparison();
        readersComparison.readWithFileReader();
        readersComparison.readWithBufferedReader();
        readersComparison.readWithBufferedOutputStream();
        readersComparison.readWithCommonsIO();
        readersComparison.readWithNIO();
        readersComparison.readWithFileChannel();
    }

    void readWithFileReader() {
        File file = new File("big.txt");
        long start = System.currentTimeMillis();
        try (FileReader reader = new FileReader(file)) {
            StringBuilder stringBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
        } catch (IOException ex) {

        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time with file reader is: " + Long.toString(end - start) + " ms");
    }

    void readWithBufferedReader() throws IOException {
        File file = new File("big.txt");
        long start = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder stringBuilder = new StringBuilder();
        CharBuffer cbuff = CharBuffer.allocate(20 * 1024);
        while (reader.read(cbuff) != -1) {
            stringBuilder.append(cbuff);
            cbuff.clear();
        }
        reader.close();
        long end = System.currentTimeMillis();
        System.out.println("Execution time with buffered reader is: " + Long.toString(end - start) + " ms");
    }

    void readWithBufferedOutputStream() throws IOException {
        File file = new File("big.txt");
        FileInputStream fis = new FileInputStream(file);

        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuilder stringBuilder = new StringBuilder();
        long start = System.currentTimeMillis();
        // byte array to store input
        byte[] contents = new byte[20 * 1024];
        int bytesRead;
        String s;

        while ((bytesRead = bis.read(contents)) != -1) {
            s = new String(contents, 0, bytesRead);
            stringBuilder.append(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time with buffered input stream is: " + (end - start) + " ms");
    }

    void readWithCommonsIO() throws IOException {
        File file = new File("big.txt");
        long start = System.currentTimeMillis();
        String data = FileUtils.readFileToString(file, "UTF-8");
        long end = System.currentTimeMillis();
        System.out.println("Execution time with commons io is: " + (end - start) + " ms");
    }

    void readWithNIO() throws IOException {
        Path path = Paths.get("big.txt");
        long start = System.currentTimeMillis();
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        long end = System.currentTimeMillis();
        System.out.println("Execution time with NIO is: " + (end - start) + " ms");
    }

    public void readWithFileChannel()
            throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile reader = new RandomAccessFile("big.txt", "r");
        FileChannel channel = reader.getChannel();

        int bufferSize = 20 * 1024;
        if (bufferSize > channel.size()) {
            bufferSize = (int) channel.size();
        }
        ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        channel.read(buff);
        buff.flip();
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        int bytesRead;
        while ((bytesRead = channel.read(buff)) != -1) {
            s = new String(buff.array(), 0, bytesRead);
            buff.clear();
            stringBuilder.append(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time with File Channel is: " + (end - start) + " ms");
        channel.close();
        reader.close();
    }
}
