/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ҳ��תURL����ӿ�
  * ��������: ��ҳ��תURL����ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
public interface IG622Info extends BaseModel {

	/**
	 * ��ҳIDȡ��
	 *
	 * @return ��ҳID
	 */
	public String getHpid();

	/**
	 * ��ҳ����ȡ��
	 *
	 * @return ��ҳ����
	 */
	public String getHplabel();

	/**
	 * ��ҳURLȡ��
	 *
	 * @return ��ҳURL
	 */
	public String getHpurl();

	/**
	 * ��ҳ��ʾ����ȡ��
	 *
	 * @return ��ҳ��ʾ����
	 */
	public String getHptitle();

}