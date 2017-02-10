package com.company;

import datamanager.DataManager;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        People people = new People("John",201,1111);
        People people1 = new People("John1",2011,10);
        People people2 = new People("John1",2011,10);
        People people3 = new People("John1",2011,10);
        List<People> list = new LinkedList<>();
        list.add(people);
        list.add(people1);
        list.add(people2);
        list.add(people3);


        DataManager.serializeCollection(list);
        //DataManager.serialize(people);
        //People people1 = DataManager.deserialize("test.xml");
        //System.out.println("name " +people1.getName()+" ; age "+ people1.getAge() +"; salary "+ people1.getSalary());
    }
}
