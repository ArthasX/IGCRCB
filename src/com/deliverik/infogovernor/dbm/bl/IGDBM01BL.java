/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * @�������������г���ҳBL
 * @���������� 1.���ط��п���Ƿ�
 *           2.������
 *           3.������ATM��POS�ɹ����Ǳ���
 *           4.������ATM��POS�ɹ�����ͼ
 *           5.��ǰ����ͳ��
 *           6.����ƻ���ѯ
 *           7.IT��Ӫ����
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public interface IGDBM01BL extends BaseBL {

	/**
	 * ����:�����ɹ�������ͼ
	 * @param IGDBM01DTO dto
	 * @return �����ɹ���
	 * @throws BLException
	 */
	public IGDBM01DTO getPLine(IGDBM01DTO dto) throws BLException;
	
	/**
	 * ����:��ǰ��������ͼ
	 * @param IGDBM01DTO dto
	 * @return ��ǰ������
	 * @throws BLException
	 */
	public IGDBM01DTO getCurrentWorkPiller(IGDBM01DTO dto) throws BLException;
	
	/**
	 * ����:��ͼ��������
	 * @param IGDBM01DTO dto
	 * @return �����д�������Ľ�����
	 * @throws BLException
	 */
	public IGDBM01DTO getMap(IGDBM01DTO dto)throws BLException;
	
	/**
	 * ����:�����ɹ����Ǳ�
	 * @param IGDBM01DTO dto
	 * @return �����ɹ�����
	 * @throws BLException
	 */
	public IGDBM01DTO getStudy(IGDBM01DTO dto)throws BLException;
	
	
	
	/**
	 * ����:�г���ҳ�������ؼ�
	 * @param IGDBM01DTO dto
	 * @return ��ϵͳ�������
	 * @throws BLException
	 */
	public IGDBM01DTO getMonitor(IGDBM01DTO dto) throws BLException;
	
	
	/**
	 * ����:���ɱ��¸��¼����Ͳ�ͬ����������xml
	 * @param IGDBM01DTO dto
	 * @return ���¼����Ͳ�ͬ����������
	 * @throws BLException
	 */
	public IGDBM01DTO setAllTypeEventCount(IGDBM01DTO dto)  throws BLException;
	
	/**
	 * ����:�г���ҳ����xml
	 * @param IGDBM01DTO dto
	 * @return ÿ�¸�����
	 * @throws BLException
	 */
	public IGDBM01DTO setCalendar(IGDBM01DTO dto) throws BLException ;
	
	/**
	 * ����:�г���ҳIT����
	 * @param IGDBM01DTO dto
	 * @return ÿ�±�������⡢�¼�����
	 * @throws BLException
	 */
	public IGDBM01DTO setITChart(IGDBM01DTO dto)  throws BLException;
}
