package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM14DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGCIM14BL extends BaseBL {


	/**
	 * ��Ա��Ϣ��ѯ����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchEntityItemAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO insertEntityItemAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣɾ������
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO deleteEntityItemAction(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1404Action(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO editEntityItemAction(IGCIM14DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ��Ա��ϵ��������ڻ�����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1406Action(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա��ϵɾ������
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO deleteEntityItemRelationAction(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�༭������ڻ�����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1407Action(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�ǼǴ���
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO insertEntityItemRelationAction(IGCIM14DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�������
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO updateEntityItemRelationAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 *	��ȡ��Ա������ϵ����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchRelationListAction(IGCIM14DTO dto) throws BLException;

	/**
	 *��Ա��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initEntityItem(IGCIM14DTO dto) throws BLException;
	/**
	 *��Ա��Ϣ�޸Ĵ���
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO updateEntityItem(IGCIM14DTO dto) throws BLException;
	
	/**
	 * ��ȡ��Ա������ֵ
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchEntityItemLableAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ�����Ա�ʲ������ɫ������
	 * 
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 * @throws BLException 
	 */
	public IGCIM14DTO checkEntityItemDomain(IGCIM14DTO dto) throws BLException;
}
