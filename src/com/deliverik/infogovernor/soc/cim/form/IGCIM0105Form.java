package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * �豸������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGCIM0105Form extends BaseForm implements SOC0107SearchCond{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected String eiid;
	
	/** �豸���ð汾 */
	protected String civersion;
	
	protected String filename;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �豸���ð汾ȡ��
	 * @return �豸���ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * �豸���ð汾�趨
	 *
	 * @param civersion �豸���ð汾
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


	public String[] getCids() {
		return null;
	}

}
