package com.example.final_module3.Model;

public class Student {
    private Integer idStudent;
    private String nameStudent;
    private String className;
    public Student(Integer idStudentStudent, String nameStudent, String className) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.className = className;
    }
    public Integer getId() {
        return idStudent;
    }
    public void setId(Integer idStudent) {
        this.idStudent = idStudent;
    }
    public String getName() {
        return nameStudent;
    }
    public void setName(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
