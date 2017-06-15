/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM04DTO;



/**
 * �澯��Ϣ��ѯ�߼��ӿ�
 *
 *	@author liupeng@deliverik.com
 */
public interface IGALM04BL extends BaseBL {
	
	/**
	 * �澯��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO searchCRM04Action(IGALM04DTO dto) throws BLException;
	
	/**
	 * ��ȡ�澯����
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getAlarmPriority(IGALM04DTO dto) throws BLException;
	
	/**
	 * ��ȡʵʱ����ˢ��Ƶ��
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getRefreshRate(IGALM04DTO dto) throws BLException;
}
