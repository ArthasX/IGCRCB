/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * ����: mss00011���������ӿ�
  * ��������: mss00011���������ӿ�
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
public interface Mss00011SearchCond {
	public String getName_like();

	public String getType_eq();

	public String getEsyscoding();

	public IGLOG0041VO getVo();

	public String[] getDeleteId();
	public String getRuleid();

	public String getTypeid();

	public String getDeviceid();

	public String getDevicestate();

}