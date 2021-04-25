package com.example.demo.registration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>{

    Optional<ConfirmationToken> findByToken(String token);
    
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken ct SET ct.confirmedAt = ?1 WHERE ct.token = ?2") 
    int updateConfirmedAt(LocalDateTime confiemedAt, String token);
}
