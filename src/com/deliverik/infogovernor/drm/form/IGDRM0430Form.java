package com.deliverik.infogovernor.drm.form;

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
 * 应急资源配置信息详细画面FORM
 * 
 */
public class IGDRM0430Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** 应急资源配置值最大字节数 */
	private static final int MAX_BYTE = 2000;

	/** 应急资源ID */
	protected String id;
	
	/** 应急资源eiID */
	protected String eiid;
	
	/** 资产模型ID */
	protected Integer[] eid;

	/** 应急资源说明 */
	protected String eidesc;
	
	/** 应急资源状态 */
	protected String eistatus;
	
	/** 应急资源配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 应急资源配置值 */
	protected String[] civalue;
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 版本是否升级标识 */
	protected String ident;
	
	/** 资产模型属性配置值 */
	protected String[] entityItemCivalue;
	
	/** 应急资源配置附件 */
	protected String[] ciattach;
	
	/** 模型层次码 */
	protected String[] esyscoding;

	/** 应急资源版本 */
	protected Integer eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 应急资源配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	/** 应急资源配置附件数据 */
	protected Map<Integer, FormFile> fileMapXML = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 应急资源所属机构编码 */
	protected String eiorgsyscoding;
	
	/** 应急资源所属机构名称 */
	protected String eiorgname;
	
	/** 模型层次码 */
	protected String esyscoding_q;
	
	/** 更新属性标识 */
	protected String[] civalue_bak;
	
	protected String filename;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 资产模型类别（0：一般资产模型 1：配置资产模型） */
	protected String emodeltype;
	
	/** 子资产版本集合 */
	protected Map<String, String> cldVersionMap;
	
	protected String[] isUpgrade;
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	public String[] getIsUpgrade() {
		return isUpgrade;
	}


	public void setIsUpgrade(String[] isUpgrade) {
		this.isUpgrade = isUpgrade;
	}

	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
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
	 * 应急资源ID取得
	 * @return 应急资源ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 应急资源ID设定
	 *
	 * @param eiid 应急资源ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * 应急资源说明取得
	 * @return 应急资源说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 应急资源说明设定
	 *
	 * @param eidesc 应急资源说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 应急资源状态取得
	 * @return 应急资源状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 应急资源状态设定
	 *
	 * @param eistatus 应急资源状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 应急资源配置ID取得
	 * @return 应急资源配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 应急资源配置ID设定
	 *
	 * @param ciid 应急资源配置ID
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
	 * 应急资源配置值取得
	 * @return 应急资源配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 应急资源配置值设定
	 *
	 * @param civalue 应急资源配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 应急资源版本取得
	 * @return 应急资源版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}


	/**
	 * 应急资源版本设定
	 *
	 * @param eiversion 应急资源版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}


	/**
	 * 应急资源ID取得
	 * @return 应急资源ID
	 */
	public Integer[] getEid() {
		return eid;
	}


	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(Integer[] eid) {
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
	 * 应急资源配置附件数据取得
	 * @return 应急资源配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 应急资源配置附件数据
	 *
	 * @param index 应急资源配置附件数组索引
	 * @param file 应急资源配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	
	/**
	 * 应急资源配置附件数据取得
	 * @return 应急资源配置附件数据
	 */
	public FormFile getAttachFileXML(int index) {
		return (FormFile) fileMapXML.get( new Integer( index ) );
	}


	/**
	 * 应急资源配置附件数据
	 *
	 * @param index 应急资源配置附件数组索引
	 * @param file 应急资源配置附件数据
	 */
	public void setAttachFileXML(int index, FormFile file) {
		fileMapXML.put( new Integer( index ), file );
	}


	/**
	 * 应急资源配置附件取得
	 * @return 应急资源配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 应急资源配置附件
	 *
	 * @param ciattach 应急资源配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 应急资源配置表单配置值检测
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
		request.getSession().setAttribute("IGASM0304Form", this);
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

	public String getEsyscoding_q() {
		return esyscoding_q;
	}


	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}


	public String getCname() {
		// TODO Auto-generated method stub
		return null;
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
	
	public String[] getDelfile() {
		return delfile;
	}


	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}


	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<Integer, FormFile> getFileMapXML() {
		return fileMapXML;
	}


	public void setFileMapXML(Map<Integer, FormFile> fileMapXML) {
		this.fileMapXML = fileMapXML;
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
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	/**
	 * 资产模型类别设定
	 *
	 * @param eparcoding 资产模型类别
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
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
		return id;
	}
	
}
