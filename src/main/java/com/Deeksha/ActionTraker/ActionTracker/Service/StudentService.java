package com.Deeksha.ActionTraker.ActionTracker.Service;

import com.Deeksha.ActionTraker.ActionTracker.Entity.ActionTracker;
import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import com.Deeksha.ActionTraker.ActionTracker.Repository.ActionTrackerRepository;
import com.Deeksha.ActionTraker.ActionTracker.Repository.StudentRepository;
import com.Deeksha.ActionTraker.ActionTracker.Repository.UpdationCheckerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private UpdationCheckerRepository updationCheckerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ActionTrackerRepository actionTrackerRepository;

    public ActionTracker addActionTracker(int student_id , String methodName){
        ActionTracker actionTracker = new ActionTracker();
        actionTracker.setStudentId(student_id);
        actionTracker.setMethodName(methodName);
        ActionTracker tracker = actionTrackerRepository.save(actionTracker);
        return tracker;
    }

    public List<Student> getAllData() {
        List<Student> students = studentRepository.studentData(1000 ,0);
        for(Student it: students){
            Student student1 = it;
            String methodName = "Get";
            addActionTracker(student1.getId() , methodName);
        }
        return students;
    }

    public void saveStudentData(Student student) {
        String methodName = "post";
        Student student1 = studentRepository.save(student);
        addActionTracker(student1.getId() , methodName);
    }

    public void deleteStudentData(Integer id) {
        try{
            Student studentData = studentRepository.findById(id).orElseThrow();
            String methodName = "Delete";
            addActionTracker(id, methodName);
            studentRepository.deleteById(id);

        }catch (Exception e){
            System.out.println("Student not found");
        }
    }

    public void updateStudentData(Student student ,Integer id ) {

        try {
            Student s = studentRepository.findById(id).orElseThrow();
            String methodName = "update";
            ActionTracker actionTracker = addActionTracker(id, methodName);

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(student);
            Student studentData = mapper.readValue(jsonString, Student.class);
            studentData.setId(id);
            studentRepository.save(studentData);

        } catch (Exception e) {
            System.out.println("Student not found in database " + e);
        }
    }

    public Student getDataById(Integer id) {
        try {
            Student student = studentRepository.findById(id).orElseThrow();
            String methodName = "Get";
            addActionTracker(id, methodName);
            return student;
        }catch (Exception e) {
            System.out.println("Student not found");
            return null;
        }
    }
}
