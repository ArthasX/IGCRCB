package com.deliverik.framework.workflow.prd.model.condition;


public class IG731SearchCondImpl implements IG731SearchCond{

	/** �������������� */
	protected Integer pieid;

	/** ����ID(IG500��) */
	protected Integer prid;

	/** ���̱����� */
	protected Integer piid;
	
	/** ��̬��ID��IG007��*/
	protected Integer pidid;

	/** �ʲ�ID(EntityItem��) */
	protected Integer eiid;
	
	/** �Ƿ�Ϊ�����������ʲ� */
	protected String tableColumnValue;

	/** ʱ��� */
	protected String fingerprint;

	/**
	 *��������������ȡ��
	 * @return ��������������
	 */
	public Integer getPieid(){
		return pieid;
	}
	
	/**
	 *���������������趨
	 * @param pieid��������������
	 */
	public void setPieid(Integer pieid){
		this.pieid=pieid;
	}
	
	/**
	 *����ID(IG500��)ȡ��
	 * @return ����ID(IG500��)
	 */
	public Integer getPrid(){
		return prid;
	}

	/**
	 *����ID(IG500��)�趨
	 * @param prid����ID(IG500��)
 	 */
	public void setPrid(Integer prid){
		this.prid=prid;
	}
	
	/**
	 * ���̱�����ȡ��
	 *
	 * @return piid ���̱�����
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ���̱������趨
	 *
	 * @param piid ���̱�����
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 *��̬��ID��IG007��ȡ��
	 * @return ��̬��ID��IG007��
	 */
	public Integer getPidid(){
		return pidid;
	}
	
	/**
	 *��̬��ID��IG007���趨
	 * @param pidid��̬��ID��IG007��
	 */
	public void setPidid(Integer pidid){
		this.pidid=pidid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)ȡ��
	 * @return �ʲ�ID(EntityItem��)
	 */
	public Integer getEiid(){
		return eiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)�趨
	 * @param eiid�ʲ�ID(EntityItem��)
	 */
	public void setEiid(Integer eiid){
		this.eiid=eiid;
	}

	/**
	 * �Ƿ�Ϊ�����������ʲ�ȡ��
	 * @return tableColumnValue �Ƿ�Ϊ�����������ʲ�
	 */
	public String getTableColumnValue() {
		return tableColumnValue;
	}

	/**
	 * �Ƿ�Ϊ�����������ʲ��趨
	 * @param tableColumnValue �Ƿ�Ϊ�����������ʲ�
	 */
	public void setTableColumnValue(String tableColumnValue) {
		this.tableColumnValue = tableColumnValue;
	}

}
