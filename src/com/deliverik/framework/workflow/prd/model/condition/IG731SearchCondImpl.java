package com.deliverik.framework.workflow.prd.model.condition;


public class IG731SearchCondImpl implements IG731SearchCond{

	/** 自增无意义主键 */
	protected Integer pieid;

	/** 流程ID(IG500表) */
	protected Integer prid;

	/** 流程表单主键 */
	protected Integer piid;
	
	/** 动态表单ID（IG007表）*/
	protected Integer pidid;

	/** 资产ID(EntityItem表) */
	protected Integer eiid;
	
	/** 是否为表格类表单关联资产 */
	protected String tableColumnValue;

	/** 时间戳 */
	protected String fingerprint;

	/**
	 *自增无意义主键取得
	 * @return 自增无意义主键
	 */
	public Integer getPieid(){
		return pieid;
	}
	
	/**
	 *自增无意义主键设定
	 * @param pieid自增无意义主键
	 */
	public void setPieid(Integer pieid){
		this.pieid=pieid;
	}
	
	/**
	 *流程ID(IG500表)取得
	 * @return 流程ID(IG500表)
	 */
	public Integer getPrid(){
		return prid;
	}

	/**
	 *流程ID(IG500表)设定
	 * @param prid流程ID(IG500表)
 	 */
	public void setPrid(Integer prid){
		this.prid=prid;
	}
	
	/**
	 * 流程表单主键取得
	 *
	 * @return piid 流程表单主键
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 流程表单主键设定
	 *
	 * @param piid 流程表单主键
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 *动态表单ID（IG007表）取得
	 * @return 动态表单ID（IG007表）
	 */
	public Integer getPidid(){
		return pidid;
	}
	
	/**
	 *动态表单ID（IG007表）设定
	 * @param pidid动态表单ID（IG007表）
	 */
	public void setPidid(Integer pidid){
		this.pidid=pidid;
	}
	
	/**
	 *资产ID(EntityItem表)取得
	 * @return 资产ID(EntityItem表)
	 */
	public Integer getEiid(){
		return eiid;
	}
	
	/**
	 *资产ID(EntityItem表)设定
	 * @param eiid资产ID(EntityItem表)
	 */
	public void setEiid(Integer eiid){
		this.eiid=eiid;
	}

	/**
	 * 是否为表格类表单关联资产取得
	 * @return tableColumnValue 是否为表格类表单关联资产
	 */
	public String getTableColumnValue() {
		return tableColumnValue;
	}

	/**
	 * 是否为表格类表单关联资产设定
	 * @param tableColumnValue 是否为表格类表单关联资产
	 */
	public void setTableColumnValue(String tableColumnValue) {
		this.tableColumnValue = tableColumnValue;
	}

}
