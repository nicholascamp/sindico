/**
 * 
 */
package com.sindico.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sindico.entity.Usuario;

/**
 * @author Lucas
 * 
 */
public class UsuarioValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(final Class clazz) {
		return Usuario.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {

	}

}
