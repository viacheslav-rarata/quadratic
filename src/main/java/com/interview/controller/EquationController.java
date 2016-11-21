package com.interview.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.interview.bean.CoefficientBean;
import com.interview.exception.NegativeDescriminantException;
import com.interview.facade.IEquationFacade;

@Controller
public class EquationController {

	@Autowired
	private IEquationFacade equationFacade;

	@RequestMapping(value = "/resolve", method = RequestMethod.GET)
	public String resolveQuadraticEquation(ModelMap map, HttpSession session) {
		CoefficientBean coefficientBean = new CoefficientBean();
		map.addAttribute("coefficientBean", coefficientBean);
		return "resolveQuadraticEquation";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultQuadraticEquation(@ModelAttribute("coefficientBean") CoefficientBean coefficientBean,
			HttpSession session) {
		String resultPage = "redirect:/show.html";
		try {
			equationFacade.create(coefficientBean);
			session.setAttribute("coefficientBean", coefficientBean);
		} catch (NumberFormatException e) {
			session.setAttribute("error", "Wrong Number Format: " + e.getMessage());
			resultPage = "redirect:/error.html";
		} catch (NegativeDescriminantException e) {
			session.setAttribute("error","Dicriminant iz less than 0: " + e.getClass().getSimpleName());
			resultPage = "redirect:/error.html";
		}
		return resultPage;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(ModelMap map, HttpSession session) {
		return "errorPage";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showResult(ModelMap model, HttpSession session) {
		CoefficientBean coefficientBean = (CoefficientBean) session.getAttribute("coefficientBean");
		model.addAttribute(coefficientBean);
		return "resultPage";
	}
}
