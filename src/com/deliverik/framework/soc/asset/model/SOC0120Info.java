/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
  * ����: �������ݰ汾�����ӿ�
  * ��������: �������ݰ汾�����ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0120Info extends BaseModel {

	/**
	 * ����ʵ��IDȡ��
	 *
	 * @return ����ʵ��ID
	 */
	public Integer getImpeiid();

	/**
	 * ����汾ȡ��
	 *
	 * @return ����汾
	 */
	public Integer getImpversion();

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname();

	/**
	 * �����ļ���ȡ��
	 *
	 * @return �����ļ���
	 */
	public String getImpfilename();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getImpcreatetime();
	
	
	/** 
	 * �ʲ�ģ�Ͳ�����ȡ
	 * 
	 */
	public String getEsyscoding();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	/**
	 * ����CI����
	 * @return ����CI����
	 */
	public Integer getImpcitype();
	
	/**
	 * �������������Ϣȡ��
	 * @return �������������Ϣ
	 */
	public SOC0113TB getSoc0113TB();
	
	/**
	 * IPȡ��
	 * 
	 * @return IP
	 */
	public String getImpip();

	/**
	 * �û���ȡ��
	 * 
	 * @return �û���
	 */
	public String getImpuserid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getImppassword();

	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getImpstatus();
	

}