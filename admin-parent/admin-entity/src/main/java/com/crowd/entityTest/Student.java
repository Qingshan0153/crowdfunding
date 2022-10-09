package com.crowd.entityTest;

import java.util.List;
import java.util.Map;

/**
 * @author Mendax
 * @date 2022-10-09 19:56
 **/
public class Student {
    private Integer stuId;
    private String stuName;
    private Address address;
    private List<Subject> subjects;
    private Map<String, Object> map;

    public Student() {
    }

    public Student(Integer stuId, String stuName, Address address, List<Subject> subjects, Map<String, Object> map) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.address = address;
        this.subjects = subjects;
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", address=" + address +
                ", subjects=" + subjects +
                ", map=" + map +
                '}';
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
