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
	public List<Cta> listAll() {
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
	public Cta read(String CM_TYPE) {
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
	public int insertpay(CtaPay pay) {
		int result = -1;
		
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
		
	    try {
	    	result = ctaDao.insertpay(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
	}

	@Override
	public int insertCta(CtaPay pay) {
		int result = -1;
		
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
		
		try {
			result = ctaDao.insertCta(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CtaPay> mycta(String bp_id) throws Exception {
		System.out.println("mycta 조회 들어옴");
		List<CtaPay> list = null;
		try {
			list = ctaDao.mycta(bp_id);
			if(list != null) {
				System.out.println("mycta 있음");
			}else {
				System.out.println("mycta 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
