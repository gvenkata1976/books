package com.library.wallet;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.common.Endpoints;
import com.library.common.ResourceNotFoundException;
import com.library.domain.Card;
import com.library.domain.ResponseError;
import com.library.domain.Wallet;

@RestController
@RequestMapping(Endpoints.Wallet.REQUEST_URL)
public class WalletEndpoint {
	@Autowired
	private WalletService service;

	@GetMapping
	public ResponseEntity<List<Wallet>> list() {
		List<Wallet> list = service.findAll();
		ResponseEntity<List<Wallet>> response = new ResponseEntity<List<Wallet>>(list, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = Endpoints.Wallet.MAPPING_WALLET_ID)
	public ResponseEntity<Wallet> getWallet(@PathParam(value = Endpoints.Wallet.PARAM_WALLET_ID) String walletId) {
		Wallet wallet = service.findOne(walletId);
		ResponseEntity<Wallet> response = new ResponseEntity<Wallet>(wallet, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = Endpoints.Wallet.Card.MAPPING_CARD_ID)
	public ResponseEntity<Card> getCard(@PathParam(value = Endpoints.Wallet.PARAM_WALLET_ID) String walletId,
			@PathParam(value = Endpoints.Wallet.Card.PARAM_CARD_ID) String cardId) {
		Card card = service.findOne(walletId, cardId);
		ResponseEntity<Card> response = new ResponseEntity<Card>(card, HttpStatus.OK);
		return response;
	}

	@PostMapping
	public ResponseEntity<Wallet> save(@RequestBody Wallet wallet) {
		service.save(wallet);
		ResponseEntity<Wallet> response = new ResponseEntity<Wallet>(wallet, HttpStatus.OK);
		return response;
	}

	@PostMapping(value = Endpoints.Wallet.MAPPING_WALLET_ID)
	public ResponseEntity<Wallet> addCard(@PathParam(value = Endpoints.Wallet.PARAM_WALLET_ID) String id,
			@RequestBody Card card) {
		Wallet wallet = service.save(id, card);
		ResponseEntity<Wallet> response = new ResponseEntity<Wallet>(wallet, HttpStatus.OK);
		return response;
	}

	@PutMapping(value = Endpoints.Wallet.MAPPING_WALLET_ID)
	public ResponseEntity<Void> update(@PathParam(value = Endpoints.Wallet.PARAM_WALLET_ID) String id,
			@RequestBody Wallet wallet) {
		service.update(id, wallet);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = Endpoints.Wallet.MAPPING_WALLET_ID)
	public ResponseEntity<Void> delete(@PathParam(value = Endpoints.Wallet.PARAM_WALLET_ID) String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	private static final Logger logger = LoggerFactory.getLogger(WalletEndpoint.class);

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ResponseError> handleException(ResourceNotFoundException ex) {
		logger.error(ex.getCode(), ex);
		ResponseError error = new ResponseError();
		error.setCode(ex.getCode());
		error.setMessage(HttpStatus.NOT_FOUND.name());
		ResponseEntity<ResponseError> response = new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
		return response;

	}
}
