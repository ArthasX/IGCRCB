/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.dut.form.IGDUT0301Form;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.form.IGDUT0305Form;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;

/**
 * 值班情况汇总DTO
 */
public class IGDUT03DTO extends BaseDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/** CodeDetail list */
	protected List<CodeDetail> codeDetailList;

	

	/**
	 * CodeDetaillist取得
	 *
	 * @return codeDetailList CodeDetaillist
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * CodeDetaillist设定
	 *
	 * @param codeDetailList CodeDetaillist
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/** 值班情况汇总查询条件 */
	protected DutyResultSearchCond dutyResultSearchCond;
	
	/** 值班情况汇总信息Form */
	protected IGDUT0302Form igDUT0302Form;
	
	/**值班情况汇总信息对象*/
	protected DutyResult dutyResult;

	/** 值班情况汇总信息检索结果集 */
	protected List<DutyResult> dutyResultList;
	
	/** 白班计划 */
	protected DutyPlan dutyPlanAM;
	
	/** 夜班计划 */
	protected DutyPlan dutyPlanPM;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 值班情况汇总信息最大检索件数 */
	protected int maxSearchCount;

	/** 值班情况汇总信息Form */
	protected IGDUT0301Form igdut0301Form;
	
	protected int calendarYear;
	
	protected int calendarMonth;
	
	protected String dadcategory;
	
	/** 检测结果 */
	protected Map<String,Integer> dutyResultMap;
	
	/** 日常维护登记信息Form */
    protected IGDUT0304Form igDUT0304Form;
    
    /** 日常维护查询信息Form */
    protected IGDUT0305Form igDUT0305Form;
    
    /** 日常维护检索结果集 */
    protected List<OnDutyPersonRecordInfo> onDutyPersonRecordList;
    
    /** 日常维护查询条件 */
    protected OnDutyPersonRecordSearchCond onDutyPersonRecordSearchCond;
	
    /** 日常维护对象*/
    protected OnDutyPersonRecordInfo onDutyPersonRecordInfo;
	
	/** 延时解锁 */
	protected Map<String,Integer> delayMap;
	
	public Map<String, Integer> getDelayMap() {
		return delayMap;
	}

	public void setDelayMap(Map<String, Integer> delayMap) {
		this.delayMap = delayMap;
	}
    
	
	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	/**
	 * 值班情况汇总查询条件取得
	 * @return 值班情况汇总查询条件
	 */
	public DutyResultSearchCond getDutyResultSearchCond() {
		return dutyResultSearchCond;
	}

	/**
	 * 值班情况汇总查询条件设定
	 * @param dutyResultSearchCond 值班情况汇总查询条件
	 */
	public void setDutyResultSearchCond(DutyResultSearchCond dutyResultSearchCond) {
		this.dutyResultSearchCond = dutyResultSearchCond;
	}

	/**
	 * 值班情况汇总信息Form取得
	 * @return 值班情况汇总信息Form
	 */
	public IGDUT0302Form getIgDUT0302Form() {
		return igDUT0302Form;
	}

	/**
	 * 值班情况汇总信息Form设定
	 * @param igDUT0302Form 值班情况汇总信息Form
	 */
	public void setIgDUT0302Form(IGDUT0302Form igDUT0302Form) {
		this.igDUT0302Form = igDUT0302Form;
	}

	/**
	 * 值班情况汇总信息对象取得
	 * @return 值班情况汇总信息对象
	 */
	public DutyResult getDutyResult() {
		return dutyResult;
	}

	/**
	 * 值班情况汇总信息对象设定
	 * @param dutyResult 值班情况汇总信息对象
	 */
	public void setDutyResult(DutyResult dutyResult) {
		this.dutyResult = dutyResult;
	}

	/**
	 * 值班情况汇总信息检索结果集取得
	 * @return 值班情况汇总信息检索结果集
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * 值班情况汇总信息检索结果集设定
	 * @param dutyResultList 值班情况汇总信息检索结果集
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 值班情况汇总信息最大检索件数取得
	 * @return 值班情况汇总信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 值班情况汇总信息最大检索件数设定
	 * @param maxSearchCount 值班情况汇总信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public IGDUT0301Form getIgdut0301Form() {
		return igdut0301Form;
	}

	public void setIgdut0301Form(IGDUT0301Form igdut0301Form) {
		this.igdut0301Form = igdut0301Form;
	}

	public Map<String, Integer> getDutyResultMap() {
		return dutyResultMap;
	}

	public void setDutyResultMap(Map<String, Integer> dutyResultMap) {
		this.dutyResultMap = dutyResultMap;
	}

	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}
	
	/**
	 * 白班计划取得
	 * @return 白班计划
	 */
	public DutyPlan getDutyPlanAM() {
		return dutyPlanAM;
	}

	/**
	 * 白班计划设定
	 * @param dutyPlanAM 白班计划
	 */
	public void setDutyPlanAM(DutyPlan dutyPlanAM) {
		this.dutyPlanAM = dutyPlanAM;
	}

	/**
	 * 夜班计划取得
	 * @return 夜班计划
	 */
	public DutyPlan getDutyPlanPM() {
		return dutyPlanPM;
	}

	/**
	 * 夜班计划设定
	 * @param dutyPlanPM 夜班计划
	 */
	public void setDutyPlanPM(DutyPlan dutyPlanPM) {
		this.dutyPlanPM = dutyPlanPM;
	}

    /**
     * 日常维护登记信息Form取得
     *
     * @return igDUT0304Form 日常维护登记信息Form
     */
    public IGDUT0304Form getIgDUT0304Form() {
        return igDUT0304Form;
    }

    /**
     * 日常维护登记信息Form设定
     *
     * @param igDUT0304Form 日常维护登记信息Form
     */
    public void setIgDUT0304Form(IGDUT0304Form igDUT0304Form) {
        this.igDUT0304Form = igDUT0304Form;
    }

    /**
     * 日常维护查询信息Form取得
     *
     * @return igDUT0305Form 日常维护查询信息Form
     */
    public IGDUT0305Form getIgDUT0305Form() {
        return igDUT0305Form;
    }

    /**
     * 日常维护查询信息Form设定
     *
     * @param igDUT0305Form 日常维护查询信息Form
     */
    public void setIgDUT0305Form(IGDUT0305Form igDUT0305Form) {
        this.igDUT0305Form = igDUT0305Form;
    }

    /**
     * 日常维护检索结果集取得
     *
     * @return onDutyPersonRecordList 日常维护检索结果集
     */
    public List<OnDutyPersonRecordInfo> getOnDutyPersonRecordList() {
        return onDutyPersonRecordList;
    }

    /**
     * 日常维护检索结果集设定
     *
     * @param onDutyPersonRecordList 日常维护检索结果集
     */
    public void setOnDutyPersonRecordList(
            List<OnDutyPersonRecordInfo> onDutyPersonRecordList) {
        this.onDutyPersonRecordList = onDutyPersonRecordList;
    }

    /**
     * 日常维护查询条件取得
     *
     * @return onDutyPersonRecordSearchCond 日常维护查询条件
     */
    public OnDutyPersonRecordSearchCond getOnDutyPersonRecordSearchCond() {
        return onDutyPersonRecordSearchCond;
    }

    /**
     * 日常维护查询条件设定
     *
     * @param onDutyPersonRecordSearchCond 日常维护查询条件
     */
    public void setOnDutyPersonRecordSearchCond(
            OnDutyPersonRecordSearchCond onDutyPersonRecordSearchCond) {
        this.onDutyPersonRecordSearchCond = onDutyPersonRecordSearchCond;
    }

    /**
     * 日常维护对象取得
     *
     * @return onDutyPersonRecordInfo 日常维护对象
     */
    public OnDutyPersonRecordInfo getOnDutyPersonRecordInfo() {
        return onDutyPersonRecordInfo;
    }

    /**
     * 日常维护对象设定
     *
     * @param onDutyPersonRecordInfo 日常维护对象
     */
    public void setOnDutyPersonRecordInfo(
            OnDutyPersonRecordInfo onDutyPersonRecordInfo) {
        this.onDutyPersonRecordInfo = onDutyPersonRecordInfo;
    }

	

}
