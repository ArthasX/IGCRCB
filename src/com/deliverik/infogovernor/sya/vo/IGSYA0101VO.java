/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sya.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;

/**
 * ����: �ƶȲ�ѯvo
 * ������¼:  
 * �޸ļ�¼: 
 */

@SuppressWarnings("serial")
public class IGSYA0101VO extends BaseVO implements Serializable {
    
	/**��ѯ�������*/
    protected List<InstitutionInfo> institutionList;

	/**
	 * ��ѯ�������ȡ��
	 * @return institutionList  ��ѯ�������
	 */
	public List<InstitutionInfo> getInstitutionList() {
		return institutionList;
	}

	/**
	 * ��ѯ��������趨
	 * @param institutionList  ��ѯ�������
	 */
	public void setInstitutionList(List<InstitutionInfo> institutionList) {
		this.institutionList = institutionList;
	}

    
}