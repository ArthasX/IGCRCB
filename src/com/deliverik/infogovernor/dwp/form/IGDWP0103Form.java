/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.form;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作任务发起操作
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0103Form extends BaseForm{
	
	/** 计划ID */
	protected Integer id;
	
	/** 计划名称 */
	protected String pname;
	
	/** 计划描述 */
	protected String pdesc;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程名称 */
	protected String pdname;
	
	/** 短信内容 */
	protected String smscontent;
	
	/** 开始时间 */
	protected String startdate;
	
	/** 结束时间 */
	protected String enddate;
	
	/** 计划模式 */
	protected String pmode;
	
	/** 计划类型 */
	protected String ptype;
	
	/** 计划执行时间：小时 */
	protected String phour;
	
	/** 计划执行时间：分钟 */
	protected String pminute;
	
	/** 发起角色 */
	protected Integer prroleid;
	
	/** 发起人联系方式 */
	protected String prinfo;
	
	/** 流程标题 */
	protected String prtitle;
	
	/** 流程描述 */
	protected String prdesc;
	
	/** 流程变量参数值 */
	protected String[] pivarvalue;
	
	/** 流程变量定义ID */
	protected String[] pidid;
	
	/**文本域附件绑定*/
	protected Map<Integer, FormFile> fileMapMuti = new LinkedHashMap<Integer, FormFile>();
	
	/** 附件绑定map中的对应表单名称及顺序 */
	protected String[] att=new String[]{};
	
	/** 资产 */
	protected Map<Integer, String> entityMap = new LinkedHashMap<Integer, String>();
	
	protected String parprid;
	
	protected String psdid;
	
	/** 查看状态（0可编辑，1可查看） */
	protected String viewstate;

	/**
	 * 计划ID取得
	 * @return id 计划ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 计划ID设定
	 * @param id 计划ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 计划名称取得
	 * @return pname 计划名称
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 计划名称设定
	 * @param pname 计划名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 计划描述取得
	 * @return pdesc 计划描述
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * 计划描述设定
	 * @param pdesc 计划描述
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程名称取得
	 * @return pdname 流程名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程名称设定
	 * @param pdname 流程名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 短信内容取得
	 * @return smscontent 短信内容
	 */
	public String getSmscontent() {
		return smscontent;
	}

	/**
	 * 短信内容设定
	 * @param smscontent 短信内容
	 */
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

	/**
	 * 开始时间取得
	 * @return startdate 开始时间
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * 开始时间设定
	 * @param startdate 开始时间
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * 结束时间取得
	 * @return enddate 结束时间
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * 结束时间设定
	 * @param enddate 结束时间
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * 计划模式取得
	 * @return pmode 计划模式
	 */
	public String getPmode() {
		return pmode;
	}

	/**
	 * 计划模式设定
	 * @param pmode 计划模式
	 */
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}

	/**
	 * 计划类型取得
	 * @return ptype 计划类型
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	 * 计划类型设定
	 * @param ptype 计划类型
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/**
	 * 计划执行时间：小时取得
	 * @return phour 计划执行时间：小时
	 */
	public String getPhour() {
		return phour;
	}

	/**
	 * 计划执行时间：小时设定
	 * @param phour 计划执行时间：小时
	 */
	public void setPhour(String phour) {
		this.phour = phour;
	}

	/**
	 * 计划执行时间：分钟取得
	 * @return pminute 计划执行时间：分钟
	 */
	public String getPminute() {
		return pminute;
	}

	/**
	 * 计划执行时间：分钟设定
	 * @param pminute 计划执行时间：分钟
	 */
	public void setPminute(String pminute) {
		this.pminute = pminute;
	}
	
	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getParprid() {
		return parprid;
	}

	public void setParprid(String parprid) {
		this.parprid = parprid;
	}

	/**
	 * 发起角色取得
	 * @return prroleid 发起角色
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 发起角色设定
	 * @param prroleid 发起角色
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 发起人联系方式取得
	 * @return prinfo 发起人联系方式
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * 发起人联系方式设定
	 * @param prinfo 发起人联系方式
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * 流程标题取得
	 * @return prtitle 流程标题
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程标题设定
	 * @param prtitle 流程标题
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程描述取得
	 * @return prdesc 流程描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程描述设定
	 * @param prdesc 流程描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * 流程变量参数值取得
	 * @return pivarvalue 流程变量参数值
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 流程变量参数值设定
	 * @param pivarvalue 流程变量参数值
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 流程变量定义ID取得
	 * @return pidid 流程变量定义ID
	 */
	public String[] getPidid() {
		return pidid;
	}

	/**
	 * 流程变量定义ID设定
	 * @param pidid 流程变量定义ID
	 */
	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}
	
	/**
	 * 设置附件值
	 * @param index 附件索引
	 * @param file
	 */
	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}

	/**
	 * 文本域附件绑定取得
	 * @return fileMapMuti 文本域附件绑定
	 */
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	/**
	 * 文本域附件绑定设定
	 * @param fileMapMuti 文本域附件绑定
	 */
	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	/**
	 * 附件绑定map中的对应表单名称及顺序取得
	 * @return att 附件绑定map中的对应表单名称及顺序
	 */
	public String[] getAtt() {
		return att;
	}

	/**
	 * 附件绑定map中的对应表单名称及顺序设定
	 * @param att 附件绑定map中的对应表单名称及顺序
	 */
	public void setAtt(String[] att) {
		this.att = att;
	}
	
	/**
	 * 设置资产
	 * @param index 资产数组索引
	 * @param file 资产
	 */
	public void setEntityId(int index, String entityId) {
		entityMap.put(new Integer(index), entityId);
	}

	/**
	 * 资产取得
	 * @return entityMap 资产
	 */
	public Map<Integer, String> getEntityMap() {
		return entityMap;
	}

	/**
	 * 资产设定
	 * @param entityMap 资产
	 */
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
	}

	/**
	 * 查看状态（0可编辑，1可查看）取得
	 * @return viewstate 查看状态（0可编辑，1可查看）
	 */
	public String getViewstate() {
		return viewstate;
	}

	/**
	 * 查看状态（0可编辑，1可查看）设定
	 * @param viewstate 查看状态（0可编辑，1可查看）
	 */
	public void setViewstate(String viewstate) {
		this.viewstate = viewstate;
	}
	
}
