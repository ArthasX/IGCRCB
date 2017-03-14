package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * �ĵ�������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGASM0505Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ĵ�ID */
	protected Integer eiid;
	
	/** �ĵ����ð汾 */
	protected String civersion;
	
	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/**
	 * �ĵ�IDȡ��
	 * @return �ĵ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * �ĵ�ID�趨
	 *
	 * @param eiid �ĵ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ĵ����ð汾ȡ��
	 * @return �ĵ����ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * �ĵ����ð汾�趨
	 *
	 * @param civersion �ĵ����ð汾
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
