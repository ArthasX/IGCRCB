package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ��ƶԱȽ����������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM21021VO extends BaseVO implements Serializable{
	
	/** ��ƶԱȽ��������� */
	protected List<AuditResultInfo> auditResultList;

	/**
	 * ��ƶԱȽ���������ȡ��
	 * @return ��ƶԱȽ���������
	 */
	public List<AuditResultInfo> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * ��ƶԱȽ�������������
	 * @param auditResultList ��ƶԱȽ���������
	 */
	public void setAuditResultList(List<AuditResultInfo> auditResultList) {
		this.auditResultList = auditResultList;
	}
}


