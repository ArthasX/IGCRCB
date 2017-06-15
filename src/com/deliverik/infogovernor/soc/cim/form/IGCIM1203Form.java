package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * ������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGCIM1203Form extends BaseForm implements SOC0107SearchCond,SOC0129SearchCond {

	private static final long serialVersionUID = 1L;

	/** �ʲ�ID */
	protected String eiid;
	
	/** ���ô�汾 */
	protected  String civersion;
	
	/** ����С�汾 */
	protected String cismallversion;
	
	/** ���ʲ��汾���� */
	protected Map<String, String> cldVersionMap;

	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ���ð汾ȡ��
	 * @return ���ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * ���ð汾�趨
	 *
	 * @param civersion ���ð汾
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getEid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * �ʲ�����С�汾���趨
	 *
	 * @param cismallversion �ʲ�����С�汾��
	 */
	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}


	public Map<String, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<String, String> cldVersionMap) {
		this.cldVersionMap = cldVersionMap;
	}


	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEkey2() {
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


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
