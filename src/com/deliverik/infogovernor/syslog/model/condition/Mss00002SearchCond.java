/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * ����: �澯�������������ӿ�
  * ��������: �澯�������������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00002SearchCond {

	public String getName_like();
	
//	public String getIp_like();
	
	
	public String getEsyscoding();
	
	public IGLOG0041VO getVo();

	public String[] getDeleteId();
	
	public String getDeviceid();
	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid();
}