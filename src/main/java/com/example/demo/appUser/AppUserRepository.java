package com.example.demo.appUser;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@Repository
public interface AppUserRepository {
    
    Optional<AppUser> findByEmail(String email);

}
