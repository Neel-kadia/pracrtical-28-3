package com.example.CustomerRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.CustomerRegistration.service.CustomerService;
import com.example.CustomerRegistration.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomer", customerService.getAllCustomers());
		return "Customerlist";
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "CustomerAdd";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		boolean emailResult = customerService.existsEmail(customer.getEmail());
		boolean mobileResult = customerService.existsMobile(customer.getMobile());
		String error = "";
		/*if (mobileResult == true && customer.getId() == 0) {
			error = "Mobile already exists.";
			model.addAttribute("mobileError", error);
			return "CustomerAdd";
		}
		if (mobileResult == true && customer.getId() != 0) {
			Customer cust = customerService.getCustomerById(customer.getId());
			if (cust.getMobile() == customer.getMobile()) {
				error = "new Mobile already exists";
				model.addAttribute("mobileError", error);
				return "CustomerAdd";
			}
		} 
		if (emailResult == true && customer.getId() == 0) {
			error = "Email already exists";
			model.addAttribute("emailError",error);
			return "CustomerAdd";
		}
		if (emailResult == true && customer.getId() != 0) {
			Customer cust = customerService.getCustomerById(customer.getId());
			if(cust.getEmail() != customer.getEmail()) {
				error = "Email already exists";
				model.addAttribute("emailError",error);
				return "CustomerAdd";
			}
		} */
		
		/*if(emailResult == true && customer.getId() == 0) {
			error = "Email already exists";
			model.addAttribute("emailError",error);
			return "CustomerAdd";
		}
		if (mobileResult == true && customer.getId() == 0) {
			error = "Mobile already exists";
			model.addAttribute("mobileError",error);
			return "CustomerAdd";
		}
		if(emailResult == true && customer.getId() != 0) {
			Customer cust = customerService.getCustomerById(customer.getId());
			if (customer.getEmail().equals(cust.getEmail())) {
				customerService.saveCustomer(customer);
				return "redirect:/";
			}
			error = "Email already exists";
			model.addAttribute("emailError", error);
			return "CustomerAdd";
		}
		if (mobileResult == true && customer.getId() != 0) {
			Customer cust = customerService.getCustomerById(customer.getId());
			if (customer.getEmail().equals(cust.getEmail())) {
				customerService.saveCustomer(customer);
				return "redirect:/";
			}
			error = "mobile already exists.";
			model.addAttribute("mobileError", error);
			return "CustomerAdd";
		}
		customerService.saveCustomer(customer);
		return "redirect:/"; */
		
		if (customer.getId() == 0) {
			if (mobileResult == true) {
				error = "Mobile already exists";
				model.addAttribute("mobileError", error);
				return "CustomerAdd";
			}
			if (emailResult == true) {
				error = "Email already exists";
				model.addAttribute("emailError", error);
				return "CustomerAdd";
			}
		}
		if (customer.getId() != 0) {
			Customer cust = customerService.getCustomerById(customer.getId());
			if (mobileResult == true) {
				if (customer.getMobile().equals(cust.getMobile())) {
					customerService.saveCustomer(customer);
					return "redirect:/";
				}
				error = "Mobile already exists";
				model.addAttribute("mobileError", error);
				return "CustomerAdd";
			}
			if (emailResult == true) {
				if (customer.getEmail().equals(cust.getEmail())) {
					customerService.saveCustomer(customer);
					return "redirect:/";
				}
				error = "Email already exists";
				model.addAttribute("emailError", error);
				return "CustomerAdd";
			}
		}
		customerService.saveCustomer(customer);
		return "redirect:/";
		
	}

	@GetMapping("/showFormForUpadte/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "CustomerAdd";
	}

	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") int id) {
		customerService.deleteCustomerById(id);
		return "redirect:/";
	}

}