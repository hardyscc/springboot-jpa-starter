package com.example.sjs.repository;

import com.example.sjs.entity.TestVer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestVerRepository extends JpaRepository<TestVer, UUID> {
}
