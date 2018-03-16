package com.globant.google.nest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamApp {

    public static void main(String[] args){
        StreamApp app = new StreamApp();

        app.collectionToUppercase();
        System.out.println("---------------------------------");
        app.filterCollection();
        System.out.println("---------------------------------");
        app.flattenMultidimensional();
        System.out.println("---------------------------------");
        app.getOldestPerson();
        System.out.println("---------------------------------");
        app.getAllUnderAge();
        System.out.println("---------------------------------");
        app.getPeopleStatistics();
        System.out.println("---------------------------------");
        app.partitionPersons();
        System.out.println("---------------------------------");
        app.groupNationality();
        System.out.println("---------------------------------");
        app.namesSeparated();
        System.out.println("---------------------------------");
        app.sumElements();
        System.out.println("---------------------------------");        
        app.concatenatingUppercase();
        System.out.println("---------------------------------");        
        app.concatenatingUppercaseMap();
        System.out.println("---------------------------------");        
        app.wordsConcatenatedTogether();
        System.out.println("---------------------------------");        
        app.totalNumberCharacters();
        System.out.println("---------------------------------");        
        app.wordsContainLetter();
    }

    /**
     * Convert elements of a collection to upper case.
     */
    public void collectionToUppercase(){
        List<String> list = Arrays.asList("uno", "dos", "tres", "cuatro");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * Filter collection so that only elements with less than 4 characters are returned.
     */
    public void filterCollection(){
        List<String> list = Arrays.asList("hola", "chau", "marzo", "saraza");
        list.stream().filter(s -> s.length()<=4).forEach(System.out::println);
    }

    /**
     * Flatten multidimensional collection (Example, a list of lists)
     */
    public void flattenMultidimensional(){
        List<List<String>> lists = Arrays.asList(Arrays.asList("A", "B", "C", "D"),
                                                 Arrays.asList("a", "b", "c", "d"));
        lists.stream().flatMap(List::stream).forEach(System.out::println);
    }

    /**
     * Get oldest person from the collection
     */
    public void getOldestPerson(){
        List<Person> list = buildListPersons();
        Optional<Person> opPerson = list.stream().collect(maxBy(comparingInt(Person::getAge)));
        Person oldest = opPerson.get();
        System.out.println(oldest.getName() +" "+ oldest.getAge());
    }

    /**
     * Get names of all under age of 18
     */
    public void getAllUnderAge(){
        List<Person> list = buildListPersons();
        list.stream().filter(p -> p.getAge()<=18).map(Person::getName).forEach(System.out::println);
    }

    /**
     * Get people statistics: average age, count, maximum age, minimum age and sum of all ages.
     */
    public void getPeopleStatistics(){
        List<Person> list = buildListPersons();

        Optional<Person> opPersonMax = list.stream().collect(maxBy(comparingInt(Person::getAge)));
        int maximumAge = opPersonMax.get().getAge();

        Optional<Person> opPersonMin = list.stream().collect(minBy(comparingInt(Person::getAge)));
        int minimumAge = opPersonMin.get().getAge();

        long count = list.stream().count();
        int sumAges = list.stream().collect(summingInt(Person::getAge));
        double averageAge = list.stream().collect(averagingInt(Person::getAge));
    
        System.out.println("averageAge:"+ averageAge);
        System.out.println("count:"+ count);
        System.out.println("maximumAge:"+ maximumAge);
        System.out.println("minimumAge:"+ minimumAge);
        System.out.println("sumAges:"+ sumAges);
    }

    /**
     * Partition adults and kids
     */
    public void partitionPersons(){
        List<Person> list = buildListPersons();
        Map<Boolean, List<Person>> groups = list.stream().collect(partitioningBy(p -> p.getAge()<18));

        List<Person> menores = groups.get(true);
        List<Person> mayores = groups.get(false);

        print("Personas menores", menores);
        print("Personas mayores", mayores);
    }

    /**
     * Group people by nationality: Person(name, age, nationality)
     */
    public void groupNationality(){
        List<Person> list = buildListPersons();
        Map<Person.Nationality, List<Person>> groups = list.stream().collect(groupingBy(Person::getNationality));
        
        for (Map.Entry<Person.Nationality, List<Person>> sublist : groups.entrySet()){
            print(sublist.getKey().getName(), sublist.getValue());
        }
    }

    /**
     * Return people names separated by comma
     */
    public void namesSeparated(){
        List<Person> list = buildListPersons();
        String names = list.stream().map(Person::getName).collect(joining(","));
        System.out.println("Names:"+ names);
    }

    /**
     * Sum all elements of a collection
     */
    public void sumElements(){
        List<Integer> list = Arrays.asList(10, 20, 30, 40);        
        int sum = list.stream().collect(summingInt(i -> i.intValue()));
        System.out.println("Suma valores:"+ sum);
    }

    /**
     * Produce a single String that is the result of concatenating the uppercase versions of all of the Strings.
     * E.g., the result should be "HIHELLO...".
     * Use a single reduce operation, without using map. 
     */
    public void concatenatingUppercase(){
        List<String> words = buildListWords();
        Optional<String> concatOpt = words.stream().collect(reducing((s1, s2) -> s1.toUpperCase() + s2.toUpperCase()));
        System.out.println("concatenatingUppercase: "+ concatOpt.get());
    }

    /**
     * Produce the same String as above, but this time via a map operation that turns the words into upper case,
     * followed by a reduce operation that concatenates them.
     */
    public void concatenatingUppercaseMap(){
        List<String> words = buildListWords();
        String concat = words.stream().map(String::toUpperCase).collect(joining());
        System.out.println("concatenatingUppercaseMap: "+ concat);
    }

    /**
     * Produce a String that is all the words concatenated together,
     * but with commas in between. E.g., the result should be "hi,hello,...".
     * Note that there is no comma at the beginning,
     * before "hi", and also no comma at the end, after the last word.
     * Major hint: there are two versions of reduce discussed in the notes.
     */
    public void wordsConcatenatedTogether(){
        List<String> words = buildListWords();
        String concat = words.stream().map(String::toString).collect(joining(","));
        System.out.println("wordsConcatenatedTogether: "+ concat);
    }

    /**
     * Find the total number of characters (i.e., sum of the lengths) of the strings in the List. 
     */
    public void totalNumberCharacters(){
        List<String> words = buildListWords();
        int sum = words.stream().map(String::length).collect(summingInt(i -> i.intValue()));
        System.out.println("totalNumberCharacters: "+ sum);
    }

    /**
     * Find the number of words that contain an "h"
     */
    public void wordsContainLetter(){
        List<String> words = buildListWords();
        long count = words.stream().filter(s->s.contains("h")).count();
        System.out.println("wordsContainLetter: "+ count);
    }

    private List<Person> buildListPersons(){
        List<Person> list = Arrays.asList(
                            Person.getInstance(16, "Cesar", Person.Nationality.MEXICO),
                            Person.getInstance(23, "Maru", Person.Nationality.BRAZIL),
                            Person.getInstance(33, "Julio", Person.Nationality.EU),
                            Person.getInstance(27, "Adriana", Person.Nationality.MEXICO),
                            Person.getInstance(18, "Juan", Person.Nationality.BRAZIL),
                            Person.getInstance(41, "Walter", Person.Nationality.EU));
        return list;
    }

    private List<String> buildListWords(){
        List<String> words = Arrays.asList("hi", "hello");
        return words;
    }

    private void print(String title, List<Person> list){
        System.out.println(title);
        list.stream().forEach(System.out::println);
    }

    static class Person {
        int age;
        String name;
        Nationality nationality;
        
        public Person(int age, String name, Nationality nationality){
            this.age = age;
            this.name = name;
            this.nationality = nationality;
        }
        
        public static Person getInstance(int age, String name, Nationality nationality){
            return new Person(age, name, nationality);
        }
        
        public int getAge(){
            return this.age;
        }
        
        public String getName(){
            return this.name;
        }
        
        public Nationality getNationality(){
            return this.nationality;
        }
        
        @Override
        public String toString(){
            return this.name +" "+ this.age;
        }

        static enum Nationality {
            MEXICO("MEXICO"), BRAZIL("BRAZIL"), EU("EU");
            
            String name;
            
            private Nationality(String name){
                this.name = name;
            }
            
            public String getName(){
                return this.name;
            }
        }

    }

}
