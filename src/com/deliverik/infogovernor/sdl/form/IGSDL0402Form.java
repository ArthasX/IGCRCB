/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.SdlInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息新增Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0402Form extends BaseForm implements SdlInfo{
	
	/**主键*/
	protected Integer siid;
	/**类别*/
	protected String sitype;
	/**说明*/
	protected String sidesc;
	/**开始时间*/
	protected String sibegin;
	/**结束时间*/
	protected String siend;
	/**评分*/
	protected Integer simark;
	/**相关资产ID*/
	protected Integer sieiid;
	/**相关资产名称*/
	protected String sieiname;
	/**相关事件流程ID*/
	protected Integer siprid;
	/**相关事件流程名称*/
	protected String siprtitle;
	/**附件*/
	protected String siattkey;
	/**登记日期*/
	protected String sidate;
	/** 编辑模式*/
	protected String mode = "0";
	/**实际时间*/
	protected Integer sifacttime;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getSiid() {
		if(siid != null && siid != 0){
			return siid;
		}else{
			return null;
		}
	}

	/**
	 * 设置主键
	 * @param siid 主键
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * 获取类别
	 * @return 类别
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * 设置类别
	 * @param sitype 类别
	 */
	
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * 获取说明
	 * @return 说明
	 */
	public String getSidesc() {
		return sidesc;
	}

	/**
	 * 设置说明
	 * @param sidesc 说明
	 */
	public void setSidesc(String sidesc) {
		this.sidesc = sidesc;
	}

	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * 设置开始时间
	 * @param sibegin 开始时间
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * 设置结束时间
	 * @param siend 结束时间
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * 获取评分
	 * @return 评分
	 */
	public Integer getSimark() {
		return simark;
	}

	/**
	 * 设置评分
	 * @param simark 评分
	 */
	public void setSimark(Integer simark) {
		this.simark = simark;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getSieiid() {
		if(sieiid != null && sieiid != 0){
			return sieiid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关资产ID
	 * @param sieiid 相关资产ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * 获取相关资产名称
	 * @return 相关资产名称
	 */
	public String getSieiname() {
		return sieiname;
	}

	/**
	 * 设置相关资产名称
	 * @param sieiname 相关资产名称
	 */
	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}

	/**
	 * 获取相关流程ID
	 * @return 相关流程ID
	 */
	public Integer getSiprid() {
		if(siprid != null && siprid != 0){
			return siprid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关流程ID
	 * @param siprid 相关流程ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * 获取相关流程名称
	 * @return 相关流程名称
	 */
	public String getSiprtitle() {
		return siprtitle;
	}

	/**
	 * 设置相关流程名称
	 * @param siprtitle 相关流程名称
	 */
	public void setSiprtitle(String siprtitle) {
		this.siprtitle = siprtitle;
	}
	/**
	 * 获取附件
	 * @return 附件
	 */
	public String getSiattkey() {
		return siattkey;
	}

	/**
	 * 设置附件
	 * @param siattkey 附件
	 */
	public void setSiattkey(String siattkey) {
		this.siattkey = siattkey;
	}
	/**
	 * 获取登记日期
	 * @return 登记日期
	 */
	public String getSidate() {
		return sidate;
	}

	/**
	 * 设置登记日期
	 * @param sidate 登记日期
	 */
	public void setSidate(String sidate) {
		this.sidate = sidate;
	}
	
	/**
	 * 获取编辑模式
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 设置编辑模式
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 获取实际时间
	 * @return 实际时间
	 */
	public Integer getSifacttime() {
		return sifacttime;
	}

	/**
	 * 设置实际时间
	 * @param sidate 实际时间
	 */
	public void setSifacttime(Integer sifacttime) {
		this.sifacttime = sifacttime;
	}
	
	/**
	 * 获取附件
	 * @return 获取附件
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}

	/**
	 * 获取附件Map
	 * @return 附件Map
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
}
