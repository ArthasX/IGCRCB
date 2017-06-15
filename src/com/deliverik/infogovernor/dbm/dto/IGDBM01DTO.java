/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;


import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

public class IGDBM01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*����������ͼ*/
	protected List<Integer> pillerYL;
	
	/*��ͼ��Ϣ*/
	protected String maps;
	
	/*��ͼ����*/
	protected String mapname;
	
	/*�����ɹ����Ǳ�*/
	protected int meter;
	
	/*�������*/
	protected int year ;
		
	/*�����·�*/
	protected int month;
	
	/*����¼�*/
	protected int somethings;
	
	/*�������*/
	protected int somequestion;
	
	/*�������ؼ�*/
	protected String monitor;
	
	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;
	
	/*��ǰ����* ���ݸ�ʽ   "�¼�����,��������,�������,��������"*/
	protected String currentWork; 
	
	protected User user;

	public List<Integer> getPillerYL() {
		return pillerYL;
	}

	public void setPillerYL(List<Integer> pillerYL) {
		this.pillerYL = pillerYL;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}

	public String getMapname() {
		return mapname;
	}

	public void setMapname(String mapname) {
		this.mapname = mapname;
	}

	public int getMeter() {
		return meter;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getResultXML() {
		return resultXML;
	}
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	public int getSomethings() {
		return somethings;
	}
	public void setSomethings(int somethings) {
		this.somethings = somethings;
	}
	public int getSomequestion() {
		return somequestion;
	}
	public void setSomequestion(int somequestion) {
		this.somequestion = somequestion;
	}

	public String getCurrentWork() {
		return currentWork;
	}

	public void setCurrentWork(String currentWork) {
		this.currentWork = currentWork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}