package com.codingdojo.luciano.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=100, message="El nombre debe de ser de al menos 2 caracteres")
	private String name;
	
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninjas> ninjas;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;

	public Dojos() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ninjas> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
	}

	@PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
	
	
}
