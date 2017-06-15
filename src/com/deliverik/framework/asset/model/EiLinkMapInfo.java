/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ʵ����·ͼ�ӿ�
  * ��������: ʵ����·ͼ�ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface EiLinkMapInfo extends BaseModel {

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public Integer getDomainid();

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getDomainversion();

	/**
	 * ��·IDȡ��
	 *
	 * @return ��·ID
	 */
	public Integer getLinkid();

	/**
	 * ��·˳��ȡ��
	 *
	 * @return ��·˳��
	 */
	public Integer getLinkorder();

	/**
	 * ʵ��idȡ��
	 *
	 * @return ʵ��id
	 */
	public Integer getEiid();

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getEiname();

	/**
	 * �ʲ������ȡ��
	 *
	 * @return �ʲ������
	 */
	public String getEsyscoding();

	/**
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion();

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion();
	
	/**
	 * ��ͼ���ȡ��
	 *
	 * @return ��ͼ���
	 */
	public String getLinkflag();
	
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCreatetime();
	
	/**
	 * ��·������ʶȡ��
	 *
	 * @return ��·������ʶ
	 */
	public String getEndflag();

}