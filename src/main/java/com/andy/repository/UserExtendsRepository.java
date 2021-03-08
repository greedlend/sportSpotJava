package com.andy.repository;

import com.andy.model.UserExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Repository
public interface UserExtendsRepository extends JpaRepository<UserExtends, UUID> {
}
