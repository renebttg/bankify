package com.example.bankify.repository;

import com.example.bankify.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AudiLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByUser(String user);

    List<AuditLog> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<AuditLog> findByActionContainingIgnoreCase(String action);

    List<AuditLog> findBySourceIp(String sourceIp);
}
