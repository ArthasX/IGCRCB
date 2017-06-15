package com.deliverik.framework.asset.model.condition;

/**
 * 资产关系信息检索条件实现
 * 
 */
public class IG313SearchCondImpl implements IG313SearchCond {

	/** 资产ID（正反向任意） */
	protected Integer eiid;
	
	/** 资产大版本（正反向任意） */
	protected String eiversion;
	
	/** 资产小版本（正反向任意） */
	protected String eismallversion;
	
	/** 资产ID（正向） */
	protected Integer pareiid;
	
	/** 资产大版本（正向） */
	protected Integer parversion;
	
	/** 资产小版本（正向） */
	protected Integer parsmallversion;
	
	/** 资产ID（反向） */
	protected Integer cldeiid;
	
	/** 资产大版本（反向） */
	protected Integer cldversion;
	
	/** 资产小版本（反向） */
	protected Integer cldsmallversion;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 资产关系ID（平台保留） */
	protected String eirrelation;
	
	/** 资产关系是否可以删除标识（平台保留） */
	protected String eirstatus;
	
	/** 资产关系说明（平台保留） */
	protected String eirdesc;
	
	/** 通过资产属性增加自动生成的关系信息（平台保留） */
	protected String eirinfo;
	
	/** 资产模型ID（反向） */
	protected Integer cldeid;
	
	/** 资产模型ID（正向） */
	protected Integer pareid;
	
	/** 关系码  */
	protected String eirrelationcode;
	
	/**
	 * 资产ID（正反向任意）取得
	 * @return 资产ID（正反向任意）
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID（正反向任意）设定
	 *
	 * @param eiid 资产ID（正反向任意）
	 */
	public void setEiid(int eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产ID（正向）取得
	 * @return 资产ID（正向）
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * 资产ID（正向）设定
	 *
	 * @param i 资产ID（正向）
	 */
	public void setPareiid(Integer i) {
		this.pareiid = i;
	}

	/**
	 * 资产ID（反向）取得
	 * @return 资产ID（反向）
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * 资产ID（反向）设定
	 *
	 * @param cldeiid 资产ID（反向）
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * 资产关系ID取得
	 * @return 资产关系ID
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * 资产关系ID设定
	 *
	 * @param eirrelation 资产关系ID
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}

	/**
	 * 资产关系是否可以删除标识取得
	 * @return 资产关系是否可以删除标识
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * 资产关系是否可以删除标识设定
	 *
	 * @param eirstatus 资产关系是否可以删除标识
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * 资产关系说明取得
	 * @return 资产关系说明
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * 资产关系说明设定
	 *
	 * @param eirdesc 资产关系说明
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}
	
	/**
	 * 通过资产属性增加自动生成的关系信息取得
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	public String getEirinfo() {
		return eirinfo;
	}

	/**
	 * 通过资产属性增加自动生成的关系信息设定
	 *
	 * @param eirinfo 通过资产属性增加自动生成的关系信息
	 */
	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}
	
	/**
	 * 正向资产大版本取得
	 * @return 正向资产大版本
	 */
	public Integer getParversion() {
		return parversion;
	}

	/**
	 * 正向资产大版本设定
	 *
	 * @param parversion 正向资产大版本
	 */
	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}
	
	/**
	 * 正向资产小版本取得
	 * @return 正向资产小版本
	 */
	public Integer getParsmallversion() {
		return parsmallversion;
	}

	/**
	 * 正向资产小版本设定
	 *
	 * @param parsmallversion 正向资产小版本
	 */
	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}
	
	/**
	 * 反向资产大版本取得
	 * @return 反向资产大版本
	 */
	public Integer getCldversion() {
		return cldversion;
	}

	/**
	 * 反向资产大版本设定
	 *
	 * @param cldversion 反向资产大版本
	 */
	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	/**
	 * 反向资产小版本取得
	 * @return 反向资产小版本
	 */
	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	/**
	 * 反向资产小版本设定
	 *
	 * @param cldsmallversion 反向资产小版本
	 */
	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标识（反向）设定
	 *
	 * @param deleteflag 逻辑删除标识（反向）
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 资产大版本（正反向任意）取得
	 * 
	 * @return 资产大版本（正反向任意）
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * 资产大版本（正反向任意）设定
	 * 
	 * @param eiversion 资产大版本（正反向任意）
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产小版本（正反向任意）
	 * 
	 * @return 资产小版本（正反向任意）
	 */
	public String getEismallversion() {
		return eismallversion;
	}

	/**
	 * 资产小版本（正反向任意）
	 * 
	 * @param eismallversion 资产小版本（正反向任意）
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * 资产模型ID（正向）取得
	 * @return 资产模型ID（正向）
	 */
	public Integer getPareid() {
		return pareid;
	}

	/**
	 * 资产模型ID（正向）设定
	 *
	 * @param pareid 资产模型ID（正向）
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}
	
	/**
	 * 资产模型ID（反向）取得
	 * @return 资产模型ID（反向）
	 */
	public Integer getCldeid() {
		return cldeid;
	}

	/**
	 * 资产模型ID（反向）设定
	 *
	 * @param cldeid 资产模型ID（反向）
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}

	/**
	 * 关系码取得
	 * @return 关系码
	 */
	public String getEirrelationcode() {
		return eirrelationcode;
	}

	/**
	 * 关系码设定
	 * @param eirrelationcode关系码
	 */
	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}
	
	
}
