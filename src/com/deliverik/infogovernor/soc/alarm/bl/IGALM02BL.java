/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;



/**
 * 	����ģ�������
 *	@author wangxing
 */
public interface IGALM02BL extends BaseBL {
	
	public IGALM02DTO insertRuleTempAndCondition(IGALM02DTO dto) throws BLException;

	//��ѯ�������
	public IGALM02DTO searchMonitorType(IGALM02DTO dto) throws BLException;

	//��ѯ����ģ��
	public IGALM02DTO searchRuleTemp(IGALM02DTO dto) throws BLException;

	//ɾ������ģ��
	public IGALM02DTO deleteRuleTemp(IGALM02DTO dto) throws BLException;

	//����ģ���޸�ҳ���ʼ��
	public IGALM02DTO initRuleTemp(IGALM02DTO dto) throws BLException;

	//����ģ���޸�
	public IGALM02DTO updateRuleTemp(IGALM02DTO dto) throws BLException;

	//����ģ��״̬�޸�
	public IGALM02DTO updateRuleTempState(IGALM02DTO dto) throws BLException;
	
}
