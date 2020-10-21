package com.MyProject.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MyProject.Dao.utilisateurRepisotory;
import com.MyProject.Entitys.DemandeInscription;
import com.MyProject.Entitys.Utilisateur;

@Controller
@Transactional
public class UtilisateurController {
	@Autowired
	private utilisateurRepisotory user;
	public PageWapper pageSave;

	@RequestMapping(value = "/listUtilisateur", method = RequestMethod.GET)
	public String list(Model model, Pageable pageable) {
		Page<Utilisateur> demandePage = user.findAll(pageable);
		PageWapper<Utilisateur> page = new PageWapper<Utilisateur>(demandePage, "/listUtilisateur");
		model.addAttribute("listUtilisateur", page.getContent());
		model.addAttribute("page", page);
		pageSave = page;
		return "user";
	}

	@GetMapping(value = "/Inscription")
	public String addusres(Model model) {
		try {

			model.addAttribute("ajouterUer", new Utilisateur());
		} catch (Exception e) {
			model.addAttribute("exception", e);

		}
		return "hanae";
	}

	@PostMapping(value = "/save")
	public String Save(Utilisateur utilisateur, BindingResult bind) {
		utilisateur = user.save(utilisateur);

		return "redirect:/listUtilisateur?page=";
	}

	/*
	 * @GetMapping("Utilisateur/{id}/delete") public String deletById(@PathVariable
	 * Long id) {
	 * 
	 * //log.debug("Deleting id:" + id); user.deleteById(Long.valueOf(id));
	 * 
	 * return "redirect:/";
	 */

	/*
	 * @RequestMapping("product/delete/{id}") public String delete(@PathVariable
	 * Integer id){ user.deleteById(id); return "redirect:/products"; }
	 */

	/*
	 * @GetMapping(value = "Utilisateur/{id}") public String
	 * deleteuser(@PathVariable("id") Long id) { user.deleteById(id); return"user";
	 * }
	 */

	
	  @RequestMapping(value = "listUtilisateur/delete/{id}", method = RequestMethod.GET)
	  public String deleteuser(@PathVariable("id") Long id,Model model, Pageable pageable) { 
		  user.deleteById(id );
	  
	  Page<Utilisateur> demandePage = user.findAll(pageable);
	  PageWapper<Utilisateur> page = new PageWapper<Utilisateur>(demandePage,"/listUtilisateur");
	  model.addAttribute("listUtilisateur", page.getContent());
	  int Page; Page=pageSave.getNumber()-1;
	  model.addAttribute("page",Page );
	  
	  return "redirect:/listUtilisateur?page="+Page+"";
	  
	  }
	  
	  
	  
	  @RequestMapping(value="listUtilisateur/updat/{id}",method=RequestMethod.GET)
	  public String UpdatUser(@PathVariable("id")Long id,Utilisateur u ,Model model,Pageable pageable) { 
		  model.addAttribute("updat", user.findById(id)) ;
	  Page<Utilisateur> demandePage = user.findAll(pageable);
	  PageWapper<Utilisateur> page = new PageWapper<Utilisateur>(demandePage,"/listUtilisateur");
	  model.addAttribute("listUtilisateur", page.getContent());
	  model.addAttribute("page",page );
	  return "redirect:/listUtilisateur?page="+page+""; }
	 

	@RequestMapping(value = "listUtilisateur/update/{id}")
	public String Update(@PathVariable("id") Long id, Model model) {

		Utilisateur student = user.findByidentif(id);
		student.setId(id);
		model.addAttribute("user", student);

		model.addAttribute("save", user.save(student));

		return "soukaina";

	}
     
	@RequestMapping(value = "/search-utilisateur")
	public String trouver(@RequestParam(required = false) String nom,Model model, Pageable pageable) {
		
		Page<Utilisateur> demandePage = user.findAll(pageable);
		PageWapper<Utilisateur> page = new PageWapper<Utilisateur>(demandePage, "/listUtilisateur");
		model.addAttribute("listUtilisateur",  user.rechercher(nom));
		model.addAttribute("page", page);
		pageSave=page;
	//	model.addAttribute("listUtilisateur", user.rechercher(nom));
		
	

		return "user";
	}
	  
	
	
	
	
	
	
	

	/*
	 * @GetMapping("listUtilisateur/update/{id}") public ModelAndView
	 * updateCourse(@PathVariable("id") Long id){
	 * 
	 * ModelAndView model =new ModelAndView(); Utilisateur u =
	 * user.findById(id).get(); model.addObject("user", u);
	 * model.setViewName("soukaina");
	 * 
	 * model.addObject("save", user.save(u)); return model; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

//			  @GetMapping("listUtilisateur/update/{id}")
//			    public String showUpdateForm(@PathVariable ("id") long id, Model model) {
//			        Utilisateur  student = this.user.findById(id)
//			                .orElseThrow(() -> new IllegalArgumentException("Invalid student id : " + id));
//
//			        model.addAttribute("student", student);
//			        return "soukaina";
//			    }
//
//			    @PostMapping("listUtilisateur/update/{id}")
//			    public String updateStudent(@PathVariable("id") long id, @Valid Utilisateur student, BindingResult result, Model model) {
//			        if(result.hasErrors()) {
//			            student.setId(id);
//			            return "soukaina";
//			        }
//
//			        // update student
//			        user.save(student);
//
//			        // get all students ( with update)
//			        model.addAttribute("students", this.user.findAll());
//			        return "/listUtilisateur";
//			    }
//			  

//			  @RequestMapping(path = {"/edit", "/edit/{id}"})
//				public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
//										throws RecordNotFoundException 
//				{
//					if (id.isPresent()) {
//						EmployeeEntity entity = service.getEmployeeById(id.get());
//						model.addAttribute("employee", entity);
//					} else {
//						model.addAttribute("employee", new EmployeeEntity());
//					}
//					return "add-edit-employee";
//				}
	/*
	 * @RequestMapping(value = "/listUtilisateur", method = RequestMethod.GET)
	 * public String list(Model model, Pageable pageable) { Page<Utilisateur>
	 * demandePage = user.findAll(pageable); PageWapper<Utilisateur> page = new
	 * PageWapper<Utilisateur>(demandePage, "/listUtilisateur");
	 * model.addAttribute("listUtilisateur", page.getContent());
	 * model.addAttribute("page", page); return "user"; }
	 */

	/*
	 * @DeleteMapping("/listUtilisateur/{id}") public ResponseEntity<?>
	 * deleteUser(@PathVariable(value ="id")Long id_Utilisateur) { Utilisateur u =
	 * user.findById(id_Utilisateur).orElseThrow();
	 * 
	 * user.delete(u); return ResponseEntity.ok().build(); }
	 */

	/*
	 * @PostMapping(value= "/Utilisateur/delete/{id}") public String
	 * deleteUser(@PathVariable Long id) { user.deleteById(id); return "user"; }
	 */

	/*
	 * @RequestMapping(value="/Utilisateur/delete/{id}") public String
	 * DelatUserById(@PathVariable Long id) { Long idd =new Long(2);
	 * user.deletUsreById(idd); return "user"; }
	 */

}
