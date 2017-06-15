/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.qlb.igflow.generator.serialnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 流程工单号对比常量 
 *
 */
public final class IGPUBGENERATORType {

	/** 流程工单号前缀对应规则 */
	@SuppressWarnings("serial")
	public static final Map<String, String> SERIALNUM_MAP = new HashMap<String, String>(){
		{
			put("01100", "SF");//服务工单SF
			put("01183", "I");//事件为I
			put("01184", "P");//问题为P
			put("01185", "C");//变更为C
			put("01190", "WB");//个人工作为WB
			put("01200", "WA");//指派工作为WA
			put("01260", "ME");//周例会工作ME
			put("01380", "WS");//技术支持为WS
			put("01402", "WP");//工作问题为WP
			
		}
	};
}
