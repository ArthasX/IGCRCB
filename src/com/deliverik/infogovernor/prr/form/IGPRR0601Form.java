/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0601Form extends BaseForm{

	/** ���̶���ID */
	protected String pdid;
	
	/** ��ѯ������ʶ */
	protected String[] queryKey;
	
	/** ��ѯ����ֵ */
	protected String[] queryValue;

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

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
}

