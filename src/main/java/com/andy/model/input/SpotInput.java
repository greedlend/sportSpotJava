package com.andy.model.input;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class SpotInput {

    private UUID uuid;

    private Integer playersNumber;

    private String address;

    private String openTime;

    private String closeTime;

    private Boolean isOpen;

    private Boolean isDel;
}
