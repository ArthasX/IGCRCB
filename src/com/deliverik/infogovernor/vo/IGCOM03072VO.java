/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * ��������ϢVO
 */
@SuppressWarnings("serial")
public class IGCOM03072VO extends BaseVO implements Serializable {
	
	/**
	 * ������������Ϣ
	 */
	protected String ccategory;
	/**
	 * ��������Ϣ�������
	 */
	protected List<IGCOM03073VO> voList;
	

	/**
	 * ��������Ϣ�������ȡ��
	 * @return ��������Ϣ�������
	 */
	public List<IGCOM03073VO> getVoList() {
		return voList;
	}

	/**
	 * ��������Ϣ��������趨
	 * @param voList ��������Ϣ�������
	 */
	public void setVoList(List<IGCOM03073VO> voList) {
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
			this.voList = new ArrayList<IGCOM03073VO>();
		} 
		boolean flag = true;
		for(IGCOM03073VO vo : this.voList) {
			if(ci.getCid().equals(vo.getConfiguration().getCid())) {
				vo.addConfigItem(ci);
				flag = false;
				break;
			}
		}
		if(flag){
			this.voList.add(new IGCOM03073VO(ci));
		}
	}
	
}
