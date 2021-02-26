package com.andy.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/11
 * @Proposal:
 */
@Entity
@Data
public class Organization {

    @Id
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upper", referencedColumnName = "uuid")
    private Organization upper;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner", referencedColumnName = "uuid")
    private UserBase owner;
}
