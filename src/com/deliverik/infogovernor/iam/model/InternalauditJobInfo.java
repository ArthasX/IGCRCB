/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
  * ����: ���ù�����ӿ�
  * ��������: ���ù�����ӿ�
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
public interface InternalauditJobInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIajid();

	/**
	 * �ƻ����ȡ��
	 *
	 * @return �ƻ����
	 */
	public String getIajyear();

	/**
	 * ������ĿIDȡ��
	 *
	 * @return ������ĿID
	 */
	public Integer getIajiapid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getIajname();

	/**
	 * ʵ�ʹ�����ʼ����ȡ��
	 *
	 * @return ʵ�ʹ�����ʼ����
	 */
	public String getIajstarttime();

	/**
	 * ʵ�ʹ�����������ȡ��
	 *
	 * @return ʵ�ʹ�����������
	 */
	public String getIajovertime();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getIajdesc();

	/**
	 * �Ǽ�ʱ��ȡ��
	 *
	 * @return �Ǽ�ʱ��
	 */
	public String getIajinserttime();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getIajattkey();

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getIajuserid();
	
	/**
	 * ��ȡ������Ŀ��Ϣʵ��
	 * @return
	 */
	public  InternalauditprjTB getInternalauditprjTB();
}