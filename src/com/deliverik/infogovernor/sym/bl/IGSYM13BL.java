package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM13DTO;

/**
 * �����ʼ�����ҵ���߼��ӿ�
 *
 * 
 */
public interface IGSYM13BL extends BaseBL {

	/**
	 * <p>
	 * �����ʼ�
	 * </p>
	 * @throws BLException
	 * @author sunkaiyu@deliverik.com
	 */
	public IGSYM13DTO sendMail(IGSYM13DTO dto) throws BLException;
	
	/**
	 * <p>
	 * ���Ͷ���
	 * </p>
	 * @throws BLException
	 * @author sunkaiyu@deliverik.com
	 */
	public IGSYM13DTO sendSMS(IGSYM13DTO dto) throws BLException;
}
