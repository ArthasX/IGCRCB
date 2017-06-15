package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM50DTO;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * �ĵ����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM50BL extends BaseBL {


	/**
	 * �ĵ���Ϣ��ѯ����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchEntityItemAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * �ĵ���Ϣ�ǼǴ���
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO insertEntityItemAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * �ĵ���Ϣɾ������
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO deleteEntityItemAction(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5004Action(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ�������Ϣ�༭����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO editEntityItemAction(IGASM50DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �ĵ�������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5005Action(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ��������ڻ�����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5006Action(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ���ϵɾ������
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO deleteEntityItemRelationAction(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5007Action(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�ǼǴ���
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO insertEntityItemRelationAction(IGASM50DTO dto) throws BLException;

	/**
	 * �ĵ���ϵ�������
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO updateEntityItemRelationAction(IGASM50DTO dto) throws BLException;
	
	/**
	 *	��ȡ�ĵ�������ϵ����
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchRelationListAction(IGASM50DTO dto) throws BLException;
	

	/**
	 *�ĵ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM50DTO initEntityItem(IGASM50DTO dto) throws BLException;
	/**
	 *�ĵ���Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM50DTO updateEntityItem(IGASM50DTO dto) throws BLException;
	
	/**
	 * ��ȡ�ĵ�������ֵ
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchEntityItemLableAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 * @throws BLException 
	 */
//	public IGASM50DTO checkEntityItemDomain(IGASM50DTO dto) throws BLException;
	
	/**
	 * ��ѯ�ĵ��ʲ���Ϣϸ��
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 * @throws BLException
	 */
	public IGASM50DTO getAssetDetailInfomation(IGASM50DTO dto) throws BLException;
	
	
	/**
	 * �����ؼ�¼��������һ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
//	public IGASM42DTO downFileInsertData(IGASM42DTO dto) throws BLException;
	
}
