package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.asset.model.IG342Info;

/**
 * ��������Դ��ͳ�ƽ��VO
 * 
 * @author ����
 *
 */
@SuppressWarnings("serial")
public class IGASM26011VO extends BaseVO implements Serializable{

	/** ��������Դ��ͳ�ƽ�� */
	protected List<IG342Info>  entityItemAndConfigItemVWInfoList;

	/**
	 * ��ȡentityItemAndConfigItemVWInfoList
	 * @return fentityItemAndConfigItemVWInfoList entityItemAndConfigItemVWInfoList
	 */
	public List<IG342Info> getEntityItemAndConfigItemVWInfoList() {
		return entityItemAndConfigItemVWInfoList;
	}

	/**
	 * ����entityItemAndConfigItemVWInfoList
	 * @param entityItemAndConfigItemVWInfoList  entityItemAndConfigItemVWInfoList
	 */
	public void setEntityItemAndConfigItemVWInfoList(
			List<IG342Info> entityItemAndConfigItemVWInfoList) {
		this.entityItemAndConfigItemVWInfoList = entityItemAndConfigItemVWInfoList;
	}
	
}


