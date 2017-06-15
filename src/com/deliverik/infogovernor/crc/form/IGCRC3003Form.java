package com.deliverik.infogovernor.crc.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 功能：远程对接自动发起变更流程的form
 */
public class IGCRC3003Form extends BaseForm{
	
	private static final long serialVersionUID = 1L;

	/** 用户id */
	protected String platformuserid;
	
	/** 变更名称 */
	protected String title;
	
	/** 变更描述 */
	protected String desc;
	
	/** 计划执行开始时间 */
	protected String begintime;
	
	/** 变更类型 */
	protected String tree;
	
	/** 变更类别 */
	protected String type1;
	
	/** 变更分类 */
	protected String type2;
	
	/** 更新平台 */
	protected String type3;
	
	/** 变更原因分类 */
	protected String type4;
	
	/** 变更原因 */
	protected String text1;
	
	/** 变更内容 */
	protected String text2;
	
	/** 是否影响业务 */
	protected String type5;
	
	/** 执行计划 */
	protected String text3;
	
	/** 回退计划 */
	protected String text4;
	
	/** 验证计划 */
	protected String text5;
	
	/**文本域附件绑定*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = null;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		fileMapMuti = new HashMap<Integer, FormFile>();
		fileMap = new HashMap<Integer, FormFile>();
	}
	
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}
	
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}
	
	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
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
	 * 附件取得
	 * @return 附件
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * 附件设定
	 * @param fileMap 附件
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
     * 用户id获取
     * @return 用户id
     */
	public String getPlatformuserid() {
		return platformuserid;
	}

	/**
	 * 用户id设置
	 * @param platformuserid 用户id
	 */
	public void setPlatformuserid(String platformuserid) {
		this.platformuserid = platformuserid;
	}

	/**
     * 变更名称获取
     * @return 变更名称
     */
	public String getTitle() {
		return title;
	}

	/**
	 * 变更名称设置
	 * @param title 变更名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
     * 变更描述获取
     * @return 变更描述
     */
	public String getDesc() {
		return desc;
	}

	/**
	 * 变更描述设置
	 * @param desc 变更描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
     * 计划执行开始时间获取
     * @return 计划执行开始时间 
     */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * 计划执行开始时间设置
	 * @param begintime 计划执行开始时间 
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	
	/**
     * 变更类型获取
     * @return 变更类型
     */
	public String getTree() {
		return tree;
	}

	/**
	 * 变更类型设置
	 * @param tree 变更类型
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}

	/**
     * 变更类别 获取
     * @return 变更类别 
     */
	public String getType1() {
		return type1;
	}

	/**
	 * 变更类别 设置
	 * @param type1  变更类别 
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}

	/**
     * 变更分类获取
     * @return 变更分类
     */
	public String getType2() {
		return type2;
	}

	/**
	 * 变更分类设置
	 * @param type2  变更分类
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}

	/**
     * 更新平台获取
     * @return 更新平台
     */
	public String getType3() {
		return type3;
	}

	/**
	 * 更新平台设置
	 * @param type3  更新平台
	 */
	public void setType3(String type3) {
		this.type3 = type3;
	}

	/**
     * 变更原因分类获取
     * @return 变更原因分类
     */
	public String getType4() {
		return type4;
	}

	/**
	 * 变更原因分类设置
	 * @param type4  变更原因分类
	 */
	public void setType4(String type4) {
		this.type4 = type4;
	}

	/**
     * 变更原因获取
     * @return 变更原因
     */
	public String getText1() {
		return text1;
	}

	/**
	 * 变更原因设置
	 * @param text1  变更原因
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}

	/**
     * 变更内容获取
     * @return 变更内容
     */
	public String getText2() {
		return text2;
	}

	/**
	 * 变更内容设置
	 * @param text2  变更内容
	 */
	public void setText2(String text2) {
		this.text2 = text2;
	}

	/**
     * 是否影响业务获取
     * @return 是否影响业务
     */
	public String getType5() {
		return type5;
	}

	/**
	 * 是否影响业务设置
	 * @param type5  是否影响业务
	 */
	public void setType5(String type5) {
		this.type5 = type5;
	}

	/**
     * 执行计划获取
     * @return 执行计划
     */
	public String getText3() {
		return text3;
	}

	/**
	 * 执行计划设置
	 * @param text3 执行计划
	 */
	public void setText3(String text3) {
		this.text3 = text3;
	}

	/**
     * 回退计划获取
     * @return 回退计划
     */
	public String getText4() {
		return text4;
	}

	/**
	 * 回退计划设置
	 * @param text4 回退计划
	 */
	public void setText4(String text4) {
		this.text4 = text4;
	}

	/**
     * 验证计划获取
     * @return 起始时间
     */
	public String getText5() {
		return text5;
	}

	/**
	 * 验证计划设置
	 * @param text5 验证计划
	 */
	public void setText5(String text5) {
		this.text5 = text5;
	}
	
}
