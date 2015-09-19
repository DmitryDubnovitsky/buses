package com.efftech.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = Factory.NamedQuery.FACTORY_FIND_ALL, query = "from Factory"),
	@NamedQuery(name = Factory.NamedQuery.FACTORY_FIND_BY_ID, query = "from Factory where id = :id")
})

@Entity
@Table(name="factory")
public class Factory {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name="manager")
	private String manager;
	
	public Factory(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	 public static class NamedQuery {
			public static final String FACTORY_FIND_ALL = "Factory.findAll";
			public static final String FACTORY_FIND_BY_ID = "Factory.findById";
		}

}
