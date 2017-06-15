/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ���̶����ѯ����Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0109Form extends BaseForm {

	/** 
	 * ���̲����߱���Ȩ��ID 
	 */
	protected String ptdid;
	
	/** ����ID */
	protected String pdid;
	
	/**
	 * ����״̬ID��From��
	 */
	protected String fpsdid;
	
	/**
	 * ����״̬ID��To��
	 */
	protected String tpsdid;
	
	/** ������״̬ID */
	protected String ppsdid;
	
	/**
	 * �Ƿ�ȱʡ�������ʶ��1��
	 */
	protected String flag;
	
	/**
	 * ����״̬������ID
	 */
	protected String[] roleidArray;
	
	/**
	 * ����״̬ԾǨ����
	 */
	protected String[] condArray;
	
	/**
	 * �߼��������
	 */
	protected String[] logicSign;
	
	/**
	 * ����ID
	 */
	protected String[] variableID;
	
	/**
	 * ����ֵ
	 */
	protected String[] vvalue;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬ԾǨ����IDȡ��
	 * @return ����״̬ԾǨ����ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * ����״̬ԾǨ����ID�趨
	 * @param ptdid ����״̬ԾǨ����ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * ����״̬ID��From��ȡ��
	 * @return ����״̬ID��From��
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * ����״̬ID��From���趨
	 * @param fpsdid ����״̬ID��From��
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * ����״̬ID��To��ȡ��
	 * @return ����״̬ID��To��
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * ����״̬ID��To���趨
	 * @param tpsdid ����״̬ID��To��
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * ����״̬������IDȡ��
	 * @return ����״̬������ID
	 */
	public String[] getRoleidArray() {
		return roleidArray;
	}

	/**
	 * ����״̬������ID�趨
	 * @param roleidArray ����״̬������ID
	 */
	public void setRoleidArray(String[] roleidArray) {
		this.roleidArray = roleidArray;
	}

	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String[] getCondArray() {
		return condArray;
	}

	/**
	 * ����״̬ԾǨ�����趨
	 * @param condArray ����״̬ԾǨ����
	 */
	public void setCondArray(String[] condArray) {
		this.condArray = condArray;
	}

	public String[] getLogicSign() {
		return logicSign;
	}

	public void setLogicSign(String[] logicSign) {
		this.logicSign = logicSign;
	}

	public String[] getVariableID() {
		return variableID;
	}

	public void setVariableID(String[] variableID) {
		this.variableID = variableID;
	}

	public String[] getVvalue() {
		return vvalue;
	}

	public void setVvalue(String[] vvalue) {
		this.vvalue = vvalue;
	}

	/**
	 * �Ƿ�ȱʡ�������ʶȡ��
	 * @return �Ƿ�ȱʡ�������ʶ
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * �Ƿ�ȱʡ�������ʶ�趨
	 * @param flag�Ƿ�ȱʡ�������ʶ
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	/**
	 * ������״̬IDȡ��
	 * @return ������״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * ������״̬ID�趨
	 * @param ppsdid ������״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
