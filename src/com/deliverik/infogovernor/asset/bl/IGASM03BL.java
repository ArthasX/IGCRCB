package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;

/**
 * �豸���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM03BL extends BaseBL {


	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemAction(IGASM03DTO dto) throws BLException;

	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0304Action(IGASM03DTO dto) throws BLException;

	/**
	 * �豸������Ϣ�༭����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO editEntityItemAction(IGASM03DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * �豸������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305Action(IGASM03DTO dto) throws BLException;

	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0306Action(IGASM03DTO dto) throws BLException;

	/**
	 * �豸��ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemRelationAction(IGASM03DTO dto) throws BLException;

	/**
	 * �豸��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0307Action(IGASM03DTO dto) throws BLException;

	/**
	 * �豸��ϵ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemRelationAction(IGASM03DTO dto) throws BLException;

	/**
	 * �豸��ϵ�������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItemRelationAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�·���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchNewAndReciveEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�Ͻ���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchUsingEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸������Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchCanScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�����·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGASM03DTO dto) throws BLException;
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGASM03DTO dto) throws BLException;
	/**
	 * ��ѯָ��eiid�Ĵ��Ͻ��豸
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityPayByEiidAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchPreScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchReceiveEntityItemAction(IGASM03DTO dto) throws BLException;
	public void entityCancelPreScrapBatchAction(IGASM03DTO dto) throws BLException;
	public void entityPreScrapAction(IGASM03DTO dto) throws BLException;
	public void entityScrapBatchAction(IGASM03DTO dto) throws BLException;
	public void entityScrapAction(IGASM03DTO dto) throws BLException;
	public void entityPreScrapBatchAction(IGASM03DTO dto) throws BLException;
	
	public void entityCancelPreScrapAction(IGASM03DTO dto) throws BLException;
	/**
	 *�豸��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initEntityItem(IGASM03DTO dto) throws BLException;
	/**
	 *�豸��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItem(IGASM03DTO dto) throws BLException;
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchRelationListAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸�������ǼǱ༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0317Action(IGASM03DTO dto) throws BLException;
	/**
	 * �豸�������ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertBatchEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemLableAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGASM03DTO checkEntityItemDomain(IGASM03DTO dto) throws BLException;
	/**
	 * ��ȡ��ʷ�汾����ʱ��
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<IG887Info> getVersionUpdateTime(String eiid)throws BLException;
	
	/**
	 * ��ʼ���ʲ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO initXMLInfo(IGASM03DTO dto) throws BLException;
	
	/**
	 * �鿴������Ϣָ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO readXMLNodeInfo(IGASM03DTO dto) throws BLException;
	
	/**
	 * �Ƚ�2���汾������ϢXML�е�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO compareXMLInfoByVersion(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸������Ϣ�汾�Ƚϻ�����ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305ActionForXML(IGASM03DTO dto) throws BLException;
	
	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException ;

	/**
	 * �豸��ϵ����POP������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @update 0000201
	 */
	public IGASM03DTO initIGASM1110Action(IGASM03DTO dto) throws BLException;
}
