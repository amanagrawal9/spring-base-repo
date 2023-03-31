package com.springrepo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_TIME", nullable = false)
	@Version
	protected Date lastUpdatedTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME", nullable = false)
	protected Date createdTime;
	
	@PrePersist
    protected void onCreate() {
		lastUpdatedTime = createdTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	lastUpdatedTime = new Date();
    }

}