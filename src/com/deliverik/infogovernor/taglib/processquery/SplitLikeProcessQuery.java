/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.processquery;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 分割层级过滤条件生成
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SplitLikeProcessQuery extends DefaultProcessQuery{

	/**
	 * 生成标签
	 * @param param 参数
	 * @return 生成后的标签字符串
	 */
	public String generatedTag() {
		StringBuffer tagString = new StringBuffer();
		tagString.append("<span>");
		tagString.append(queryObj.getQname());
		tagString.append("：</span>");
		tagString.append("<input type='text' readOnly='true' name='qv' ");
		if(this.queryObj.getQtype().equals("pi")){
			IG007Info pid = this.queryObj.getPid();
			String val = "";
			String function = "";
			if("T".equals(pid.getPidtype())){
				if(StringUtils.isNotEmpty(this.value) && this.value.contains("_tree_")){
					val = this.value.split("_tree_")[1];
				}
				function = "selectTree(this,'" + pid.getCcid() + "');";
			}else if("G".equals(pid.getPidtype())){
				if(StringUtils.isNotEmpty(this.value) && this.value.contains("_OrgTree_")){
					val = this.value.split("_OrgTree_")[1];
				}
				function = "selectOrgTree(this);";
			}
			tagString.append(" value='");
			tagString.append(val);
			tagString.append("' ");
			tagString.append(" onclick=\"");
			tagString.append(function);
			tagString.append("\" ");
		}
		tagString.append("/> ");
		tagString.append("<input type='hidden' name='queryValue' value='");
		tagString.append(IGStringUtils.filterXMLStr(value));
		tagString.append("'/><input type='hidden' name='queryKey' value='");
		tagString.append(queryObj.getQtype());
		tagString.append("#");
		tagString.append(queryObj.getQflag());
		tagString.append("#");
		tagString.append(queryObj.getQname());
		tagString.append("'/>");
		return tagString.toString();
	}
}
