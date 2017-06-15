package com.deliverik.infogovernor.drm.form;

import java.util.Map;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM05031Form extends BaseForm implements SOC0107SearchCond{


	/** ��ʶ�����ʲ���Ϣ���ڱ�������ʾ */
	protected String  assetsName;
	
	/** �ʲ�ID */
	protected String eiid;
	
	/** �ʲ����ð汾 */
	protected String civersion;
	
	/** �ֱ��� */
	protected Integer screenWidth;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/** ���ʲ��汾����*/
	protected Map<String, String> cldVersionMap;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ����ð汾ȡ��
	 * @return �ʲ����ð汾
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * �ʲ����ð汾�趨
	 *
	 * @param civersion �ʲ����ð汾
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


	public String getAssetsName() {
		return assetsName;
	}


	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}


}
