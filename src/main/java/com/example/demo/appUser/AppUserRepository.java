package com.example.demo.appUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser set enabled = true Where email = ?1")
    int setEnableUser(String email);

}
