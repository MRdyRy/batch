package com.rdy.batch.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserModel {

    @Id
    private Integer id;
    private String name;
    private String dept;
    private Double salary;
}
