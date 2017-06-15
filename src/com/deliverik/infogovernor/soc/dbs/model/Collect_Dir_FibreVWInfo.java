/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model;

 import java.math.BigDecimal;


/**
 * 
 * @Description:存储实时信息视图实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Dir_FibreVWInfo{

    /**
     * 获取时间
     * @return
     */
	public String getSymtime();
	
	/**
	 * 获取设备
	 * @return
	 */
	public String getDirector_number();
	
	/**
	 * 获取使用率
	 * @return
	 */
	public BigDecimal getSysBusy();
	
	
}

