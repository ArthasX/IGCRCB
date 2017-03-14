package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;

/**
 * ��ͬ���ù���ҵ���߼��ӿ�
 *
 * 
 */
public interface IGASM04BL extends BaseBL {


	/**
	 * ��ͬ��Ϣ��ѯ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * ��ͬ��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * ��ͬ��Ϣɾ������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemAction(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0404Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ������Ϣ�༭����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO editEntityItemAction(IGASM04DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * ��ͬ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0405Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ��ϵ��������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0406Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ��ϵɾ������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemRelationAction(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0407Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ��ϵ�ǼǴ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemRelationAction(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ��ϵ�������
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItemRelationAction(IGASM04DTO dto) throws BLException;
	
	/**
	 *	��ȡ��ͬ������ϵ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchRelationListAction(IGASM04DTO dto) throws BLException;
	
	/**
	 *��ͬ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initEntityItem(IGASM04DTO dto) throws BLException;
	/**
	 *��ͬ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItem(IGASM04DTO dto) throws BLException;
	
	/**
	 * ��ȡ��ͬ������ֵ
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemLableAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ��Ǻ�ͬ�ʲ������ɫ������
	 * 
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 * @throws BLException 
	 */
	public IGASM04DTO checkEntityItemDomain(IGASM04DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ǽǲ�ѯ����(��ӦӦ����Ǽǲ�ѯ)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVWAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * Ӧ����Ǽǲ�ѯ����2(��ӦӦ�����ѯ)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVW2Action(IGASM04DTO dto) throws BLException;

	
	/**
	 * ��ͬ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0422Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ����Ǽǳ�����ʾ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO initIGASM0421Action(IGASM04DTO dto) throws BLException;

	/**
	 * ��ͬ����ǼǴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO editIGASM0421Action(IGASM04DTO dto) throws BLException; 
	
	/**
     * ��ͬͳ�Ʋ�ѯ����
     * add by zhangze
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGASM04DTO searchStatics(IGASM04DTO dto) throws BLException;
	
	/**
	 * ��ͬ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0420Action(IGASM04DTO dto) throws BLException;
}
