/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * ����: CRM08�ӿ�
  * ��������: CRM08�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM08Info extends BaseModel {

	/**
	 * RULETEMPIDȡ��
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * RULETEMPNAMEȡ��
	 *
	 * @return RULETEMPNAME
	 */
	public String getRuletempname();

	/**
	 * CATEGORYCCIDȡ��
	 *
	 * @return CATEGORYCCID
	 */
	public String getCategoryccid();

	/**
	 * RULECONDITIONȡ��
	 *
	 * @return RULECONDITION
	 */
	public Integer getRulecondition();

	/**
	 * TEMPSTATEȡ��
	 *
	 * @return TEMPSTATE
	 */
	public Integer getTempstate();
	
	public Integer getAlarmlevel();

	public String getCategorycid();

	public String getDetail();

	public String getCreatetime();
	
	public List<CRM07TB> getCrm07TBList();
	
	public String getTypecid();
	
	public String getTypeccid();
	
}