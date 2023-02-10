package com.Deeksha.ActionTraker.ActionTracker.Service;

import com.Deeksha.ActionTraker.ActionTracker.Entity.ActionTracker;
import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import com.Deeksha.ActionTraker.ActionTracker.Repository.ActionTrackerRepository;
import com.Deeksha.ActionTraker.ActionTracker.Repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ActionTrackerRepository actionTrackerRepository;

    public void addActionTracker(int student_id , String methodName){
        ActionTracker actionTracker = new ActionTracker();
        actionTracker.setStudentId(student_id);
        actionTracker.setMethodName(methodName);
        actionTrackerRepository.save(actionTracker);
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
        Student studentData = studentRepository.findById(id).orElse(null);
        if (studentData != null) {
            String methodName = "Delete";
            addActionTracker(id, methodName);
            studentRepository.deleteById(id);
        }
    }

    public void updateStudentData(Student student ,Integer id ) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(student);
        Student studentData = mapper.readValue(jsonString , Student.class);
        studentData.setId(id);
        studentRepository.save(studentData);

    }

    public Optional<Student> getDataById(Integer id) {
        String methodName = "Get";
        addActionTracker(id, methodName);
        return studentRepository.findById(id);
    }
}
