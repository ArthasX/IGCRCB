/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.processquery;

import com.deliverik.framework.utility.IGStringUtils;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: Like方式查询条件生成
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class LikeProcessQuery extends DefaultProcessQuery{

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
		tagString.append("<input type='text' name='queryValue' value='");
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
