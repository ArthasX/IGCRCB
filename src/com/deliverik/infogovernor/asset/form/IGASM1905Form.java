package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * �豸������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGASM1905Form extends BaseForm implements SOC0107SearchCond{

	private static final long serialVersionUID = 1L;

	/** ��ԱID */
	protected String eiid;
	
	/** ��Ա���ð汾 */
	protected String civersion;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * ��ԱIDȡ��
	 * @return ��ԱID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * ��ԱID�趨
	 *
	 * @param eiid ��ԱID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��Ա���ð汾ȡ��
	 * @return ��Ա���ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * ��Ա���ð汾�趨
	 *
	 * @param civersion ��Ա���ð汾
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}




	public String getEid() {
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


	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}
}
