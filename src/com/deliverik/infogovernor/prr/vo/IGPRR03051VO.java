/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 可发起流程集合VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03051VO extends BaseVO{

	/**工作定义集合*/
	protected Map<IG259Info,List<IG380Info>> templateDefinitionMap;

	/**
	 * 工作定义集合取得
	 * @return templateDefinitionMap 工作定义集合
	 */
	public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
		return templateDefinitionMap;
	}

	/**
	 * 工作定义集合设定
	 * @param templateDefinitionMap 工作定义集合
	 */
	public void setTemplateDefinitionMap(
			Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
		this.templateDefinitionMap = templateDefinitionMap;
	}
}
