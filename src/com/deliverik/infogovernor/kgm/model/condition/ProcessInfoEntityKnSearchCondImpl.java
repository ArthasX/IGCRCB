/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.condition;


public class ProcessInfoEntityKnSearchCondImpl implements ProcessInfoEntityKnSearchCond{

	/** 自增无意义主键 */
	protected Integer piekid;

	/** 流程ID(ProcessRecordKn表) */
	protected Integer prkid;

	/** 动态表单ID（IG007表）*/
	protected Integer pidid;

	/** 资产ID(EntityItem表) */
	protected Integer eiid;

	/** 时间戳 */
	protected String fingerprint;
	

	/**
	 *自增无意义主键取得
	 * @return 自增无意义主键
	 */
	public Integer getPiekid(){
		return piekid;
	}
	
	/**
	 *自增无意义主键设定
	 * @param pieid自增无意义主键
	 */
	public void setPiekid(Integer piekid){
		this.piekid=piekid;
	}
	
	/**
	 *流程ID(ProcessRecordKn表)取得
	 * @return 流程ID(ProcessRecordKn表)
	 */
	public Integer getPrkid(){
		return prkid;
	}

	/**
	 *流程ID(ProcessRecordKn表)设定
	 * @param prid流程ID(ProcessRecordKn表)
 	 */
	public void setPrkid(Integer prkid){
		this.prkid=prkid;
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

}
