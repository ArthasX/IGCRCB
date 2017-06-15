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
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 机房编辑画面FORM
 * 
 * @History 2010-5-07     0000428: 增加机房属性管理
 */
public class IGASM1102Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** 机房配置值最大字节数 @update 0000200*/
	private static final int MAX_BYTE = 2000;

	/** 机房ID */
	protected Integer eiid;
	
	/** 机房ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 机房名称 */
	protected String einame;
	
	/** 机房编码 */
	protected String eilabel;

	/** 机房说明 */
	protected String eidesc;

	/** 机房版本号 */
	protected Integer eiversion;

	/** 机房变更时间 */
	protected String eiupdtime;
	
	/** 机房登记日 */
	protected String eiinsdate;
	
	/** 横向位置坐标长 */
	protected String x_total;
	
	/** 纵向位置坐标长 */
	protected String y_total;
	
	/** 负责人 */
	protected String manager;
	
	/** 联系电话 */
	protected String tel;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 文档状态 */
	protected String eistatus;
	
	/** 文档配置ID */
	protected String[] ciid;
	
	/** 资产配置ID */
	protected String[] cid;

	/** 资产配置编号 */
	protected String[] clabel;

	/** 文档配置值 */
	protected String[] civalue;
	
	/** 删除附件标识 */
	protected String[] delfile;
	
	/** 机房配置附件 */
	protected String[] ciattach;
	
	protected String[] esyscoding_str;
	
	protected String esyscoding;
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 机房配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	/** 类型层次码 */
	protected String esyscoding_q;
	
	protected String[] entityItemCivalue;
	
	/** 资产小版本*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid() {
		return this.eiid;
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
	 * 机房ID（文字）取得
	 * @return 机房ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 机房ID（文字）设定
	 *
	 * @param eiidStr 机房ID（文字）
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		if( (this.eidStr == null) || (this.eidStr.equals(""))){
			return null;
		} else {
			return this.eidStr;
		}
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
	 * 资产模型ID（文字）取得
	 * @return 资产模型ID（文字）
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * 资产模型ID（文字）设定
	 *
	 * @param eidStr 资产模型ID（文字）
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * 机房名称取得
	 * @return 机房名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机房名称设定
	 *
	 * @param einame 机房名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 机房编码取得
	 * @return 机房编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机房编码设定
	 *
	 * @param eilabel 机房编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * 机房版本号取得
	 * @return 机房版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 机房版本号设定
	 *
	 * @param eiversion 机房版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 机房更新时间取得
	 * @return 机房更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 机房更新时间设定
	 *
	 * @param eiupdtime 机房更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 机房登记日取得
	 * @return 机房登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 机房登记日设定
	 *
	 * @param eiinsdate 机房登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 横向位置坐标轴长取得
	 * @return 横向位置坐标轴长
	 */
	public String getX_total() {
		return x_total;
	}

	/**
	 * 横向位置坐标轴长设定
	 *
	 * @param x_total 横向位置坐标轴长
	 */
	public void setX_total(String x_total) {
		this.x_total = x_total;
	}

	/**
	 * 纵向位置坐标轴长取得
	 * @return 纵向位置坐标轴长
	 */
	public String getY_total() {
		return y_total;
	}

	/**
	 * 纵向位置坐标轴长设定
	 *
	 * @param y_total 纵向位置坐标轴长
	 */
	public void setY_total(String y_total) {
		this.y_total = y_total;
	}

	/**
	 * 负责人取得
	 * @return 负责人
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * 负责人设定
	 *
	 * @param manager 负责人
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * 联系电话取得
	 * @return 联系电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 联系电话设定
	 *
	 * @param tel 联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 编辑模式取得
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * 编辑模式设定
	 *
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
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
		request.getSession().setAttribute("IGASM1102Form", this);
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

	public String[] getEntityItemCivalue() {
		return entityItemCivalue;
	}

	public void setEntityItemCivalue(String[] entityItemCivalue) {
		this.entityItemCivalue = entityItemCivalue;
	}
	
	/**
	 * 文档配置附件数据取得
	 * @return 文档配置附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}


	/**
	 * 文档配置附件数据
	 *
	 * @param index 文档配置附件数组索引
	 * @param file 文档配置附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}

	public String getEiorgsyscoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getDelfile() {
		return delfile;
	}

	public void setDelfile(String[] delfile) {
		this.delfile = delfile;
	}

	public String[] getEsyscoding_str() {
		return esyscoding_str;
	}

	public void setEsyscoding_str(String[] esyscoding_str) {
		this.esyscoding_str = esyscoding_str;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
		public Integer getEirootmark() {
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

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}


}
