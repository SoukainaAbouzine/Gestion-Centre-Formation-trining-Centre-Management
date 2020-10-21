package com.MyProject.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.MyProject.Entitys.Etudiant;
import com.MyProject.Entitys.Formateur;

public interface EtudiantRepository extends JpaRepository <Etudiant,Long>{
	Page<Etudiant>findAll(Pageable pageable);
     
	@Query("select e from Etudiant e where e.id = :x") 
	public Etudiant findByidentif(@Param("x") Long id);

}
