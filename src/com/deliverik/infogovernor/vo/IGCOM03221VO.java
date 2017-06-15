package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03221VO extends BaseVO implements Serializable{
	
	/** ��������Ϣ */
	protected IG688Info entityItemData;
		
	private Map<String,String> configItem;
			
	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	
	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGCOM03221VO(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	public Map<String, String> getConfigItem() {
		return configItem;
	}

	public void setConfigItem(Map<String, String> configItem) {
		this.configItem = configItem;
	}	
}


