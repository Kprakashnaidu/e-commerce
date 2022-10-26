package net.javaguides.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Checkout;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.repository.UserRepository;
import net.javaguides.sms.service.CheckoutService;
import net.javaguides.sms.service.StudentService;
import net.javaguides.sms.service.UserService;

@Controller
public class CheckoutController {

	
	private CheckoutService checkoutService;
	private StudentService studentService;
	private UserService userService;
	
	//private UserRepository userRepository;

	public CheckoutController(CheckoutService checkoutService, StudentService studentService, UserService userService ) {
		super();
		this.checkoutService=checkoutService;
		this.studentService=studentService;
		this.userService=userService;
		//this.userRepository = userRepository;
		
		
	}
	
	@GetMapping("/checkout/new")
	public String createStudentForm(Model model) {

	// create student object to hold student form data
	Checkout checkout = new Checkout();
	model.addAttribute("checkout", checkout);
	model.addAttribute("users", userService.userByOrderId());
	return "checkout";

	}
	
	@PostMapping("/checkout")
	public String saveCheckout(@ModelAttribute("checkout") Checkout checkout,  BindingResult bindingResult) {
		checkoutService.saveCheckout(checkout);
		List<User> validusers=userService.userByOrderId();
		
		Long orderId=checkout.getId();
		
		for (User use:validusers) {
			use.setOrderId(orderId);
		    userService.updateUser(use);
		}
		
			
		
	return "redirect:/students";
	}
	
	@GetMapping("/adminReports")
	public String viewOrders(Model model) {
	model.addAttribute("checkout", checkoutService.getAllCheckouts());
	return "reports";
	}
	
	@GetMapping("/AdminOrderDetails")
	public String viewOrderDetails(Model model) {
	model.addAttribute("checkout", checkoutService.getAllCheckouts());
	return "report_detail";
	}

	
}
