/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化首页辅助功能VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10001VO extends BaseVO{

	/**模板集合*/
	protected List<Template> templateList;

	/**
	 * 模板集合取得
	 * @return templateList 模板集合
	 */
	public List<Template> getTemplateList() {
		return templateList;
	}

	/**
	 * 模板集合设定
	 * @param templateList 模板集合
	 */
	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}
}
