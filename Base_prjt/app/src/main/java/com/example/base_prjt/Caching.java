package com.example.base_prjt;

import android.app.Person;

import java.net.InetAddress;
import java.util.Random;

public class Caching {
    private class PersonObject {
        String second_name;
        int id;
        int incomes;
        String vehicles;
        String savings;
        String real_estates;

        public PersonObject(String name) {
            this.second_name = name;
            this.id = Utils.get_id(name);
            this.incomes = Utils.get_incomes(name);
            this.vehicles = Utils.get_vehicles(name);
            this.savings = Utils.get_savings(name);
            this.real_estates = Utils.get_real_estates(name);
        }
    }

    private String get_random_name() {
        String str = null;

        return str;
    }

    private PersonObject[] objs = new PersonObject[20];

    public PersonObject get_random_object() {
        return objs[new Random().nextInt(20)];
    }

    private boolean is_internet_available() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");
        } catch (Exception e) {
            return false;
        }
    }

    public void update_object(int id, String name) {
        if (is_internet_available()) {
            Utils.update_rankings(id, name);
        }
    }
}
