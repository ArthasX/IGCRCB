/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;

/**
 * 演练计划DTO
 *
 */
public class IGDRM06DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	
	protected int maxSearchCount;

	protected User user;
	
	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
    protected List<DrillplanInfo> drilllist;
    
    protected List<DrillplanVWInfo> drillVWlist;
    List<Map<String, Object>> searchDrillplanMap;
    //审批是否通过
    protected String judgestatus;
    //审批意见
    protected String judgeopinion;
    //演练条目
    protected List<DrillplanitemInfo> drillItemList;
    //演练计划
    protected DrillplanInfo drillplanInfo;
    //演练 vw
    protected List<DrillplanVWInfo> drillplanVWlist;
    
    
    

    public List<DrillplanVWInfo> getDrillplanVWlist() {
        return drillplanVWlist;
    }

    public void setDrillplanVWlist(List<DrillplanVWInfo> drillplanVWlist) {
        this.drillplanVWlist = drillplanVWlist;
    }

    public DrillplanInfo getDrillplanInfo() {
        return drillplanInfo;
    }

    public void setDrillplanInfo(DrillplanInfo drillplanInfo) {
        this.drillplanInfo = drillplanInfo;
    }

    public List<DrillplanitemInfo> getDrillItemList() {
        return drillItemList;
    }

    public void setDrillItemList(List<DrillplanitemInfo> drillItemList) {
        this.drillItemList = drillItemList;
    }

    public String getJudgeopinion() {
        return judgeopinion;
    }

    public void setJudgeopinion(String judgeopinion) {
        this.judgeopinion = judgeopinion;
    }

    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    public List<DrillplanVWInfo> getDrillVWlist() {
        return drillVWlist;
    }

    public void setDrillVWlist(List<DrillplanVWInfo> drillVWlist) {
        this.drillVWlist = drillVWlist;
    }

    public List<DrillplanInfo> getDrilllist() {
        return drilllist;
    }

    public void setDrilllist(List<DrillplanInfo> drilllist) {
        this.drilllist = drilllist;
    }
	    

	/**
	 * pagingDto   取得
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * pagingDto   设定
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}


	/**
	 * maxSearchCount   取得
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * maxSearchCount   设定
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * user   取得
	 * @return user user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * user   设定
	 * @param user user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public List<Map<String, Object>> getSearchDrillplanMap() {
		return searchDrillplanMap;
	}

	public void setSearchDrillplanMap(List<Map<String, Object>> searchDrillplanMap) {
		this.searchDrillplanMap = searchDrillplanMap;
	}

}