/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.csebank.items.form.ITEMS0101Form;
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.form.ITEMS0110Form;
import com.csebank.items.form.ITEMS0111Form;
import com.csebank.items.form.ITEMS0115Form;
import com.csebank.items.form.ITEMS0116Form;
import com.csebank.items.form.ITEMS0121Form;
import com.csebank.items.form.ITEMS0126Form;
import com.csebank.items.form.ITEMS0136Form;
import com.csebank.items.form.ITEMS0141Form;
import com.csebank.items.form.ITEMS0142Form;
import com.csebank.items.form.ITEMS0143Form;
import com.csebank.items.form.ITEMS0144Form;
import com.csebank.items.form.ITEMS0145Form;
import com.csebank.items.form.ITEMS0146Form;
import com.csebank.items.form.ITEMS0147Form;
import com.csebank.items.form.ITEMS0148Form;
import com.csebank.items.form.ITEMS0174Form;
import com.csebank.items.form.ITEMS0175Form;
import com.csebank.items.model.InStock;
import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.OutStock;
import com.csebank.items.model.OutStockVWInfo;
import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.model.condition.OutStockSearchVWCond;
import com.csebank.items.model.condition.StockSearchCond;
import com.csebank.items.vo.ITEMS01692VO;
import com.csebank.items.vo.ITEMS01712VO;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCond;

public class ITEMS01DTO extends BaseDTO {

	private static final long serialVersionUID = 1250899278907842110L;

	private User user;
	private List<Organization> orgList;
	private String outstockorg;// 库存机构号
	private String userid;// 用户id
	private String username;// 用户name
	private String userorg;
	private Integer stockid;
	private Integer outstockid;
	private String category;
	private String seqcode;
	private String seqcode_q;
	/**
	 * 物品名称
	 */
	private String itemsname;
	private String itemsname_q;
	private String typecode;
	private String outtype;
	private String stockorg_q;
	protected String instockorg;
	protected String time_f;
	protected String time_t;
	private String typecode_q;
	private ItemsCategorySearchCond itemsCategorySearchCond;
	protected List<String> editList;//类别管理是否可见修改按钮（0不可见，1可见）
	
	private List<ItemsCategory> itemsCategoryList;
	private ItemsCategory itemsCategory;
	private InStock inStock;
	private List<InStock> inStockList;
	private Stock stock;
	private ITEMS0115Form items0115form;
	private ITEMS0116Form items0116form;
	private ITEMS0121Form items0121form;
	// stock表查询接口
	private StockSearchCond stockSearchCond;
	private ITEMS0106Form items0106form;
	private ITEMS0110Form items0110form;
	private ITEMS0111Form items0111form;
	private ITEMS0126Form items0126form;
	private ITEMS0101Form items0101form;
	
	// 物品申领
	private List<OutStockVWInfo> outStockList;
	private List<OutStock> osList;
	private List<Stock> stockList;
	private OutStockSearchCond outStockSearchCond;
	private ITEMS0141Form items0141form;
	private OutStock outStock;
	
	//申领审批
	private ITEMS0142Form items0142form;
	private OutStockSearchVWCond outStockSearchVWCond;
	private String goToError;//返回错误页用判断标识
	private List<Stock> exstockList;//保存被申领并且库存中存在的耗材
	
	//出库
	private ITEMS0143Form items0143form;
	
	//配送清单
	private ITEMS0148Form items0148form;
	Map<String,Map<String,String>> outmap;
	
	//接收
	private ITEMS0144Form items0144form;
	
	//下拨
	private ITEMS0145Form items0145form;
	private ITEMS0146Form items0146form;
	private ITEMS0147Form items0147form;
	
	private ITEMS0136Form items0136form;
	
	//机构下拨 
	private ITEMS0174Form items0174form;
	private ITEMS0175Form items0175form;
	/**
	 * 允许查询的最大记录数
	 */

	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */

	protected PagingDTO pagingDto;

	protected List<Integer> chknumList;
	protected String outstockorg_q;
	protected String accountstatus_q;
	protected String reqstatus;
	
	protected boolean showNoneStock = true;
	protected Map<String,String> editMap;//入库调整使用
	
	
	/** 仓库收益相关VO */
	protected List<ITEMS01692VO> items01692VOList;
	
	/** 物品收益相关VO */
	protected List<ITEMS01712VO> items01712VOList;
	
	/** 物品收益总计 */
	protected String total;
	
	protected ItemsPaySearchCond itemsPaySearchCond;
	
	protected OutStockDetailSearchCond outStockDetailSearchCond;
	
	

	
	/**
	 * 机构对象
	 */
	
