package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM09DTO;

/**
 * ���������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM09BL extends BaseBL {


	/**
	 * ��������Ϣ��ѯ����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchEntityItemAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * ��������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO insertEntityItemAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * ��������Ϣɾ������
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO deleteEntityItemAction(IGASM09DTO dto) throws BLException;

	/**
	 * ������������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0904Action(IGASM09DTO dto) throws BLException;

	/**
	 * ������������Ϣ�༭����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO editEntityItemAction(IGASM09DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ������������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0905Action(IGASM09DTO dto) throws BLException;

	/**
	 * �����̹�ϵ��������ڻ�����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0906Action(IGASM09DTO dto) throws BLException;

	/**
	 * �����̹�ϵɾ������
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO deleteEntityItemRelationAction(IGASM09DTO dto) throws BLException;

	/**
	 * �����̹�ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0907Action(IGASM09DTO dto) throws BLException;

	/**
	 * �����̹�ϵ�ǼǴ���
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO insertEntityItemRelationAction(IGASM09DTO dto) throws BLException;

	/**
	 * �����̹�ϵ�������
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO updateEntityItemRelationAction(IGASM09DTO dto) throws BLException;
	
	/**
	 *	��ȡ�����̹�����ϵ����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchRelationListAction(IGASM09DTO dto) throws BLException;
	
	/**
	 *��������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initEntityItem(IGASM09DTO dto) throws BLException;
	/**
	 *��������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO updateEntityItem(IGASM09DTO dto) throws BLException;
	
	/**
	 * ��ȡ�����̱�����ֵ
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchEntityItemLableAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ��Ƿ������ʲ������ɫ������
	 * 
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 * @throws BLException 
	 */
	public IGASM09DTO checkEntityItemDomain(IGASM09DTO dto) throws BLException;
	/**
	 * ��������Ϣ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM09DTO intiIGASM0901Action(IGASM09DTO dto) throws BLException;
}
