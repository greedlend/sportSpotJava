package com.andy.repository;

import com.andy.model.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/29
 * @Proposal:
 */
@Repository
public interface UserBaseRepository extends JpaRepository<UserBase, String>, JpaSpecificationExecutor {
}
