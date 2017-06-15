/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM05DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ʳ�ù����趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM05BL extends BaseBL {
	
	//�ɱ�
	/**
	 * 
	 * Description: ʳ�óɱ���Ϣ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�óɱ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * ʳ�óɱ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEateryAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�óɱ���Ϣ���
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEateryAction(IGLOM05DTO dto) throws BLException ;
	
	//������
	/**
	 * 
	 * Description: ʳ�ù�������Ϣ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�ù�������Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * ʳ�ù�������Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEworkingLunchAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�ù�������Ϣ���
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEworkingLunchAction(IGLOM05DTO dto) throws BLException ;
	
	//�Ӵ�
	/**
	 * 
	 * Description: ʳ�ýӴ���Ϣ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM05DTO searchEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�ýӴ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO insertEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * ʳ�ýӴ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEentertainmentAction(IGLOM05DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ʳ�ýӴ���Ϣ���
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO updateEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: ʳ�ýӴ���Ϣɾ��
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO deleteEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: �����ͳɱ�ͳ�Ʋ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchWorkLunchEateryAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: �Ӵ�ͳ�Ʋ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchEentertainmentStatisticsAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: ���ŽӴ�ͳ�Ʋ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchDeptEentertainmentAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: ���ͳ�Ʋ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchGoodsStockAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: ��һ��Ʒ���ͳ�Ʋ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchSingleGoodsStockAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * 
	 * Description: ��Ʒ���ͳ����ϸ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM05DTO searchGoodsStockDetailAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * �Ϳ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * �Ϳ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * ������_�Ϳ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchELunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * �Ϳ�״̬���Ĵ���
	 * 
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO changeLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * �Ϳ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initLunchCardAction(IGLOM05DTO dto) throws BLException ;
	
	/**
	 * �Ϳ���Ϣ�趨
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateLunchCardAction(IGLOM05DTO dto) throws BLException ;
	/**
	 * ʳ���д����Ż��ܲ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWAction(IGLOM05DTO dto) throws BLException;
	/**
	 * ʳ���д����Ż�����ϸ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWDetail(IGLOM05DTO dto) throws BLException;
	/**
	 * ʳ����Ʒ������ϸ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchGoutDetailInfo(IGLOM05DTO dto) throws BLException;

}
