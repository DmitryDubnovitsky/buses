package com.efftech.spring.domain;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name = Image.NamedQuery.Image_FIND_ALL, query = "from Image"),
	@NamedQuery(name = Image.NamedQuery.Image_FIND_BY_ID, query = "from Image where id= :id")
})
@NamedNativeQueries({ 
	@NamedNativeQuery(name = Image.NamedQuery.Image_FIND_BY_PRICE, query = "select * from files_upload,bus where(bus.id=files_upload.id and  bus.price < :price)", resultClass = Image.class),
	@NamedNativeQuery(name = Image.NamedQuery.Image_FIND_BY_MANUF, query = "select * from files_upload,bus where (bus.id=files_upload.id and bus.manufacturer like :manufacturer)", resultClass = Image.class),
	@NamedNativeQuery(name = Image.NamedQuery.Image_FIND_BY_SEASON, query = "select * from files_upload where id in(select id from bus where bus.season = :season)", resultClass = Image.class),
	@NamedNativeQuery(name = Image.NamedQuery.Image_FIND_BY_SIZE, query = "select * from files_upload,bus where (bus.id=files_upload.id and bus.size like :size and bus.proportion like :proportion and bus.diameter like :diameter)", resultClass = Image.class)
	})

@Entity
@Table(name = "files_upload")
public class Image {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
	
	@Column(name = "name")
    private String imageName;
	
    @Column(name = "data")
    private byte[] data;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Bus bus;
    
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	} 

	public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
    public static class NamedQuery {
		public static final String Image_FIND_ALL = "Image.findAll";
		public static final String Image_FIND_BY_ID = "Image.findById";
		public static final String Image_FIND_BY_MANUF= "Image.findbyManuf";
		public static final String Image_FIND_BY_SIZE="Image.findBySize";
		public static final String Image_FIND_BY_PRICE= "Image.findbyPrice";
		public static final String Image_FIND_BY_SEASON= "Image.findbySeason";
	}
}