package com.deliverik.infogovernor.asset.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;

/**
 * 设备配置详细画面FORM
 * 
 */
public class IGASM1116Form extends BaseForm implements SOC0606SearchCond{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected String eiid;
	
	/** 设备配置版本 */
	protected String civersion;
	
	/** 系统配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 系统配置值 */
	protected String[] civalue;
	
	/** 系统配置附件 */
	protected String[] ciattach;
	
	/** 系统配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	public String[] getCiid() {
		return ciid;
	}


	public void setCiid(String[] ciid) {
		this.ciid = ciid;
	}


	public String[] getCid() {
		return cid;
	}


	public void setCid(String[] cid) {
		this.cid = cid;
	}


	public String[] getClabel() {
		return clabel;
	}


	public void setClabel(String[] clabel) {
		this.clabel = clabel;
	}


	public String[] getCivalue() {
		return civalue;
	}


	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	public String[] getCiattach() {
		return ciattach;
	}


	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * 取值范围下拉数据设定
	 *
	 * @param selectedList 取值范围下拉数据
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}

	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}


	/**
	 * 设备ID取得
	 * @return 资产项ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(String eiid) {
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


	public String getEid_q() {
		// TODO Auto-generated method stub
		return null;
	}
}
