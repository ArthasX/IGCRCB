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
 * 系统配置信息详细画面FORM
 * 
 */
public class IGASM1804Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** 系统配置值最大字节数 */
	private static final int MAX_BYTE = 2000;

	/** 系统ID */
	protected String eiid;
	
	/** 系统说明 */
	protected String eidesc;
	
	/** 系统状态 */
	protected String eistatus;
	
	/** 系统配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 系统配置值 */
	protected String[] civalue;
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 系统配置附件 */
	protected String[] ciattach;
	
	/** 资产模型ID */
	protected String[] eid;
	
	/** 模型层次码 */
	protected String[] esyscoding;

	/** 系统版本 */
	protected int eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 系统配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** 系统所属机构编码 */
	protected String eiorgsyscoding;
	
	/** 系统所属机构名称 */
	protected String eiorgname;
	
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
	protected Map<String, String> cldVersionMap;
	
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
	 * 系统ID取得
	 * @return 系统ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 系统ID设定
	 *
	 * @param eiid 系统ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * 系统说明取得
	 * @return 系统说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 系统说明设定
	 *
	 * @param eidesc 系统说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 系统状态取得
	 * @return 系统状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 系统状态设定
	 *
	 * @param eistatus 系统状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 系统配置ID取得
	 * @return 系统配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 系统配置ID设定
	 *
	 * @param ciid 系统配置ID
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
	 * 系统配置值取得
	 * @return 系统配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 系统配置值设定
	 *
	 * @param civalue 系统配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 系统版本取得
	 * @return 系统版本
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * 系统版本设定
	 *
	 * @param eiversion 系统版本
	 */
	public void setEiversion(int eiversion) {
		this.eiversion = eiversion;
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
	 * 系统配置附件数据取得
	 * @return 系统配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 系统配置附件数据
	 *
	 * @param index 系统配置附件数组索引
	 * @param file 系统配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 系统配置附件取得
	 * @return 系统配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 系统配置附件
	 *
	 * @param ciattach 系统配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 系统配置表单配置值检测
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
		request.getSession().setAttribute("IGASM1804Form", this);
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
	 * 设备ID取得
	 * @return 设备ID
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


	public String[] getDelfile() {
		return delfile;
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

	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
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


	public Map<String, String> getCldVersionMap() {
		return cldVersionMap;
	}


	public void setCldVersionMap(Map<String, String> cldVersionMap) {
		this.cldVersionMap = cldVersionMap;
	}


	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
