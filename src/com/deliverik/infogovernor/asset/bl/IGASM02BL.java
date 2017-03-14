package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;

/**
 * �ʲ����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM02BL extends BaseBL {


	/**
	 * �ʲ�����Ϣ��ѯ����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchEntityItemAction(IGASM02DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ϣ�ǼǴ���
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemAction(IGASM02DTO dto) throws BLException;
	
	/**
	 * �ʲ�����Ϣɾ������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemAction(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ���������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0204Action(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ���������Ϣ�༭����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO editEntityItemAction(IGASM02DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �ʲ���������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0205Action(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ����ϵ��������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206Action(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ����ϵɾ������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemRelationAction(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ����ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0207Action(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ����ϵ�ǼǴ���
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemRelationAction(IGASM02DTO dto) throws BLException;

	/**
	 * �ʲ����ϵ�������
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO updateEntityItemRelationAction(IGASM02DTO dto) throws BLException;
	
	/**
	 *	��ȡ�����������ϵ����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchRelationListAction(IGASM02DTO dto) throws BLException;
	/**
	 * �豸������ϵ������ڻ�����
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206BelongAction(IGASM02DTO dto) throws BLException  ;
}
