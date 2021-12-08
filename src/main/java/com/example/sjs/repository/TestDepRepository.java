package com.example.sjs.repository;

import com.example.sjs.entity.TestDep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDepRepository extends JpaRepository<TestDep, Long> {
}
