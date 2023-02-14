package model;

public class Classroom {
    private int id;
    private String name;
    private boolean status;

    public Classroom() {
        this.status=true;
    }

    public Classroom(int id, String name) {
        this.id = id;
        this.name = name;
        this.status=true;

    }

    public Classroom(String name) {
        this.name = name;
        this.status=true;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
