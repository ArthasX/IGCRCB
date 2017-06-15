package com.deliverik.infogovernor.soc.iop.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP02DTO;

/**
 * �豸Ӱ�����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGIOP02BL extends BaseBL {


	/**
	 * ����IP�ʲ���eiid ��ѯ
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIPByEiids(IGIOP02DTO dto)throws BLException;
	/**
	 * IP�ʲ���ѯ
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIP(IGIOP02DTO dto)throws BLException;
	
	/**
	 * IP����
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO recoveryIP(IGIOP02DTO dto)throws BLException;
	
	/**
	 * ����eiid ��ѯIP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP02DTO getIPByEiid(IGIOP02DTO dto)throws BLException;
	
	/**
	 * IP����
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO allotIP(IGIOP02DTO dto)throws BLException;
	
}
