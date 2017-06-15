package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������ʷ��¼��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM12051VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected IG688Info entityItemData;
	
	/** ����������Ϣ */
	protected List<IG800Info> voDataList;

	/**
	 * ���캯��
	 * @param entityItemData��������Ϣ
	 * @param configItemDataList������������Ϣ
	 */
	public IGASM12051VO(IG688Info entityItemData,List<IG800Info> configItemDataList) {
		this.entityItemData = entityItemData;
		this.voDataList = configItemDataList;
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
	public List<IG800Info> getVoDataList() {
		return voDataList;
	}
}


