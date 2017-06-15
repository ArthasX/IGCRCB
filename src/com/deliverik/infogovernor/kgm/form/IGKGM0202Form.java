package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

public class IGKGM0202Form extends BaseForm implements KnowledgeSearchCond{
	private static final long serialVersionUID = 1L;
 
	/**
	 *knid_q
	 */
	protected Integer knid_q;

	/**
	 *知识id数组
	 */
	protected String[] knids;
	
	/**
	 *key
	 */
	protected Integer knid;
	
	/**
	 *key
	 */
	protected Integer knversion;
	
	/**
	 *knarea
	 */
	protected String knarea;
	
	/**
	 *knareaname
	 */
	protected String knareaname;
	
	/**
	 *kntelarea
	 */
	protected String kntelarea;
	
	/**
	 *kntelareaname
	 */
	protected String kntelareaname;
	
	/**
	 *标题
	 */
	protected String[] kntitles;

	/**
	 *编号
	 */
	protected String knserial;

	/**
	 *归档人
	 */
	protected String knapprover;

	/**
	 *归档时间
	 */
	protected String knapprovetime;
	
	/**
	 *分类名称
	 */
	protected String knclassname;
	
	/**
	 *知识贡献人
	 */
	protected String knproffer;

	/**
	 *贡献时间
	 */
	protected String knproffertime;
	
	/**
	 *部门
	 */
	protected String kndepartment;

	/**
	 *来源
	 */
	protected String knorigin;
	
	/**
	 *来源
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
	 *关键字
	 */
	protected String knkey_p;
	
	/**
	 *状态
	 */
	protected String knstatus;
	
	/**
	 *驳回说明
	 */
	protected String knreject;
	
	/**
	 *标题
	 */
	protected String kntitle;
	
	/**
	 *关键字数组
	 */
	protected String[] knkeys;
	
	/**知识贡献人姓名*/
	protected String knproffername;

	/**归档人姓名 */
	protected String knapprovername;
	
	/**知识审批人角色*/
	protected Integer knapproverole;
	/**排序字段**/
	protected String order;
	
	protected String selectstatus;
	
	/**排序方式**/
	protected String sing;
	
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
	 *驳回说明取得
	 * 
	 * @return 驳回说明
	 */
	public String getKnreject() {
		return knreject;
	}

	/**
	 * 驳回说明
	 * @param file 驳回说明
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
     *关键字数组取得
     * 
     * @return 关键字数组
     */
	public String[] getKnkeys() {
		return knkeys;
	}

    /**
     *关键字设定
     * 
     * @param knkeys 关键字
     */
	public void setKnkeys(String[] knkeys) {
		this.knkeys = knkeys;
	}

    /**
     *key取得
     * 
     * @return key
     */
	public Integer getKnid() {
		return knid;
	}

    /**
     *key设定
     * 
     * @param key key
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
     * @param knserial 编号
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
     * @param kndepartment 部门
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
     * @param knapprover 归档人
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
     * @param knapprovetime 归档时间
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
     * @param knclass 分类
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
     * @param knkey 关键字
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
     * @param knorigin 来源
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
     * @param knproffer 知识贡献人
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
     * @param knproffertime 贡献时间
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
     * @param kntitle 标题
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
     * @param kndes 问题描述
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
     * @param knfaultcause 故障原因总结
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
     * @param knsolveway 解决办法
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
     * @param knstatus 状态
     */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}

    /**
     *版本取得
     * 
     * @return 版本
     */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	 *分类名称取得
	 * 
	 * @return 分类名称
	 */
	public String getKnclassname(){
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
	 *ingerPrint取得
	 * 
	 * @return ingerPrint
	 */
	public String getFingerPrint() {
		return "";
	}

	public Integer getKnid_q() {
		return knid_q;
	}

	public void setKnid_q(Integer knid_q) {
		this.knid_q = knid_q;
	}

	public String[] getKnids() {
		return knids;
	}

	public void setKnids(String[] knids) {
		this.knids = knids;
	}
	/**
	 *归档时间从取得
	 * 
	 * @return 归档时间从
	 */
	public String getKnapprovetime_f(){
		return "";
	}
	/**
	 *归档时间到取得
	 * 
	 * @return 归档时间到
	 */
	public String getKnapprovetime_t(){
		return "";
	}
	
	/**
	 *贡献时间从取得
	 * 
	 * @return 贡献时间从
	 */
	public String getKnproffertime_f(){
		return "";
	}
	
	/**
	 *贡献时间到取得
	 * 
	 * @return 贡献时间到
	 */
	public String getKnproffertime_t() {
		return "";
	}

	public String getKnkey_p() {
		return knkey_p;
	}

	public void setKnkey_p(String knkey_p) {
		this.knkey_p = knkey_p;
	}

	public String getKnarea() {
		return knarea;
	}

	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}

	public String getKnareaname() {
		return knareaname;
	}

	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}

	public String getKntelarea() {
		return kntelarea;
	}

	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}

	public String getKntelareaname() {
		return kntelareaname;
	}

	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}

	public String getKnoriginname() {
		return knoriginname;
	}

	public void setKnoriginname(String knoriginname) {
		this.knoriginname = knoriginname;
	}

	public Integer getKnversion() {
		return knversion;
	}

	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	/**业务系统名称*/
	protected String systemid;

	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getKnserial_like() {
		// TODO Auto-generated method stub
		return null;
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
}
