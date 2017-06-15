package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * <p>
 * 资产信息检索条件
 * </p>
 * <p>
 * (未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>elabel</td>
 * <td>资产模型编号</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>资产编号</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>资产名称（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>ecategory</td>
 * <td>资产模型分类</td>
 * </tr> 
 * <tr>
 * <td>eiupdtime_from</td>
 * <td>资产更新开始时间（大于等于）</td>
 * </tr> 
 * <tr>
 * <td>eiupdtime_to</td>
 * <td>资产更新截止时间（小于等于）</td>
 * </tr>
 * <tr>
 * <td>eiorgcode</td>
 * <td>资产所属机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>esyscoding</td>
 * <td>资产模型层次码（前方一致模糊匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG688SearchCond {
	
	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel();

	/**
	 * 资产模型名称取得（平台保留）
	 * @return 资产模型名称
	 */
	public String getEname();

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel();
	
	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory();
	
	/**
	 * 资产模型一级子类取得（平台保留）
	 * @return 资产模型一级子类
	 */
	public String getEkey1();
	
	/**
	 * 资产模型二级子类取得（平台保留）
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产更新开始时间取得
	 * @return 资产更新开始时间FROM
	 */
	public String getEiupdtime_from();

	/**
	 * 资产更新截止时间取得
	 * @return 资产更新截止时间
	 */
	public String getEiupdtime_to();

	/**
	 * 资产属性名称检索条件数组取得（平台保留）
	 * @return 资产属性名称检索条件数组
	 */
	public String[] getCname();

	/**
	 * 资产属性值检索条件数组取得（平台保留）
	 * @return 资产属性值检索条件数组
	 */
	public String[] getCivalue();

	/**
	 * 资产共通属性编号检索条件数组取得（平台保留）
	 * @return 资产共通属性编号检索条件数组
	 */
	public String[] getCclabel();

	/**
	 * 资产共通属性值检索条件数组取得（平台保留）
	 * @return 资产共通属性值检索条件数组
	 */
	public String[] getCcivalue();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgcode();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding_q();
	
	/**
	 * 资产状态取得（平台保留）
	 * @return 资产状态
	 */
	public String getEistatus_q();

	/**
	 * 资产状态取得（平台保留）
	 * @return 资产状态
	 */
	public String getEistatus();
	
	/**
	 * 资产模型层次码得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 资产ID集合取得（平台保留）
	 * @return 资产ID集合
	 */
	public List<String> getEiidList();
	
	/**
	 * 资产使用机构code取得
	 * @return 资产使用机构code
	 */
	public String getUsesyscoding();
	
	/** 
	 * 维保开始日期取得 
	 * @return 维保开始日期
	 */
	 public String getWbdate_from();
	 
	 /**
	  * 维保结束日期取得 
	  * @return 维保结束日期
	  */
	 public String getWbdate_to();
	 
	 /**
	 * 资产模型状态取得
	 * 
	 * @return 资产模型状态
	 */
	public String getEstatus();
	
	/**
	 * 资产模型类别取得
	 * 
	 * @return 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	public String getEmodeltype_eq();
	
	/**
	 * 资产描述模糊查询
	 * @return
	 */
	public String getEidesc_like();

    /**
     * 是否查询发票标志
     * @return
     */
    public String getQueryflag();
	
}
