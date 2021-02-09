package com.coding.patterns;

import java.util.ArrayList;
import java.util.List;

public class BuilderExample {
    private String name;
    private String surName;
    private int age;
    private List<String> occupations;

    public BuilderExample(String name, String surName, int age, List<String> occupations) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.occupations = occupations;
    }

    public static BuilderExampleBuilder builder() {
        return new BuilderExampleBuilder();
    }

    public static void main(String[] args) {
        System.out.println(BuilderExample.builder().name("John").surName("Smith").age(30)
                .addOccupation("SDE").addOccupation("SDET").build());
    }

    @Override
    public String toString() {
        return "BuilderExample{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", occupations=" + occupations +
                '}';
    }

    public static class BuilderExampleBuilder {
        private String name;
        private String surName;
        private int age;
        private List<String> occupations;

        public BuilderExampleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BuilderExampleBuilder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public BuilderExampleBuilder age(int age) {
            this.age = age;
            return this;
        }

        public BuilderExampleBuilder occupations(List<String> occupations) {
            this.occupations = occupations;
            return this;
        }

        public BuilderExampleBuilder addOccupation(String occupation) {
            if (this.occupations == null) {
                this.occupations = new ArrayList<>();
            }
            occupations.add(occupation);
            return this;
        }


        public BuilderExample build() {
            return new BuilderExample(name, surName, age, occupations);
        }
    }
}
