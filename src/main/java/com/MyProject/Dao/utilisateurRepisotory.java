package com.MyProject.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Utilisateur;

public interface utilisateurRepisotory extends JpaRepository<Utilisateur,Long>{
	public Page<Utilisateur>findAll(Pageable pageable);
	
	//public void updatUser(Long id,Utilisateur u);
	
	@Query("select u from Utilisateur u where u.id = :x") 
	public Utilisateur findByidentif(@Param("x") Long id);
	
	@Query("select u from Utilisateur u where u.nome like :x OR u.prenome like :x  OR u.role like :x ")  
	public List<Utilisateur> rechercher(@Param("x") String nom);
	
	//public Utilisateur getById(Long id);
	/*
	 * @Query("delete Utilisateur where nome = :x") public String
	 * deletUsreByname(@Param("x") String nome);
	 */
	 
}
