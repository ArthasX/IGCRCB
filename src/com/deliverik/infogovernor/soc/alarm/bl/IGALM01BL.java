/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM01DTO;



/**
 *	����ָ��ģ�������
 *	@author wangxing
 */
public interface IGALM01BL extends BaseBL {
	
	public IGALM01DTO importPerfTemplateAction(IGALM01DTO dto) throws BLException;
	public IGALM01DTO searchALM0102Action(IGALM01DTO dto) throws BLException;
	public IGALM01DTO deleteALM0102Action(IGALM01DTO dto) throws BLException;
}
