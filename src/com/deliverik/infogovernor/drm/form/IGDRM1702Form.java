/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.form;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录登记Form
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1702Form extends BaseForm{

	/** 主键 */
	protected Integer trid;

	/** 培训名称 */
	protected String trname;

	/** 培训计划id */
	protected Integer tpid;

	/** 培训计划名称 */
	protected String tpname;

	/** 培训内容 */
	protected String tpcontent;

	/** 培训开始时间 */
	protected String trstime;

	/** 培训结束时间 */
	protected String tretime;

	/** 培训地点 */
	protected String trside;

	/** 讲师 */
	protected String trlecturer;
	
	/** 附件信息 */
	protected Map<Integer, FormFile> fileMap = new LinkedHashMap<Integer, FormFile>();
	
	/** 培训人员姓名 */
	protected String[] tpaname;
	
	/** 培训人员联系方式 */
	protected String[] tpatel;
	
	/** 培训人员机构 */
	protected String[] tpaorg;
	
	/** 删除附件信息 */
	protected String predelkey;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * 主键设定
	 *
	 * @param trid 主键
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * 培训名称取得
	 *
	 * @return 培训名称
	 */
	public String getTrname() {
		return trname;
	}

	/**
	 * 培训名称设定
	 *
	 * @param trname 培训名称
	 */
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**
	 * 培训计划id取得
	 *
	 * @return 培训计划id
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * 培训计划id设定
	 *
	 * @param tpid 培训计划id
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * 培训计划名称取得
	 *
	 * @return 培训计划名称
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * 培训计划名称设定
	 *
	 * @param tpname 培训计划名称
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * 培训内容取得
	 *
	 * @return 培训内容
	 */
	public String getTpcontent() {
		return tpcontent;
	}

	/**
	 * 培训内容设定
	 *
	 * @param tpcontent 培训内容
	 */
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**
	 * 培训开始时间取得
	 *
	 * @return 培训开始时间
	 */
	public String getTrstime() {
		return trstime;
	}

	/**
	 * 培训开始时间设定
	 *
	 * @param trstime 培训开始时间
	 */
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**
	 * 培训结束时间取得
	 *
	 * @return 培训结束时间
	 */
	public String getTretime() {
		return tretime;
	}

	/**
	 * 培训结束时间设定
	 *
	 * @param tretime 培训结束时间
	 */
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**
	 * 培训地点取得
	 *
	 * @return 培训地点
	 */
	public String getTrside() {
		return trside;
	}

	/**
	 * 培训地点设定
	 *
	 * @param trside 培训地点
	 */
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**
	 * 讲师取得
	 *
	 * @return 讲师
	 */
	public String getTrlecturer() {
		return trlecturer;
	}

	/**
	 * 讲师设定
	 *
	 * @param trlecturer 讲师
	 */
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**  
	 * 获取附件信息  
	 * @return fileMap 附件信息  
	 */
	
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**  
	 * 设置附件信息  
	 * @param fileMap 附件信息  
	 */
	
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**  
	 * 获取培训人员姓名  
	 * @return tpaname 培训人员姓名  
	 */
	
	public String[] getTpaname() {
		return tpaname;
	}

	/**  
	 * 设置培训人员姓名  
	 * @param tpaname 培训人员姓名  
	 */
	
	public void setTpaname(String[] tpaname) {
		this.tpaname = tpaname;
	}

	/**  
	 * 获取培训人员联系方式  
	 * @return tpatel 培训人员联系方式  
	 */
	
	public String[] getTpatel() {
		return tpatel;
	}

	/**  
	 * 设置培训人员联系方式  
	 * @param tpatel 培训人员联系方式  
	 */
	
	public void setTpatel(String[] tpatel) {
		this.tpatel = tpatel;
	}

	/**  
	 * 获取培训人员机构  
	 * @return tpaorg 培训人员机构  
	 */
	
	public String[] getTpaorg() {
		return tpaorg;
	}

	/**  
	 * 设置培训人员机构  
	 * @param tpaorg 培训人员机构  
	 */
	
	public void setTpaorg(String[] tpaorg) {
		this.tpaorg = tpaorg;
	}
	
	/**
	 * 附件信息设置
	 * @param index 附件索引
	 * @param file 附件信息
	 */
	public void setAttachFile(int index,FormFile file){
		fileMap.put(new Integer(index), file);
	}

	/**  
	 * 获取删除附件信息  
	 * @return predelkey 删除附件信息  
	 */
	
	public String getPredelkey() {
		return predelkey;
	}

	/**  
	 * 设置删除附件信息  
	 * @param predelkey 删除附件信息  
	 */
	
	public void setPredelkey(String predelkey) {
		this.predelkey = predelkey;
	}
}
