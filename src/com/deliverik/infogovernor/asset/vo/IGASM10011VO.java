package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * �ʲ�����Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM10011VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ������� */
	protected List<IG688Info> entityDataList;
	protected List<SOC0124Info> socEntityDataList;

	/**
	 * ���캯��
	 * @param entityData���ʲ�����Ϣ�������
	 */
	public IGASM10011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	public IGASM10011VO(){
		
	}
	
	/**
	 * �ʲ�����Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

	public List<SOC0124Info> getSocEntityDataList() {
		return socEntityDataList;
	}

	public void setSocEntityDataList(List<SOC0124Info> socEntityDataList) {
		this.socEntityDataList = socEntityDataList;
	}
	
	

}


