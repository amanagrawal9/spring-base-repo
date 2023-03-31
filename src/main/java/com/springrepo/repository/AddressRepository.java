package com.springrepo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springrepo.model.AddressEntity;

public interface AddressRepository extends PagingAndSortingRepository<AddressEntity, Integer> {

}
