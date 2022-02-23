package com.example.domains.entities;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

public abstract class EntidadBase<E> implements Entidad<E> {
	@Override
	public Set<ConstraintViolation<EntidadBase<E>>> getErrors() {
		var val = Validation.buildDefaultValidatorFactory().getValidator();
		return val.validate(this);
	}
	@Override
	public String getErrorsMessage() {
		var errores = getErrors();
		if(errores.size() == 0) return "";
		StringBuilder sb = new StringBuilder("ERRORES: ");
		errores.forEach(item -> sb.append(item.getPropertyPath() + ": " + item.getMessage() + ". "));
		return sb.toString().trim();
	}
	@Override
	public boolean isValid() { return getErrors().size() == 0; }
	@Override
	public boolean isInvalid() { return !isValid(); }
	
}
