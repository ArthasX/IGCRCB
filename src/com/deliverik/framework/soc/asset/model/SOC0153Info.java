/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;


/**
  * ����: ��ռ䷥ֵ�趨��ӿ�
  * ��������: ��ռ䷥ֵ�趨��ӿ�
  * ������¼: 
  * �޸ļ�¼: 
  */
public interface SOC0153Info{

	public Integer getLid() ;
	public String getLogName();
	public String getWarnType() ;
	public Integer getCiType() ;
	public String getLogStatus() ;
	public String getLogContent() ;
	public String getLogDate();
	public String getTotalSize();
	public String getUserSize() ;
	public String getSurplusSize() ;
	public String getUserRatio() ;
	public String getServerIP() ;
	public SOC0113TB getSoc0113TB();
	

}