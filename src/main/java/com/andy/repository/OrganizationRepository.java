package com.andy.repository;

import com.andy.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
public interface OrganizationRepository extends JpaRepository<Organization,String> {
}
