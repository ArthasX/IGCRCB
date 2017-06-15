/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.processquery;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件标签生成工厂类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ProcessQueryFactory {

	/** 生成类结合 */
	protected Map<String, ProcessQuery> map;

	/**
	 * 生成类结合设定
	 * @param map 生成类结合
	 */
	public void setMap(Map<String, ProcessQuery> map) {
		this.map = map;
	}
	
	/**
	 * 生成标签
	 * @param param 参数
	 * @return 生成后的标签字符串
	 */
	public String generatedTag(Map<String, Object> param){
		IG111Info info = (IG111Info) param.get(ProcessQuery.PARAM_DEFINITION_OBJECT);
		String value = (String) param.get(ProcessQuery.PARAM_VALUE);
		List<IG333Info> psdList = (List<IG333Info>) param.get(ProcessQuery.PARAM_STATUS_DEFINITION);
		ProcessQuery tag = map.get(info.getQmode());
		if(tag == null) return "暂不支持此查询条件";
		tag.setQueryObj(info);
		tag.setValue(value);
		tag.setPsdList(psdList);
		return tag.generatedTag();
	}
}
