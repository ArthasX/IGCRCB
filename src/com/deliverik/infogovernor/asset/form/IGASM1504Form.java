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

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 人员配置信息详细画面FORM
 * 
 */
public class IGASM1504Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** 人员配置值最大字节数 */
	private static final int MAX_BYTE = 2000;

	/** 人员ID */
	protected String eiid;
	
	/** 资产模型ID */
	protected String[] eid;

	/** 人员说明 */
	protected String eidesc;
	
	/** 人员状态 */
	protected String eistatus;
	
	/** 人员配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 人员配置值 */
	protected String[] civalue;
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 人员配置附件 */
	protected String[] ciattach;
	
	/** 模型层次码 */
	protected String[] esyscoding;

	/** 人员版本 */
	protected int eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 人员配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 人员所属机构名称 */
	protected String eiorgname;
	
	/** 人员所属机构编码 */
	protected String eiorgsyscoding;
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	/** 资产模型属性配置值 */
	protected String[] entityItemCivalue;
	
	/** 更新属性标识 */
	protected String[] civalue_bak;

	/** 版本是否升级标识 */
	protected String ident;
	
	protected String[] isUpgrade;
	
	/** 子资产版本集合 */
	protected Map<Integer, String> cldVersionMap;
	
	public String[] getIsUpgrade() {
		return isUpgrade;
	}


	public void setIsUpgrade(String[] isUpgrade) {
		this.isUpgrade = isUpgrade;
	}
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	/**
	 * 人员ID取得
	 * @return 人员ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 人员ID设定
	 *
	 * @param eiid 人员ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * 人员说明取得
	 * @return 人员说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 人员说明设定
	 *
	 * @param eidesc 人员说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 人员状态取得
	 * @return 人员状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 人员状态设定
	 *
	 * @param eistatus 人员状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 人员配置ID取得
	 * @return 人员配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 人员配置ID设定
	 *
	 * @param ciid 人员配置ID
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
	 * 人员配置值取得
	 * @return 人员配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 人员配置值设定
	 *
	 * @param civalue 人员配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 人员版本取得
	 * @return 人员版本
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * 人员版本设定
	 *
	 * @param eiversion 人员版本
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * 人员ID取得
	 * @return 人员ID
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
	 * 人员配置附件数据取得
	 * @return 人员配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 人员配置附件数据
	 *
	 * @param index 人员配置附件数组索引
	 * @param file 人员配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 人员配置附件取得
	 * @return 人员配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 人员配置附件
	 *
	 * @param ciattach 人员配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 人员配置表单配置值检测
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
		request.getSession().setAttribute("IGASM1504Form", this);
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
		return null;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
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
	 *
	 * @param entityItemCivalue 资产模型属性配置值
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
	 *
	 * @param civalue_bak 更新属性标识
	 */
	public void setCivalue_bak(String[] civalue_bak) {
		this.civalue_bak = civalue_bak;
	}

	/**
	 * 版本升级标识取得
	 * @return 版本升级标识
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * 版本升级标识设定
	 * @param ident 版本升级标识
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	public String[] getDelfile() {
		return delfile;
	}

	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}
	
		public String getClabel_q() {
		return null;
	}

	public List<Integer> getEiid_list() {
		return null;
	}

	public String getSreilabel_q() {
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


	public Map<Integer, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<Integer, String> cldVersionMap2) {
		this.cldVersionMap = cldVersionMap2;
	}


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getEkey2()
	 */
	public String getEkey2() {
		return null;
	}

	protected int checkersion;

	/**
	 * checkersion取得
	 * @return checkersion  checkersion
	 */
	public int getCheckersion() {
		return checkersion;
	}


	/**
	 * checkersion设定
	 * @param checkersion  checkersion
	 */
	public void setCheckersion(int checkersion) {
		this.checkersion = checkersion;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
