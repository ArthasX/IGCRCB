/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;


/**
 * 概述: 知识审核检索条件接口
 * 功能描述：知识审核检索条件接口
 * 创建记录：宋海洋 2010/12/07
 * 修改记录：
 */
public class IGKGM0208Form extends BaseForm implements KnowledgeSearchCond{

	private static final long serialVersionUID = 1L;
	
	/**
	 *部门
	 */
	protected String kndepartment;
	
	/**
	 *页面表示
	 */
	protected String showFlag;

	/**
	 *来源
	 */
	protected String knorigin;

	/**
	 *问题描述
	 */
	protected String kndes;

	/**
	 *故障原因总结
	 */
	protected String knfaultcause;

	/**
	 *解决办法
	 */
	protected String knsolveway;
	

	/**
	 *分类
	 */
	protected String knclass;

	/**
	 *关键字
	 */
	protected String knkey;
	
	/**
	 *状态
	 */
	protected String knstatus;
	
	/**
	 *标题
	 */
	protected String kntitle;
	
	/**
	 *关键字数组
	 */
	protected String[] knkeys;
	
	/**
	 *标题数组
	 */
	protected String[] kntitles;
	
	/**
	 *分类名称
	 */
	protected String knclassname;
	
	/**
	 *知识id数组
	 */
	protected String[] knids;
	
	/**知识贡献人姓名*/
	protected String knproffername;

	/**归档人姓名 */
	protected String knapprovername;
	
	/**
	 *归档时间从
	 */
	protected String knapprovetime_f;
	
	/**
	 *归档时间到
	 */
	protected String knapprovetime_t;

	/**
	 *贡献时间从
	 */
	protected String knproffertime_f;

	/**
	 *贡献时间到
	 */
	protected String knproffertime_t;
	
	/**
	 *驳回原因数组
	 */
	protected String[] knrejects;
	
	/**
	 *驳回原因
	 */
	protected String knreject;
	/**
	 *版本数组
	 */
	protected String[] knversions;
	
	/**业务领域*/
	protected String knarea;
	
	/**技术领域*/
	protected String kntelarea;
	
	/**来源名称*/
	protected String knoriginname;
	
	
	/**业务领域名*/
	protected String knareaname;
	
	
	/**技术领域名*/
	protected String kntelareaname;
	
	/**知识审批人角色*/
	protected Integer knapproverole;
	/**知识编号*/
	protected String knserial_like;
	/**排序字段**/
	protected String order;
	
	protected String selectstatus;
	
	/**排序方式**/
	protected String sing;
	/**
	 *知识编号取得
	 * 
	 * @return 知识编号
	 */
	public String getKnserial_like() {
		return knserial_like;
	}
	
	/**
	 * 知识编号
	 * @param knserialnum_like 知识编号
	 */
	public void setKnserial_like(String knserial_like) {
		this.knserial_like = knserial_like;
	}
protected Integer[] knapproveroles;
	
	public Integer[] getKnapproveroles() {
		return knapproveroles;
	}
	public void setKnapproveroles(Integer[] knapproveroles) {
		this.knapproveroles = knapproveroles;
	}
	
