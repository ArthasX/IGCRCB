/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;

public interface IGFIN04BL extends BaseBL {

	public IGFIN02DTO findCountByBudget(IGFIN02DTO dto) throws BLException;

	public IGFIN02DTO findBudgetByBType(IGFIN02DTO dto) throws BLException;

	public IGFIN02DTO findExpenseByBType(IGFIN02DTO dto) throws BLException;

	public IGFIN02DTO findCountByExpense(IGFIN02DTO dto) throws BLException;

	public IGFIN02DTO findBudgetByExpense(IGFIN02DTO dto) throws BLException;

	public IGFIN02DTO findExpenseByExpense(IGFIN02DTO dto) throws BLException;

}
