package com.yena.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yena.springboot.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
