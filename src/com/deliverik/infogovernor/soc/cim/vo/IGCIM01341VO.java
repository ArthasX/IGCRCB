package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * FS��ϵ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01341VO extends BaseVO implements Serializable{
	/**
	 * FS��ϵ��ѡ�б�
	 */
	protected List<SOC0118Info> entityItemList;
	
	/**
	 * FS��ϵ�Ѿ�ѡ�б�
	 */
	protected List<SOC0118Info> entityItemedList;

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	public List<SOC0118Info> getEntityItemedList() {
		return entityItemedList;
	}

	public void setEntityItemedList(List<SOC0118Info> entityItemedList) {
		this.entityItemedList = entityItemedList;
	}
	
	
	
}


