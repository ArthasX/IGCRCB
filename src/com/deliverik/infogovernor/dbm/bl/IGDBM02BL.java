/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;

/**
 * @�������������г���ҳBL
 * @���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.������
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 * @������¼�������� 2010/10/26
 * @version 1.0
 */

public interface IGDBM02BL extends BaseBL {

	/**
	 * ����:�г���ҳ�������ؼ�
	 * @param IGDBM02DTO dto
	 * @return ��ϵͳ�������
	 * @throws BLException
	 */
	public IGDBM02DTO getMonitor(IGDBM02DTO dto) throws BLException;
	
	
	/**
	 * 
	 * ����:������ҳ�¼������⡢�������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �¼������⡢�������
	 * @throws BLException
	 */
	public IGDBM02DTO getProcessCount(IGDBM02DTO dto)  throws BLException;
	
	
	/**
	 * ����:���ɴ�����ҳ����ƻ�����xml
	 * @param IGDBM02DTO dto
	 * @return ����ƻ�����
	 * @throws BLException
	 */
	public IGDBM02DTO setChangePlan(IGDBM02DTO dto) throws BLException ;
	
	
	
	/**
	 * ����:������ҳ�����¼�����ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �����¼�����
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthEventCount(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * ����:������ҳ������������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return ������������
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthProblemCount(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * 
	 * ����:������ҳ�����Ĺ�������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �����Ĺ�������
	 * @throws BLException
	 */
	public IGDBM02DTO getWorkCount(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGDBM02DTO dto
	 * @return �¼�������ƽ�����ʱ��
	 * @throws BLException
	 */
	public IGDBM02DTO setEventAvgCost(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM02DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM02DTO setproProblemAvgSolute(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM02DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM02DTO setproChangeAvgSuccess(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * ����:�����ɹ�������ͼ
	 * @param IGDBM02DTO dto
	 * @return �����ɹ���
	 * @throws BLException
	 */
	public IGDBM02DTO getPLine(IGDBM02DTO dto) throws BLException;
	
	/**
	 * ����:�����ɹ����Ǳ�
	 * @param IGDBM02DTO dto
	 * @return �����ɹ�����
	 * @throws BLException
	 */
	public IGDBM02DTO getStudy(IGDBM02DTO dto)throws BLException;
}
