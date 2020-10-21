package com.MyProject.Entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cours")
public class Cours {
@Id  @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_cours")
private Long idCours;
private String nomCours;
private int nbHeurs;
@ManyToMany(mappedBy = "cours")
private Collection<Formation>formation;
 

public Collection<Formation> getFormation() {
	return formation;
}
public void setFormation(Collection<Formation> formation) {
	this.formation = formation;
}

public Cours(String nomCours, int nbHeurs, Collection<Formation> formation) {
	super();
	this.nomCours = nomCours;
	this.nbHeurs = nbHeurs;
	this.formation = formation;
}
public Cours() {
super();
// TODO Auto-generated constructor stub
}
public Long getIdCours() {
   return idCours;
}
public void setIdCours(Long idCours) {
   this.idCours = idCours;
}
public String getNomCours() {
   return nomCours;
}
public void setNomCours(String nomCours) {
   this.nomCours = nomCours;
}
public int getNbHeurs() {
   return nbHeurs;
}
public void setNbHeurs(int nbHeurs) {
   this.nbHeurs = nbHeurs;
}

}
