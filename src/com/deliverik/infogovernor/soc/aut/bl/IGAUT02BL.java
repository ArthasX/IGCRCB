/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT02DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_个人工作业务逻辑接口 
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public interface IGAUT02BL extends BaseBL {

	public IGAUT02DTO checkEntityItemDomain(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemAction(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0201Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0202Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0203Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0204Action(IGAUT02DTO dto) throws BLException;
	public IGAUT02DTO searchEntityItemFor0205Action(IGAUT02DTO dto) throws BLException;
}
