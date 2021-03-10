package com.andy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Spot {

    @Id
    private UUID uuid;

    private Integer noPlayer;

    private String address;

    private Date openTime;

    private Date closeTime;

    private Boolean isOpen;

    private Boolean isDel;
}
