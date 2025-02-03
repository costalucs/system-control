package com.acadpendragon.system.repositories;


import com.acadpendragon.system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.pagamento = false")
    List<User> findByPaymentFalse();
}