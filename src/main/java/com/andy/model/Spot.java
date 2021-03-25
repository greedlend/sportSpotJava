package com.andy.model;

import com.andy.config.postgreSQL.PgPointType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.postgresql.geometric.PGpoint;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@TypeDef(name = "pointType", typeClass = PgPointType.class)
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

    @Type(type = "pointType")
    private PGpoint geometry;
//    Latitude = x and longitude = y

}
