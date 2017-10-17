package com.dev.hac.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.dev.hac.dto.IGHAC01DTO;
/**
 * 数据管理业务逻辑接口
 *
 * 
 */
public interface IGHAC01BL extends BaseBL {
	
	/**
	 * <p>
	 * 查询数据信息树
	 * </p>
	 * @throws BLException
	 * @author lvxin@deliverik.com
	 */
	public IGHAC01DTO searchCodeTreeAction(IGHAC01DTO dto) throws BLException;

}