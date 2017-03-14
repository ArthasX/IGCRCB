/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;


/**
 * Ԥ��ҵ���߼��ӿ�
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
	
	/** ��Ŀ�Ǽ�ҳ��Ԥ�㼯�ϳ�ʼ��*/
	public IGFIN01DTO initProjectBudgetList(IGFIN01DTO dto) throws BLException;
	
}
