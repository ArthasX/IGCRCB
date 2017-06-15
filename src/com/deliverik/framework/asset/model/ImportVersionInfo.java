/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������ݰ汾�����ӿ�
  * ��������: �������ݰ汾�����ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface ImportVersionInfo extends BaseModel {

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
	public EiImportProgrammeTB getEiImportProgrammeTB();
	
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
	
	public IG013TB getEntityItemTB();
	
	/**��ȡ��·ͼ����*/
	public Integer getEircount();
	
	/**��ȡ��������*/
	public Integer getBelongcount();
}