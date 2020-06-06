package com.example;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.example.pojo.Contact;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YamlBeansTest {

    /**
     * 反序列化，即yaml到实体类
     */
    @Test
    public void reverseSearial(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/Users/doubledumbao/git/yaml-demo/yamlbeans-demo/src/main/resources/contact.yml");
            YamlReader reader = new YamlReader(fileReader);
            Contact contact = reader.read(Contact.class);
            System.out.println(contact);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void serialize(){
        Contact contact = new Contact();
        contact.setName("doubledumbao");
        contact.setAge(33);
        contact.setAddress("shandong province");
        List<Contact.Phone> phoneNumbers = new ArrayList<>();
        Contact.Phone phone1 = new Contact.Phone();
        phone1.setName("lx");
        phone1.setNumber("189541");
        phoneNumbers.add(phone1);
        Contact.Phone phone2 = new Contact.Phone();
        phone2.setName("lcy");
        phone2.setNumber("179532");
        phoneNumbers.add(phone2);
        contact.setPhoneNumbers(phoneNumbers);

        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("phones.yml"));
            YamlWriter yamlWriter = new YamlWriter(writer);
            yamlWriter.write(contact);
            yamlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
