package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 设备配置信息历史记录画面FORM
 * 
 */
public class IGASM0305Form extends BaseForm implements IG800SearchCond{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected Integer eiid;
	
	/** 设备配置版本 */
	protected String civersion;
	
	protected String filename;

	/** 资产属性小版本号*/
	protected String cismallversion;
	
	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 设备配置版本取得
	 * @return 设备配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 设备配置版本设定
	 *
	 * @param civersion 设备配置版本
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}


	public String getEid() {
		return null;
	}


	public Integer getCid() {
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
