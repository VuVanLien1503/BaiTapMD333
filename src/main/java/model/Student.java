package model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date birth;
    private String address;
    private String phone;
    private String email;
    private int classroom_id;
    private boolean status;


    public Student() {
        this.status =true;
    }

    public Student(int id, String name, Date birth, String address, String phone, String email, int classroom_id) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_id = classroom_id;
        this.status =true;
    }

    public Student(String name, Date birth, String address, String phone, String email, int classroom_id) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_id = classroom_id;
        this.status =true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
