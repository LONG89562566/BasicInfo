package com.info.admin.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.info.admin.controller.base.BaseController;

@Controller
@RequestMapping("/admin")
public class MainController extends BaseController {

	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "main";
	}
}