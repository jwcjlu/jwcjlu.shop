package com.rd.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  
@Table(name="t_person") 
public class PersonEntity implements Serializable{
    private static final long serialVersionUID = -4376187124011546736L;  
    
    private Integer id;  
    private String name;  
  
    @Id   @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    @Column(length=50 ,nullable = false , unique = false)  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    @Override  
    public String toString() {  
        return "PersonEntity [id=" + id + ", name=" + name + "]";  
    }  

}
