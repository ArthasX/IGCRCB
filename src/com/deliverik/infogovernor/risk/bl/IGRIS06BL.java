package com.deliverik.infogovernor.risk.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;

/**
 * ��������ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGRIS06BL extends BaseBL {


	/**
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchEntityItemAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * �������Ϣ�ǼǴ���
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO insertEntityItemAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * �������Ϣɾ������
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO deleteEntityItemAction(IGRIS06DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0604Action(IGRIS06DTO dto) throws BLException;

	/**
	 * �����������Ϣ�༭����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO editEntityItemAction(IGRIS06DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �����������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0605Action(IGRIS06DTO dto) throws BLException;

	/**
	 * ������ϵ��������ڻ�����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0606Action(IGRIS06DTO dto) throws BLException;

	/**
	 * ������ϵɾ������
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO deleteEntityItemRelationAction(IGRIS06DTO dto) throws BLException;

	/**
	 * ������ϵ�༭������ڻ�����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0607Action(IGRIS06DTO dto) throws BLException;

	/**
	 * ������ϵ�ǼǴ���
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO insertEntityItemRelationAction(IGRIS06DTO dto) throws BLException;

	/**
	 * ������ϵ�������
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO updateEntityItemRelationAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 *	��ȡ����������ϵ����
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchRelationListAction(IGRIS06DTO dto) throws BLException;
	

	/**
	 *�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGRIS06DTO initEntityItem(IGRIS06DTO dto) throws BLException;
	/**
	 *�������Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGRIS06DTO updateEntityItem(IGRIS06DTO dto) throws BLException;
	
	/**
	 * ��ȡ����������ֵ
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchEntityItemLableAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 * @throws BLException 
	 */
	public IGRIS06DTO checkEntityItemDomain(IGRIS06DTO dto) throws BLException;
	
	
	/**
	 * ������ѯ
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGRIS06DTO searchCheckItemListAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * ��������� ȡֵ��Χ
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO 
	 */
	public IGRIS06DTO searchRiskPropertyActioin(IGRIS06DTO dto) throws BLException;
	

	/**
	 * ����ʲ�����
	 * @param eiid �ʲ�ID
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ
	 * @throws BLException
	 */
	public IGRIS06DTO createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException;

	/**	
	 * ���ܣ����������м������ϸ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGRIS06DTO serachCheckItemInfoListAction(IGRIS06DTO dto) throws BLException;
		
	public IGRIS06DTO searchCheckItemListNotPageAction(IGRIS06DTO dto) throws BLException;
	
	public IGRIS06DTO searchCheckItemWindowAction(IGRIS06DTO dto) throws BLException;
	
	/**	
	 * ���ܣ����¼����״̬
	 * @param dto
	 * @return ����
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public Integer updateCheckItemStatus(IGRIS06DTO dto) throws BLException;
}
