package com.deliverik.infogovernor.crc.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 功能：远程对接自动发起服务请求流程的form
 */
public class IGCRC3001Form extends BaseForm{
	
	private static final long serialVersionUID = 1L;

	//用户id
	protected String platformuserid;
	//服务请求名称
	protected String title;
	//服务请求描述
	protected String desc;
	//服务请求分类
	protected String tree;
	//是否为生产数据导出申请
	protected String type1;
	//影响程度
	protected String type2;
	//紧急程度
	protected String type3;
	
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the tree
	 */
	public String getTree() {
		return tree;
	}

	/**
	 * @return the type1
	 */
	public String getType1() {
		return type1;
	}

	/**
	 * @return the type2
	 */
	public String getType2() {
		return type2;
	}

	/**
	 * @return the type3
	 */
	public String getType3() {
		return type3;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param tree the tree to set
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}

	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}

	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}

	/**
	 * @param type3 the type3 to set
	 */
	public void setType3(String type3) {
		this.type3 = type3;
	}

	/**
	 * @return the platformuserid
	 */
	public String getPlatformuserid() {
		return platformuserid;
	}

	/**
	 * @param platformuserid the platformuserid to set
	 */
	public void setPlatformuserid(String platformuserid) {
		this.platformuserid = platformuserid;
	}
}
