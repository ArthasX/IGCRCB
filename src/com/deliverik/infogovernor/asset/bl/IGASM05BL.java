package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM05DTO;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * �ĵ����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM05BL extends BaseBL {


	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchEntityItemAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * �ĵ���Ϣ�ǼǴ���
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO insertEntityItemAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * �ĵ���Ϣɾ������
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO deleteEntityItemAction(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0504Action(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ�������Ϣ�༭����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO editEntityItemAction(IGASM05DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �ĵ�������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0505Action(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ��������ڻ�����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0506Action(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ���ϵɾ������
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO deleteEntityItemRelationAction(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0507Action(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�ǼǴ���
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO insertEntityItemRelationAction(IGASM05DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�������
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO updateEntityItemRelationAction(IGASM05DTO dto) throws BLException;
	
	/**
	 *	��ȡ�ĵ�������ϵ����
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchRelationListAction(IGASM05DTO dto) throws BLException;
	

	/**
	 *�ĵ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM05DTO initEntityItem(IGASM05DTO dto) throws BLException;
	/**
	 *�ĵ���Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM05DTO updateEntityItem(IGASM05DTO dto) throws BLException;
	
	/**
	 * ��ȡ�ĵ�������ֵ
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchEntityItemLableAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws BLException 
	 */
	public IGASM05DTO checkEntityItemDomain(IGASM05DTO dto) throws BLException;
	
	/**
	 * ��ѯ�ĵ��ʲ���Ϣϸ��
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws BLException
	 */
	public IGASM05DTO getAssetDetailInfomation(IGASM05DTO dto) throws BLException;
	
	
	/**
	 * �����ؼ�¼��������һ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM42DTO downFileInsertData(IGASM42DTO dto) throws BLException;
	
}
