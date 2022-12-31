package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addTeacherStudentPair(String teacher, String student){
        studentRepository.addTeacherStudentPair(teacher,student);
    }

    public Student getStudent(String studentName){
        return studentRepository.getStudent(studentName);
    }

    public Teacher getTeacher(String teacherName){
        return studentRepository.getTeacher(teacherName);
    }

    public List<String> getStudentFromTeacher(String teacher){
        return studentRepository.getStudentFromTeacher(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
