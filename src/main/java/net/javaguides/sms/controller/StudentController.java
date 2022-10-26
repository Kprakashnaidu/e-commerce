package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Checkout;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.StudentService;
import net.javaguides.sms.service.UserService;

@Controller
public class StudentController {

private StudentService studentService;

private UserService userService;

public StudentController(StudentService studentService, UserService userService) {
super();
this.studentService = studentService;
this.userService=userService;
}

// handler method to handle list students and return mode and view
@GetMapping("/students")
public String listStudents(Model model) {
model.addAttribute("students", studentService.getAllStudents());
return "students";
}



@GetMapping("/students/new")
public String createStudentForm(Model model) {

// create student object to hold student form data
Student student = new Student();
model.addAttribute("student", student);
return "create_student";

}

@PostMapping("/students")
public String saveStudent(@ModelAttribute("student") Student student) {
studentService.saveStudent(student);
return "redirect:/students";
}

//SiteNAme
@GetMapping("/students/site")
public String createSiteForm(Model model) {

// create student object to hold student form data
Student site = new Student();
model.addAttribute("student", site);
return "site_form";

}



@GetMapping("/students/view")
public String viewStudent(Model model) {
model.addAttribute("students", studentService.getAllStudents());
return "view";
}


@GetMapping("/students/reports")
public String createReports(Model model) {

// create student object to hold student form data
Student reports = new Student();
model.addAttribute("student", reports);
return "reports";

}

@GetMapping("/students/edit/{id}")
public String editStudentForm(@PathVariable Long id, Model model) {
model.addAttribute("student", studentService.getStudentById(id));
return "edit_student";
}

@GetMapping("/students/edits/{id}")
public String editUserForm(@PathVariable Long id, Model model) {
model.addAttribute("student", studentService.getStudentById(id));
return "add_cart";
}

@GetMapping("/users/view_user")
public String viewUser(Model model) {
model.addAttribute("students", studentService.getAllStudents());

return "view_user";
}

@GetMapping("/view_cart")
public String viewCart(Model model) {

model.addAttribute("users", userService.userByOrderId());

return "view_cart";
}

@PostMapping("/students/{id}")
public String updateStudent(@PathVariable Long id,
@ModelAttribute("student") Student student,
Model model) {

// get student from database by id
Student existingStudent = studentService.getStudentById(id);
existingStudent.setId(id);
existingStudent.setCategory(student.getCategory());
existingStudent.setSkuid(student.getSkuid());
existingStudent.setTitle(student.getTitle());
existingStudent.setDiscription(student.getDiscription());
existingStudent.setPrice(student.getPrice());

// save updated student object
studentService.updateStudent(existingStudent);
return "redirect:/students";
}

@PostMapping("/student/{id}")
public String updateQty(@PathVariable Long id,
@ModelAttribute("student") Student student,
Model model) {

// get student from database by id
Student existingStudent = studentService.getStudentById(id);
existingStudent.setId(id);
existingStudent.setCategory(student.getCategory());
existingStudent.setSkuid(student.getSkuid());
existingStudent.setTitle(student.getTitle());
existingStudent.setDiscription(student.getDiscription());
existingStudent.setPrice(student.getPrice());
existingStudent.setQuantity(student.getQuantity());

// save updated student object
studentService.updateStudent(existingStudent);
long checkoutId;
Checkout checkout=new Checkout();
try {
 checkoutId =checkout.getId();}
catch(Exception e){ checkoutId=1000;}


User newuser= new User(existingStudent.getCategory(),existingStudent.getSkuid(), existingStudent.getTitle(), existingStudent.getDiscription(),existingStudent.getPrice(),student.getQuantity());
/*newuser.setId(existingStudent.getId());
newuser.setCategory(existingStudent.getCategory());
newuser.setPrice(existingStudent.getPrice());
newuser.setSkuid(existingStudent.getSkuid());
newuser.setTitle(existingStudent.getTitle());
newuser.setDiscription(existingStudent.getDiscription());
newuser.setQuantity(student.getQuantity());*/
// save updated student object
userService.saveUser(newuser);


return "redirect:/users/view_user";


}



// handler method to handle delete student request

@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable Long id) {
studentService.deleteStudentById(id);
return "redirect:/students";
}

}