/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����: ��Ŀ��Ԥ���ϵ���ѯ�����ӿ�
 * ������������Ŀ��Ԥ���ϵ���ѯ�����ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public interface ProjectBudgetRelationSearchCond {
	/**
	 * ��Ŀidȡ��
	 * @return pid_eq ��Ŀid
	 */
	public Integer getPid_eq();
	/**
	 * Ԥ��idȡ��
	 * @return bid_eq Ԥ��id
	 */
	public Integer getBid_eq();
}
