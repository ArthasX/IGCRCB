/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.condition;


public class ProcessInfoEntityKnSearchCondImpl implements ProcessInfoEntityKnSearchCond{

	/** �������������� */
	protected Integer piekid;

	/** ����ID(ProcessRecordKn��) */
	protected Integer prkid;

	/** ��̬��ID��IG007��*/
	protected Integer pidid;

	/** �ʲ�ID(EntityItem��) */
	protected Integer eiid;

	/** ʱ��� */
	protected String fingerprint;
	

	/**
	 *��������������ȡ��
	 * @return ��������������
	 */
	public Integer getPiekid(){
		return piekid;
	}
	
	/**
	 *���������������趨
	 * @param pieid��������������
	 */
	public void setPiekid(Integer piekid){
		this.piekid=piekid;
	}
	
	/**
	 *����ID(ProcessRecordKn��)ȡ��
	 * @return ����ID(ProcessRecordKn��)
	 */
	public Integer getPrkid(){
		return prkid;
	}

	/**
	 *����ID(ProcessRecordKn��)�趨
	 * @param prid����ID(ProcessRecordKn��)
 	 */
	public void setPrkid(Integer prkid){
		this.prkid=prkid;
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

}
