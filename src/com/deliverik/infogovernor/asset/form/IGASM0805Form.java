package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * Ӧ��������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGASM0805Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** Ӧ��ID */
	protected Integer eiid;
	
	/** Ӧ�����ð汾 */
	protected String civersion;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(Integer eiid) {
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
