/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 演练计划检索条件实现
  * 功能描述: 演练计划检索条件实现
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public class DrillplanSearchCondImpl implements
		DrillplanSearchCond {
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
    
    /**是否是具有审批权限*/
    protected String isAdmin;
    
    /**审批状态*/
    protected String judgestatus;
    /**演练计划编号 like*/
    protected String serial_like;
    
    /**状态不等于*/
    protected String judgestatus_ne;

    /**开始时间*/
   	protected String propentime;
   	
   	/**结束时间*/
   	protected String prclosetime;
   	
    /**审批状态*/
    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /**是否是具有审批权限*/
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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
	 * serial_like   取得
	 * @return serial_like serial_like
	 */
	public String getSerial_like() {
		return serial_like;
	}

	/**
	 * serial_like   设定
	 * @param serial_like serial_like
	 */
	public void setSerial_like(String serial_like) {
		this.serial_like = serial_like;
	}

	/**
	 * judgestatus_ne取得
	 *
	 * @return judgestatus_ne judgestatus_ne
	 */
	public String getJudgestatus_ne() {
		return judgestatus_ne;
	}

	/**
	 * judgestatus_ne设定
	 *
	 * @param judgestatus_ne judgestatus_ne
	 */
	public void setJudgestatus_ne(String judgestatus_ne) {
		this.judgestatus_ne = judgestatus_ne;
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