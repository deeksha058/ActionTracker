package com.Deeksha.ActionTraker.ActionTracker.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SlaveTable")
public class ActionTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int StudentId;
    private String MethodName;

}
