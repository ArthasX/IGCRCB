/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;

/**
 * @�����������л�����ʩ��ҳBL
 * @���������� 1.�Ĵ�����ʹ����
 *           2.�Ĵ�������������������
 *           3.�Ĵ��������ݿ����м��ʹ����
 *           4.���Ĵ洢��������������
 *           5.����¼������������
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public interface IGDBM04BL extends BaseBL {

	/**
	 * ����:���պ���ϵͳ����CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ���պ���ϵͳ����cpu�ڴ�ʹ����
	 * @throws BLException
	 */
	public IGDBM04DTO setKernelUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:����ǰ��ϵͳ����CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ����ǰ��ϵͳ����cpu�ڴ�ʹ����
	 * @throws BLException
	 */
	public IGDBM04DTO setPrefixUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:�����м�ҵ������CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return �����м�ҵ������cpu�ڴ�ʹ����
	 * @throws BLException
	 */
	public IGDBM04DTO setMiddleOperationUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:������������CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ������������cpu�ڴ�ʹ����
	 * @throws BLException
	 */
	public IGDBM04DTO setNetbankUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:������IT�������
	 * @param IGDBM04DTO dto
	 * @return ����������������
	 * @throws BLException
	 */
	public IGDBM04DTO setEquipment(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:��ú���ҵ���������ݿ���м��������������
	 * @param IGDBM04DTO dto
	 * @return ���ݿ���м��������������
	 * @throws BLException
	 */
	public IGDBM04DTO getSystemPiller(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * ����:������ʩ��ҳ����¼������Ǳ�
	 * @param IGDBM04DTO dto
	 * @return �¼���������
	 * @throws BLException
	 */
	public IGDBM04DTO getSomeThingsQuestions(IGDBM04DTO dto)throws BLException;
	
	/**
	 * ����:���Ĵ洢��������������
	 * @param IGDBM04DTO dto
	 * @return ���Ĵ洢����������
	 * @throws BLException
	 */
	public IGDBM04DTO getDoubleColorLine(IGDBM04DTO dto)  throws BLException;
}
