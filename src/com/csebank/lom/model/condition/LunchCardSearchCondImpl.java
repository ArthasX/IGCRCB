/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ�óɱ���Ϣ��ѯ�ӿ�ʵ��
 *
 */
public class LunchCardSearchCondImpl implements LunchCardSearchCond {
	
	/**
	 * �Ϳ�����
	 */
	public String typename;
	
	/**
	 * �Ϳ�״̬
	 */
	public String desc;
	
	/**
	 * �Ϳ����
	 */
	public Integer icid;

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

}
