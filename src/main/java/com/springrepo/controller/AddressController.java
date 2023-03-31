package com.springrepo.controller;

import com.springrepo.model.AddressEntity;
import com.springrepo.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	
	@RequestMapping(value = "/id/{addressId:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AddressEntity> getById(@PathVariable Integer addressId) throws Exception {
		//log.debug("Get Address Request came for: " + addressId);
		
		Optional<AddressEntity> response = addressService.getById(addressId);
		
		//log.debug("Returning Address: [" + response + "]");
		
		return new ResponseEntity<AddressEntity>(response.get(), HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = { "application/xml", "application/json" })
	@ResponseBody
	public ResponseEntity<AddressEntity> save(
			@RequestBody AddressEntity addressEntity, BindingResult result) throws Exception {

		log.debug("Create Address Message request came for [" + addressEntity + "]");
		
		if (result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		AddressEntity response = addressService.save(addressEntity);
		
		//log.debug("Create Address completed successfully for [" + response + "]");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Page<AddressEntity>> getAddresses(@RequestParam(required = false, defaultValue = "0") Integer pageNumber, 
			@RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String sortBy, @RequestParam(required = false, defaultValue = "true") Boolean approved) {
		
		//log.debug("Get Addresses request came for [" + pageNumber + ", " + pageSize + ", " + sortBy + "]");
		
		if(sortBy == null) {
			sortBy = "lastUpdatedTime";
		}
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		Page<AddressEntity> response = addressService.getAddresses(pageable);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
