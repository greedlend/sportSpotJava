package com.andy.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/28
 * @Proposal:
 */

// 在MemberAccount宣告了一個@Component註解,只是要讓此類可被Controller注入
//    @Component
//    @Service
//    @Repository
//    @RestController
//    @Controller
//    這五個註解會在Spring Boot Starter一啟動後就做掃描,傳統的我們Spring會藉由xml的定義將類別定義成一個Bean
//    Spring Boot就是要解決太多繁雜的xml設定

@Component
@Entity
@Getter
@Setter
//@Builder
public class UserBase implements Serializable {

    @Id
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_time", nullable = false)
    private ZonedDateTime createTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upper", referencedColumnName = "uuid")
    private UserBase upper;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_extends_relate", referencedColumnName = "uuid")
    @Column(name = "user_extends_relate")
    private String userExtendsRelate;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "org_relate", referencedColumnName = "uuid")
    @Column(name = "org_relate")
    private String orgRelate;

    /**
     * 另外賦予前端的資料
     * */
    @Transient
    private BigDecimal balance;
}
