package com.Deeksha.ActionTraker.ActionTracker.Controller;

import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import com.Deeksha.ActionTraker.ActionTracker.Repository.ActionTrackerRepository;
import com.Deeksha.ActionTraker.ActionTracker.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ActionTrackerRepository actionTrackerRepository;

    @RequestMapping("/")
    public void print(){
        System.out.println("print the data");
    }

    @GetMapping("/getAllData")
    public List<Student> getAllStudentData(){
        return studentService.getAllData();
    }

    @GetMapping("/getDataById/{id}")
    public Optional<Student> getDataById(@PathVariable("id") Integer id){
        return studentService.getDataById(id);
    }

    @PostMapping("/postData")
    public String postTheStudent(@RequestBody Student student){
        studentService.saveStudentData(student);
        return "Data Saved Successfully!";
    }

    @DeleteMapping("/deleteData/{id}")
    public String deleteStudentData(@PathVariable("id") Integer id){
        studentService.deleteStudentData(id);
        return "data Deleted Successfully!";
    }

    @PutMapping("/updateData/{id}")
    public String updateStudentData(@RequestBody Student student ,@PathVariable("id") Integer id ){
        studentService.updateStudentData(student ,id);
        return "Data Updated Successfully!";
    }
}
