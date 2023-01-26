package com.example.Spring_first.repository;


import com.example.Spring_first.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query(value = "SELECT  t.name, c1.name, COUNT(*)  From Driver d \n" +
            "join  CHAMPIONSHIPS_TEAM_DRIVER c on c.DRIVER_ID = d.id \n" +
            "join  Team t on c.TEAM_ID  = t.id \n" +
            "join  Country c1 on d.country_id  = c1.id \n" +
            "where t.name = ?1 \n" +
            "GROUP BY c1.name", nativeQuery = true)
    List<Object> findAllTeamCountryByStringName(String teamName);
}
