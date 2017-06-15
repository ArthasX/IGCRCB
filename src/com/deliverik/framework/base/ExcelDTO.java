/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.base;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

import jxl.Sheet;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 概述: Excel导出通用DTO
 * 功能描述: Excel导出通用DTO
 * 创建记录:
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class ExcelDTO extends BaseDTO {
	
    /** 响应对象 */
	protected HttpServletResponse response;
	
	/** 模版标识 */
	protected String fileid;
	
	/** 可写Sheet页 */
	protected WritableSheet writableSheet;
	
	/** 可写模版 */
	protected WritableWorkbook writableWorkbook;
	
	/** 模版Sheet页 */
	protected Sheet templateSheet;
	
	/** 显示名称 */
	protected String displayName;
	
	/** 数据列表起始行数 */
	protected int startRow;
	
	protected IGWKM0101Form igwkm0101form;
	
	protected FileOutputStream fos_I;	
	
	public FileOutputStream getFos_I() {
		return fos_I;
	}

	public void setFos_I(FileOutputStream fos_I) {
		this.fos_I = fos_I;
	}

	/**
     * 数据列表起始行数取得
     * 
     * @return 数据列表起始行数
     */
	public int getStartRow() {
		return startRow;
	}

	/**
     * 数据列表起始行数设定
     * 
     * @param 数据列表起始行数
     */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
     * 响应对象取得
     * 
     * @return 响应对象
     */
	public HttpServletResponse getResponse() {
        return response;
    }

	/**
     * 响应对象设定
     * 
     * @param 响应对象
     */
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

	/**
	 * 模版标识取得
	 * 
	 * @return 模版标识
	 */
	public String getFileid() {
		return fileid;
	}

	/**
	 * 模版标识设定
	 * 
	 * @param fileid 模版标识
	 */
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	/**
	 * 可写Sheet页取得
	 * 
	 * @return 可写writableSheet页
	 */
	public WritableSheet getWritableSheet() {
		return writableSheet;
	}

	/**
	 * 可写Sheet页设定
	 * 
	 * @param writableSheet 可写Sheet页
	 */
	public void setWritableSheet(WritableSheet writableSheet) {
		this.writableSheet = writableSheet;
	}

	/**
	 * 可写模板取得
	 * 
	 * @return writableWorkbook 可写模板
	 */
	public WritableWorkbook getWritableWorkbook() {
		return writableWorkbook;
	}

	/**
	 * 可写模板设定
	 * 
	 * @param writableWorkbook 可写模板
	 */
	public void setWritableWorkbook(WritableWorkbook writableWorkbook) {
		this.writableWorkbook = writableWorkbook;
	}

	/**
	 * 模版Sheet页取得
	 * 
	 * @return 模版Sheet页
	 */
	public Sheet getTemplateSheet() {
		return templateSheet;
	}

	/**
	 * 模版Sheet页设定
	 * 
	 * @param templateSheet 模版Sheet页
	 */
	public void setTemplateSheet(Sheet templateSheet) {
		this.templateSheet = templateSheet;
	}

	/**
	 * 显示名称取得
	 * 
	 * @return 显示名称
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 显示名称设定
	 * 
	 * @param displayName 显示名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}
	
	
	
	
}
