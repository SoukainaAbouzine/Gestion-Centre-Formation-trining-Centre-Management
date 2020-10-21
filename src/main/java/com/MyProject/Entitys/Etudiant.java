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
@DiscriminatorValue("etudiant")
public class Etudiant extends Utilisateur{
	 
	public Collection<Formation> getFormation() {
		return formation;
	}
	public Etudiant(String niveauEtude, Date dateNaissance) {
		super();
		NiveauEtude = niveauEtude;
		this.dateNaissance = dateNaissance;
	}
	public void setFormation(Collection<Formation> formation) {
		this.formation = formation;
	}
	private String NiveauEtude;
	  private Date dateNaissance;
	  @ManyToMany (cascade = { CascadeType.ALL })
	    @JoinTable(
	            name = "Etudiant_forme", 
	            joinColumns = { @JoinColumn (name = "Etudiant_id") }, 
	            inverseJoinColumns = { @JoinColumn(name = "Formation_id") }
	        )
	 
	  private Collection<Formation>formation;
	  
	public String getNiveauEtude() {
		return NiveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		NiveauEtude = niveauEtude;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	 public Etudiant() {
			// TODO Auto-generated constructor stub
		}
		
	
	
	
	public Etudiant(String nome, String prenome, String username, String password, String email, String telephone,
			String role, Date dateCreation, boolean actif, String niveauEtude, Date dateNaissance) {
		super(nome, prenome, username, password, email, telephone, role, dateCreation, actif);
		NiveauEtude = niveauEtude;
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return "Etudiant [NiveauEtude=" + NiveauEtude + ", dateNaissance=" + dateNaissance + ", getNiveauEtude()="
				+ getNiveauEtude() + ", getDateNaissance()=" + getDateNaissance() + "]";
	}
	  
	  

}

