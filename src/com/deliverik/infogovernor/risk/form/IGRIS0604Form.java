package com.deliverik.infogovernor.risk.form;

import java.util.ArrayList;
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
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * 检查项配置信息详细画面FORM
 * 
 */
public class IGRIS0604Form extends BaseForm implements SOC0129SearchCond{

	private static final long serialVersionUID = 1L;

	/** 检查项配置值最大字节数 */
	private static final int MAX_BYTE = 2000;
	
	

	public IGRIS0604Form() {
		fileList = new ArrayList<FormFileInfo>();
		fileList.add(new FormFileInfo());
	}


	/** 检查项ID */
	protected String eiid;
	
	/** 检查项说明 */
	protected String eidesc;
	
	/** 检查项状态 */
	protected String eistatus;
	
	/** 检查项配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 检查项配置值 */
	protected String[] civalue;
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 检查项配置附件 */
	protected String[] ciattach;
	
	/** 资产模型ID */
	protected String[] eid;
	
	/** 模型层次码 */
	protected String[] esyscoding;

	/** 检查项版本 */
	protected int eiversion;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 检查项配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	/** 检查项所属机构编码 */
	protected String eiorgsyscoding;
	
	/** 检查项所属机构名称 */
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
	
	
	/**版本集合map*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**选择版本*/
	protected String selecteiversion;
	
	/**查看人是否有权限修改*/
	protected String identyFlag; 
	
	protected String hiddenmguserid;
	

	protected int checkersion;
	
	/**查询标识*/
	protected String looksign;

	/** 文件列表  */	
	protected List<FormFileInfo> fileList;
	protected FormFile file;
	public String nattkey;
	protected String attacthname;
	public List<Attachment> attachmentList;
	//是否删除附件
	public String deletekeys;
	
	protected String eiids;
	
	
	/**
	 * 查询标识取得
	 * @return looksign 查询标识
	 */
	public String getLooksign() {
		return looksign;
	}


	/**
	 * 查询标识设定
	 * @param looksign 查询标识
	 */
	public void setLooksign(String looksign) {
		this.looksign = looksign;
	}


	/**
	 * checkersion取得
	 * @return checkersion checkersion
	 */
	public int getCheckersion() {
		return checkersion;
	}


	/**
	 * checkersion设定
	 * @param checkersion checkersion
	 */
	public void setCheckersion(int checkersion) {
		this.checkersion = checkersion;
	}


	/**
	 * hiddenmguserid取得
	 * @return hiddenmguserid hiddenmguserid
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}


	/**
	 * hiddenmguserid设定
	 * @param hiddenmguserid hiddenmguserid
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}


	/**
	 * 查看人是否有权限修改取得
	 * @return identyFlag 查看人是否有权限修改
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}


	/**
	 * 查看人是否有权限修改设定
	 * @param identyFlag 查看人是否有权限修改
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}


	/**
	 * 选择版本取得
	 * @return selecteiversion 选择版本
	 */
	public String getSelecteiversion() {
		return selecteiversion;
	}


	/**
	 * 选择版本设定
	 * @param selecteiversion 选择版本
	 */
	public void setSelecteiversion(String selecteiversion) {
		this.selecteiversion = selecteiversion;
	}


	/**
	 * 版本集合map取得
	 * @return checkVersionMap 版本集合map
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}


	/**
	 * 版本集合map设定
	 * @param checkVersionMap 版本集合map
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}


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
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 检查项ID设定
	 *
	 * @param eiid 检查项ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}


	/**
	 * 检查项说明取得
	 * @return 检查项说明
	 */
	public String getEidesc() {
		return eidesc;
	}


	/**
	 * 检查项说明设定
	 *
	 * @param eidesc 检查项说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}


	/**
	 * 检查项状态取得
	 * @return 检查项状态
	 */
	public String getEistatus() {
		return eistatus;
	}


	/**
	 * 检查项状态设定
	 *
	 * @param eistatus 检查项状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}


	/**
	 * 检查项配置ID取得
	 * @return 检查项配置ID
	 */
	public String[] getCiid() {
		return ciid;
	}


	/**
	 * 检查项配置ID设定
	 *
	 * @param ciid 检查项配置ID
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
	 * 检查项配置值取得
	 * @return 检查项配置值
	 */
	public String[] getCivalue() {
		return civalue;
	}


	/**
	 * 检查项配置值设定
	 *
	 * @param civalue 检查项配置值
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}


	/**
	 * 检查项版本取得
	 * @return 检查项版本
	 */
	public int getEiversion() {
		return eiversion;
	}


	/**
	 * 检查项版本设定
	 *
	 * @param eiversion 检查项版本
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
	 * 检查项配置附件数据取得
	 * @return 检查项配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 检查项配置附件数据
	 *
	 * @param index 检查项配置附件数组索引
	 * @param file 检查项配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}


	/**
	 * 检查项配置附件取得
	 * @return 检查项配置附件
	 */
	public String[] getCiattach() {
		return ciattach;
	}


	/**
	 * 检查项配置附件
	 *
	 * @param ciattach 检查项配置附件
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}


	/**
	 * 检查项配置表单配置值检测
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
		request.getSession().setAttribute("IGRIS0604Form", this);
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
	/**
	 * attacthname取得
	 * @return attacthname  attacthname
	 */
	public String getAttacthname() {
		return attacthname;
	}

	/**
	 * attacthname设定
	 * @param attacthname  attacthname
	 */
	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}
	/**
	 * nattkey取得
	 * @return nattkey  nattkey
	 */
	public String getNattkey() {
		return nattkey;
	}

	/**
	 * nattkey设定
	 * @param nattkey  nattkey
	 */
	public void setNattkey(String nattkey) {
		this.nattkey = nattkey;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}
	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}

	public FormFileInfo getFileList(int index) {
		int size = fileList.size();
		if (index>size-1) {
			for (int i = 0; i < index-size+1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}

	/**
	 * 文件列表设定
	 * @param fileList  文件列表
	 */
	public void setFileList(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}
	
	public FormFile getAttachFile() {
		return this.file;
	}

	public void setAttachFile( FormFile file) {
		this.file=file;
	}


	/**
	 * deletekeys取得
	 * @return deletekeys  deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}


	/**
	 * deletekeys设定
	 * @param deletekeys  deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}


	/**
	 * @return the eiids
	 */
	public String getEiids() {
		return eiids;
	}


	/**
	 * @param eiids the eiids to set
	 */
	public void setEiids(String eiids) {
		this.eiids = eiids;
	}


	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