	/**
	 *知识审批人角色
	 * 
	 * @return 知识审批人角色
	 */
	public Integer getKnapproverole() {
		return knapproverole;
	}
	/**
	 *知识审批人角色
	 * @param knapproverole 知识审批人角色
	 */
	public void setKnapproverole(Integer knapproverole) {
		this.knapproverole = knapproverole;
	}
	
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
	public String getKntelareaname() {
		return kntelareaname;
	}
	/**
	 * 技术领域
	 * @param kntelareaname 技术领域
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
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
	 *版本数组取得
	 * 
	 * @return 版本数组
	 */
	public String[] getKnversions() {
		return knversions;
	}
	/**
	 * 版本数组设定
	 * @param knversions 版本数组
	 */
	public void setKnversions(String[] knversions) {
		this.knversions = knversions;
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
	 *驳回原因数组取得
	 * 
	 * @return 驳回原因数组
	 */
	public String[] getKnrejects() {
		return knrejects;
	}
	/**
	 * 驳回原因数组设定
	 * @param knrejects 驳回原因数组
	 */
	public void setKnrejects(String[] knrejects) {
		this.knrejects = knrejects;
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
	 *知识id数组取得
	 * 
	 * @return 知识id数组
	 */
	public String[] getKnids() {
		return knids;
	}
	
	/**
	 *知识id数组设定
	 * 
	 * @param knids 知识id数组
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}

	/**
	 *分类名称取得
	 * 
	 * @return 分类名称
	 */
	public String getKnclassname() {
		return knclassname;
	}

	/**
	 *分类名称设定
	 * 
	 * @param knclassname 分类名称
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}
	
	/**
	 *标题数组取得
	 * 
	 * @return 标题数组
	 */
	public String[] getKntitles() {
		return kntitles;
	}
	
	/**
	 *标题数组设定
	 * 
	 * @param kntitles 标题数组
	 */
	public void setKntitles(String[] kntitles) {
		this.kntitles = kntitles;
	}

	/**
	 *关键字数组取得
	 * 
	 * @return 关键字数组
	 */
	public String[] getKnkeys() {
		return knkeys;
	}
	
	/**
	 *关键字数组设定
	 * 
	 * @param knkeys 关键字数组
	 */
	public void setKnkeys(String[] knkeys) {
		this.knkeys = knkeys;
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
	 *部门设定
	 * 
	 * @param kndepartment部门
	 */
	public void setKndepartment(String kndepartment) {
		this.kndepartment = kndepartment;
	}
	
	/**
	 *问题描述设定
	 * 
	 * @param kndes问题描述
	 */
	public void setKndes(String kndes) {
		this.kndes = kndes;
	}
	
	public IGKGM0208Form() {
		// TODO Auto-generated constructor stub
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
	 *故障原因总结设定
	 * 
	 * @param knfaultcause故障原因总结
	 */
	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
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

	public String getKnapprover() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnapprovetime() {
		// TODO Auto-generated method stub
		return null;
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
	 *问题描述取得
	 * 
	 * @return 问题描述
	 */
	public String getKndes() {
		return kndes;
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
	 *来源取得
	 * 
	 * @return 来源
	 */
	public String getKnorigin() {
		return knorigin;
	}

	public String getKnproffer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnproffertime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnserial() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *解决办法取得
	 * 
	 * @return 解决办法
	 */
	public String getKnsolveway() {
		return knsolveway;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.knkeys = null;

	}
	
	/**
	 *归档时间从取得
	 * 
	 * @return 归档时间从
	 */
	public String getKnapprovetime_f() {
		return knapprovetime_f;
	}
	/**
	 *归档时间从设定
	 * 
	 * @param knapprovetime_t 归档时间从
	 */
	public void setKnapprovetime_f(String knapprovetime_f) {
		this.knapprovetime_f = knapprovetime_f;
	}
	/**
	 *归档时间到取得
	 * 
	 * @return 归档时间到
	 */
	public String getKnapprovetime_t() {
		return knapprovetime_t;
	}
	/**
	 *归档时间到设定
	 * 
	 * @param knapprovetime_t 归档时间到
	 */
	public void setKnapprovetime_t(String knapprovetime_t) {
		this.knapprovetime_t = knapprovetime_t;
	}
	/**
	 *贡献时间从取得
	 * 
	 * @return 贡献时间从
	 */
	public String getKnproffertime_f() {
		return knproffertime_f;
	}
	/**
	 *贡献时间从设定
	 * 
	 * @param knproffertime_t 贡献时间从
	 */
	public void setKnproffertime_f(String knproffertime_f) {
		this.knproffertime_f = knproffertime_f;
	}
	/**
	 *贡献时间到取得
	 * 
	 * @return 贡献时间到
	 */
	public String getKnproffertime_t() {
		return knproffertime_t;
	}
	/**
	 *贡献时间到设定
	 * 
	 * @param knproffertime_t 贡献时间到
	 */
	public void setKnproffertime_t(String knproffertime_t) {
		this.knproffertime_t = knproffertime_t;
	}
	public Integer getKnid() {
		// TODO Auto-generated method stub
		return null;
	}
	/**业务系统名称*/
	protected String systemid;

	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the selectstatus
	 */
	public String getSelectstatus() {
		return selectstatus;
	}

	/**
	 * @param selectstatus the selectstatus to set
	 */
	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}

	/**
	 * @return the sing
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * @param sing the sing to set
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}

	public String getKnclass_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
}
