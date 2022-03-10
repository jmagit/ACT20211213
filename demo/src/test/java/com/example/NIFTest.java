package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.domains.entities.EntidadBase;
import com.example.domains.validators.NIF;
import com.example.domains.validators.NifValidator;

public class NIFTest {

	@Nested
	class NifValidatorTest {
		@ParameterizedTest(name = "Valor: {0}")
		@ValueSource(strings = {"12345678Z", "1234s", "12345678z"})
		@NullSource
		void OKTest(String nif) {
			var val = new NifValidator();
			assertTrue(val.isValid(nif, null));
		}
		@ParameterizedTest(name = "Valor: {0}")
		@ValueSource(strings = {"12345678", "S", "z12345678"})
		@EmptySource
		void KOTest(String nif) {
			var val = new NifValidator();
			assertFalse(val.isValid(nif, null));
		}
	}

	@Nested
	class NifAnotationTest {
		class Entidad extends EntidadBase<Entidad> {
			@NIF
			private String nif;

			public Entidad(String nif) {
				super();
				this.nif = nif;
			}
		}
		@ParameterizedTest(name = "Valor: {0}")
		@ValueSource(strings = {"12345678Z"})
		@NullSource
		void OKTest(String nif) {
			var val = new Entidad(nif);
			assertTrue(val.isValid());
		}
		@ParameterizedTest(name = "Valor: {0}")
		@ValueSource(strings = {"12345678"})
		@EmptySource
		void KOTest(String nif) {
			var val = new Entidad(nif);
			assertTrue(val.isInvalid());
			assertEquals(1, val.getErrors().size());
			assertEquals(nif + " no es un NIF válido.", val.getErrors().stream().findFirst().get().getMessage());
		}
		
	}
}
