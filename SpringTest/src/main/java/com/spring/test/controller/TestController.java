package com.spring.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test.exception.ServerSideValidationException;
import com.spring.test.model.TestModel;
import com.spring.test.validation.ValidationUtils;

@Controller
public class TestController {

	@RequestMapping(value = "showMessage", method = RequestMethod.GET)
	public ModelAndView showMessage() {

		return new ModelAndView("showMessage");
	}

	@RequestMapping(value = "validateform", method = RequestMethod.POST)
	// public @ResponseBody String validateForm(@Valid TestBean
	// testModel,BindingResult result, HttpServletResponse
	// response,HttpServletRequest request) throws ValidationException {
	public @ResponseBody String validateForm(@ModelAttribute TestModel testModel, HttpServletResponse response,
			HttpServletRequest request) throws ServerSideValidationException {
		String filter = "";

		System.out.println("before");
		System.out.println(testModel.getComments());
		System.out.println(testModel.getNumber());
		System.out.println(testModel.getDecimal());
		System.out.println(testModel.getDate());
		System.out.println(testModel.getFilepath());
		System.out.println(testModel.getFilter());
		
		
		
		ValidationUtils.validateModel(testModel);

		
		System.out.println("---------------------------------------------------");
		System.out.println("after");
		System.out.println(testModel.getComments());
		System.out.println(testModel.getNumber());
		System.out.println(testModel.getDecimal());
		System.out.println(testModel.getDate());
		System.out.println(testModel.getFilepath());
		System.out.println(testModel.getFilter());
		
		
		return filter;
	}
	
	
	@RequestMapping(value = "errorPage", method = RequestMethod.GET)
	public ModelAndView errorPage() {
		System.out.println("inside error apge");
		return new ModelAndView("errorPage");
	}
	
	
}