package com.deliverik.infogovernor.drm.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;

/**
 * 服务商配置信息详细画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0424Form extends BaseForm {

	/** 资产模型ID */
	protected String eid;

	/** 资产配置ID */
	protected String[] cid;

	/** 服务商配置值 */
	protected String[] cvalue;
	
	/** 服务商配置附件 */
	protected String[] ciattach;
	
	/** 资产模型属性配置值 */
	protected String[] entityItemCvalue;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 服务商配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 资产模型说明 */
	protected String edesc;
	
	/**
	 * 资产模型说明取得
	 *
	 * @return edesc 资产模型说明
	 */
	
	public String getEdesc() {
		return edesc;
	}


	/**
	 * 资产模型说明设定
	 *
	 * @param edesc 资产模型说明
	 */
	
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * 资产模型名称取得
	 *
	 * @return ename 资产模型名称
	 */
	
	public String getEname() {
		return ename;
	}


	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * 删除附件标识取得
	 *
	 * @return delfile 删除附件标识
	 */
	
	public String[] getDelfile() {
		return delfile;
	}


	/**
	 * 删除附件标识设定
	 *
	 * @param delfile 删除附件标识
	 */
	
	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}


	/**
	 * 服务商配置值取得
	 * @return 服务商配置值
	 */
	public String[] getCvalue() {
		return cvalue;
	}


	/**
	 * 服务商配置值设定
	 *
	 * @param cvalue 服务商配置值
	 */
	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * 服务商ID取得
	 * @return 服务商ID
	 */
	public String getEid() {
		return eid;
	}


	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}


	/**
	 * 资产配置ID取得
	 * @return 资产配置ID
	 */
	public String[] getCid() {
		return cid;
	}


	/**
	 * 资产配置ID设定
	 *
	 * @param cid 资产配置ID
	 */
	public void setCid(String[] cid) {
		this.cid = cid;
	}


	/**
	 * 服务商配置附件数据取得
	 * @return 服务商配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 服务商配置附件数据
	 *
	 * @param index 服务商配置附件数组索引
	 * @param file 服务商配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 服务商配置附件取得
	 * @return 服务商配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 服务商配置附件
	 *
	 * @param ciattach 服务商配置附件
	 */
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
	 * 资产模型属性配置值取得
	 * @return 资产模型属性配置值
	 */
	public String[] getEntityItemCvalue() {
		return entityItemCvalue;
	}

	/**
	 * 资产模型属性配置值设定
	 *
	 * @param entityItemCvalue 资产模型属性配置值
	 */
	public void setEntityItemCvalue(String[] entityItemCvalue) {
		this.entityItemCvalue = entityItemCvalue;
	}

	/**
	 * 模型层次码取得
	 * 
	 * @return 模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 模型层次码设定
	 * 
	 * @param esyscoding 模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}
