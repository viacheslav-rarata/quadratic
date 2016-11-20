package com.interview.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.interview.facade.IEquationFacade;

@Controller
public class EquationController {

	@Autowired
	private IEquationFacade equationFacade;

	@RequestMapping(value = "/admin/transaction", method = RequestMethod.GET)
	public String createQuadraticRule(ModelMap map, HttpSession session) {
		return "/jsp/createQuadraticRule";
	}

}
