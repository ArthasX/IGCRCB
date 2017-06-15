package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������ϵ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM07061VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected IG688Info entityItemData;
	
	/** �ʲ����ϵ��Ϣ1 */
	protected List<IG313Info> parEntityItemRelationList;

	/** �ʲ����ϵ��Ϣ2 */
	protected List<IG313Info> cldEntityItemRelationList;

	/**
	 * ���캯��
	 * @param entityItemData��������Ϣ
	 * @param parEntityItemRelationList���ʲ����ϵ��Ϣ1
	 * @param cldEntityItemRelationList���ʲ����ϵ��Ϣ2
	 */
	public IGASM07061VO(IG688Info entityItemData,
			List<IG313Info> parEntityItemRelationList,
			List<IG313Info> cldEntityItemRelationList) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationList = parEntityItemRelationList;
		this.cldEntityItemRelationList = cldEntityItemRelationList;
		
	}
	
	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	/**
	 * �ʲ����ϵ��Ϣ1ȡ��
	 * @return �ʲ����ϵ��Ϣ1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ��Ϣ1����ȡ��
	 * @return �ʲ����ϵ��Ϣ1����
	 */
	public int getParCount() {
		if (parEntityItemRelationList == null) {
			return 0;
		}
		return parEntityItemRelationList.size();
	}

	/**
	 * �ʲ����ϵ��Ϣ2ȡ��
	 * @return �ʲ����ϵ��Ϣ2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}
	
	/**
	 * �ʲ����ϵ��Ϣ2����ȡ��
	 * @return �ʲ����ϵ��Ϣ2����
	 */
	public int getCldCount() {
		if (cldEntityItemRelationList == null) {
			return 0;
		}
		return cldEntityItemRelationList.size();
	}
}


