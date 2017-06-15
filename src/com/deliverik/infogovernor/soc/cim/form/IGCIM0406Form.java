/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;

/**
 * @Description: 资产详细信息画面FORM
 * @Author  
 * @History 2009-8-17     新建
 * @Version V2.0
 */
public class IGCIM0406Form extends BaseForm implements SOC0109SearchCond{

	private static final long serialVersionUID = 1L;
	
	/** 资产类型ID */
	protected String eid;

	/** 删除对象资产配置ID */
	protected String[] deleteCid;
	

	/**
	 * 资产类型ID取得
	 * @return 资产类型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产类型ID设定
	 *
	 * @param eid 资产类型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 删除对象资产配置ID取得
	 * @return 删除对象资产配置ID
	 */
	public String[] getDeleteCid() {
		return deleteCid;
	}

	/**
	 * 删除对象资产配置ID设定
	 *
	 * @param deleteCid 删除对象资产配置ID
	 */
	public void setDeleteCid(String[] deleteCid) {
		this.deleteCid = deleteCid;
	}

	public String getCcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}



	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCseq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.asset.model.condition.ConfigurationSearchCond#getCattachList()
	 */
	public List<String> getCattachList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getFilterlabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscoding_like() {
		// TODO Auto-generated method stub
		return null;
	}

}
