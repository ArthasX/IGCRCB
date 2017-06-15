package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;

/**
 * �������ʲ���ϵ��Ϣ
 *
 */
public interface QuartzProcessInfoEntity extends BaseModel {
	
	/**
	*��������������
	*/
	public Integer getQpieid();
	
	/**
	*����ID(QuartzProcessRecord��)
	*/
	public Integer getQprid();

	/**
	*��̬��ID��QuartzProcessInfo��
	*/
	public Integer getQpiid();

	/**
	*�ʲ�ID(QuartzEntityItem��)
	*/
	public Integer getQeiid();
	
	/**
	 * �������ʲ���Ϣ
	 * @return
	 */
	public IG013TB getEntityItemTB();
	
	public SOC0118TB getSoc0118TB();

}
