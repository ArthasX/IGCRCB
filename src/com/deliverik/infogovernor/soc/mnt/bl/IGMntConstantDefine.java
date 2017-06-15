/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 概述:信息发布相关常量
 * 功能描述:信息发布相关常量
 * 创建记录: 杨龙全 2011-9-20
 * 修改记录:
 */
public class IGMntConstantDefine {
	static Log log = LogFactory.getLog(IGMNT01BLImpl.class);
	// -------------------------- 联动菜单分类信息 --------------------------
	/** 组件类型标识 */
	public static String COMPONENT_TYPE_CODE="800";
    /** SYSTEM_KPI标识 */
	public static String SYSTEM_KPI_CODE="801";
    /** SYSTEM采集间隔标识 */
	public static String SYSTEM_VAL_CODE="802";
    /** RA_KPI标识 */
	public static String RA_KPI_CODE="803";
    /** RA采集间隔标识 */
	public static String RA_VAL_CODE="804";
    /** SA_KPI标识 */
	public static String SA_KPI_CODE="805";
    /** SA采集间隔标识 */
	public static String SA_VAL_CODE="806";
    /** CACHE_KPI标识 */
	public static String CACHE_KPI_CODE="807";
    /** CACHE采集间隔标识 */
	public static String CACHE_VAL_CODE="808";
    /**DA_KPI标识 */
	public static String DA_KPI_CODE="809";
    /** DA采集间隔标识 */
	public static String DA_VAL_CODE="810";
    /** DISK_KPI标识 */
	public static String DISK_KPI_CODE="811";
    /** DISK采集间隔标识 */
	public static String DISK_VAL_CODE="812";
    /** DIRECTOR_KPI标识 */
	public static String DIRECTOR_KPI_CODE="813";
    /** DIRECTOR采集间隔标识 */
	public static String DIRECTOR_VAL_CODE="814";
    /** PORT_KPI标识 */
	public static String PORT_KPI_CODE="815";
    /** PORT采集间隔标识 */
	public static String PORT_VAL_CODE="816";
	//-----------对应collect_object_list中object_type-----------
	/** system 对应的类型 */
	public static String SYSTEM="";
	/** RA 对应的类型 */
	public static String RA="DIRECTORS_RDF";
	/** SA 对应的类型 */
	public static String SA="DIRECTORS_FE";
	/** Cache 对应的类型 */
	public static String CACHE="DIRECTORS_FE";
	/** DA 对应的类型 */
	public static String DA="DIRECTORS_DA";
	/** Disk 对应的类型 */
	public static String DISK="DISK";
	/** Director 对应的类型 */
	public static String DIRECTOR="DIRECTORS_FE,DIRECTORS_DA";
	/** Ports 对应的类型 */
	public static String PORT="PORTS_FE";
	
	//--------任务活动状态--------
	/** 活动中*/
	public static String TASKSTATUSACTIVITY="0"; 
	/** 已关闭 */
	public static String TASKSTATUSACLOSE="1"; 
	/** 没有退出按钮 */
	public static String NOEXITFLAG="1";
	/** 有退出按钮 */
	public static String ISEXITFLAG="1";
	/**设置默认为120的*/
	public static String INTERVAL_DEFAULT="Disk,Cache";
	/**默认为120*/
	public static String INTERVAL_DEFAULT_VAL="120";
	/**其他默认为15的*/
	public static String INTERVAL_DEFAULT_OTHER_VAL="15";
	/**错误标识*/
	public static String ERR_FLAG="ERR";
	/**类型名称*/
	public static String MONITOR_OBJTYPE="Symmetrix";
	/**
	 * 用反射获取属性值
	 * @param fieldName 属性值
	 * @return
	 */
	public static String getValue(String fieldName){
		IGMntConstantDefine iGMntConstantDefine=new IGMntConstantDefine();
		String valueStr="";
		try{
			Field value=iGMntConstantDefine.getClass().getField(fieldName);
			 valueStr=(String) value.get(iGMntConstantDefine);
		}catch (Exception e) {
			log.error("========获取"+fieldName+"没有获取到========");
		}
		return valueStr;
	}
}
