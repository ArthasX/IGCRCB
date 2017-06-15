/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单信息生成对应标签接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface FormGeneratedTag extends Serializable{
	
	/** 表单类型 */
	public static final String PARAMS_FORM_TYPE = "formType";
	
	/** 表单定义主键 */
	public static final String PARAMS_PIDID = "pidid";
	
	/** 表单主键 */
	public static final String PARAMS_PIID = "piid";
	
	/** 流程主键 */
	public static final String PARAMS_PRID = "prid";
	
	/** 状态名称 */
	public static final String PARAMS_PSDNAME = "psdname";
	
	/** 表单模式 */
	public static final String PARAMS_PIDMODE = "pidmode";
	
	/** 访问权限 */
	public static final String PARAMS_PIDACCESS = "pidaccess";
	
	/** 标签名称 */
	public static final String PARAMS_PROPERTY = "property";
	
	/** 大小 */
	public static final String PARAMS_SIZE = "size";
	
	/** 文本域长度 */
	public static final String PARAMS_TEXTAREA_SIZE = "textAreaSize";
	
	/** 表单值 */
	public static final String PARAMS_VALUE = "value";
	
	/** 私有表单的权限范围 */
	public static final String PARAMS_PRIVATESCOPE = "privatescope";
	
	/** 用户ID */
	public static final String PARAMS_USERID = "userid";
	
	/** 角色ID */
	public static final String PARAMS_ROLEID = "roleid";
	
	/** 机构码 */
	public static final String PARAMS_ORGID = "orgid";
	
	/** 表单默认值 */
	public static final String PARAMS_PIDDEFAULT = "piddefault";
	
	/** 表单备选值 */
	public static final String PARAMS_OPTIONS = "options";
	
	/** 流程ID */
	public static final String PARAMS_PDID = "pdid";
	
	/** 基础数据定义ID */
	public static final String PARAMS_CCID = "ccid";
	
	/** 表单名称 */
	public static final String PARAMS_PIDLABEL = "pidlabel";
	
	/** 文本域附件 */
	public static final String PARAMS_TEXTAREA_ATT_MAP = "textAreaMap";
	
	/** 相关表单信息 */
	public static final String PARAMS_PROCESSINFO_LIST = "processInfolist";
	
	/** 相关资产信息 */
	public static final String PARAMS_PROCESSINFO_ENTITY_LIST  = "processInfoEntityList";
	
	/** 是否必填 */
	public static final String PARAMS_PIDREQUIRED = "pidrequired";
	
	/** 机构范围下拉列表 */
	public static final String PARAMS_PROCESS_ORG_SELECTED_OPTIONS ="processOrgSelectedOptions";
	
	/** 是否包含附件 */
	public static final String PARAMS_HASATTACH = "hasattach";
	
	/** 表格类表单模式 */
	public static final String PARAMS_PIDDISPLAY = "piddisplay";
	
	/** 表格类表单列信息 */
	public static final String PARAMS_TABLE_COLUMN_INFO = "columnInfoMap";
	
	/** 表格类表单列宽 */
	public static final String PARAMS_PIDWIDTH = "pidwidth";
	
	/** 表格类表单行号 */
	public static final String PARAMS_ROWNUMBER = "rownumber";
	
	/** 表格类表单列值 */
	public static final String PARAMS_TABLE_FORM_COLUMN_VALUE = "tableColumnValueMap";
	
	/** 表格类表单的使用模式 */
	public static final String PARAMS_PIDUSE = "piduse";
	
	/** 表格类表单固定行行数 */
	public static final String PARAMS_PIDROWS = "pidrows";
	
	/** 表格类表单是否显示行号 */
	public static final String PARAMS_SHOWROWNUM = "showrownum";
	
	/** 表格类表单关联资产信息 */
	public static final String PARAMS_TABLE_FORM_ENTITY_INFO = "tableColumnValueEntity";
	
	/** 表格类表单列附件信息 */
	public static final String PARAMS_TABLE_COLUMN_ATTACH_INFO = "tableColumnAttachMap";
	
	/** 流程类表单值Map */
	public static final String PARAMS_PROCESSINFO_FORM_VALUE_MAP = "processInfoFormValue";
	
	/** 人员类表单值Map */
	public static final String PARAMS_PARTICIPANT_FORM_VALUE_MAP = "participantFormValue";
	
	/** 表单单位 */
	public static final String PARAMS_PIDUNIT = "pidunit";
	
	/** 是否包含备注 */
	public static final String PARAMS_REMARKS = "remarks";
	
	/** 备注常量1表示有备注 */
	public static final String REMARK_TAG = "1";
	
	/** 备注 */
	public static final String PARAMS_PIDCOMMENT ="pidcomment";
	
	/** 单复选显示方式 */
	public static final String PARAMS_SHOWSTYLES ="showstyles";
	
	/** 显示方式常量1表示单行 */
	public static final String SHOWSTYLES_TAG = "1";
	
	/** 表格类表单是否显示边线 */
	public static final String PARAMS_SHOWLINE = "showline";
	
	/** 表格类表单标题显示模式 */
	public static final String PARAMS_TITLE_DISPLAY = "titledisplay";
	
	/** 是否隐藏标题 */
	public static final String PARAMS_PIDHIDE = "pidhide";
	
	/** 表单说明 */
	public static final String PARAMS_PIDDESC ="piddesc";
	
	/** 表单js关联事件 */
	public static final String PARAMS_JSFUNCTION = "jsfunction";
	
	/** 表格式表单组模式标题与内容宽度比例 */
	public static final String PARAMS_PIDRATIO = "pidratio";
	
	/** 表格列限制长度 */
	public static final String PARAMS_PIDSIZE = "pidsize";
	
	/** 表单可写标识 */
	public static final String PARAMS_WRITEABLE = "writeable";
	
	/** 树形表单只选末级标识 */
	public static final String PARAMS_SELECED_LAST = "selecedlast";
	
	/** 数字控件的数字类型 */
	public static final String PARAMS_NUMBER_TYPE = "numbertype";
	
	/** 对齐方式 */
	public static final String PARAMS_ALIGN = "align";
	
	/** 流程处于关闭状态下状态级私有表单值map所有可写，只读  */
	public static final String PARAMS_STATUS_CLOSE = "StatusCloseDetails";
	
	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params);
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params);
	
	/**
	 * 公有不可见标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicHideTag(Map<String, Object> params);
	
	/**
	 * 私有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPrivateWriteableTag(Map<String, Object> params);
	
	/**
	 * 私有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPrivateReadableTag(Map<String, Object> params);
	
	/**
	 * 私有不可见标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPrivateHideTag(Map<String, Object> params);
	
	/**
	 * 私有全部可见标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params);
	
	/**
	 * 表格类表单可写列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params);
	
	/**
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params);
	
	/**
	 * 可写附件显示操作
	 * @param id 显示位置dom对象id
	 * @return
	 */
	public String writeableAttachmentInfoShow(Map<String, Object> params);
	
	/**
	 * 只读附件显示操作
	 * @param id 显示位置dom对象id
	 * @return
	 */
	public String readableAttachmentInfoShow(Map<String, Object> params);
	
	 /**
     * 状态可写标签生成
     * @param params 参数
     * @return 状态标签字符串
     */
    public String generatedStatusWriteableTag(Map<String, Object> params);
    
    /**
     * 状态只读标签生成
     * @param params 参数
     * @return 状态标签字符串
     */
    public String generatedStatusReadableTag(Map<String, Object> params);
    
    /**
     * 状态不可见标签生成
     * @param params 参数
     * @return 状态标签字符串
     */
    public String generatedStatusHideTag(Map<String, Object> params);
    
    /**
     *流程关闭状态状态级表单显示
     * @param params 参数
     * @return 流程关闭状态状态级表单显示
     */
    public String generatedStatusCloseTag(Map<String, Object> params);
	
}
