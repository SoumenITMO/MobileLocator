package com.example.demo.Dao;

import com.example.demo.Entity.MobilestationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilestationDao extends JpaRepository<MobilestationEntity, Long> {

    MobilestationEntity getFirstById(Integer uuid);
}
