package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ϵͳ������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGASM1805Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** ϵͳID */
	protected Integer eiid;
	
	/** ϵͳ���ð汾 */
	protected String civersion;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	
	/**
	 * ϵͳIDȡ��
	 * @return ϵͳID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * ϵͳID�趨
	 *
	 * @param eiid ϵͳID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ϵͳ���ð汾ȡ��
	 * @return ϵͳ���ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * ϵͳ���ð汾�趨
	 *
	 * @param civersion ϵͳ���ð汾
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
