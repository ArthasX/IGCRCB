/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.bl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.csebank.common.CodeValueBean;
import com.csebank.items.bl.task.InStockBL;
import com.csebank.items.bl.task.ItemsCategoryBL;
import com.csebank.items.bl.task.ItemsCodesBL;
import com.csebank.items.bl.task.ItemsPayBL;
import com.csebank.items.bl.task.OutStockBL;
import com.csebank.items.bl.task.OutStockDetailBL;
import com.csebank.items.bl.task.StockBL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.form.ITEMS0110Form;
import com.csebank.items.form.ITEMS0111Form;
import com.csebank.items.form.ITEMS0116Form;
import com.csebank.items.form.ITEMS0141Form;
import com.csebank.items.form.ITEMS0142Form;
import com.csebank.items.form.ITEMS0143Form;
import com.csebank.items.form.ITEMS0144Form;
import com.csebank.items.form.ITEMS0146Form;
import com.csebank.items.form.ITEMS0175Form;
import com.csebank.items.model.InStock;
import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.ItemsCodes;
import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.OutStock;
import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.OutStockVWInfo;
import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.InStockSearchCond;
import com.csebank.items.model.condition.InStockSearchCondImpl;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.csebank.items.model.condition.ItemsCategorySearchCondImpl;
import com.csebank.items.model.condition.OutStockDetailSearchCondImpl;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.model.condition.OutStockSearchCondImpl;
import com.csebank.items.model.condition.OutStockSearchVWCond;
import com.csebank.items.model.condition.OutStockSearchVWCondImpl;
import com.csebank.items.model.condition.StockSearchCondImpl;
import com.csebank.items.model.dao.OutStockVWDAO;
import com.csebank.items.model.entity.InStockTB;
import com.csebank.items.model.entity.ItemsCategoryTB;
import com.csebank.items.model.entity.OutStockDetailTB;
import com.csebank.items.model.entity.OutStockTB;
import com.csebank.items.model.entity.StockTB;
import com.csebank.items.util.CSEHelper;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01692VO;
import com.csebank.items.vo.ITEMS01712VO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;

public class ITEMS01BLImpl extends BaseBLImpl implements ITEMS01BL {

	static Log log = LogFactory.getLog(ITEMS01BLImpl.class);

	protected ItemsCategoryBL itemsCategoryBL;
	protected ItemsCodesBL itemsCodesBL;
	protected OutStockBL outStockBL;
	protected InStockBL inStockBL;
	protected StockBL stockBL;
	protected OutStockVWDAO outStockVWDAO;
	protected OutStockDetailBL outStockDetailBL;
	protected UserRoleBL userRoleBL;
	protected ItemsPayBL itemsPayBL;
	
	/**
	 * 注入OrganizationBL
	 */
	protected OrganizationBL organizationBL;

	/**
	 * 设置OrganizationBL
	 * @param organizationBL OrganizationBL
	 */
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setItemsPayBL(ItemsPayBL itemsPayBL) {
		this.itemsPayBL = itemsPayBL;
	}

	/**
	 * @param outStockDetailBL the outStockDetailBL to set
	 */
	public void setOutStockDetailBL(OutStockDetailBL outStockDetailBL) {
		this.outStockDetailBL = outStockDetailBL;
	}

	/**
	 * @param userRoleBL the userRoleBL to set
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setOutStockVWDAO(OutStockVWDAO outStockVWDAO) {
		this.outStockVWDAO = outStockVWDAO;
	}

	public void setOutStockBL(OutStockBL outStockBL) {
		this.outStockBL = outStockBL;
	}

	public void setInStockBL(InStockBL inStockBL) {
		this.inStockBL = inStockBL;
	}

	public void setStockBL(StockBL stockBL) {
		this.stockBL = stockBL;
	}

	public void setItemsCategoryBL(ItemsCategoryBL itemsCategoryBL) {
		this.itemsCategoryBL = itemsCategoryBL;
	}

	public void setItemsCodesBL(ItemsCodesBL itemsCodesBL) {
		this.itemsCodesBL = itemsCodesBL;
	}
	
	private String getSeqno(String type,String category,String seqcode,String orgcode){
		String newSeqno = "";
		String categoryName = DefineUtils.CATEGORY_MAP.get(category);
		if("I".equals(type)){
			InStockSearchCondImpl cond = new InStockSearchCondImpl();
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setInstockorg(orgcode);
			List<InStock> instockList = inStockBL.searchInStock(cond, 0, 0);
			String nowyear = CSEHelper.getCurrentYear();
			if(instockList==null || instockList.size()==0){//首次取
				newSeqno = type+categoryName+nowyear+"0001";
			}else{
				InStock instock = instockList.get(instockList.size()-1);
				String oldSeqno = instock.getSeqno();
				
				String temp = oldSeqno.substring(oldSeqno.length()-4);//取后4位数字
				String oldyear = oldSeqno.substring(4,8);//取年份
				if(oldyear.equals(nowyear)){
					newSeqno = type+categoryName+oldyear+StringUtils.leftPad(String.valueOf(Integer.valueOf(temp)+1), 4, "0");
				}else{
					newSeqno = type+categoryName+nowyear+"0001";
				}
			}
		}else{
			OutStockSearchCondImpl cond = new OutStockSearchCondImpl();
			ArrayList<String> list = new ArrayList<String>();
			list.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);
			list.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setReqorg(orgcode);
			cond.setOuttypelist(list);
			cond.setSerachtype("seq_desc");//按seqno降序排列
			List<OutStock> outstockList = outStockBL.searchOutStock(cond, 0, 0);
			String nowyear = CSEHelper.getCurrentYear();
			String oldSeqno = "";
			for(int i=0,j=outstockList.size();i<j;i++){
				OutStock outstock = outstockList.get(i);
				if( outstock.getSeqno()!=null && !"".equals(outstock.getSeqno())){
					oldSeqno = outstock.getSeqno();
					break;
				}
			}
			if("".equals(oldSeqno)){//首次取
				newSeqno = type+categoryName+nowyear+"0001";
			}else{
				String temp = oldSeqno.substring(oldSeqno.length()-4);//取后4位数字
				String oldyear = oldSeqno.substring(4,8);//取年份
				if(oldyear.equals(nowyear)){
					newSeqno = type+categoryName+oldyear+StringUtils.leftPad(String.valueOf(Integer.valueOf(temp)+1), 4, "0");
				}else{
					newSeqno = type+categoryName+nowyear+"0001";
				}
			}
		}
		return newSeqno;
	}
	
	
	public ITEMS01DTO searchItemsCategoryAction(ITEMS01DTO dto) throws BLException {
		ItemsCategorySearchCond cond = dto.getItemsCategorySearchCond();
		List<ItemsCategory> itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		
		if (itemsCategoryList.size() == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (itemsCategoryList.size() > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),itemsCategoryList.size()));
			return dto;
		}
		InStockSearchCondImpl iscond = new InStockSearchCondImpl();
		List<String> flaglist = new ArrayList<String>(); 
		for(ItemsCategory ic:itemsCategoryList){
			iscond = new InStockSearchCondImpl();
			iscond.setCategory(ic.getCategory());//物品种类
			iscond.setSeqcode(ic.getSeqcode());//物品编号
			List<InStock> inlist = inStockBL.searchInStock(iscond, 0, 0);
			if(inlist!=null && inlist.size()>0){
				flaglist.add("0");//不可修改
			}else{
				flaglist.add("1");//可修改
			}
		}
		dto.setItemsCategoryList(itemsCategoryList);
		dto.setEditList(flaglist);
		return dto;
	}

	public ITEMS01DTO insertItemsCategoryAction(ITEMS01DTO dto) throws BLException {
		ItemsCategory itemsCategory = dto.getItemsCategory();
		itemsCategory = itemsCategoryBL.insertItemsCategory(itemsCategory);
		if(itemsCategory == null){
			throw new BLException("ITEMS0104.E001");
		}
		dto.setItemsCategory(itemsCategory);
		return dto;
	}

	public ITEMS01DTO findItemsCategoryByPkAction(ITEMS01DTO dto) throws BLException {
		Integer icid = dto.getItemsCategory().getIcid();
		ItemsCategory itemsCategory = itemsCategoryBL.findItemsCategoryByPk(icid);
		dto.setItemsCategory(itemsCategory);
		return dto;
	}
	
	/**
	 * 查询stock表中的物品
	 */
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto, String temp) throws BLException {
		String category = dto.getCategory();
		String seqcode = dto.getSeqcode();
		String itemsname = dto.getItemsname();
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setItemsname(itemsname);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
		}else{
			cond.setStockorg(dto.getStockorg_q());
		}
		
		//cond.setStockorg_q(dto.getStockorg_q());//查询当前机构及其下级机构的数据
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		int totalCount = stockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		//调用DAO接口查询
		stockList = stockBL.searchStock(cond, 0, 0);
		dto.setStockList(stockList);
		return dto;
	}
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto) throws BLException {	
		
		//User user = dto.getUser();
//		//取当前用户角色类型为DefineUtils.ITEMS_ROLETYPE的角色集合
//		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
//		rolecond.setUserid(user.getUserid());
//		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
//		boolean flag = false;//是否可以管理总行库存
//		for(UserRoleInfo ur:urlist){
//			//如果角色类型为耗材管理默认角色类型
//			if(DefineUtils.ITEMS_ROLETYPE.equals(ur.getRoletype())){
//				if(userRoleBL.checkRoleManagerByID(user.getUserid(), ur.getRoleid())){
//					flag = true;
//					break;
//				}
//				
//			}
//			
//		}
//		

		String category = dto.getCategory();
		String seqcode = dto.getSeqcode();
		String itemsname = dto.getItemsname();
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setItemsname(itemsname);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
		}else{
			cond.setStockorg(dto.getStockorg_q());
		}
		
		//cond.setStockorg_q(dto.getStockorg_q());//查询当前机构及其下级机构的数据
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		int totalCount = stockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		stockList = stockBL.searchStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setStockList(stockList);
		return dto;
	}
	
	/**
	 * 查询stock表中的物品(申领使用)
	 */
	public ITEMS01DTO searchStockForInsertOutStockAction(ITEMS01DTO dto) throws BLException {
		String category = dto.getCategory();
		String seqcode = dto.getSeqcode();
		String typecode_q = dto.getTypecode_q();//物品名称
//		StockSearchCondImpl cond = new StockSearchCondImpl();
//		cond.setCategory(category);
//		cond.setSeqcode(seqcode);
//		cond.setStockorg(dto.getStockorg_q());
		//cond.setStockorg_q(dto.getStockorg_q());//查询当前机构及其下级机构的数据
		
		
		ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setTypecode(typecode_q);
		cond.setStatus(DefineUtils.ITEMSCATEGORY_STATUS_QY);//查状态为启用的记录
		List<ItemsCategory> itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		int totalCount = itemsCategoryList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		pDto.setTotalCount(totalCount);
		dto.setItemsCategoryList(itemsCategoryList);
		return dto;
	}
	
	public ITEMS01DTO statStockAction(ITEMS01DTO dto) throws BLException {
		String category = dto.getCategory();
		String seqcode = dto.getSeqcode();
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setStockorg(dto.getStockorg_q());//机构号
		cond.setSeqcode_q(dto.getSeqcode_q());
		cond.setItemsname_q(dto.getItemsname_q());
		PagingDTO pDto = dto.getPagingDto();
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		int totalCount = stockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		pDto.setTotalCount(totalCount);
		stockList = stockBL.searchStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<Integer> chknumList = new ArrayList<Integer>();

		List<Stock> new_stockList = new ArrayList<Stock>();
		for (Stock stock : stockList) {
			String stockCategory = stock.getCategory();
			String stockSeqcode = stock.getSeqcode();
//			String stockStockorg = stock.getStockorg();
			OutStockSearchCondImpl stockCond = new OutStockSearchCondImpl();
			stockCond.setCategory(stockCategory);
			stockCond.setSeqcode(stockSeqcode);
//			stockCond.setOutstockorg(stockStockorg);
			stockCond.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);
			List<OutStock> outStockList = outStockBL.findOutStockByCond(stockCond, 0, 0);
			int totalChknum = 0;
			for (OutStock outStock : outStockList) {
				totalChknum += outStock.getChknum();
			}
			chknumList.add(totalChknum);
			
			//总行库存单价取入库单价的平均值，支行库存单价取出库单价的平均值
			//如果库存数量为0，则单价及金额均为0
			if(stock.getStocknum().equals(0)){
				StockTB stb = (StockTB)SerializationUtils.clone(stock);
				stb.setPrice(0d);//单价
				stb.setAmount(0d);//金额
				new_stockList.add(stb);
			}else{
				InStockSearchCondImpl incond = new InStockSearchCondImpl();
				incond.setCategory(stockCategory);
				incond.setSeqcode(stockSeqcode);
				incond.setInstockorg(dto.getStockorg_q());//机构号
				List<InStock> inlist = inStockBL.searchInStock(incond, 0, 0);
				Double in_price = 0d;//入库单价
				Double in_amount = 0d;//金额小计
				int in_num = 0;//数量合计
				for(InStock ins:inlist){
					//库存数量为 = 入库数量 - 出库数量 - 损耗数量 - 销毁数量
					int stock_num = 0;
					Double sum_count = 0d;
					stock_num = (ins.getInnum()-ins.getOutnum()-ins.getLossnum()-ins.getHavocnum());//实际库存数量
					//in_num +=ins.getInnum();
					in_num +=stock_num;
					if(stock_num > 0){
						sum_count = getMultiply(String.valueOf(ins.getInprice()), String.valueOf(stock_num)).doubleValue();//该批次入库金额
					}else{
						sum_count = 0d;
					}
					
					in_amount = getAdd(String.valueOf(in_amount), String.valueOf(sum_count)).doubleValue();
				}
				
				in_price = getDivide(String.valueOf(in_amount), String.valueOf(in_num)).doubleValue();//单价
				in_price = round(in_price,4);
				Double amount = 0d;//金额合计
//				amount = getMultiply(String.valueOf(in_price), String.valueOf(stock.getStocknum())).doubleValue();//金额
//				
				amount = in_amount;
				StockTB stb = (StockTB)SerializationUtils.clone(stock);
				stb.setPrice(in_price);//单价
				stb.setAmount(round(amount,2));//金额
				new_stockList.add(stb);
			}
			
		}
		dto.setChknumList(chknumList);
		dto.setStockList(new_stockList);
		
		
		
		
		return dto;
	}
	
	/**
	 * 查询stock表中指定物品的详细信息
	 */
	public ITEMS01DTO searchStockDetailAction(ITEMS01DTO dto) throws BLException {
		Stock stock = stockBL.findStockByPk(dto.getStockid());
		dto.setStock(stock);
		return dto;
	}
	
	/**
	 * 查询outstock表中指定记录的详细信息
	 */
	public ITEMS01DTO searchOutStockDetailAction(ITEMS01DTO dto) throws BLException {
		OutStock outStock = outStockBL.findOutStockByPk(dto.getOutstockid());
		dto.setOutStock(outStock);
		return dto;
	}
	
	/**
	 * 根据用户ID判断当前用户是否可以管理总行库存
	 * @param ITEMS01DTO
	 * @return boolean true:可以 false:不可以
	 */
	public boolean checkRoleManagerByUserID(ITEMS01DTO dto) throws BLException {
		User user = dto.getUser();
		//取当前用户角色类型为DefineUtils.ITEMS_ROLETYPE的角色集合
		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
		rolecond.setUserid(user.getUserid());
		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
		boolean flag = false;//是否可以管理总行库存
		for(UserRoleInfo ur:urlist){
			//如果角色类型为耗材管理默认角色类型
			if(DefineUtils.ITEMS_ROLETYPE.equals(ur.getRoletype())){
				if(userRoleBL.checkRoleManagerByID(user.getUserid(), ur.getRoleid())){
					flag = true;
					break;
				}
				
			}
			
		}
		return flag;
	}
	
	
	/**
	 * 查询outstock表中的记录
	 */
	public ITEMS01DTO searchOutStockAction(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//调用DAO接口查询
		pDto.setTotalCount(totalCount);
		outStockList = outStockBL.findOutStockByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		Map<String,String> editMap = new HashMap<String,String>();
		boolean flag = false;
		for(OutStock outStock:outStockList){
			flag = false;
			OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
			detailcond.setOutstockid(outStock.getOutstockid());
			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
			for(OutStockDetail detail:detailList){
				InStock inStock = inStockBL.findInStockByPk(detail.getInstockid());
				if(detail.getInprice()==0d && detail.getOutprice()==0d && DefineUtils.ITEMSCODES_STOCK_NATURE_ZZ.equals(inStock.getNature())){
					//如果入库单价和出库单价都为0，并且物品性质为自制（1）时，不可结账
					flag = true;
					break;
				}
			}
			if(flag){
				editMap.put(String.valueOf(outStock.getOutstockid()), DefineUtils.ACCOUNTSTATUS_FALSE);
			}else{
				editMap.put(String.valueOf(outStock.getOutstockid()), DefineUtils.ACCOUNTSTATUS_TRUE);
			}
		}
		
		dto.setEditMap(editMap);
		dto.setOsList(outStockList);
		return dto;
	}
	
	/**
	 * 查询耗材通知
	 *   总行显示：支行接收情况（显示未接收的支行）
	 *   支行显示：总行有下拨物品/配送物品，请接收 显示新增物品情况
	 */
	public ITEMS01DTO searchOutStockForNoticeAction(ITEMS01DTO dto) throws BLException {
		//ITEMS0144Form form = dto.getItems0144form();
		List<String> outTypeList = new ArrayList<String>();
		outTypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//支行申领
		outTypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//总行下拨
		
		OutStockSearchVWCondImpl cond = new OutStockSearchVWCondImpl();
		cond.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);
		cond.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
		cond.setOutTypeList(outTypeList);
		//如果为支行用户则只查询申领机构为该支行的记录
