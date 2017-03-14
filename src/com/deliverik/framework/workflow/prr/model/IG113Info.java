package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * 表单日志信息
 * </p>
 */

public interface IG113Info  extends BaseModel {

	/**
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getRlvid();

	/**
	 * 变量ID取得
	 * @return 变量ID
	 */
	public Integer getPiid();

	

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	
	/**
	 * 流程变量标识取得
	 * @return 流程变量标识
	 */
	public String getPivarname();

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPivartype();

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPivarvalue();

	/**
	 * 流程附件KEY取得
	 * @return 流程附件KEY
	 */
	public String getPiattkey();

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPivarlabel();

	/**
	 * 流程自定义前处理标识取得
	 * @return 流程自定义前处理标识
	 */
	public String getPidid();
	
	/**
	 * 流程对象类型变量显示名称取得
	 * @return 流程对象类型变量显示名称
	 */
	public String getPishowvarname();
	
	/**
	 * 流程日志实体取得
	 * @return recordLog 流程日志实体
	 */
	public IG036TB getRecordLog();
	
	/**
	 * 显示内容取得
	 * @return showValue 显示内容
	 */
	public String getShowValue();

}