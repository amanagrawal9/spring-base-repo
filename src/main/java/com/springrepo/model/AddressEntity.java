package com.springrepo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "ADDRESS")
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends BaseEntity {

	@Column(name = "ADDRESS_LINE1", nullable = false)
    private String addressLine;

    @Column(name = "POSTCODE", nullable = false)
    private String postcode;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "CITY", nullable = false)
    private String city;
    
}
