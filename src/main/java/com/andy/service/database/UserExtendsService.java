package com.andy.service.database;

import com.andy.model.UserBase;
import com.andy.model.UserExtends;
import com.andy.repository.UserExtendsRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Service
public class UserExtendsService {

    @Autowired
    private UserExtendsRepository userExtendsRepository;

    @Transactional(readOnly = true)
    public UserExtends getUserExtends(UserBase userBase) {
        Optional<UserExtends> result =
                null == userBase.getUserExtendsRelate() ? Optional.ofNullable(null):this.userExtendsRepository.findById(userBase.getUserExtendsRelate());
        if(!result.isPresent()) {return null;}
        return result.get();
    }
}
