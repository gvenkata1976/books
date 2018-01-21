package com.library.common;

public interface Tables {
	String FOREIGN_KEY_NONE = "none";
	long SERIAL_VERSION_ID = -758295393643775164L;

	public interface Sequences {
		String GENERATOR_STRATEGY = "org.hibernate.id.enhanced.SequenceStyleGenerator";
		String SEQUENCE_GENERATOR = "sequenceGenerator";
		String INITIAL_VALUE = "1";
		String INCREMENT_SIZE = "1";

		public interface Parameters {
			String SEQUENCE_NAME = "sequence_name";
			String INITIAL_VALUE = "initial_value";
			String INCREMENT_SIZE = "increment_size";
		}
	}

	public interface Audit {
		String CREATED_BY = "CREATED_BY";
		String VERSION = "VERSION";
		String CREATED_DATE = "CREATED_DATE";
		String MODIFIED_BY = "MODIFIED_BY";
		String MODIFIED_DATE = "MODIFIED_DATE";
	}

	public interface Wallet {
		String SEQUENCE_NAME = "WALLET_ID_SEQ";
		String TABLE_NAME = "TBL_WALLET";

		public interface Columns {
			String WALLET_ID = "WALLET_ID";
			String CARD_ID = "CARD_ID";

		}
	}

	public interface Card {
		String SEQUENCE_NAME = "CARD_ID_SEQ";
		String TABLE_NAME = "TBL_CARD";

		public interface Columns {
			String CARD_ID = "CARD_ID";
			String CARD_NUMBER = "CARD_NUMBER";
			String CARD_TYPE = "CARD_TYPE";
			String CVV = "CVV";
			String MAX_LIMIT = "MAX_LIMIT";
			String NAME_ON_CARD = "NAME_ON_CARD";
			String DATE_OF_EXPIRY = "DATE_OF_EXPIRY";
		}
	}

	public interface Address {
		String SEQUENCE_NAME = "ADDRESS_ID_SEQ";
		String TABLE_NAME = "TBL_ADDRESS";

		public interface Columns {
			String ADDRESS_ID = "ADDRESS_ID";
			String AREA = "AREA";
			String CITY = "CITY";
			String COUNTRY = "COUNTRY";
			String LANDMARK = "LANDMARK";
			String SURVEY_NUMBER = "SURVEY_NUMBER";
			String POSTAL_CODE = "POSTAL_CODE";
			String REGION = "REGION";
			String STATE = "STATE";
			String STREET = "STREET";
		}
	}

	public interface Book {
		String SEQUENCE_NAME = "BOOK_ID_SEQ";
		String TABLE_NAME = "TBL_BOOK";

		public interface Columns {
			String BOOK_ID = "BOOK_ID";
			String AUTHOR = "AUTHOR";
			String BAR_CODE = "BAR_CODE";
			String CATEGORY = "CATEGORY";
			String COUNT = "COUNT";
			String DISCOUNT = "DISCOUNT";
			String LANGUAGE = "LANGUAGE";
			String BLOOD_GROUP = "BLOOD_GROUP";
			String PRICE = "PRICE";
			String PUBLISHER = "PUBLISHER";
			String STATUS = "STATUS";
		}
	}

	public interface Region {
		String TABLE_NAME = "TBL_REGION";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface SubscriptionType {
		String TABLE_NAME = "TBL_SUBSCRIPTION_TYPE";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface MemberType {
		String TABLE_NAME = "TBL_MEMBER_TYPE";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface IdentityType {
		String TABLE_NAME = "TBL_ID_TYPE";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
			String ISSUED_BY = "ISSUED_BY";
		}
	}

	public interface City {
		String TABLE_NAME = "TBL_CITY";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface State {
		String TABLE_NAME = "TBL_STATE";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface Country {
		String TABLE_NAME = "TBL_COUNTRY";

		public interface Columns {
			String CODE = "CODE";
			String NAME = "NAME";
		}
	}

	public interface Branch {
		String SEQUENCE_NAME = "BRANCH_ID_SEQ";
		String TABLE_NAME = "TBL_BRANCH";

		public interface Columns {
			String BRANCH_ID = "BRANCH_ID";
			String EMAIL = "EMAIL";
			String BRANCH_NAME = "BRANCH_NAME";
			String PHONE_NUMBER = "PHONE_NUMBER";
		}
	}

	public interface Coupon {
		String SEQUENCE_NAME = "COUPON_ID_SEQ";
		String TABLE_NAME = "TBL_COUPON";

		public interface Columns {
			String COUPON_ID = "COUPON_ID";
			String CODE = "CODE";
			String DISCOUNT = "DISCOUNT";
			String PROVIDER = "PROVIDER";
			String TYPE = "TYPE";
		}
	}

	public interface Contact {
		String SEQUENCE_NAME = "CONTACT_ID_SEQ";
		String TABLE_NAME = "TBL_CONTACT";

		public interface Columns {
			String CONTACT_ID = "CONTACT_ID";
			String EMAIL = "PRIMARY_EMAIL";
			String PHONE = "PRIMARY_PHONE";
			String IS_PREFERRED = "IS_PREFERRED";

		}
	}

	public interface Member {
		String SEQUENCE_NAME = "MEMBER_ID_SEQ";
		String TABLE_NAME = "TBL_MEMBER";

		public interface Columns {
			String MEMBER_ID = "MEMBER_ID";
			String BLOOD_GROUP = "BLOOD_GROUP";
			String EMAIL = "EMAIL";
			String ID_PROOF = "ID_PROOF";
			String MEMBER_NAME = "MEMBER_NAME";
			String PHONE = "PHONE";
			String MANAGER_ID = "MANAGER_ID";
			String ADDRESS_ID = "ADDRESS_ID";
		}
	}

	public interface Role {
		String SEQUENCE_NAME = "ROLE_ID_SEQ";
		String TABLE_NAME = "TBL_ROLE";

		public interface Columns {
			String ROLE_ID = "ROLE_ID";
			String AUTHORITY = "AUTHORITY";
			String CODE = "CODE";
		}
	}

	public interface User {
		String SEQUENCE_NAME = "USER_ID_SEQ";
		String TABLE_NAME = "TBL_USER";

		public interface Columns {
			String USER_ID = "USER_ID";
			String LOGIN = "LOGIN";
			String PASSWORD = "PASSWORD";
			String USER_NAME = "USER_NAME";
			String ACCOUNT_NON_EXPIRED = "ACCOUNT_NON_EXPIRED";
			String ACCOUNT_NON_LOCKED = "ACCOUNT_NON_LOCKED";
			String CREDENTIALS_NON_EXPIRED = "CREDENTIALS_NON_EXPIRED";
			String ENABLED = "ENABLED";
		}
	}

	public interface Employee {
		String SEQUENCE_NAME = "EMPLOYEE_ID_SEQ";
		String TABLE_NAME = "TBL_EMPLOYEE";

		public interface Columns {
			String EMPLOYEE_ID = "EMPLOYEE_ID";
			String BLOOD_GROUP = "BLOOD_GROUP";
			String DATE_OF_JOIN = "DATE_OF_JOIN";
			String DESIGNATION = "DESIGNATION";
			String FIRST_NAME = "FIRST_NAME";
			String LAST_NAME = "LAST_NAME";
			String TOTAL_EXPERIENCE = "TOTAL_EXPERIENCE";
			String MANAGER_ID = "MANAGER_ID";

		}

	}
}
