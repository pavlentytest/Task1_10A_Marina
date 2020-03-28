package com.company;

import java.util.*;

class School {
    private String name;
    private int number;
    School(String n,int k) {
        this.name = n;
        this.number = k;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
public class Main {

    public static void main(String[] args) {

        /*TreeSet<Integer> ch = new TreeSet<>();
        ch.add(111);
        ch.add(345345);
        ch.add(3);
        ch.add(-9);
        ch.add(3);

        for(Integer s: ch) {
            System.out.println(s);
        }*/




        Scanner scanner = new Scanner(System.in);
        Set<School> hashSet = new HashSet<>();
        Set<School> treeSet = new TreeSet<>(new Comparator<School>() {
            @Override
            public int compare(School t1, School t2) {
                //return t1.getName().compareTo(t2.getName());
                 return t2.getNumber() - t1.getNumber();
            }
        });
        while (true) {
            String full_stroka = scanner.nextLine();
            if (!full_stroka.isEmpty()) {
                String[] schools = full_stroka.split(" ");
                String school_name = schools[0];
                int school_number = Integer.parseInt(schools[1]);
                if (school_number % 2 == 0) {
                    hashSet.add(new School(school_name,school_number));
                } else {
                    treeSet.add(new School(school_name,school_number));
                }
            } else {
                break;
            }
        }

        Iterator<School> rule = treeSet.iterator();
        while(rule.hasNext()) {
            if(rule.next().getName().length() > 5) {
                rule.remove();
            }
          //  System.out.println(rule.next());
        }



        for(School s: treeSet) {
            System.out.println(s.getNumber() + "=>" + s.getName());
        }
/*
        for(School s2: hashSet) {
         //   if(s2.getName().length() > 5) {
         //       hashSet.remove(s2);
          //  }
        }
        for(School s2: hashSet) {
            System.out.println(s2.getNumber() + "=>" + s2.getName());
        }*/
    }
}
