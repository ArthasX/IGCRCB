/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产关系图画面FORM
 * 
 */
public class IGCOM0305Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 资产ID */
	protected String eiid;
	
	/** 关系图XML */
	protected String relationXmlStr;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 关系数 */
	protected String eircount;
	
	/** 关系图XML文件名称 */
	protected String filename;
	
	/** 画板宽 */
	protected String width;
	
	/** 画板高 */
	protected String height;
	
	/** 画板x坐标 */
	protected String coordsize_x;
	
	/** 画板y坐标 */
	protected String coordsize_y;
	
	/** 版本 */
	protected String eiversion;
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 关系图XML取得
	 * @return 关系图XML
	 */
	public String getRelationXmlStr() {
		return relationXmlStr;
	}

	/**
	 * 关系图XML设定
	 *
	 * @param relationXmlStr 关系图XML
	 */
	public void setRelationXmlStr(String relationXmlStr) {
		this.relationXmlStr = relationXmlStr;
	}

	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 关系数取得
	 * @return 关系数
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * 关系数设定
	 *
	 * @param eircount 关系数
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}

	/**
	 * 关系图XML文件名称取得
	 * @return 关系图XML文件名称
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * 关系图XML文件名称设定
	 *
	 * @param filename 关系图XML文件名称
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 画板宽取得
	 * @return 画板宽
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * 画板宽设定
	 *
	 * @param width 画板宽
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 画板高取得
	 * @return 画板高
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 画板高设定
	 *
	 * @param height 画板高
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * 画板x坐标取得
	 * @return 画板x坐标
	 */
	public String getCoordsize_x() {
		return coordsize_x;
	}

	/**
	 * 画板x坐标设定
	 *
	 * @param coordsize_x 画板x坐标
	 */
	public void setCoordsize_x(String coordsize_x) {
		this.coordsize_x = coordsize_x;
	}

	/**
	 * 画板y坐标取得
	 * @return 画板y坐标
	 */
	public String getCoordsize_y() {
		return coordsize_y;
	}

	/**
	 * 画板y坐标设定
	 *
	 * @param coordsize_y 画板y坐标
	 */
	public void setCoordsize_y(String coordsize_y) {
		this.coordsize_y = coordsize_y;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}
	
}
