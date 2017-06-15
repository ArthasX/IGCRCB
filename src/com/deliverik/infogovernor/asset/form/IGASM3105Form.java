package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �����������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGASM3105Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** �����ID */
	protected Integer eiid;
	
	/** ��������ð汾 */
	protected String civersion;
	
	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * �����ID�趨
	 *
	 * @param eiid �����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��������ð汾ȡ��
	 * @return ��������ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * ��������ð汾�趨
	 *
	 * @param civersion ��������ð汾
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
