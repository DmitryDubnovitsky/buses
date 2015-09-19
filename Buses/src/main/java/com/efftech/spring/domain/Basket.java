package com.efftech.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = Basket.NamedQuery.BASKET_FIND_ALL, query = "from Basket"),
	@NamedQuery(name = Basket.NamedQuery.BASKET_FIND_BY_ID, query = "from Basket where id = :id")
})

@Entity
@Table(name="basket")
public class Basket {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name="size")
	private int size;
	
	@Column(name="proportion")
	private int proportion;
	
	@Column(name="diameter")
	private int diameter;

	@Column(columnDefinition = "enum('winter','summer')")
	@Enumerated(EnumType.STRING)
	private Season season = Season.summer;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="price")
	private float price;
		
	public  Basket() {
	
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

	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public static class NamedQuery {
		public static final String BASKET_FIND_ALL = "Basket.findAll";
		public static final String BASKET_FIND_BY_ID = "Basket.findById";
	}
}