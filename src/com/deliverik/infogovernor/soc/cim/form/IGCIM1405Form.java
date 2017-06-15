package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 设备配置信息历史记录画面FORM
 * 
 */
public class IGCIM1405Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 人员ID */
	protected Integer eiid;
	
	/** 人员配置版本 */
	protected String civersion;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	/**
	 * 人员ID取得
	 * @return 人员ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 人员ID设定
	 *
	 * @param eiid 人员ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 人员配置版本取得
	 * @return 人员配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 人员配置版本设定
	 *
	 * @param civersion 人员配置版本
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
}
