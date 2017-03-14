package com.deliverik.infogovernor.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ������������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03032VO extends BaseVO implements Serializable{
	
	/** ������������Ϣ */
	protected IG800Info entityData;

	/**
	 * ���캯��
	 * @param entityItemData��������������Ϣ
	 */
	public IGCOM03032VO(IG800Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public IG800Info getEntityData() {
		return entityData;
	}
	
	/**
	 * ���������ø�����Ϣ��ʶȡ��
	 * @return ���������ø�����Ϣ��ʶ
	 */
	public String getAttachFlag() {
		String attachFlg = "";
		
		if (entityData.getConfiguration() != null) {
			if (StringUtils.isNotEmpty(entityData.getConfiguration().getCcategory())) {
				attachFlg = entityData.getConfiguration().getCcategory().substring(0, 1);
			}
		}
		return attachFlg;
	}
}


