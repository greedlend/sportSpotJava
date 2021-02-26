package com.andy.service.database;

import com.andy.model.Organization;
import com.andy.model.UserBase;
import com.andy.repository.OrganizationRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional(readOnly = true)
    public Organization getOrganization(UserBase userBase) {
        Optional<Organization> result =
                Strings.isBlank(userBase.getOrgRelate())? Optional.ofNullable(null):this.organizationRepository.findById(userBase.getOrgRelate());
        if(!result.isPresent()) {return null;}
        return result.get();
    }

    @Transactional(readOnly = true)
    public Organization getOrganization(String uuid) {
        return this.organizationRepository.findById(uuid).get();
    }

    @Transactional(readOnly = true)
    public List<Organization> findList() {
        return this.organizationRepository.findAll();
    }
}
