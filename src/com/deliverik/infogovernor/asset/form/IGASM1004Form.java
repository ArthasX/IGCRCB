package com.deliverik.infogovernor.asset.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 资产项配置信息详细画面FORM
 * 
 */
public class IGASM1004Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** 资产项ID */
	protected Integer eiid;
	
	/** 资产项配置附件 */
	protected String[] ciattach;
	
	/** 模型层次码 */
	protected String esyscoding_q;

	/**
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 资产项ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产项配置附件取得
	 * @return 资产项配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 资产项配置附件
	 *
	 * @param ciattach 资产项配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Integer> getEiid_list() {
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


	public String getCiversion() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}
}
