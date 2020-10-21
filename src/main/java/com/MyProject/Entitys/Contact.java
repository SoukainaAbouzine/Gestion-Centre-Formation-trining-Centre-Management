package com.MyProject.Entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 @Entity
public class Contact {
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	 @Column(name="id_Contact")
	private Long idContact;
	private String name ,prenom,email,message ,telephone;
	public Utilisateur getUtlisateur() {
		return utlisateur;
	}

	public void setUtlisateur(Utilisateur utlisateur) {
		this.utlisateur = utlisateur;
	}

	private Date dateContacte;
	 @ManyToOne
	 @JoinColumn(name="id_Utilisateur")
	private Utilisateur utlisateur;
	 
	 

	public Contact(String name, String prenom, String email, String message, String telephone, Date dateContacte,
			Utilisateur utlisateur) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.message = message;
		this.telephone = telephone;
		this.dateContacte = dateContacte;
		this.utlisateur = utlisateur;
	}

	public Contact(String name, String prenom, String email, String message, String telephone) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.message = message;
		this.telephone = telephone;
	}

	public Contact(String name, String prenom, String email, String message, String telephone, Date dateContacte) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.message = message;
		this.telephone = telephone;
		this.dateContacte = dateContacte;
	}

	public Contact() {
		super();
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateContacte() {
		return dateContacte;
	}

	public void setDateContacte(Date dateContacte) {
		this.dateContacte = dateContacte;
	}

	public Utilisateur getUtilisateur() {
		return utlisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utlisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", name=" + name + ", prenom=" + prenom + ", email=" + email
				+ ", message=" + message + ", telephone=" + telephone + ", dateContacte=" + dateContacte
				+ ", utilisateur=" + utlisateur + ", getIdContact()=" + getIdContact() + ", getName()=" + getName()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getMessage()=" + getMessage()
				+ ", getTelephone()=" + getTelephone() + ", getDateContacte()=" + getDateContacte()
				+ ", getUtilisateur()=" + getUtilisateur() + "]";
	}

}
