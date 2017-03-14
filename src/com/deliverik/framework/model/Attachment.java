package com.deliverik.framework.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * ������Ϣ
 * </p>
 */

public interface Attachment  extends BaseModel {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getAttid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttkey();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttname();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttdesc();

	/**
	 * �������λ��ȡ��
	 * @return �������λ��
	 */
	public String getAtturl();

}