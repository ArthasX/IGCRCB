package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * �����¼�������Ϣ
 *
 */
public interface IG413Info  extends BaseModel {

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getPedid();

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ״̬IDȡ��
	 * 
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public String getPedactionid();

	/**
	 * �¼�����ȡ��
	 * 
	 * @return �¼�����
	 */
	public String getPedtype();

	/**
	 * �Զ���BL����ȡ��
	 * 
	 * @return �Զ���BL����
	 */
	public String getPedblid();

	/**
	 * �¼�ִ��˳��ȡ��
	 * 
	 * @return �¼�ִ��˳��
	 */
	public Integer getPedorder();
	
	
	/**
	 * �¼���������ȡ��
	 * 
	 * @return �¼�ִ��˳��
	 */
	public String getPedec();

}