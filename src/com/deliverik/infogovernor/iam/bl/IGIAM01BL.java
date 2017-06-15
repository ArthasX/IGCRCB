/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;

/**
 * 风险审计业务逻辑接口
 *
 *	@author
 */
public interface IGIAM01BL extends BaseBL {
	
	/** 内审项目管理信息查询处理 */
	public IGIAM01DTO searchIAMAction(IGIAM01DTO dto) throws BLException;
	/** 内审项目查看查询处理 */
	public IGIAM01DTO dsearchIAMAction(IGIAM01DTO dto) throws BLException;
	/** 内审项目更新处理 */
	public IGIAM01DTO updateIAMAction(IGIAM01DTO dto) throws BLException;
	/** 内审项目删除处理 */
	public IGIAM01DTO deleteIAMAction(IGIAM01DTO dto) throws BLException;
	/** 内审项目添加处理 */
	public IGIAM01DTO insertIAMAction(IGIAM01DTO dto) throws BLException;
	
	/**内审工作登记中内审项目弹出页查询  zhaomin */
	public IGIAM01DTO helpSearch(IGIAM01DTO dto) throws BLException;
	
	/**审计报告项目弹出页查询  huiyongzhi */
	public IGIAM01DTO auditProjectHelpSearch(IGIAM01DTO dto) throws BLException;
}
