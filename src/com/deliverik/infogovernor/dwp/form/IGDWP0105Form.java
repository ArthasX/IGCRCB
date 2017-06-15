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
 * Description: 保存流程信息Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0105Form extends BaseForm{

	/** 计划ID */
	protected Integer id;
	
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
}
