package com.MyProject.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.MyProject.Entitys.Cours;
import com.MyProject.Entitys.DemandeInscription;

public interface CoursRepisotory extends PagingAndSortingRepository<Cours,Long>{
	Page<Cours>findAll(Pageable pageable);

}
