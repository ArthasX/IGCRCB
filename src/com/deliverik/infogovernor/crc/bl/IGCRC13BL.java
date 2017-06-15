/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1302DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1303DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;


/**	
 * ����:�ĵ���ѯcontrolBL�ӿ�
 * ����������1.��ѯ�ĵ���Ϣ�б�	
 * ������¼��shenbing    2014/7/15	
 *         	
 */
public interface IGCRC13BL {
	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO searchEntityItemAction(IGCRC1301DTO dto) throws BLException;
	
	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1301DTO openSearchEntityItemAction(IGCRC1301DTO dto) throws BLException;

	/**
	 * ���ĵ�����ͳ�ƴ���
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1303DTO searchEntitySumAction(IGCRC1303DTO dto) throws BLException;
	
	/**
	 * ������ͳ���ĵ�����
	 *
	 * @param dto IGCRC1301DTO
	 * @return IGCRC1301DTO
	 */
	public IGCRC1304DTO searchDepartSumAction(IGCRC1304DTO dto) throws BLException;
	/**
	 * <p>
	 * �ҵĽ��ģ���ȡ�û�������ĵ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGCRC1302DTO getWorkInitByMe(IGCRC1302DTO dto) throws BLException;
	
	/**
	 * �ĵ�����ͳ����ϸ��ѯ
	 * 
	 * @param dto
	 * @return
	 */
	public IGCRC1301DTO searchItemAction(IGCRC1301DTO dto) throws BLException;
	
	
	/**
	 * �ĵ�����ͳ�ƹ������̲�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC1304DTO searchIG500ItemAction(IGCRC1304DTO dto)throws BLException;
	
}
