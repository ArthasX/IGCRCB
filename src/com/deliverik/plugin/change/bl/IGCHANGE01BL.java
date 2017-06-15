package com.deliverik.plugin.change.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发起变更日志处理BL接口
 * </p>
 * 
 * @author dinghaonan@deliverik.com
 * @version 1.0
 */
public interface IGCHANGE01BL extends BaseBL{
	
	public IGCHANGE01DTO registIGCHANGEAction(IGCHANGE01DTO dto) throws BLException;
	
	public IGCHANGE01DTO saveInitiacteChangeAction(IGCHANGE01DTO dto) throws BLException;
	
	/**根据prid 查询变更日志记录*/
	public IGCHANGE01DTO searchInitiacteChangeAction(IGCHANGE01DTO dto) throws BLException;
}
