package com.react.practice.entity;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="buyerInfo")
public class BuyerEntity {

    @Id
    @Column(unique = true)
    private String merchant_uid;

    @Column
    private String userid;

    @Column
    private String pay_method;

    @Column
    private String name;

    @Column
    private String amount;

    @Column
    private String phone;

    @Column
    private String addr;
}
