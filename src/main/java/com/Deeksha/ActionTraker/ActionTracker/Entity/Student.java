package com.Deeksha.ActionTraker.ActionTracker.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Main_Stu_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String fName;
    private String mName;
    private String email;

    private String CreateAt;
    private String UpdatedAt;
}
