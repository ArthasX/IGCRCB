/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ�ýӴ���Ϣ��ѯ�ӿ�ʵ��
 *
 */
public class EentertainmentSearchCondImpl implements EentertainmentSearchCond {
	
	/**
	 * ʳ�ýӴ���Ϣ��ʼʱ���ѯ
	 */
	public String eetime_from;
	
	/**
	 * ʳ�ýӴ���Ϣ����ʱ���ѯ
	 */
	public String eetime_to;
	
	public Integer rid_mon;
	
	public Integer rid_org;

	/**
	 * ʳ�ýӴ���Ϣʱ���ѯȡ��
	 * @return ʳ�ýӴ���Ϣ��ʼʱ���ѯ
	 */
	public String getEetime_from() {
		return eetime_from;
	}

	/**
	 * ʳ�ýӴ���Ϣ��ʼʱ���ѯ�趨
	 * @param eetime_from ʳ�ýӴ���Ϣ��ʼʱ���ѯ
	 */
	public void setEetime_from(String eetime_from) {
		this.eetime_from = eetime_from;
	}

	/**
	 * ʳ�ýӴ���Ϣ����ʱ���ѯȡ��
	 * @return ʳ�ýӴ���Ϣ����ʱ���ѯ
	 */
	public String getEetime_to() {
		return eetime_to;
	}

	/**
	 * ʳ�ýӴ���Ϣ����ʱ���ѯ�趨
	 * @param eetime_to ʳ�ýӴ���Ϣ����ʱ���ѯ
	 */
	public void setEetime_to(String eetime_to) {
		this.eetime_to = eetime_to;
	}

	public Integer getRid_mon() {
		return rid_mon;
	}

	public void setRid_mon(Integer rid_mon) {
		this.rid_mon = rid_mon;
	}

	public Integer getRid_org() {
		return rid_org;
	}

	public void setRid_org(Integer rid_org) {
		this.rid_org = rid_org;
	}

}
