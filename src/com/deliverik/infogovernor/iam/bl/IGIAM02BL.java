/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;

/**
 * ����������ҵ���߼��ӿ�
 *
 *	@author zhaomin
 */
public interface IGIAM02BL extends BaseBL {
	
	/** 
	 * ������������Ϣ��ѯ����
	 */
	public IGIAM02DTO searchIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * �������鿴��ѯ���� 
	 */
	public IGIAM02DTO dsearchIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * ���������´���
	 */
	public IGIAM02DTO updateIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 *������ɾ������ 
	 */
	public IGIAM02DTO deleteIAMAction(IGIAM02DTO dto) throws BLException;
	
	/** 
	 * ��������Ӵ��� 
	 */
	public IGIAM02DTO insertIAMAction(IGIAM02DTO dto) throws BLException;
	
}
