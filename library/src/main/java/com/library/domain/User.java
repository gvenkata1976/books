package com.library.domain;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.core.userdetails.UserDetails;

import com.library.common.Tables;

@Entity
@Table(name = Tables.User.TABLE_NAME)
public class User extends AbstractEntityAudit implements UserDetails {
	private static final long serialVersionUID = Tables.SERIAL_VERSION_ID;

	private BigInteger id;
	private String username;
	private String login;
	private String password;
	private Set<Role> authorities;
	private Contact contact;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.User.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) }) 
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = Tables.Role.Columns.ROLE_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	@Override
	public Set<Role> getAuthorities() {
		return authorities;
	}

	@Column(name = Tables.User.Columns.LOGIN)
	public String getLogin() {
		return login;
	}

	@Column(name = Tables.User.Columns.PASSWORD)
	public String getPassword() {
		return password;
	}

	@Column(name = Tables.User.Columns.USER_NAME)
	public String getUsername() {
		return this.username;
	}

	@Column(name = Tables.User.Columns.ACCOUNT_NON_EXPIRED)
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Column(name = Tables.User.Columns.ACCOUNT_NON_LOCKED)
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Column(name = Tables.User.Columns.CREDENTIALS_NON_EXPIRED)
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Column(name = Tables.User.Columns.ENABLED)
	public boolean isEnabled() {
		return this.enabled;
	}

	@OneToOne
	@JoinColumn(name = Tables.Contact.Columns.CONTACT_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Contact getContact() {
		return contact;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<Role> roles) {
		this.authorities = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return " User [ id=" + id + " username=" + username + ", login=" + login + ", password=" + password
				+ ", authorities=" + authorities + ", contact=" + contact + ", accountNonExpired=" + accountNonExpired
				+ ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired
				+ ", enabled=" + enabled + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Address)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		User other = (User) obj;
		Object[] obj1 = array(id, login, password, authorities, contact, accountNonExpired, accountNonLocked,
				credentialsNonExpired, enabled);
		Object[] obj2 = array(other.id, other.login, other.password, other.authorities, other.contact,
				other.accountNonExpired, other.accountNonLocked, other.credentialsNonExpired, other.enabled);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, id, login, password, authorities, contact, accountNonExpired, accountNonLocked,
				credentialsNonExpired, enabled, super.hashCode());
	}
}
