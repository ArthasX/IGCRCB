/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ط���ѡ���б�Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0305Form extends BaseForm{
	
	/** ����ʵ��ID */
	protected Integer prid;

	/** ���̶���ID */
	protected String pdid;
	
	/** ״̬�ڵ㶨��ID */
	protected String psdid;
	
	/** �����ɫID */
	protected Integer roleid;
	
	/** ��չ���� */
	protected String parameters;

	/**
	 * ����ʵ��IDȡ��
	 * @return prid ����ʵ��ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ʵ��ID�趨
	 * @param prid ����ʵ��ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬�ڵ㶨��IDȡ��
	 * @return psdid ״̬�ڵ㶨��ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬�ڵ㶨��ID�趨
	 * @param psdid ״̬�ڵ㶨��ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �����ɫIDȡ��
	 * @return roleid �����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �����ɫID�趨
	 * @param roleid �����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��չ����ȡ��
	 * @return parameters ��չ����
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * ��չ�����趨
	 * @param parameters ��չ����
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
