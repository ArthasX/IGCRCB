/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����߰�ť������Ϣ����ͼ�ӿ�
  * ��������: �����߰�ť������Ϣ����ͼ�ӿ�
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public interface IG221Info extends BaseModel {

	/**
	 * ��ťIDȡ��
	 *
	 * @return ��ťID
	 */
	public String getPbdid();

	/**
	 * Ĭ�ϰ�ť����ȡ��
	 *
	 * @return Ĭ�ϰ�ť����
	 */
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

	public String getPdbdid();

	public String getPdbdname();

	public String getPdbddesc();

	public String getPdbdauth();
	
	public String getPbdflag();
	
	/**
	 *�Ƿ�У���������0��У��1У��ȡ��
	 */
	public String getCheckrequired();
	
	/**
	 *�Ƿ����¼����ȡ��
	 */
	public String getCheckrecord();
	
	/**
	 *����ҳjs����ȡ��
	 */
	public String getActurl();
}