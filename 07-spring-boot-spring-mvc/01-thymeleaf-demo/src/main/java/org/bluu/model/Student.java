package org.bluu.model;

import java.util.List;

public class Student {
    public enum Lang {
        JAVA, PYTHON, C, CSHARP, GO, V
    }

    private String firstName;
    private String lastName;
    private String country;
    private Lang prefLang;
    private List<String> prefSystems;

    public List<String> getPrefSystems() {
        return prefSystems;
    }

    public void setPrefSystems(List<String> prefSystems) {
        this.prefSystems = prefSystems;
    }

    public Student() {
    }

    public Lang getPrefLang() {
        return prefLang;
    }

    public void setPrefLang(Lang prefLang) {
        this.prefLang = prefLang;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
