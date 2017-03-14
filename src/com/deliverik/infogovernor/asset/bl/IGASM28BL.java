package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;

/**
 * ��������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM28BL extends BaseBL {


	/**
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * �������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * �������Ϣɾ������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemAction(IGASM28DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2804Action(IGASM28DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO editEntityItemAction(IGASM28DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2805Action(IGASM28DTO dto) throws BLException;

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2806Action(IGASM28DTO dto) throws BLException;

	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemRelationAction(IGASM28DTO dto) throws BLException;

	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2807Action(IGASM28DTO dto) throws BLException;

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemRelationAction(IGASM28DTO dto) throws BLException;

	/**
	 * ������ϵ�������
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO updateEntityItemRelationAction(IGASM28DTO dto) throws BLException;
	
	/**
	 *	��ȡ����������ϵ����
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchRelationListAction(IGASM28DTO dto) throws BLException;
	

	/**
	 *�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM28DTO initEntityItem(IGASM28DTO dto) throws BLException;
	/**
	 *�������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM28DTO updateEntityItem(IGASM28DTO dto) throws BLException;
	
	/**
	 * ��ȡ����������ֵ
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemLableAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 * @throws BLException 
	 */
	public IGASM28DTO checkEntityItemDomain(IGASM28DTO dto) throws BLException;
	
	
	/**
	 * ������ѯ
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * ��������� ȡֵ��Χ
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO 
	 */
	public IGASM28DTO searchRiskPropertyActioin(IGASM28DTO dto) throws BLException;
	

	/**
	 * ����ʲ�����
	 * @param eiid �ʲ�ID
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ
	 * @throws BLException
	 */
	public IGASM28DTO createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException ;

}
