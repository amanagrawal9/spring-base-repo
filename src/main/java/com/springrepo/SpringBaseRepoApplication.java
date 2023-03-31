package com.springrepo;

import com.springrepo.model.ContactEntity;
import com.springrepo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBaseRepoApplication {

	@Autowired
	private ContactRepository contactRepository;

	@PostConstruct
	public void initUsers() {

		List<ContactEntity> all = contactRepository.findAll();
		if (all.isEmpty()) {
			ContactEntity contact = new ContactEntity();
			contact.setUserName("admin");
			contact.setPassword("admin");
			contact.setEmail("admin@gmail.com");
			contactRepository.save(contact);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBaseRepoApplication.class, args);
	}

}
