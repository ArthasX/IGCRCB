/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯��ҳ��������VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10001VO extends BaseVO{

	/**ģ�弯��*/
	protected List<Template> templateList;

	/**
	 * ģ�弯��ȡ��
	 * @return templateList ģ�弯��
	 */
	public List<Template> getTemplateList() {
		return templateList;
	}

	/**
	 * ģ�弯���趨
	 * @param templateList ģ�弯��
	 */
	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}
}
