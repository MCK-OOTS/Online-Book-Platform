package com.react.practice.repository;

import com.react.practice.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity, String> {

}
