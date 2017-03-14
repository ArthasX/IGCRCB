package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;

/**
 * ��Ʊ���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM24BL extends BaseBL {


	/**
	 * ��Ʊ��Ϣ��ѯ����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchEntityItemAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * ��Ʊ��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO insertEntityItemAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * ��Ʊ��Ϣɾ������
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO deleteEntityItemAction(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2404Action(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ������Ϣ�༭����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO editEntityItemAction(IGASM24DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ��Ʊ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2405Action(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ��ϵ��������ڻ�����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2406Action(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ��ϵɾ������
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO deleteEntityItemRelationAction(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2407Action(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ��ϵ�ǼǴ���
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO insertEntityItemRelationAction(IGASM24DTO dto) throws BLException;

	/**
	 * ��Ʊ��ϵ�������
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO updateEntityItemRelationAction(IGASM24DTO dto) throws BLException;
	
	/**
	 *	��ȡ��Ʊ������ϵ����
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchRelationListAction(IGASM24DTO dto) throws BLException;
	

	/**
	 *��Ʊ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM24DTO initEntityItem(IGASM24DTO dto) throws BLException;
	/**
	 *��Ʊ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM24DTO updateEntityItem(IGASM24DTO dto) throws BLException;
	
	/**
	 * ��ȡ��Ʊ������ֵ
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchEntityItemLableAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 * @throws BLException 
	 */
	public IGASM24DTO checkEntityItemDomain(IGASM24DTO dto) throws BLException;

    /**
     * ��ѯ��ʼ������ҳ����Ϣ
     * @param dto
     */
    public IGASM24DTO searchInitEntityInfo(IGASM24DTO dto)throws BLException;
}
