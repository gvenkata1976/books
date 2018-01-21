package com.library.domain;

import java.math.BigInteger;
import java.sql.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.common.Tables;

@Entity
@Table(name = Tables.Employee.TABLE_NAME)
public class Employee extends AbstractEntityAudit {
	private BigInteger id;
	private String firstName;
	private String lastName;
	private Date dateOfJoin;
	private Short totalExperience;
	private Set<Address> address;
	private Employee manager;
	private String bloodGroup;
	private String designation;
	private Branch branch;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Tables.Sequences.SEQUENCE_GENERATOR)
	@GenericGenerator(name = Tables.Sequences.SEQUENCE_GENERATOR, strategy = Tables.Sequences.GENERATOR_STRATEGY, parameters = {
			@Parameter(name = Tables.Sequences.Parameters.SEQUENCE_NAME, value = Tables.Employee.SEQUENCE_NAME),
			@Parameter(name = Tables.Sequences.Parameters.INITIAL_VALUE, value = Tables.Sequences.INITIAL_VALUE),
			@Parameter(name = Tables.Sequences.Parameters.INCREMENT_SIZE, value = Tables.Sequences.INCREMENT_SIZE) })
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = Tables.Address.Columns.ADDRESS_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Set<Address> getAddress() {
		return address;
	}

	@Column(name = Tables.Employee.Columns.BLOOD_GROUP)
	public String getBloodGroup() {
		return bloodGroup;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Tables.Branch.Columns.BRANCH_ID, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Branch getBranch() {
		return branch;
	}

	@Column(name = Tables.Employee.Columns.DATE_OF_JOIN)
	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	@Column(name = Tables.Employee.Columns.DESIGNATION)
	public String getDesignation() {
		return designation;
	}

	@Column(name = Tables.Employee.Columns.FIRST_NAME)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = Tables.Employee.Columns.LAST_NAME)
	public String getLastName() {
		return lastName;
	}

	@Column(name = Tables.Employee.Columns.TOTAL_EXPERIENCE)
	public short getTotalExperience() {
		return totalExperience;
	}

	@ManyToOne
	@JoinColumn(name = Tables.Employee.Columns.MANAGER_ID, nullable = true, foreignKey = @ForeignKey(name = Tables.FOREIGN_KEY_NONE))
	public Employee getManager() {
		return manager;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTotalExperience(short totalExperience) {
		this.totalExperience = totalExperience;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfJoin="
				+ dateOfJoin + ", totalExperience=" + totalExperience + ", address=" + address + ", manager=" + manager
				+ ", bloodGroup=" + bloodGroup + ", designation=" + designation + ", branch=" + branch + "]";
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, id, firstName, lastName, dateOfJoin, totalExperience, address, manager, bloodGroup,
				designation, branch, super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Employee)) {
			return false;
		}

		if (!super.equals(obj)) {
			return false;
		}
		Employee other = (Employee) obj;
		Object[] obj1 = array(id, firstName, lastName, dateOfJoin, totalExperience, address, manager, bloodGroup,
				designation, branch);
		Object[] obj2 = array(other.id, other.firstName, other.lastName, other.dateOfJoin, other.totalExperience,
				other.address, other.manager, other.bloodGroup, other.designation, other.branch);
		return java.util.Arrays.deepEquals(obj1, obj2);
	}

}
