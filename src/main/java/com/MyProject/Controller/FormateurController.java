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

import com.MyProject.Dao.FormateurRepository;
import com.MyProject.Dao.utilisateurRepisotory;
import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Utilisateur;
@Controller
@Transactional
public class FormateurController {
	@Autowired
	private FormateurRepository formateur;
	
	@Autowired
	private utilisateurRepisotory user;
	public PageWapper pageSave;
	
	
	 @RequestMapping(value = "/listFormateur", method = RequestMethod.GET)
		public String list(Model model, Pageable pageable) {
			Page<Formateur> demandePage = formateur.findAll(pageable);
			PageWapper<Formateur> page = new PageWapper<Formateur>(demandePage, "/listFormateur");
			model.addAttribute("listFormateur", page.getContent());
			model.addAttribute("page", page);
			pageSave=page;
			return "Formateurlist";
		}
	
	 @GetMapping(value="/InscriptionFormateur") 
	  public String addFormateur(Model model) {
		  try { 
		  
		  model.addAttribute("ajouterFormateur", new Formateur());}
			  catch(Exception e){
				  model.addAttribute("exception", e);
				  
		  }
		  return "Formateur";}
	 
	 
	 @PostMapping(value="/saveFormateur")
	   public String Save(Formateur formateur1,BindingResult bind ) {
		  formateur1=formateur.save(formateur1);
		   
		   return "redirect:/listFormateur?page=";
	   }
	    
		
		  @RequestMapping(value = "listFormateur/update/{id}")
		  public String UpdateFormateur(@PathVariable("id") Long id, Model model) {
		  
		  Utilisateur form = formateur.findByidentif(id); 
		  form.setId(id);
		  model.addAttribute("form", form);
		  
		  model.addAttribute("save",user.save(form) );
		  return "FormateurModifier";
		  }
		 
			/*
			 * @RequestMapping(value = "listFormateur/delete/{id}", method =
			 * RequestMethod.GET) public String deleteFormateur(@PathVariable("id") Long
			 * id,Model model, Pageable pageable) {
			 * 
			 * user.deleteById(id );
			 * 
			 * Page<Utilisateur> demandePage = user.findAll(pageable);
			 * PageWapper<Utilisateur> page = new
			 * PageWapper<Utilisateur>(demandePage,"/listFormateur");
			 * model.addAttribute("listFormateur", page.getContent()); int Page;
			 * Page=pageSave.getNumber()-1; model.addAttribute("page",Page );
			 * 
			 * return "redirect:/listFormateur?page="+Page+"";
			 * 
			 * }
			 */
		 
	  
	  @RequestMapping(value = "listFormateur/delet/{id}", method = RequestMethod.GET)
	  public String deleteuser(@PathVariable("id") Long id,Model model, Pageable
	  pageable) { 
		  
		    formateur.deleteById(id );
		    Page<Formateur> demandePage = formateur.findAll(pageable);
			PageWapper<Formateur> page = new PageWapper<Formateur>(demandePage, "/listFormateur");
			model.addAttribute("listFormateur", page.getContent());
			int Page1; Page1=pageSave.getNumber()-1;
			model.addAttribute("page", Page1);
			
			return "redirect:/listFormateur?page="+Page1+"";
	  
			/*
			 * Page<Formateur> demandePage = formateur.findAll(pageable);
			 * PageWapper<Formateur> page = new PageWapper<Formateur>(demandePage,
			 * "/listFormateur"); model.addAttribute("listFormateur", page.getContent());
			 * int Page1; Page1=pageSave.getNumber()-1; model.addAttribute("page",Page1 );
			 * System.out.println("formateur"+pageSave.getNumber());
			 * 
			 * return "listFormateur?page="+Page1+"";
			 */
	  
	  }
}
