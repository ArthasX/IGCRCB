/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 
 * Description: ��ϳ�����ѯVO
 * 
 */

@SuppressWarnings("serial")
public class IGDRM02011VO extends BaseVO implements Serializable {

	/** �����ʲ�List */
	protected List<SOC0124Info> entityItemVWInfoList ;

	/**
	 * @return the �����ʲ�List
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * @param �����ʲ�List the entityItemVWInfoList to set
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
}
