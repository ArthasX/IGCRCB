package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseModel;

/**
 * �������ʲ���ϵ��Ϣ
 *
 */
public interface IG731Info extends BaseModel {
	
	/**
	*��������������
	*/
	public Integer getPieid();
	
	/**
	*����ID(Ig500��)
	*/
	public Integer getPrid();

	/**
	*��̬��ID��Ig599��
	*/
	public Integer getPiid();

	/**
	*�ʲ�ID(EntityItem��)
	*/
	public Integer getEiid();
	
	/**
	 * �ʲ��汾��ȡ��
	 * @return eiversion �ʲ��汾��
	 */
	public Integer getEiversion();
	
	/**
	 * �������ʲ���Ϣ
	 * @return
	 */
	public IG013TB getEntityItemTB();
	
	/**
	 * �ʲ���Ϣ��ͼȡ��
	 *
	 * @return entityItemVWTB �ʲ���Ϣ��ͼ
	 */
	public IG688VW getEntityItemVWTB();

}
