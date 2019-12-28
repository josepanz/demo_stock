package com.developers.demo_stock.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Country {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int id; 
	    
	    @Column
		@NotEmpty
	    @Size(max=50, message="Tamaño no permitido")
	    private String code;
	    
	    @Column
	    @NotEmpty
	    @Size(max=50, message="Tamaño no permitido")
	    private String description;
	    
		@Temporal(TemporalType.DATE)
		@Column
	    private Date creation_date;
	    
		public Country() {
			
		}
		
		@PrePersist
		public void prePersist() {
			creation_date = new Date();
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreation_date() {
			return creation_date;
		}

		public void setCreation_date(Date creation_date) {
			this.creation_date = creation_date;
		}
		
	    
}
