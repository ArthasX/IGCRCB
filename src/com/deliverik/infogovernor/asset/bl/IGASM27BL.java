package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.asset.dto.IGASM2701DTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;

/**
 * ���յ����ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM27BL extends BaseBL {


	/**
	 * ���յ���Ϣ��ѯ����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchEntityItemAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * ���յ���Ϣ�ǼǴ���
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO insertEntityItemAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * ���յ���Ϣɾ������
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO deleteEntityItemAction(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2704Action(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ�������Ϣ�༭����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO editEntityItemAction(IGASM27DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ���յ�������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2705Action(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ��ϵ��������ڻ�����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2706Action(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ��ϵɾ������
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO deleteEntityItemRelationAction(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2707Action(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ��ϵ�ǼǴ���
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO insertEntityItemRelationAction(IGASM27DTO dto) throws BLException;

	/**
	 * ���յ��ϵ�������
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO updateEntityItemRelationAction(IGASM27DTO dto) throws BLException;
	
	/**
	 *	��ȡ���յ������ϵ����
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchRelationListAction(IGASM27DTO dto) throws BLException;
	

	/**
	 *���յ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM27DTO initEntityItem(IGASM27DTO dto) throws BLException;
	/**
	 *���յ���Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM27DTO updateEntityItem(IGASM27DTO dto) throws BLException;
	
	/**
	 * ��ȡ���յ������ֵ
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchEntityItemLableAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ���ָ�������ʲ������ɫ������
	 * 
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 * @throws BLException 
	 */
	public IGASM27DTO checkEntityItemDomain(IGASM27DTO dto) throws BLException;
	/**��ѯ���ռ���  ��������*/
	public IGASM27DTO searchRiskPropertyActioin(IGASM27DTO dto)	throws BLException;
	/**
	 *������յ� �����Լ������� 
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 * @throws BLException
	 * */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException ;
	
	/**���յ��Զ�����ͼ��ѯ*/
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)throws BLException;
}
