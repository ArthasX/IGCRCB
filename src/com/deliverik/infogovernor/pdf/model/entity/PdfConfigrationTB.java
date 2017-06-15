/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;

/**
  * 概述: 报表对应BL及模板名称配置表实体
  * 功能描述: 报表对应BL及模板名称配置表实体
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="PdfConfigration")
public class PdfConfigrationTB extends BaseEntity implements Serializable,
		Cloneable, PdfConfigrationInfo {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 数据填充BL名称 */
	protected String pdfbl;

	/** PDF报表模板名称 */
	protected String templatename;
	
	/** PDF报表导出文件名称 */
	protected String exportname;
	
	/** PDF报表XML文件名称 */
	protected String xmlname;

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 数据填充BL名称取得
	 *
	 * @return 数据填充BL名称
	 */
	public String getPdfbl() {
		return pdfbl;
	}

	/**
	 * 数据填充BL名称设定
	 *
	 * @param pdfbl 数据填充BL名称
	 */
	public void setPdfbl(String pdfbl) {
		this.pdfbl = pdfbl;
	}

	/**
	 * PDF报表模板名称取得
	 *
	 * @return PDF报表模板名称
	 */
	public String getTemplatename() {
		return templatename;
	}

	/**
	 * PDF报表模板名称设定
	 *
	 * @param templatename PDF报表模板名称
	 */
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pdid;
	}

    /**
     * @return the PDF报表导出文件名称
     */
    public String getExportname() {
        return exportname;
    }

    /**
     * @param PDF报表导出文件名称 the exportname to set
     */
    public void setExportname(String exportname) {
        this.exportname = exportname;
    }

    /**
     * @return the PDF报表XML文件名称
     */
    public String getXmlname() {
        return xmlname;
    }

    /**
     * @param PDF报表XML文件名称 the xmlname to set
     */
    public void setXmlname(String xmlname) {
        this.xmlname = xmlname;
    }

}