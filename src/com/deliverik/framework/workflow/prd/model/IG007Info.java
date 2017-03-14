package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * 流程变量定义信息
 *
 */
public interface IG007Info  extends BaseModel {

	/**
	 * 流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public String getPidid();

	/**
	 * 流程类型ID取得
	 * @return 流程类型ID
	 */
	public String getPdid();

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();

	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();

	/**
	 * 流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc();

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();

	/**
	 * 流程变量选项取得
	 * @return 流程变量选项
	 */
	public String getPidoption();

	/**
	 * 流程变量默认值取得
	 * @return 流程变量默认值
	 */
	public String getPiddefault();

	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public Integer getPiid();

	/**
	 * 流程变量排序标识取得
	 * @return 流程变量排序标识
	 */
	public String getPidsortid();
	
	/**
	 * 流程变量是否必填取得
	 * @return 流程变量是否必填
	 */
	public String getPidrequired();
	
	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue();
	
	/**
	 * 参与者具有的流程变量权限取得
	 * @return 参与者具有的流程变量权限
	 */
	public String getPidaccess();
	
	public Integer getPidgid();
	/**
	 * 流程变量联动信息取得
	 * @return 流程变量联动信息
	 */
	public List<IG286TB> getProcessLinkageDefList();
	
	/**
	 * 树形流程变量CCID取得
	 * @return 树形流程变量CCID
	 */
	public String getCcid();
	
	/**
	 * 表单信息的模式取得
	 *
	 * @return pidmode 表单信息的模式
	 */
	public String getPidmode();
	
	
//	public String getPiattkey()
	
	/**
	 * 表单信息的行显示模式取得
	 *
	 * @return 表单信息的行模式
	 */
	public String getRowwidth();
	
	/**
	 * 私有变量权限范围设定
	 * 
	 * @return 私有变量权限范围
	 */
	public String getPrivatescope();
	
	/**
	 * 私有变量值取得
	 * @return 私有变量值集合
	 */
	public List<IG899TB> getProcessPrivateInfoList();
	
	/**
	 * 是否包含附件取得
	 * @return 是否包含附件
	 */
	public String getHasattach();
	/**
	 * 表格模式取得
	 * @return piddisplay 表格模式
	 */
	public String getPiddisplay();

	/**
	 * 使用模式取得
	 * @return piduse 使用模式
	 */
	public String getPiduse();

	/**
	 * 宽度取得
	 * @return pidwidth 宽度
	 */
	public Integer getPidwidth();

	/**
	 * 父表单定义主键取得
	 * @return ppidid 父表单定义主键
	 */
	public String getPpidid();
	
	/**
	 * 行数取得
	 * @return pidrows 行数
	 */
	public Integer getPidrows();
	
	/**
	 * 是否隐藏列名取得
	 * @return pidhide 是否隐藏列名
	 */
	public String getPidhide();
		
	/**
	 * 是否显示行号取得
	 * @return showrownum 是否显示行号
	 */
	public String getShowrownum();
	
	/**
	 * 表单单位取得
	 */
	public String getPidunit() ;
	
	/**
	 *是否包含备注取得
	 */
	public String getRemarks();
	
	/**
	 *单选复选显示方式取得
	 */
	public String getShowstyles();
	
	
	/**
	 * 表格类表单是否显示边线取得
	 * @return showline 表格类表单是否显示边线
	 */
	public String getShowline();
	
	/**
	 * 表格名称显示方式取得
	 * @return titledisplay 表格名称显示方式
	 */
	public String getTitledisplay();
	
	/**
	 * 是否需要审批意见取得
	 * @return needidea 是否需要审批意见
	 */
	public String getNeedidea();
	
	/**
	 * js方法取得
	 * @return jsfunction js方法
	 */
	public String getJsfunction();
	
	/**
	 * 表格式表单组模式标题内容比例取得
	 * @return pidratio 表格式表单组模式标题内容比例
	 */
	public String getPidratio();
	
	/**
	 * 最大字符数取得
	 * @return pidsize 最大字符数
	 */
	public Integer getPidsize();
	
	/**
	 * 表单可写标识取得
	 * @return writeable 表单可写标识
	 */
	public String getWriteable();
	
	/**
	 * 树形表单只能选择末级标识取得
	 * @return selecedlast 树形表单只能选择末级标识
	 */
	public String getSelecedlast();
	
	/**
	 * 数字类型取得
	 * @return numbertype 数字类型
	 */
	public String getNumbertype();
	
	/**
	 * 对齐方式取得
	 * @return align 对齐方式
	 */
	public String getAlign();
	/**
	 * 是否为标识表单取得
	 * @return isFlag 是否为标识表单
	 */
	public String getIsFlag();
}