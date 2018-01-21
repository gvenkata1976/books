package com.library.common;

public interface Endpoints {
	public interface Book {
		String REQUEST_URL = "/book";
		String MAPPING_BOOK_ID = "/{bookId}";
		String PARAM_BOOK_ID = "bookId";
	}
	
	public interface Employee {
		String REQUEST_URL = "/employee";
		String MAPPING_EMPLOYEE_ID = "/{employeeId}";
		String PARAM_EMPLOYEE_ID = "employeeId";
	}

	public interface Wallet {
		String REQUEST_URL = "/wallet";
		String MAPPING_WALLET_ID= "/{walletId}";
		String PARAM_WALLET_ID  = "walletId";
		public interface Card {
			String REQUEST_URL = "/card";
			String MAPPING_CARD_ID = "/{walletId}/card/{cardId}";
			String PARAM_CARD_ID = "cardId";
		}

	}
}
