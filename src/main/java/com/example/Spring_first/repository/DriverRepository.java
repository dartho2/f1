package com.example.Spring_first.repository;

import com.example.Spring_first.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query(value = "SELECT d.firstname, t.name , COUNT(*) From Driver d \n" +
            "join  CHAMPIONSHIPS_TEAM_DRIVER c on c.DRIVER_ID = d.id \n" +
            "join  Team t on c.TEAM_ID  = t.id \n" +
            "where t.name = ?1 and d.firstname = ?2 GROUP BY FIRSTNAME\n", nativeQuery = true)
    Object findAllByStringName(String teamName, String driverName);

}
