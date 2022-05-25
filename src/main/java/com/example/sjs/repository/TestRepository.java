package com.example.sjs.repository;

import com.example.sjs.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, String> {
}
