package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ����־��Ϣ��������ʵ��
 */
public class IG113SearchCondImpl implements IG113SearchCond {

	/** ����ID */
	protected Integer piid;
	
	/** ��־ID */
	protected Integer rlid;
	
	/** ���̼�¼ID */
	protected Integer prid;
	
	/** ��ֵ�Ƿ�Ϊ�� Y Ϊ�� N ��Ϊ��*/
	protected String valueIsNull;
	
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ����ID�趨
	 * @param piid ����ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * ��־ID�趨
	 * @param rlid ��־ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ֵ�Ƿ�Ϊ��ȡ��
	 * @return valueIsNull ��ֵ�Ƿ�Ϊ��
	 */
	public String getValueIsNull() {
		return valueIsNull;
	}

	/**
	 * ��ֵ�Ƿ�Ϊ���趨
	 * @param valueIsNull ��ֵ�Ƿ�Ϊ��
	 */
	public void setValueIsNull(String valueIsNull) {
		this.valueIsNull = valueIsNull;
	}

}
