package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;

/**
 * �������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM07BL extends BaseBL {


	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO searchEntityItemAction(IGASM07DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemAction(IGASM07DTO dto) throws BLException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemAction(IGASM07DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0704Action(IGASM07DTO dto) throws BLException;

	/**
	 * ����������Ϣ�༭����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO editEntityItemAction(IGASM07DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0705Action(IGASM07DTO dto) throws BLException;

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0706Action(IGASM07DTO dto) throws BLException;

	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemRelationAction(IGASM07DTO dto) throws BLException;

	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0707Action(IGASM07DTO dto) throws BLException;

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemRelationAction(IGASM07DTO dto) throws BLException;

	/**
	 * ������ϵ�������
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO updateEntityItemRelationAction(IGASM07DTO dto) throws BLException;
}
