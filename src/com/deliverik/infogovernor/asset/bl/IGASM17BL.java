package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM17DTO;

/**
 * ������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM17BL extends BaseBL {


	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * �����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * �����Ϣɾ������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemAction(IGASM17DTO dto) throws BLException;

	/**
	 * ���������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1704Action(IGASM17DTO dto) throws BLException;

	/**
	 * ���������Ϣ�༭����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO editEntityItemAction(IGASM17DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ���������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1705Action(IGASM17DTO dto) throws BLException;

	/**
	 * �����ϵ��������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1706Action(IGASM17DTO dto) throws BLException;

	/**
	 * �����ϵɾ������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemRelationAction(IGASM17DTO dto) throws BLException;

	/**
	 * �����ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1707Action(IGASM17DTO dto) throws BLException;

	/**
	 * �����ϵ�ǼǴ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemRelationAction(IGASM17DTO dto) throws BLException;

	/**
	 * �����ϵ�������
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItemRelationAction(IGASM17DTO dto) throws BLException;
	
	/**
	 *	��ȡ���������ϵ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchRelationListAction(IGASM17DTO dto) throws BLException;
	
	/**
	 *�����Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initEntityItem(IGASM17DTO dto) throws BLException;
	/**
	 *�����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItem(IGASM17DTO dto) throws BLException;
	
	/**
	 * ��ȡ���������ֵ
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemLableAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 * @throws BLException 
	 */
	public IGASM17DTO checkEntityItemDomain(IGASM17DTO dto) throws BLException;
}
