package com.umberapp.umber.tokenautocomplete;

import java.io.Serializable;

public class Person implements Serializable {
    private String email;
    private String name;

    public Person(String n, String e) {
        this.name = n;
        this.email = e;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return this.name;
    }
}
