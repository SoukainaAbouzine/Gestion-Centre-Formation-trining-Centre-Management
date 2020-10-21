package com.MyProject.Entitys;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("formateur")
public class Formateur extends Utilisateur{
	private  String diplome;
	private String description;
	
	 @ManyToMany (cascade = { CascadeType.ALL })
	    @JoinTable(
	            name = "Formateur_forme", 
	            joinColumns = { @JoinColumn (name = "Formateur_id") }, 
	            inverseJoinColumns = { @JoinColumn(name = "Formation_id") }
	        )
	 
	  private Collection<Formation>formation;
	
	public Collection<Formation> getFormation() {
		return formation;
	}
	public void setFormation(Collection<Formation> formation) {
		this.formation = formation;
	}
	public String getDiplome() {
	return diplome;
	}
	public void setDiplome(String diplome) {
	this.diplome = diplome;
	}
	public String getDescription() {
	return description;
	}
	public void setDescription(String description) {
	this.description = description;
	}
	public Formateur() {
	super();
	// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	public Formateur(String diplome, String description, Collection<Formation> formation) {
		super();
		this.diplome = diplome;
		this.description = description;
		this.formation = formation;
	}
	public Formateur(String nome, String prenome, String username, String password, String email, String telephone,
			String role, Date dateCreation, boolean actif, String diplome, String description) {
		super(nome, prenome, username, password, email, telephone, role, dateCreation, actif);
		this.diplome = diplome;
		this.description = description;
	}
	@Override
	public String toString() {
	return "Formateur [diplome=" + diplome + ", description=" + description + ", getDiplome()=" + getDiplome()
	+ ", getDescription()=" + getDescription() + "]";
	}
	

}
