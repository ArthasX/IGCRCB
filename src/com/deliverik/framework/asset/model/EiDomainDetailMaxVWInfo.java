/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;

/**
 * ����: �ʲ�����ϸ���ӿ�
 * ��������: �ʲ�����ϸ���ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDetailMaxVWInfo extends BaseModel {

	/**
	 * �ʲ���IDȡ��
	 *
	 * @return �ʲ���ID
	 */
	public Integer getEiddid();

	/**
	 * �ʲ���汾ȡ��
	 *
	 * @return �ʲ���汾
	 */
	public Integer getEiddversion();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�ID
	 */
	public  String getEiname();

	/**
	 * �ʲ�����汾ȡ��
	 *
	 * @return �ʲ�����汾
	 */
	public Integer getEiImportversion();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/** ����ʱ�� */
	public String getCreatetime();
	
//	/**
//	 * ����Ϣȡ��
//	 * @return ����Ϣ
//	 */
//	public EiDomainDefVW getEiDomainDefVW();
	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public EiDomainDefTB getEiDomainDefTB();
	
	public Integer getEiid();
	
	public IG013TB getEntityItemTB();
	/**��·����*/
	public Integer getEircount();
	/**��������*/
	public Integer getBelongcount();
}