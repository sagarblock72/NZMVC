package com.nt.service;

import java.util.List;

import com.nt.dto.EmpSearchDTO;
import com.nt.dto.EmpSearchresultDTO;

public interface EmpSearchService {
	
	public List<EmpSearchresultDTO> process(EmpSearchDTO dto);

}
