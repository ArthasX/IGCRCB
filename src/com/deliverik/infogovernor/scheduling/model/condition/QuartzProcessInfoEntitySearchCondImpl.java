package com.deliverik.infogovernor.scheduling.model.condition;


public class QuartzProcessInfoEntitySearchCondImpl implements QuartzProcessInfoEntitySearchCond{

	/** 自增无意义主键 */
	protected Integer qpieid;

	/** 流程ID(QuartzProcessRecord表) */
	protected Integer qprid;

	/** 动态表单ID（QuartzProcessInfoDef表）*/
	protected Integer qpiid;

	/** 资产ID(EntityItem表) */
	protected Integer qeiid;

	

	/**
	 *自增无意义主键取得
	 * @return 自增无意义主键
	 */
	public Integer getQpieid(){
		return qpieid;
	}
	
	/**
	 *自增无意义主键设定
	 * @param pieid自增无意义主键
	 */
	public void setQpieid(Integer qpieid){
		this.qpieid=qpieid;
	}
	
	/**
	 *流程ID(QuartzProcessRecord表)取得
	 * @return 流程ID(QuartzProcessRecord表)
	 */
	public Integer getQprid(){
		return qprid;
	}

	/**
	 *流程ID(QuartzProcessRecord表)设定
	 * @param prid流程ID(QuartzProcessRecord表)
 	 */
	public void setQprid(Integer qprid){
		this.qprid=qprid;
	}
	
	/**
	 *动态表单ID（QuartzProcessInfoDef表）取得
	 * @return 动态表单ID（QuartzProcessInfoDef表）
	 */
	public Integer getQpiid(){
		return qpiid;
	}
	
	/**
	 *动态表单ID（QprocessInfoDef表）设定
	 * @param pidid动态表单ID（QprocessInfoDef表）
	 */
	public void setQpiid(Integer qpiid){
		this.qpiid=qpiid;
	}
	
	/**
	 *资产ID(EntityItem表)取得
	 * @return 资产ID(EntityItem表)
	 */
	public Integer getQeiid(){
		return qeiid;
	}
	
	/**
	 *资产ID(EntityItem表)设定
	 * @param eiid资产ID(EntityItem表)
	 */
	public void setQeiid(Integer qeiid){
		this.qeiid=qeiid;
	}

}
