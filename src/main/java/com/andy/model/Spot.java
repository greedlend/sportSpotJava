package com.andy.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Spot {

    @Id
    private UUID uuid;

    private Integer playersNumber;

    private String address;

    private String openTime;

//    @Column(name = "closeTime")
    private String closeTime;

    private Boolean isOpen;

    private Boolean isDel;

}
