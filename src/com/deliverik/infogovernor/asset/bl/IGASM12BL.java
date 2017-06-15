package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;

/**
 * �������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM12BL extends BaseBL {


	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO searchEntityItemAction(IGASM12DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO insertEntityItemAction(IGASM12DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO deleteEntityItemAction(IGASM12DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1204Action(IGASM12DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO editEntityItemAction(IGASM12DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1205Action(IGASM12DTO dto) throws BLException;

	/**
	 * �����ϵ��������ڻ�����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1206Action(IGASM12DTO dto) throws BLException;

	/**
	 * �����ϵɾ������
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO deleteEntityItemRelationAction(IGASM12DTO dto) throws BLException;

	/**
	 * �����ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1207Action(IGASM12DTO dto) throws BLException;

	/**
	 * �����ϵ�ǼǴ���
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO insertEntityItemRelationAction(IGASM12DTO dto) throws BLException;

	/**
	 * �����ϵ�������
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO updateEntityItemRelationAction(IGASM12DTO dto) throws BLException;
}
