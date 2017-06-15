/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义相关常量类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD01BLType {

	/**
	 * 取得流程查询默认显示列
	 * @return 流程查询默认显示列
	 */
	public static Map<String, String> getDefaultShowColumn(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("pr#prserialnum#工单号", "工单号");
		map.put("pr#prtitle#标题", "标题");
		map.put("pr#prdesc#描述", "描述");
		map.put("pr#prusername#发起人", "发起人");
		map.put("pr#prstatus#状态", "状态");
		map.put("pr#propentime#发起时间", "发起时间");
		map.put("pr#prclosetime#关闭时间", "关闭时间");
		map.put("pp#ppusername#处理人", "处理人");
		return map;
	}
}