	protected Organization organization;
	
	/**
	 * 机构对象List
	 */
	
	protected List<Organization> organizationCondList;
	
	/**
	 * 机构对象List（下拉列表用）
	 */
	
	protected List<Organization> organizationList;
	
	/**
	 * 机构删除主键
	 */
	
	protected String[] deleteOrgid;
	/**
	 * 机构状态变化主键
	 */
	
	protected  Integer changeOrgid;
	
	/**
	 * 每级机构的完整名称
	 */
	
	protected  Map<Integer,String> completenameMap;
	
	/**
	 * 每级机构是否显示停用按钮
	 */
	
	protected  Map<Integer,String> buttonMap;
	
	/**
	 * 每级机构是否显示启用按钮
	 */
	
	protected  Map<Integer,String> startbuttonMap;
	

	/** 库存统计--单价 */
	protected Double price;
	
	/** 库存统计--金额 */
	protected Double amount;
	
	protected OrganizationSearchCond organizationSearchCond;
	
	
	/**机构树*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	
	/**
	 * @return the itemsname
	 */
	public String getItemsname() {
		return itemsname;
	}
	/**
	 * @param itemsname the itemsname to set
	 */
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	/**
	 * @return the typecode_q
	 */
	public String getTypecode_q() {
		return typecode_q;
	}
	/**
	 * @param typecode_q the typecode_q to set
	 */
	public void setTypecode_q(String typecode_q) {
		this.typecode_q = typecode_q;
	}
	/**
	 * @return the typecode
	 */
	public String getTypecode() {
		return typecode;
	}
	/**
	 * @param typecode the typecode to set
	 */
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the editList
	 */
	public List<String> getEditList() {
		return editList;
	}
	/**
	 * @param editList the editList to set
	 */
	public void setEditList(List<String> editList) {
		this.editList = editList;
	}
	public List<ITEMS01692VO> getItems01692VOList() {
		return items01692VOList;
	}
	public void setItems01692VOList(List<ITEMS01692VO> items01692VOList) {
		this.items01692VOList = items01692VOList;
	}
	private List<ItemsPay> paymentList;
	
