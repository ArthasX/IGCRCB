/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����״̬��ť�����ӿ�
  * ��������: ����״̬��ť�����ӿ�
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
public interface IG156Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPseid();

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPsdid();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getPseactionid();
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getPsebuttonid();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPseorder();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsedec();
	
	/**
     * ��ť����ȡ��
     *
     * @return ��ť����
     */
    public String getPsbdname();

}