/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
 * ����: �ʲ�����ϸ��ӿ�
 * ��������: �ʲ�����ϸ��ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface SOC0138Info extends BaseModel {

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
	public SOC0111TB getEiDomainDefTB();
	
	public Integer getEiid();
	
	/**
	 * �ʲ��ѽ�����ϵ����ȡ��
	 * @return �ʲ��ѽ�����ϵ����
	 */
	public String getEircount();
}
