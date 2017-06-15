/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;


/**
 * 概述: 知识信息检索条件接口
 * 功能描述：知识信息检索条件接口
 * 创建记录：宋海洋 2010/12/07
 * 修改记录：
 */
public class IGKGM0203Form extends BaseForm implements KnowledgeSearchCond{

	private static final long serialVersionUID = 1L;
	
	/**
	 *部门
	 */
	protected String kndepartment;

	/**
	 *来源
	 */
	protected String knorigin;
	
	/**
	 * 来源名称
	 */
	protected String knoriginname;

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
	
	/**知识贡献人姓名*/
	protected String knproffername;

	/**归档人姓名 */
	protected String knapprovername;
	
	/**技术领域*/
	protected String kntelarea;
	
	/**技术领域名称*/
	protected String kntelareaname;
	
	/**业务系统名称*/
	protected String systemid;
	
	/**业务领域*/
	protected String knarea;
	
	/**业务领域名称*/
	protected String knareaname;
	
	/**
	 * 打开知识明细页面的流程ID
	 */
	protected Integer prid;
	
	/**
	 * 打开知识明细页面的服务工单ID
	 */
	protected Integer sfid;
	
	/**
	 * 是否显示选择按钮
	 */
	protected String selectDisp;
	
	/**知识审批人角色*/
	protected Integer knapproverole;
	/**知识编号*/
	protected String knserial_like;
	
	/**排序字段**/
	protected String order;
	
	/**搜索菜单栏标志位*/
	protected String showFlag;

	
	protected String selectstatus;
	
	/**排序方式**/
	protected String sing;
	
	/** 是否清空查询数据标识 **/
	protected String resetFlag;
	
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
	 * @return the showFlag
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * @param showFlag the showFlag to set
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

	/**
	 * 业务领域取得
	 * @return 业务领域
	 */
	public String getKnarea() {
		return knarea;
	}

	/**
	 * 业务领域设定
	 * @param knarea 业务领域
	 */
	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}

	/**
	 * 业务领域名称取得
	 * @return 业务领域名称
	 */
	public String getKnareaname() {
		return knareaname;
	}

	/**
	 * 业务领域名称设定
	 * @param knareaname 业务领域名称
	 */
	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}

	/**
	 * 技术领域取得
	 * @return 技术领域
	 */
	public String getKntelarea() {
		return kntelarea;
	}

	/**
	 * 技术领域设定
	 * @param kntelarea  技术领域
	 */
	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}

	/**
	 * 技术领域名称设定
	 * @return 技术领域名称
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}

	/**
	 * 技术领域名称设定
	 * @param kntelarean 技术领域名称
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}

	/**
	 * 来源名称取得
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
	
	public IGKGM0203Form() {
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

	public String getKnproffertime_f() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnproffertime_t() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *归档时间从
	 */
	protected String knapprovetime_f;
	
	/**
	 *归档时间到
	 */
	protected String knapprovetime_t;
	
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
	 * 打开知识明细页面的流程ID取得
	 * @return 打开知识明细页面的流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 打开知识明细页面的流程ID设定
	 * @param prid打开知识明细页面的流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 是否显示选择按钮取得
	 * @return 是否显示选择按钮
	 */
	public String getSelectDisp() {
		return selectDisp;
	}

	/**
	 * 是否显示选择按钮设定
	 * @param selectDisp是否显示选择按钮
	 */
	public void setSelectDisp(String selectDisp) {
		this.selectDisp = selectDisp;
	}
	
	/**
	 * 打开知识明细页面的服务工单ID取得
	 * @return 打开知识明细页面的服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 打开知识明细页面的服务工单ID设定
	 * @param sfid打开知识明细页面的服务工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.selectDisp = null;
		this.prid = null;
		this.sfid = null;
		
		if(StringUtils.isNotEmpty(resetFlag)) {
			this.knserial_like = null;
			this.knkey = null;
			this.kntitle = null;
			this.knproffername = null;
			this.knclass = null;
			this.knclassname = null;
			this.knorigin = null;
			this.knoriginname = null;
			this.kntelarea = null;
			this.kntelareaname = null;
			this.systemid = null;
			this.knapprovetime_f = null;
			this.knapprovetime_t = null;
		}
	}

	public Integer getKnid() {
		// TODO Auto-generated method stub
		return null;
	}
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

	/**
	 * 是否清空查询数据标识取得
	 * 
	 * @return 是否清空查询数据标识
	 */
	public String getResetFlag() {
		return resetFlag;
	}

	/**
	 * 是否清空查询数据标识设定
	 * 
	 * @param resetFlag 是否清空查询数据标识
	 */
	public void setResetFlag(String resetFlag) {
		this.resetFlag = resetFlag;
	}

	public String getKnclass_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
