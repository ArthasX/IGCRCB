/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.zwj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.zwj.dto.IGZWJ01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 武警总院流程相关BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGZWJ01BL extends BaseBL{

	public IGZWJ01DTO searchOrgnameAction(IGZWJ01DTO dto) throws BLException;
	
	public IGZWJ01DTO searchUserInfoAction(IGZWJ01DTO dto) throws BLException;
}
