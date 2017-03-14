/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ؼ�¼��ӿ�
  * ��������: ���ؼ�¼��ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface IgdocdownInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getDdid();

	/**
	 * �ĵ��ʲ�IDȡ��
	 *
	 * @return �ĵ��ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getUserid();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getDowntime();

	/**
	 * ����λ��ȡ��
	 *
	 * @return ����λ��
	 */
	public String getDownlocation();


	public void setEiid(Integer eiid);

	public void setUserid(String userid) ;


	public void setDowntime(String downtime);

	public void setDownlocation(String downlocation);

	public void setFingerprint(String fingerprint);
}