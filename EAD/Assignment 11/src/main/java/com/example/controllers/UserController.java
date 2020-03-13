package com.example.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dtos.UserDto;
import com.example.models.User;
import com.example.models.Vehicle;
import com.example.services.UserService;

/**
 * Controller to implement controller for user related processing
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Checks if user is already logged in
	 * 
	 * @param session
	 * @param res
	 * @return true if logged in or false otherwise
	 */
	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	/**
	 * form processing for user registration
	 * 
	 * @param user
	 * @param errors
	 * @param model
	 * @return
	 */
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("user") User user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "register";
		} else {
			String emailId = user.getEmailId();
			int empId = userService.getUserId(emailId);
			if (empId == -1) {
				int userId = userService.addUser(user);
				model.addAttribute("vehicle", new Vehicle());
				model.addAttribute("userId", userId);
				return "vehicle";
			} else {
				model.addAttribute("alert", "This email is already registered :)");
				return "redirect:login";
			}
		}

	}

	/**
	 * form processing for user login
	 * 
	 * @param user
	 * @param errors
	 * @param model
	 * @return
	 */
	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("userDto") UserDto userDto, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "login";
		} else {
			String emailId = userDto.getEmailId();
			String password = userDto.getPassword();
			int empId = userService.getUserId(emailId);
			if (empId == -1) {
				return "redirect:login";
			} else {
				User user = userService.getUserById(empId);
				if (user.getEmailId().equals(emailId) && user.getPassword().equals(password)) {
					session.setAttribute("empId", empId);
					session.setAttribute("user", user);
					System.out.println(emailId + " " + password);
					return "redirect:display";
				} else {
					return "redirect:login";
				}
			}
		}
	}

	/**
	 * endpoint to get user details from session
	 * 
	 * @param session
	 * @param model
	 * @param res
	 * @return details if registered or redirects to login otherwise
	 */
	@GetMapping("/getUserDetails")
	public String getUserById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			User user = userService.getUserById(empId);
			model.addAttribute("user", user);
			return "showUserDetails";
		} else {
			return "redirect:login";
		}

	}

	/**
	 * form processing to edit user
	 * 
	 * @param user
	 * @param errors
	 * @param session
	 * @return
	 */
	@PostMapping("/editUser")
	public String updateUserDetails(@Valid @ModelAttribute("user") User user, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "showUserDetails";
		} else {
			int empId = (int) session.getAttribute("empId");
			user.setEmpId(empId);
			user.setConfirmPassword(user.getPassword());
			userService.updateUser(user);
			return "redirect:display";
		}

	}

	/**
	 * endpoint to get friends
	 * 
	 * @param model
	 * @param session
	 * @param res
	 * @return showfriends
	 */
	@GetMapping("/getFriends")
	public String getFriends(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			List<User> friends = userService.getFriends(empId);
			model.addAttribute("friends", friends);
			model.addAttribute("user", session.getAttribute("user"));
			return "showfriends";
		} else {
			return "redirect:login";
		}
	}

	/**
	 * endpoint to get profile of a friend
	 * 
	 * @param empId
	 * @param model
	 * @param session
	 * @param res
	 * @return showprofile
	 */
	@GetMapping("getFriend/{empId}")
	public String getFriend(@PathVariable("empId") int empId, Model model, HttpSession session,
			HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			User friend = userService.getUserById(empId);
			model.addAttribute("friend", friend);
			model.addAttribute("user", session.getAttribute("user"));
			return "showprofile";
		} else {
			return "redirect:login";
		}
	}

	/**
	 * this endpoint is to logout user if logged in
	 * 
	 * @param session
	 * @return redirects to home
	 */
	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.removeAttribute("empId");
		session.invalidate();
		return "redirect:home";
	}

	/**
	 * endpoint to upload new profile picture
	 * @param picture
	 * @param session
	 * @param model
	 * @param res
	 * @return display
	 */
	@PostMapping("/upload-profile-picture")
	public String uploadProfilePicture(@RequestParam MultipartFile picture, HttpSession session, Model model,
			HttpServletRequest req, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			String path = session.getServletContext().getRealPath("/");
			String serverPath = "http://localhost:9090/";
			
			String fileExt = FilenameUtils.getExtension(picture.getOriginalFilename());
			User user = (User)session.getAttribute("user");
			 try{  
		        byte barr[]=picture.getBytes();  
		        
		        String address = path+"pictures/"+session.getAttribute("empId")+"."+fileExt;
		        String addressForBrowser = serverPath+"pictures/"+session.getAttribute("empId")+"."+fileExt;
		        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(address));
		        userService.uploadProfilePicture((int)session.getAttribute("empId"), addressForBrowser);
		        
		        user.setProfilePicture(addressForBrowser);
		        session.setAttribute("user", user);
		        
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();      
	        } catch(Exception e) {
	        	System.out.println(e);
	        }  
			
			model.addAttribute("user", user);
			return "redirect:"+req.getHeader("Referer");
		} else {
			return "redirect:login";
		}
	}
}