package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM19BL extends BaseBL {


	/**
	 * ��Ա��Ϣ��ѯ����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM19DTO searchEntityItemAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO insertEntityItemAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣɾ������
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO deleteEntityItemAction(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1904Action(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO editEntityItemAction(IGASM19DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ��Ա������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1905Action(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ��������ڻ�����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1906Action(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա��ϵɾ������
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO deleteEntityItemRelationAction(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1907Action(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�ǼǴ���
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO insertEntityItemRelationAction(IGASM19DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�������
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO updateEntityItemRelationAction(IGASM19DTO dto) throws BLException;
	
	/**
	 *	��ȡ��Ա������ϵ����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO searchRelationListAction(IGASM19DTO dto) throws BLException;

	/**
	 *��Ա��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initEntityItem(IGASM19DTO dto) throws BLException;
	/**
	 *��Ա��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO updateEntityItem(IGASM19DTO dto) throws BLException;
	
	/**
	 * ��ȡ��Ա������ֵ
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO searchEntityItemLableAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ�����Ա�ʲ������ɫ������
	 * 
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 * @throws BLException 
	 */
	public IGASM19DTO checkEntityItemDomain(IGASM19DTO dto) throws BLException;
}
