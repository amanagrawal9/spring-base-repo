package com.springrepo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "CONTACT")
@EqualsAndHashCode(callSuper = true)
public class ContactEntity extends BaseEntity {

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;
    
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;
    
	@Column(name = "DATE_OF_BIRTH")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "MOBILE_PHONE")
	private String mobilePhone;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
}
