package com.library.wallet;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.library.domain.Wallet;

@Repository
public interface WalletRepository extends PagingAndSortingRepository<Wallet, BigInteger> {
	Wallet findByIdAndCards(BigInteger walletId, BigInteger cardId);
}
