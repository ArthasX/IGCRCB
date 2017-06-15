/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;

/**
 * ��������VO
 * �޸�ʱ�䣺LuJiayuan 2013/01/31 Ǩ��SOC��������������IGCOM04033VO���ΪIGCOM04034VO
 */
public class IGCOM04034VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String name;
	
	/**
	 * �������ݼ������
	 */
	protected List<IG677Info> processRecordInfoList = new ArrayList<IG677Info>();
	
	/**
	 * �������ݼ������
	 */
	protected List<IG677Info> processRecordInfoListAsc = new ArrayList<IG677Info>();

	public List<IG677Info> getProcessRecordInfoList() {
		return processRecordInfoList;
	}

	public void setProcessRecordInfoList(
			List<IG677Info> processRecordInfoList) {
		this.processRecordInfoList = processRecordInfoList;
	}

	public List<IG677Info> getProcessRecordInfoListAsc() {
		return processRecordInfoListAsc;
	}

	public void setProcessRecordInfoListAsc(
			List<IG677Info> processRecordInfoListAsc) {
		this.processRecordInfoListAsc = processRecordInfoListAsc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public IGCOM04034VO(String name){
		this.name = name ;
	}
}
