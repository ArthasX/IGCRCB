/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ʷ��ѯ�ӿ�
  * ��������: ������ʷ��ѯ�ӿ�
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public interface AssessmentScoreVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPpiid();

	/**
	 * ���б�idȡ��
	 *
	 * @return ���б�id
	 */
	public Integer getPiid();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPivarname();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivarlabel();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivartype();

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid();

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public String getRoleid();

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getUserid();

	/**
	 * ˽�б�ֵȡ��
	 *
	 * @return ˽�б�ֵ
	 */
	public String getPpivalue();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOrgid();

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getUsername();
	
	/**
	 * ppicommentȡ��
	 */
	public String getPpicommect();

}