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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MyProject.Dao.demendeInscriptionRepisotory;
import com.MyProject.Dao.utilisateurRepisotory;
import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Etudiant;
import com.MyProject.Entitys.Formateur;
import com.MyProject.Entitys.Utilisateur;

//import Dao.Produit;

@Controller
@Transactional
public class DemandeInscriptionController {
	@Autowired

	private demendeInscriptionRepisotory dao;

	
	@RequestMapping(value = "/liste-validee")
	public String listeDemandesValide(Model model) {
		model.addAttribute("Demandes", dao.findByStatus("confirmer"));

		// model.addAttribute("Demandes",dao.findAll());

		return "liste-validee";
	}

	@RequestMapping(value = "/liste-archive")
	public String listeDemandesArchive(Model model) {
		model.addAttribute("Demandes", dao.findByStatus("annuler"));

		return "liste-archives";

	}

	@RequestMapping(value = "/listDemande", method = RequestMethod.GET)
	public String list(Model model, Pageable pageable) {
		Page<DemandeInscription> demandePage = dao.findAll(pageable);
		PageWapper<DemandeInscription> page = new PageWapper<DemandeInscription>(demandePage, "/listDemande");
		model.addAttribute("listDemande", page.getContent());
		model.addAttribute("page", page);
		return "dmd";
	}
	
	@GetMapping(value = "/demandeInscription")
	public String addDemande(Model model) {
		try {

			model.addAttribute("ajouterDemande", new DemandeInscription());
		} catch (Exception e) {
			model.addAttribute("exception", e);

		}
		return "FaireDemande";
	}

	@PostMapping(value = "/saveDemande")
	public String SaveDemande(DemandeInscription dmd, BindingResult bind) {
		dmd = dao.save(dmd);

		return "redirect:/listDemande?page=";
	}


}
/*
 * @GetMapping("/add") public String add(Model model) {
 * 
 * model.addAttribute("customer", new Customers()); return "customers/form";
 */
/*
 * @PostMapping(value = "/save") public String save(Customers customer, final
 * RedirectAttributes ra) {
 * 
 * Customers save = customerService.save(customer);
 * ra.addFlashAttribute("successFlash", "Cliente foi salvo com sucesso.");
 * return "redirect:/customers";
 */

/*
 * @RequestMapping("/save") public ModelAndView save(@ModelAttribute("employee")
 * Employee employeeObj) { ModelAndView mav = new ModelAndView("employeesList");
 * employeeService.save(employeeObj); List<Employee> list =
 * employeeService.get(); mav.addObject("list", list); return mav; }
 */

/*
 * @RequestMapping(path = "/createEmployee", method = RequestMethod.POST) public
 * String createOrUpdateEmployee(EmployeeEntity employee) {
 * service.createOrUpdateEmployee(employee); return "redirect:/"; } }
 */

/*
 * try { DemandeInscription d = (DemandeInscription)
 * service.afficherDemandeinscription(); model.addAttribute("demandeList",d);
 * }catch(Exception e) { model.addAttribute("Exception",e); } return "demandes";
 */
/*
 * model.addAttribute("listdemande",service.afficherDemandeinscription());
 * return "demandes";
 */

/*
 * @RequestMapping("/in") public String home() { return "demandeInscription";
 */

/*
 * @Autowired ProduitMetier Services ;
 * 
 * @RequestMapping(value="/index") public String pageIndex(Model model) {
 * 
 * model.addAttribute("listeProduit",Services.getAllProduit()); return
 * "Produits"; }
 */