	public ITEMS0136Form getItems0136form() {
		return items0136form;
	}
	public void setItems0136form(ITEMS0136Form items0136form) {
		this.items0136form = items0136form;
	}
	public List<ItemsPay> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<ItemsPay> paymentList) {
		this.paymentList = paymentList;
	}
	public ItemsPaySearchCond getItemsPaySearchCond() {
		return itemsPaySearchCond;
	}
	public void setItemsPaySearchCond(ItemsPaySearchCond itemsPaySearchCond) {
		this.itemsPaySearchCond = itemsPaySearchCond;
	}
	/**
	 * @return the editMap
	 */
	public Map<String, String> getEditMap() {
		return editMap;
	}
	/**
	 * @param editMap the editMap to set
	 */
	public void setEditMap(Map<String, String> editMap) {
		this.editMap = editMap;
	}
	/**
	 * @return the outmap
	 */
	public Map<String, Map<String, String>> getOutmap() {
		return outmap;
	}
	/**
	 * @param outmap the outmap to set
	 */
	public void setOutmap(Map<String, Map<String, String>> outmap) {
		this.outmap = outmap;
	}
	/**
	 * @return the items0148form
	 */
	public ITEMS0148Form getItems0148form() {
		return items0148form;
	}
	/**
	 * @param items0148form the items0148form to set
	 */
	public void setItems0148form(ITEMS0148Form items0148form) {
		this.items0148form = items0148form;
	}
	public boolean isShowNoneStock() {
		return showNoneStock;
	}
	public void setShowNoneStock(boolean showNoneStock) {
		this.showNoneStock = showNoneStock;
	}
	
	/**
	 * @return the items0115form
	 */
	public ITEMS0115Form getItems0115form() {
		return items0115form;
	}

	/**
	 * @param items0115form the items0115form to set
	 */
	public void setItems0115form(ITEMS0115Form items0115form) {
		this.items0115form = items0115form;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public List<OutStock> getOsList() {
		return osList;
	}

	public void setOsList(List<OutStock> osList) {
		this.osList = osList;
	}

	public List<OutStockVWInfo> getOutStockList() {
		return outStockList;
	}

	public void setOutStockList(List<OutStockVWInfo> outStockList) {
		this.outStockList = outStockList;
	}

	public List<Stock> getExstockList() {
		return exstockList;
	}

	public void setExstockList(List<Stock> exstockList) {
		this.exstockList = exstockList;
	}

	public List<Organization> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Organization> orgList) {
		this.orgList = orgList;
	}

	public String getUserorg() {
		return userorg;
	}

	public void setUserorg(String userorg) {
		this.userorg = userorg;
	}

	public String getInstockorg() {
		return instockorg;
	}

	public void setInstockorg(String instockorg) {
		this.instockorg = instockorg;
	}

	public String getOutstockorg_q() {
		return outstockorg_q;
	}

	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}
	public String getStockorg_q() {
		return stockorg_q;
	}

	public void setStockorg_q(String stockorg_q) {
		this.stockorg_q = stockorg_q;
	}
	

	public List<Integer> getChknumList() {
		return chknumList;
	}

	public void setChknumList(List<Integer> chknumList) {
		this.chknumList = chknumList;
	}

	public String getTime_f() {
		return time_f;
	}

	public void setTime_f(String time_f) {
		this.time_f = time_f;
	}

	public String getTime_t() {
		return time_t;
	}

	public void setTime_t(String time_t) {
		this.time_t = time_t;
	}

	public ITEMS0126Form getItems0126form() {
		return items0126form;
	}

	public void setItems0126form(ITEMS0126Form items0126form) {
		this.items0126form = items0126form;
	}

	public ITEMS0110Form getItems0110form() {
		return items0110form;
	}

	public void setItems0110form(ITEMS0110Form items0110form) {
		this.items0110form = items0110form;
	}

	public ITEMS0147Form getItems0147form() {
		return items0147form;
	}

	public void setItems0147form(ITEMS0147Form items0147form) {
		this.items0147form = items0147form;
	}

	public ITEMS0146Form getItems0146form() {
		return items0146form;
	}

	public void setItems0146form(ITEMS0146Form items0146form) {
		this.items0146form = items0146form;
	}

	public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public ITEMS0145Form getItems0145form() {
		return items0145form;
	}

	public void setItems0145form(ITEMS0145Form items0145form) {
		this.items0145form = items0145form;
	}

	public Integer getOutstockid() {
		return outstockid;
	}

	public void setOutstockid(Integer outstockid) {
		this.outstockid = outstockid;
	}

	public ITEMS0144Form getItems0144form() {
		return items0144form;
	}

	public void setItems0144form(ITEMS0144Form items0144form) {
		this.items0144form = items0144form;
	}

	public ITEMS0143Form getItems0143form() {
		return items0143form;
	}

	public void setItems0143form(ITEMS0143Form items0143form) {
		this.items0143form = items0143form;
	}

	public ITEMS0121Form getItems0121form() {
		return items0121form;
	}

	public void setItems0121form(ITEMS0121Form items0121form) {
		this.items0121form = items0121form;
	}

	public String getGoToError() {
		return goToError;
	}

	public void setGoToError(String goToError) {
		this.goToError = goToError;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ITEMS0116Form getItems0116form() {
		return items0116form;
	}

	public void setItems0116form(ITEMS0116Form items0116form) {
		this.items0116form = items0116form;
	}

	public String getSeqcode() {
		return seqcode;
	}

	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}

	public OutStockSearchVWCond getOutStockSearchVWCond() {
		return outStockSearchVWCond;
	}

	public void setOutStockSearchVWCond(OutStockSearchVWCond outStockSearchVWCond) {
		this.outStockSearchVWCond = outStockSearchVWCond;
	}

	public ITEMS0142Form getItems0142form() {
		return items0142form;
	}

	public void setItems0142form(ITEMS0142Form items0142form) {
		this.items0142form = items0142form;
	}


	public Integer getStockid() {
		return stockid;
	}

	public List<InStock> getInStockList() {
		return inStockList;
	}

	public void setInStockList(List<InStock> inStockList) {
		this.inStockList = inStockList;
	}

	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}

	public ITEMS0111Form getItems0111form() {
		return items0111form;
	}

	public void setItems0111form(ITEMS0111Form items0111form) {
		this.items0111form = items0111form;
	}

	public String getOutstockorg() {
		return outstockorg;
	}

	public String getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public void setOutstockorg(String outstockorg) {
		this.outstockorg = outstockorg;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public OutStock getOutStock() {
		return outStock;
	}

	public void setOutStock(OutStock outStock) {
		this.outStock = outStock;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public ITEMS0106Form getItems0106form() {
		return items0106form;
	}

	public void setItems0106form(ITEMS0106Form items0106form) {
		this.items0106form = items0106form;
	}

	public StockSearchCond getStockSearchCond() {
		return stockSearchCond;
	}

	public void setStockSearchCond(StockSearchCond stockSearchCond) {
		this.stockSearchCond = stockSearchCond;
	}

	public ITEMS0141Form getItems0141form() {
		return items0141form;
	}

	public InStock getInStock() {
		return inStock;
	}

	public void setInStock(InStock inStock) {
		this.inStock = inStock;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setItems0141form(ITEMS0141Form items0141form) {
		this.items0141form = items0141form;
	}


	public OutStockSearchCond getOutStockSearchCond() {
		return outStockSearchCond;
	}

	public void setOutStockSearchCond(OutStockSearchCond outStockSearchCond) {
		this.outStockSearchCond = outStockSearchCond;
	}

	public ItemsCategory getItemsCategory() {
		return itemsCategory;
	}

	public void setItemsCategory(ItemsCategory itemsCategory) {
		this.itemsCategory = itemsCategory;
	}

	public ItemsCategorySearchCond getItemsCategorySearchCond() {
		return itemsCategorySearchCond;
	}

	public void setItemsCategorySearchCond(
			ItemsCategorySearchCond itemsCategorySearchCond) {
		this.itemsCategorySearchCond = itemsCategorySearchCond;
	}

	public List<ItemsCategory> getItemsCategoryList() {
		return itemsCategoryList;
	}

	public void setItemsCategoryList(List<ItemsCategory> itemsCategoryList) {
		this.itemsCategoryList = itemsCategoryList;
	}
	public List<ITEMS01712VO> getItems01712VOList() {
		return items01712VOList;
	}
	public void setItems01712VOList(List<ITEMS01712VO> items01712VOList) {
		this.items01712VOList = items01712VOList;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public ITEMS0101Form getItems0101form() {
		return items0101form;
	}
	public void setItems0101form(ITEMS0101Form items0101form) {
		this.items0101form = items0101form;
	}
	public ITEMS0174Form getItems0174form() {
		return items0174form;
	}
	public void setItems0174form(ITEMS0174Form items0174form) {
		this.items0174form = items0174form;
	}
	public OrganizationSearchCond getOrganizationSearchCond() {
		return organizationSearchCond;
	}
	public void setOrganizationSearchCond(
			OrganizationSearchCond organizationSearchCond) {
		this.organizationSearchCond = organizationSearchCond;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public List<Organization> getOrganizationCondList() {
		return organizationCondList;
	}
	public void setOrganizationCondList(List<Organization> organizationCondList) {
		this.organizationCondList = organizationCondList;
	}
	public List<Organization> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}
	public String[] getDeleteOrgid() {
		return deleteOrgid;
	}
	public void setDeleteOrgid(String[] deleteOrgid) {
		this.deleteOrgid = deleteOrgid;
	}
	public Integer getChangeOrgid() {
		return changeOrgid;
	}
	public void setChangeOrgid(Integer changeOrgid) {
		this.changeOrgid = changeOrgid;
	}
	public Map<Integer, String> getCompletenameMap() {
		return completenameMap;
	}
	public void setCompletenameMap(Map<Integer, String> completenameMap) {
		this.completenameMap = completenameMap;
	}
	public Map<Integer, String> getButtonMap() {
		return buttonMap;
	}
	public void setButtonMap(Map<Integer, String> buttonMap) {
		this.buttonMap = buttonMap;
	}
	public Map<Integer, String> getStartbuttonMap() {
		return startbuttonMap;
	}
	public void setStartbuttonMap(Map<Integer, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}

	public OutStockDetailSearchCond getOutStockDetailSearchCond() {
		return outStockDetailSearchCond;
	}

	public void setOutStockDetailSearchCond(
			OutStockDetailSearchCond outStockDetailSearchCond) {
		this.outStockDetailSearchCond = outStockDetailSearchCond;
	}

	public ITEMS0175Form getItems0175form() {
		return items0175form;
	}

	public void setItems0175form(ITEMS0175Form items0175form) {
		this.items0175form = items0175form;
	}

	public String getAccountstatus_q() {
		return accountstatus_q;
	}

	public void setAccountstatus_q(String accountstatus_q) {
		this.accountstatus_q = accountstatus_q;
	}

	public String getReqstatus() {
		return reqstatus;
	}

	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}

	public String getSeqcode_q() {
		return seqcode_q;
	}

	public void setSeqcode_q(String seqcode_q) {
		this.seqcode_q = seqcode_q;
	}

	public String getItemsname_q() {
		return itemsname_q;
	}

	public void setItemsname_q(String itemsname_q) {
		this.itemsname_q = itemsname_q;
	}
}