//		if(DefineUtils.ZHIH_ORGNO.equals(form.getFlag())){
//			cond.setReqorg_q(dto.getUser().getOrgid());
//		}
//		
		if(dto.getUser().getOrgid().length()>=7 && 
		   DefineUtils.ZHIH_ORGNO.equals(dto.getUser().getOrgid().substring(0,7))){
				cond.setReqorg_q(dto.getUser().getOrgid());
		}
		
		
		List<OutStockVWInfo> outStockList = outStockVWDAO.findByCond(cond, 0, 0);
		// 查询记录总数
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		outStockList = outStockVWDAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		dto.setOutStockList(outStockList);

		return dto;
	}
	
	
	
	
	/**
	 * 查询outstock表中的记录(VW)
	 */
	public ITEMS01DTO searchOutStockVWAction(ITEMS01DTO dto) throws BLException {
		OutStockSearchVWCond cond = dto.getOutStockSearchVWCond();	
		List<OutStockVWInfo> outStockList = outStockVWDAO.findByCond(cond, 0, 0);
		
		// 查询记录总数
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		outStockList = outStockVWDAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<Stock> exstockList = new ArrayList<Stock>();//保存被申领并且库存中存在的耗材
		//查询被申领并且库存中存在的耗材的
		for(int i=0,j=outStockList.size();i<j;i++){
			String category = outStockList.get(i).getCategory().toString();
			String seqcode = outStockList.get(i).getSeqcode().toString();
			StockSearchCondImpl stockcond = new StockSearchCondImpl();
			stockcond.setStockorg(DefineUtils.DEFAULT_ORGNO);//设置默认机构号为总行机构号
			stockcond.setCategory(category);
			stockcond.setSeqcode(seqcode);
			List<Stock> stockList = stockBL.searchStock(stockcond, 0, 0);
			if(stockList!=null && stockList.size()>0 && stockList.get(0).getStocknum()>0){
				exstockList.add(stockList.get(0));
			}else{
//				StockTB stb = new  StockTB();
//				stb.setStocknum(10);
				exstockList.add(null);
			}
			
		}
		
		pDto.setTotalCount(totalCount);
		dto.setOutStockList(outStockList);
		dto.setExstockList(exstockList);
		return dto;
	}
	
	private String setPackno(String packno,String oldpackno){
		StringBuffer buff = new StringBuffer();
		if(StringUtils.isNotEmpty(packno)){
			if(StringUtils.isNotEmpty(oldpackno)){
				buff.append("、");
			}
			buff.append(packno);
			oldpackno+=buff.toString();
		}
		
		return oldpackno;
	}
	
	/**
	 * 查询outstock表中的记录(配送清单)
	 */
	public ITEMS01DTO searchOutStockBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// 查询记录总数
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//调用DAO接口查询
		outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		Map<String,Map<String,String>> outmap = new LinkedHashMap<String,Map<String,String>>();//<配送时间，<机构code，配送清单>>

		for(OutStock outstock:outStockList){
			String outtime = outstock.getOuttime().substring(0,10);//配送时间
			String orgcode = outstock.getReqorg();
			String packno = outstock.getPackno();//包裹号

			if(outmap.get(outtime)!=null){
				Map<String,String> packmap = outmap.get(outtime);//<机构code，配送清单>
				if(StringUtils.isNotEmpty(packmap.get(orgcode))){
					String oldpackno = packmap.get(orgcode);
					packmap.put(orgcode, setPackno(packno,oldpackno));
				}else{
					packmap.put(orgcode, setPackno(packno,""));
				}
				outmap.put(outtime, packmap);
			}else{
				Map<String,String> packmap = new LinkedHashMap<String,String>();//<机构code，配送清单>
				packmap.put(orgcode, setPackno(packno,""));			
				outmap.put(outtime, packmap);
			}
			
		}

		dto.setOutmap(outmap);
		return dto;
	}
	
	/**
	 * 查询outstock表中的记录(配送清单明细)
	 */
	public ITEMS01DTO searchOutStockDetailBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// 查询记录总数
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		outStockList = outStockBL.findOutStockByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		dto.setOsList(outStockList);
		return dto;
	}
	
	/**
	 * 查询outstock表中的记录(配送清单明细Excel导出)
	 */
	public ITEMS01DTO searchExcelDataBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// 查询记录总数
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			// 查询数据不存在
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// 查询数据件数过多
			return dto;
		}
		//调用DAO接口查询
		outStockList = outStockBL.findOutStockByCond(cond, 0, 0);

		dto.setOsList(outStockList);
		return dto;
	}
	
	/**
	 * 物品申领（即在outstock表中增加一条申领记录）
	 */
	public ITEMS01DTO insertOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0141Form form = dto.getItems0141form();
		String[] categorys = form.getCategorys();//物品种类
		String[] itemsnames = form.getItemsnames();//物品名称
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		//String[] types = form.getTypes();//物品类型
		//String[] seqnos = form.getSeqnos();//批次号
		//Integer[] bigpacknums = form.getBigpacknums();//大包装数量
		//Integer[] smallpacknums = form.getSmallpacknums();//小包装数量
		//String[] itemversions = form.getItemversions();//凭证版本
		//Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		Integer[] reqnums = form.getReqnums();//申领数量
		if(categorys!=null){
			for(int i = 0,j = categorys.length;i<j;i++){
				OutStockTB outstock = new OutStockTB();
				//设置物品信息
				outstock.setCategory(categorys[i]);
				outstock.setItemsname(itemsnames[i]);
				outstock.setSeqcode(seqcodes[i]);
				outstock.setTypecode(typecodes[i]);
				//outstock.setSeqno(seqnos[i]);
				//outstock.setBigpacknum(bigpacknums[i]);
				//outstock.setSmallpacknum(smallpacknums[i]);
				//outstock.setItemversion(itemversions[i]);
				//outstock.setStockid(stockids[i]);
				outstock.setReqnum(reqnums[i]);
				outstock.setReqtime(CSEHelper.getCurrentTime());
				outstock.setType(null);
				
				//设置申领的相关信息
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//出库类型：支行申领
				outstock.setReqorg(dto.getOutstockorg());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP);//出库状态：申领待审批
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//结账状态：未结账
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				
				outStockBL.insertOutStock(outstock);
				
				//将在stock表中的被申领的物品记录的prenum（变动数量增加）
				//Stock oldstock = stockBL.findStockByPk(stockids[i]);
				//StockTB stock = new StockTB();
//				stock.setCategory(categorys[i]);
//				stock.setSeqcode(seqcodes[i]);
				//stock.clone(oldstock);
				//stock.setStockid(stockids[i]);
				//stock.setPrenum(reqnums[i]);//申请数量
				//stock.setUserid(dto.getUserid());
				//stock.setUsername(dto.getUsername());
				//stockBL.addToStock(stock,DefineUtils.STOCK_PRENUM_SL);
			}
		}
		return dto;
	}
	
	/**
	 * 判断页面提交的该记录的出库状态是否与数据库中该记录的出库状态一致，有任何一条不一致则返回错误页
	 * Parameters outstockid,该记录的reqstatus
	 */
	private boolean checkEditStockReqstatus(ITEMS0144Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] reqstatuss = form.getReqstatuss();//出库状态
		if(outstockids!=null){
			for(int i = 0,j = outstockids.length;i<j;i++){
				OutStock outStock = outStockBL.findOutStockByPk(outstockids[i]);
				if(!outStock.getReqstatus().equals(reqstatuss[i])){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 物品申领修改
	 */
	public ITEMS01DTO editOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();	
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] categorys = form.getCategorys();//物品种类
		String[] itemsnames = form.getItemsnames();//物品名称
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		//String[] types = form.getTypes();//物品类型

		//String[] seqnos = form.getSeqnos();//批次号
		//Integer[] bigpacknums = form.getBigpacknums();//大包装数量
		//Integer[] smallpacknums = form.getSmallpacknums();//小包装数量
		//String[] itemversions = form.getItemversions();//凭证版本
		//Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		//Integer[] reqnums = form.getReqnums();//申领数量
		Integer[] new_reqnums = form.getNew_reqnums();//申领数量(修改后)
		if(!checkEditStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					OutStockTB outstock = new OutStockTB();
					//设置物品信息
					outstock.setOutstockid(outstockids[i]);
					outstock.setCategory(categorys[i]);
					outstock.setItemsname(itemsnames[i]);
					outstock.setSeqcode(seqcodes[i]);
					outstock.setTypecode(typecodes[i]);
					//outstock.setSeqno(seqnos[i]);
					//outstock.setBigpacknum(bigpacknums[i]);
					//outstock.setSmallpacknum(smallpacknums[i]);
					//outstock.setItemversion(itemversions[i]);
					//outstock.setStockid(stockids[i]);
					outstock.setReqnum(new_reqnums[i]);//设置申领数量为修改后的数量
					outstock.setReqtime(CSEHelper.getCurrentTime());
					//outstock.setType(types[i]);
					
					//设置申领的相关信息
					outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//出库类型：支行申领
					outstock.setReqorg(dto.getOutstockorg());
					outstock.setReqid(dto.getUserid());
					outstock.setReqname(dto.getUsername());
					outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP);//出库状态：申领待审批
					outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//结账状态：未结账
					
					outStockBL.insertOutStock(outstock);
					
					//更新stock表中被申领的物品记录的prenum。公式为：prenum = 当前值 - 修改前领数量 + 修改后申领数量
					//Stock oldStock = stockBL.findStockByPk(stockids[i]);
					
					//StockTB stockTB = new StockTB();
//					stockTB.clone(oldStock);
//					stockTB.setStockid(oldStock.getStockid());
//					stockTB.setPrenum(oldStock.getPrenum()-reqnums[i]+new_reqnums[i]);
//					stockTB.setUserid(dto.getUserid());
//					stockTB.setUsername(dto.getUsername());
//					stockTB.setUptime(CSEHelper.getCurrentTime());
//					stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SLXG);
				}
			}
		}else{
			dto.setGoToError("EDIT_REQSTATUS_ERROR");
		}
		return dto;
	}
	
	/**
	 * 物品申领删除
	 */
	public ITEMS01DTO delOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		//Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		//Integer[] reqnums = form.getReqnums();//申领数量
		
		if(!checkEditStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					OutStockTB outstock = new OutStockTB();
					outstock.setOutstockid(outstockids[i]);
					outStockBL.deleteOutStock(outstock);
					
					//更新stock表中被申领的物品记录的prenum。公式为：prenum = 当前值 - 修改前领数量 
//					Stock oldStock = stockBL.findStockByPk(stockids[i]);
//					StockTB stockTB = new StockTB();
//					stockTB.clone(oldStock);
//					stockTB.setStockid(oldStock.getStockid());
//					stockTB.setPrenum(oldStock.getPrenum()-reqnums[i]);
//					stockTB.setUserid(dto.getUserid());
//					stockTB.setUsername(dto.getUsername());
//					stockTB.setUptime(CSEHelper.getCurrentTime());
//					stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SLSC);
				}
			}
		} else {
			dto.setGoToError("DEl_REQSTATUS_ERROR");
		}
		return dto;
	}
	
	
	public void changeRequsetStatus(String selectid, String requestStatus) throws BLException {
		itemsCodesBL.changeStatus(selectid, requestStatus);
	}
	
	/**
	 * 从传入的form中取值赋给OutStockTB对象后将其返回(申领审批)
	 */
	private OutStockTB getNewTB(ITEMS0142Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] outstockorgs = form.getOutstockorgs();//库存机构号
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		String[] seqnos = form.getSeqnos();//批次号
		String[] outtypes = form.getOuttypes();//出库类型
		String[] reqorgs = form.getReqorgs();//领用机构号
		String[] reqids = form.getReqids();//申请人或下拨人ＩＤ
		String[] reqnames = form.getReqnames();//申请人或下拨人姓名
		String[] reqtimes = form.getReqtimes();//申请或下拨时间
		Integer[] reqnums = form.getReqnums();//申领数量
		
		Integer[] outnums = form.getOutnums();//实际出库数量
		String[] chkreasons = form.getChkreasons();//审批说明
		String[] pakreasons = form.getPakreasons();//出库说明
		String[] packnos = form.getPacknos();//包裹号
		String[] chkids = form.getChkids();//审批人ID
		String[] chknames = form.getChknames();//审批人姓名
		String[] chktimes = form.getChktimes();//审批时间
		String[] stockuserids = form.getStockuserids();//库管人的ID
		String[] stocknames = form.getStocknames();//库管人的名字
		String[] outtimes = form.getOuttimes();//出库时间
		String[] rcvids = form.getRcvids();//接收人ID
		String[] rcvnames = form.getRcvnames();//接收人姓名
		String[] rcvtimes = form.getRcvtimes();//接收时间
		//String[] reqstatuss = form.getReqstatuss();//出库状态
		String[] accountstatuss = form.getAccountstatuss();//结账状态
		Double[] inprices = form.getInprices();//入库单价（未使用）
		//Double[] outprices = form.getOutprices();//出库单价
		Double[] outamounts = form.getOutamounts();//出库金额
		Integer[] bigpacknums = form.getBigpacknums();//大包装数量
		Integer[] smallpacknums = form.getSmallpacknums();//小包装数量
		String[] itemversions = form.getItemversions();//凭证版本
		Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		String[] itemsnames = form.getItemsnames();//物品名称
		Integer[] stocknums = form.getStocknums();//库存数量
		
		String[] types = form.getTypes();//物品类型
		
		outstock.setOutstockid(outstockids[i]==null?0:outstockids[i]);
		outstock.setOutstockorg(outstockorgs[i]==null?"":outstockorgs[i]);
		outstock.setCategory(categorys[i]==null?"":categorys[i]);
		outstock.setSeqcode(seqcodes[i]==null?"":seqcodes[i]);
		outstock.setTypecode(typecodes[i]==null?"":typecodes[i]);
		outstock.setSeqno(seqnos[i]==null?"":seqnos[i]);
		outstock.setOuttype(outtypes[i]==null?"":outtypes[i]);
		outstock.setReqorg(reqorgs[i]==null?"":reqorgs[i]);
		outstock.setReqid(reqids[i]==null?"":reqids[i]);
		outstock.setReqname(reqnames[i]==null?"":reqnames[i]);
		
		outstock.setReqtime(reqtimes[i]==null?"":reqtimes[i]);
		outstock.setReqnum(reqnums[i]==null?0:reqnums[i]);
		outstock.setOutnum(outnums[i]==null?0:outnums[i]);
		outstock.setChkreason(chkreasons[i]==null?"":chkreasons[i]);
		outstock.setPakreason(pakreasons[i]==null?"":pakreasons[i]);
		outstock.setPackno(packnos[i]==null?"":packnos[i]);
		outstock.setChkid(chkids[i]==null?"":chkids[i]);
		outstock.setChkname(chknames[i]==null?"":chknames[i]);
		outstock.setChktime(chktimes[i]==null?"":chktimes[i]);
		outstock.setStockuserid(stockuserids[i]==null?"":stockuserids[i]);
		
		outstock.setStockname(stocknames[i]==null?"":stocknames[i]);
		outstock.setOuttime(outtimes[i]==null?"":outtimes[i]);
		outstock.setRcvid(rcvids[i]==null?"":rcvids[i]);
		outstock.setRcvname(rcvnames[i]==null?"":rcvnames[i]);
		outstock.setRcvtime(rcvtimes[i]==null?"":rcvtimes[i]);
		outstock.setAccountstatus(accountstatuss[i]==null?"":accountstatuss[i]);
		outstock.setInprice(inprices[i]==null?0:inprices[i]);
		//outstock.setOutprice(outprices[i]==null?0:outprices[i]);
		outstock.setOutamount(outamounts[i]==null?0:outamounts[i]);
		outstock.setBigpacknum(bigpacknums[i]==null?0:bigpacknums[i]);
		
		outstock.setSmallpacknum(smallpacknums[i]==null?0:smallpacknums[i]);
		outstock.setItemversion(itemversions[i]==null?"":itemversions[i]);
		outstock.setStockid(stockids[i]==null?0:stockids[i]);
		outstock.setItemsname(itemsnames[i]==null?"":itemsnames[i]);
		outstock.setStocknum(stocknums[i]==null?0:stocknums[i]);
		
		outstock.setType(types[i]==null?"":types[i]);
		
		return outstock;
	}
	
	
	/**
	 * 校验审批数量是否超过库存数量
	 */
	@SuppressWarnings("unchecked")
	private boolean checkStockNum(ITEMS0142Form form) throws BLException{
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		Integer[] chknums = form.getChknums();//审批完成数量
		//Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		ArrayList totaltype = new ArrayList();//存在几种物品(格式：categorys;seqcodes)
		ArrayList totalnum = new ArrayList();//每种物品的审批总数量
		StockSearchCondImpl cond = new StockSearchCondImpl();

		if(outstockids!=null){
			//取得共有几种被审批的物品
			for(int i = 0,j = outstockids.length;i<j;i++){
				String category = categorys[i];
				String seqcode = seqcodes[i];
				String type = category+";"+seqcode;

				if(!checkStockTypeIsInList(totaltype,type)){
					totaltype.add(type);
				}
			}
			
			//取得每种被审批的物品的数量和
			for(int i = 0,j = totaltype.size();i<j;i++){
				Integer num = 0;
				for(int x = 0,y = outstockids.length;x<y;x++){
					String category = totaltype.get(i).toString().split(";")[0];
					String seqcode = totaltype.get(i).toString().split(";")[1];
					
					if(category.equals(categorys[x])){
						if(seqcode.equals(seqcodes[x])){
							num+= chknums[x];
						}
					}
				}
				totalnum.add(num);
			}
			
			//校验审批数量是否超过库存数量
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//查询指定类别和编号的物品
				cond.setCategory(category);
				cond.setSeqcode(seqcode);
				cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
				
				Stock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//审批数量的和
				if(num>stock.getStocknum()){
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 判断该物品种类是否已经保存
	 */
	private boolean checkStockTypeIsInList(ArrayList totaltype,String type){
		boolean flag = false;
		for(int i = 0,j = totaltype.size();i<j;i++){
			if(type.equals(totaltype.get(i).toString())){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 判断页面提交的该记录的出库状态是否与数据库中该记录的出库状态一致，有任何一条不一致则返回错误页(避免多人同时审批同一条记录)
	 */
	private boolean checkStockReqstatus(ITEMS0142Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] reqstatuss = form.getReqstatuss();//出库状态
		if(outstockids!=null){
			for(int i = 0,j = outstockids.length;i<j;i++){
				OutStock outStock = outStockBL.findOutStockByPk(outstockids[i]);
				if(!outStock.getReqstatus().equals(reqstatuss[i])){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 申领审批
	 */
	public ITEMS01DTO approveOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0142Form form = dto.getItems0142form();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		//Integer[] reqnums = form.getReqnums();//申领数量
		Integer[] chknums = form.getChknums();//审批完成数量
		Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		String flag = form.getFlag();//1通过  0不通过

		if(!checkStockReqstatus(form) || "0".equals(flag)){
			if(!checkStockNum(form) || "0".equals(flag)){
				if(outstockids!=null){
					for(int i = 0,j = outstockids.length;i<j;i++){
						//设置申批的基本信息
						OutStockTB outstock = getNewTB(form,i);
						outstock.setChkid(dto.getUserid());
						outstock.setChkname(dto.getUsername());
						outstock.setChktime(CSEHelper.getCurrentTime());
						if("1".equals(flag)){
							//为OutStock表设置申批通过时的重要信息
							outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//出库状态：待出库
							outstock.setChknum(chknums[i]);//设置审批数量
							
							//设置查询条件查询
						
							Stock oldStock = stockBL.findStockByPk(stockids[i]);
							
							//更新stock表中被申批的物品记录的prenum。公式为：prenum = 当前值  + 审批数量
							StockTB stockTB = new StockTB();
							stockTB.clone(oldStock);
							stockTB.setStockid(oldStock.getStockid());
							stockTB.setPrenum(oldStock.getPrenum()+chknums[i]);
							stockTB.setUserid(dto.getUserid());
							stockTB.setUsername(dto.getUsername());
							stockTB.setUptime(CSEHelper.getCurrentTime());
							stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SP);
							
							//更新outstock表
							outStockBL.insertOutStock(outstock);
						}else{
							//为OutStock表设置申批不通过时的重要信息
							outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SPWTG);//出库状态：审批未通过
							outstock.setChknum(chknums[i]);//设置审批数量
							
							//设置查询条件查询
							//Stock oldStock = stockBL.findStockByPk(stockids[i]);
							
							//更新stock表中被申批的物品记录的prenum。公式为：prenum = 当前值 - 申领数量 
//							StockTB stockTB = new StockTB();
//							stockTB.clone(oldStock);
//							stockTB.setStockid(oldStock.getStockid());
//							//stockTB.setPrenum(oldStock.getPrenum()-reqnums[i]);
//							stockTB.setUserid(dto.getUserid());
//							stockTB.setUsername(dto.getUsername());
//							stockTB.setUptime(CSEHelper.getCurrentTime());
//							stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SP);
							
							//更新outstock表
							outStockBL.insertOutStock(outstock);
						}
					}
				}
			}else{
				//同种物品的审批数量超过库存数量
				dto.setGoToError("SP_NUM_ERROR");
			}
		}else{
			//页面提交记录的出库状态与数据库中记录的出库状态不一致
			dto.setGoToError("SP_REQSTATUS_ERROR");
		}
		
		return dto;
	}
	
	/**
	 * 从传入的form中取值赋给OutStockTB对象后将其返回(出库)
	 */
	private OutStockTB getNewTB(ITEMS0143Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] outstockorgs = form.getOutstockorgs();//库存机构号
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		String[] seqnos = form.getSeqnos();//批次号
		String[] outtypes = form.getOuttypes();//出库类型
		String[] reqorgs = form.getReqorgs();//领用机构号
		String[] reqids = form.getReqids();//申请人或下拨人ＩＤ
		String[] reqnames = form.getReqnames();//申请人或下拨人姓名
		String[] reqtimes = form.getReqtimes();//申请或下拨时间
		Integer[] reqnums = form.getReqnums();//申领数量
		Integer[] chknums = form.getChknums();//申批数量
		
		Integer[] outnums = form.getOutnums();//实际出库数量
		String[] chkreasons = form.getChkreasons();//审批说明
		String[] pakreasons = form.getPakreasons();//出库说明
		
		String[] chkids = form.getChkids();//审批人ID
		String[] chknames = form.getChknames();//审批人姓名
		String[] chktimes = form.getChktimes();//审批时间
		//String[] stockuserids = form.getStockuserids();//库管人的ID
		//String[] stocknames = form.getStocknames();//库管人的名字
		String[] outtimes = form.getOuttimes();//出库时间
		String[] rcvids = form.getRcvids();//接收人ID
		String[] rcvnames = form.getRcvnames();//接收人姓名
		String[] rcvtimes = form.getRcvtimes();//接收时间
		//String[] reqstatuss = form.getReqstatuss();//出库状态
		String[] accountstatuss = form.getAccountstatuss();//结账状态
		Double[] inprices = form.getInprices();//入库单价（未使用）
		//Double[] outprices = form.getOutprices();//出库单价
		Double[] outamounts = form.getOutamounts();//出库金额
		Integer[] bigpacknums = form.getBigpacknums();//大包装数量
		Integer[] smallpacknums = form.getSmallpacknums();//小包装数量
		String[] itemversions = form.getItemversions();//凭证版本
		Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		String[] itemsnames = form.getItemsnames();//物品名称
		Integer[] stocknums = form.getStocknums();//库存数量
		String[] types = form.getTypes();//物品类型

		
		outstock.setChknum(chknums[i]==null?0:chknums[i]);//设置审批数量
		outstock.setOutstockid(outstockids[i]==null?0:outstockids[i]);
		outstock.setOutstockorg(outstockorgs[i]==null?"":outstockorgs[i]);
		outstock.setCategory(categorys[i]==null?"":categorys[i]);
		outstock.setSeqcode(seqcodes[i]==null?"":seqcodes[i]);
		outstock.setTypecode(typecodes[i]==null?"":typecodes[i]);
		outstock.setSeqno(seqnos[i]==null?"":seqnos[i]);
		outstock.setOuttype(outtypes[i]==null?"":outtypes[i]);
		outstock.setReqorg(reqorgs[i]==null?"":reqorgs[i]);
		outstock.setReqid(reqids[i]==null?"":reqids[i]);
		outstock.setReqname(reqnames[i]==null?"":reqnames[i]);
		
		outstock.setReqtime(reqtimes[i]==null?"":reqtimes[i]);
		outstock.setReqnum(reqnums[i]==null?0:reqnums[i]);
		outstock.setOutnum(outnums[i]==null?0:outnums[i]);
		outstock.setChkreason(chkreasons[i]==null?"":chkreasons[i]);
		outstock.setPakreason(pakreasons[i]==null?"":pakreasons[i]);
		outstock.setChkid(chkids[i]==null?"":chkids[i]);
		outstock.setChkname(chknames[i]==null?"":chknames[i]);
		outstock.setChktime(chktimes[i]==null?"":chktimes[i]);
		//outstock.setStockuserid(stockuserids[i]==null?"":stockuserids[i]);
		
		//outstock.setStockname(stocknames[i]==null?"":stocknames[i]);
		outstock.setOuttime(outtimes[i]==null?"":outtimes[i]);
		outstock.setRcvid(rcvids[i]==null?"":rcvids[i]);
		outstock.setRcvname(rcvnames[i]==null?"":rcvnames[i]);
		outstock.setRcvtime(rcvtimes[i]==null?"":rcvtimes[i]);
		outstock.setAccountstatus(accountstatuss[i]==null?"":accountstatuss[i]);
		outstock.setInprice(inprices[i]==null?0:inprices[i]);
		
		outstock.setOutamount(outamounts[i]==null?0:outamounts[i]);
		outstock.setBigpacknum(bigpacknums[i]==null?0:bigpacknums[i]);
		
		outstock.setSmallpacknum(smallpacknums[i]==null?0:smallpacknums[i]);
		outstock.setItemversion(itemversions[i]==null?"":itemversions[i]);
		outstock.setStockid(stockids[i]==null?0:stockids[i]);
		outstock.setItemsname(itemsnames[i]==null?"":itemsnames[i]);
		outstock.setStocknum(stocknums[i]==null?0:stocknums[i]);
		
		outstock.setType(types[i]==null?"":types[i]);
		
		return outstock;
	}
	
	/**
	 * 从传入的form中取值赋给OutStockTB对象后将其返回(出库)
	 */
	private OutStockDetailTB getNewOutStockDetailTB(OutStock outStock){
		OutStockDetailTB outstockDetail = new OutStockDetailTB();
		
		outstockDetail.setOutstockid(outStock.getOutstockid());
		outstockDetail.setChknum(outStock.getChknum());//设置审批数量
		outstockDetail.setOutstockid(outStock.getOutstockid());
		outstockDetail.setOutstockorg(outStock.getOutstockorg());
		outstockDetail.setCategory(outStock.getCategory());
		outstockDetail.setSeqcode(outStock.getSeqcode());
		outstockDetail.setTypecode(outStock.getTypecode());
		outstockDetail.setSeqno(outStock.getSeqno());
		outstockDetail.setOuttype(outStock.getOuttype());
		outstockDetail.setReqorg(outStock.getReqorg());
		outstockDetail.setReqid(outStock.getReqid());
		outstockDetail.setReqname(outStock.getReqname());
		
		outstockDetail.setReqtime(outStock.getReqtime());
		outstockDetail.setReqnum(outStock.getReqnum());
		//outstockDetail.setOutnum(outStock.getOutnum());//出库数量
		outstockDetail.setChkreason(outStock.getChkreason());
		outstockDetail.setPackno(outStock.getPackno());
		outstockDetail.setPakreason(outStock.getPakreason());
		outstockDetail.setChkid(outStock.getChkid());
		outstockDetail.setChkname(outStock.getChkname());
		outstockDetail.setChktime(outStock.getChktime());
		
		outstockDetail.setOuttime(outStock.getOuttime());//出库时间
		outstockDetail.setRcvid(outStock.getRcvid());
		outstockDetail.setRcvname(outStock.getRcvname());
		outstockDetail.setRcvtime(outStock.getRcvtime());
		outstockDetail.setAccountstatus(outStock.getAccountstatus());
		//outstockDetail.setInprice(outStock.getInprice());
		
		//outstockDetail.setOutamount(outStock.getOutamount());//出库金额
		outstockDetail.setBigpacknum(outStock.getBigpacknum());
		
		outstockDetail.setSmallpacknum(outStock.getSmallpacknum());
		outstockDetail.setItemversion(outStock.getItemversion());
		outstockDetail.setStockid(outStock.getStockid());
		outstockDetail.setItemsname(outStock.getItemsname());
		//outstockDetail.setStocknum(outStock.getStocknum());
		
		outstockDetail.setType(outStock.getType());
		
		return outstockDetail;
	}
	
	/**
	 * 校验配送数量是否超过库存数量
	 */
	@SuppressWarnings("unchecked")
	private String checkOutNum(ITEMS0143Form form) throws BLException{
		String flag = null;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		Integer[] outnums = form.getOutnums();//出库数量
		//Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		ArrayList totaltype = new ArrayList();//存在几种物品(格式：categorys;seqcodes)
		ArrayList totalnum = new ArrayList();//每种物品的出库总数量
		StockSearchCondImpl cond = new StockSearchCondImpl();

		if(outstockids!=null){
			//取得共有几种物品
			for(int i = 0,j = outstockids.length;i<j;i++){
				String category = categorys[i];
				String seqcode = seqcodes[i];
				String type = category+";"+seqcode;

				if(!checkStockTypeIsInList(totaltype,type)){
					totaltype.add(type);
				}
			}
			
			//取得每种物品的数量和
			for(int i = 0,j = totaltype.size();i<j;i++){
				Integer num = 0;
				for(int x = 0,y = outstockids.length;x<y;x++){
					String category = totaltype.get(i).toString().split(";")[0];
					String seqcode = totaltype.get(i).toString().split(";")[1];
					
					if(category.equals(categorys[x])){
						if(seqcode.equals(seqcodes[x])){
							num+= outnums[x];
						}
					}
				}
				totalnum.add(num);
			}
			
			//校验配送数量是否超过库存数量
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//查询指定类别和编号的物品
				cond.setCategory(category);
				cond.setSeqcode(seqcode);
				cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
				
				Stock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//出库数量的和
				if(num>stock.getStocknum()){
					if(flag==null)
					{
						flag = seqcodes[i]+","+(stock.getStocknum());
					}else{
						flag += ","+seqcodes[i]+","+(stock.getStocknum());
					}
				}
			}
			
			
		}
		
		
		return flag;
	}
	
	/**
	 * 判断页面提交的该记录的出库状态是否与数据库中该记录的出库状态一致，有任何一条不一致则返回错误页(避免多人同时操作同一条记录)
	 * Parameters outstockid,该记录的reqstatus
	 */
	private String checkOutReqstatus(ITEMS0143Form form){
		String flag = null;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] reqstatuss = form.getReqstatuss();//出库状态
		String[] seqcodes = form.getSeqcodes();//物品编号
		if(outstockids!=null){
			for(int i = 0,j = outstockids.length;i<j;i++){
				OutStock outStock = outStockBL.findOutStockByPk(outstockids[i]);
				if(!outStock.getReqstatus().equals(reqstatuss[i])){
					if(flag==null){
						flag = seqcodes[i];
					}else
					{
						flag += ","+seqcodes[i];
					}
				}
			}
		}
		
		
		return flag;
	}

	
	/**
	 * 配送下发
	 */
	public ITEMS01DTO distributionOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0143Form form = dto.getItems0143form();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] reqorgs = form.getReqorgs();//申领机构
		Integer[] chknums = form.getChknums();//审批数量
		Integer[] outnums = form.getOutnums();//出库数量
		Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		//String[] packnos = form.getPacknos();//包裹号
		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setInstockorg(DefineUtils.DEFAULT_ORGNO);//设置库存机构为顶级机构
		List<String> statuslist = new ArrayList<String>();
		statuslist.add(DefineUtils.ITEMSCODES_STATUS_WCK);//未出库
		statuslist.add(DefineUtils.ITEMSCODES_STATUS_BFCK);//部分出库
		
		Double out_price = 0d;//出库单价
		Double out_amount = 0d;//出库金额
		Double out_price_part = 0d;//入库明细表每批库存单价*该批出库数量，然后再与各批出库记录汇总的值
		int out_num_part = 0;//出库数量小计
		boolean falg = false;//是否已满足出库数量
		List<Integer> instockidlist =  new ArrayList<Integer>();
		List<Integer> instockOutnumlist = new ArrayList<Integer>();
		int per_outnum = 0;//每条记录需要的库存数量
		String cor = checkOutReqstatus(form);
		String con = checkOutNum(form);
		if(cor==null){
			if(con==null){
				if(outstockids!=null){						
					//出库
					for(int i = 0,j = outstockids.length;i<j;i++){
						//设置基本信息
						OutStockTB outstock = getNewTB(form,i);
						
						outstock.setOuttime(CSEHelper.getCurrentTime());					
						outstock.setStockuserid(dto.getUserid());						
						outstock.setStockname(dto.getUsername());					
						outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
						
						//为OutStock表设置配送下发时的重要信息
						outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收					
						outstock.setOutnum(outnums[i]);//设置出库数量					
						//outstock.setPackno(packnos[i]);//设置包裹号
						//outstock.setStockuserid(dto.getUserid());
						//outstock.setStockname(dto.getUsername());
						outstock.setSeqno(getSeqno("O",categorys[i],seqcodes[i],reqorgs[i]));//保存出库批次号
						
						//设置查询条件查询
					
						Stock oldStock = stockBL.findStockByPk(stockids[i]);
						int nowprenum = oldStock.getPrenum()-chknums[i];//变动数量,公式为：prenum = 当前值 - 审批数量
						
						//更新stock表中被下发的物品记录的prenum,stocknum。公式为：prenum = 当前值 - 审批数量,stocknum = 当前值 - 实际出库数量
						
//						StockTB stockTB = new StockTB();
//						stockTB.clone(oldStock);
//						stockTB.setStockid(oldStock.getStockid());
//						stockTB.setPrenum(oldStock.getPrenum()-chknums[i]);
//						stockTB.setStocknum(oldStock.getStocknum()-outnums[i]);
//						stockTB.setUserid(dto.getUserid());
//						stockTB.setUsername(dto.getUsername());
//						stockTB.setUptime(CSEHelper.getCurrentTime());
//						Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
						
						
						//stockBL.saveOrUpdateStock(stockTB);
						
						//更新instock表
						cond.setCategory(categorys[i]);
						cond.setSeqcode(seqcodes[i]);
						cond.setStatus_q(statuslist);
						cond.setInstock_sort(DefineUtils.INSTOCK_SORT_BYINTIME);//设置排序方式为按照入库时间升序排序
						
						//该批物品的集合
						List<InStock> oldInStock = inStockBL.searchInStock(cond, 0, 0);
						
						//该条记录需要的库存数量
						per_outnum = outnums[i];
			
						//按照先入库先出库的原则依次减少库存量,直至满足出库数量为止	
						for(int x = 0 , y = oldInStock.size();x<y;x++){
							InStock outinstock =  oldInStock.get(x);
							per_outnum = outnums[i] - out_num_part;//取得还差多少数量满足出库要求
							int true_instocknum = outinstock.getInnum()-outinstock.getOutnum()-outinstock.getLossnum()-outinstock.getHavocnum();//每批货的实际库存量
							if(true_instocknum>per_outnum){
								if(out_num_part!=0){//未能直接满足出库需要
									//判断当前的数量小计是否已满足出库数量								
									if((out_num_part+true_instocknum)>=outnums[i]){//满足
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
												
										}
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add((outnums[i]-out_num_part));
										
										//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//新增出库明细
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收					
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(outnums[i]-out_num_part);//出库数量
										outStockDetail.setInprice(outinstock.getInprice());//入库单价
										outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//出库金额
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
										outStockDetailBL.insertOutStockDetail(outStockDetail);
										falg = true;
										break;
									}else{
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add(true_instocknum);
										
										//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//新增出库明细
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(true_instocknum);//出库数量
										outStockDetail.setInprice(outinstock.getInprice());//入库单价
										outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//出库金额
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
										outStockDetailBL.insertOutStockDetail(outStockDetail);
									}
								}else{
									InStockTB instockTB = new InStockTB();
									instockTB.clone(outinstock);
									instockTB.setInstockid(outinstock.getInstockid());
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_BFCK);//入库后状态修改为：部分出库
									instockTB.setOutnum(outinstock.getOutnum()+outnums[i]);//设置已出库数量
									//instockTB.setUserid(dto.getUserid());
									//instockTB.setUsername(dto.getUsername());
									//instockTB.setIntime(CSEHelper.getCurrentTime());
									inStockBL.insertInStock(instockTB);
									
									//计算出库单价及出库金额，更新outstock表
									out_price = outinstock.getOutprice();
									
									if(out_price!=null && out_price>0){
										out_price = round(out_price,4);
										out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										outstock.setOutprice(out_price);
										outstock.setOutamount(out_amount);
									}
									
									//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-outnums[i]);
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									
									OutStock outStock1 = outStockBL.insertOutStock(outstock);
									//新增出库明细
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]);//出库数量
									outStockDetail.setInprice(outinstock.getInprice());//入库单价
									outStockDetail.setOutprice(out_price);//出库单价
									outStockDetail.setOutamount(out_amount);//出库金额
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
									outStockDetailBL.insertOutStockDetail(outStockDetail);
									break;
								}
								
								
								
							}else if(true_instocknum==per_outnum){
								if(out_num_part!=0){//未能直接满足出库需要
									//判断当前的数量小计是否已满足出库数量								
									if((out_num_part+true_instocknum)>=outnums[i]){//满足
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
											
										}
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add((outnums[i]-out_num_part));
										
										//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//新增出库明细
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(outnums[i]-out_num_part);//出库数量
										outStockDetail.setInprice(outinstock.getInprice());//入库单价
										outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//出库金额
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetailBL.insertOutStockDetail(outStockDetail);
										falg = true;
										break;
									}else{
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add(true_instocknum);
										
										//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//新增出库明细
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(true_instocknum);//出库数量
										outStockDetail.setInprice(outinstock.getInprice());//入库单价
										outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//出库金额
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
										outStockDetailBL.insertOutStockDetail(outStockDetail);
									}
								}else{
									InStockTB instockTB = new InStockTB();
									instockTB.clone(outinstock);
									instockTB.setInstockid(outinstock.getInstockid());
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_YCK);//入库后状态修改为：已出库
									instockTB.setOutnum(outinstock.getOutnum()+outnums[i]);//设置已出库数量
									//instockTB.setUserid(dto.getUserid());
									//instockTB.setUsername(dto.getUsername());
									//instockTB.setIntime(CSEHelper.getCurrentTime());
									inStockBL.insertInStock(instockTB);
									
									//计算出库单价及出库金额，更新outstock表
									out_price = outinstock.getOutprice();
									if(out_price!=null && out_price>0){
										out_price = round(out_price,4);
										out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										outstock.setOutprice(out_price);
										outstock.setOutamount(out_amount);
									}
									//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-outnums[i]);
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									OutStock outStock1 = outStockBL.insertOutStock(outstock);
									//新增出库明细
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]);//出库数量
									outStockDetail.setInprice(outinstock.getInprice());//入库单价
									outStockDetail.setOutprice(out_price);//出库单价
									outStockDetail.setOutamount(out_amount);//出库金额
									outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetailBL.insertOutStockDetail(outStockDetail);

									break;
								}
								
							}else{
								//判断当前的数量小计是否已满足出库数量								
								if((out_num_part+true_instocknum)>=outnums[i]){//满足
									if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
										out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
										
									}
									//out_num_part+=(outnums[i]-out_num_part);
									instockidlist.add(outinstock.getInstockid());
									instockOutnumlist.add((outnums[i]-out_num_part));
									
									//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									//新增出库明细
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]-out_num_part);//出库数量
									outStockDetail.setInprice(outinstock.getInprice());//入库单价
									outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
									outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//出库金额
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
									outStockDetailBL.insertOutStockDetail(outStockDetail);
									falg = true;
									break;
								}else{
									if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
										out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
										
									}
									out_num_part+=true_instocknum;
									instockidlist.add(outinstock.getInstockid());
									instockOutnumlist.add(true_instocknum);
									
									//更新stock表中被下发的物品记录的prenum,stocknum。公式为：stocknum = 当前值 - 实际出库数量
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									//新增出库明细
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//出库状态：待接收				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(true_instocknum);//出库数量
									outStockDetail.setInprice(outinstock.getInprice());//入库单价
									outStockDetail.setOutprice(outinstock.getOutprice());//出库单价
									outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//出库金额
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//入库批次号
									outStockDetailBL.insertOutStockDetail(outStockDetail);
								}
							}
						}
						if(falg){
							//更新instock表中出库涉及的各条记录
							for(int n=0,m=instockidlist.size();n<m;n++){
								InStockTB instockTB = new InStockTB();
								InStock is = inStockBL.findInStockByPk(instockidlist.get(n));
								int true_num = is.getInnum()-is.getOutnum()-is.getLossnum()-is.getHavocnum();//该批货的实际库存量
								instockTB.clone(is);
								instockTB.setInstockid(is.getInstockid());
								if(instockOutnumlist.get(n)==true_num){
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_YCK);//入库后状态修改为：已出库
									instockTB.setOutnum(is.getOutnum()+true_num);//设置已出库数量
								}else{
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_BFCK);//入库后状态修改为：部分出库
									instockTB.setOutnum(is.getOutnum()+instockOutnumlist.get(n));//设置已出库数量
								}
								//instockTB.setUserid(dto.getUserid());
								//instockTB.setUsername(dto.getUsername());
								//instockTB.setIntime(CSEHelper.getCurrentTime());
								inStockBL.insertInStock(instockTB);
								
							}
							//计算出库单价及出库金额，更新outstock表
							if(out_price_part!=null && out_price_part>0){
								out_price = getDivide(String.valueOf(out_price_part), String.valueOf(outnums[i])).doubleValue();
								out_price = round(out_price,4);
								out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outnums[i])).doubleValue();
								out_amount = round(out_amount,4);
								outstock.setOutprice(out_price);
								outstock.setOutamount(out_amount);
							}

							outStockBL.insertOutStock(outstock);

						}
						//重置
						out_price_part = 0d;
						out_num_part = 0;
						per_outnum = 0;
						out_price = 0d;
						out_amount = 0d;
						falg = false;
						instockidlist.clear();
						instockOutnumlist.clear();
					}
				}
			}else{
				//同种物品的出库数量超过库存数量
				dto.setGoToError("CK_NUM_ERROR;"+con);
			}
		}else{
			//页面提交记录的出库状态与数据库中记录的出库状态不一致
			dto.setGoToError("CK_REQSTATUS_ERROR;"+cor);
		}
		
		return dto;
	}
	
	/**
	 * 判断页面提交的该记录的出库状态是否与数据库中该记录的出库状态一致，有任何一条不一致则返回错误页(避免多人同时审批同一条记录)
	 * Parameters outstockid,该记录的reqstatus
	 */
	private boolean checkReceiveStockReqstatus(ITEMS0144Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] reqstatuss = form.getReqstatuss();//出库状态
		if(outstockids!=null){
			for(int i = 0,j = outstockids.length;i<j;i++){
				OutStock outStock = outStockBL.findOutStockByPk(outstockids[i]);
				if(!outStock.getReqstatus().equals(reqstatuss[i])){
					flag = true;
					break;
				}
			}
		}
		
		
		return flag;
	}
	
	/**
	 * 从传入的form中取值赋给OutStockTB对象后将其返回(接收)
	 */
	private OutStockTB getNewTB(ITEMS0144Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		String[] outstockorgs = form.getOutstockorgs();//库存机构号
		String[] categorys = form.getCategorys();//物品种类
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		String[] seqnos = form.getSeqnos();//批次号
		String[] outtypes = form.getOuttypes();//出库类型
		String[] reqorgs = form.getReqorgs();//领用机构号
		String[] reqids = form.getReqids();//申请人或下拨人ＩＤ
		String[] reqnames = form.getReqnames();//申请人或下拨人姓名
		String[] reqtimes = form.getReqtimes();//申请或下拨时间
		Integer[] reqnums = form.getReqnums();//申领数量
		Integer[] chknums = form.getChknums();//申批数量
		
		Integer[] outnums = form.getOutnums();//实际出库数量
		String[] chkreasons = form.getChkreasons();//审批说明
		String[] pakreasons = form.getPakreasons();//出库说明
		
		String[] chkids = form.getChkids();//审批人ID
		String[] chknames = form.getChknames();//审批人姓名
		String[] chktimes = form.getChktimes();//审批时间
		String[] stockuserids = form.getStockuserids();//库管人的ID
		String[] stocknames = form.getStocknames();//库管人的名字
		String[] outtimes = form.getOuttimes();//出库时间
		String[] rcvids = form.getRcvids();//接收人ID
		String[] rcvnames = form.getRcvnames();//接收人姓名
		String[] rcvtimes = form.getRcvtimes();//接收时间
		//String[] reqstatuss = form.getReqstatuss();//出库状态
		String[] accountstatuss = form.getAccountstatuss();//结账状态
		Double[] inprices = form.getInprices();//入库单价（未使用）
		Double[] outprices = form.getOutprices();//出库单价
		Double[] outamounts = form.getOutamounts();//出库金额
		Integer[] bigpacknums = form.getBigpacknums();//大包装数量
		Integer[] smallpacknums = form.getSmallpacknums();//小包装数量
		String[] itemversions = form.getItemversions();//凭证版本
		Integer[] stockids = form.getStockids();//stock库存静态信息表的主键ID
		String[] itemsnames = form.getItemsnames();//物品名称
		Integer[] stocknums = form.getStocknums();//库存数量
		String[] types = form.getTypes();//物品类型
		
		outstock.setChknum(chknums[i]==null?0:chknums[i]);//设置审批数量
		outstock.setOutstockid(outstockids[i]==null?0:outstockids[i]);
		outstock.setOutstockorg(outstockorgs[i]==null?"":outstockorgs[i]);
		outstock.setCategory(categorys[i]==null?"":categorys[i]);
		outstock.setSeqcode(seqcodes[i]==null?"":seqcodes[i]);
		outstock.setTypecode(typecodes[i]==null?"":typecodes[i]);
		outstock.setSeqno(seqnos[i]==null?"":seqnos[i]);
		outstock.setOuttype(outtypes[i]==null?"":outtypes[i]);
		outstock.setReqorg(reqorgs[i]==null?"":reqorgs[i]);
		outstock.setReqid(reqids[i]==null?"":reqids[i]);
		outstock.setReqname(reqnames[i]==null?"":reqnames[i]);
		
		outstock.setReqtime(reqtimes[i]==null?"":reqtimes[i]);
		outstock.setReqnum(reqnums[i]==null?0:reqnums[i]);
		outstock.setOutnum(outnums[i]==null?0:outnums[i]);
		outstock.setChkreason(chkreasons[i]==null?"":chkreasons[i]);
		outstock.setPakreason(pakreasons[i]==null?"":pakreasons[i]);
		outstock.setChkid(chkids[i]==null?"":chkids[i]);
		outstock.setChkname(chknames[i]==null?"":chknames[i]);
		outstock.setChktime(chktimes[i]==null?"":chktimes[i]);
		outstock.setStockuserid(stockuserids[i]==null?"":stockuserids[i]);
		
		outstock.setStockname(stocknames[i]==null?"":stocknames[i]);
		outstock.setOuttime(outtimes[i]==null?"":outtimes[i]);
		outstock.setRcvid(rcvids[i]==null?"":rcvids[i]);
		outstock.setRcvname(rcvnames[i]==null?"":rcvnames[i]);
		outstock.setRcvtime(rcvtimes[i]==null?"":rcvtimes[i]);
		outstock.setAccountstatus(accountstatuss[i]==null?"":accountstatuss[i]);
		outstock.setInprice(inprices[i]==null?0:inprices[i]);
		outstock.setOutprice(outprices[i]==null?0:outprices[i]);
		outstock.setOutamount(outamounts[i]==null?0:outamounts[i]);
		outstock.setBigpacknum(bigpacknums[i]==null?0:bigpacknums[i]);
		
		outstock.setSmallpacknum(smallpacknums[i]==null?0:smallpacknums[i]);
		outstock.setItemversion(itemversions[i]==null?"":itemversions[i]);
		outstock.setStockid(stockids[i]==null?0:stockids[i]);
		outstock.setItemsname(itemsnames[i]==null?"":itemsnames[i]);
		outstock.setStocknum(stocknums[i]==null?0:stocknums[i]);
		
		outstock.setType(types[i]==null?"":types[i]);
		
		
		return outstock;
	}
	
	/**
	 * 接收
	 */
	public ITEMS01DTO receiveOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();
		Integer[] outstockids = form.getOutstockids();//outstock表主键ID
		Double[] outprices = form.getOutprices();//出库单价
		Double[] outamounts = form.getOutamounts();//出库金额
		Integer[] outnums = form.getOutnums();//出库数量
		String[] packnos = form.getPacknos();//包裹号

		if(!checkReceiveStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					//设置基本信息
					OutStockTB outstock = getNewTB(form,i);
					outstock.setRcvid(dto.getUserid());
					outstock.setRcvname(dto.getUsername());
					outstock.setRcvtime(CSEHelper.getCurrentTime());
					outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);//出库状态：出库完成
					outstock.setPackno(packnos[i]);
					//更新outstock表
					OutStock os = outStockBL.insertOutStock(outstock);
					
					//支行入库
					
					ITEMS0106Form items0106Form = new ITEMS0106Form();
					items0106Form.setOutnum(0);
					items0106Form.setLossnum(0);
					items0106Form.setHavocnum(0);
					items0106Form.setInstockorg(dto.getOutstockorg());//当前登录用户的所属机构
					items0106Form.setStockorg(dto.getOutstockorg());//当前登录用户的所属机构
					items0106Form.setStatus(DefineUtils.ITEMSCODES_STATUS_WCK);
					items0106Form.setInprice(outprices[i]);//入库单价
					items0106Form.setInamount(outamounts[i]);//入库金额
					items0106Form.setInnum(outnums[i]);//入库数量
					
					items0106Form.setCategory(form.getCategorys()[i]);
					items0106Form.setSeqcode(form.getSeqcodes()[i]);
					items0106Form.setIntime(CSEHelper.getCurrentTime());
					items0106Form.setSeqno(form.getSeqnos()[i]);
					items0106Form.setTypecode(form.getTypecodes()[i]);
					items0106Form.setType(form.getTypes()[i]);
					items0106Form.setItemversion(form.getItemversions()[i]);
					items0106Form.setUserid(dto.getUserid());
					items0106Form.setUsername(dto.getUsername());
					items0106Form.setUpdtime(CSEHelper.getCurrentTime());
					//items0106Form.setIntime(CSEHelper.getCurrentTime());
					items0106Form.setItemsname(form.getItemsnames()[i]);
					
					items0106Form.setOutprice(0d);
					items0106Form.setOutamount(0d);
					items0106Form.setStocknum(outnums[i]);//本次入库数量
					items0106Form.setLossnum(0);
					items0106Form.setLostnum(0);
					items0106Form.setPrenum(0);
					items0106Form.setOutstockid(os.getOutstockid());
					//保存
					insertInStockByReceiveAction(items0106Form);

				}
			}
		}else{
			//页面提交记录的出库状态与数据库中记录的出库状态不一致
			dto.setGoToError("JS_REQSTATUS_ERROR");
		}
		
		return dto;
	}
	
	/**
	 * 接收时，支行入库
	 */
	public void insertInStockByReceiveAction(ITEMS0106Form form) throws BLException {
		inStockBL.insertInStock(form);//插入InStock表
		stockBL.addToStock(form,DefineUtils.STOCK_PRENUM_JS);

	}
	
	/**
	 * 物品下拨
	 */
	public ITEMS01DTO allocateOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0146Form form = dto.getItems0146form();
		String[] reqorgs = form.getReqorgs();//下拨机构号
		Integer[] chknums = form.getChknums();//下拨数量
		Stock stock = stockBL.findStockByPk(dto.getStockid());
	
		if(stock!=null){
			for(int i = 0,j = reqorgs.length;i<j;i++){
				OutStockTB outstock = new OutStockTB();
				//设置物品信息
				outstock.setCategory(stock.getCategory());
				outstock.setItemsname(stock.getItemsname());
				outstock.setSeqcode(stock.getSeqcode());
				outstock.setTypecode(stock.getTypecode());
				outstock.setStockid(stock.getStockid());
				outstock.setChknum(chknums[i]);//设置审批数量为页面填写的下拨数量
				outstock.setType(stock.getType());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqtime(CSEHelper.getCurrentTime());
				//outstock.setStocknum(stocknum);
				
				//设置下拨的相关信息
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//出库类型：总行下拨
				outstock.setReqorg(reqorgs[i]);//申领机构
				outstock.setChkid(dto.getUserid());
				outstock.setChkname(dto.getUsername());
				outstock.setChktime(CSEHelper.getCurrentTime());
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//出库状态：待出库
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//结账状态：未结账
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				outStockBL.insertOutStock(outstock);
				
				//将在stock表中的被下拨的物品记录的prenum（变动数量增加）
				StockTB stock1 = new StockTB();
				stock1.clone(stock);
				stock1.setStockid(dto.getStockid());
				stock1.setPrenum(chknums[i]);//下拨数量
				stockBL.addToStock(stock1,DefineUtils.STOCK_PRENUM_XB);//下拨
				
			}
		}

		return dto;
	}
	

	/**
	 * 根据传入参数获取其部分的下拉列表('下拨查询'页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0147(String selectid){
		List<ItemsCodes> list = itemsCodesBL.getItemsCodesList(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		//codeList.add(new LabelValueBean("", ""));
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			if(DefineUtils.ITEMSCODES_REQSTATUS_DCK.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_DJS.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_CKWC.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}
		}

		return codeList;
	}
	
	
	/**
	 * 根据传入参数获取其部分的下拉列表(我的申领页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodesFor0144(String selectid){
		List<ItemsCodes> list = itemsCodesBL.getItemsCodesList(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		//codeList.add(new LabelValueBean("", ""));
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			if(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_DCK.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_DJS.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_SPWTG.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_CKWC.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}
		}

		return codeList;
	}
	
	/**
	 * 根据传入参数获取其部分的下拉列表(申领审批页，'状态'用)
	 */
	public List<LabelValueBean> getPartItemsCodes(String selectid){
		List<ItemsCodes> list = itemsCodesBL.getItemsCodesList(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		//codeList.add(new LabelValueBean("", ""));
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			if(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_DCK.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}
		}

		return codeList;
	}
	
	/**
	 * 根据传入参数获取其全部的下拉列表
	 */
	public List<LabelValueBean> getItemsCodes(String selectid){
		List<ItemsCodes> list = CodeValueBean.getConfigInfo(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		if(!DefineUtils.ITEMSCODES_STOCK_NATURE.equals(selectid) &&
				!DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS.equals(selectid)){
			codeList.add(new LabelValueBean("", ""));
		}
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
		}
		return codeList;
	}
	
	/**
	 * 根据传入参数获取其全部的下拉列表
	 */
	public List<LabelValueBean> getItemsCodesFor0129Action(String selectid){
		List<ItemsCodes> list = CodeValueBean.getConfigInfo(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		codeList.add(new LabelValueBean("", ""));
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			if(DefineUtils.ITEMSCODES_REQSTATUS_DJS.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}else if(DefineUtils.ITEMSCODES_REQSTATUS_CKWC.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}
			
		}
		return codeList;
	}
	
	
	public String getRequsetStatus(String selectid) throws BLException {
		return itemsCodesBL.getItemsCodesList(selectid).get(0).getStatus();
	}
	
	/**
	 * 根据传入参数获取其部分的下拉列表(库存管理页，'调整类型'用)
	 */
	public List<LabelValueBean> getPartOutStockTypeCodes(String selectid){//ITEMSCODES_OUTSTOCK_OUTTYPE
		List<ItemsCodes> list = itemsCodesBL.getItemsCodesList(selectid);
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
//		codeList.add(new LabelValueBean("", ""));
		for(Iterator<ItemsCodes> iter = list.iterator();iter.hasNext();){
			ItemsCodes itemsCodes = iter.next();
			if(DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			} else if (DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			} else if (DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(itemsCodes.getTypecode())){
				codeList.add(new LabelValueBean(itemsCodes.getTypename(), itemsCodes.getTypecode()));
			}
		}
		return codeList;
	}

	/**
	 * 返回传入参数之积
	 * @return
	 */
	private BigDecimal getMultiply(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * 返回传入参数之商
	 * @return
	 */
	private BigDecimal getDivide(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	/**
	 * 返回传入参数之差
	 * @return
	 */
	private BigDecimal getSubtract(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.subtract(bd2_b);
	}
	
	/**
	 * 返回传入参数之和
	 * @return
	 */
	private BigDecimal getAdd(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.add(bd2_b);
	}
	
	protected ITEMS01DTO insertInStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0106Form items0106Form = dto.getItems0106form();
		items0106Form.setOutnum(0);
		items0106Form.setLossnum(0);
		items0106Form.setHavocnum(0);
		items0106Form.setInstockorg(DefineUtils.DEFAULT_ORGNO);
		items0106Form.setStockorg(DefineUtils.DEFAULT_ORGNO);
		items0106Form.setStatus(DefineUtils.ITEMSCODES_STATUS_WCK);
		double inprice = items0106Form.getInprice();//入库单价
		int innum = items0106Form.getInnum();//入库数量
		double inamount = getMultiply(String.valueOf(inprice),String.valueOf(innum)).doubleValue(); //入库总金额
		items0106Form.setInamount(inamount);
		double outprice = items0106Form.getOutprice();//出货单价
		double outamount = getMultiply(String.valueOf(outprice),String.valueOf(innum)).doubleValue();
		items0106Form.setOutamount(outamount);
		items0106Form.setStocknum(items0106Form.getInnum());
		items0106Form.setLostnum(0);
		items0106Form.setPrenum(0);
		items0106Form.setIntime(CSEHelper.getCurrentTime());			
		items0106Form.setSeqno(this.getSeqno("I", items0106Form.getCategory(), items0106Form.getSeqcode(), DefineUtils.DEFAULT_ORGNO));
		InStock inStock = inStockBL.insertInStock(items0106Form);//插入InStock表

		Stock stock = stockBL.addToStock(items0106Form,DefineUtils.STOCK_PRENUM_RK);
		
		//插入明细表
		OutStockDetailTB outStockDetail = new OutStockDetailTB();		
		outStockDetail.setCategory(items0106Form.getCategory());//物品种类
		outStockDetail.setSeqcode(items0106Form.getSeqcode());//物品编号
		outStockDetail.setTypecode(items0106Form.getTypecode());//物品型号
		outStockDetail.setItemsname(items0106Form.getItemsname());//物品名称

		outStockDetail.setInstockid(inStock.getInstockid());
		outStockDetail.setInprice(items0106Form.getInprice());//入库单价
		outStockDetail.setOutprice(items0106Form.getOutprice());//出库单价
		outStockDetail.setOutamount(inamount);//入库金额
		outStockDetail.setOutnum(items0106Form.getInnum());//入库数量
		outStockDetail.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
		outStockDetail.setReqorg(DefineUtils.DEFAULT_ORGNO);
		outStockDetail.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_RK);//类型为入库
		outStockDetail.setInseqno(items0106Form.getSeqno());//批次号
		outStockDetail.setOuttime(CSEHelper.getCurrentTime());//入库时间
		outStockDetail.setStocknum(stock.getStocknum());
		outStockDetailBL.insertOutStockDetail(outStockDetail);
		dto.setInStock(inStock);
		dto.setStock(stock);
		return dto;
	}

	public ITEMS01DTO searchInStockAction(ITEMS01DTO dto) throws BLException {
		String category = dto.getCategory();//种类
		String seqcode = dto.getSeqcode();//编号
		
//		User user = dto.getUser();
//		//取当前用户角色类型为DefineUtils.ITEMS_ROLETYPE的角色集合
//		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
//		rolecond.setUserid(user.getUserid());
//		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
//		boolean flag = false;//是否可以管理总行库存
//		for(UserRoleInfo ur:urlist){
//			//如果角色类型为耗材管理默认角色类型
//			if(DefineUtils.ITEMS_ROLETYPE.equals(ur.getRoletype())){
//				if(userRoleBL.checkRoleManagerByID(user.getUserid(), ur.getRoleid())){
//					flag = true;
//					break;
//				}
//				
//			}
//			
//		}

		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setShowNoneStock(dto.isShowNoneStock());
		if(checkRoleManagerByUserID(dto)){
			cond.setInstockorg(DefineUtils.DEFAULT_ORGNO);
		}else{
			cond.setInstockorg(dto.getUser().getOrgid());//用户所属机构
		}
		
		//cond.setInstockorg_q(dto.getUserorg());
		List<InStock> inStockList = inStockBL.searchInStock(cond, 0, 0);
		int totalCount = inStockList.size();
		if (totalCount == 0) {
			// 查询数据不存在
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// 查询数据件数过多
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		inStockList = inStockBL.searchInStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		Map<String,String> editMap = new HashMap<String,String>();
		boolean flag = false;
		for(InStock instock:inStockList){
			flag = false;
			OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
			detailcond.setInstockid(String.valueOf(instock.getInstockid()));
			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
			for(OutStockDetail detail:detailList){
				if(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ.equals(detail.getAccountstatus())){
					//如果已结账则不可修改入库单价和出库单价
					flag = true;
					break;
				}
			}
			if(flag){
				editMap.put(String.valueOf(instock.getInstockid()), DefineUtils.INSTOCK_PRICE_EDIT_FALSE);
			}else{
				editMap.put(String.valueOf(instock.getInstockid()), DefineUtils.INSTOCK_PRICE_EDIT_TRUE);
			}
		}
		
		
		
		pDto.setTotalCount(totalCount);
		dto.setInStockList(inStockList);
		dto.setEditMap(editMap);
		return dto;
	}

	protected ITEMS01DTO adjustStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0111Form items0111form = dto.getItems0111form();
		String category = items0111form.getCategory();
		String seqcode = items0111form.getSeqcode();
		Integer[] instockids = items0111form.getInstockid();
		Integer[] adjInnums = items0111form.getInputSubInnum();
		Integer allAdjInnums = 0;
		
		//查询调整前的库存情况
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			cond.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		if(stockList==null || stockList.size()==0){
			throw new BLException("ITEMS0110.E001");//库存机构不存在
		}
		Stock oldStock = stockList.get(0);
		
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];
			Integer adjInnum = adjInnums[i];
			allAdjInnums += adjInnum;
			InStock inStock = inStockBL.findInStockByPk(instockid);
			Integer outnum = inStock.getOutnum();
			Integer lossnum = inStock.getLossnum();
			Integer javocnum = inStock.getHavocnum();
			Integer innum = inStock.getInnum();
			//当用户输入的数量大于可用库存时，返回null，页面转让错误页。
			if(innum - outnum - lossnum - javocnum + adjInnum < 0){
				return null;
			}
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			inStockTB.setInnum(inStock.getInnum() + adjInnum);
			InStock newinStock = inStockBL.insertInStock(inStockTB);
			
			//新增出库明细
			OutStockDetailTB outStockDetail = new OutStockDetailTB();
			outStockDetail.setCategory(newinStock.getCategory());//物品种类
			outStockDetail.setSeqcode(newinStock.getSeqcode());//物品编号
			outStockDetail.setTypecode(newinStock.getTypecode());//物品型号
			outStockDetail.setItemsname(newinStock.getItemsname());//物品名称
			
			outStockDetail.setInstockid(newinStock.getInstockid());
			outStockDetail.setOutnum(adjInnum);//调整数量
			outStockDetail.setInprice(newinStock.getInprice());//入库单价
			outStockDetail.setOutprice(newinStock.getOutprice());//出库单价
			outStockDetail.setOutamount(getMultiply(String.valueOf(newinStock.getInprice()), String.valueOf(adjInnum)).doubleValue());//调整金额
			outStockDetail.setStocknum(allAdjInnums + oldStock.getStocknum());//库存数量
			outStockDetail.setInseqno(newinStock.getSeqno());//批次号
			outStockDetail.setOuttime(CSEHelper.getCurrentTime());//调整时间
			outStockDetail.setOutstockorg(newinStock.getInstockorg());
			outStockDetail.setReqorg(newinStock.getInstockorg());
			outStockDetail.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_RKTZ);//出库类型：入库调整
			outStockDetailBL.insertOutStockDetail(outStockDetail);
		}

		StockTB stockTB = new StockTB();
		stockTB.setCategory(category);
		stockTB.setSeqcode(seqcode);
		stockTB.setPrenum(allAdjInnums);
		stockTB.setUserid(items0111form.getUserid());
		stockTB.setUsername(items0111form.getUsername());
		if(checkRoleManagerByUserID(dto)){
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		
		//在库存总表中减去减少的库存
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_TZ);
		dto.setStock(stock);
		return dto;
	}

	protected ITEMS01DTO useItemsAction(ITEMS01DTO dto) throws BLException {
		ITEMS0116Form items0116form = dto.getItems0116form();
		String category = items0116form.getCategory();
		String seqcode = items0116form.getSeqcode();
		Integer[] instockids = items0116form.getInstockid();//传入的inStock表ID
		Integer[] useNums = items0116form.getUseNum();
		//String[] descs = items0116form.getDesc();
		String[] reqorgs = items0116form.getReqorg();
		String[] reqnames = items0116form.getReqname();
		
		Integer allUseItemsNum = 0;

		//查询调整前的库存情况
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			cond.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		if(stockList==null || stockList.size()==0){
			throw new BLException("ITEMS0110.E001");//库存机构不存在
		}
		Stock oldStock = stockList.get(0);
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];
			Integer useNum = useNums[i];
			allUseItemsNum += useNum;
			String reqorg = reqorgs[i];
			String reqname = reqnames[i];
			InStock inStock = inStockBL.findInStockByPk(instockid);
			//当使用的数量大于可用数量时(使用数量+出库数量+损耗数量+销毁数量>入库数量)，返回null，转入错误页面
			if(useNum + inStock.getOutnum() + inStock.getLossnum() + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			inStockTB.setOutnum(useNum + inStock.getOutnum());
			inStockBL.insertInStock(inStockTB);
			OutStockTB outStockTB = new OutStockTB();
			//当支行使用时不设置结账状态，因为支行在申领或下拨时已进行过结账
			if(DefineUtils.DEFAULT_ORGNO.equals(inStock.getInstockorg())){
				outStockTB.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//设置为未结账
			}

			outStockTB.setCategory(category);
			outStockTB.setSeqcode(seqcode);
			outStockTB.setOutstockorg(inStock.getInstockorg());
			outStockTB.setTypecode(inStock.getTypecode());
			outStockTB.setSeqno(inStock.getSeqno());
			outStockTB.setOuttype(DefineUtils.STOCK_PRENUM_SY);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			outStockTB.setOutnum(useNum);
//			outStockTB.setPakreason(desc);
			outStockTB.setReqorg(reqorg);    //设置使用人机构
			outStockTB.setRcvname(reqname);//使用人姓名
			outStockTB.setReqid(dto.getUser().getUserid());//操作人ID
			outStockTB.setReqname(dto.getUser().getUsername());  //操作人姓名

			String time = CSEHelper.getCurrentTime();
			outStockTB.setReqtime(time);//领用时间
			outStockTB.setRcvtime(time);//操作时间
			outStockTB.setOuttime(time);//操作时间
			outStockTB.setInprice(inStock.getInprice());
			outStockTB.setOutprice(inStock.getOutprice());
			outStockTB.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());
			outStockTB.setItemsname(inStock.getItemsname());
			//outStockList.add(outStockTB);
			OutStock outStock1 = outStockBL.insertOutStock(outStockTB);
			
			//新增出库明细
			
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
			outStockDetail.setOutstockid(outStock1.getOutstockid());
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(useNum);//使用数量
			outStockDetail.setInprice(inStock.getInprice());//入库单价
			outStockDetail.setOutprice(inStock.getOutprice());//出库单价
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//出库金额
			outStockDetail.setStocknum(oldStock.getStocknum() - allUseItemsNum);
			outStockDetail.setInseqno(inStock.getSeqno());
			outStockDetailBL.insertOutStockDetail(outStockDetail);
			
		}

		
		StockTB stockTB = new StockTB();
		stockTB.setCategory(category);
		stockTB.setSeqcode(seqcode);
		stockTB.setPrenum(allUseItemsNum);
		stockTB.setUserid(items0116form.getUserid());
		stockTB.setUsername(items0116form.getUsername());
		if(checkRoleManagerByUserID(dto)){
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		//在库存总表中减去使用的部分
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SY);
		dto.setStock(stock);
		return dto;
	}
	
	protected ITEMS01DTO wasteItemsAction(ITEMS01DTO dto) throws BLException {
		ITEMS0116Form items0116form = dto.getItems0116form();
		String category = items0116form.getCategory();
		String seqcode = items0116form.getSeqcode();
		Integer[] instockids = items0116form.getInstockid();
		Integer[] useNums = items0116form.getUseNum();
		String[] descs = items0116form.getDesc();
		Integer allWasteItemsNum = 0;
		//List<OutStock> outStockList = new ArrayList<OutStock>();
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];
			Integer useNum = useNums[i];
			allWasteItemsNum += useNum;
			String desc = descs[i];
			InStock inStock = inStockBL.findInStockByPk(instockid);
			//当申请报废的数量大于可用数量时(申请报废数量+出库数量+损耗数量+销毁数量>入库数量)，返回null，转入错误页面
			if(useNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_SH);
			outStockTB.setInstockid(inStock.getInstockid());
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SHDSP);
			outStockTB.setCategory(category);
			outStockTB.setSeqcode(seqcode);
			outStockTB.setOutstockorg(inStock.getInstockorg());
			outStockTB.setTypecode(inStock.getTypecode());
			outStockTB.setSeqno(inStock.getSeqno());
			outStockTB.setReqorg(dto.getUser().getOrgid());//申请人的所属机构
			outStockTB.setReqnum(useNum);
			outStockTB.setPakreason(desc);
			outStockTB.setReqtime(CSEHelper.getCurrentTime());
			outStockTB.setInprice(inStock.getInprice());
			outStockTB.setOutprice(inStock.getOutprice());
			outStockTB.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());
			outStockTB.setItemsname(inStock.getItemsname());
			outStockTB.setStockuserid(items0116form.getUserid());
			outStockTB.setStockname(items0116form.getUsername());
			//outStockList.add(outStockTB);
			outStockBL.insertOutStock(outStockTB);
			
			//新增出库明细
