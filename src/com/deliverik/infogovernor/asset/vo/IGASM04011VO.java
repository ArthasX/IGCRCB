package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ��ͬ��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM04011VO extends BaseVO implements Serializable{
	
	/** ��ͬ��Ϣ������� */
	protected List<IG688Info> entityDataList;
	
	/** ��ͬ��Ϣ������� */
	protected List<IG499Info> entityItemCompactVWInfoList;
	
	/**
	 * ���췽��
	 */
	public IGASM04011VO() {
		super();
	}

	public List<IG499Info> getEntityItemCompactVWInfoList() {
		return entityItemCompactVWInfoList;
	}

	public void setEntityItemCompactVWInfoList(
			List<IG499Info> entityItemCompactVWInfoList) {
		this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
	}

	/**
	 * ���캯��
	 * @param entityData����ͬ��Ϣ�������
	 */
	public IGASM04011VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * ��ͬ��Ϣ�������ȡ��
	 * @return �ʲ�����Ϣ�������
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

}


