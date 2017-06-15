/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.infogovernor.risk.form.IGRIS0501Form;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;


/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9�½� 
 * 			
 * @Version V1.0
 */
public class IGRIS05DTO {

	/**���ͳ�Ʋ�ѯFORM*/
	protected IGRIS0501Form igris0501Form;
	
	/**���ͳ�Ʋ�ѯ����*/
	protected List<CheckWorkConutVWInfo> checkWorkConutList;
	
	/**�����map����*/
	protected Map<String, List<CheckWorkConutVWInfo>> checkWorkConutmap;
	
	/**���*/
	protected Map<Integer,String> mapType;
	
	/**�����map����*/
	protected Map<String, Map<String,List<CheckWorkConutVWInfo>>> checkExcelWorkConutmap;
	
	/**���*/
	protected Map<String,Map<Integer,String>> mapTypeExcel;
	
	/** 1��ѯ 2����*/
	protected String flag;

	/**
	 * ���ȡ��
	 * @return mapType ���
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * ����趨
	 * @param mapType ���
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}

	/**
	 * ���ͳ�Ʋ�ѯFORMȡ��
	 * @return igris0501Form ���ͳ�Ʋ�ѯFORM
	 */
	public IGRIS0501Form getIgris0501Form() {
		return igris0501Form;
	}

	/**
	 * ���ͳ�Ʋ�ѯFORM�趨
	 * @param igris0501Form ���ͳ�Ʋ�ѯFORM
	 */
	public void setIgris0501Form(IGRIS0501Form igris0501Form) {
		this.igris0501Form = igris0501Form;
	}

	/**
	 * checkWorkConutListȡ��
	 * @return checkWorkConutList checkWorkConutList
	 */
	public List<CheckWorkConutVWInfo> getCheckWorkConutList() {
		return checkWorkConutList;
	}

	/**
	 * checkWorkConutList�趨
	 * @param checkWorkConutList checkWorkConutList
	 */
	public void setCheckWorkConutList(List<CheckWorkConutVWInfo> checkWorkConutList) {
		this.checkWorkConutList = checkWorkConutList;
	}


	/**
	 * �����map����ȡ��
	 * @return checkWorkConutmap �����map����
	 */
	public Map<String, List<CheckWorkConutVWInfo>> getCheckWorkConutmap() {
		return checkWorkConutmap;
	}

	/**
	 * �����map�����趨
	 * @param checkWorkConutmap �����map����
	 */
	public void setCheckWorkConutmap(
			Map<String, List<CheckWorkConutVWInfo>> checkWorkConutmap) {
		this.checkWorkConutmap = checkWorkConutmap;
	}

	/**
	 * 1��ѯ2����ȡ��
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 1��ѯ2�����趨
	 * @param flag the 1��ѯ2����
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * �����map����ȡ��
	 * @return the checkExcelWorkConutmap
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getCheckExcelWorkConutmap() {
		return checkExcelWorkConutmap;
	}

	/**
	 * �����map�����趨
	 * @param checkExcelWorkConutmap the �����map����
	 */
	public void setCheckExcelWorkConutmap(
			Map<String, Map<String, List<CheckWorkConutVWInfo>>> checkExcelWorkConutmap) {
		this.checkExcelWorkConutmap = checkExcelWorkConutmap;
	}

	/**
	 * ���ȡ��
	 * @return the mapTypeExcel
	 */
	public Map<String, Map<Integer, String>> getMapTypeExcel() {
		return mapTypeExcel;
	}

	/**
	 * ����趨
	 * @param mapTypeExcel the ���
	 */
	public void setMapTypeExcel(Map<String, Map<Integer, String>> mapTypeExcel) {
		this.mapTypeExcel = mapTypeExcel;
	}
}
