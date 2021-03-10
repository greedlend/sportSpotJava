package com.andy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Spot implements Serializable {

    @Id
    private UUID uuid;

    private Integer noPlayers;

    private String address;

    private Date openTime;

    private Date closeTime;

    private Boolean isOpen;

    private Boolean isDel;
}
