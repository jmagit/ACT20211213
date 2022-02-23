package com.example.domains.entities;

import java.util.Set;

import javax.validation.ConstraintViolation;

public interface Entidad<E> {

	Set<ConstraintViolation<EntidadBase<E>>> getErrors();

	String getErrorsMessage();

	boolean isValid();

	boolean isInvalid();

}