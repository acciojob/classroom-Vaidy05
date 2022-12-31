package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class StudentRepository {

    private HashMap<String,Student> studentHashMap;

    private HashMap<String,Teacher> teacherHashMap;

    private HashMap<String,List<String>> teacherStudentMapping;

    public StudentRepository() {
        this.studentHashMap = new HashMap<>();
        this.teacherHashMap = new HashMap<>();
        this.teacherStudentMapping = new HashMap<>();
    }

    public void addStudent(Student student){
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addTeacherStudentPair(String teacher, String student){

        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){

            List<String> numberOfStudents = new ArrayList<>();

            if(teacherStudentMapping.containsKey(teacher)){
                numberOfStudents = teacherStudentMapping.get(teacher);
            }

            numberOfStudents.add(student);

            teacherStudentMapping.put(teacher,numberOfStudents);
        }
    }

    public Student getStudent(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher getTeacher(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> getStudentFromTeacher(String teacher){

        List<String> studentList = new ArrayList<>();

        if(teacherStudentMapping.containsKey(teacher))
            studentList = teacherStudentMapping.get(teacher);

        return studentList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentHashMap.keySet());
    }

    public void deleteTeacherByName(String teacher){

        List<String> studentList = new ArrayList<>();

        if(teacherStudentMapping.containsKey(teacher)){

            studentList = teacherStudentMapping.get(teacher);

            for(String student : studentList){

                if(studentHashMap.containsKey(student))
                    studentHashMap.remove(student);
            }

            teacherStudentMapping.remove(teacher);
        }

        if(teacherHashMap.containsKey(teacher))
            teacherHashMap.remove(teacher);
    }

    public void deleteAllTeachers(){

        teacherHashMap = new HashMap<>();

        HashSet<String> studentSet = new HashSet<>();

        for(String teacher : teacherStudentMapping.keySet()){

            for(String student : teacherStudentMapping.get(teacher)){
                studentSet.add(student);
            }
        }

        for(String student : studentSet){

            if(studentHashMap.containsKey(student))
                studentHashMap.remove(student);
        }

        teacherStudentMapping = new HashMap<>();
    }
}
