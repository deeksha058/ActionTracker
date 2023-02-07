package com.Deeksha.ActionTraker.ActionTracker.Repository;

import com.Deeksha.ActionTraker.ActionTracker.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Integer> {

    @Query(value = "SELECT * FROM main_stu_table limit :limit_value offset :offset_value" ,nativeQuery = true)
    public List<Student> studentData(Integer limit_value , Integer offset_value);


}
