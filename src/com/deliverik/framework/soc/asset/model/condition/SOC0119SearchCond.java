package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * <p>
 * 资产关系信息检索条件
 * </p>
 * <p>
 * (未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>正反向任意关联资产ID</td>
 * </tr>
 * <tr>
 * <td>pareiid</td>
 * <td>正向关联资产ID</td>
 * </tr> 
 * <tr>
 * <td>cldeiid</td>
 * <td>反向关联资产ID</td>
 * </tr> 
 * <tr>
 * <td>parversion</td>
 * <td>正向资产大版本</td>
 * </tr> 
 * <tr>
 * <td>parsmallversion</td>
 * <td>正向资产小版本</td>
 * </tr> 
 * <tr>
 * <td>cldversion</td>
 * <td>反向资产大版本</td>
 * </tr> 
 * <tr>
 * <td>cldsmallversion</td>
 * <td>反向资产小版本</td>
 * </tr> 
 * <tr>
 * <td>deleteflag</td>
 * <td>逻辑删除标识</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0119SearchCond {

	/**
	 * 资产ID（正反向任意）取得
	 * @return 资产ID（正反向任意）
	 */
	public String getEiid();
	
	/**
	 * 资产ID（正向）取得
	 * @return 资产ID（正向）
	 */
	public Integer getPareiid();
	
	/**
	 * 资产ID（反向）取得
	 * @return 资产ID（反向）
	 */
	public Integer getCldeiid();
	
	/**
	 * 资产关系ID取得（平台保留）
	 * @return 资产关系ID
	 */
	public String getEirrelation();
	
	/**
	 * 资产关系是否可以删除标识（"C"标识不能删除）取得（平台保留）
	 * @return 资产关系是否可以删除标识
	 */
	public String getEirstatus();
	
	/**
	 * 资产关系说明取得（平台保留）
	 * @return 资产关系说明
	 */
	public String getEirdesc();
	
	/**
	 * 通过资产属性增加自动生成的关系信息取得（平台保留）
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	public String getEirinfo();
	
	/**
	 * 正向资产大版本取得
	 * @return 正向资产大版本
	 */
	public Integer getParversion();
	
	/**
	 * 正向资产小版本取得
	 * @return 正向资产小版本
	 */
	public Integer getParsmallversion();
	
	/**
	 * 反向资产大版本取得
	 * @return 反向资产大版本
	 */
	public Integer getCldversion();

	/**
	 * 反向资产小版本取得
	 * @return 反向资产小版本
	 */
	public Integer getCldsmallversion();

	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 资产大版本（正反向任意）取得
	 * 
	 * @return 资产大版本（正反向任意）
	 */
	public String getEiversion();

	/**
	 * 资产小版本（正反向任意）
	 * 
	 * @return 资产小版本（正反向任意）
	 */
	public String getEismallversion();
	
	public String getEirrelationcode();
	
	public String getPareiids() ;

	public String getCldeiids();
	
	public boolean isFlag();
		/**
	 * eirrelation_in取得
	 *
	 * @return eirrelation_in eirrelation_in
	 */
	public String[] getEirrelation_in();
	
	public String getEirrelations();
	
	/**
	 * 资产模型ID（正向）取得
	 * @return 资产模型ID（正向）
	 */
	public Integer getPareid();
	
	/**
	 * 资产模型ID（反向）取得
	 * @return 资产模型ID（反向）
	 */
	public Integer getCldeid();
	
	List<Integer> getCldriid_in();
}

