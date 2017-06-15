/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;

/**
 * ����: ��CI��Ϣ��������֣�
 * ��������: ��CI��Ϣ��������֣�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02131VO extends BaseVO implements Serializable{
	
	/** ����ϸ��Ϣ */
	protected List<SOC0138Info> soc0138InfoList;
	
	protected List<SOC0136Info> soc0136infoList;
	
	protected String eilabel;


	public List<SOC0138Info> getSoc0138InfoList() {
		return soc0138InfoList;
	}

	public void setSoc0138InfoList(List<SOC0138Info> soc0138InfoList) {
		this.soc0138InfoList = soc0138InfoList;
	}

	public List<SOC0136Info> getSoc0136infoList() {
		return soc0136infoList;
	}

	public void setSoc0136infoList(List<SOC0136Info> soc0136infoList) {
		this.soc0136infoList = soc0136infoList;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

}
