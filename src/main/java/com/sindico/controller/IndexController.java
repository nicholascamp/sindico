/**
 * 
 */
package com.sindico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Lucas
 * 
 */
@Controller
@SessionAttributes
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String getIndex() {
		return "index";
	}

}
