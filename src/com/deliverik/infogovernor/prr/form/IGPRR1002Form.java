/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵���Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR1002Form extends BaseForm{

	/** ����excel���� */
	protected FormFile exportFile;

	/**
	 * ����excel����ȡ��
	 * @return exportFile ����excel����
	 */
	public FormFile getExportFile() {
		return exportFile;
	}

	/**
	 * ����excel�����趨
	 * @param exportFile ����excel����
	 */
	public void setExportFile(FormFile exportFile) {
		this.exportFile = exportFile;
	}
}
