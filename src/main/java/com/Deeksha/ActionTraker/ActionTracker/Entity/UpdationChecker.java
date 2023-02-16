package com.Deeksha.ActionTraker.ActionTracker.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "Update_checker")
public class UpdationChecker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private int ActionTrackerId;

    private String previous_data;
    private String updated_data;
}
