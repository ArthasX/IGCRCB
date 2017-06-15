package com.deliverik.framework.workflow.prd.model.condition;


/**
 * 流程类型定义信息检索条件实现
 * 
 */
public class IG380SearchCondImpl implements IG380SearchCond{
	
	/** 流程类型定义ID */
	protected String pdid;
	
	protected String[] pdid_in;
	protected String[] pdid_not_in;

	/** 流程模板ID */
	protected Integer ptid;

	/** 流程类型定义名称 */
	protected String pdname;

	/** 流程类型定义状态（a启用，i停用）*/
	protected String pdstatus;
	
	/** 流程模板ID（不匹配） */
	protected Integer notSelfPd;

	/** 是否为查询历史版本 1：历史  0：全部 */
	protected String searchHistory ;
	/**
	 * 自定义流程模板取得
	 * @return 流程模板ID
	 */
	public Integer[] PrTypeArray;
	
	public String[] pdstatuses;
	
	/** 流程类型定义ID */
	protected String pdid_like;
	
	/**
	 * 流程日志权限
	 */
	protected String permission;
	
	   /**
     * 一组流程记录流程类型ID模糊查询
     */
    protected String[] prpdid_like_or;
    
    /** 流程发布位置菜单 */
    protected String actname;
	
	public String[] getPrpdid_like_or() {
        return prpdid_like_or;
    }


    public void setPrpdid_like_or(String[] prpdid_like_or) {
        this.prpdid_like_or = prpdid_like_or;
    }


	/**
	 * 流程日志权限取得
	 * @return 流程日志权限
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * 流程日志权限设定
	  * @param permission 流程日志权限
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	

	/**
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public String getPdid() {
		return pdid;
	}
	
	/**
	 * 根据流程ID取得自定义流程和标准流程ID
	  * @param pdid 流程类型定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板ID设定
	  * @param ptid 流程模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程类型定义名称取得
	 * @return 流程类型定义名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程类型定义名称设定
	  * @param pdname 流程类型定义名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 流程类型定义状态（a启用，i停用）取得
	 * @return 流程类型定义状态
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * 流程类型定义状态（a启用，i停用）设定
	  * @param pdstatus 流程类型定义状态
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * 流程模板ID（不匹配）取得
	 * @return 流程模板ID
	 */
	public Integer getNotSelfPd() {
		return notSelfPd;
	}

	/**
	 * 流程模板ID（不匹配）设定
	  * @param notSelfPd 流程模板ID
	 */
	public void setNotSelfPd(Integer notSelfPd) {
		this.notSelfPd = notSelfPd;
	}

	public String[] getPdstatuses() {
		return pdstatuses;
	}

	public void setPdstatuses(String[] pdstatuses) {
		this.pdstatuses = pdstatuses;
	}

	public Integer[] getPrTypeArray() {
		return PrTypeArray;
	}

	public void setPrTypeArray(Integer[] prTypeArray) {
		PrTypeArray = prTypeArray;
	}


	public String getSearchHistory() {
		return searchHistory;
	}


	public void setSearchHistory(String searchHistory) {
		this.searchHistory = searchHistory;
	}

	/**
	 * 流程类型定义ID取得
	 * 
	 * @return 流程类型定义ID
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * 流程类型定义ID设定
	 * 
	 * @param pdid_like 流程类型定义ID
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

	/**
	 * 流程发布位置菜单取得
	 * @return  流程发布位置菜单  
	 */
    public String getActname() {
        return actname;
    }

    /**
     * 流程发布菜单位置设定
     * @param actname 流程发布位置菜单   
     */
    public void setActname(String actname) {
        this.actname = actname;
    }


	/**
	 * pdid_in   取得
	 * @return pdid_in pdid_in
	 */
	public String[] getPdid_in() {
		return pdid_in;
	}
	
		/**
	 * pdid_in   设定
	 * @param pdid_in pdid_in
	 */
	public void setPdid_in(String[] pdid_in) {
		this.pdid_in = pdid_in;
	}


	/**
	 * pdid_not_in   取得
	 * @return pdid_not_in pdid_not_in
	 */
	public String[] getPdid_not_in() {
		return pdid_not_in;
	}


	/**
	 * pdid_not_in   设定
	 * @param pdid_not_in pdid_not_in
	 */
	public void setPdid_not_in(String[] pdid_not_in) {
		this.pdid_not_in = pdid_not_in;
	}
	


}
