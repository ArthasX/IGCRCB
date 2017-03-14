/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
/**
 * ����: �ʲ�CI���ҵ���߼��ӿ�
 * ��������: �ʲ�CI���ҵ���߼��ӿ�
 * ������¼: 2211/04/25
 * �޸ļ�¼: 
 */
public interface IGASM22BL extends BaseBL{

	/**
	 * ����̨��ʾ����
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * ����������ɾ������
	 * 
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO deleteCIWaitTaskAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * ����̨���봦��
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO importIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * ����̨�Աȴ���
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO compareIGASM2201Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * ����̨����鿴����
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2203Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * CI����ԱȽ����ѯ����
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCIResultAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * CI����ԱȽ�����洦��
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public void updateCIResultAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI�������ǼǴ���
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO insertCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI��������ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * CI���������������ʾ
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2205Action(IGASM22DTO dto) throws BLException;

	/**
	 * CI�������������
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateCITaskAction(IGASM22DTO dto) throws BLException;

	/**
	 * �豸��Ϣ��ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO searchEntityItemAction(IGASM22DTO dto) throws BLException;

	/**
	 * �豸��ϸ��Ϣ��ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2209Action(IGASM22DTO dto) throws BLException;

	/**
	 * �豸Ӱ�췶Χ��ѯ����
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO initIGASM2208Action(IGASM22DTO dto) throws BLException;
	
	/**
	 * �ʲ����´���
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO updateEntityAction(IGASM22DTO dto) throws BLException;
	
	/**
	 * ��������CI(���ù�ϵ������bat)
	 * 
	 * @param dtoIGASM22DTO
	 * @return IGASM22DTO
	 * @throws BLException
	 */
	public IGASM22DTO rootMarkUpdateAction(IGASM22DTO dto) throws BLException;
}
