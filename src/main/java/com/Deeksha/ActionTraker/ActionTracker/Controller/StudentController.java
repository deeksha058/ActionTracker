package com.Deeksha.ActionTraker.ActionTracker.Controller;

import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import com.Deeksha.ActionTraker.ActionTracker.Repository.ActionTrackerRepository;
import com.Deeksha.ActionTraker.ActionTracker.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ActionTrackerRepository actionTrackerRepository;

    @RequestMapping("/")
    public void print(){
        System.out.println("print the data");
    }

    @GetMapping("/g")
    public List<Student> getAllStudentData(){
        return studentService.getAllData();
    }

    @GetMapping("/g/{id}")
    public Optional<Student> getDataById(@PathVariable("id") Integer id){
        return studentService.getDataById(id);
    }

    @PostMapping("/p")
    public String postTheStudent(@RequestBody Student student){
        studentService.saveStudentData(student);
        return "Data Saved Successfully!";
    }

    @DeleteMapping("/d/{id}")
    public String deleteStudentData(@PathVariable("id") Integer id){
        studentService.deleteStudentData(id);
        return "data Deleted Successfully!";
    }

    @PutMapping("/u/{id}")
    public String updateStudentData(@RequestBody Student student ,@PathVariable("id") Integer id ){
        studentService.updateStudentData(student ,id);
        return "Data Updated Successfully!";
    }
}
