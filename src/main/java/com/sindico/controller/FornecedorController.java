/**
 * 
 */
package com.sindico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sindico.service.FornecedorService;

/**
 * The Class FornecedorController.
 * 
 * @author Lucas
 */
@Controller
@SessionAttributes
public class FornecedorController {

	/** The fornecedor service. */
	@Autowired
	FornecedorService	fornecedorService;
}
