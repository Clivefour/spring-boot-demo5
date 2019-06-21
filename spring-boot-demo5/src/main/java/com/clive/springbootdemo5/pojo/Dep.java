package com.clive.springbootdemo5.pojo;

import java.io.Serializable;
import java.util.List;

public class Dep implements Serializable{
    private int id;
    private String name;
    private List<Emp> emps;

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

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
