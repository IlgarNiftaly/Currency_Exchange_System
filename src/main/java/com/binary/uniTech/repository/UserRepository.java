package com.binary.uniTech.repository;

import com.binary.uniTech.entity.User;
import com.binary.uniTech.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
            select new com.binary.uniTech.wrapper.UserWrapper(u.id, u.userName, u.email, u.password, u.emailVerified, u.fkAccountId) from User u
            """)

    List<UserWrapper> findAllUserWrapper();

    User findByEmail(String email);
}
