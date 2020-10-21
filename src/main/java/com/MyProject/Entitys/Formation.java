package com.MyProject.Entitys;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Formation")
public class Formation {

@Id @GeneratedValue (strategy = GenerationType.AUTO)
@Column(name="id_Formation")
  private Long idFormation;
  private String name ,description;
  private int nbrHeurs,places ,discount;
  private boolean actif;
@OneToMany(mappedBy = "formations")
  private Collection<DemandeInscription> DemandeInscription;
@ManyToMany(mappedBy = "formation")
  private Collection<Etudiant>etudiant;
@ManyToMany(mappedBy = "formation")
  private Collection<Formateur>formateur;

public Collection<Cours> getCours() {
	return cours;
}
public void setCours(Collection<Cours> cours) {
	this.cours = cours;
}
@ManyToMany (cascade = { CascadeType.ALL })
@JoinTable(
        name = "Programe", 
        joinColumns = { @JoinColumn (name = "Formation_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "Cours_id") }
    )

private Collection<Cours>cours;



public Formation(String name) {
	super();
	this.name = name;
}
public Formation() {
	super();
}
 
public Formation(String name, String description, int nbrHeurs, int places, int discount, boolean actif) {
	super();
	this.name = name;
	this.description = description;
	this.nbrHeurs = nbrHeurs;
	this.places = places;
	this.discount = discount;
	this.actif = actif;
}
public Collection<DemandeInscription> getDemandeInscription() {
	return DemandeInscription;
}
public void setDemandeInscription(Collection<DemandeInscription> demandeInscription) {
	DemandeInscription = demandeInscription;
}
public Collection<Etudiant> getEtudiant() {
	return etudiant;
}
public void setEtudiant(Collection<Etudiant> etudiant) {
	this.etudiant = etudiant;
}
public Collection<Formateur> getFormateur() {
	return formateur;
}
public void setFormateur(Collection<Formateur> formateur) {
	this.formateur = formateur;
}
public Collection<DemandeInscription> getDemendeInscriptions() {
return DemandeInscription;
}
public void setDemendeInscriptions(List<DemandeInscription> demendeInscriptions) {
this.DemandeInscription = demendeInscriptions;
}

public Long getIdFormation() {
   return idFormation;
}
public void setIdFormation(Long idFormation) {
   this.idFormation = idFormation;
}
public String getName() {
return name;
}
public void setName(String name) {
   this.name = name;
}
public String getDescription() {
  return description;
}
public void setDescription(String description) {
   this.description = description;
}
public int getNbrHeurs() {
   return nbrHeurs;
}
public void setNbrHeurs(int nbrHeurs) {
    this.nbrHeurs = nbrHeurs;
}
public int getPlaces() {
   return places;
}
public void setPlaces(int places) {
   this.places = places;
}
public int getDiscount() {
   return discount;
}
public void setDiscount(int discount) {
   this.discount = discount;
}
public boolean isActif() {
   return actif;
}
public void setActif(boolean actif) {
    this.actif = actif;
}@Override
public String toString() {
	return "Formation [idFormation=" + idFormation + ", name=" + name + ", description=" + description + ", nbrHeurs="
			+ nbrHeurs + ", places=" + places + ", discount=" + discount + ", actif=" + actif + ", DemandeInscription="
			+ DemandeInscription + ", etudiant=" + etudiant + ", formateur=" + formateur + "]";
}
}