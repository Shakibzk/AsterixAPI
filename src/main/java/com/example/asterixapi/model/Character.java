package com.example.asterixapi.model;

public class Character {
    private String id;
    private String name;
    private int age;
    private String profession;

    public Character(String id, String name, int age, String profession) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    // Getter ها و Setter ها

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getProfession() { return profession; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setProfession(String profession) { this.profession = profession; }
}
