/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN03DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0301Form;
import com.deliverik.infogovernor.fin.model.Budget;


/**
 * ͳ��ҵ���߼��ӿ�
 *
 *
 */
public interface IGFIN03BL extends BaseBL {

	
	public List<Budget> findBudgetByCondition(IGFIN03DTO dto) throws BLException;
	
	public ArrayList findExpenseByCondition(IGFIN03DTO dto,boolean flag) throws BLException;
	
	public String getXmlByCondition(IGFIN0301Form form) throws BLException;
	
}
