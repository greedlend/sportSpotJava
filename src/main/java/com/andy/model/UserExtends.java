package com.andy.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Entity
@Data
public class UserExtends {

    @Id
//    @Column(name = "uuid", nullable = false)
    private UUID uuid;

//    @Column(name = "address")
    private String address;

//    @Column(name = "title")
    private String title;
}
