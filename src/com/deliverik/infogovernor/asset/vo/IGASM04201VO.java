/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ��ͬӦ����Ǽǣ֣�
 * ��������: ��ͬӦ����Ǽǣ֣�
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM04201VO extends BaseVO implements Serializable {
	
	
	/** ��ͬӦ����Ǽ���Ϣ������� */
	protected List<IG499Info> entityItemCompactVWList;

	/**
	 * ��ͬӦ����Ǽ���Ϣ�������ȡ��
	 *
	 * @return entityItemCompactVWList ��ͬӦ����Ǽ���Ϣ�������
	 */
	public List<IG499Info> getEntityItemCompactVWList() {
		return entityItemCompactVWList;
	}

	/**
	 * ��ͬӦ����Ǽ���Ϣ��������趨
	 *
	 * @param entityItemCompactVWList ��ͬӦ����Ǽ���Ϣ�������
	 */
	public void setEntityItemCompactVWList(
			List<IG499Info> entityItemCompactVWList) {
		this.entityItemCompactVWList = entityItemCompactVWList;
	}
	
}
