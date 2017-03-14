/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;

/**
 * �������ҵ���߼��ӿ�
 *
 *	@author
 */
public interface IGIAM01BL extends BaseBL {
	
	/** ������Ŀ������Ϣ��ѯ���� */
	public IGIAM01DTO searchIAMAction(IGIAM01DTO dto) throws BLException;
	/** ������Ŀ�鿴��ѯ���� */
	public IGIAM01DTO dsearchIAMAction(IGIAM01DTO dto) throws BLException;
	/** ������Ŀ���´��� */
	public IGIAM01DTO updateIAMAction(IGIAM01DTO dto) throws BLException;
	/** ������Ŀɾ������ */
	public IGIAM01DTO deleteIAMAction(IGIAM01DTO dto) throws BLException;
	/** ������Ŀ��Ӵ��� */
	public IGIAM01DTO insertIAMAction(IGIAM01DTO dto) throws BLException;
	
	/**�������Ǽ���������Ŀ����ҳ��ѯ  zhaomin */
	public IGIAM01DTO helpSearch(IGIAM01DTO dto) throws BLException;
	
	/**��Ʊ�����Ŀ����ҳ��ѯ  huiyongzhi */
	public IGIAM01DTO auditProjectHelpSearch(IGIAM01DTO dto) throws BLException;
}
