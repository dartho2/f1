package com.example.Spring_first.repository;

import com.example.Spring_first.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findByIdAndTeamIdIs(long driverId, long teamId);
}
