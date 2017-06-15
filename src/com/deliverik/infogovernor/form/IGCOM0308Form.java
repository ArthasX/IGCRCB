package com.deliverik.infogovernor.form;

import java.util.Map;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ������Ϣ��ʷ��¼����FORM
 * 
 */
public class IGCOM0308Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** �ʲ�ID */
	protected Integer eiid;
	
	/** ���ô�汾 */
	protected  String civersion;
	
	/** ����С�汾 */
	protected String cismallversion;
	
	/** ���ʲ��汾���� */
	protected Map<String, String> cldVersionMap;

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
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


	public Integer getCid() {
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

}
