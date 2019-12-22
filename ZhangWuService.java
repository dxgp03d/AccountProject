package service;

import java.util.List;

import dao.ZhangWuDao;
import domain.ZhangWu;

public class ZhangWuService {
    
	private ZhangWuDao dao = new ZhangWuDao();
	
	
	public void deleteZhangWu(int zwid) {	
		dao.deleteZhangWu(zwid);		
	}

	  	
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	
	
	public void addZhangWu(ZhangWu zw){
		dao.addZhangWu(zw);
	}
	
	
	public List<ZhangWu> select(String startDate, String endDate){
		return dao.select(startDate, endDate);
		
	}
	
	
	public List<ZhangWu> selectAll(){
		return  dao.selectAll();
		
	}







}
