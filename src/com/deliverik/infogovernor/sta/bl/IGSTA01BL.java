/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sta.dto.IGSTA01DTO;

/**
 * �����ලҵ���߼��ӿ�
 *
 *	@author liupeng@deliverik.com
 */
public interface IGSTA01BL extends BaseBL {
	
	/**
	 * �������ļල��ѯ����
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchRiskcheckproblemsuperviseAction(IGSTA01DTO dto) throws BLException;
	
	/**
     * ��ͬͳ�Ʋ�ѯ����
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO searchContractAmountAction(IGSTA01DTO dto) throws BLException;
    
    /**
     * ��Ŀͳ�Ʋ�ѯ����
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO searchPrjRecAction(IGSTA01DTO dto) throws BLException;
    
    /**
     * ��ͬģ��labelvaluebean��ѯ����
     *
     * @param dto IGSTA01DTO
     * @return IGSTA01DTO
     */
    public IGSTA01DTO getContractLabel(IGSTA01DTO dto) throws BLException ;
    
    /**
     * ��ͬ��Ϣ��ѯ����
     *
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGSTA01DTO searchEntityItemAction(IGSTA01DTO dto) throws BLException;
}
