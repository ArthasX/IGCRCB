/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 物品领用Form
 * 
 */
public class IGLOM0205Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 物品信息ID */
	protected Integer gid;
	
	/** 物品种类 */
	protected String gcategory;
	
	/** 物品名称 */
	protected String gname;
	
	/** 物品编号 */
	protected String gcode;
	
	/** 预警提示数量 */
	protected Integer gwarningnum;
	
	/** 物品内部转移定价（%） */
	protected Double gprice;
	
	/** 状态（0:停用 1:启用） */
	protected String gstatus;

	
	/** 物品出库信息ID */
	protected Integer goid;
	
	/** 出库类型(0:入库 1:领用 2:调剂 3:核销) */
	protected String gotype;
	
	/** 所属机构层次码 */
	protected String goorg;
	
	/** 所属机构名称*/
	protected String goorgname;
	
	/** 物品种类 */
	protected String gocategory;
	
	/** 物品名称 */
	protected Integer goname;
	
	/** 物品编号 */
	protected Double gocode;
	
	/** 出库时间 */
	protected String gotime;

	/** 采购申请单批号 */
	protected String goreqnum;

	/** 出库单价 */
	protected Double gooutprice;
	
	/** 出库数量 */
	protected Integer goinnum;
	
	/** 计量单位 */
	protected String gounit;
	
	/** 供应商*/
	protected String goprovider;
	
	/** 购买人*/
	protected String gopurchaser;

	/** 调剂价格*/
	protected Double goreliefprice;
	
	/** 调剂数量*/
	protected Integer goreliefnum;
	
	/** 出库状态(入库时：0:库存无 1:库存有;出库时：0:出库完成 1:待审批 2:审批未通过)*/
	protected String gostatus;
	
	/** 领用机构/调剂机构层次码*/
	protected String goreqorg;
	
	/** 领用人/调剂人ID*/
	protected String gorequser;
	
	/** 领用人/调剂人姓名*/
	protected String gorequsername;
	
	/** 登记人*/
	protected String gouser;
	
	/** 登记人姓名*/
	protected String gousername;
	
	/** 审批数量*/
	protected Integer gochknum;
	
	/** 审批人ID*/
	protected String gochkid;
	
	/** 审批人姓名*/
	protected String gochkkname;
	
	/** 接待工作ID*/
	protected Integer rid;
	
}
