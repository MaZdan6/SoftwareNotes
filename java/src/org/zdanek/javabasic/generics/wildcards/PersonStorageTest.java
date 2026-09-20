package org.zdanek.javabasic.generics.wildcards;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class PersonStorageTest
{
    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    
    public void cannotLoadFromEmptyFile() throws Exception
    {
        PersonLoader loader = new PersonLoader(file);

        //assertNull(loader.load());
    }

    
    public void savesAndLoadsPerson() throws Exception
    {
        PersonSaver saver = new PersonSaver(file);
        PersonLoader loader = new PersonLoader(file);

        saver.save(donDraper);

        //assertEquals(donDraper, loader.load());
    }

    
    public void savesAndLoadsTwoPeople() throws Exception
    {
        saver.save(donDraper);
        saver.save(peggyOlson);

        //assertEquals(donDraper, loader.load());
        //assertEquals(peggyOlson, loader.load());
    }

    
    public void savesArraysOfPeople() throws Exception
    {
        /*Employee[] employees = new Employee[2];
        Person[] people = employees;*/
        Partner[] people = new Partner[2];
        people[0] = donDraper;
        people[1] = bertCooper;

        saver.saveAll(people);

        //assertEquals(donDraper, loader.load());
        //assertEquals(bertCooper, loader.load());
    }

    
    public void savesListsOfPeople() throws Exception
    {
        List<Partner> people = new ArrayList<>();
        people.add(donDraper);
        people.add(bertCooper);

        saver.saveAll(people);

        //assertEquals(donDraper, loader.load());
        //assertEquals(bertCooper, loader.load());
    }

    
    public void loadsListsOfPeople() throws Exception
    {
        saver.save(donDraper);
        saver.save(bertCooper);

        List<Object> people = new ArrayList<>();
        loader.loadAll(people);


        //assertEquals(asList(donDraper, bertCooper), people);
    }

    
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }
}
