/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
  * ����: ȱʡ�����߰�ť�����ӿ�
  * ��������: ȱʡ�����߰�ť�����ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG725Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPdbdid();

	/**
	 * ���״̬IDȡ��
	 *
	 * @return ���״̬ID
	 */
	public String getPsdid();

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
	public String getPdbdname();

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPdbddesc();

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getPdbdauth();
	
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
	
	public IG900TB getProcessButtonDefTB();

}