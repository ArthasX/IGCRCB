package com.deliverik.framework.workflow.prr.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * 流程变量信息
 *
 */
public interface IG599Info  extends BaseModel {

	/**
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public Integer getPiid();

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
	 * 流程变量模式取得
	 * @return 流程变量模式
	 */
	public String getPidmode();
	
	/**
	 * 私有变量权限范围设定
	 * 
	 * @return 私有变量权限范围
	 */
	public String getPrivatescope();
	
	/**
	 * 参与者具有的流程变量权限取得
	 * @return 参与者具有的流程变量权限
	 */
	public String getPidaccess();
	
	/**
	 * 私有变量值取得
	 * @return 私有变量值集合
	 */
	public List<IG899TB> getProcessPrivateInfofList();
	
	/**
	 *备注取得
	 */
	public String getPidcomment();

}