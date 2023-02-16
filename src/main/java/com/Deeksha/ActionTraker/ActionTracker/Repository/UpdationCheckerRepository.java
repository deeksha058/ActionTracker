package com.Deeksha.ActionTraker.ActionTracker.Repository;

import com.Deeksha.ActionTraker.ActionTracker.Entity.UpdationChecker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdationCheckerRepository extends JpaRepository<UpdationChecker, Integer> {
}
