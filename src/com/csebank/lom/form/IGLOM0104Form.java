/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ���������Form
 *
 */
public class IGLOM0104Form extends BaseForm implements RecptionGuestSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ӵ�����ID
	 */
	protected Integer rid;
	
	/** ɾ���Ӵ����˶��� */
	protected String[] deleteRgid;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	protected String flag;
	

	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * ɾ���Ӵ����˶���ȡ��
	 * @return ɾ���Ӵ����˶���
	 */
	public String[] getDeleteRgid() {
		return deleteRgid;
	}

	/**
	 * ɾ���Ӵ����˶����趨
	 * @param deleteRgid ɾ���Ӵ����˶���
	 */
	public void setDeleteRgid(String[] deleteRgid) {
		this.deleteRgid = deleteRgid;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * ״̬�趨
	 * @param rstatus ״̬
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
