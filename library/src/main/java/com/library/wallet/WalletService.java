package com.library.wallet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.common.ResourceNotFoundException;
import com.library.common.validations.Validations;
import com.library.domain.Card;
import com.library.domain.Wallet;

@Service
public class WalletService {

	@Autowired
	private WalletRepository repo;

	@Transactional(readOnly = true)
	public List<Wallet> findAll() {
		List<Wallet> target = new ArrayList<Wallet>();
		repo.findAll().forEach(target::add);
		return target;
	}

	@Transactional(readOnly = true)
	public Wallet findOne(String id) {
		Validations.notNull(id);
		Wallet wallet = repo.findOne(new BigInteger(id));
		Validations.notNull(wallet);
		return wallet;
	}

	@Transactional
	public void save(Wallet wallet) {
		Validations.notNull(wallet);
		repo.save(wallet);
	}

	@Transactional
	public void update(String id, Wallet wallet) {
		Validations.notNull(id);
		Validations.notNull(wallet);
		Wallet repoWallet = findOne(id);
		repoWallet.setCards(wallet.getCards());
		repoWallet.setModifiedDate(new Date());
		repo.save(repoWallet);

	}

	@Transactional
	public void delete(String id) {
		Wallet repoWallet = findOne(id);
		repo.delete(repoWallet);
	}

	@Transactional
	public Wallet save(String id, Card card) {
		Wallet wallet = findOne(id);
		wallet.getCards().add(card);
		repo.save(wallet);
		return wallet;
	}

	@Transactional
	public Card findOne(String walletId, String cardId) {
		Validations.notNull(cardId);
		Wallet wallet = findOne(walletId);
		BigInteger cardKey = new BigInteger(cardId);
		Optional<Card> opCard = wallet.getCards().stream().filter(card -> card.getId().equals(cardKey)).findFirst();
		return opCard.orElseThrow(() -> new ResourceNotFoundException(cardId));
	}
}
