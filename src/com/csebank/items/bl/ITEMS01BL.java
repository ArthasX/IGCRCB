/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.model.condition.InStockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface ITEMS01BL extends BaseBL {
	
	public ITEMS01DTO searchItemsCategoryAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO insertItemsCategoryAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO findItemsCategoryByPkAction(ITEMS01DTO dto) throws BLException;
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto, String temp) throws BLException;
	/**
	 * ��ѯstock���е���Ʒ
	 */
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto) throws BLException;
	public ITEMS01DTO statStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯstock���е���Ʒ(����ʹ��)
	 */
	public ITEMS01DTO searchStockForInsertOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯstock����ָ����Ʒ����ϸ��Ϣ
	 */
	public ITEMS01DTO searchStockDetailAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstock����ָ����¼����ϸ��Ϣ
	 */
	public ITEMS01DTO searchOutStockDetailAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstock���еļ�¼(VW)
	 */
	public ITEMS01DTO searchOutStockVWAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstockVW��ͼ�еļ�¼(�����嵥)
	 */
	public ITEMS01DTO searchOutStockBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstockVW��ͼ�еļ�¼(�����嵥��ϸ)
	 */
	public ITEMS01DTO searchOutStockDetailBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstockVW��ͼ�еļ�¼(�����嵥��ϸExcel����)
	 */
	public ITEMS01DTO searchExcelDataBy0148Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * �����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
	 * @param ITEMS01DTO
	 * @return boolean true:���� false:������
	 */
	public boolean checkRoleManagerByUserID(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯoutstock���еĴ�������¼
	 */
	public ITEMS01DTO searchOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯ�Ĳ�֪ͨ
	 *   ������ʾ��֧�н����������ʾδ���յ�֧�У�
	 *   ֧����ʾ���������²���Ʒ/������Ʒ������� ��ʾ������Ʒ���
	 */
	public ITEMS01DTO searchOutStockForNoticeAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��Ʒ���죨����outstock��������һ�������¼��
	 */
	public ITEMS01DTO insertOutStockAction(ITEMS01DTO dto) throws BLException;

	/**
	 * ��������
	 */
	public ITEMS01DTO approveOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ����
	 */
	public ITEMS01DTO receiveOutStockAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ���ݴ��������ȡ�䲿�ֵ������б�(��������ҳ��'״̬'��)
	 */
	public List<LabelValueBean> getPartItemsCodes(String selectid);
	
	/**
	 * ���ݴ��������ȡ�䲿�ֵ������б�(�ҵ�����ҳ��'״̬'��)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0144(String selectid);
	
	/**
	 * ���ݴ��������ȡ�䲿�ֵ������б�('�²���ѯ'ҳ��'״̬'��)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0147(String selectid);
	
	/**
	 * ���ݴ��������ȡ��ȫ���������б�
	 */
	public List<LabelValueBean> getItemsCodes(String selectid);
	
	/**
	 * ���ݴ��������ȡ��ȫ���������б�
	 */
	public List<LabelValueBean> getItemsCodesFor0129Action(String selectid);
	
	/**
	 * ���ݴ��������ȡ������嵥
	 */
	public ITEMS01DTO searchPaymentItems(ITEMS01DTO dto);
	
	public ITEMS01DTO searchInStockAction(ITEMS01DTO dto) throws BLException;

	public List<LabelValueBean> getPartOutStockTypeCodes(String selectid);

	public ITEMS01DTO reportInStockAction(ITEMS01DTO dto) throws BLException;

	public ITEMS01DTO doStock(ITEMS01DTO dto,String methodName) throws BLException;
	
	public String getRequsetStatus(String selectid) throws BLException;
	
	public ITEMS01DTO reportOutStockAction(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO searchPaymentDetail(ITEMS01DTO dto) throws BLException;
	
	public void changeRequsetStatus(String selectid,String requestStatus) throws BLException;
	
	public String getOutTypeName(String selectid,String typecode) throws BLException;
	
	/**
	 * ��ѯ�ֿ�����
	 */
	public ITEMS01DTO searchITEMS0169Action(ITEMS01DTO dto) throws BLException;
	
	/**
	 * ��ѯ��Ʒ����
	 */
	public ITEMS01DTO searchITEMS0171Action(ITEMS01DTO dto) throws BLException;
	
	public ITEMS01DTO changeCategoryStatusAction(ITEMS01DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public ITEMS01DTO searchOrganizationAction(ITEMS01DTO dto)  throws BLException;
	
	/**
	 * �����²� ��Ʒ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public ITEMS01DTO searchStockForOrgAction(ITEMS01DTO dto)  throws BLException;
	
	/**
	 * ��ѯ���һ�������Ʒ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String searchOldStockAction(InStockSearchCond cond)  throws BLException;
}
