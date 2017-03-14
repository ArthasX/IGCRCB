/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.svc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;

/**
 * ������Ϣ����
 */
@SuppressWarnings("serial")
public class IGSVC1301ExcelDTO extends ExcelDTO {
	
	//������������
	protected List<WorkmanagerInfo> wmList;
		
	//���������ѯform
	protected IGDBM1301Form igdbm1301Form;

	/**
	 * @return the wmList
	 */
	public List<WorkmanagerInfo> getWmList() {
		return wmList;
	}

	/**
	 * @param wmList the wmList to set
	 */
	public void setWmList(List<WorkmanagerInfo> wmList) {
		this.wmList = wmList;
	}

	/**
	 * @return the igdbm1301Form
	 */
	public IGDBM1301Form getIgdbm1301Form() {
		return igdbm1301Form;
	}

	/**
	 * @param igdbm1301Form the igdbm1301Form to set
	 */
	public void setIgdbm1301Form(IGDBM1301Form igdbm1301Form) {
		this.igdbm1301Form = igdbm1301Form;
	}	
	
}
