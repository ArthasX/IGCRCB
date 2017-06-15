/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;


/**
 * 预算业务逻辑接口
 *
 *
 */
public interface IGFIN01BL extends BaseBL {


	public IGFIN01DTO insertBudgetTBDAOAction(IGFIN01DTO dto) throws BLException;
	
	
	public IGFIN01DTO searchBudgetAction(IGFIN01DTO dto) throws BLException;
	
	
	public IGFIN01DTO initIGFIN0103Action(IGFIN01DTO dto) throws BLException;
	
	public IGFIN01DTO initIGFIN0102Action(IGFIN01DTO dto) throws BLException;
	
	public IGFIN01DTO deleteBudgetAction(IGFIN01DTO dto) throws BLException;
	
	
	public IGFIN01DTO updateBudgetAction(IGFIN01DTO dto) throws BLException;
	
	
	public IGFIN01DTO findBudgetByPcode(IGFIN01DTO dto) throws BLException;
	
	/** 项目登记页面预算集合初始化*/
	public IGFIN01DTO initProjectBudgetList(IGFIN01DTO dto) throws BLException;
	
}
