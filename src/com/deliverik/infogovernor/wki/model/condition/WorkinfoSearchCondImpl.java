/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.model.condition;

/**
  * ����: ������Ϣ��������ʵ��
  * ��������: ������Ϣ��������ʵ��
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
public class WorkinfoSearchCondImpl implements
		WorkinfoSearchCond {
	
	protected Integer workInfoId;
	//��������
	protected String workName;
	//������ID
	protected Integer initId;
	//����������
	protected String initName;
	//ִ����id
	protected Integer execId;
	//ִ��������
	protected String execName;
	public Integer getWorkInfoId() {
		return workInfoId;
	}
	public void setWorkInfoId(Integer workInfoId) {
		this.workInfoId = workInfoId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Integer getInitId() {
		return initId;
	}
	public void setInitId(Integer initId) {
		this.initId = initId;
	}
	public String getInitName() {
		return initName;
	}
	public void setInitName(String initName) {
		this.initName = initName;
	}
	public Integer getExecId() {
		return execId;
	}
	public void setExecId(Integer execId) {
		this.execId = execId;
	}
	public String getExecName() {
		return execName;
	}
	public void setExecName(String execName) {
		this.execName = execName;
	}
	
	
}