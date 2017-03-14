/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:风险检查统计查询接口 （检查）
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface CheckVWInfo{
	/**
	 * syscoding取得
	 * @return syscoding syscoding
	 */
	public String getSyscoding();

	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * 检查方法取得
	 * @return checkMethod 检查方法
	 */
	public String getCheckMethod();

	/**
	 * 建议检查频度取得
	 * @return checkfrequency 建议检查频度
	 */
	public String getCheckfrequency();
}
