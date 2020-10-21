package com.MyProject.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Formation;

public interface FormationRepisotory extends PagingAndSortingRepository<Formation,Long> {
	Page<Formation>findAll(Pageable pageable);

}
