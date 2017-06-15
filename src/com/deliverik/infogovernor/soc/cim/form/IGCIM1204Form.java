package com.deliverik.infogovernor.soc.cim.form;

import java.util.Map;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGCIM1204Form extends BaseForm implements SOC0107SearchCond{


	/** �豸ID */
	protected String eiid;
	
	/** �豸���ð汾 */
	protected String civersion;
	
	/** �ֱ��� */
	protected Integer screenWidth;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/** ���ʲ��汾����*/
	protected Map<String, String> cldVersionMap;
	
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


	public Integer getScreenWidth() {
		return screenWidth;
	}


	public void setScreenWidth(Integer screenWidth) {
		this.screenWidth = screenWidth;
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
}
