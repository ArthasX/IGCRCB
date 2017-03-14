/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM01DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ӵ�����_�Ӵ������趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM01BL extends BaseBL {
	
	/**
	 * 
	 * Description: �Ӵ���Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionAction(IGLOM01DTO dto) throws BLException;
	/**
	 * ����Ͳ͹�����Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM01DTO  searchDealInfo(IGLOM01DTO dto)throws BLException;
	
	/**
	 * 
	 * Description: �Ӵ���Ϣ�趨
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO insertRecptionAction(IGLOM01DTO dto) throws BLException;
	/**
	 * ����Ͳ���Ϣ�Ǽ���⴦��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM01DTO insetDealInfo(IGLOM01DTO dto)throws BLException;
	
	/**
	 * 
	 * Description: �Ӵ���Ϣ���
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO updateRecptionAction(IGLOM01DTO dto) throws BLException ;
	public IGLOM01DTO updateDealAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * ״̬���³�����ʾ
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecption(IGLOM01DTO dto) throws BLException ;
	/**
	 * ״̬���³�����ʾ
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initDeal(IGLOM01DTO dto) throws BLException ;

	/**
	 * ״̬���´���
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeRecptionAction(IGLOM01DTO dto) throws BLException ;
	/**
	 * ����Ͳ�״̬���´���
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeDealAction(IGLOM01DTO dto) throws BLException ;
	/**
	 * ɾ������
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * ɾ������
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteDealAction(IGLOM01DTO dto) throws BLException ;

	
	/**
	 * 
	 * Description: �Ӵ�������Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionGuestAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �Ӵ�������Ϣ�趨
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO insertRecptionGuestAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �Ӵ�������Ϣ���
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM01DTO updateRecptionGuestAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * �Ӵ����˳�����ʾ
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecptionGuest(IGLOM01DTO dto) throws BLException ;

	/**
	 * �Ӵ�����ɾ������
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionGuestAction(IGLOM01DTO dto) throws BLException ;
	
	/**
	 * 
	 * �Ӵ�ͳ����Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * ����Ͳ�ͳ����Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchDealVWAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * ���ŽӴ�ͳ����Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionOrgVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * ��������Ͳ�ͳ����Ϣ��ѯ
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchDealOrgVWAction(IGLOM01DTO dto) throws BLException;
	/**
	 * 
	 * Description: �Ӵ����˲�ѯ����
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM01DTO searchRecptionGuestInfoAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ���ݿͻ���Ϣ��ѯ�Ӵ�������Ϣ����
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 */
	public IGLOM01DTO searchRecptionByGusetAction(IGLOM01DTO dto) throws BLException;
	
	/**
	 * Description:�Ӵ�����������Ϣ��ѯ����
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 * @throws BLException
	 */
	public IGLOM01DTO searchRecptionCostAction(IGLOM01DTO dto) throws BLException;

}
