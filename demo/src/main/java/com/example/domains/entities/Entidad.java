package com.example.domains.entities;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

public abstract class Entidad<E> {
	public Set<ConstraintViolation<Entidad<E>>> getErrors() {
		var val = Validation.buildDefaultValidatorFactory().getValidator();
		return val.validate(this);
	}
	public String getErrorsMessage() {
		var errores = getErrors();
		if(errores.size() == 0) return "";
		StringBuilder sb = new StringBuilder("ERRORES: ");
		errores.forEach(item -> sb.append(item.getPropertyPath() + ": " + item.getMessage() + ". "));
		return sb.toString().trim();
	}
	public boolean isValid() { return getErrors().size() == 0; }
	public boolean isInvalid() { return !isValid(); }
	
}
