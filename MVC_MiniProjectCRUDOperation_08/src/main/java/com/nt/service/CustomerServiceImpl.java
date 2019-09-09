package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO dao;

	public CustomerServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CustomerDTO> listStudent() {
		
		//use dao
		List<CustomerBO> lbo=dao.getAll();
		//convert lbo to ldto
		
		List<CustomerDTO> ldto=new ArrayList<CustomerDTO>();
		
		for(CustomerBO bo:lbo) {
			CustomerDTO dto=new CustomerDTO();
			dto.setCno(bo.getCno());
			dto.setCname(bo.getCname());
			dto.setAddr(bo.getAddr());
			dto.setSal(bo.getSal());
			dto.setMobno(bo.getMobno());
			dto.setBillamt(bo.getBillamt());
			ldto.add(dto);
		}
	
		return ldto;
	}

	@Override
	public CustomerDTO getOneRecord(int cno) {
		//use dao
		CustomerBO bo=dao.updatebySno(cno);
		//copy bo to dto
		CustomerDTO dto=new CustomerDTO();
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}

	@Override
	public String modifyRecord(CustomerDTO dto) {
		CustomerBO bo=null;
		int cnt=0;
		
		bo=new CustomerBO();
		BeanUtils.copyProperties(dto, bo);
		cnt=dao.insertBycno(bo);
		
		if(cnt==0)
			return "record not found for updation";
		else
			return "record found and updated";

	}

	@Override
	public String removeRecord(int cno) {
		int cnt=0;
		//use dao
		cnt=dao.deleteBycno(cno);
		if(cnt==0)
			return "record not found for deletion";
		else
			return "record found and  deleted";
	}

	@Override
	public String insertNewSustomer(CustomerDTO dto) {
		CustomerBO bo=null;
		int cnt=0;
		//convert dto to bo
		bo=new CustomerBO();
		BeanUtils.copyProperties(dto, bo);
		cnt=dao.insertNewRecord(bo);
		
		if(cnt==0)
			return "new user reg failled";
		else
			return "new user successfully inserted";
		
	
	}

}
