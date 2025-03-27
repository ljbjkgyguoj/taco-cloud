package org.example.taco.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Taco {

    private Long id;

    private String name;

    private Long tacoOrderId;

    private Date createdAt = new Date();
}
