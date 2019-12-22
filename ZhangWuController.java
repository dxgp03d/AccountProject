package controller;

import java.util.List;

import domain.ZhangWu;
import service.ZhangWuService;

public class ZhangWuController {
	
	private ZhangWuService service = new ZhangWuService();
	
	
	public void deleteZhangWu(int zwid){
		service.deleteZhangWu(zwid);
	}
	
	
	public void editZhangWu(ZhangWu zw){
		service.editZhangWu(zw);
	}
	
	public void addZhangWu(ZhangWu zw){
		service.addZhangWu(zw);
	}
	
	
	
	public List<ZhangWu> select(String startDate, String endDate){
		return service.select(startDate, endDate);
		
	}
	
	
	
	public List<ZhangWu> selectAll(){
		return service.selectAll();
		
	}

}