//			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
//			outStockDetail.setOutstockid(outStock.getOutstockid());
//			outStockDetail.setInstockid(inStock.getInstockid());
//			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SHDSP);
//			outStockDetail.setOutnum(useNum);//损耗数量
//			outStockDetail.setInprice(inStock.getInprice());//入库单价
//			outStockDetail.setOutprice(inStock.getOutprice());//出库单价
//			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//出库金额
//			outStockDetail.setStocknum(inStock.getInnum()-inStock.getOutnum()-inStock.getLossnum()-inStock.getHavocnum());
//			outStockDetail.setOuttime("");
//			outStockDetailBL.insertOutStockDetail(outStockDetail);
		}
		//outStockBL.saveOrUpdateAll(outStockList);
		StockTB stockTB = new StockTB();
		stockTB.setCategory(category);
		stockTB.setSeqcode(seqcode);
		stockTB.setPrenum(allWasteItemsNum);
		stockTB.setUserid(items0116form.getUserid());
		stockTB.setUsername(items0116form.getUsername());
		if(checkRoleManagerByUserID(dto)){
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		//在库存总表中让“变动数量”加上申请损耗数量
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SH);
		dto.setStock(stock);
		return dto;
	}

	protected ITEMS01DTO destroyItemsAction(ITEMS01DTO dto) throws BLException {
		ITEMS0116Form items0116form = dto.getItems0116form();
		String category = items0116form.getCategory();
		String seqcode = items0116form.getSeqcode();
		Integer[] instockids = items0116form.getInstockid();//inStock表主键
		Integer[] useNums = items0116form.getUseNum();
		String[] descs = items0116form.getDesc();
		Integer destroyItemsNum = 0;
		//List<OutStock> outStockList = new ArrayList<OutStock>();
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];
			Integer useNum = useNums[i];
			String desc = descs[i];
			destroyItemsNum += useNum;
			InStock inStock = inStockBL.findInStockByPk(instockid);
			if(useNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.setInstockid(inStock.getInstockid());
			outStockTB.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_XH);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_XHDSP);
			outStockTB.setCategory(category);
			outStockTB.setSeqcode(seqcode);
			outStockTB.setOutstockorg(inStock.getInstockorg());
			outStockTB.setTypecode(inStock.getTypecode());
			outStockTB.setSeqno(inStock.getSeqno());
			outStockTB.setReqorg(dto.getUser().getOrgid());//申请人的所属机构
			outStockTB.setReqnum(useNum);
			outStockTB.setPakreason(desc);
			outStockTB.setReqtime(CSEHelper.getCurrentTime());
			outStockTB.setInprice(inStock.getInprice());
			outStockTB.setOutprice(inStock.getOutprice());
			outStockTB.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());
			outStockTB.setItemsname(inStock.getItemsname());
			outStockTB.setStockuserid(items0116form.getUserid());
			outStockTB.setStockname(items0116form.getUsername());
			//outStockList.add(outStockTB);
			outStockBL.insertOutStock(outStockTB);
			//新增出库明细
