/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ʲ�ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessInfoEntity implements ProcessInfoEntityInfo {
	
	/** �ʲ�ID */
	protected Integer eiid;
	
	/** �ʲ��汾�� */
	protected Integer eiversion;
	
	/** �ʲ����� */
	protected String einame;

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}


	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	
	/**
	 * �ʲ�IDȡ��
	 * @return eiid �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ��汾��ȡ��
	 * @return eiversion �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return einame �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
}
