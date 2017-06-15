package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;

/**
 * �������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM16BL extends BaseBL {


	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchEntityItemAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO insertEntityItemAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO deleteEntityItemAction(IGASM16DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1604Action(IGASM16DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO editEntityItemAction(IGASM16DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1605Action(IGASM16DTO dto) throws BLException;

	/**
	 * ���ݹ�ϵ��������ڻ�����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1606Action(IGASM16DTO dto) throws BLException;

	/**
	 * ���ݹ�ϵɾ������
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO deleteEntityItemRelationAction(IGASM16DTO dto) throws BLException;

	/**
	 * ���ݹ�ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1607Action(IGASM16DTO dto) throws BLException;

	/**
	 * ���ݹ�ϵ�ǼǴ���
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO insertEntityItemRelationAction(IGASM16DTO dto) throws BLException;

	/**
	 * ���ݹ�ϵ�������
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO updateEntityItemRelationAction(IGASM16DTO dto) throws BLException;
	
	/**
	 *	��ȡ���ݹ�����ϵ����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchRelationListAction(IGASM16DTO dto) throws BLException;
	

	/**
	 *������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initEntityItem(IGASM16DTO dto) throws BLException;
	/**
	 *������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO updateEntityItem(IGASM16DTO dto) throws BLException;
	
	/**
	 * ��ȡ���ݱ�����ֵ
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchEntityItemLableAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ��������ʲ������ɫ������
	 * 
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 * @throws BLException 
	 */
	public IGASM16DTO checkEntityItemDomain(IGASM16DTO dto) throws BLException;
}
