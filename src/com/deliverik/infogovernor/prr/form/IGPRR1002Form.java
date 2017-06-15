/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导入Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR1002Form extends BaseForm{

	/** 导入excel对象 */
	protected FormFile exportFile;

	/**
	 * 导入excel对象取得
	 * @return exportFile 导入excel对象
	 */
	public FormFile getExportFile() {
		return exportFile;
	}

	/**
	 * 导入excel对象设定
	 * @param exportFile 导入excel对象
	 */
	public void setExportFile(FormFile exportFile) {
		this.exportFile = exportFile;
	}
}
