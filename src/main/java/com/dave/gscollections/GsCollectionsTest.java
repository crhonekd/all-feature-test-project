package com.dave.gscollections;

import com.dave.model.Person;
import com.dave.utils.ListFactory;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.list.mutable.SynchronizedMutableList;

import java.util.List;

/**
 * Created by David on 07/03/2017.
 */
public class GsCollectionsTest {
    public static void main(String[] args) {

        final List<Person> persons = ListFactory.getListOfPersons();

        MutableList<Person> l = new FastList<Person>();
        l.addAll(persons);

        MutableList<Person> inPrague = l.select(c -> c.getAddress().getCity().equals("Prague"));


        System.out.println();
    }
}

