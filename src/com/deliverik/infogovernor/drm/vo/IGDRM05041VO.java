package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * �ĵ���ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM05041VO extends BaseVO implements Serializable{
	
	/** �ĵ���Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	protected List<SOC0118Info> entityItemList;
	
	/**
	 * @return the entityItemList
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * @param entityItemList the entityItemList to set
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGDRM05041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** �ĵ������������� */
	protected String eiorgname;
	
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
	 * �ĵ���Ϣȡ��
	 * @return �ĵ���Ϣ
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
}

