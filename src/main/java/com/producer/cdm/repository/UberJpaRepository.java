package com.producer.cdm.repository;

import com.producer.cdm.model.UberData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UberJpaRepository extends JpaRepository<UberData,Long> {


}
