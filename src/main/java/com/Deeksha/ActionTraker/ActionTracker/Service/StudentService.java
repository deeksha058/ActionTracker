package com.Deeksha.ActionTraker.ActionTracker.Service;

import com.Deeksha.ActionTraker.ActionTracker.Entity.ActionTracker;
import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import com.Deeksha.ActionTraker.ActionTracker.Repository.ActionTrackerRepository;
import com.Deeksha.ActionTraker.ActionTracker.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ActionTrackerRepository actionTrackerRepository;

    public List<Student> getAllData() {
        List<Student> students = studentRepository.findAll();
        for(Student it: students){
            Student student1 = it;
            ActionTracker actionTracker = new ActionTracker();
            actionTracker.setStudentId(student1.getId());
            actionTracker.setMethodName("Get");
            actionTrackerRepository.save(actionTracker);
        }
        return students;
    }

    public void saveStudentData(Student student) {
        ActionTracker actionTracker = new ActionTracker();
        Student student1 = studentRepository.save(student);
        actionTracker.setStudentId(student1.getId());
        actionTracker.setMethodName("Post");
        actionTrackerRepository.save(actionTracker);

    }

    public void deleteStudentData(Integer id) {
        ActionTracker actionTracker = new ActionTracker();
        actionTracker.setStudentId(id);
        actionTracker.setMethodName("Delete");
        actionTrackerRepository.save(actionTracker);
        studentRepository.deleteById(id);
    }

    public void updateStudentData( Student student ,Integer id ) {
        Student studentData = studentRepository.findById(id).get();
        ActionTracker actionTracker = new ActionTracker();
        actionTracker.setStudentId(id);
        actionTracker.setMethodName("update");
        actionTrackerRepository.save(actionTracker);
        studentData.setName(student.getName());
        studentData.setFName(student.getFName());
        studentData.setMName(student.getMName());
        studentData.setEmail(student.getEmail());
        studentRepository.save(studentData);

    }

    public Optional<Student> getDataById(Integer id) {
        ActionTracker actionTracker = new ActionTracker();
        actionTracker.setStudentId(id);
        actionTracker.setMethodName("Get");
        actionTrackerRepository.save(actionTracker);
        return studentRepository.findById(id);
    }
}
