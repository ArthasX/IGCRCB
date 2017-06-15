/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.csebank.lom.form.IGLOM0501Form;
import com.csebank.lom.form.IGLOM0502Form;
import com.csebank.lom.form.IGLOM0503Form;
import com.csebank.lom.form.IGLOM0504Form;
import com.csebank.lom.form.IGLOM0505Form;
import com.csebank.lom.form.IGLOM0506Form;
import com.csebank.lom.form.IGLOM0508Form;
import com.csebank.lom.form.IGLOM0509Form;
import com.csebank.lom.form.IGLOM0514Form;
import com.csebank.lom.form.IGLOM0515Form;
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.csebank.lom.vo.IGLOM05051VO;
import com.csebank.lom.vo.IGLOM05141VO;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * 食堂管理DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM05DTO extends BaseDTO implements Serializable {
	
	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 食堂招待部门汇总明细查询条件 */
	protected EESearchCond eeSearchCond;
	/** 食堂管理信息最大检索件数 */
	protected int maxSearchCount;
	
	/** 接待删除ID */
	protected String[] deleteEeid;

	/** 食堂成本信息查询条件 */
	protected EaterySearchCond eaterySearchCond;
	
	/** 食堂工作餐信息查询条件 */
	protected EworkingLunchSearchCond eworkingLunchSearchCond;
	
	/** 食堂接待信息查询条件 */
	protected EentertainmentSearchCond eentertainmentSearchCond;
	
	/** 工作餐成本信息统计条件 */
	protected WorkLunchEaterySearchCond workLunchEaterySearchCond;
	
	/** 接待信息统计条件 */
	protected EentertainmentStatisticsSearchCond eentertainmentStatisticsSearchCond;
	
	/** 部门接待信息统计条件 */
	protected DeptEentertainmentSearchCond deptEentertainmentSearchCond;
	
	/** 库存统计条件 */
	protected GoodsStockSearchCond goodsStockSearchCond;
	
	/** 单一物品库存统计条件 */
	protected SingleGoodsStockSearchCond singleGoodsStockSearchCond;
	
	/** 餐卡条件 */
	protected LunchCardSearchCond lunchCardSearchCond;
	
	/** 食堂成本信息Form */
	protected IGLOM0501Form iglom0501Form;
	
	/** 食堂成本管理Form */
	protected IGLOM0502Form iglom0502Form;
	
	/** 食堂工作餐信息Form */
	protected IGLOM0503Form iglom0503Form;
	
	/** 食堂工作餐管理Form */
	protected IGLOM0504Form iglom0504Form;
	
	/** 工作餐成本统计Form */
	protected IGLOM0505Form iglom0505Form;
	
	/** 食堂接待信息Form */
	protected IGLOM0506Form iglom0506Form;
	
	/** 接待统计Form */
	protected IGLOM0508Form iglom0508Form;
	
	/** 部门接待统计Form */
	protected IGLOM0509Form iglom0509Form;
	
	/** 库存统计Form */
	protected IGLOM0514Form iglom0514Form;
	
	/** 单一物品库存统计Form */
	protected IGLOM0515Form iglom0515Form;
	
	/** 餐卡Form */
	protected IGLOM0518Form iglom0518Form;
	
	/** 餐卡Form */
	protected IGLOM0519Form iglom0519Form;
	
	/** 食堂成本信息 */
	protected Eatery eatery;
	
	/** 食堂成本信息搜索结果集 */
	protected List<Eatery> eateryList;
	
	/** 食堂工作餐信息 */
	protected EworkingLunch eworkingLunch;
	
	/** 食堂工作餐信息搜索结果集 */
	protected List<EworkingLunch> eworkingLunchList;
	
	/** 食堂接待信息 */
	protected Eentertainment eentertainment;
	
	/** 食堂接待信息搜索结果集 */
	protected List<Eentertainment> eentertainmentList;
	
	/** 工作餐成本统计信息 */
	protected WorkLunchEatery workLunchEatery;
	
	/** 工作餐成本统计搜索结果集 */
	protected List<WorkLunchEatery> workLunchEateryList;
	
	/** 接待统计 */
	protected EentertainmentStatistics eentertainmentStatistics;
	
	/** 接待统计搜索结果集 */
	protected List<EentertainmentStatistics> eentertainmentStatisticsList;
	
	/** 部门接待统计 */
	protected DeptEentertainment deptEentertainment;
	
	/** 部门接待统计搜索结果集 */
	protected List<DeptEentertainment> deptEentertainmentList;
	
	/** 库存统计 */
	protected GoodsStock goodsStock;
	
	/** 库存统计搜索结果集 */
	protected List<GoodsStock> goodsStockList;
	
	/** 单一物品库存统计 */
	protected SingleGoodsStock singleGoodsStock;
	
	/** 单一物品库存统计搜索结果集 */
	protected List<SingleGoodsStock> singleGoodsStockList;
	
	/** 餐卡信息 */
	protected ItemsCodesSt itemsCodes;
	
	/** 餐卡结果集 */
	protected List<ItemsCodesSt> itemsCodesList;
	
	protected Map<String,IGLOM05141VO> map;
	protected Map<String,IGLOM05051VO> mapel;
	
	protected String innum;
	
	protected String outnum;

	protected String nownum;
	/** 食堂管理-食堂接待部门汇总查询条件接口*/
	protected EEOrgVWSearchCond eeOrgVWSearchCond;
	/** 食堂招待汇总搜索结果集 */
	protected List<EEOrg> eeOrgVWList;
	/** 食堂管理-物品消耗明细查询条件接口*/
	protected GoutDetailSearchCond goutDetailSearchCond;
	/** 食堂物品消耗明细结果集 */
	protected List<GoutDetailInfo> goutDetailInfoList;
	
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
	 * 食堂管理信息最大检索件数取得
	 * @return 食堂管理信息最大检索件数取得
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 食堂管理信息最大检索件数设定
	 * @param maxSearchCount 食堂管理信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * 接待删除ID
	 * @return 接待删除ID
	 */
	public String[] getDeleteEeid() {
		return deleteEeid;
	}
	
	/**
	 * 接待删除ID
	 * @param deleteEeid 接待删除ID
	 */
	public void setDeleteEeid(String[] deleteEeid) {
		this.deleteEeid = deleteEeid;
	}
	
	/**
	 * 食堂成本信息查询条件取得
	 * @return
	 */
	public EaterySearchCond getEaterySearchCond() {
		return eaterySearchCond;
	}

	/**
	 * 食堂成本信息查询条件设定
	 * @param eaterySearchCond 接待管理查询条件设定
	 */
	public void setEaterySearchCond(EaterySearchCond eaterySearchCond) {
		this.eaterySearchCond = eaterySearchCond;
	}
	
	/**
	 * 食堂工作餐查询条件取得
	 * @return
	 */
	public EworkingLunchSearchCond getEworkingLunchSearchCond() {
		return eworkingLunchSearchCond;
	}

	/**
	 * 食堂工作餐查询条件设定
	 * @param eworkingLunchSearchCond 接待管理查询条件设定
	 */
	public void setEworkingLunchSearchCond(EworkingLunchSearchCond eworkingLunchSearchCond) {
		this.eworkingLunchSearchCond = eworkingLunchSearchCond;
	}
	
	/**
	 * 食堂接待查询条件取得
	 * @return
	 */
	public EentertainmentSearchCond getEentertainmentSearchCond() {
		return eentertainmentSearchCond;
	}

	/**
	 * 食堂接待查询条件设定
	 * @param eworkingLunchSearchCond 接待管理查询条件设定
	 */
	public void setEentertainmentSearchCond(EentertainmentSearchCond eentertainmentSearchCond) {
		this.eentertainmentSearchCond = eentertainmentSearchCond;
	}
	
	/**
	 * 工作餐成本统计查询条件取得
	 * @return
	 */
	public WorkLunchEaterySearchCond getWorkLunchEaterySearchCond() {
		return workLunchEaterySearchCond;
	}

	/**
	 * 工作餐成本统计查询条件设定
	 * @param workLunchEaterySearchCond 工作餐成本统计查询条件设定
	 */
	public void setWorkLunchEaterySearchCond(WorkLunchEaterySearchCond workLunchEaterySearchCond) {
		this.workLunchEaterySearchCond = workLunchEaterySearchCond;
	}
	
	/**
	 * 接待统计查询条件取得
	 * @return
	 */
	public EentertainmentStatisticsSearchCond getEentertainmentStatisticsSearchCond() {
		return eentertainmentStatisticsSearchCond;
	}

	/**
	 * 接待统计查询条件设定
	 * @param workLunchEaterySearchCond 接待统计查询条件设定
	 */
	public void setEentertainmentStatisticsSearchCond(EentertainmentStatisticsSearchCond eentertainmentStatisticsSearchCond) {
		this.eentertainmentStatisticsSearchCond = eentertainmentStatisticsSearchCond;
	}
	
	/**
	 * 部门接待统计查询条件取得
	 * @return
	 */
	public DeptEentertainmentSearchCond getDeptEentertainmentSearchCond() {
		return deptEentertainmentSearchCond;
	}


	/**
	 * 部门接待统计查询条件设定
	 * @param deptEentertainmentSearchCond 接待统计查询条件设定
	 */
	public void setDeptEentertainmentSearchCond(DeptEentertainmentSearchCond deptEentertainmentSearchCond) {
		this.deptEentertainmentSearchCond = deptEentertainmentSearchCond;
	}
	
	/**
	 * 库存统计查询条件取得
	 * @return
	 */
	public GoodsStockSearchCond getGoodsStockSearchCond() {
		return goodsStockSearchCond;
	}

	/**
	 * 库存统计查询条件设定
	 * @param goodsStockSearchCond 库存统计查询条件设定
	 */
	public void setGoodsStockSearchCond(GoodsStockSearchCond goodsStockSearchCond) {
		this.goodsStockSearchCond = goodsStockSearchCond;
	}
	
	/**
	 * 单一物品库存统计查询条件取得
	 * @return
	 */
	public SingleGoodsStockSearchCond getSingleGoodsStockSearchCond() {
		return singleGoodsStockSearchCond;
	}

	/**
	 * 单一物品库存统计查询条件设定
	 * @param goodsStockSearchCond 单一物品库存统计查询条件设定
	 */
	public void setSingleGoodsStockSearchCond(SingleGoodsStockSearchCond singleGoodsStockSearchCond) {
		this.singleGoodsStockSearchCond = singleGoodsStockSearchCond;
	}
	
	/**
	 * 餐卡查询条件取得
	 * @return
	 */
	public LunchCardSearchCond getLunchCardSearchCond() {
		return lunchCardSearchCond;
	}

	/**
	 * 餐卡查询条件设定
	 * @param lunchCardSearchCond 单一物品库存统计查询条件设定
	 */
	public void setLunchCardSearchCond(LunchCardSearchCond lunchCardSearchCond) {
		this.lunchCardSearchCond = lunchCardSearchCond;
	}

	/**
	 * 食堂成本信息Form取得
	 * @return 食堂成本信息Form
	 */
	public IGLOM0501Form getIglom0501Form() {
		return iglom0501Form;
	}

	/**
	 * 食堂成本信息Form设定
	 * @param igLOM0501Form 食堂成本信息Form
	 */
	public void setIglom0501Form(IGLOM0501Form iglom0501Form) {
		this.iglom0501Form = iglom0501Form;
	}
	
	/**
	 * 食堂成本管理Form取得
	 * @return 食堂成本管理Form
	 */
	public IGLOM0502Form getIglom0502Form() {
		return iglom0502Form;
	}

	/**
	 * 食堂成本管理Form设定
	 * @param igLOM0502Form 食堂成本管理Form
	 */
	public void setIglom0502Form(IGLOM0502Form iglom0502Form) {
		this.iglom0502Form = iglom0502Form;
	}
	
	/**
	 * 食堂工作餐信息Form取得
	 * @return 食堂工作餐信息Form
	 */
	public IGLOM0503Form getIglom0503Form() {
		return iglom0503Form;
	}

	/**
	 * 食堂工作餐信息Form设定
	 * @param igLOM0503Form 食堂工作餐信息Form
	 */
	public void setIglom0503Form(IGLOM0503Form iglom0503Form) {
		this.iglom0503Form = iglom0503Form;
	}
	
	/**
	 * 食堂工作餐管理Form取得
	 * @return 食堂工作餐管理Form
	 */
	public IGLOM0504Form getIglom0504Form() {
		return iglom0504Form;
	}

	/**
	 * 食堂工作餐管理Form设定
	 * @param igLOM0504Form 食堂工作餐管理Form
	 */
	public void setIglom0504Form(IGLOM0504Form iglom0504Form) {
		this.iglom0504Form = iglom0504Form;
	}
	
	/**
	 * 工作餐成本统计Form取得
	 * @return 工作餐成本统计Form
	 */
	public IGLOM0505Form getIglom0505Form() {
		return iglom0505Form;
	}

	/**
	 * 工作餐成本统计Form设定
	 * @param igLOM0505Form 工作餐成本统计Form
	 */
	public void setIglom0505Form(IGLOM0505Form iglom0505Form) {
		this.iglom0505Form = iglom0505Form;
	}
	
	/**
	 * 食堂接待信息Form取得
	 * @return 食堂接待信息Form
	 */
	public IGLOM0506Form getIglom0506Form() {
		return iglom0506Form;
	}

	/**
	 * 食堂接待信息Form设定
	 * @param igLOM0506Form 食堂接待信息Form
	 */
	public void setIglom0506Form(IGLOM0506Form iglom0506Form) {
		this.iglom0506Form = iglom0506Form;
	}
	
	/**
	 * 接待统计Form取得
	 * @return 接待统计Form
	 */
	public IGLOM0508Form getIglom0508Form() {
		return iglom0508Form;
	}

	/**
	 * 接待统计Form设定
	 * @param iglom0508Form 接待统计Form
	 */
	public void setIglom0508Form(IGLOM0508Form iglom0508Form) {
		this.iglom0508Form = iglom0508Form;
	}
	
	/**
	 * 部门接待统计Form取得
	 * @return 接待统计Form
	 */
	public IGLOM0509Form getIglom0509Form() {
		return iglom0509Form;
	}

	/**
	 * 部门接待统计Form设定
	 * @param iglom0509Form 接待统计Form
	 */
	public void setIglom0509Form(IGLOM0509Form iglom0509Form) {
		this.iglom0509Form = iglom0509Form;
	}
	
	/**
	 * 库存统计Form取得
	 * @return 库存统计Form
	 */
	public IGLOM0514Form getIglom0514Form() {
		return iglom0514Form;
	}

	/**
	 * 库存统计Form设定
	 * @param iglom0514Form 库存统计Form
	 */
	public void setIglom0514Form(IGLOM0514Form iglom0514Form) {
		this.iglom0514Form = iglom0514Form;
	}
	
	/**
	 * 单一物品库存统计Form取得
	 * @return 单一物品库存统计Form
	 */
	public IGLOM0515Form getIglom0515Form() {
		return iglom0515Form;
	}

	/**
	 * 单一物品库存统计Form设定
	 * @param iglom0515Form 单一物品库存统计Form
	 */
	public void setIglom0515Form(IGLOM0515Form iglom0515Form) {
		this.iglom0515Form = iglom0515Form;
	}
	
	/**
	 * 餐卡Form取得
	 * @return 餐卡Form
	 */
	public IGLOM0518Form getIglom0518Form() {
		return iglom0518Form;
	}

	/**
	 * 餐卡Form设定
	 * @param iglom0518Form 餐卡Form
	 */
	public void setIglom0518Form(IGLOM0518Form iglom0518Form) {
		this.iglom0518Form = iglom0518Form;
	}
	/**
	 * 餐卡Form取得
	 * @return 餐卡Form
	 */
	public IGLOM0519Form getIglom0519Form() {
		return iglom0519Form;
	}
	/**
	 * 餐卡Form设定
	 * @param iglom0519Form 餐卡Form
	 */
	public void setIglom0519Form(IGLOM0519Form iglom0519Form) {
		// TODO Auto-generated method stub
		this.iglom0519Form = iglom0519Form;
	}
	
	/**
	 * 食堂成本信息取得
	 * @return 食堂成本信息
	 */
	public Eatery getEatery() {
		return eatery;
	}

	/**
	 * 食堂成本信息设定
	 * @param eatery 食堂成本信息
	 */
	public void setEatery(Eatery eatery) {
		this.eatery = eatery;
	}
	
	/**
	 * 食堂工作餐信息取得
	 * @return 食堂工作餐信息
	 */
	public EworkingLunch getEworkingLunch() {
		return eworkingLunch;
	}

	/**
	 * 食堂工作餐信息设定
	 * @param eworkingLunch 食堂工作餐信息
	 */
	public void setEworkingLunch(EworkingLunch eworkingLunch) {
		this.eworkingLunch = eworkingLunch;
	}
	
	/**
	 * 食堂接待信息取得
	 * @return 食堂接待信息
	 */
	public Eentertainment getEentertainment() {
		return eentertainment;
	}

	/**
	 * 食堂接待信息设定
	 * @param eentertainment 食堂接待信息
	 */
	public void setEentertainment(Eentertainment eentertainment) {
		this.eentertainment = eentertainment;
	}
	
	/**
	 * 工作餐成本统计信息取得
	 * @return 工作餐成本统计信息
	 */
	public WorkLunchEatery getWorkLunchEatery() {
		return workLunchEatery;
	}

	/**
	 * 工作餐成本统计信息设定
	 * @param eentertainment 工作餐成本统计信息
	 */
	public void setWorkLunchEatery(WorkLunchEatery workLunchEatery) {
		this.workLunchEatery = workLunchEatery;
	}
	
	/**
	 * 接待统计信息取得
	 * @return 接待统计信息
	 */
	public EentertainmentStatistics getEentertainmentStatistics() {
		return eentertainmentStatistics;
	}

	/**
	 * 接待统计信息设定
	 * @param eentertainmentStatistics 接待统计信息
	 */
	public void setEentertainmentStatistics(EentertainmentStatistics eentertainmentStatistics) {
		this.eentertainmentStatistics = eentertainmentStatistics;
	}
	
	/**
	 * 部门接待统计信息取得
	 * @return 部门接待统计信息
	 */
	public DeptEentertainment getDeptEentertainment() {
		return deptEentertainment;
	}

	/**
	 * 部门接待统计信息设定
	 * @param deptEentertainment 部门接待统计信息
	 */
	public void setDeptEentertainment(DeptEentertainment deptEentertainment) {
		this.deptEentertainment = deptEentertainment;
	}
	
	/**
	 * 库存统计信息取得
	 * @return 库存统计信息
	 */
	public GoodsStock getGoodsStock() {
		return goodsStock;
	}

	/**
	 * 库存统计信息设定
	 * @param goodsStock 库存统计信息
	 */
	public void setGoodsStock(GoodsStock goodsStock) {
		this.goodsStock = goodsStock;
	}
	
	/**
	 * 单一物品库存统计信息取得
	 * @return 单一物品库存统计信息
	 */
	public SingleGoodsStock getSingleGoodsStock() {
		return singleGoodsStock;
	}

	/**
	 * 单一物品库存统计信息设定
	 * @param goodsStock 单一物品库存统计信息
	 */
	public void setSingleGoodsStock(SingleGoodsStock singleGoodsStock) {
		this.singleGoodsStock = singleGoodsStock;
	}
	
	/**
	 * 餐卡信息取得
	 * @return 餐卡信息
	 */
	public ItemsCodesSt getItemsCodes() {
		return itemsCodes;
	}

	/**
	 * 餐卡信息设定
	 * @param itemsCodes 餐卡信息
	 */
	public void setItemsCodes(ItemsCodesSt itemsCodes) {
		this.itemsCodes = itemsCodes;
	}

	/**
	 * 食堂成本信息搜索结果集取得
	 * @return 食堂成本信息搜索结果集
	 */
	public List<Eatery> getEateryList() {
		return eateryList;
	}

	/**
	 * 食堂成本信息搜索结果集设定
	 * @param eateryList 食堂成本信息搜索结果集
	 */
	public void setEateryList(List<Eatery> eateryList) {
		this.eateryList = eateryList;
	}
	
	/**
	 * 食堂工作餐信息搜索结果集取得
	 * @return 食堂工作餐信息搜索结果集
	 */
	public List<EworkingLunch> getEworkingLunchList() {
		return eworkingLunchList;
	}

	/**
	 * 食堂工作餐信息搜索结果集设定
	 * @param eworkingLunchList 食堂工作餐信息搜索结果集
	 */
	public void setEworkingLunchList(List<EworkingLunch> eworkingLunchList) {
		this.eworkingLunchList = eworkingLunchList;
	}
	
	/**
	 * 食堂接待信息搜索结果集取得
	 * @return 食堂接待信息搜索结果集
	 */
	public List<Eentertainment> getEentertainmentList() {
		return eentertainmentList;
	}

	/**
	 * 食堂接待信息搜索结果集设定
	 * @param eworkingLunchList 食堂接待信息搜索结果集
	 */
	public void setEentertainmentList(List<Eentertainment> eentertainmentList) {
		this.eentertainmentList = eentertainmentList;
	}
	
	/**
	 * 工作餐成本统计信息搜索结果集取得
	 * @return 工作餐成本统计信息搜索结果集
	 */
	public List<WorkLunchEatery> getWorkLunchEateryList() {
		return workLunchEateryList;
	}

	/**
	 * 工作餐成本统计信息搜索结果集设定
	 * @param eworkingLunchList 工作餐成本统计信息搜索结果集
	 */
	public void setWorkLunchEateryList(List<WorkLunchEatery> workLunchEateryList) {
		this.workLunchEateryList = workLunchEateryList;
	}
	
	/**
	 * 接待统计信息搜索结果集取得
	 * @return 接待统计信息搜索结果集
	 */
	public List<EentertainmentStatistics> getEentertainmentStatisticsList() {
		return eentertainmentStatisticsList;
	}

	/**
	 * 接待统计信息搜索结果集设定
	 * @param eworkingLunchList 接待统计信息搜索结果集
	 */
	public void setDeptEentertainmentList(List<DeptEentertainment> deptEentertainmentList) {
		this.deptEentertainmentList = deptEentertainmentList;
	}
	
	/**
	 * 部门接待统计信息搜索结果集取得
	 * @return 部门接待统计信息搜索结果集
	 */
	public List<DeptEentertainment> getDeptEentertainmentList() {
		return deptEentertainmentList;
	}

	/**
	 * 部门接待统计信息搜索结果集设定
	 * @param eworkingLunchList 部门接待统计信息搜索结果集
	 */
	public void setEentertainmentStatisticsList(List<EentertainmentStatistics> eentertainmentStatisticsList) {
		this.eentertainmentStatisticsList = eentertainmentStatisticsList;
	}
	
	/**
	 * 库存统计信息搜索结果集取得
	 * @return 库存统计信息搜索结果集
	 */
	public List<GoodsStock> getGoodsStockList() {
		return goodsStockList;
	}

	/**
	 * 库存统计信息搜索结果集设定
	 * @param goodsStockList 库存统计信息搜索结果集
	 */
	public void setGoodsStockList(List<GoodsStock> goodsStockList) {
		this.goodsStockList = goodsStockList;
	}
	
	/**
	 * 单一物品库存统计信息搜索结果集取得
	 * @return 单一物品库存统计信息搜索结果集
	 */
	public List<SingleGoodsStock> getSingleGoodsStockList() {
		return singleGoodsStockList;
	}

	/**
	 * 单一物品库存统计信息搜索结果集设定
	 * @param goodsStockList 单一物品库存统计信息搜索结果集
	 */
	public void setSingleGoodsStockList(List<SingleGoodsStock> singleGoodsStockList) {
		this.singleGoodsStockList = singleGoodsStockList;
	}
	
	/**
	 * 餐卡信息搜索结果集取得
	 * @return 餐卡信息搜索结果集
	 */
	public List<ItemsCodesSt> getItemsCodesList() {
		return itemsCodesList;
	}

	/**
	 * 餐卡信息搜索结果集设定
	 * @param itemsCodesList 餐卡信息搜索结果集
	 */
	public void setItemsCodesList(List<ItemsCodesSt> itemsCodesList) {
		this.itemsCodesList = itemsCodesList;
	}

	public Map<String, IGLOM05141VO> getMap() {
		return map;
	}

	public void setMap(Map<String, IGLOM05141VO> map) {
		this.map = map;
	}

	public String getInnum() {
		return innum;
	}

	public void setInnum(String innum) {
		this.innum = innum;
	}

	public String getOutnum() {
		return outnum;
	}

	public void setOutnum(String outnum) {
		this.outnum = outnum;
	}

	public String getNownum() {
		return nownum;
	}

	public void setNownum(String nownum) {
		this.nownum = nownum;
	}

	public Map<String, IGLOM05051VO> getMapel() {
		return mapel;
	}

	public void setMapel(Map<String, IGLOM05051VO> mapel) {
		this.mapel = mapel;
	}
	public EEOrgVWSearchCond getEeOrgVWSearchCond() {
		return eeOrgVWSearchCond;
	}

	public void setEeOrgVWSearchCond(EEOrgVWSearchCond eeOrgVWSearchCond) {
		this.eeOrgVWSearchCond = eeOrgVWSearchCond;
	}

	public List<EEOrg> getEeOrgVWList() {
		return eeOrgVWList;
	}

	public void setEeOrgVWList(List<EEOrg> eeOrgVWList) {
		this.eeOrgVWList = eeOrgVWList;
	}

	public EESearchCond getEeSearchCond() {
		return eeSearchCond;
	}

	public void setEeSearchCond(EESearchCond eeSearchCond) {
		this.eeSearchCond = eeSearchCond;
	}

	public GoutDetailSearchCond getGoutDetailSearchCond() {
		return goutDetailSearchCond;
	}

	public void setGoutDetailSearchCond(GoutDetailSearchCond goutDetailSearchCond) {
		this.goutDetailSearchCond = goutDetailSearchCond;
	}

	public List<GoutDetailInfo> getGoutDetailInfoList() {
		return goutDetailInfoList;
	}

	public void setGoutDetailInfoList(List<GoutDetailInfo> goutDetailInfoList) {
		this.goutDetailInfoList = goutDetailInfoList;
	}

}
