package com.deliverik.infogovernor.asset.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���������Ϣ��ϸ����FORM
 * 
 */
public class IGASM1004Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ���ID */
	protected Integer eiid;
	
	/** �ʲ������ø��� */
	protected String[] ciattach;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;

	/**
	 * �ʲ���IDȡ��
	 * @return �ʲ���ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ������ø���ȡ��
	 * @return �ʲ������ø���
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * �ʲ������ø���
	 *
	 * @param ciattach �ʲ������ø���
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCiversion() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}
}
