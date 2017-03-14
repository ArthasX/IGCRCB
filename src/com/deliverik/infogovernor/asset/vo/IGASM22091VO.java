/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: �豸��ϸ��Ϣ��������֣�
 * ��������: �豸��ϸ��Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22091VO extends BaseVO implements Serializable{
	/** �豸��Ϣ */
	protected IG688Info entityItemData;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	
	
	
	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM22091VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	
	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public IG688Info getEntityItemData() {
		return entityItemData;
	}


	/**
	 * �豸��Ϣ�趨
	 * @param entityItemData�豸��Ϣ
	 */
	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}


	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}


	/**
	 * �ʲ��汾�б��趨
	 * @param configItemVersionTime�ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * �ʲ���������Ϣ��������趨
	 * @param configItemVWInfoMap�ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * �豸������������ȡ��
	 * @return �豸������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �豸�������������趨
	 * @param eiorgname�豸������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 * @param flagȨ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	

}
