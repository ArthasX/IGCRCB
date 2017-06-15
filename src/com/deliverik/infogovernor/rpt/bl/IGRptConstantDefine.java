/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 概述:报告相关常量
 * 功能描述:报告相关常量
 * 创建记录: 杨龙全 
 * 修改记录:
 */
public class IGRptConstantDefine {
	static Log log = LogFactory.getLog(IGRptConstantDefine.class);
	
	/**图片默认宽度*/
	public static Float SHAPEWIDTH=200F;
	/**图片默认高度*/
	public static Float SHAPEHEIGHT=200F;
	/**没有找到路径*/
	public static String NOT_FIND_PATH_MSG="1";
	/**图片没有找到*/
	public static String NOT_ANOTHER_IMG_MSG="2";
	/**文档标识前缀*/
	public static String WORD_FLAG_PREFIX="[SOC_";
	/**文档标识后缀*/
	public static String WORD_FLAG_SUFFIX="]";
	/**模板映射关系单条启用*/
	public static String IS_USED="1";
	/**模板映射关系单条未启用*/
	public static String NOT_IS_USED="0";
	/**模板时间类型月标识*/
	public static String TEM_TYPE_MONTH="0";
	/**模板时间类型季标识*/
	public static String TEM_TYPE_QUARTER="1";
	/**模板时间类型年标识*/
	public static String TEM_TYPE_YEAR="2";
	/**word图片位置*/
	public static Integer SHAPE_IMG_LOCATION=1;
	//----------------------------下面为容量报表---------------------------
	/**存储DMX ESYSCODING */
	public static String STORAGE_ESYSCODING="999001009001";
	/**业务系统 ESYSCODING */
	public static String BUSINESS_ESYSCODING="999003001";
	/**主机 ESYSCODING */
	public static String HOST_ESYSCODING="999001001";
	/**卷组 ESYSCODING */
	public static String VG_ESYSCODING="999001004";
	/**文件系统 ESYSCODING */
	public static String FS_ESYSCODING="999001016";
	/**vg与fs关系码 */
	public static String VG_FS_CODE="242";
	
	/** 工单数量统计*/
	public static String REPORT_TEMPLATE_PROCESSNUMBER="1";
	/** 特定表单统计*/
	public static String REPORT_TEMPLATE_SPECIFICFORM="2";
	/** 树形表单统计*/
	public static String REPORT_TEMPLATE_TREEFORM="3";
	/** 人员工作量统计*/
	public static String REPORT_TEMPLATE_WORKLOAD="4";
	
	/**
	 * 用反射获取属性值
	 * @param fieldName 属性值
	 * @return
	 */
	public static String getValue(String fieldName){
		IGRptConstantDefine iGMntConstantDefine=new IGRptConstantDefine();
		String valueStr="";
		try{
			Field value=iGMntConstantDefine.getClass().getField(fieldName);
			 valueStr=(String) value.get(iGMntConstantDefine);
		}catch (Exception e) {
			log.error("========not find==="+fieldName+"========");
		}
		return valueStr;
	}
}
