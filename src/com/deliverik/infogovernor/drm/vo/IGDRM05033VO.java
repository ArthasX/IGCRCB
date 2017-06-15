/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * ��������ϢVO
 */
@SuppressWarnings("serial")
public class IGDRM05033VO extends BaseVO implements Serializable {
	
	/**
	 * ������������Ϣ
	 */
	protected String ccategory;
	/**
	 * ��������Ϣ�������
	 */
	protected List<IGDRM05034VO> voList;
	

	/**
	 * ��������Ϣ�������ȡ��
	 * @return ��������Ϣ�������
	 */
	public List<IGDRM05034VO> getVoList() {
		return voList;
	}

	/**
	 * ��������Ϣ��������趨
	 * @param voList ��������Ϣ�������
	 */
	public void setVoList(List<IGDRM05034VO> voList) {
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
			this.voList = new ArrayList<IGDRM05034VO>();
		} 
		boolean flag = true;
		for(IGDRM05034VO vo : this.voList) {
			if(ci.getCid().equals(vo.getConfiguration().getCid())) {
				vo.addConfigItem(ci);
				flag = false;
				break;
			}
		}
		if(flag){
			this.voList.add(new IGDRM05034VO(ci));
		}
	}
	
}
