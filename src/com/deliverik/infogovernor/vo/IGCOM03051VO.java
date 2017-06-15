package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * �ʲ����ϵ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03051VO extends BaseVO implements Serializable{
	

	/** �豸��Ϣ */
	protected IG688Info entityItemData;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	
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
	 * @param entityItemData���豸��Ϣ
	 * @param parEntityItemRelationMap���ʲ����ϵ��Ϣ1
	 * @param cldEntityItemRelationList���ʲ����ϵ��Ϣ2
	 * @param parCount���ʲ����ϵ��Ϣ1����
	 * @param cldCount���ʲ����ϵ��Ϣ2����
	 */
	public IGCOM03051VO(IG688Info entityItemData,
			Map<String,List<IG313Info>> parEntityItemRelationMap) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}
	
	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param username �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

}


