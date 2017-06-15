/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程excel导入常量类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR10BLType {

	/**
	 * 标记
	 */
	public static enum Sign{
		/** 流程定义ID */
		PDID("pdid"),
		/** 基本信息 */
		BASIS("basis"),
		/** 参与人信息 */
		PARTICIPANT("participant"),
		/** 表单信息 */
		PROCESS_INFO("processinfo")
		;
		
		private String code;
		
		private Sign(String _code){
			this.code = _code;
		}
		
		public String toString(){
			return this.code;
		}
	}
	
	/** 普通表单KEY */
	public static final String PROCESS_BASIS_FORM_KEY = "basis_key";
	
	/** 流程发起人 */
	public static final String PROCESS_BASIS_OPENER = "发起人ID";
	
	/** 流程发起时间 */
	public static final String PROCESS_BASIS_OPENTIME = "发起时间";
	
	/** 流程关闭时间 */
	public static final String PROCESS_BASIS_CLOSETIME = "关闭时间";
	
	/** 
	 * <p>可导入的流程类型范围</p> 
	 * 门禁申请(01371)、数据拷贝申请(01281)
	 * --内部互联网申请(01372)、外部互联网申请(01373)、
	 * 数据查询申请(01060)、数据变更申请流程(01063)、程序变更申请流程(01065)、 
	 */
	public static final String[] PROCESS_PDIDS = new String[]{"01371","01281","01060","01063","01065"};
}
