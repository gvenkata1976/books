package com.library.common.validations;

import java.util.Optional;

import com.library.common.ResourceNotFoundException;

public class Validations {

	public static void notNull(Object obj) {
		Optional<Object> opWallet = Optional.ofNullable(obj);
		opWallet.orElseThrow(() -> new ResourceNotFoundException(""));
	}
}
