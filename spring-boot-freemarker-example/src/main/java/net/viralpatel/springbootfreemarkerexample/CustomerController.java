package net.viralpatel.springbootfreemarkerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String index(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("customers", customerService.findAll());

		return "index";
	}

	@PostMapping("/add")
	public String add(Customer customer) {
		
		customerService.add(customer);
		
		return "redirect:/";
	}

	@GetMapping("/delete/{customerId}")
	public String delete(@PathVariable int customerId) {

		customerService.remove(customerId);

		return "redirect:/";
	}

}
