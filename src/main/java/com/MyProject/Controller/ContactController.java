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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MyProject.Dao.ContacteRepisotory;
import com.MyProject.Entitys.Contact;
import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Utilisateur;

@Controller
@Transactional
public class ContactController {
	@Autowired
	private ContacteRepisotory contact;
	
	 public PageWapper pageSave;

		@RequestMapping(value = "/listContact", method = RequestMethod.GET)
		public String listContact(Model model, Pageable pageable) {
			Page<Contact> ContactPage = contact.findAll(pageable);
			PageWapper<Contact> page = new PageWapper<Contact>(ContactPage, "/listContact");
			model.addAttribute("listContact", page.getContent());
			model.addAttribute("page", page);
			pageSave = page;
			return "ContactList";
		}
	 
	 @GetMapping(value = "/ajouterContact")
		public String addContact(Model model) {
			try {

				model.addAttribute("ajouterContacte", new Contact());
			} catch (Exception e) {
				model.addAttribute("exception", e);

			}
			return "FaireContact";
		}

		@PostMapping(value = "/saveContact")
		public String SaveDemande(Contact ctc, BindingResult bind) {
			ctc = contact.save(ctc);

			return "redirect:/listContact?page=";
		}
		
		
}
