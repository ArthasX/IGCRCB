/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * ��������ϢVO
 */
@SuppressWarnings("serial")
public class IGCIM12042VO extends BaseVO implements Serializable {
	
	/**
	 * ������������Ϣ
	 */
	protected String ccategory;
	/**
	 * ��������Ϣ�������
	 */
	protected List<IGCIM12043VO> voList;
	

	/**
	 * ��������Ϣ�������ȡ��
	 * @return ��������Ϣ�������
	 */
	public List<IGCIM12043VO> getVoList() {
		return voList;
	}

	/**
	 * ��������Ϣ��������趨
	 * @param voList ��������Ϣ�������
	 */
	public void setVoList(List<IGCIM12043VO> voList) {
		this.voList = voList;
	}

	/**
	 * ������������Ϣȡ��
	 * @return ������������Ϣ
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * ������������Ϣ�趨
	 * @param ccategory ������������Ϣ
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}
	/**
	 * ����ʲ�������
	 * 
	 * @param ci
	 */
	public void addConfigItem(SOC0107Info ci) {
		if(this.voList == null) {
			this.voList = new ArrayList<IGCIM12043VO>();
		} 
		boolean flag = true;
		for(IGCIM12043VO vo : this.voList) {
			if(ci.getCid().equals(vo.getConfiguration().getCid())) {
				vo.addConfigItem(ci);
				flag = false;
				break;
			}
		}
		if(flag){
			this.voList.add(new IGCIM12043VO(ci));
		}
	}
	
}
