/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.form.IGLOM0201Form;
import com.csebank.lom.form.IGLOM0202Form;
import com.csebank.lom.form.IGLOM0203Form;
import com.csebank.lom.form.IGLOM0204Form;
import com.csebank.lom.form.IGLOM0205Form;
import com.csebank.lom.form.IGLOM0208Form;
import com.csebank.lom.form.IGLOM0211Form;
import com.csebank.lom.form.IGLOM0212Form;
import com.csebank.lom.form.IGLOM0213Form;
import com.csebank.lom.form.IGLOM0214Form;
import com.csebank.lom.form.IGLOM0215Form;
import com.csebank.lom.form.IGLOM0216Form;
import com.csebank.lom.form.IGLOM0218Form;
import com.csebank.lom.form.IGLOM0220Form;
import com.csebank.lom.form.IGLOM0219Form;
import com.csebank.lom.form.IGLOM0512Form;
import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.Goods;
import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * 
 * 接待管理DTO
 *
 */
public class IGLOM02DTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = 5935839229364287442L;
	
	/** 用户 */
	private User user;
	
	private IGLOM0201Form iglom0201Form;
	
	private IGLOM0205Form iglom0205Form;
	
	private IGLOM0202Form iglom0202Form;
	
	private IGLOM0203Form iglom0203Form;
	
	private IGLOM0204Form iglom0204Form;
	
	private IGLOM0208Form iglom0208Form;
	
	private IGLOM0213Form iglom0213Form;
	
	private IGLOM0214Form iglom0214Form;
	
	/** 食堂领用Form */
	protected IGLOM0512Form iglom0512Form;
	
	private Goods goods;
	
	private IGLOM0211Form iglom0211Form;
	
	private IGLOM0212Form iglom0212Form;
	
	private IGLOM0215Form iglom0215Form;
	
	private IGLOM0216Form iglom0216Form;
	
	private IGLOM0218Form iglom0218Form;
	
	private IGLOM0220Form iglom0220Form;
	
	/** 每月盘点查询结果集 */
	private List<Inventory> InventoryList;
	
	private InventorySearchCond inventorySearchCond;
	
	private IGLOM0219Form iglom0219Form;
	
	private GinoutstockdetailSearchCond gIOStockDetailCond;
	
	private GoutstockSearchCond goutstockSearchCond;
	
	private GoutstockVWSearchCond goutstockVWSearchCond;
	
	private List<Ginoutstockdetail> gIOStockDetailList;
	
	private List<GinoutStockDetailVW> ginoutStockDetailVWList;
	

	/** 所属机构查询 */
	private String org_q;
	
	/** 物品种类*/
	private String gcategory;
	
	/** 物品编号 */
	private String gcode;
	
	/** 物品名称 */
	private String gname;
	
	private Integer[] totalStockNum;

	/** 物品集合 */
	private List<Goods> goodsList;
	
	/** 库存物品集合 */
	private List<Gstock> gstockList;
	
	/** 可领用物品信息集合 */
	private List<GoutstockVWInfo> goutstockList;
	
	/** 库存物品集合(库存预警查询使用) */
	private List<GstockVWInfo> gstockVWList;
	
	/** 返回错误页标识 */
	private String gotoError;
	
	/** 已领用物品信息集合 */
	private List<Goutstock> goutstockTBList;
	private List<Goutstock> goutstockTBListall;
	
	/** 已领用物品信息集合 */
	private List<GoutstockVWInfo> goutstockVWList;

	/**
	 * 允许查询的最大记录数
	 */
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	protected PagingDTO pagingDto;
	
	
	
	/**
	 * @return the goutstockVWList
	 */
	public List<GoutstockVWInfo> getGoutstockVWList() {
		return goutstockVWList;
	}

	/**
	 * @param goutstockVWList the goutstockVWList to set
	 */
	public void setGoutstockVWList(List<GoutstockVWInfo> goutstockVWList) {
		this.goutstockVWList = goutstockVWList;
	}

	/**
	 * 食堂领用Form取得
	 * @return 食堂领用Form
	 */ 
	public IGLOM0512Form getIglom0512Form() {
		return iglom0512Form;
	}

 	/**
	 * 食堂领用Form设定
	 * @param iglom0512Form 食堂领用Form
	 */
	public void setIglom0512Form(IGLOM0512Form iglom0512Form) {
		this.iglom0512Form = iglom0512Form;
	}

	
	/**
	 * @return the goutstockVWSearchCond
	 */
	public GoutstockVWSearchCond getGoutstockVWSearchCond() {
		return goutstockVWSearchCond;
	}

	/**
	 * @param goutstockVWSearchCond the goutstockVWSearchCond to set
	 */
	public void setGoutstockVWSearchCond(GoutstockVWSearchCond goutstockVWSearchCond) {
		this.goutstockVWSearchCond = goutstockVWSearchCond;
	}

	/**
	 * @return the iglom0214Form
	 */
	public IGLOM0214Form getIglom0214Form() {
		return iglom0214Form;
	}

	/**
	 * @param iglom0214Form the iglom0214Form to set
	 */
	public void setIglom0214Form(IGLOM0214Form iglom0214Form) {
		this.iglom0214Form = iglom0214Form;
	}

	/**
	 * @return the goutstockTBList
	 */
	public List<Goutstock> getGoutstockTBList() {
		return goutstockTBList;
	}

	/**
	 * @param goutstockTBList the goutstockTBList to set
	 */
	public void setGoutstockTBList(List<Goutstock> goutstockTBList) {
		this.goutstockTBList = goutstockTBList;
	}

	/**
	 * @return the gstockVWList
	 */
	public List<GstockVWInfo> getGstockVWList() {
		return gstockVWList;
	}

	/**
	 * @param gstockVWList the gstockVWList to set
	 */
	public void setGstockVWList(List<GstockVWInfo> gstockVWList) {
		this.gstockVWList = gstockVWList;
	}

	/**
	 * @return the iglom0213Form
	 */
	public IGLOM0213Form getIglom0213Form() {
		return iglom0213Form;
	}

	/**
	 * @param iglom0213Form the iglom0213Form to set
	 */
	public void setIglom0213Form(IGLOM0213Form iglom0213Form) {
		this.iglom0213Form = iglom0213Form;
	}

	/**
	 * @return the iglom0208Form
	 */
	public IGLOM0208Form getIglom0208Form() {
		return iglom0208Form;
	}

	/**
	 * @param iglom0208Form the iglom0208Form to set
	 */
	public void setIglom0208Form(IGLOM0208Form iglom0208Form) {
		this.iglom0208Form = iglom0208Form;
	}

	/**
	 * @return the goutstockList
	 */
	public List<GoutstockVWInfo> getGoutstockList() {
		return goutstockList;
	}

	/**
	 * @param goutstockList the goutstockList to set
	 */
	public void setGoutstockList(List<GoutstockVWInfo> goutstockList) {
		this.goutstockList = goutstockList;
	}

	/**
	 * @return the gstockList
	 */
	public List<Gstock> getGstockList() {
		return gstockList;
	}

	/**
	 * @param gstockList the gstockList to set
	 */
	public void setGstockList(List<Gstock> gstockList) {
		this.gstockList = gstockList;
	}

	/**
	 * @return the gotoError
	 */
	public String getGotoError() {
		return gotoError;
	}

	/**
	 * @param gotoError the gotoError to set
	 */
	public void setGotoError(String gotoError) {
		this.gotoError = gotoError;
	}

	/**
	 * 用户取得
	 * @return 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户设定
	 * @param 用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	/**
	 * @return the iglom0205Form
	 */
	public IGLOM0205Form getIglom0205Form() {
		return iglom0205Form;
	}

	/**
	 * @param iglom0205Form the iglom0205Form to set
	 */
	public void setIglom0205Form(IGLOM0205Form iglom0205Form) {
		this.iglom0205Form = iglom0205Form;
	}

	/**
	 * @return the goodsList
	 */
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return the gcategory
	 */
	public String getGcategory() {
		return gcategory;
	}

	/**
	 * @param gcategory the gcategory to set
	 */
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	/**
	 * @return the gcode
	 */
	public String getGcode() {
		return gcode;
	}

	/**
	 * @param gcode the gcode to set
	 */
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	/**
	 * @return the org_q
	 */
	public String getOrg_q() {
		return org_q;
	}

	/**
	 * @param org_q the org_q to set
	 */
	public void setOrg_q(String org_q) {
		this.org_q = org_q;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * @param pagingDto the pagingDto to set
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	

	public IGLOM0201Form getIglom0201Form() {
		return iglom0201Form;
	}

	public void setIglom0201Form(IGLOM0201Form iglom0201Form) {
		this.iglom0201Form = iglom0201Form;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public IGLOM0202Form getIglom0202Form() {
		return iglom0202Form;
	}

	public void setIglom0202Form(IGLOM0202Form iglom0202Form) {
		this.iglom0202Form = iglom0202Form;
	}

	public IGLOM0203Form getIglom0203Form() {
		return iglom0203Form;
	}

	public void setIglom0203Form(IGLOM0203Form iglom0203Form) {
		this.iglom0203Form = iglom0203Form;
	}

	public IGLOM0204Form getIglom0204Form() {
		return iglom0204Form;
	}

	public void setIglom0204Form(IGLOM0204Form iglom0204Form) {
		this.iglom0204Form = iglom0204Form;
	}

	public List<Ginoutstockdetail> getGIOStockDetailList() {
		return gIOStockDetailList;
	}

	public void setGIOStockDetailList(List<Ginoutstockdetail> stockDetailList) {
		gIOStockDetailList = stockDetailList;
	}

	public GinoutstockdetailSearchCond getGIOStockDetailCond() {
		return gIOStockDetailCond;
	}

	public void setGIOStockDetailCond(GinoutstockdetailSearchCond stockDetailCond) {
		gIOStockDetailCond = stockDetailCond;
	}

	public IGLOM0211Form getIglom0211Form() {
		return iglom0211Form;
	}

	public void setIglom0211Form(IGLOM0211Form iglom0211Form) {
		this.iglom0211Form = iglom0211Form;
	}

	public GoutstockSearchCond getGoutstockSearchCond() {
		return goutstockSearchCond;
	}

	public void setGoutstockSearchCond(GoutstockSearchCond goutstockSearchCond) {
		this.goutstockSearchCond = goutstockSearchCond;
	}

	
	public IGLOM0212Form getIglom0212Form() {
		return iglom0212Form;
	}

	public void setIglom0212Form(IGLOM0212Form iglom0212Form) {
		this.iglom0212Form = iglom0212Form;
	}

	public IGLOM0215Form getIglom0215Form() {
		return iglom0215Form;
	}

	public void setIglom0215Form(IGLOM0215Form iglom0215Form) {
		this.iglom0215Form = iglom0215Form;
	}

	public IGLOM0216Form getIglom0216Form() {
		return iglom0216Form;
	}

	public void setIglom0216Form(IGLOM0216Form iglom0216Form) {
		this.iglom0216Form = iglom0216Form;
	}

	public Integer[] getTotalStockNum() {
		return totalStockNum;
	}

	public void setTotalStockNum(Integer[] totalStockNum) {
		this.totalStockNum = totalStockNum;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public IGLOM0218Form getIglom0218Form() {
		return iglom0218Form;
	}

	public void setIglom0218Form(IGLOM0218Form iglom0218Form) {
		this.iglom0218Form = iglom0218Form;
	}

	public List<GinoutStockDetailVW> getGinoutStockDetailVWList() {
		return ginoutStockDetailVWList;
	}

	public void setGinoutStockDetailVWList(
			List<GinoutStockDetailVW> ginoutStockDetailVWList) {
		this.ginoutStockDetailVWList = ginoutStockDetailVWList;
	}

	/**
	 * @return iglom0220Form
	 */
	public IGLOM0220Form getIglom0220Form() {
		return iglom0220Form;
	}

	/**
	 * @param iglom0220Form
	 */
	public void setIglom0220Form(IGLOM0220Form iglom0220Form) {
		this.iglom0220Form = iglom0220Form;
	}

	/**
	 * @return inventorySearchCond
	 */
	public InventorySearchCond getInventorySearchCond() {
		return inventorySearchCond;
	}

	/**
	 * @param inventorySearchCond
	 */
	public void setInventorySearchCond(InventorySearchCond inventorySearchCond) {
		this.inventorySearchCond = inventorySearchCond;
	}

	/**
	 * @return InventoryList
	 */
	public List<Inventory> getInventoryList() {
		return InventoryList;
	}

	/**
	 * @param inventoryList
	 */
	public void setInventoryList(List<Inventory> inventoryList) {
		InventoryList = inventoryList;
	}
	

	public IGLOM0219Form getIglom0219Form() {
		return iglom0219Form;
	}

	public void setIglom0219Form(IGLOM0219Form iglom0219Form) {
		this.iglom0219Form = iglom0219Form;
	}

	public List<Goutstock> getGoutstockTBListall() {
		return goutstockTBListall;
	}

	public void setGoutstockTBListall(List<Goutstock> goutstockTBListall) {
		this.goutstockTBListall = goutstockTBListall;
	}


}
