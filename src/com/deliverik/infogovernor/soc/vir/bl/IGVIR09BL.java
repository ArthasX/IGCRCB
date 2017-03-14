package com.deliverik.infogovernor.soc.vir.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR09DTO;

public interface IGVIR09BL extends BaseBL {
	
	/**
	 * ��ȡ������Դ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO getConfigItemList(IGVIR09DTO dto) throws BLException;
	
	/**
	 * ���������Դ�ƷѲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO insertBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * ������Դ�ƷѲ��Բ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO searchBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * ͨ��id��ȡ�ƷѲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO getBillingStrategyByID(IGVIR09DTO dto) throws BLException;
	
	/**
	 * �޸ļƷѲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO updateBillingStrategy(IGVIR09DTO dto) throws BLException;
	
	/**
	 * ɾ���ƷѲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR09DTO deleteBillingStrategy(IGVIR09DTO dto) throws BLException;
}
