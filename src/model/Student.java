package model;

public class Student {
    private int id;
    private String rollNo;
    private String name;
    private int age;
    private String email;

    public Student() {}

    public Student(String rollNo, String name, int age, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Student(int id, String rollNo, String name, int age, String email) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Roll No: " + rollNo +
                " | Name: " + name +
                " | Age: " + age +
                " | Email: " + email;
    }
}
