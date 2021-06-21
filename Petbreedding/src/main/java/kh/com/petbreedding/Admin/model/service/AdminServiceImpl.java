package kh.com.petbreedding.Admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Admin.model.dao.AdminDao;
import kh.com.petbreedding.BP.model.vo.BPartner;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao aDao;
	
	@Override
	public List<BPartner> waitList() {
		List<BPartner> list = null;
		try {
			list = aDao.waitList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int confirmBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.confirmBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int refuseBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.refuseBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<BPartner> deleteList() {
		List<BPartner> list = null;
		try {
			list = aDao.deleteList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int deleteBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.deleteBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int backBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.backBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
