/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����߰�ť������Ϣ����ͼ���������ӿ�
  * ��������: �����߰�ť������Ϣ����ͼ���������ӿ�
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public interface IG221SearchCond {
	
	public String getPbdname();
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPpbdid();

	/**
	 * �����߶���IDȡ��
	 *
	 * @return �����߶���ID
	 */
	public String getPpdid();

	/**
	 * ��ť����IDȡ��
	 *
	 * @return ��ť����ID
	 */
	public String getPbdid();

	/**
	 * ��ť��ʾ����ȡ��
	 *
	 * @return ��ť��ʾ����
	 */
	public String getPpbdname();

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPpbddesc();

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getPpbdauth();
	
	/**
	 * �ڵ���Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPsdid();
}