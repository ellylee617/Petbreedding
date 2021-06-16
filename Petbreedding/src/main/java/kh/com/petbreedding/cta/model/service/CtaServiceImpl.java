package kh.com.petbreedding.cta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.cta.model.dao.CtaDao;
import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

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

	@Override
	public int insertpay(CtaPay pay) throws Exception {
		String CM_CODE = pay.getCM_CODE();
		String BP_ID = pay.getBP_ID();
		
		CM_CODE = CM_CODE.replace("<", "&lt;");
		CM_CODE = CM_CODE.replace("<", "&gt;");
		BP_ID = BP_ID.replace("<", "&lt;");
		BP_ID = BP_ID.replace("<", "&gt;");
		
		//공백처리
		CM_CODE = CM_CODE.replace(" ", "&nbsp;&nbsp;");
		BP_ID = BP_ID.replace(" ", "&nbsp;&nbsp;");
		
		pay.setBP_ID(BP_ID);
		pay.setCM_CODE(CM_CODE);
	    return ctaDao.insertpay(pay);
	}

	@Override
	public int insertCta(CtaPay pay) throws Exception {
		String CM_CODE = pay.getCM_CODE();
		String BP_ID = pay.getBP_ID();
		
		CM_CODE = CM_CODE.replace("<", "&lt;");
		CM_CODE = CM_CODE.replace("<", "&gt;");
		BP_ID = BP_ID.replace("<", "&lt;");
		BP_ID = BP_ID.replace("<", "&gt;");
		
		//공백처리
		CM_CODE = CM_CODE.replace(" ", "&nbsp;&nbsp;");
		BP_ID = BP_ID.replace(" ", "&nbsp;&nbsp;");
		
		pay.setBP_ID(BP_ID);
		pay.setCM_CODE(CM_CODE);
		
		return ctaDao.insertCta(pay);
	}
	
	
}
