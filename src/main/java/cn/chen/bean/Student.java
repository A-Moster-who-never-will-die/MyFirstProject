package cn.chen.bean;

public class Student {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Student(String name,int id) {
        this.name = name;
        this.id=id;
    }
}
