package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����ҳ�涨����Ϣ
 *
 */
public interface IG126Info  extends BaseModel {

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getPjdid();

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ҳ������ȡ��
	 * 
	 * @return ҳ������
	 */
	public String getPjdtype();

	/**
	 * �Զ���BL����ȡ��
	 * 
	 * @return �Զ���BL����
	 */
	public String getPjdblid();

	/**
	 * ҳ��·��ȡ��
	 * 
	 * @return ҳ��·��
	 */
	public String getPjdurl();

}