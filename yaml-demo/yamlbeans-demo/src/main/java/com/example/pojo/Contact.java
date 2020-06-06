package com.example.pojo;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {

    /**
     * name: Nathan Sweet
     * age: 28
     * address: 4011 16th Ave S
     * phone numbers:
     *   - name: Home
     *     number: 206-555-5138
     *   - name: Work
     *     number: 425-555-2306
     */

    private String name;
    private int age;
    private String address;
    private List<Phone> phoneNumbers;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

    public static class Phone implements  Serializable{
        private String name;
        private String number;

        public Phone() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}

