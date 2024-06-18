package com.maggwritey.filereadwrite.DAO;




import org.springframework.data.jpa.repository.JpaRepository;

import com.maggwritey.filereadwrite.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

