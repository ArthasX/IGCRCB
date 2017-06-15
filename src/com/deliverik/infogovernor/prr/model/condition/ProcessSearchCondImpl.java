/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.model.condition;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯ��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessSearchCondImpl implements ProcessSearchCond{

	/** ���̶���ID */
	protected String pdid;
	
	/** ��ѯ������ʶ */
	protected String[] queryKey;
	
	/** ��ѯ����ֵ */
	protected String[] queryValue;
	
	/** ��ʾ�м��� */
	protected List<IG110Info> showColumnList;
	
	/** ��ѯ�������弯�� */
	protected List<IG111Info> queryList;

	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ѯ������ʶȡ��
	 * @return queryKey ��ѯ������ʶ
	 */
	public String[] getQueryKey() {
		return queryKey;
	}

	/**
	 * ��ѯ������ʶ�趨
	 * @param queryKey ��ѯ������ʶ
	 */
	public void setQueryKey(String[] queryKey) {
		this.queryKey = queryKey;
	}

	/**
	 * ��ѯ����ֵȡ��
	 * @return queryValue ��ѯ����ֵ
	 */
	public String[] getQueryValue() {
		return queryValue;
	}

	/**
	 * ��ѯ����ֵ�趨
	 * @param queryValue ��ѯ����ֵ
	 */
	public void setQueryValue(String[] queryValue) {
		this.queryValue = queryValue;
	}

	/**
	 * ��ʾ�м���ȡ��
	 * @return showColumnList ��ʾ�м���
	 */
	public List<IG110Info> getShowColumnList() {
		return showColumnList;
	}

	/**
	 * ��ʾ�м����趨
	 * @param showColumnList ��ʾ�м���
	 */
	public void setShowColumnList(List<IG110Info> showColumnList) {
		this.showColumnList = showColumnList;
	}

	/**
	 * ��ѯ�������弯��ȡ��
	 * @return queryList ��ѯ�������弯��
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * ��ѯ�������弯���趨
	 * @param queryList ��ѯ�������弯��
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
}
