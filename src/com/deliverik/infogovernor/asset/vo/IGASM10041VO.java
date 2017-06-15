package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * �ʲ�����ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM10041VO extends BaseVO implements Serializable{
	

	public IGASM10041VO(){}
	/** �����Ϣ */
	protected IG688Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	protected SOC0124Info socEntityItemVWInfo;
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> socConfigItemVWInfoMap;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM10041VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * �����Ϣȡ��
	 * @return �����Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public SOC0124Info getSocEntityItemVWInfo() {
		return socEntityItemVWInfo;
	}

	public void setSocEntityItemVWInfo(SOC0124Info socEntityItemVWInfo) {
		this.socEntityItemVWInfo = socEntityItemVWInfo;
	}

	public Map<String, List<SOC0129Info>> getSocConfigItemVWInfoMap() {
		return socConfigItemVWInfoMap;
	}

	public void setSocConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> socConfigItemVWInfoMap) {
		this.socConfigItemVWInfoMap = socConfigItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	
}


