/**
 * 
 */
package com.sindico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Authority.
 * 
 * @author Lucas
 */
@Entity
@Table(name = "AUTHORITY")
public class Authority implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -5330797635489070797L;

	/** The id. */
	@Id
	@GeneratedValue
	private Long				id;

	/** The authority. */
	@Column(name = "AUTHORITY", length = 60, nullable = false, unique = true)
	@NotNull
	private String				authority;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the authority.
	 * 
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 * 
	 * @param authority
	 *            the new authority
	 */
	public void setAuthority(final String authority) {
		this.authority = authority;
	}

}
