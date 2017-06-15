package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM06DTO;

/**
 * ������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM06BL extends BaseBL {


	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO searchEntityItemAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * �����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO insertEntityItemAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * �����Ϣɾ������
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO deleteEntityItemAction(IGASM06DTO dto) throws BLException;

	/**
	 * ���������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0604Action(IGASM06DTO dto) throws BLException;

	/**
	 * ���������Ϣ�༭����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO editEntityItemAction(IGASM06DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ���������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0605Action(IGASM06DTO dto) throws BLException;

	/**
	 * �����ϵ��������ڻ�����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0606Action(IGASM06DTO dto) throws BLException;

	/**
	 * �����ϵɾ������
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO deleteEntityItemRelationAction(IGASM06DTO dto) throws BLException;

	/**
	 * �����ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0607Action(IGASM06DTO dto) throws BLException;

	/**
	 * �����ϵ�ǼǴ���
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO insertEntityItemRelationAction(IGASM06DTO dto) throws BLException;

	/**
	 * �����ϵ�������
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO updateEntityItemRelationAction(IGASM06DTO dto) throws BLException;
	
	/**
	 *	��ȡϵͳ������ϵ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM06DTO searchRelationListAction(IGASM06DTO dto) throws BLException;

	/**
	 *�����Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initEntityItem(IGASM06DTO dto) throws BLException;
	/**
	 *�����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO updateEntityItem(IGASM06DTO dto) throws BLException;
	
	/**
	 * ��ȡ���������ֵ
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO searchEntityItemLableAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 * @throws BLException 
	 */
	public IGASM06DTO checkEntityItemDomain(IGASM06DTO dto) throws BLException;
}
