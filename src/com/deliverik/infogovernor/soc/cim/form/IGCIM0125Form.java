package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * Ӧ��������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGCIM0125Form extends BaseForm implements SOC0107SearchCond{

	private static final long serialVersionUID = 1L;

	/** Ӧ��ID */
	protected String eiid;
	
	/** Ӧ�����ð汾 */
	protected String civersion;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * Ӧ�����ð汾ȡ��
	 * @return Ӧ�����ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * Ӧ�����ð汾�趨
	 *
	 * @param civersion Ӧ�����ð汾
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getCid() {
		// TODO Auto-generated method stub
		return null;
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
}
