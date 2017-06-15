package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �豸������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGCIM1405Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** ��ԱID */
	protected Integer eiid;
	
	/** ��Ա���ð汾 */
	protected String civersion;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * ��ԱIDȡ��
	 * @return ��ԱID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * ��ԱID�趨
	 *
	 * @param eiid ��ԱID
	 */
	public void setEiid(Integer eiid) {
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


	public Integer getCid() {
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
}
