package com.example.lab.repository;

import com.example.lab.domain.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, UUID>, JpaSpecificationExecutor<BorrowedBook> {
}
