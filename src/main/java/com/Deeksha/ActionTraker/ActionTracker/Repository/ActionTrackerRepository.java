package com.Deeksha.ActionTraker.ActionTracker.Repository;

import com.Deeksha.ActionTraker.ActionTracker.Entity.ActionTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ActionTrackerRepository extends JpaRepository<ActionTracker ,Integer> {

}
