/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ״̬��˽�б�ֵ��¼��ӿ�
  * ��������: ״̬��˽�б�ֵ��¼��ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG561VWInfo extends BaseModel {

	/**
	 * ��ˮidȡ��
	 *
	 * @return ��ˮid
	 */
	public Integer getPvlid();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ״̬idȡ��
	 *
	 * @return ״̬id
	 */
	public String getPsdid();

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivarname();

	/**
	 * ����ʾȡ��
	 *
	 * @return ����ʾ
	 */
	public String getPivarlabel();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPivartype();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPivarvalue();

	/**
	 * ����keyȡ��
	 *
	 * @return ����key
	 */
	public String getPiattkey();

	/**
	 * Ȩ��ȡ��
	 *
	 * @return Ȩ��
	 */
	public String getPidaccess();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPidrequired();
	/**
     * �û�id
     * @return �û�id
     */
	public void setPiuserid(String piuserid);
	/**
     * ��id (599) ȡ��
     * @return ��id599
     */
	public Integer getPiid();
	
	/**
	 * �ڵ�����
	 * @return �ڵ�����
	 */
	public String getPsdname();

}