/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM02DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ʒ��Ϣ_��Ʒ��Ϣ�趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM02BL extends BaseBL {
	
	/**
	 * 
	 * Description: ��Ʒ��Ϣ�趨
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO insertGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ��Ʒ��Ϣ��ѯ
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ��ѯ��ָ���Ӵ������¼��ص�������Ʒ��ϢACTION
	 */
	public IGLOM02DTO searchGoodsForRecptionAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ����ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForApplyAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ʳ������ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForSTAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ����ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForEditAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ���Ԥ����ѯACTION
	 */
	public IGLOM02DTO searchGstockWarningAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ���ͳ�Ʋ�ѯACTION
	 */
	public IGLOM02DTO searchGstockAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ���ͳ�Ƶ���ACTION
	 */
	public IGLOM02DTO searchGstockForExcelAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ��Ʒ��Ϣ��ѯ
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsByKey(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ��Ʒ��Ϣɾ��
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO deleteGoodsAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGIOStockDetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoutStockAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ���������ѯ��������ļ�¼
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM02DTO searchGoutStockVWForDestroyAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchIODetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsIODetailAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO searchGoodsIODetail0218Action(IGLOM02DTO dto) throws BLException;
	/**
	 * 
	 * Description: �������
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM02DTO doStock(IGLOM02DTO dto, String methodName) throws BLException;
	
	public String getCodeValue(String code) throws BLException;
	
	public String searchGoodsCodeAction(String gcategory) throws BLException;
	
	/**
	 * 
	 * Description: ÿ���̵�
	 * @param dto
	 * @return IGLOM02DTO
	 * @throws BLException
	 * 
	 */
	public IGLOM02DTO searchInventoryAction(IGLOM02DTO dto) throws BLException;
	
	/**
	 * ÿ���̵��Զ���������
	 * 
	 * @throws BLException
	 */
	public void insertInventoryInfoAction() throws BLException;
}
