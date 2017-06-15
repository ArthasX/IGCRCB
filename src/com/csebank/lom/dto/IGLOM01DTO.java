/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.form.IGLOM0102Form;
import com.csebank.lom.form.IGLOM0103Form;
import com.csebank.lom.form.IGLOM0104Form;
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.form.IGLOM0109Form;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealAmount;
import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.csebank.lom.model.condition.DealSearchCond;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * 接待管理DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM01DTO extends BaseDTO implements Serializable {
	

	/** 接待管理查询条件 */
	protected RecptionSearchCond recptionSearchCond;

	/** 接待客人管理查询条件 */
	protected RecptionGuestSearchCond recptionGuestSearchCond;
	
	/** 接待统计查询条件 */
	protected RecptionVWSearchCond recptionVWSearchCond;
	
	/** 部门接待统计查询条件 */
	protected RecptionOrgVWSearchCond recptionOrgVWSearchCond;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 接待信息最大检索件数 */
	protected int maxSearchCount;
	
	/** 接待信息Form */
	protected IGLOM0101Form iglom0101Form;
	
	/** 接待客人Form */
	protected IGLOM0102Form iglom0102Form;
	
	/** 接待工作管理Form */
	protected IGLOM0103Form iglom0103Form;
	
	/** 接待客人管理Form */
	protected IGLOM0104Form iglom0104Form;
	
	/** 接待工作 */
	protected Recption recption;
	
	/** 接待工作搜索结果集 */
	protected List<Recption> recptionList;
	
	/** 接待客人 */
	protected RecptionGuest recptionGuest;
	
	/** 接待客人搜索结果集 */
	protected List<RecptionGuest> recptionGuestList;
	
	/** 接待统计搜索结果集 */
	protected List<RecptionVWInfo> recptionVWList;
	
	/** 部门接待统计搜索结果集 */
	protected List<RecptionOrg> recptionOrgVWList;
	
	/** 接待客人搜索结果集(费用) */
	protected List<RecptionAmount> recptionAmountList;
	/** 接待客人搜索结果集(费用) */
	protected List<DealAmount> dealAmountList;
	
	/** 主要申请机构名称 */
	protected String rapporgname;
	
	/** 接待工作删除对象 */
	protected String[] deleteRid;
	
	/** 接待客人删除对象 */
	protected String[] deleteRgid;
	
	/** 接待工作信息 */
	protected Recption recptionData;
	
	/** 接待客人查询条件 */
	protected RecptionGuestInfoCond recptionguestinfoCond;
	
	/** 接待工作和费用统计搜索结果集 */
	protected List<RecptionCost> recptionCostList;
	
	/** 接待客人和接待工作搜索结果集 */
	protected List<GuestRecption> guestRecptionList;
	
	
	protected DealOrgVWSearchCond dealOrgVWSearchCond;
	protected List<DealOrg> dealOrgVWList;
	protected DealSearchCond dealSearchCond;
	protected List<Deal> dealList;
	//外出就餐实体
	protected Deal deal;
	/** 接待统计搜索结果集 */
	protected List<DealVWInfo> dealVWList;
	/** 接待统计查询条件 */
	protected DealVWSearchCond dealVWSearchCond;
	/** 外出就餐信息Form */
	protected IGLOM0115Form iglom0115Form;
	protected IGLOM0107Form iglom0107Form;
	
	
	/** 接待客人查询信息Form */
	protected IGLOM0109Form iglom0109Form;

	/** 接待客人查询搜索结果集 */
	protected List<RecptionGuestInfo> recptionguestInfo;
	
	/** 发票工作 */
	protected RecptionGuestInfo recptionguest;
	
	/**
	 * 接待客人和接待工作搜索结果集取得
	 * @return 接待客人和接待工作搜索结果集
	 */
	public List<GuestRecption> getGuestRecptionList() {
		return guestRecptionList;
	}
	
	/**
	 * 接待客人和接待工作搜索结果集设定
	 * @param guestRecptionList 接待客人和接待工作搜索结果集
	 */
	public void setGuestRecptionList(List<GuestRecption> guestRecptionList) {
		this.guestRecptionList = guestRecptionList;
	}
	
	/**
	 * 接待工作和费用统计搜索结果集取得
	 * @return 接待工作和费用统计搜索结果集
	 */
	public List<RecptionCost> getRecptionCostList() {
		return recptionCostList;
	}
	/**
	 * 接待工作和费用统计搜索结果集设定
	 * @param recptionCostList 接待工作和费用统计搜索结果集
	 */
	public void setRecptionCostList(List<RecptionCost> recptionCostList) {
		this.recptionCostList = recptionCostList;
	}

	/**
	 * 接待管理查询条件取得
	 * @return 接待管理查询条件
	 */
	public RecptionSearchCond getRecptionSearchCond() {
		return recptionSearchCond;
	}

	
	/**
	 * 接待管理查询条件设定
	 * @param recptionSearchCond 接待管理查询条件设定
	 */
	public void setRecptionSearchCond(RecptionSearchCond recptionSearchCond) {
		this.recptionSearchCond = recptionSearchCond;
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
	 * 接待信息最大检索件数取得
	 * @return 接待信息最大检索件数取得
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 接待信息最大检索件数设定
	 * @param maxSearchCount 接待信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 接待信息Form取得
	 * @return 接待信息Form
	 */
	public IGLOM0101Form getIglom0101Form() {
		return iglom0101Form;
	}

	/**
	 * 接待信息Form设定
	 * @param igLOM0101Form 接待信息Form
	 */
	public void setIglom0101Form(IGLOM0101Form iglom0101Form) {
		this.iglom0101Form = iglom0101Form;
	}

	/**
	 * 接待工作取得
	 * @return 接待工作
	 */
	public Recption getRecption() {
		return recption;
	}

	/**
	 * 接待工作设定
	 * @param recption 接待工作
	 */
	public void setRecption(Recption recption) {
		this.recption = recption;
	}

	/**
	 * 接待工作搜索结果集取得
	 * @return 接待工作搜索结果集
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * 接待工作搜索结果集设定
	 * @param recptionList 接待工作搜索结果集
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}

	/**
	 * 接待工作管理Form取得
	 * @return 接待工作管理Form
	 */
	public IGLOM0103Form getIglom0103Form() {
		return iglom0103Form;
	}

	/**
	 * 接待工作管理Form设定
	 * @param iglom0103Form 接待工作管理Form
	 */
	public void setIglom0103Form(IGLOM0103Form iglom0103Form) {
		this.iglom0103Form = iglom0103Form;
	}

	/**
	 * 主要申请机构名称取得
	 * @return 主要申请机构名称
	 */
	public String getRapporgname() {
		return rapporgname;
	}

	/**
	 * 主要申请机构名称设定
	 * @param rapporgname 主要申请机构名称
	 */
	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	/**
	 * 接待工作删除对象取得
	 * @return 接待工作删除对象
	 */
	public String[] getDeleteRid() {
		return deleteRid;
	}

	/**
	 * 接待工作删除对象设定
	 * @param deleteRid 接待工作删除对象
	 */
	public void setDeleteRid(String[] deleteRid) {
		this.deleteRid = deleteRid;
	}


	/**
	 * 接待客人登记Form取得
	 * @return 接待客人登记Form
	 */
	public IGLOM0102Form getIglom0102Form() {
		return iglom0102Form;
	}

	/**
	 * 接待客人登记Form设定
	 * @param iglom0102Form 接待客人登记Form
	 */
	public void setIglom0102Form(IGLOM0102Form iglom0102Form) {
		this.iglom0102Form = iglom0102Form;
	}

	/**
	 * 接待客人取得
	 * @return 接待客人
	 */
	public RecptionGuest getRecptionGuest() {
		return recptionGuest;
	}

	/**
	 * 接待客人设定
	 * @param recptionGuest 接待客人
	 */
	public void setRecptionGuest(RecptionGuest recptionGuest) {
		this.recptionGuest = recptionGuest;
	}

	/**
	 * 接待客人搜索结果集取得
	 * @return 接待客人搜索结果集
	 */
	public List<RecptionGuest> getRecptionGuestList() {
		return recptionGuestList;
	}

	/**
	 * 接待客人搜索结果集设定
	 * @param recptionGuestList 接待客人搜索结果集
	 */
	public void setRecptionGuestList(List<RecptionGuest> recptionGuestList) {
		this.recptionGuestList = recptionGuestList;
	}

	/**
	 * 接待客人删除对象取得
	 * @return 接待客人删除对象
	 */
	public String[] getDeleteRgid() {
		return deleteRgid;
	}

	/**
	 * 接待客人删除对象设定
	 * @param deleteRgid 接待客人删除对象
	 */
	public void setDeleteRgid(String[] deleteRgid) {
		this.deleteRgid = deleteRgid;
	}

	/**
	 * 接待客人管理查询条件取得
	 * @return 接待客人管理查询条件
	 */
	public RecptionGuestSearchCond getRecptionGuestSearchCond() {
		return recptionGuestSearchCond;
	}

	/**
	 * 接待客人管理查询条件设定
	 * @param recptionGuestSearchCond 接待客人管理查询条件
	 */
	public void setRecptionGuestSearchCond(
			RecptionGuestSearchCond recptionGuestSearchCond) {
		this.recptionGuestSearchCond = recptionGuestSearchCond;
	}

	/**
	 * 接待客人管理Form取得
	 * @return 接待客人管理Form
	 */
	public IGLOM0104Form getIglom0104Form() {
		return iglom0104Form;
	}

	/**
	 * 接待客人管理Form设定
	 * @param iglom0104Form 接待客人管理Form
	 */
	public void setIglom0104Form(IGLOM0104Form iglom0104Form) {
		this.iglom0104Form = iglom0104Form;
	}

	/**
	 * 接待工作信息取得
	 * @return 接待工作信息
	 */
	public Recption getRecptionData() {
		return recptionData;
	}

	/** 
	 * 接待工作信息设定
	 * @param recptionData 接待工作信息
	 */
	public void setRecptionData(Recption recptionData) {
		this.recptionData = recptionData;
	}

	/**
	 * 接待统计搜索结果集取得
	 * @return 接待统计搜索结果集
	 */
	public List<RecptionVWInfo> getRecptionVWList() {
		return recptionVWList;
	}

	/**
	 * 接待统计搜索结果集设定
	 * @param recptionVWList 接待统计搜索结果集
	 */
	public void setRecptionVWList(List<RecptionVWInfo> recptionVWList) {
		this.recptionVWList = recptionVWList;
	}

	/**
	 * 接待统计查询条件取得
	 * @return 接待统计查询条件
	 */
	public RecptionVWSearchCond getRecptionVWSearchCond() {
		return recptionVWSearchCond;
	}

	/**
	 * 接待统计查询条件设定
	 * @param recptionVWSearchCond 接待统计查询条件
	 */
	public void setRecptionVWSearchCond(RecptionVWSearchCond recptionVWSearchCond) {
		this.recptionVWSearchCond = recptionVWSearchCond;
	}

	/**
	 * 部门接待统计查询条件取得
	 * @return 部门接待统计查询条件
	 */
	public RecptionOrgVWSearchCond getRecptionOrgVWSearchCond() {
		return recptionOrgVWSearchCond;
	}

	/**
	 * 部门接待统计查询条件设定
	 * @param recptionOrgVWSearchCond 部门接待统计查询条件
	 */
	public void setRecptionOrgVWSearchCond(
			RecptionOrgVWSearchCond recptionOrgVWSearchCond) {
		this.recptionOrgVWSearchCond = recptionOrgVWSearchCond;
	}


	/**
	 * 部门接待统计搜索结果集取得
	 * @return 部门接待统计搜索结果集
	 */
	public List<RecptionOrg> getRecptionOrgVWList() {
		return recptionOrgVWList;
	}

	/**
	 * 部门接待统计搜索结果集设定
	 * @param recptionOrgVWList 部门接待统计搜索结果集
	 */
	public void setRecptionOrgVWList(List<RecptionOrg> recptionOrgVWList) {
		this.recptionOrgVWList = recptionOrgVWList;
	}
	
	/**
	 * 接待管理查询条件取得
	 * @return
	 */
	public RecptionGuestInfoCond getRecptionGuestInfoCond() {
		return recptionguestinfoCond;
	}

	/**
	 * 接待管理查询条件设定
	 * @param recptionSearchCond 接待管理查询条件设定
	 */
	public void setRecptionGuestInfoCond(RecptionGuestInfoCond recptionguestinfoCond) {
		this.recptionguestinfoCond = recptionguestinfoCond;
	}

	public List<RecptionAmount> getRecptionAmountList() {
		return recptionAmountList;
	}

	public void setRecptionAmountList(List<RecptionAmount> recptionAmountList) {
		this.recptionAmountList = recptionAmountList;
	}

	public DealOrgVWSearchCond getDealOrgVWSearchCond() {
		return dealOrgVWSearchCond;
	}

	public void setDealOrgVWSearchCond(DealOrgVWSearchCond dealOrgVWSearchCond) {
		this.dealOrgVWSearchCond = dealOrgVWSearchCond;
	}

	public List<DealOrg> getDealOrgVWList() {
		return dealOrgVWList;
	}

	public void setDealOrgVWList(List<DealOrg> dealOrgVWList) {
		this.dealOrgVWList = dealOrgVWList;
	}

	public DealSearchCond getDealSearchCond() {
		return dealSearchCond;
	}

	public void setDealSearchCond(DealSearchCond dealSearchCond) {
		this.dealSearchCond = dealSearchCond;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public List<DealVWInfo> getDealVWList() {
		return dealVWList;
	}

	public void setDealVWList(List<DealVWInfo> dealVWList) {
		this.dealVWList = dealVWList;
	}

	public DealVWSearchCond getDealVWSearchCond() {
		return dealVWSearchCond;
	}

	public void setDealVWSearchCond(DealVWSearchCond dealVWSearchCond) {
		this.dealVWSearchCond = dealVWSearchCond;
	}

	public IGLOM0115Form getIglom0115Form() {
		return iglom0115Form;
	}

	public void setIglom0115Form(IGLOM0115Form iglom0115Form) {
		this.iglom0115Form = iglom0115Form;
	}

	public IGLOM0107Form getIglom0107Form() {
		return iglom0107Form;
	}

	public void setIglom0107Form(IGLOM0107Form iglom0107Form) {
		this.iglom0107Form = iglom0107Form;
	}

	public List<DealAmount> getDealAmountList() {
		return dealAmountList;
	}

	public void setDealAmountList(List<DealAmount> dealAmountList) {
		this.dealAmountList = dealAmountList;
	}
	
	

	/**
	 * 接待客人查询Form取得
	 * @return 接待客人查询Form
	 */
	public IGLOM0109Form getIglom0109Form() {
		return iglom0109Form;
	}

	/**
	 * 接待客人查询Form设定
	 * @param iglom0109Form 接待客人查询Form
	 */
	public void setIglom0109Form(IGLOM0109Form iglom0109Form) {
		this.iglom0109Form = iglom0109Form;
	}
	
	/**
	 * 接待客人查询搜索结果集
	 * @return 发票信息搜索结果集
	 */
	public List<RecptionGuestInfo> getRecptionGuestInfoList() {
		return recptionguestInfo;
	}

	/**
	 * 接待客人查询搜索结果集
	 * @param recptionList 接待客人查询搜索结果集
	 */
	public void setRecptionGuestInfoList(List<RecptionGuestInfo> recptionguestInfo) {
		this.recptionguestInfo = recptionguestInfo;
	}
	
	/**
	 * 接待客人查询
	 * @return 发票工作
	 */
	public RecptionGuestInfo getRecptionGuestInfo() {
		return recptionguest;
	}

	/**
	 * 接待客人查询
	 * @param recption 接待客人查询
	 */
	public void setRecptionGuestInfo(RecptionGuestInfo recptionguest) {
		this.recptionguest = recptionguest;
	}
}
