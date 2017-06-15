/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: �豸��ϸ��Ϣ��������֣�
 * ��������: �豸��ϸ��Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22081VO extends BaseVO implements Serializable{
	
	/** �豸��Ϣ������� */
	protected List<IG688Info> entityDataList;
	
	/** ��Ӱ����豸��Ϣ */
	protected Map<String,List<IG749Info>> entityItemVWInfoMap;
	
	/**
	 * ���캯��
	 * @param entityData���豸��Ϣ�������
	 */
	public IGASM22081VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ���캯��
	 */
	public IGASM22081VO() {
		super();
	}

	/**
	 * �豸��Ϣ�������ȡ��
	 * @return �豸��Ϣ�������
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

	/**
	 * �豸��Ϣ��������趨
	 * @param entityDataList�豸��Ϣ�������
	 */
	public void setEntityDataList(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}

	/**
	 * ��Ӱ����豸��Ϣȡ��
	 * @return entityItemVWInfoMap��Ӱ����豸��Ϣ
	 */
	public Map<String, List<IG749Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * ��Ӱ����豸��Ϣ�趨
	 * @param entityItemVWInfoMap��Ӱ����豸��Ϣ
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<IG749Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}
	
}
