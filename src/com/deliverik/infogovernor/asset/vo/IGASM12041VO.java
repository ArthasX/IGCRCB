package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM12041VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected IG688Info entityItemData;
	
	/** ����������Ϣ */
	protected List<IG002Info> configItemDataList;

	/**
	 * ���캯��
	 * @param entityItemData��������Ϣ
	 * @param configItemDataList������������Ϣ
	 */
	public IGASM12041VO(IG688Info entityItemData,List<IG002Info> configItemDataList) {
		this.entityItemData = entityItemData;
		this.configItemDataList = configItemDataList;
	}
	
	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * ����������Ϣȡ��
	 * @return ����������Ϣ
	 */
	public List<IG002Info> getConfigItemDataList() {
		return configItemDataList;
	}
}


