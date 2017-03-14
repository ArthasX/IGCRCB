package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 资产信息实体
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0605")
@SuppressWarnings("serial")
//public class EntityItemVW extends BaseEntity implements Serializable, Cloneable, EntityItemVWInfo {
public class SOC0605VW implements Serializable, Cloneable, SOC0605Info {

	/** 资产ID */
	@Id
	protected Integer eiid;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 资产名称 */
	protected String einame;
	
	/** 资产编号 */
	protected String eilabel;
	
	/** 资产说明 */
	protected String eidesc;
	
	/** 资产变更时间 */
	protected String eiupdtime;
	
	/** 资产状态 */
	protected String eistatus;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 资产模型编号 */
	protected String elabel;

	/** 资产模型说明 */
	protected String edesc;

	/** 资产模型状态 */
	protected String estatus;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 资产模型三级子类 */
	protected String ekey3;
	
	/** 资产版本号 */
	protected Integer eiversion;
	
	/** 资产登记日 */
	protected String eiinsdate;
	
	/** 资产所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产模型*/
	protected String esyscoding;
	
	/** 资产已建立关系总数 */
	protected String eircount;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	/** 资产序号*/
	protected String serial;
	
	/** 资产购买日期*/
	protected String buytime;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;
	
	/** 资产模型类别（0：一般资产模型 1：配置资产模型） */
	protected String emodeltype;
	
	/** 资产所属机构信息实体 */
	@OneToOne
	@JoinColumn(name="eiorgsyscoding", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getBuytime() {
		return buytime;
	}

	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * 资产说明取得
	 * @return 资产说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产说明设定
	 *
	 * @param eidesc 资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产更新时间取得
	 * @return 资产更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 资产更新时间设定
	 *
	 * @param eiupdtime 资产更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus 资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
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
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}


	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * 资产模型说明设定
	 *
	 * @param edesc 资产模型说明
	 */
	public String getEdesc() {
		return edesc;
	}


	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * 资产模型状态设定
	 *
	 * @param estatus 资产模型状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}


	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}


	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}


	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}


	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}


	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}


	/**
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}


	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}


	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}


	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
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
	 * 资产登记日取得
	 * @return 资产登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产登记日设定
	 *
	 * @param eiinsdate 资产登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 资产已建立关系总数取得
	 * @return 资产已建立关系总数
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * 资产已建立关系总数设定
	 *
	 * @param eircount 资产已建立关系总数
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}
	
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产所属机构信息实体取得
	 * @return 资产所属机构信息实体
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * 资产所属机构信息实体设定
	 *
	 * @param organizationTB 资产所属机构信息实体
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
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
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
	
	/**
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	/**
	 * 资产模型类别设定
	 *
	 * @param eparcoding 资产模型类别
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}
	
}
