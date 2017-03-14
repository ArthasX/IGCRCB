/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程基本信息
 */
public class ProcessRecord implements ProcessRecordInfo{
	
	/** 流程ID */
	private Integer prid;
	
	/** 流程定义名称 */
	private String prpdname;
	
	/** 工单号 */
	private String prserialnum;
	
	/** 发起时间 */
	private String propentime;
	
	/** 关闭时间 */
	private String prclosetime;
	
	/** 流程名称 */
	private String prtitle;
	
	/** 流程描述 */
	private String prdesc;
	
	/** 流程状态 */
	private String prstatus;

	/** 优先级 */
	private String prPriority;

	/** 流程定义ID */
	private String prpdid;
	
	/** 流程类型 */
	private String prtype;
	
	/** 发起角色ID */
	private Integer prroleid;
	
	/** 发起用户ID */
	private String pruserid;
	
	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 流程定义名称取得
	 * @return 流程定义名称
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * 流程定义名称设定
	 * @param prpdname 流程定义名称
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * 工单号取得
	 *
	 * @return 工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 工单号设定
	 *
	 * @param prserialnum 工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

    /**
     * 发起时间取得
     * @return 发起时间
     */
    public String getPropentime() {
        return propentime;
    }

    /**
     * 发起时间设定
     * @param propentime 发起时间
     */
    public void setPropentime(String propentime) {
        this.propentime = propentime;
    }

    /**
     * 关闭时间取得
     * @return 关闭时间
     */
    public String getPrclosetime() {
        return prclosetime;
    }

    /**
     * 关闭时间设定
     * @param prclosetime 关闭时间
     */
    public void setPrclosetime(String prclosetime) {
        this.prclosetime = prclosetime;
    }

    /**
     * 流程描述取得
     * @return 流程描述
     */
    public String getPrdesc() {
        return prdesc;
    }

    /**
     * 流程描述设定
     * @param prdesc 流程描述
     */
    public void setPrdesc(String prdesc) {
        this.prdesc = prdesc;
    }

    /**
     * 流程状态取得
     * @return 流程状态
     */
    public String getPrstatus() {
        return prstatus;
    }

    /**
     * 流程状态设定
     * @param prstatus 流程状态
     */
    public void setPrstatus(String prstatus) {
        this.prstatus = prstatus;
    }

    /**
     * 流程名称取得
     * @return 流程名称
     */
    public String getPrtitle() {
        return prtitle;
    }

    /**
     * 流程名称设定
     * @param prtitle 流程名称
     */
    public void setPrtitle(String prtitle) {
        this.prtitle = prtitle;
    }
    
    /**
     * 优先级取得
     * @return 优先级
     */
    public String getPrPriority() {
    	return prPriority;
    }

    /**
     * 优先级设定
     * @param prPriority 优先级
     */
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}

	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义ID设定
	 * @param prpdid 流程定义ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 发起角色ID取得
	 * @return prroleid 发起角色ID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * 发起角色ID设定
	 * @param prroleid 发起角色ID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * 发起用户ID取得
	 * @return pruserid 发起用户ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * 发起用户ID设定
	 * @param pruserid 发起用户ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	
}
