/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * ����Ϣ��ѯ����Form
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0161Form extends BaseForm implements IG992Info{

	protected String mode = "0";


	protected Integer Pedid;


	/** �ⲿ�¼�ID */
	protected String pedeventid;

	/** �ⲿ���� */
	protected String pedaction;

	/** �ⲿ�¼����� */
	protected String peddesc;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPedid() {
		return Pedid;
	}

	/**
	 * �����趨
	 *
	 * @param Pedid ����
	 */
	public void setPedid(Integer Pedid) {
		this.Pedid = Pedid;
	}

	/**
	 * �¼�IDȡ��
	 *
	 * @return �¼�ID
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �¼�ID�趨
	 *
	 * @param pedeventid �¼�ID
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * �ⲿ�¼�����ȡ��
	 *
	 * @return �ⲿ�¼�����
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * �ⲿ�¼������趨
	 *
	 * @param pedaction �ⲿ�¼�����
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * �����趨
	 *
	 * @param peddesc ����
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

}
