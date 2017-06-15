package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * 配置信息历史记录画面FORM
 * 
 */
public class IGCIM1203Form extends BaseForm implements SOC0107SearchCond,SOC0129SearchCond {

	private static final long serialVersionUID = 1L;

	/** 资产ID */
	protected String eiid;
	
	/** 配置大版本 */
	protected  String civersion;
	
	/** 配置小版本 */
	protected String cismallversion;
	
	/** 子资产版本集合 */
	protected Map<String, String> cldVersionMap;

	/** 模型层次码 */
	protected String esyscoding_q;
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 配置版本取得
	 * @return 配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 配置版本设定
	 *
	 * @param civersion 配置版本
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
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * 资产属性小版本号设定
	 *
	 * @param cismallversion 资产属性小版本号
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


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