//			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
//			outStockDetail.setOutstockid(outStock.getOutstockid());
//			outStockDetail.setInstockid(inStock.getInstockid());
//			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_XHDSP);
//			outStockDetail.setOutnum(useNum);//销毁数量
//			outStockDetail.setInprice(inStock.getInprice());//入库单价
//			outStockDetail.setOutprice(inStock.getOutprice());//出库单价
//			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//出库金额
//			outStockDetail.setStocknum(inStock.getInnum()-inStock.getOutnum()-inStock.getLossnum()-inStock.getHavocnum());
//			outStockDetail.setOuttime("");
//			outStockDetailBL.insertOutStockDetail(outStockDetail);
		}
		//outStockBL.saveOrUpdateAll(outStockList);
		
		StockTB stockTB = new StockTB();
		stockTB.setCategory(category);
		stockTB.setSeqcode(seqcode);
		stockTB.setPrenum(destroyItemsNum);
		stockTB.setUserid(items0116form.getUserid());
		stockTB.setUsername(items0116form.getUsername());
		if(checkRoleManagerByUserID(dto)){
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//顶级机构
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//当前用户机构
		}
		//在库存总表中让“变动数量”加上申请销毁数量
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_XH);
		dto.setStock(stock);
		
		return dto;
	}
	
	//损耗通过
	protected ITEMS01DTO approveWaste(ITEMS01DTO dto) throws BLException{
		String nowTime = CSEHelper.getCurrentTime();
		Integer[] outstockids = dto.getItems0121form().getOutstockid();
		for (int i = 0; i < outstockids.length; i++) {
			Integer outstockid = outstockids[i];
			OutStock oldOutStock = outStockBL.findOutStockByPk(outstockid);
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.clone(oldOutStock);
			outStockTB.setOutstockid(oldOutStock.getOutstockid());
			outStockTB.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_SH);
			Integer inStockId = oldOutStock.getInstockid();
			Integer reqNum = oldOutStock.getReqnum();
			InStock inStock = inStockBL.findInStockByPk(inStockId);
			//当申请销毁的数量大于可用数量时(申请销毁数量+出库数量+损耗数量+销毁数量>入库数量)，返回null，转入错误页面
			if(reqNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			outStockTB.setOutnum(reqNum);
//			outStockTB.setReqnum(0);
			outStockTB.setChktime(nowTime);
			outStockTB.setOuttime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			OutStock outStock = outStockBL.insertOutStock(outStockTB);
			
			//查询出库明细
//			OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
//			detailcond.setOutstockid(outstockid);
//			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
//			if (detailList == null || detailList.size()==0){
//				throw new BLException("ITEMS0120.E001");
//			}

			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			Integer oldLossNum = inStock.getLossnum();
			inStockTB.setLossnum(reqNum + oldLossNum);
			inStockBL.insertInStock(inStockTB);
			String category = oldOutStock.getCategory();
			String seqcode = oldOutStock.getSeqcode();
			StockSearchCondImpl cond = new StockSearchCondImpl();
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setStockorg(dto.getUserorg());//当前用户机构
			List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
			if(stockList==null || stockList.size()==0){
				throw new BLException("ITEMS0110.E001");//库存机构不存在
			}
			Stock oldStock = stockList.get(0);
			
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			Integer lostNum = oldStock.getLostnum();
			stockTB.setLostnum(reqNum + lostNum);
			Integer preNum = oldStock.getPrenum();
			if(preNum == null || preNum == 0 || preNum < reqNum){
				return null;
			}
			stockTB.setPrenum(preNum - reqNum);
			stockTB.setStocknum(oldStock.getStocknum() - reqNum);
			stockTB.setUptime(nowTime);
			stockTB.setUserid(dto.getUserid());
			stockTB.setUsername(dto.getUsername());
			Stock stock = stockBL.saveOrUpdateStock(stockTB);
			
			//更新出库明细
//			OutStockDetail osd = detailList.get(0);
//			OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
			outStockDetail.setOutstockid(outStock.getOutstockid());
			//outStockDetail.setId(detailList.get(0).getId());
			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(reqNum);//损耗通过数量
			outStockDetail.setInprice(inStock.getInprice());//入库单价
			outStockDetail.setOutprice(inStock.getOutprice());//出库单价
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(reqNum)).doubleValue());//出库金额
			outStockDetail.setChktime(nowTime);
			outStockDetail.setOuttime(nowTime);
			outStockDetail.setStocknum(stock.getStocknum());
			outStockDetail.setInseqno(inStock.getSeqno());
			outStockDetailBL.insertOutStockDetail(outStockDetail);
			

		}
		return dto;
	}
	
	protected ITEMS01DTO approveDestroy(ITEMS01DTO dto) throws BLException{
		String nowTime = CSEHelper.getCurrentTime();
		Integer[] outstockids = dto.getItems0121form().getOutstockid();
		for (int i = 0; i < outstockids.length; i++) {
			Integer outstockid = outstockids[i];
			OutStock oldOutStock = outStockBL.findOutStockByPk(outstockid);
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.clone(oldOutStock);
			outStockTB.setOutstockid(oldOutStock.getOutstockid());
			outStockTB.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_XH);
			Integer inStockId = oldOutStock.getInstockid();
			Integer reqNum = oldOutStock.getReqnum();
			InStock inStock = inStockBL.findInStockByPk(inStockId);
			//当申请销毁的数量大于可用数量时(申请销毁数量+出库数量+损耗数量+销毁数量>入库数量)，返回null，转入错误页面
			if(reqNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			outStockTB.setOutnum(reqNum);
//			outStockTB.setReqnum(0);
			outStockTB.setChktime(nowTime);
			outStockTB.setOuttime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			OutStock outStock = outStockBL.insertOutStock(outStockTB);
			
			//查询出库明细
//			OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
//			detailcond.setOutstockid(outstockid);
//			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
//			if (detailList == null || detailList.size()==0){
//				throw new BLException("ITEMS0120.E001");
//			}

			
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
//			inStockTB.setLossnum(inStock.getLossnum() - reqNum);
			inStockTB.setHavocnum(inStock.getHavocnum() + reqNum);
			inStockBL.insertInStock(inStockTB);
			String category = oldOutStock.getCategory();
			String seqcode = oldOutStock.getSeqcode();
			StockSearchCondImpl cond = new StockSearchCondImpl();
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setStockorg(dto.getUserorg());
			List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
			if(stockList==null || stockList.size()==0){
				throw new BLException("ITEMS0110.E001");//库存机构不存在
			}
			Stock oldStock = stockList.get(0);

			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			Integer lostNum = oldStock.getLostnum();
			stockTB.setLostnum(lostNum + reqNum);
			stockTB.setStocknum(oldStock.getStocknum() - reqNum);
			Integer preNum = oldStock.getPrenum();
			//不存在变动数量，或者变动数量小于申请销毁的数量（相减得负数），返回错误页
			if(preNum == null || preNum == 0 || preNum < reqNum){
				return null;
			}
			stockTB.setPrenum(preNum - reqNum);
			stockTB.setUptime(nowTime);
			stockTB.setUserid(dto.getUserid());
			stockTB.setUsername(dto.getUsername());
			Stock stock = stockBL.saveOrUpdateStock(stockTB);
			
			//更新出库明细
//			OutStockDetail osd = detailList.get(0);
//			OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
			outStockDetail.setOutstockid(outStock.getOutstockid());
			//outStockDetail.setId(detailList.get(0).getId());
			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(reqNum);//损耗通过数量
			outStockDetail.setInprice(inStock.getInprice());//入库单价
			outStockDetail.setOutprice(inStock.getOutprice());//出库单价
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(reqNum)).doubleValue());//出库金额
			outStockDetail.setChktime(nowTime);
			outStockDetail.setOuttime(nowTime);
			outStockDetail.setStocknum(stock.getStocknum());
			outStockDetail.setInseqno(inStock.getSeqno());
			outStockDetailBL.insertOutStockDetail(outStockDetail);
			
		}
		return dto;
	}
	
	protected ITEMS01DTO noApproveWaste(ITEMS01DTO dto) throws BLException{
		String nowTime = CSEHelper.getCurrentTime();
		Integer[] outstockids = dto.getItems0121form().getOutstockid();
		for (int i = 0; i < outstockids.length; i++) {
			Integer outstockid = outstockids[i];
			OutStock oldOutStock = outStockBL.findOutStockByPk(outstockid);
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.clone(oldOutStock);
			outStockTB.setOutstockid(oldOutStock.getOutstockid());
//			outStockTB.setOuttype(DefineUtils.STOCK_PRENUM_SH);
			outStockTB.setChktime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SPWTG);
			outStockBL.insertOutStock(outStockTB);

			
			String category = oldOutStock.getCategory();
			String seqcode = oldOutStock.getSeqcode();
			StockSearchCondImpl cond = new StockSearchCondImpl();
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setStockorg(dto.getUserorg());
			Stock oldStock = stockBL.searchStock(cond, 0, 0).get(0);
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			stockTB.setPrenum(oldStock.getPrenum() - oldOutStock.getReqnum());
			stockTB.setUptime(nowTime);
			stockTB.setUserid(dto.getUserid());
			stockTB.setUsername(dto.getUsername());
			stockBL.saveOrUpdateStock(stockTB);
		}
		return dto;
	}
	
	protected ITEMS01DTO noApproveDestroy(ITEMS01DTO dto) throws BLException{
		String nowTime = CSEHelper.getCurrentTime();
		Integer[] outstockids = dto.getItems0121form().getOutstockid();
		for (int i = 0; i < outstockids.length; i++) {
			Integer outstockid = outstockids[i];
			OutStock oldOutStock = outStockBL.findOutStockByPk(outstockid);
			OutStockTB outStockTB = new OutStockTB();
			outStockTB.clone(oldOutStock);
			outStockTB.setOutstockid(oldOutStock.getOutstockid());
//			outStockTB.setOuttype(DefineUtils.STOCK_PRENUM_XH);
			outStockTB.setChktime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SPWTG);
			outStockBL.insertOutStock(outStockTB);
			
			
			String category = oldOutStock.getCategory();
			String seqcode = oldOutStock.getSeqcode();
			StockSearchCondImpl cond = new StockSearchCondImpl();
			cond.setCategory(category);
			cond.setSeqcode(seqcode);
			cond.setStockorg(dto.getUserorg());
			Stock oldStock = stockBL.searchStock(cond, 0, 0).get(0);
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			stockTB.setPrenum(oldStock.getPrenum() - oldOutStock.getReqnum());
			stockTB.setUptime(nowTime);
			stockTB.setUserid(dto.getUserid());
			stockTB.setUsername(dto.getUsername());
			stockBL.saveOrUpdateStock(stockTB);
		}
		return dto;
	}

	protected ITEMS01DTO editInStockAction(ITEMS01DTO dto){
		ITEMS0110Form items0110form = dto.getItems0110form();
		Integer[] instockids = items0110form.getInstockid();
		Double[] editInprises = items0110form.getEditInprise();//需要修改的入库单价
		Double[] editOutprises = items0110form.getEditOutprise();//需要修改的出库单价
		List<Integer> outstockidList = new ArrayList<Integer>();
		//List<OutStockDetail> osdList = new ArrayList<OutStockDetail>();
		Map<Integer,List<OutStockDetail>> map = new HashMap<Integer,List<OutStockDetail>>();//<outstockid,List<OutStockDetail>>
		
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];//inStock表主键
			Double editInprise = editInprises[i];
			Double editOutprise = editOutprises[i];
			InStock inStock = inStockBL.findInStockByPk(instockid);
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			inStockTB.setInprice(editInprise);
			inStockTB.setOutprice(editOutprise);
			inStockBL.insertInStock(inStockTB);
			OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
			detailcond.setInstockid(String.valueOf(inStock.getInstockid()));
			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
			boolean flag = false;//是否应该被更新
			if(detailList!=null && detailList.size()>0){
				for(OutStockDetail detail:detailList){
					//查询对应的出库记录
					if(detail.getOutstockid()!=null && detail.getOutstockid()!=0){
						OutStock outStock = outStockBL.findOutStockByPk(detail.getOutstockid());
						//查询该出库记录对应的全部出库明细
						detailcond = new OutStockDetailSearchCondImpl();
						detailcond.setOutstockid(outStock.getOutstockid());
						List<OutStockDetail> osdList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
						for(OutStockDetail osd:osdList){
							flag = false;
							//只有确实被调整的入库记录对应的明细记录才被修改
							if(inStock.getInstockid().equals(osd.getInstockid())){
								flag = true;
							}
							//更新入库、出库明细
							OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);			
							//outStockDetail.setInstockid(inStock.getInstockid());
							if(flag){
								outStockDetail.setInprice(editInprise);//入库单价
								outStockDetail.setOutprice(editOutprise);//出库单价
							}
							if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(osd.getOuttype())
								 || DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(osd.getOuttype())){
								if(flag){
									outStockDetail.setOutamount(getMultiply(String.valueOf(editInprise), String.valueOf(osd.getOutnum())).doubleValue());//入库金额
									outStockDetailBL.insertOutStockDetail(outStockDetail);
								}
								
							}else if(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_ZHXB.equals(osd.getOuttype())
									|| DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(osd.getOuttype())){
								if(flag){
									outStockDetail.setOutamount(getMultiply(String.valueOf(editOutprise), String.valueOf(osd.getOutnum())).doubleValue());//出库金额
									outStockDetailBL.insertOutStockDetail(outStockDetail);
								}
								
								if(map.get(outStockDetail.getOutstockid())!=null){
									List<OutStockDetail> osDetail = map.get(outStockDetail.getOutstockid());
									if(!osDetail.contains(outStockDetail)){
										osDetail.add(outStockDetail);
									}
									map.put(outStockDetail.getOutstockid(), osDetail);
								}else{
									List<OutStockDetail> osDetail = new ArrayList<OutStockDetail>();
									osDetail.add(outStockDetail);
									map.put(outStockDetail.getOutstockid(), osDetail);
								}
								if(!outstockidList.contains(outStockDetail.getOutstockid())){
									outstockidList.add(outStockDetail.getOutstockid());
								}
							}
						}
						
					}else{
						//outstockid不存在，则说明该明细为入库记录或入库调整记录
						flag = false;
						//只有确实被调整的入库记录对应的明细记录才被修改
						if(inStock.getInstockid().equals(detail.getInstockid())){
							flag = true;
						}
						//更新入库、出库明细
						OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(detail);			
						//outStockDetail.setInstockid(inStock.getInstockid());
						if(flag){
							outStockDetail.setInprice(editInprise);//入库单价
							outStockDetail.setOutprice(editOutprise);//出库单价
						}
						if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(detail.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(detail.getOuttype())
							 || DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(detail.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(detail.getOuttype())){
							if(flag){
								outStockDetail.setOutamount(getMultiply(String.valueOf(editInprise), String.valueOf(detail.getOutnum())).doubleValue());//入库金额
								outStockDetailBL.insertOutStockDetail(outStockDetail);
							}
							
						}
						
					}


				}
			}
			
		}
		//更新出库信息
		Double out_price = 0d;//出库单价
		Double out_amount = 0d;//出库金额
		Double out_price_part = 0d;//出库单价合计
		if(outstockidList!=null && outstockidList.size()>0){
			for(Integer outstockid:outstockidList){
				OutStock outStock = outStockBL.findOutStockByPk(outstockid);
				OutStockTB ostb = (OutStockTB)SerializationUtils.clone(outStock);	
				out_price = 0d;
				out_amount = 0d;
				out_price_part = 0d;
				
				//计算出库平均单价及出库金额
				List<OutStockDetail> detailList = map.get(outstockid);
				for(OutStockDetail detail:detailList){
					out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(detail.getOutprice()), String.valueOf(detail.getOutnum())).doubleValue())).doubleValue();
						
				}
				if(detailList!=null && detailList.size()>0){
					out_price = getDivide(String.valueOf(out_price_part), String.valueOf(outStock.getOutnum())).doubleValue();
					out_price = round(out_price,4);
					out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outStock.getOutnum())).doubleValue();
					out_amount = round(out_amount,4);
					
					ostb.setOutprice(out_price);
					ostb.setOutamount(out_amount);
					outStockBL.insertOutStock(ostb);
					
					//更新支行接收记录
					InStockSearchCondImpl incond = new InStockSearchCondImpl();
					incond.setOutstockid(outstockid);
					List<InStock> inlist = inStockBL.searchInStock(incond, 0, 0);
					for(InStock inStock:inlist){
						InStockTB inStockTB = new InStockTB();
						inStockTB.clone(inStock);
						inStockTB.setInstockid(inStock.getInstockid());
						inStockTB.setInprice(out_price);//更新支行入库价格为调整后的出库价格
						inStockTB.setInamount(getMultiply(String.valueOf(out_price), String.valueOf(inStock.getInnum())).doubleValue());
						inStockBL.insertInStock(inStockTB);
					}
				}
				
				
			}
		}
		
		
		
		
		return dto;
	}
	
	protected ITEMS01DTO payAction(ITEMS01DTO dto){
		Integer[] outstockids = dto.getItems0126form().getOutstockids();
		String paytime = CSEHelper.getCurrentTime();
		OutStockDetailSearchCondImpl detailcond = new OutStockDetailSearchCondImpl();
		for (int i = 0; i < outstockids.length; i++) {
			Integer outstockid = outstockids[i];
			OutStock oldOutStock = outStockBL.findOutStockByPk(outstockid);
			OutStockTB outStockTB = (OutStockTB)oldOutStock;
			outStockTB.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ);
			outStockTB.setPaytime(paytime);
			OutStock outStock = outStockBL.insertOutStock(outStockTB);
			
			
			detailcond.setOutstockid(outStock.getOutstockid());
			List<OutStockDetail> detailList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
			for(OutStockDetail osd:detailList){
				//更新出库明细
				OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
				outStockDetail.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ);
				outStockDetail.setPaytime(paytime);
				outStockDetailBL.insertOutStockDetail(outStockDetail);
			}
			
		}
		return dto;
	}

	public ITEMS01DTO reportInStockAction(ITEMS01DTO dto) throws BLException {
		//在DTO中获取页面输入的开始时间和结束时间
		String intime_f = dto.getTime_f();
		String intime_t = dto.getTime_t();
		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setIntime_f(intime_f);
		cond.setIntime_t(intime_t);
		cond.setInstockorg(dto.getInstockorg());
		cond.setInstock_sort(DefineUtils.INSTOCK_SORT_BYINCODE);//按物品编号升序
		cond.setSeqcode_q(dto.getSeqcode_q());
		cond.setItemsname_q(dto.getItemsname_q());
		List<InStock> inStockList = inStockBL.searchInStock(cond, 0, 0);
		int totalCount = inStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		pDto.setTotalCount(totalCount);
		inStockList = inStockBL.searchInStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setInStockList(inStockList);
		return dto;
	}
	
	public ITEMS01DTO reportOutStockAction(ITEMS01DTO dto) throws BLException{
		//在DTO中获取页面输入的开始时间和结束时间，出库类型
		String outtime_f = dto.getTime_f();
		String outtime_t = dto.getTime_t();
		OutStockSearchCondImpl cond = new OutStockSearchCondImpl();
		cond.setOuttime_f(outtime_f);
		cond.setOuttime_t(outtime_t);
		cond.setOuttype(dto.getOuttype());
		cond.setReqorg(dto.getOutstockorg_q());//申领机构
		cond.setOutstockorg(dto.getOutstockorg());//所属机构
		cond.setAccountstatus_q(dto.getAccountstatus_q());
		cond.setReqstatus(dto.getReqstatus());
		cond.setSeqcode_q(dto.getSeqcode_q());
		cond.setItemsname_q(dto.getItemsname_q());
		cond.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS_CKWC);
		List<OutStock> outStockList = outStockBL.searchOutStock(cond, 0, 0);
		
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		pDto.setTotalCount(totalCount);
		outStockList = outStockBL.searchOutStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setOsList(outStockList);
		return dto;
	}
	
	
	
	public ITEMS01DTO searchPaymentItems(ITEMS01DTO dto) {
		List<ItemsPay> paymentList = itemsPayBL.searchItemsPayment(dto.getItemsPaySearchCond(), 0, 0);
		if (paymentList.size() == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (paymentList.size() > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),paymentList.size()));
			return dto;
		}
		dto.setPaymentList(paymentList);
		return dto;
	}
	
	public ITEMS01DTO searchPaymentDetail(ITEMS01DTO dto) throws BLException {
		String reqorg = dto.getItems0136form().getReqorg();
		OutStockSearchCondImpl cond = new OutStockSearchCondImpl();
		cond.setReqstatus("searchPaymentDetail");
		cond.setCanPayment(true);
		cond.setOuttime_f(dto.getItems0136form().getOuttime_f());
		cond.setOuttime_t(dto.getItems0136form().getOuttime_t());
		if(!"all".equals(reqorg)){
			cond.setSortType("outtime");
			cond.setReqorg(reqorg);
		} else {
			cond.setSortType("reqorg");
		}
		List<OutStock> outStockList = outStockBL.searchOutStock(cond, 0, 0);
		dto.setOsList(outStockList);
		return dto;
	}
	
	public synchronized ITEMS01DTO doStock(ITEMS01DTO dto, String methodName) throws BLException {
		if (methodName.equals("insertInStockAction")){ //物品入库
			dto = this.insertInStockAction(dto);
		}
		else if (methodName.equals("adjustStockAction")){ //库存调整
			dto = this.adjustStockAction(dto);
		}
		else if (methodName.equals("useItemsAction")){ //正常内部使用
			dto = this.useItemsAction(dto);
		}
		else if (methodName.equals("wasteItemsAction")){ //申请损耗
			dto = this.wasteItemsAction(dto);
		}
		else if (methodName.equals("destroyItemsAction")){ //申请销毁
			dto = this.destroyItemsAction(dto);
		}
		else if (methodName.equals("approveWaste")){//损耗审批
			dto = this.approveWaste(dto);
		}
		else if (methodName.equals("noApproveWaste")){//损耗审批
			dto = this.noApproveWaste(dto);
		}
		else if (methodName.equals("approveDestroy")){//销毁审批
			dto = this.approveDestroy(dto);
		}
		else if (methodName.equals("noApproveDestroy")){//销毁审批
			dto = this.noApproveDestroy(dto);
		}
		else if (methodName.equals("insertOutStockAction")){//申领登记
			dto = this.insertOutStockAction(dto);
		}
		else if (methodName.equals("editOutStockAction")){//申领修改
			dto = this.editOutStockAction(dto);
		}
		else if (methodName.equals("delOutStockAction")){//申领删除
			dto = this.delOutStockAction(dto);
		}
		else if (methodName.equals("approveOutStockAction")){//申领审批
			dto = this.approveOutStockAction(dto);
		}
		else if (methodName.equals("distributionOutStockAction")){//配送下发(出库)
			dto = this.distributionOutStockAction(dto);
		}
		else if (methodName.equals("receiveOutStockAction")){//接收
			dto = this.receiveOutStockAction(dto);
		}
		else if (methodName.equals("allocateOutStockAction")){//下拨
			dto = this.allocateOutStockAction(dto);
		}
		else if (methodName.equals("editInStockAction")){//修改
			dto = this.editInStockAction(dto);
		}
		else if (methodName.equals("payAction")){//结账
			dto = this.payAction(dto);
		}
		else if (methodName.equals("orgOutStockAction")){//机构下拨
			dto = this.orgOutStockAction(dto);
		}
		if(null == dto){
			throw new BLException("", "");
		}
		return dto;
	}

	public String getOutTypeName(String selectid,String typeCode) throws BLException {
		List<ItemsCodes> itemsCodeList = this.itemsCodesBL.getItemsCodesList(selectid);
		for (ItemsCodes itemsCodes : itemsCodeList) {
			if(typeCode.equals(itemsCodes.getTypecode())){
				return itemsCodes.getTypename();
			}
		}
		return "";
	}
	
	/**
	 * 查询物品收益
	 */
	public ITEMS01DTO searchITEMS0169Action(ITEMS01DTO dto) throws BLException {
		List<OutStock> outStockList = outStockBL.findOutStockByCond(dto.getOutStockSearchCond(), 0, 0);
		if (outStockList.size() == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (outStockList.size() > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),outStockList.size()));
			return dto;
		}
		OutStockDetailSearchCondImpl osdCond = new OutStockDetailSearchCondImpl();
		List<ITEMS01692VO> items01692VOList = new ArrayList<ITEMS01692VO>();
		for(OutStock os : outStockList) {
			ITEMS01692VO vo = new ITEMS01692VO();
			vo.setOutStock(os);
			osdCond.setOutstockid(os.getOutstockid());
			List<OutStockDetail> osdList = outStockDetailBL.searchOutStockDetail(osdCond, 0, 0);
			
			//数量
			int outCount = 0;
			//入库单价
			Double inPrice = 0.0;
			//出库单价
			Double outPrice = 0.0;
			
			for(OutStockDetail osd : osdList) {
				outCount += osd.getOutnum();
				inPrice = getAdd(String.valueOf(inPrice), String.valueOf(getMultiply(String.valueOf(osd.getOutnum()), String.valueOf(osd.getInprice())).doubleValue())).doubleValue();
				outPrice = getAdd(String.valueOf(outPrice), String.valueOf(getMultiply(String.valueOf(osd.getOutnum()), String.valueOf(osd.getOutprice())).doubleValue())).doubleValue();

			}
			if(0 != outCount) {
				//四舍五入
				vo.setCount(outCount + "");
				inPrice = round(getDivide(String.valueOf(inPrice), String.valueOf(outCount)).doubleValue(),4);
				vo.setCountPrice(outPrice + "");
				vo.setInPrice(inPrice.toString());
				outPrice = round(getDivide(String.valueOf(outPrice), String.valueOf(outCount)).doubleValue(),4);
				vo.setOutPrice(outPrice + "");
				/*	收益算法：
					使用：（出库单价*出库数量）—（入库单价*出库数量）
			    	下拨：（出库单价*出库数量）—（入库单价*出库数量）
			    	申领：（出库单价*出库数量）—（入库单价*出库数量）
			    	损耗：—（入库单价*出库数量）
			    	销毁：—（入库单价*出库数量）
			    */
				if(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL.equals(os.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_ZHXB.equals(os.getOuttype())||
						DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(os.getOuttype())) {
					vo.setIncome(getMultiply(String.valueOf(getSubtract(String.valueOf(outPrice), String.valueOf(inPrice)).doubleValue()), String.valueOf(outCount)).doubleValue()  + "");
				} else if(DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(os.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(os.getOuttype())) {
					vo.setIncome("-" + getMultiply(String.valueOf(inPrice), String.valueOf(outCount)).doubleValue());
					vo.setOutPrice(DefineUtils.SEPARATOR);
					vo.setCountPrice(DefineUtils.SEPARATOR);
				}
			}
			items01692VOList.add(vo);
		}
		dto.setItems01692VOList(items01692VOList);
		return dto;
	}
	
	/**
	 * 查询物品收益
	 */
	public ITEMS01DTO searchITEMS0171Action(ITEMS01DTO dto) throws BLException {
		List<OutStockDetail> outStockDetailList = outStockDetailBL.searchOutStockDetail(dto.getOutStockDetailSearchCond(), 0, 0);
		if (outStockDetailList.size() == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (outStockDetailList.size() > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),outStockDetailList.size()));
			return dto;
		}
		List<ITEMS01712VO> items01712VOList = new ArrayList<ITEMS01712VO>();
		Double total = 0.0;//收益总计
		for(OutStockDetail osd : outStockDetailList) {
			ITEMS01712VO vo = new ITEMS01712VO();
			vo.setOutStockDetail(osd);
			vo.setDate(osd.getOuttime().substring(0,10));
			//入库和入库调整
			if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(osd.getOuttype())) {
				vo.setInNum(osd.getOutnum() + "");//入库数量
				vo.setInPrice(osd.getInprice() + "");//入库单价
				vo.setInCountPrice(osd.getOutamount() + "");//入库金额
				vo.setOutNum(DefineUtils.SEPARATOR);//出库数量
				vo.setOutPrice(DefineUtils.SEPARATOR);//出库单价
				vo.setOutCountPrice(DefineUtils.SEPARATOR);//出库金额
				vo.setIncome(DefineUtils.SEPARATOR);//收益
				vo.setStockNum(osd.getStocknum() + "");//库存数量
			} else {
				vo.setInNum(DefineUtils.SEPARATOR);//入库数量
				vo.setInPrice(osd.getInprice() + "");//入库单价
				vo.setInCountPrice(DefineUtils.SEPARATOR);//入库金额
				vo.setOutNum(osd.getOutnum() + "");//出库数量
				vo.setStockNum(osd.getStocknum() + "");//库存数量
				
				/*	收益算法
					使用：（出库单价*出库数量）—（入库单价*出库数量）
			    	下拨：（出库单价*出库数量）—（入库单价*出库数量）
			    	申领：（出库单价*出库数量）—（入库单价*出库数量）
			    	损耗：—（入库单价*出库数量）
			    	销毁：—（入库单价*出库数量）
				 */
				if(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL.equals(osd.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_ZHXB.equals(osd.getOuttype())||
						DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(osd.getOuttype())) {
					vo.setOutPrice(osd.getOutprice() + "");//出库单价
					vo.setOutCountPrice(osd.getOutamount() + "");//出库金额
					vo.setIncome(getMultiply(String.valueOf(getSubtract(String.valueOf(osd.getOutprice()), String.valueOf(osd.getInprice())).doubleValue()), String.valueOf(osd.getOutnum())).doubleValue() + "");//收益
	
					total = getAdd(String.valueOf(total), 
								String.valueOf(getMultiply(String.valueOf(getSubtract(String.valueOf(osd.getOutprice()), String.valueOf(osd.getInprice())).doubleValue()), String.valueOf(osd.getOutnum())).doubleValue())).doubleValue();

				} else if(DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(osd.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(osd.getOuttype())) {
					vo.setOutPrice(DefineUtils.SEPARATOR);//出库单价
					vo.setOutCountPrice(DefineUtils.SEPARATOR);//出库金额
					vo.setIncome("-" + getMultiply(String.valueOf(osd.getInprice()),String.valueOf(osd.getOutnum())).doubleValue());//收益
					total = getSubtract(String.valueOf(total), String.valueOf(getMultiply(String.valueOf(osd.getInprice()),String.valueOf(osd.getOutnum())).doubleValue())).doubleValue();
				}
			}
			items01712VOList.add(vo);
		}
		
		total = round(total,2);
		dto.setItems01712VOList(items01712VOList);
		dto.setTotal(total.toString());
		return dto;
	}
	
	/**
	 * 返回被截取后的数据
	 * @param doubleValue 被截取的数据
	 * @param scale 小数点后保留位数
	 * @return
	 */
	private Double round(Double doubleValue, int scale){ 
		Double value = null; 
		String text = doubleValue.toString(); 
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}
	
	public ITEMS01DTO changeCategoryStatusAction(ITEMS01DTO dto) throws BLException {
		ItemsCategory itemsCategory = itemsCategoryBL.findItemsCategoryByPk(dto.getItems0101form().getIcid());
		ItemsCategoryTB itemsCategoryTB = (ItemsCategoryTB)SerializationUtils.clone(itemsCategory);
		String status = "0";
		if(itemsCategory.getStatus().equals("0")){
			status = "1";
		}
		itemsCategoryTB.setStatus(status);
		itemsCategoryBL.insertItemsCategory(itemsCategoryTB);
		dto.addMessage(new ActionMessage("ITEMS0101.I001","物品状态"));
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public ITEMS01DTO searchOrganizationAction(ITEMS01DTO dto)
			throws BLException {
		log.debug("========机构查询处理开始========");
		// 查询记录总数
		int totalCount = organizationBL.getOrganizationSearchCount(dto
				.getOrganizationSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<Organization> organizationList = organizationBL.searchOrganization(dto
				.getOrganizationSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//设置机构全名

		dto.setOrganizationCondList(organizationList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========机构查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 取得包含机构全名的机构对象集合
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteOrgNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String name = "";
			if(ret.getOrgsyscoding()!=null && !"".equals(ret.getOrgsyscoding())){
				name = getCompleteOrgName(ret.getOrgsyscoding());
			}

			org.put(ret.getOrgid(), name);
		}
		
		return org;
	}
	
	
	
	
	/**
	 * <p>
	 * 取得该结点的机构全名
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private String getCompleteOrgName(String syscoding) {
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		StringBuffer orgname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==4){
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, 4);
			codelist.add(pcode);
			String childs = syscoding.substring(4);
			int j = childs.length()/3;
			for(int i=1;i<=j;i++){
				codelist.add(pcode+childs.substring(0, 3*i));
			}
			
		}
		
		
		//form.setComplete_name(syscoding);
		//form.setIs_in_use("1");
		form.setSyscoding_area(codelist);
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该角色管理域的下级机构树
		for(int i=0,j=ret.size();i<j;i++){
			String syscode = ret.get(i).getOrgsyscoding();
			if(syscoding.contains(syscode)){
				if(i>0){
					orgname.append("-");
				}
				orgname.append(ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}

	
	/**
	 * 查询stock表中的物品(机构下拨)
	 */
	public ITEMS01DTO searchStockForOrgAction(ITEMS01DTO dto) throws BLException {
		
		String category = dto.getCategory();
		String typecode_q = dto.getTypecode_q();//物品名称
		
		ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
		cond.setCategory(category);
		cond.setTypecode(typecode_q);
		cond.setStatus(DefineUtils.ITEMSCATEGORY_STATUS_QY);//查状态为启用的记录
		List<ItemsCategory> itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		//调用DAO接口查询
		itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		dto.setItemsCategoryList(itemsCategoryList);
		return dto;
	}
	
	/**
	 * 机构下拨（即在outstock表中增加一条申领记录）
	 */
	public ITEMS01DTO orgOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0175Form form = dto.getItems0175form();
		String[] categorys = form.getCategorys();//物品种类
		String[] itemsnames = form.getItemsnames();//物品名称
		String[] seqcodes = form.getSeqcodes();//物品编号
		String[] typecodes = form.getTypecodes();//物品型号
		Integer[] reqnums = form.getReqnums();//申领数量
		Integer[] stocknum = form.getStocknum();//申领数量
		for(int i = 0;i<reqnums.length;i++){
			if(reqnums[i]>stocknum[i]){
				throw new BLException("ITEMS0175.E002", seqcodes[i], itemsnames[i]);
			}
		}
		String time = CSEHelper.getCurrentTime();
		if(categorys!=null){
			for(int i = 0,j = categorys.length;i<j;i++){
				//查询stock
				StockSearchCondImpl scond = new StockSearchCondImpl();
				scond.setCategory(categorys[i]);
				scond.setSeqcode(seqcodes[i]);
				scond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				
				List<Stock> stocklist = stockBL.searchStock(scond, 0, 0);
				if(stocklist==null || stocklist.size()==0){
					throw new BLException("ITEMS0175.E001", form.getSeqcodes()[i], form.getItemsnames()[i]);//编号，名称为。。的物品信息不存在
				}
				Stock stock = stocklist.get(0);
				
				OutStockTB outstock = new OutStockTB();
				//设置物品信息
				outstock.setCategory(categorys[i]);
				outstock.setItemsname(itemsnames[i]);
				outstock.setSeqcode(seqcodes[i]);
				outstock.setTypecode(typecodes[i]);
				outstock.setReqnum(reqnums[i]);
				outstock.setChknum(reqnums[i]);//设置审批数量为页面填写的下拨数量
				
				outstock.setStockid(stock.getStockid());			
				outstock.setType(stock.getType());
				
				//设置申领的相关信息
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//出库类型：总行下拨
				outstock.setReqorg(form.getReqorg());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqtime(time);
				outstock.setChkid(dto.getUserid());
				outstock.setChkname(dto.getUsername());
				outstock.setChktime(time);
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//出库状态：待出库
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//结账状态：未结账
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				
				outStockBL.insertOutStock(outstock);
				
				//将在stock表中的被下拨的物品记录的prenum（变动数量增加）
				StockTB stock1 = new StockTB();
				stock1.clone(stock);
				stock1.setStockid(stock.getStockid());
				stock1.setPrenum(reqnums[i]);//下拨数量
				stockBL.addToStock(stock1,DefineUtils.STOCK_PRENUM_XB);//下拨
				
			}
		}
		return dto;
	}

	/**
	 * 查询最后一次入库物品信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String searchOldStockAction(InStockSearchCond cond)
			throws BLException {
		
		List<InStock> list = inStockBL.searchInStock(cond, 0, 0);

		InStock is = list.get(0);

		StringBuffer bf = new StringBuffer();
		
		if(is.getCategory() == null){	
			bf.append("");	
		}else{
			bf.append(is.getCategory());	
		}
		
		if(is.getPacknum() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getPacknum());
		}	
		
		if(is.getBigpacknum() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getBigpacknum());
		}
		
		if(is.getInprice() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getInprice());
		}
		
		if(is.getOutprice() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getOutprice());
		}
		
		if(is.getItemversion() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getItemversion());
		}
		
		if(is.getPrintinside() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getPrintinside());
		}
		
		if(is.getNature() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getNature());
		}
		
		if(is.getPrintexternal() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getPrintexternal());
		}
		
		if(is.getPrintcompany() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getPrintcompany());
		}
		
		if(is.getType() == null){	
			bf.append(",");	
		}else{
			bf.append("," + is.getType());
		}
		
		return bf.toString();
	}
	
	
}
