package kh.com.petbreedding.cta.model.dao;

import java.util.List;


import kh.com.petbreedding.cta.model.vo.Cta;

public interface CtaDao {
	
	public List<Cta> listAll() throws Exception;
			
}
