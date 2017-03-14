/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;

public interface CRM01BL extends BaseBL{

	/**
	 * �ɼ������ѯ
	 * @param cond ��ѯ����
	 * @param start ��ʼҳ��
	 * @param length ��ʾ����
	 * @return ��ѯ���
	 */
	public List<CRMVW01Info> searchCRM01VWInfoList(CRM10SearchCond cond , int start,int length);
	public Integer  getSearchCount(CRM10SearchCond cond);
	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException; 
	public String searchTable(final CRM10SearchCond cond);
}
