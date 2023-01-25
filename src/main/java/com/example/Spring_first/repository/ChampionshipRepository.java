package com.example.Spring_first.repository;

import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long> {
    List<Championship> findAllByDriverIdIn(List<Long> ids);

    List<Championship> findByYearsIs(long year);
}
