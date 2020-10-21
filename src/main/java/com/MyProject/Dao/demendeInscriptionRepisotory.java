package com.MyProject.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.MyProject.Entitys.DemandeInscription;

public interface demendeInscriptionRepisotory extends JpaRepository<DemandeInscription,Long>{
	
	Page<DemandeInscription>findAll(Pageable pageable);
	
	
	  @Query("select d from DemandeInscription d where d.statue like :x")
	  public List<DemandeInscription> findByStatus(@Param("x") String status);
	 
	
}
