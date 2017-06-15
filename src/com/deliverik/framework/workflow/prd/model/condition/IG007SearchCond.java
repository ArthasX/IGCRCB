/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程变量定义信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>pidid</td>
 * <td>流程变量定义ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>流程类型ID</td>
 * </tr>
 * <tr>
 * <td>pidlabel</td>
 * <td>流程变量显示名称</td>
 * </tr> 
 * <tr>
 * <td>pidname</td>
 * <td>流程变量名称</td>
 * </tr> 
 * <tr>
 * <td>pidtype</td>
 * <td>流程变量类型</td>
 * </tr> 
 * <tr>
 * <td>pidrequired</td>
 * <td>流程变量是否必填</td>
 * </tr> 
 * <tr>
 * <td>pidname_like</td>
 * <td>流程变量名称(模糊匹配)</td>
 * </tr> 
 * <tr>
 * <td>isDefault</td>
 * <td>流程变量定义是否判断变量为缺省变量标识（WorkFlowConstDefine.YES:判断，WorkFlowConstDefine.NO:不判断）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG007SearchCond {
	
	/**
	 * 功能：流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public String getPidid();

	/**
	 * 功能：流程类型ID取得
	 * @return 流程类型ID
	 */
	public String getPdid();

	/**
	 * 功能：流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();

	/**
	 * 功能：流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();

	/**
	 * 功能：流程变量是否必填取得
	 * @return 流程变量是否必填
	 */
	public String getPidrequired();

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname_like();

	/**
	 * 功能：流程变量定义是否判断变量为缺省变量标识取得
	 * @return 流程变量定义是否判断变量为缺省变量标识
	 */
	public String getIsDefault();
	
	public Integer getPidgid();
	
	/**
	 * 功能：流程共通变量ID取得
	 * @return 流程共通变量ID
	 */
	public String getPidmode();
	
	public String getPidid_notlike();
	
	public String getPsdcode_like();

	public String getPpdid_like();

	public String getPsdid_like();
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPidid_like();
	
	public String[] getPidtypes();
	
	/**
	 * 表格类表单列标识取得
	 * @return tableColumn 表格类表单列标识
	 */
	public String getTableColumn();
	
	 /**
		 * 父表单定义主键取得
		 * @return ppidid 父表单定义主键
		 */
	public String getPpidid();
	
	/**
	 *是否导出操作取得
	 */
	public String getIsExport();
		
	public String getPiduse();
}
