package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 资产信息检索条件实现
 * 
 */
public class SOC0118SearchCondImpl implements SOC0118SearchCond {

	/** 资产模型ID */
	protected String eid;
	
	/** 资产编号 */
	protected String eilabel;
	
	/** 资产名称 */
	protected String einame;
	
	/** 资产版本号 */
	protected Integer eiversion;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;
	
	/** 资产ID（平台保留） */
	protected String eiid;
	
	protected List<String> eilabel_list;
	
	/** 资产名称（完全匹配 ）*/
	protected String einame_equal;
	
	/** 资产顶级实体ID */
	protected Integer eirootmark;
	
	/** 资产eiid */
	protected List<Integer> eiids;
	
	/** 资产模型ID */
	protected String[] eids;
	
	/** 存储过滤eq */
	protected String esyscoding_eq;
	/** 存储过滤like*/
	protected String esyscoding_like;
	
	/** 分类CD */
	protected String ccid ;
	
	/** 数据CD(父) */
	protected String pcid;
	
	/** 数据CD状态 */
	protected String cdstatus;
	
	protected String tableName;
	
	protected String numRows;
	
	protected String tableSpaceName;
	
	protected String instanceName;
	
	protected String businessName;
	protected String[] eid_arr;
	/**业务系统的管理人员*/
	protected String magName;
	
	/**einame集合*/
	protected List<String> einame_in;
	
	
	protected String eilabel_like;
	
	/**ip分配标识*/
	protected String eidesc_falg;
	
	protected String eiupdtime_from;
	
	protected String eiupdtime_to;
	/**是否属于集群*/
	protected boolean isClumped;
	/** 资产状态 */
	protected String eistatus;
	
	/** 资产登记时间 */
	protected String eiinsdate_like;
	/** 负责人 */
	protected String eiusername;
	
	/**
	 * 业务系统ID
	 * 根据业务系统查询相关联的主机时使用
	 * */
	protected Integer systemId;
	
	protected String environmentType;
	/**是否升级*/
	protected boolean upgrade;
	/**创建日期大于*/
	protected String eiinsdate_gt;
	/**创建日期小于*/
	protected String eiinsdate_lt;
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/** 状态不等于 */
	protected String eistatus_ne;
	
	/** 场景分类查询条件 */
	protected String scenceCategory;

	/** 场景分类查询条件 演练场景:1,应急场景0 */
	public String getScenceCategory() {
		return scenceCategory;
	}

	/** 场景分类查询条件 演练场景:1,应急场景0 */
	public void setScenceCategory(String scenceCategory) {
		this.scenceCategory = scenceCategory;
	}

	public String getEistatus_ne() {
		return eistatus_ne;
	}

	public void setEistatus_ne(String eistatus_ne) {
		this.eistatus_ne = eistatus_ne;
	}

	public String getEiinsdate_gt() {
		return eiinsdate_gt;
	}

	public void setEiinsdate_gt(String eiinsdate_gt) {
		this.eiinsdate_gt = eiinsdate_gt;
	}

	public String getEiinsdate_lt() {
		return eiinsdate_lt;
	}

	public void setEiinsdate_lt(String eiinsdate_lt) {
		this.eiinsdate_lt = eiinsdate_lt;
	}

	public boolean isUpgrade() {
		return upgrade;
	}

	public void setUpgrade(boolean upgrade) {
		this.upgrade = upgrade;
	}

	public String getEidesc_falg() {
		return eidesc_falg;
	}

	public void setEidesc_falg(String eidesc_falg) {
		this.eidesc_falg = eidesc_falg;
	}

	public String getEilabel_like() {
		return eilabel_like;
	}

	public void setEilabel_like(String eilabel_like) {
		this.eilabel_like = eilabel_like;
	}

	public List<String> getEiname_in() {
		return einame_in;
	}

	public void setEiname_in(List<String> einame_in) {
		this.einame_in = einame_in;
	}

	public String getMagName() {
		return magName;
	}

