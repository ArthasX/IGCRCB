/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sya.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sya.dto.IGSYA01DTO;

/**
 * ��Ч����ҵ���߼��ӿ�
 *
 *	@author zhaomin@deliverik.com
 */
public interface IGSYA01BL extends BaseBL {


    /**
     *  ��Ч���˲�ѯ����
     *
     * @param dto IGSVC19DTO
     * 
     * 
     * @return IGSVC19DTO
     */
    public IGSYA01DTO search(IGSYA01DTO dto) throws BLException;
    
    /**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGSYA01DTO regist(IGSYA01DTO dto) throws BLException;
	
	public IGSYA01DTO init(IGSYA01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: ���
	 * </p>
	 * 
	 * @param dto IGSVC19DTO
	 * @return IGSVC19DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYA01DTO update(IGSYA01DTO dto) throws BLException;
	
	 /**
     * ɾ��
     */
    public IGSYA01DTO deleteTrain(IGSYA01DTO dto)throws BLException;
        
}
