package com.efftech.spring.domain;

import java.util.Vector;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name = Bus.NamedQuery.BUS_FIND_ALL, query = "from Bus"),
	@NamedQuery(name = Bus.NamedQuery.Bus_FIND_BY_ID, query = "from Bus where id = :id") })
@NamedNativeQueries({ 
	@NamedNativeQuery(name = Bus.NamedQuery.Bus_FIND_BY_PRICE, query = "select * from bus where price < :price", resultClass = Bus.class),
	@NamedNativeQuery(name = Bus.NamedQuery.Bus_FIND_BY_MANUF, query = "select * from bus where manufacturer like :manufacturer", resultClass = Bus.class),
	@NamedNativeQuery(name = Bus.NamedQuery.Bus_FIND_BY_SEASON, query = "select * from bus where season = :season", resultClass = Bus.class),
	@NamedNativeQuery(name = Bus.NamedQuery.Bus_FIND_BY_SIZE, query = "select * from bus where (size like :size and proportion like :proportion and diameter like :diameter)", resultClass = Bus.class)
	})

    @Entity
    @Table(name = "bus")
    public class Bus {
	
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
	
	@OneToOne(mappedBy="bus", cascade=CascadeType.ALL)
	private Image user;
	
	public  Bus() {
	
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Image getUser() {
		return user;
	}

	public void setUser(Image user) {
		this.user = user;
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
		public static final String BUS_FIND_ALL = "Bus.findAll";
		public static final String Bus_FIND_BY_ID = "Bus.findById";
		public static final String Bus_FIND_BY_PRICE = "Bus.findByPrice";
		public static final String Bus_FIND_BY_MANUF = "Bus.findByManuf";
		public static final String Bus_FIND_BY_SEASON = "Bus.findBySeason";
		public static final String Bus_FIND_BY_SIZE = "Bus.findBySize";
	}
}