package com.MyProject;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MyProject.Dao.ContacteRepisotory;
import com.MyProject.Dao.CoursRepisotory;
import com.MyProject.Dao.FormationRepisotory;
import com.MyProject.Dao.demendeInscriptionRepisotory;
import com.MyProject.Dao.utilisateurRepisotory;
import com.MyProject.Entitys.Contact;
import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Etudiant;
import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Formation;
import com.MyProject.Entitys.Utilisateur;

@SpringBootApplication
public class GestionFormation3Application implements CommandLineRunner{
	
	@Autowired
	 private utilisateurRepisotory user;
	@Autowired
	private FormationRepisotory formation;
	@Autowired
	private demendeInscriptionRepisotory demande;
	@Autowired
	private CoursRepisotory cours;
	@Autowired
	private ContacteRepisotory contact;

	public static void main(String[] args) {
		SpringApplication.run(GestionFormation3Application.class, args);
	}

	public void run(String... args) throws Exception {
		
	   
		
		
		/*
		 * Formateur formateur1=user.save(new
		 * Formateur("soukaina","aboueine","soukazAbouzine","soukaz1223",
		 * "soukainaabouzine113@gmail.com", "+212 6 48 24 05 30","formateure",new
		 * Date(11/07/2018),true,"doctorat","Math Informatique"));
		 * 
		 * 
		 * Formation f=formation.save(new Formation("bigdata","good",20, 25,15,true));
		 * Formateur soukaina=new Formateur("soukaina","abouzine","souka1123","hanar",
		 * "soukainaabouzine113@gmail.com" , "+212 6 48 24 05 30","formateur", new
		 * Date(), true, "doctorat", "have a good khnowledg");
		 * 
		 * DemandeInscription d= demande.save(new
		 * DemandeInscription("jon","hanae","hanae@gmail.com"
		 * ,"+212 6 66 55 77","pas de places","confirmer",soukaina,f));
		 * 
		 * 
		 */
			/*
			 * Formation bigData2=new Formation("php","spicialiter des mastre",50,
			 * 25,15,true);
			 * 
			 * formation.save(bigData2);
			 * 
			 * 
			 * 
			 * Etudiant hassan2=new Etudiant("mohamed",
			 * "hassan","hassouna","hassane112","hassan@gmail.com", "06066 24 56",
			 * "etudiant", new Date(11/6/2016),true,"master",new Date(07/11/1995));
			 * user.save(hassan2); Utilisateur Uadmin1=user.save(new Utilisateur
			 * ("Abc@gmail.com","abc" ,"admin"));
			 * 
			 * Contact c=new Contact("abs", "abs","abc@gmail?com","test", "06345279");
			 * 
			 * 
			 * Etudiant E1=user.save(new Etudiant("licece",new Date(11/07/1995))); Etudiant
			 * E3=user.save(new Etudiant("oussama","abouzine","oussamaab","amo1223",
			 * "oussamaabouzine2202@gmail.com", "+212 6 55 77 8","etudiant",new
			 * Date(1/3/2015),true,"bacaloriat",new Date(5/6/2002)));
			 */
		 
   		  
   		//  user.deleteById(100L);
     
/*
 * formateur1.getFormation().add(f); user.save(formateur1);
 */
	/*
	 * user.save(soukaina); Formation java=new Formation("java EE", "java junior",
	 * 28,15, 66, true); formation.save(java);
	 */
   //soukaina.getFormation().add(java); java.getFormateur().add(soukaina);
/*
 * f.getFormateur().add(formateur1); formateur1.getFormation().add(f);
 */
	/*
	 * 
	 * 
	 * formation.save(java); // user.save(soukaina);
	 * 
	 */ 
		  
		 
	}

}
