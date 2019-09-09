package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class EmployeeHLO  implements Serializable{
	
	@Id
	@Column(name="eid")
	@Type(type="int")
	//@GenericGenerator(name="gen1",strategy="increment")
	//@GeneratedValue(generator="gen1")
	private int eid;
	
	@Column(name="fname")
	@Type(type="string")
	private String fname;
	
	@Column(name="lname")
	@Type(type="string")
	private String lname;
	
	@Column(name="email")
	@Type(type="string")
	private String email;

}
