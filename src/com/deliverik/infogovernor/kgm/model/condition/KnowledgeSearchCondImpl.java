/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:流程评审Cond类
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeSearchCondImpl implements KnowledgeSearchCond {
	
	/**
	 *id
	 */
	protected Integer knid;
	
	/**
	 *id
	 */
	protected Integer knversion;
	
	/**
	 *编号
	 */
	protected String knserial;

	/**
	 *部门
	 */
	protected String kndepartment;

	/**
	 *归档人
	 */
	protected String knapprover;

	/**
	 *归档时间从
	 */
	protected String knapprovetime_f;
	
	/**
	 *归档时间到
	 */
	protected String knapprovetime_t;

	/**
	 *分类
	 */
	protected String knclass;


	/**
	 *关键字
	 */
	protected String knkey;


	/**
	 *来源
	 */
	protected String knorigin;


	/**
	 *知识贡献人
	 */
	protected String knproffer;


	/**
	 *贡献时间从
	 */
	protected String knproffertime_f;

	/**
	 *贡献时间到
	 */
	protected String knproffertime_t;
	/**
	 *标题
	 */
	protected String kntitle;


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
	 *状态
	 */
	protected String knstatus;

	
	/**
	 *关键字数组
	 */
	protected String[] knkeys;

	/**业务系统名称*/
	protected String systemid;
	
	/**
	 *标题数组
	 */
	protected String kntitles[];

	/**知识贡献人姓名*/
	protected String knproffername;

	/**归档人姓名 */
	protected String knapprovername;
	
	/**业务领域*/
	protected String knarea;
	
	/**技术领域*/
	protected String kntelarea;
	
	/**知识审批人角色*/
	protected Integer knapproverole;
	
	protected Integer[] knapproveroles;
	/**知识编号*/
	protected String knserial_like;
	
	/**排序字段**/
	protected String order;
	
	protected String selectstatus;
	
	/**排序方式**/
	protected String sing;
	
	/**
	 *分类模糊查询
	 */
	protected String knclass_like;
	
	
	public String getKnclass_like() {
		return knclass_like;
	}

	public void setKnclass_like(String knclass_like) {
		this.knclass_like = knclass_like;
	}

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
	
	public Integer[] getKnapproveroles() {
		return knapproveroles;
	}
	public void setKnapproveroles(Integer[] knapproveroles) {
		this.knapproveroles = knapproveroles;
	}
	/**
	 *业务领域取得
	 * 
	 * @return 业务领域
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
	public Integer getKnid() {
		return knid;
	}
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	public Integer getKnversion() {
		return knversion;
	}

	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSelectstatus() {
		return selectstatus;
	}

	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}
	
	
}
