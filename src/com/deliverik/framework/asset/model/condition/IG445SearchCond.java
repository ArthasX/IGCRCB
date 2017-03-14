package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * 设备统计分析信息查询条件（平台保留）
 * </p>
 * <p>
 * (未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>ciupdtime_from</td>
 * <td>资产登记开始时间（大于等于）</td>
 * </tr>
 * <tr>
 * <td>ciupdtime_to</td>
 * <td>资产登记截止时间（小于等于）</td>
 * </tr> 
 * <tr>
 * <td>eid</td>
 * <td>资产模型ID</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding_q</td>
 * <td>资产所属机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG445SearchCond {
	
	/** 资产登记开始时间*/
	public String getCiupdtime_from();
	
	/** 资产登记截止时间*/
	public String getCiupdtime_to();
	
	/** 资产模型ID*/
	public String getEid();
	
	/** 资产所属机构层次码*/
	public String getEiorgsyscoding_q();
	
}
