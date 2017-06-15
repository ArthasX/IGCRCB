package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;

/**
 * ϵͳ���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM18BL extends BaseBL {


	/**
	 * ϵͳ��Ϣ��ѯ����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchEntityItemAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * ϵͳ��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO insertEntityItemAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * ϵͳ��Ϣɾ������
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO deleteEntityItemAction(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1804Action(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ������Ϣ�༭����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO editEntityItemAction(IGASM18DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ϵͳ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1805Action(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ��ϵ��������ڻ�����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1806Action(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ��ϵɾ������
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO deleteEntityItemRelationAction(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1807Action(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ��ϵ�ǼǴ���
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO insertEntityItemRelationAction(IGASM18DTO dto) throws BLException;

	/**
	 * ϵͳ��ϵ�������
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO updateEntityItemRelationAction(IGASM18DTO dto) throws BLException;
	
	/**
	 *	��ȡϵͳ������ϵ����
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchRelationListAction(IGASM18DTO dto) throws BLException;
	

	/**
	 *ϵͳ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM18DTO initEntityItem(IGASM18DTO dto) throws BLException;
	/**
	 *ϵͳ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM18DTO updateEntityItem(IGASM18DTO dto) throws BLException;
	
	/**
	 * ��ȡϵͳ������ֵ
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchEntityItemLableAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ϵͳ�ʲ������ɫ������
	 * 
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 * @throws BLException 
	 */
	public IGASM18DTO checkEntityItemDomain(IGASM18DTO dto) throws BLException;
}
