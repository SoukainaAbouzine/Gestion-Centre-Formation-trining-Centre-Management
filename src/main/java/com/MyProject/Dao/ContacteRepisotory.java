package com.MyProject.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.MyProject.Entitys.Contact;
import com.MyProject.Entitys.DemandeInscription;

public interface ContacteRepisotory extends JpaRepository<Contact, Long> {
	
	Page<Contact>findAll(Pageable pageable);
      
	/*
	 * @Query("select c from Contact c where c.statue like :x") public List<Contact>
	 * findByStatus(@Param("x") String status);
	 */
}
