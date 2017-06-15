/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.model.Expense;


/**
 * ����ҵ���߼��ӿ�
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
