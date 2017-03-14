/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;

/**
 * @����������������������ҳBL
 * @���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.����ͳ��
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public interface IGDBM03BL extends BaseBL {
	/**
	 * 
	 * ����:������ҳ�¼������⡢�������ȡ�ô���
	 * @param IGDBM03DTO dto
	 * @return �¼������⡢�����
	 * @throws BLException
	 */
	public IGDBM03DTO getProcessCount(IGDBM03DTO dto)  throws BLException;

	
	/**
	 * ����:���ɴ�����ҳ����ƻ�����xml
	 * @param IGDBM03DTO dto
	 * @return ����ƻ�����
	 * @throws BLException
	 */
	public IGDBM03DTO setChangePlan(IGDBM03DTO dto) throws BLException ;
	

	/**
	 * ����:���ɱ��¸��¼����Ͳ�ͬ����������xml
	 * @param IGDBM03DTO dto
	 * @return ���¸��¼����Ͳ�ͬ����������
	 * @throws BLException
	 */
	public IGDBM03DTO setAllTypeEventCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:������ҳ�����¼�����ȡ�ô���
	 * @param IGDBM03DTO dto
	 * @return �����¼�����
	 * @throws BLException
	 */
	public IGDBM03DTO getCurrentMouthEventCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:������ҳ������������ȡ�ô���
	 * @param IGDBM03DTO dto
	 * @return ������������
	 * @throws BLException
	 */
	public IGDBM03DTO getCurrentMouthProblemCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 
	 * ����:��������������͹�������ȡ�ô���
	 * @param IGDBM03DTO dto
	 * @return �������͹�������
	 * @throws BLException
	 */
	public IGDBM03DTO getAllTypeWorkCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGDBM03DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException
	 */
	public IGDBM03DTO setEventAvgCost(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM03DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM03DTO setproProblemAvgSolute(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM03DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM03DTO setproChangeAvgSuccess(IGDBM03DTO dto)  throws BLException;

	/**
	 * ����:�����¼����ȼ���Ӱ��̶ȡ������̶�xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setproincidentInfo(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * ����:����֪ʶ����ռ��xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setKnowledgeInfo(IGDBM03DTO dto)  throws BLException;
}
