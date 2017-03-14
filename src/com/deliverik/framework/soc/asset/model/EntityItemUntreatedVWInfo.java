/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model;

/**
 * 概述:未上架机柜、空调、ups视图接口
 * 功能描述: 未上架机柜、空调、ups视图接口
 * 创建人：付彬
 * 创建记录: 2013/07/03
 * 修改记录: 
 */

public interface EntityItemUntreatedVWInfo {
	
	/**资产id 取得*/
	public Integer getEiid();

	/**资产名称  取得*/
	public String getEiname();

	/**资产编号 取得 */
	public String getEilabel();

	/**资产层次码  取得*/
	public String getEsyscoding();

	/**高度  取得*/
	public String getU_total();

	/**机柜、机架标识 取得  */
	public String getContainertype();

	/**空调类型  取得*/
	public String getEitype();
}
