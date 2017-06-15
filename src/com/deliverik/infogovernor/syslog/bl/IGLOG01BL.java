/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;

/**
 * �豸ʵʱ����ʷ��־ҵ���߼��ӿ�
 * @author ��ʡ
 *
 */
public interface IGLOG01BL extends BaseBL{
	
	public IGLOG01DTO searchUserRole(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * �豸ʵʱ��־��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchSysLogListAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * �豸��ʷ��־��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchHistorySysLogListAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * ������ҳ���豸��ʷ��־��ѯ��������Excel����
	 * @return
	 * @throws BLException
	 * @throws Exception
	 */
	public IGLOG01DTO searchHistorySysLogListNopageAction(IGLOG01DTO dto) throws BLException, Exception;
	
	/**
	 * ��ȡ�澯����
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG01DTO getAlarmPriority(IGLOG01DTO dto) throws Exception;
	
	/**
	 * ��ȡʵʱ����ˢ��Ƶ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO getRefreshRate(IGLOG01DTO dto) throws BLException;
	
	
	public IGLOG01DTO getCodeList(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO echoData(IGLOG01DTO dto) throws BLException;

	public void deleteData(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO searchHistoryChecked(IGLOG01DTO dto) throws BLException,
			Exception;

	public void delete00013TB(IGLOG01DTO dto) throws BLException;

	public IGLOG01DTO findAllMS00013(IGLOG01DTO dto);

	public boolean SearchCount(IGLOG01DTO dto);
	/**
	 * �豸�澯�����̵��б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO searchSysLogAlarmListActionWithProcess(IGLOG01DTO dto) throws BLException;
	
	/**
	 * �澯�޸�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO FixSysLogAlarmsAction(IGLOG01DTO dto) throws BLException;
	
	/**
	 * ��ȡ�豸��־ʵ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO getSysLogBean(IGLOG01DTO dto) throws BLException;
	
	/**
	 * �豸��־�����߼�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO doFilter(IGLOG01DTO dto) throws BLException;
	
	/**
	 * ��IG��ʵʱ��MSS00008��������״̬�������ƶ���HQ����ʷ���У�MSS00009��
	 * @throws Exception
	 */
	public void moveFilterSyslogToHistoryDB() throws Exception;
	
	
	/**
	 * ��ȡsyslog�澯����
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG01DTO getAlarmTotalcount(IGLOG01DTO dto) throws Exception;
	
	
	/**
	 * �豸��ʷ�澯�����̵��б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO searchSysLogHistoryAlarmListActionWithProcess(IGLOG01DTO dto)
			throws BLException;
}
