package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03031VO extends BaseVO implements Serializable{
	
	/** ��������Ϣ */
	protected IG688Info entityItemData;
	
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ�������(SOC) */
	//protected Map<String,Map<String,List<ConfigItemVWInfo>>> configInfoMap;
	
	protected Map<String,List<IG002Info>> configInfoMap;
	
	/** �ʲ���Ϣ */
	protected IG013Info entityItem;
	
	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

//	public Map<String, Map<String, List<ConfigItemVWInfo>>> getConfigInfoMap() {
//		return configInfoMap;
//	}
//
//	public void setConfigInfoMap(
//			Map<String, Map<String, List<ConfigItemVWInfo>>> configInfoMap) {
//		this.configInfoMap = configInfoMap;
//	}

	
	
	public Boolean getFlag() {
		return flag;
	}

	public Map<String, List<IG002Info>> getConfigInfoMap() {
		return configInfoMap;
	}

	public void setConfigInfoMap(Map<String, List<IG002Info>> configInfoMap) {
		this.configInfoMap = configInfoMap;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGCOM03031VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	
}


