package com.spring.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test.Exception.ServerSideValidationException;
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
			HttpServletRequest request) {
		String filter = "";
		try {

		ValidationUtils.validateModel(testModel);

		filter = testModel.getFilter();
		System.out.println(filter);
		/* } */
		
		}
		catch( ServerSideValidationException e )
		{
			
		}
		return filter;
	}
}