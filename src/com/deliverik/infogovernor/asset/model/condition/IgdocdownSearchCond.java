/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ���ؼ�¼����������ӿ�
  * ��������: ���ؼ�¼����������ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface IgdocdownSearchCond {
	
	public Integer getEiid();
	
	public void setEiid(Integer eiid);

	public String getUserid();

	public void setUserid(String userid);

	public String getDowntime();

	public void setDowntime(String downtime);

	public String getDownlocation();

	public void setDownlocation(String downlocation);

	public String getFingerprint();

	public void setFingerprint(String fingerprint);
}