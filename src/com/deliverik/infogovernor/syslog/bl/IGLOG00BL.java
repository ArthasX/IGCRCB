/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;

/**
 * �豸ʵʱ����ʷ��־�澯ҵ���߼��ӿ�
 * @author ��ʡ
 *
 */
public interface IGLOG00BL extends BaseBL{
	
	/**
	 * �豸ʵʱ�澯��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchSysLogAlarmListAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * �豸��ʷ�澯��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchHistorySysLogAlarmListAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * �豸ʵʱ��־�޸�����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO FixSysLogAlarmsAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * ������ҳ���豸��ʷ�澯��ѯ��������Excel����
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG00DTO searchHistorySysLogAlarmListNopageAction(IGLOG00DTO dto) throws BLException, Exception;
	
	/**
	 * ��ȡ�澯�����б�
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG00DTO getAlarmPriority(IGLOG00DTO dto) throws Exception;
	
	/**
	 * �豸�澯�����̵��б�
	 * @���� zhaoyong
	 */
	public IGLOG00DTO searchSysLogAlarmListActionWithProcess(IGLOG00DTO dto)throws BLException;
	
	/**
	 * ��ȡʵʱ����ˢ��Ƶ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG00DTO getRefreshRate(IGLOG00DTO dto) throws BLException;

	
	

}
