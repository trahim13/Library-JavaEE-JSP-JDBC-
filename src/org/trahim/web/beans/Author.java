package org.trahim.web.beans;

/**
 * Created by root on 19.08.2017.
 */
public class Author {

    public Author() {
    }

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
