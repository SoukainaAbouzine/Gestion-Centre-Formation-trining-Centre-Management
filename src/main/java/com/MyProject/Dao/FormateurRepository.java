package com.MyProject.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Utilisateur;

public interface FormateurRepository extends JpaRepository <Formateur,Long>{
	Page<Formateur>findAll(Pageable pageable);

	@Query("select f from Formateur f where f.id = :x") 
	public Formateur findByidentif(@Param("x") Long id);
 
}
