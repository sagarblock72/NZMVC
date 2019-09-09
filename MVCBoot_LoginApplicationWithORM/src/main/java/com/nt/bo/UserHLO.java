package com.nt.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="userlist")
@Data
public class UserHLO {
	
	@Column(name="uname")
	@Type(type="string")
	private String user;
	
	@Column(name="passsword")
	@Type(type="string")
	private String pwd;

}
