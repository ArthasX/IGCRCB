/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;

/**
 * 内审工作管理业务逻辑接口
 *
 *	@author zhaomin
 */
public interface IGIAM02BL extends BaseBL {
	
	/** 
	 * 内审工作管理信息查询处理
	 */
	public IGIAM02DTO searchIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * 内审工作查看查询处理 
	 */
	public IGIAM02DTO dsearchIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * 内审工作更新处理
	 */
	public IGIAM02DTO updateIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 *内审工作删除处理 
	 */
	public IGIAM02DTO deleteIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * 内审工作添加处理 
	 */
	public IGIAM02DTO insertIAMAction(IGIAM02DTO dto) throws BLException;
	
}
