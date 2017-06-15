package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * �豸��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01081VO extends BaseVO implements Serializable{
	
	/** �豸��Ϣ������� */
	protected List<SOC0124Info> entityDataList;

	/**
	 * ���캯��
	 * @param entityData���豸��Ϣ�������
	 */
	public IGCIM01081VO(List<SOC0124Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * �豸��Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<SOC0124Info> getEntityDataList() {
		return entityDataList;
	}

}


