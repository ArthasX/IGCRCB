package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;

/**
 * ��������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM31BL extends BaseBL {


	/**
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * �������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * �������Ϣɾ������
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemAction(IGASM31DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3104Action(IGASM31DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO editEntityItemAction(IGASM31DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3105Action(IGASM31DTO dto) throws BLException;

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3106Action(IGASM31DTO dto) throws BLException;

	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemRelationAction(IGASM31DTO dto) throws BLException;

	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3107Action(IGASM31DTO dto) throws BLException;

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemRelationAction(IGASM31DTO dto) throws BLException;

	/**
	 * ������ϵ�������
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO updateEntityItemRelationAction(IGASM31DTO dto) throws BLException;
	
	/**
	 *	��ȡ����������ϵ����
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRelationListAction(IGASM31DTO dto) throws BLException;
	

	/**
	 *�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM31DTO initEntityItem(IGASM31DTO dto) throws BLException;
	/**
	 *�������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM31DTO updateEntityItem(IGASM31DTO dto) throws BLException;
	
	/**
	 * ��ȡ����������ֵ
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemLableAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO checkEntityItemDomain(IGASM31DTO dto) throws BLException;
	
	/**
	 * ��ȡ���յ�ָ����������ֵ
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRiskPropertyActioin(IGASM31DTO dto)	throws BLException;
	
	
	/**
	 * ��Maintenanc�в���һ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM31DTO insertMaintenance(IGASM31DTO dto)throws BLException;
	/**
	 * ����ָ��չʾ��Ϣ��ѯ
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexShow(IGASM31DTO dto) throws BLException;
	
	/**
	 * ����ָ��չʾ���ݲ�ѯ
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexContext(IGASM31DTO dto) throws BLException;
	/**
	 * ����ָ��չʾ���ݾ��嵥����ѯ
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexByRiid(IGASM31DTO dto) throws BLException;

	/**	
	 * ���ܣ������ָ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGASM31DTO initIGASM3116Action(IGASM31DTO dto) throws BLException;
}
