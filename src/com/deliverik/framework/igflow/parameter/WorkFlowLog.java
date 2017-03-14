/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ������־������Ϣ
 */
public class WorkFlowLog implements WorkFlowLogInfo {

	/** ��Ȩ�û�ID */
	private String authuserid;

	/** ��ע */
	private String comment;

	/** ��ǰ�û�ID */
	private String executorid;
	
	/** ���̴����ɫID */
	private Integer executorRoleid;
	
	/** ����ID */
	private Integer prid;

	/**
	 * ��Ȩ�û�IDȡ��
	 * 
	 * @return ��Ȩ�û�ID
	 */
	public String getAuthuserid() {
		return authuserid;
	}

	/**
	 * ��עȡ��
	 * 
	 * @return ��ע
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * ��ǰ�û�IDȡ��
	 * 
	 * @return ��ǰ�û�ID
	 */
	public String getExecutorid() {
		return executorid;
	}

	/**
	 * ���̴����ɫIDȡ��
	 * 
	 * @return ���̴����ɫID
	 */
	public Integer getExecutorRoleid() {
		return executorRoleid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��Ȩ�û�ID�趨
	 * 
	 * @param authuserid ��Ȩ�û�ID����Ϊ�գ�
	 */
	public void setAuthuserid(String authuserid) {
		this.authuserid = authuserid;
	}

	/**
	 * ��ע�趨
	 * 
	 * @param comment ��ע
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * ��ǰ�û�ID�趨
	 * 
	 * @param executorid ��ǰ�û�ID
	 */
	public void setExecutorid(String executorid) {
		this.executorid = executorid;
	}

	/**
	 * ���̴����ɫID�趨
	 * 
	 * @param executorRoleid ���̴����ɫID
	 */
	public void setExecutorRoleid(Integer executorRoleid) {
		this.executorRoleid = executorRoleid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
}
