/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ������¼�ͳ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class IncidentAveSolveTimeVW implements IncidentAveSolveTimeVWInfo{

	/** �¼����� */
	@Id
	protected String itype;
	
	/** ƽ������¼� */
	protected String solveTime;

	/**
	 * �¼�����ȡ��
	 * @return itype �¼�����
	 */
	public String getItype() {
		return itype;
	}

	/**
	 * �¼������趨
	 * @param itype �¼�����
	 */
	public void setItype(String itype) {
		this.itype = itype;
	}

	/**
	 * ƽ������¼�ȡ��
	 * @return solveTime ƽ������¼�
	 */
	public String getSolveTime() {
		return solveTime;
	}

	/**
	 * ƽ������¼��趨
	 * @param solveTime ƽ������¼�
	 */
	public void setSolveTime(String solveTime) {
		this.solveTime = solveTime;
	}
}
