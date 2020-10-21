package com.MyProject.Entitys;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;



@Entity

@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Type_Utilisateur",
discriminatorType=DiscriminatorType.STRING,length=16)
public class Utilisateur {
	
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="id_Utilisateur")
	private Long id;
	private String nome,prenome,username,password ,email ,telephone ,role;
	private Date dateCreation;
	private boolean actif;
	
	@OneToMany(mappedBy="utlisateur")

	private Collection<Contact>Contact;
	@OneToMany(mappedBy="utilisateur")
	 private Collection<DemandeInscription>DemandeInscription;
		
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	
	public Utilisateur(String nome, String prenome, String email, String telephone, String role, Date dateCreation) {
		super();
		this.nome = nome;
		this.prenome = prenome;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
	}
	
	
	public Utilisateur(String nome, String prenome, String username, String password, String email, String telephone,
			String role, Date dateCreation, boolean actif) {
		super();
		this.nome = nome;
		this.prenome = prenome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.role = role;
		this.dateCreation = dateCreation;
		this.actif = actif;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTLF() {
		return telephone;
	}
	public void setTLF(String tLF) {
		telephone = tLF;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPrenome() {
		return prenome;
	}
	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Collection<Contact> getContact() {
		return Contact;
	}
	public void setContact(Collection<Contact> contact) {
		Contact = contact;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nome=" + nome + ", prenome=" + prenome + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", telephone=" + telephone + ", dateCreation="
				+ dateCreation + ", role=" + role + ", actif=" + actif + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getTLF()="
				+ getTLF() + ", getDateCreation()=" + getDateCreation() + ", getRole()=" + getRole() + ", isActif()="
				+ isActif() + ", getNome()=" + getNome() + ", getPrenome()=" + getPrenome() + ", getTelephone()="
				+ getTelephone() + "]";
	}
	
	
	
	
		

}