	public void setMagName(String magName) {
		this.magName = magName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNumRows() {
		return numRows;
	}

	public void setNumRows(String numRows) {
		this.numRows = numRows;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * 资产模型ID取得
	 *
	 * @return eids 资产模型ID
	 */
	
	public String[] getEids() {
		return eids;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eids 资产模型ID
	 */
	
	public void setEids(String[] eids) {
		this.eids = eids;
	}

	/**
	 * 资产eiid取得
	 *
	 * @return eiids 资产eiid
	 */
	
	public List<Integer> getEiids() {
		return eiids;
	}

	/**
	 * 资产eiid设定
	 *
	 * @param eiids 资产eiid
	 */
	
	public void setEiids(List<Integer> eiids) {
		this.eiids = eiids;
	}

	/**
	 * 资产名称（完全匹配 ）取得
	 * @return 资产名称（完全匹配 ）
	 */
	public String getEiname_equal() {
		return einame_equal;
	}

	/**
	 * 资产名称（完全匹配 ）设定
	 *
	 * @param einame_equal 资产名称（完全匹配 ）
	 */
	public void setEiname_equal(String einame_equal) {
		this.einame_equal = einame_equal;
	}

	public List<String> getEilabel_list() {
		return eilabel_list;
	}

	public void setEilabel_list(List<String> eilabel_list) {
		this.eilabel_list = eilabel_list;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding 资产所属机构层次码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname() {
		return einame;
	}


	/**
	 * 资产名称设定
	 *
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 *
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * 资产顶级实体ID取得
	 * @return 资产顶级ID
	 */
	public Integer getEirootmark()
	{
		return eirootmark;
	}
	/**
	 * 资产顶级实体ID设定
	 *
	 * @param eirootmark 资产顶级实体ID
	 */
	public void setEirootmark(Integer eirootmark)
	{
		this.eirootmark = eirootmark;
	}

	/**
	 * 存储过滤eq取得
	 *
	 * @return esyscoding_eq 存储过滤eq
	 */
	public String getEsyscoding_eq() {
		return esyscoding_eq;
	}

	/**
	 * 存储过滤eq设定
	 *
	 * @param esyscoding_eq 存储过滤eq
	 */
	public void setEsyscoding_eq(String esyscoding_eq) {
		this.esyscoding_eq = esyscoding_eq;
	}

	/**
	 * 存储过滤like取得
	 *
	 * @return esyscoding_like 存储过滤like
	 */
	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	/**
	 * 存储过滤like设定
	 *
	 * @param esyscoding_like 存储过滤like
	 */
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}

	public String getCcid() {
		return ccid;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getCdstatus() {
		return cdstatus;
	}

	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}
	public String[] getEid_arr() {
		return eid_arr;
	}
	public void setEid_arr(String[] eid_arr) {
		this.eid_arr = eid_arr;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public Integer getSystemId() {
		return systemId;
	}
	/**
	 * 根据业务系统查询与其相关联的主键信息时使用
	 * @param systemId
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/**
	 * 
	 */
	public String getEnvironmentType() {
		return environmentType;
	}

	/**
	 * 设置环境类型 (生成,同城,异地 对应 soc0151中010 的值)
	 * @param environmentType
	 */
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}

	public boolean isClumped() {
		return isClumped;
	}
	/**
	 * 是否属于集群
	 * @param isClumped
	 */
	public void setClumped(boolean isClumped) {
		this.isClumped = isClumped;
	}
	
	protected String eitype;
	
	
	public String getEitype() {
		return eitype;
	}

	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	/**
	 * @return the 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * @param 资产状态 the eistatus to set
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * @return the eiinsdate_like
	 */
	public String getEiinsdate_like() {
		return eiinsdate_like;
	}

	/**
	 * @param eiinsdate_like the eiinsdate_like to set
	 */
	public void setEiinsdate_like(String eiinsdate_like) {
		this.eiinsdate_like = eiinsdate_like;
	}

	/**
	 * @return the 负责人
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * @param 负责人 the eiusername to set
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**  
	 * 获取开始时间  
	 * @return propentime 开始时间  
	 */
	
	public String getPropentime() {
		return propentime;
	}

	/**  
	 * 设置开始时间  
	 * @param propentime 开始时间  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**  
	 * 获取结束时间  
	 * @return prclosetime 结束时间  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}

	/**  
	 * 设置结束时间  
	 * @param prclosetime 结束时间  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	
}
