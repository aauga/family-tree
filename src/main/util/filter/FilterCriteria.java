package main.util.filter;

import main.data.Person;

import java.util.ArrayList;

public interface FilterCriteria {
    public ArrayList<Person> filterList(ArrayList<Person> list, String criteria);
}
