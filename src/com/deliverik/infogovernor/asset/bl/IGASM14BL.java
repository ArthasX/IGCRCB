package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM14BL extends BaseBL {


	/**
	 * �����¼��Ϣ��ѯ����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * �����¼��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * �����¼��Ϣɾ������
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemAction(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1404Action(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼������Ϣ�༭����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO editEntityItemAction(IGASM14DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �����¼������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1405Action(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼��ϵ��������ڻ�����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1406Action(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼��ϵɾ������
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1407Action(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼��ϵ�ǼǴ���
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 * �����¼��ϵ�������
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 *�����¼��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initEntityItem(IGASM14DTO dto) throws BLException;
	/**
	 *�����¼��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItem(IGASM14DTO dto) throws BLException;
	
	/**
	 * ��ȡ�����¼������ֵ
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemLableAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ��Ƿ����¼�ʲ������ɫ������
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO checkEntityItemDomain(IGASM14DTO dto) throws BLException;
	
	/**
	 * ͨ���豸��ѯ�����¼
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO searchServiceAction(IGASM14DTO dto) throws BLException;
}
