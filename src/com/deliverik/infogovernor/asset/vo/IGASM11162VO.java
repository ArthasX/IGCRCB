package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;

/**
 * �豸������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11162VO extends BaseVO implements Serializable{
	
	/** �豸������Ϣ */
	protected SOC0107Info entityData;

	/**
	 * ���캯��
	 * @param entityItemData���豸������Ϣ
	 */
	public IGASM11162VO(SOC0107Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public SOC0107Info getEntityData() {
		return entityData;
	}
	
	/**
	 * �豸���ø�����Ϣ��ʶȡ��
	 * @return �豸���ø�����Ϣ��ʶ
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


