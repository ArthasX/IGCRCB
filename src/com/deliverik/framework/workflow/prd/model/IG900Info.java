/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̰�ť�����ӿ�
  * ��������: ���̰�ť�����ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG900Info extends BaseModel {

	/**
	 * ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷȡ��
	 *
	 * @return ������01���£�02ȷ�ϣ�ȷ�ϣ�������1��ͷ
	 */
	public String getPbdid();

	/**
	 * ��ťĬ������ȡ��
	 *
	 * @return ��ťĬ������
	 */
	public String getPbdname();

	/**
	 * �Ƿ�ϵͳ������ť��1��0��ȡ��
	 *
	 * @return �Ƿ�ϵͳ������ť��1��0��
	 */
	public String getPbdflag();
	
	/**
	 * ��ť��ʾͼƬ����ȡ��
	 * 
	 * @return ��ť��ʾͼƬ����
	 */
	public String getPbdimage();

}