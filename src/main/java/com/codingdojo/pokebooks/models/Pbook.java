package com.codingdojo.pokebooks.models;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.PrePersist;

import javax.persistence.PreUpdate;

import javax.persistence.Table;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="pbooks")

public class Pbook {
	
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @NotNull
    
    @Size(min = 5, max = 200)
    
    private String expenseName;
    
    @NotNull
    
    @Size(min = 5, max = 200)
    
    private String description;
    
    @NotNull
    
    @Size(min = 3, max = 40)
    
    private String vendor;
    
    @NotNull
    
    @Min(1)
    
    private double numberOfAmount;
    
    // This will not allow the createdAt column to be updated after creation
    
    @Column(updatable=false)
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    
    private Date updatedAt;
    
    public Pbook() {
    	
    }
    
    public Pbook(String name, String desc, String ven, double amount) {
    	
        this.expenseName = name;
        
        this.description = desc;
        
        this.vendor = ven;
        
        this.numberOfAmount = amount;
        
    }
    
    // other getters and setters removed for brevity
    
    @PrePersist
    
    protected void onCreate(){
    	
        this.createdAt = new Date();
        
    }
    
    @PreUpdate
    
    protected void onUpdate(){
    	
        this.updatedAt = new Date();
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getNumberOfAmount() {
		return numberOfAmount;
	}

	public void setNumberOfAmount(double numberOfAmount) {
		this.numberOfAmount = numberOfAmount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
    
    
    
    
    
}
