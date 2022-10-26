package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.User;
import net.javaguides.sms.service.StudentService;
import net.javaguides.sms.service.UserService;

@Controller
public class UserController {

private UserService userService;
private StudentService studentService;


public UserController(UserService userService) {
super();
this.userService = userService;
}



// handler method to handle list students and return mode and view
/*@GetMapping("/use")
public String listUsers(Model model) {
model.addAttribute("use", userService.getAllUsers());
return "students";
}

/*@GetMapping("/users/view_user")
public String viewUser(Model model) {
model.addAttribute("students", studentService.getAllStudents());

return "view_user";
}



@PostMapping("/users/{id}")
public String updateStudent(@PathVariable Long id,
@ModelAttribute("user") User user,
Model model) {

// get student from database by id
Student existingStudent = studentService.getStudentById(id);

User newuser = null;
newuser.setId(existingStudent.getId());
newuser.setCategory(existingStudent.getCategory());
newuser.setPrice(existingStudent.getPrice());
newuser.setSkuid(existingStudent.getSkuid());
newuser.setTitle(existingStudent.getTitle());
newuser.setDiscription(existingStudent.getDiscription());
newuser.setQuantity(user.getQuantity());
// save updated student object
userService.updateUser(newuser);
return "redirect:/view_user";
}*/


}