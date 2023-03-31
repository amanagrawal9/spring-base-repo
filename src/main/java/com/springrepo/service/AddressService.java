package com.springrepo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springrepo.model.AddressEntity;
import com.springrepo.repository.AddressRepository;

@Transactional
@Service("addressServiceImpl")
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public Optional<AddressEntity> getById(Integer id) {
		return addressRepository.findById(id);
	}

	public AddressEntity save(AddressEntity addressEntity) {
		return addressRepository.save(addressEntity);
	}

	public Page<AddressEntity> getAddresses(Pageable pageable) {
		return addressRepository.findAll(pageable);
	}

}
