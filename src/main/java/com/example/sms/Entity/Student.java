package com.example.sms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "StudentMngtSystem")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String Email;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String Email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = Email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
