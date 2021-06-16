package kh.com.petbreedding.cta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.cta.model.dao.CtaDao;
import kh.com.petbreedding.cta.model.vo.Cta;

@Service("ctaService")
public class CtaServiceImpl implements CtaService {
	@Autowired
	private CtaDao ctaDao;

	@Override
	public List<Cta> listAll() throws Exception {
		List<Cta> list = null;
		System.out.println("service들어옴");
		try {
			list=ctaDao.listAll();
			System.out.println("리스트들어옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cta read(String CM_TYPE) throws Exception {
		Cta vo = null;
		System.out.println("read service 들어옴");
		try {
			vo = ctaDao.read(CM_TYPE);
			System.out.println("read들어옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
}
