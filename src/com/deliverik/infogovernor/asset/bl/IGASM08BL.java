package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;

/**
 * Ӧ�����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM08BL extends BaseBL {


	/**
	 * Ӧ����Ϣ��ѯ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ϣɾ������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemAction(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0804Action(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO editEntityItemAction(IGASM08DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * Ӧ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0805Action(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ��������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0806Action(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵɾ������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemRelationAction(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0807Action(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemRelationAction(IGASM08DTO dto) throws BLException;

	/**
	 * Ӧ�ù�ϵ�������
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO updateEntityItemRelationAction(IGASM08DTO dto) throws BLException;
	
	/**
	 *	��ȡӦ�ù�����ϵ����
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchRelationListAction(IGASM08DTO dto) throws BLException;
	

	/**
	 *Ӧ����Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO initEntityItem(IGASM08DTO dto) throws BLException;
	/**
	 *Ӧ����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO updateEntityItem(IGASM08DTO dto) throws BLException;
	
	/**
	 * ��ȡӦ�ñ�����ֵ
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemLableAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���Ӧ���ʲ������ɫ������
	 * 
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 * @throws BLException 
	 */
	public IGASM08DTO checkEntityItemDomain(IGASM08DTO dto) throws BLException;
}
