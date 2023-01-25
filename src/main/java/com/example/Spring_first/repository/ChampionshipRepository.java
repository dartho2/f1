package com.example.Spring_first.repository;

import com.example.Spring_first.model.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long> {
    List<Championship> findAllByTeamIdIs(long id);

    List<Championship> findAllByDriversIdIs(long id);
    List<Championship> findAllByDriversIdAndTeamIdIs(long id,long ids);

}
