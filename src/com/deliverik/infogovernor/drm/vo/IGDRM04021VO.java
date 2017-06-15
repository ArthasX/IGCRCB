/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ����Դ�Ǽ�VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM04021VO extends BaseVO{

	protected List<SOC0118Info> entityItemList;
	protected List<SOC0118VWInfo> entityVWItemList;
	
	
	/**
	 * @return the entityVWItemList
	 */
	public List<SOC0118VWInfo> getEntityVWItemList() {
		return entityVWItemList;
	}

	/**
	 * @param entityVWItemList the entityVWItemList to set
	 */
	public void setEntityVWItemList(List<SOC0118VWInfo> entityVWItemList) {
		this.entityVWItemList = entityVWItemList;
	}

	/** ҳ�������Json */
	protected String nodeMapJson;

	/**
	 * entityItemList   ȡ��
	 * @return entityItemList entityItemList
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * entityItemList   �趨
	 * @param entityItemList entityItemList
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * nodeMapJson   ȡ��
	 * @return nodeMapJson nodeMapJson
	 */
	public String getNodeMapJson() {
		return nodeMapJson;
	}

	/**
	 * nodeMapJson   �趨
	 * @param nodeMapJson nodeMapJson
	 */
	public void setNodeMapJson(String nodeMapJson) {
		this.nodeMapJson = nodeMapJson;
	}
	
	
	
}
