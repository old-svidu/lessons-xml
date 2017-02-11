package com.company;

import datamanager.DataManager;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        People people = new People("John",201,1111);
        People people1 = new People("John1",2011,10);

        List<People> list = new LinkedList<>();
        list.add(people);
        list.add(people1);


        DataManager.serializeCollection(list);
        DataManager.serialize(people);
        People people11 = DataManager.deserialize("test1.xml");
        System.out.println("name " +people11.getName()+"; age "+ people11.getAge() +"; salary "+ people11.getSalary());
    }
}
