package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM15DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM15BL extends BaseBL {


	/**
	 * ��Ա��Ϣ��ѯ����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchEntityItemAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO insertEntityItemAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * ��Ա��Ϣɾ������
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO deleteEntityItemAction(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1504Action(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա������Ϣ�༭����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO editEntityItemAction(IGASM15DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ��Ա������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1505Action(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ��������ڻ�����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1506Action(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա��ϵɾ������
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO deleteEntityItemRelationAction(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1507Action(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�ǼǴ���
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO insertEntityItemRelationAction(IGASM15DTO dto) throws BLException;

	/**
	 * ��Ա��ϵ�������
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO updateEntityItemRelationAction(IGASM15DTO dto) throws BLException;
	
	/**
	 *	��ȡ��Ա������ϵ����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchRelationListAction(IGASM15DTO dto) throws BLException;

	/**
	 *��Ա��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initEntityItem(IGASM15DTO dto) throws BLException;
	/**
	 *��Ա��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO updateEntityItem(IGASM15DTO dto) throws BLException;
	
	/**
	 * ��ȡ��Ա������ֵ
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchEntityItemLableAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ�����Ա�ʲ������ɫ������
	 * 
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 * @throws BLException 
	 */
	public IGASM15DTO checkEntityItemDomain(IGASM15DTO dto) throws BLException;
}
