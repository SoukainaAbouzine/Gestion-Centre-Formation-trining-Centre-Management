package com.MyProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MyProject.Dao.EtudiantRepository;
import com.MyProject.Dao.utilisateurRepisotory;
import com.MyProject.Entitys.Etudiant;
import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Utilisateur;
@Controller
@Transactional
public class EtudiantController {
	
	@Autowired
	private EtudiantRepository etudiant;
	@Autowired
	private utilisateurRepisotory user;
	public PageWapper pageSave;

	
	 @RequestMapping(value = "/listEtudiant", method = RequestMethod.GET)
		public String list(Model model, Pageable pageable) {
			Page<Etudiant> demandePage = etudiant.findAll(pageable);
			PageWapper<Etudiant> page = new PageWapper<Etudiant>(demandePage, "/listEtudiant");
			model.addAttribute("listEtudiant", page.getContent());
			model.addAttribute("page", page);
			return "EtudiantList";
		}

	
	
	@GetMapping(value="/InscriptionEtudiant") 
	  public String addEtudiant(Model model) {
		  try { 
		  
		  model.addAttribute("ajouterEtudiant", new Etudiant());}
			  catch(Exception e){
				  model.addAttribute("exception", e);
				  
		  }
		  return "Etudiant";}
	
	@PostMapping(value="/saveEtudiant")
	   public String Save(Etudiant etudiant1,BindingResult bind ) {
		  etudiant1=etudiant.save(etudiant1);
		   
		   return  "EtudiantList";
	   }
	
	 @RequestMapping(value = "listEtudiant/update/{id}")
	  public String UpdateEtudiant(@PathVariable("id") Long id, Model model) {
	  
	  Utilisateur student = etudiant.findByidentif(id); 
	  student.setId(id);
	  model.addAttribute("etudiant", student);
	  
	  model.addAttribute("save",user.save(student) );
	  return "EtudaintModifier";
	  }
	
	
	 @RequestMapping(value = "listEtudiant/delet/{id}", method = RequestMethod.GET)
	  public String deleteuser(@PathVariable("id") Long id,Model model, Pageable
	  pageable) { 
		  
		    etudiant.deleteById(id );
	  
	  Page<Etudiant> demandePage = etudiant.findAll(pageable);
	  PageWapper<Etudiant> page = new PageWapper<Etudiant>(demandePage,
	  "/listEtudiant"); model.addAttribute("listEtudiant",page.getContent()); 
	  int Page; 
	  Page=pageSave.getNumber()-1;
	  model.addAttribute("page",Page );
	  
	  return "redirect:/listEtudiant?page="+Page+"";
	  
	  }
}
