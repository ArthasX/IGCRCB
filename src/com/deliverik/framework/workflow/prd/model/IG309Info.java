/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;


/**
  * ����: �����߿��Ӱ�ťʵ��ӿ�
  * ��������: �����߿��Ӱ�ťʵ��ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG309Info {


	/**
	 * ��ť����IDȡ��
	 *
	 * @return ��ť����ID
	 */
	public String getVbid();

	/**
	 * ��ť��ʾ����ȡ��
	 *
	 * @return ��ť��ʾ����
	 */
	public String getVbname();

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getVbdesc();

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getVbauth();
	
	/**
	 * ͼƬ��ȡ��
	 * 
	 * @return ͼƬ��
	 */
	public String getVbimage();
	
	/**
	 *У���¼�Ƿ����ȡ��
	 */
	public String getVbrecord();
	
	/**
	 *����ҳjs����ȡ��
	 */
	public String getVbacturl();

}