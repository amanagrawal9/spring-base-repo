package com.springrepo.repository;

import com.springrepo.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

    ContactEntity findByUserName(String username);

}
