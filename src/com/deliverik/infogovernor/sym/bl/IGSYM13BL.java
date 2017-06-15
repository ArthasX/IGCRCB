package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM13DTO;

/**
 * 发送邮件短信业务逻辑接口
 *
 * 
 */
public interface IGSYM13BL extends BaseBL {

	/**
	 * <p>
	 * 发送邮件
	 * </p>
	 * @throws BLException
	 * @author sunkaiyu@deliverik.com
	 */
	public IGSYM13DTO sendMail(IGSYM13DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 发送短信
	 * </p>
	 * @throws BLException
	 * @author sunkaiyu@deliverik.com
	 */
	public IGSYM13DTO sendSMS(IGSYM13DTO dto) throws BLException;
}
