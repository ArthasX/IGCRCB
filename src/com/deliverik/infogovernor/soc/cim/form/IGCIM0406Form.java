/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;

/**
 * @Description: �ʲ���ϸ��Ϣ����FORM
 * @Author  
 * @History 2009-8-17     �½�
 * @Version V2.0
 */
public class IGCIM0406Form extends BaseForm implements SOC0109SearchCond{

	private static final long serialVersionUID = 1L;
	
	/** �ʲ�����ID */
	protected String eid;

	/** ɾ�������ʲ�����ID */
	protected String[] deleteCid;
	

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�����ID�趨
	 *
	 * @param eid �ʲ�����ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * ɾ�������ʲ�����IDȡ��
	 * @return ɾ�������ʲ�����ID
	 */
	public String[] getDeleteCid() {
		return deleteCid;
	}

	/**
	 * ɾ�������ʲ�����ID�趨
	 *
	 * @param deleteCid ɾ�������ʲ�����ID
	 */
	public void setDeleteCid(String[] deleteCid) {
		this.deleteCid = deleteCid;
	}

	public String getCcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCseq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.ConfigurationSearchCond#getCattachList()
	 */
	public List<String> getCattachList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getFilterlabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscoding_like() {
		// TODO Auto-generated method stub
		return null;
	}

}
