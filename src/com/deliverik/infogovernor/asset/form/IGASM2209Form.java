/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 设备详细信息Form
 * 功能描述: 设备详细信息Form
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2209Form extends BaseForm implements IG002SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 设备ID */
	protected Integer eiid;
	
	/** 设备说明 */
	protected String eidesc;
	
	/** 设备状态 */
	protected String eistatus;
	
	/** 设备所属机构编码 */
	protected String eiorgsyscoding;
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 设备配置值 */
	protected String[] civalue;
	
	/** 资产模型属性配置值 */
	protected String[] entityItemCivalue;
	
	/** 更新属性标识 */
	protected String[] civalue_bak;
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();

	
	
	
	
	/**
	 * 设备配置值取得
	 * @return 设备配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 设备配置值设定
	 * @param civalue设备配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 资产模型属性配置值取得
	 * @return 资产模型属性配置值
	 */
	public String[] getEntityItemCivalue() {
		return entityItemCivalue;
	}

	/**
	 * 资产模型属性配置值设定
	 * @param entityItemCivalue资产模型属性配置值
	 */
	public void setEntityItemCivalue(String[] entityItemCivalue) {
		this.entityItemCivalue = entityItemCivalue;
	}

	/**
	 * 更新属性标识取得
	 * @return 更新属性标识 
	 */
	public String[] getCivalue_bak() {
		return civalue_bak;
	}

	/**
	 * 更新属性标识设定
	 * @param civalue_bak更新属性标识 
	 */
	public void setCivalue_bak(String[] civalue_bak) {
		this.civalue_bak = civalue_bak;
	}

	/**
	 * 设备ID取得
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 * @param eiid设备ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}

	/**
	 * 取值范围下拉数据设定
	 * @param selectedListMap取值范围下拉数据
	 */
	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}

	/**
	 * 设备说明取得
	 * @return 设备说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 设备说明设定
	 * @param eidesc设备说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 设备状态取得
	 * @return 设备状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 设备状态设定
	 * @param eistatus设备状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 设备所属机构编码取得
	 * @return 设备所属机构编码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 设备所属机构编码设定
	 * @param eiorgsyscoding设备所属机构编码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 模型层次码取得
	 * @return 模型层次码
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 模型层次码设定
	 * @param eiorgname模型层次码
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 设备所属机构名称取得
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}
	
	/**
	 * 设备所属机构名称设定
	 * @param esyscoding_q设备所属机构名称
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
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
