package com.library.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.library.common.Tables;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntityAudit {

	private int version = 0;
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;

	@PreUpdate
	public void preUpdate() {
		modifiedDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		createdDate = now;
		modifiedDate = now;
	}

	@Column(name = Tables.Audit.VERSION)
	@Version
	public int getVersion() {
		return version;
	}

	@Column(name = Tables.Audit.CREATED_BY, nullable = false)
	@CreatedBy
	public String getCreatedBy() {
		return createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Tables.Audit.CREATED_DATE, nullable = false, updatable = false, insertable = true)
	@CreatedDate
	public Date getCreatedDate() {
		return createdDate;
	}

	@Column(name = Tables.Audit.MODIFIED_BY, nullable = false)
	@LastModifiedBy
	public String getModifiedBy() {
		return modifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Tables.Audit.MODIFIED_DATE, nullable = false, updatable = true, insertable = true)
	@LastModifiedDate
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return " AbstractEntityAudit [ version=" + version + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "] ";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof AbstractEntityAudit)) {
			return false;
		}
		AbstractEntityAudit other = (AbstractEntityAudit) obj;
		Object[] obj1 = array(this.version, this.createdDate, this.createdBy, this.modifiedBy, this.modifiedDate);
		Object[] obj2 = array(other.version, other.createdDate, other.createdBy, other.modifiedBy, other.modifiedDate);
		return Arrays.deepEquals(obj1, obj2);
	}

	protected Object[] array(Object... objects) {
		return objects;
	}

	@Override
	public int hashCode() {
		final int HASH = 61 * 7;
		return Objects.hash(HASH, this.version, this.createdDate, this.createdBy, this.modifiedBy, this.modifiedDate);
	}
}
