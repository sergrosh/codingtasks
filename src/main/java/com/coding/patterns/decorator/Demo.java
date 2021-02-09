package com.coding.patterns.decorator;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("some.txt")));
        encoded.write(salaryRecords);
        DataSource plain = new FileDataSource("some.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.read());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.read());
    }
}
