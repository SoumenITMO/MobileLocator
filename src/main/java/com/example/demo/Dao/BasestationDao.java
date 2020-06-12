package com.example.demo.Dao;

import com.example.demo.Entity.BasestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BasestationDao extends JpaRepository<BasestationEntity, Long> {

    List<BasestationEntity> getAllBy();
}
