	/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;


/**
  * 概述: 关系树结点对象
  * 功能描述: 关系树结点对象
  * 创建记录: 杨龙全 2013/05/28
  * 修改记录: 
  */
public class RelationTreeTB {
	
	/**对象ID*/
	protected Integer eiid;
	
	/**对象名字*/
	protected String einame;
	
	/**对象顶级ID*/
	protected Integer eirootmark;
	
	/**模型名字*/
	protected String ename;
	
	/**模型名字*/
	protected String eid;
	
	/**对象版本*/
	protected Integer eiversion;
	
	/**对象小版本*/
	protected Integer eismallversion;
	
	/**对象父结点*/
	protected Integer fatherEiid;
	
	protected Integer grandpaEiid;
	
	/**关系码*/
	protected String rlnCode;
	
	protected Integer sourceEiid;
	
	/**是否是叶子结点 true为父结点，false为叶子*/
	protected String isLeaf;

	protected String esyscoding;

	private String eparcoding;

	/**
	 * 构造方法
	 */
	public RelationTreeTB() {
		super();
	}
	
	/**
	 * @param eiid
	 * @param einame
	 * @param eirootmark
	 * @param ename
	 * @param eid
	 * @param eiversion
	 * @param eismallversion
	 */
	public RelationTreeTB(Integer eiid, String einame, Integer eirootmark,
			String ename, String eid, Integer eiversion, Integer eismallversion,
			Integer fatherEiid,String isLeaf,Integer sourceEiid) {
		super();
		this.eiid = eiid;
		this.einame = einame;
		this.eirootmark = eirootmark;
		this.ename = ename;
		this.eid = eid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
		this.fatherEiid=fatherEiid;
		this.isLeaf=isLeaf;
		this.sourceEiid=sourceEiid;
	}

	/**
	 * @param eiid
	 * @param einame
	 * @param eirootmark
	 * @param ename
	 * @param eid
	 * @param eiversion
	 * @param eismallversion
	 */
	public RelationTreeTB(Integer eiid, String einame, Integer eirootmark,
			String ename, String eid, Integer eiversion, Integer eismallversion,
			Integer fatherEiid,String isLeaf,Integer sourceEiid, 
			String esyscoding, String eparcoding) {
		super();
		this.eiid = eiid;
		this.einame = einame;
		this.eirootmark = eirootmark;
		this.ename = ename;
		this.eid = eid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
		this.fatherEiid=fatherEiid;
		this.isLeaf=isLeaf;
		this.sourceEiid=sourceEiid;
		this.esyscoding = esyscoding;
		this.eparcoding = eparcoding;
	}

	/**
	 * 对象ID取得
	 *
	 * @return eiid 对象ID
	 */
	
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 对象ID设定
	 *
	 * @param eiid 对象ID
	 */
	
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 对象名字取得
	 *
	 * @return einame 对象名字
	 */
	
	public String getEiname() {
		return einame;
	}

	/**
	 * 对象名字设定
	 *
	 * @param einame 对象名字
	 */
	
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 对象顶级ID取得
	 *
	 * @return eirootmark 对象顶级ID
	 */
	
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * 对象顶级ID设定
	 *
	 * @param eirootmark 对象顶级ID
	 */
	
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 模型名字取得
	 *
	 * @return ename 模型名字
	 */
	
	public String getEname() {
		return ename;
	}

	/**
	 * 模型名字设定
	 *
	 * @param ename 模型名字
	 */
	
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 模型名字取得
	 *
	 * @return eid 模型名字
	 */
	
	public String getEid() {
		return eid;
	}

	/**
	 * 模型名字设定
	 *
	 * @param eid 模型名字
	 */
	
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 对象版本取得
	 *
	 * @return eiversion 对象版本
	 */
	
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 对象版本设定
	 *
	 * @param eiversion 对象版本
	 */
	
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 对象小版本取得
	 *
	 * @return eismallversion 对象小版本
	 */
	
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 对象小版本设定
	 *
	 * @param eismallversion 对象小版本
	 */
	
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * 对象父结点取得
	 *
	 * @return fatherEiid 对象父结点
	 */
	
	public Integer getFatherEiid() {
		return fatherEiid;
	}

	/**
	 * 对象父结点设定
	 *
	 * @param fatherEiid 对象父结点
	 */
	
	public void setFatherEiid(Integer fatherEiid) {
		this.fatherEiid = fatherEiid;
	}

	/**
	 * 关系码取得
	 *
	 * @return rlnCode 关系码
	 */
	
	public String getRlnCode() {
		return rlnCode;
	}

	/**
	 * 关系码设定
	 *
	 * @param rlnCode 关系码
	 */
	
	public void setRlnCode(String rlnCode) {
		this.rlnCode = rlnCode;
	}

	/**
	 * 是否是叶子结点取得
	 *
	 * @return isLeaf 是否是叶子结点
	 */
	
	public String getIsLeaf() {
		return isLeaf;
	}

	/**
	 * 是否是叶子结点设定
	 *
	 * @param isLeaf 是否是叶子结点
	 */
	
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getSourceEiid() {
		return sourceEiid;
	}

	public void setSourceEiid(Integer sourceEiid) {
		this.sourceEiid = sourceEiid;
	}

	public Integer getGrandpaEiid() {
		return grandpaEiid;
	}

	public void setGrandpaEiid(Integer grandpaEiid) {
		this.grandpaEiid = grandpaEiid;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}
	
}