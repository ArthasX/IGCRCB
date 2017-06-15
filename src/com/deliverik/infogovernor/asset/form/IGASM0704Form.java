package com.deliverik.infogovernor.asset.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 机房配置信息详细画面FORM
 * 
 */
public class IGASM0704Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** 机房配置值最大字节数 */
	private static final int MAX_BYTE = 2000;

	/** 机房ID */
	protected Integer eiid;
	
	/** 资产模型ID */
	protected String eid;

	/** 机房说明 */
	protected String eidesc;
	
	/** 机房状态 */
	protected String eistatus;
	
	/** 机房配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 机房配置值 */
	protected String[] civalue;
	
	/** 机房配置附件 */
	protected String[] ciattach;

	/** 机房版本 */
	protected int eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 机房配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return eiid;
	}


	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 机房说明取得
	 * @return 机房说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 机房说明设定
	 *
	 * @param eidesc 机房说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 机房状态取得
	 * @return 机房状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 机房状态设定
	 *
	 * @param eistatus 机房状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 机房配置ID取得
	 * @return 机房配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 机房配置ID设定
	 *
	 * @param ciid 机房配置ID
	 */
	public void setCiid(String[] ciid) {
		this.ciid = ciid;
	}


	/**
	 * 资产配置编号取得
	 * @return 资产配置编号
	 */
	public String[] getClabel() {
		return clabel;
	}


	/**
	 * 资产配置编号设定
	 *
	 * @param clabel 资产配置编号
	 */
	public void setClabel(String[] clabel) {
		this.clabel = clabel;
	}


	/**
	 * 机房配置值取得
	 * @return 机房配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 机房配置值设定
	 *
	 * @param civalue 机房配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 机房版本取得
	 * @return 机房版本
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * 机房版本设定
	 *
	 * @param eiversion 机房版本
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * 机房ID取得
	 * @return 机房ID
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
	 * 画面迁移标识取得
	 * @return 画面迁移标识
	 */
	public String getRoute() {
		return route;
	}


	/**
	 * 画面迁移标识设定
	 *
	 * @param route 画面迁移标识
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	
	/**
	 * 机房配置附件数据取得
	 * @return 机房配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 机房配置附件数据
	 *
	 * @param index 机房配置附件数组索引
	 * @param file 机房配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 机房配置附件取得
	 * @return 机房配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 机房配置附件
	 *
	 * @param ciattach 机房配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 机房配置表单配置值检测
	 *
	 * @param mapping
	 * @param request
	 * @return 检测错误信息
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		errors = super.validate(mapping, request);
		if ( civalue != null ) {
			for ( int i=0;i<civalue.length;i++ ) {
				if (!IGStringUtils.isValidBytes(civalue[i],MAX_BYTE)) {
					errors.add(Globals.ERROR_KEY, new ActionMessage("errors.maxbytes","(编号：" +clabel[i]+")的配置内容", 
    					String.valueOf(MAX_BYTE / 3), String.valueOf(MAX_BYTE)));
				}
			}
		}
		request.getSession().setAttribute("IGASM0704Form", this);
		return errors;
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
