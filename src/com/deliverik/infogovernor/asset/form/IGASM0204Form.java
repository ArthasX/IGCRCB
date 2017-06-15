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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 资产项配置信息详细画面FORM
 * 
 */
public class IGASM0204Form extends BaseForm implements IG002SearchCond{

	private static final long serialVersionUID = 1L;

	/** 资产项配置值最大字节数 */
	private static final int MAX_BYTE = 2000;

	/** 资产项ID */
	protected Integer eiid;
	
	/** 资产模型ID */
	protected String[] eid;

	/** 资产项说明 */
	protected String eidesc;
	
	/** 资产项状态 */
	protected String eistatus;
	
	/** 资产项配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 资产项配置值 */
	protected String[] civalue;
	
	/** 资产项配置附件 */
	protected String[] ciattach;

	/** 资产项版本 */
	protected int eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 模型层次码 */
	protected String[] esyscoding;
	
	/** 资产项配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}


	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}


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
	 * 资产项说明取得
	 * @return 资产项说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 资产项说明设定
	 *
	 * @param eidesc 资产项说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 资产项状态取得
	 * @return 资产项状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 资产项状态设定
	 *
	 * @param eistatus 资产项状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 资产项配置ID取得
	 * @return 资产项配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 资产项配置ID设定
	 *
	 * @param ciid 资产项配置ID
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
	 * 资产项配置值取得
	 * @return 资产项配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 资产项配置值设定
	 *
	 * @param civalue 资产项配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 资产项版本取得
	 * @return 资产项版本
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * 资产项版本设定
	 *
	 * @param eiversion 资产项版本
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public String[] getEid() {
		return eid;
	}


	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String[] eid) {
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
	 * 资产配置附件取得
	 * @return 资产配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 资产配置附件
	 *
	 * @param ciattach 资产配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
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
	 * 资产项配置附件数据取得
	 * @return 资产项配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 资产项配置附件数据
	 *
	 * @param index 资产项配置附件数组索引
	 * @param file 资产项配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 资产项配置表单配置值检测
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
		
		request.getSession().setAttribute("IGASM0204Form", this);
		return errors;
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
	 * 模型层次码取得
	 * @return 模型层次码
	 */
	public String[] getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 模型层次码设定
	 *
	 * @param esyscoding 模型层次码
	 */
	public void setEsyscoding(String[] esyscoding) {
		this.esyscoding = esyscoding;
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
		return null;
	}


	public String getCiversion() {
		return null;
	}


	public String getEid_q() {
		return null;
	}
}
