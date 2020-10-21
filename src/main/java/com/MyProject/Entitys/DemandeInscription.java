package com.MyProject.Entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="DemandeInscription")
public class DemandeInscription {

@Id @GeneratedValue (strategy = GenerationType.AUTO)
@Column(name="id_Demande")
private Long idDemande;
private String name,prenome,email,telephone,justification ,statue ;
@ManyToOne
@JoinColumn(name="id_Utilisateur",nullable=false)
private Utilisateur utilisateur;
@ManyToOne
@JoinColumn(name="id_Formation",nullable=false)
private Formation formations;
public Formation getFormations() {
	return formations;
}
public void setFormations(Formation formations) {
	this.formations = formations;
}
public Long getIdDemande() {
return idDemande;
}
public void setIdDemande(Long idDemande) {
this.idDemande = idDemande;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getPrenome() {
return prenome;
}
public void setPrenome(String prenome) {
this.prenome = prenome;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getTelephone() {
return telephone;
}
public void setTelephone(String telephone) {
this.telephone = telephone;
}
public String getJustification() {
return justification;
}
public void setJustification(String justification) {
this.justification = justification;
}
public String getStatue() {
return statue;
}
public void setStatue(String statue) {
this.statue = statue;
}
public Utilisateur getUtilisateur() {
return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
this.utilisateur = utilisateur;
}
  
public DemandeInscription() {
super();
// TODO Auto-generated constructor stub
}
public DemandeInscription(String name, String prenome, String email, String telephone, String justification,
		String statue, Utilisateur utilisateur, Formation formations) {
	super();
	this.name = name;
	this.prenome = prenome;
	this.email = email;
	this.telephone = telephone;
	this.justification = justification;
	this.statue = statue;
	this.utilisateur = utilisateur;
	this.formations = formations;
}
public DemandeInscription(Long idDemande, String name, String prenome, String email, String telephone,
		Formation formations) {
	super();
	this.idDemande = idDemande;
	this.name = name;
	this.prenome = prenome;
	this.email = email;
	this.telephone = telephone;
	this.formations = formations;
}


}
