/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����: ��Ŀ��Ԥ���ϵ���ѯ����ʵ��
 * ������������Ŀ��Ԥ���ϵ���ѯ����ʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public class ProjectBudgetRelationSearchCondImpl implements ProjectBudgetRelationSearchCond{
	/** ��Ŀid */
	private Integer pid_eq;
	/** Ԥ��id */
	private Integer bid_eq;
	/**
	 * ��Ŀidȡ��
	 * @return pid_eq ��Ŀid
	 */
	public Integer getPid_eq() {
		return pid_eq;
	}
	/**
	 * ��Ŀid�趨
	 * @param pid_eq ��Ŀid
	 */
	public void setPid_eq(Integer pid_eq) {
		this.pid_eq = pid_eq;
	}
	/**
	 * Ԥ��idȡ��
	 * @return bid_eq Ԥ��id
	 */
	public Integer getBid_eq() {
		return bid_eq;
	}
	/**
	 * Ԥ��id�趨
	 * @param bid_eq Ԥ��id
	 */
	public void setBid_eq(Integer bid_eq) {
		this.bid_eq = bid_eq;
	}
}	
