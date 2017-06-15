/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.model.Expense;


/**
 * 费用业务逻辑接口
 *
 *
 */
public interface IGFIN02BL extends BaseBL {

	public IGFIN02DTO insertExpenseTBDAOAction(IGFIN02DTO dto) throws BLException;
	
	public IGFIN02DTO searchExpenseAction(IGFIN02DTO dto) throws BLException;
	
	public IGFIN02DTO initIGFIN0206Action(IGFIN02DTO dto) throws BLException;
	
	public IGFIN02DTO deleteExpenseAction(IGFIN02DTO dto) throws BLException;
	
	public List<Expense> findExpenseByBid(String bid) throws BLException;
	
}
