/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_�¼��鿴��ʷ��¼FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01011Form extends BaseForm implements IG036SearchCond {

	/**���̱��*/
	protected Integer prid;

	/**�����û�ID*/
	protected String rluserid;

	/**�����û�����*/
	protected String rlusername;

	/**
	 * ��ȡ���̱��
	 * @return ���̱��
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �������̱��
	 * @param prid ���̱��
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ�����û�ID
	 * @return �����û�ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * ���ò����û�ID
	 * @param rluserid �����û�ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}

	/**
	 * ��ȡ�����û�����
	 * @return �����û�����
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * ���ò����û�����
	 * @param rlusername �����û�����
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	public String getNotEqualrlType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPsdcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRlType() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRolemanger() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoleorder_type() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRoleorder() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPsdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPsdnum() {
		// TODO Auto-generated method stub
		return null;
	}

}
