package com.deliverik.infogovernor.drm.form;
/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 演练计划管理Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0602Form extends BaseForm{
    //id
    protected Integer did;

    /** 演练计划制定人id */
    protected String duserid;

    /** 演练计划指定人名 */
    protected String dusername;

    /** 创建时间 */
    protected String crttimestart;
    /** 创建时间 */
    protected String crttimeend;

    /** 审批时间 */
    protected String judgetimestart;
    /** 审批时间 */
    protected String judgetimeend;
    
    /**审批人id*/
    protected String judgeuserid;
    
    /**审批人username*/
    protected String judgeusername;

    /** 演练计划编号 */
    protected String dserial;

    /** 演练计划名称 */
    protected String dname;

    /**审批意见*/
    protected String dopinion;
    
    /**是否是具有审批权限*/
    protected String isAdmin;
    
    /**审批状态*/
    protected String judgestatus;
    /**审批是否通过*/
    protected String isthrough;
    /**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;

    public String getIsthrough() {
        return isthrough;
    }

    public void setIsthrough(String isthrough) {
        this.isthrough = isthrough;
    }

    /**审批状态*/
    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getDopinion() {
        return dopinion;
    }

    public void setDopinion(String dopinion) {
        this.dopinion = dopinion;
    }

    public String getJudgeuserid() {
        return judgeuserid;
    }

    public void setJudgeuserid(String judgeuserid) {
        this.judgeuserid = judgeuserid;
    }

    public String getJudgeusername() {
        return judgeusername;
    }

    public void setJudgeusername(String judgeusername) {
        this.judgeusername = judgeusername;
    }

    /**
     * 演练计划id取得
     *
     * @return 演练计划id
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 演练计划id设定
     *
     * @param did 演练计划id
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 演练计划制定人id取得
     *
     * @return 演练计划制定人id
     */
    public String getDuserid() {
        return duserid;
    }

    /**
     * 演练计划制定人id设定
     *
     * @param duserid 演练计划制定人id
     */
    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    /**
     * 演练计划指定人名取得
     *
     * @return 演练计划指定人名
     */
    public String getDusername() {
        return dusername;
    }

    /**
     * 演练计划指定人名设定
     *
     * @param dusername 演练计划指定人名
     */
    public void setDusername(String dusername) {
        this.dusername = dusername;
    }



    /**
     * 演练计划编号取得
     *
     * @return 演练计划编号
     */
    public String getDserial() {
        return dserial;
    }

    /**
     * 演练计划编号设定
     *
     * @param dserial 演练计划编号
     */
    public void setDserial(String dserial) {
        this.dserial = dserial;
    }

    /**
     * 演练计划名称取得
     *
     * @return 演练计划名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 演练计划名称设定
     *
     * @param dname 演练计划名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCrttimestart() {
        return crttimestart;
    }

    public void setCrttimestart(String crttimestart) {
        this.crttimestart = crttimestart;
    }

    public String getCrttimeend() {
        return crttimeend;
    }

    public void setCrttimeend(String crttimeend) {
        this.crttimeend = crttimeend;
    }

    public String getJudgetimestart() {
        return judgetimestart;
    }

    public void setJudgetimestart(String judgetimestart) {
        this.judgetimestart = judgetimestart;
    }

    public String getJudgetimeend() {
        return judgetimeend;
    }

    public void setJudgetimeend(String judgetimeend) {
        this.judgetimeend = judgetimeend;
    }

	/**  
	 * 获取开始时间  
	 * @return propentime 开始时间  
	 */
	
	public String getPropentime() {
		return propentime;
	}

	/**  
	 * 设置开始时间  
	 * @param propentime 开始时间  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**  
	 * 获取结束时间  
	 * @return prclosetime 结束时间  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}

	/**  
	 * 设置结束时间  
	 * @param prclosetime 结束时间  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
    
}
