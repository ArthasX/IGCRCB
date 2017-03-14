/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.infogovernor.kgm.model.Knowledge;

/**
 * 概述: 知识库实体实体
 * 功能描述：知识库实体
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
@IdClass(KnowledgeTBPK.class)
@Entity
public class KnowledgeVW extends BaseEntity implements Serializable, Cloneable,Knowledge{
	@Id
	/**主键 */
	protected Integer knid;
	
	@Id
	/**知识版本 */
	protected Integer knversion;
	
	/**编号 */
	protected String knserial;
	
	/**部门 */
	protected String kndepartment;

	/**归档人id */
	protected String knapprover;
	
	/**归档人姓名 */
	protected String knapprovername;
	
	/**归档时间 */
	protected String knapprovetime;
	
	/**分类*/
	protected String knclass;
	
	/**分类名称*/
	protected String knclassname;
	
	/**关键字*/
	protected String knkey;
	
	/**来源*/
	protected String knorigin;
	
	/**来源名称*/
	protected String knoriginname;
	
	/**知识贡献人id*/
	protected String knproffer;
	
	/**知识贡献人姓名*/
	protected String knproffername;
	
	/**贡献时间*/
	protected String knproffertime;
	
	/**标题*/
	protected String kntitle;
	
	/**问题描述*/
	protected String kndes;
	
	/**故障原因总结*/
	protected String knfaultcause;
	
	/**解决办法*/
	protected String knsolveway;
	
	/**状态*/
	protected String knstatus;
	
	/**驳回原因*/
	protected String knreject;
	
	/**附件KEY*/
	protected String knattkey;
	
	/**业务领域*/
	protected String knarea;
	
	/**业务领域名*/
	protected String knareaname;
	
	/**技术领域*/
	protected String kntelarea;
	
	/**技术领域名*/
	protected String kntelareaname;
	
	/**知识审批人角色*/
	protected Integer knapproverole;

	
	/**
	 * 流程状态前处理变量
	 */
	@Transient
	protected List<Attachment> attachmentList;
	
	/**UserTB 实体*/
	@OneToOne
	@JoinColumn(name="knapprover", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	/**UserTB 实体*/
	@OneToOne
	@JoinColumn(name="knproffer", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	/**
	 *来源名称取得
	 * 
	 * @return 来源名称
	 */
	public String getKnoriginname() {
		return knoriginname;
	}
	/**
	 * 来源名称设定
	 * @param knoriginname 来源名称
	 */
	public void setKnoriginname(String knoriginname) {
		this.knoriginname = knoriginname;
	}
	/**
	 *知识版本取得
	 * 
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}
	/**
	 * 知识版本
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 *附件KEY取得
	 * 
	 * @return 附件KEY
	 */
	public String getKnattkey() {
		return knattkey;
	}
	
	/**
	 * 附件KEY
	 * @param knattkey 附件KEY
	 */
	public void setKnattkey(String knattkey) {
		this.knattkey = knattkey;
	}
	/**
	 *驳回原因取得
	 * 
	 * @return 驳回原因
	 */
	public String getKnreject() {
		return knreject;
	}
	/**
	 * 驳回原因设定
	 * @param knreject 驳回原因
	 */
	public void setKnreject(String knreject) {
		this.knreject = knreject;
	}

	/**
	 *归档人姓名取得
	 * 
	 * @return 归档人姓名
	 */
	public String getKnapprovername() {
		return knapprovername;
	}

	/**
	 * 归档人姓名设定
	 * @param knapprovername 归档人姓名
	 */
	public void setKnapprovername(String knapprovername) {
		this.knapprovername = knapprovername;
	}
	/**
	 *知识贡献人姓名取得
	 * 
	 * @return 知识贡献人姓名
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 * 知识贡献人姓名设定
	 * @param knproffername 知识贡献人姓名
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	
	
	/**
	 * User实体取得
	 * @return User实体
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * UserTB实体设定
	 * @param userTB User实体
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}

	/**
	 * User实体取得
	 * @return User实体
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * User实体设定
	 * @param user User实体
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *主键设定
	 * 
	 * @param knid主键
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *编号取得
	 * 
	 * @return 编号
	 */
	public String getKnserial() {
		return knserial;
	}

	/**
	 *编号设定
	 * 
	 * @param knserial编号
	 */
	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}

	/**
	 *部门取得
	 * 
	 * @return 部门
	 */
	public String getKndepartment() {
		return kndepartment;
	}

	/**
	 *部门设定
	 * 
	 * @param kndepartment部门
	 */
	public void setKndepartment(String kndepartment) {
		this.kndepartment = kndepartment;
	}	

	/**
	 *归档人取得
	 * 
	 * @return 归档人
	 */
	public String getKnapprover() {
		return knapprover;
	}

	/**
	 *归档人设定
	 * 
	 * @param knapprover归档人
	 */
	public void setKnapprover(String knapprover) {
		this.knapprover = knapprover;
	}

	/**
	 *归档时间取得
	 * 
	 * @return 归档时间
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *归档时间设定
	 * 
	 * @param knapprovetime归档时间
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *分类取得
	 * 
	 * @return 分类
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *分类设定
	 * 
	 * @param knclass分类
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *关键字取得
	 * 
	 * @return 关键字
	 */
	public String getKnkey() {
		return knkey;
	}

	/**
	 *关键字设定
	 * 
	 * @param knkey关键字
	 */
	public void setKnkey(String knkey) {
		this.knkey = knkey;
	}

	/**
	 *来源取得
	 * 
	 * @return 来源
	 */
	public String getKnorigin() {
		return knorigin;
	}

	/**
	 *来源设定
	 * 
	 * @param knorigin来源
	 */
	public void setKnorigin(String knorigin) {
		this.knorigin = knorigin;
	}

	/**
	 *知识贡献人取得
	 * 
	 * @return 知识贡献人
	 */
	public String getKnproffer() {
		return knproffer;
	}

	/**
	 *知识贡献人设定
	 * 
	 * @param knproffer知识贡献人
	 */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

	/**
	 *贡献时间取得
	 * 
	 * @return 贡献时间
	 */
	public String getKnproffertime() {
		return knproffertime;
	}

	/**
	 *贡献时间设定
	 * 
	 * @param knproffertime贡献时间
	 */
	public void setKnproffertime(String knproffertime) {
		this.knproffertime = knproffertime;
	}

	/**
	 *标题取得
	 * 
	 * @return 标题
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *标题设定
	 * 
	 * @param kntitle标题
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *问题描述取得
	 * 
	 * @return 问题描述
	 */
	public String getKndes() {
		return kndes;
	}

	/**
	 *问题描述设定
	 * 
	 * @param kndes问题描述
	 */
	public void setKndes(String kndes) {
		this.kndes = kndes;
	}

	/**
	 *故障原因总结取得
	 * 
	 * @return 故障原因总结
	 */
	public String getKnfaultcause() {
		return knfaultcause;
	}

	/**
	 *故障原因总结设定
	 * 
	 * @param knfaultcause故障原因总结
	 */
	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
	}

	/**
	 *解决办法取得
	 * 
	 * @return 解决办法
	 */
	public String getKnsolveway() {
		return knsolveway;
	}

	/**
	 *解决办法设定
	 * 
	 * @param knsolveway解决办法
	 */
	public void setKnsolveway(String knsolveway) {
		this.knsolveway = knsolveway;
	}

	/**
	 *状态取得
	 * 
	 * @return 状态
	 */
	public String getKnstatus() {
		return knstatus;
	}

	/**
	 *状态设定
	 * 
	 * @param knstatus状态
	 */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}
	
	/**
	 *类别名称取得
	 * 
	 * @return 类别名称
	 */
	public String getKnclassname() {
		return knclassname;
	}
	
	/**
	 *类别名称设定
	 * 
	 * @param knclassname 类别名称
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}

	public Serializable getPK() {
		return new KnowledgeTBPK(knid,knversion);
	}
	/**
	 *业务领域取得
	 * 
	 * @return 业务领域
	 */
	public String getKnarea() {
		return knarea;
	}
	/**
	 *业务领域
	 * @param knarea 业务领域
	 */
	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}
	/**
	 *业务领域名取得
	 * 
	 * @return 业务领域名
	 */
	public String getKnareaname() {
		return knareaname;
	}
	/**
	 * 业务领域名
	 * @param knareaname 业务领域名
	 */
	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}
	/**
	 *技术领域取得
	 * 
	 * @return 技术领域
	 */
	public String getKntelarea() {
		return kntelarea;
	}
	/**
	 * 技术领域
	 * @param kntelarea 技术领域
	 */
	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}
	/**
	 *技术领域取得
	 * 
	 * @return 技术领域
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}
	/**
	 * 技术领域
	 * @param kntelareaname 技术领域Y
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * 知识附件List设定
	 * @param attachmentList 知识附件List
	 */
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public Integer getKnapproverole() {
		return knapproverole;
	}
	public void setKnapproverole(Integer knapproverole) {
		this.knapproverole = knapproverole;
	}

	
}
