package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * Ӧ����ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01481VO extends BaseVO implements Serializable{
	
	/** Ӧ����Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGCIM01481VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** Ӧ�������������� */
	protected String eiorgname;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * Ӧ����Ϣȡ��
	 * @return Ӧ����Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
}


