/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计（检查项）查询检索条件接口
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface CheckVWCond {
	/**
	 * syscoding取得
	 * @return syscoding syscoding
	 */
	public String getSyscoding();
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
