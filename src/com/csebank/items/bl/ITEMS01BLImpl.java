/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	 * ע��OrganizationBL
	 */
	protected OrganizationBL organizationBL;

	/**
	 * ����OrganizationBL
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
			if(instockList==null || instockList.size()==0){//�״�ȡ
				newSeqno = type+categoryName+nowyear+"0001";
			}else{
				InStock instock = instockList.get(instockList.size()-1);
				String oldSeqno = instock.getSeqno();
				
				String temp = oldSeqno.substring(oldSeqno.length()-4);//ȡ��4λ����
				String oldyear = oldSeqno.substring(4,8);//ȡ���
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
			cond.setSerachtype("seq_desc");//��seqno��������
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
			if("".equals(oldSeqno)){//�״�ȡ
				newSeqno = type+categoryName+nowyear+"0001";
			}else{
				String temp = oldSeqno.substring(oldSeqno.length()-4);//ȡ��4λ����
				String oldyear = oldSeqno.substring(4,8);//ȡ���
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
			iscond.setCategory(ic.getCategory());//��Ʒ����
			iscond.setSeqcode(ic.getSeqcode());//��Ʒ���
			List<InStock> inlist = inStockBL.searchInStock(iscond, 0, 0);
			if(inlist!=null && inlist.size()>0){
				flaglist.add("0");//�����޸�
			}else{
				flaglist.add("1");//���޸�
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
	 * ��ѯstock���е���Ʒ
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
		
		//cond.setStockorg_q(dto.getStockorg_q());//��ѯ��ǰ���������¼�����������
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		int totalCount = stockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		//����DAO�ӿڲ�ѯ
		stockList = stockBL.searchStock(cond, 0, 0);
		dto.setStockList(stockList);
		return dto;
	}
	public ITEMS01DTO searchStockAction(ITEMS01DTO dto) throws BLException {	
		
		//User user = dto.getUser();
//		//ȡ��ǰ�û���ɫ����ΪDefineUtils.ITEMS_ROLETYPE�Ľ�ɫ����
//		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
//		rolecond.setUserid(user.getUserid());
//		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
//		boolean flag = false;//�Ƿ���Թ������п��
//		for(UserRoleInfo ur:urlist){
//			//�����ɫ����Ϊ�ĲĹ���Ĭ�Ͻ�ɫ����
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
		
		//cond.setStockorg_q(dto.getStockorg_q());//��ѯ��ǰ���������¼�����������
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
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		stockList = stockBL.searchStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setStockList(stockList);
		return dto;
	}
	
	/**
	 * ��ѯstock���е���Ʒ(����ʹ��)
	 */
	public ITEMS01DTO searchStockForInsertOutStockAction(ITEMS01DTO dto) throws BLException {
		String category = dto.getCategory();
		String seqcode = dto.getSeqcode();
		String typecode_q = dto.getTypecode_q();//��Ʒ����
//		StockSearchCondImpl cond = new StockSearchCondImpl();
//		cond.setCategory(category);
//		cond.setSeqcode(seqcode);
//		cond.setStockorg(dto.getStockorg_q());
		//cond.setStockorg_q(dto.getStockorg_q());//��ѯ��ǰ���������¼�����������
		
		
		ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setTypecode(typecode_q);
		cond.setStatus(DefineUtils.ITEMSCATEGORY_STATUS_QY);//��״̬Ϊ���õļ�¼
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
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
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
		cond.setStockorg(dto.getStockorg_q());//������
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
			
			//���п�浥��ȡ��ⵥ�۵�ƽ��ֵ��֧�п�浥��ȡ���ⵥ�۵�ƽ��ֵ
			//����������Ϊ0���򵥼ۼ�����Ϊ0
			if(stock.getStocknum().equals(0)){
				StockTB stb = (StockTB)SerializationUtils.clone(stock);
				stb.setPrice(0d);//����
				stb.setAmount(0d);//���
				new_stockList.add(stb);
			}else{
				InStockSearchCondImpl incond = new InStockSearchCondImpl();
				incond.setCategory(stockCategory);
				incond.setSeqcode(stockSeqcode);
				incond.setInstockorg(dto.getStockorg_q());//������
				List<InStock> inlist = inStockBL.searchInStock(incond, 0, 0);
				Double in_price = 0d;//��ⵥ��
				Double in_amount = 0d;//���С��
				int in_num = 0;//�����ϼ�
				for(InStock ins:inlist){
					//�������Ϊ = ������� - �������� - ������� - ��������
					int stock_num = 0;
					Double sum_count = 0d;
					stock_num = (ins.getInnum()-ins.getOutnum()-ins.getLossnum()-ins.getHavocnum());//ʵ�ʿ������
					//in_num +=ins.getInnum();
					in_num +=stock_num;
					if(stock_num > 0){
						sum_count = getMultiply(String.valueOf(ins.getInprice()), String.valueOf(stock_num)).doubleValue();//�����������
					}else{
						sum_count = 0d;
					}
					
					in_amount = getAdd(String.valueOf(in_amount), String.valueOf(sum_count)).doubleValue();
				}
				
				in_price = getDivide(String.valueOf(in_amount), String.valueOf(in_num)).doubleValue();//����
				in_price = round(in_price,4);
				Double amount = 0d;//���ϼ�
//				amount = getMultiply(String.valueOf(in_price), String.valueOf(stock.getStocknum())).doubleValue();//���
//				
				amount = in_amount;
				StockTB stb = (StockTB)SerializationUtils.clone(stock);
				stb.setPrice(in_price);//����
				stb.setAmount(round(amount,2));//���
				new_stockList.add(stb);
			}
			
		}
		dto.setChknumList(chknumList);
		dto.setStockList(new_stockList);
		
		
		
		
		return dto;
	}
	
	/**
	 * ��ѯstock����ָ����Ʒ����ϸ��Ϣ
	 */
	public ITEMS01DTO searchStockDetailAction(ITEMS01DTO dto) throws BLException {
		Stock stock = stockBL.findStockByPk(dto.getStockid());
		dto.setStock(stock);
		return dto;
	}
	
	/**
	 * ��ѯoutstock����ָ����¼����ϸ��Ϣ
	 */
	public ITEMS01DTO searchOutStockDetailAction(ITEMS01DTO dto) throws BLException {
		OutStock outStock = outStockBL.findOutStockByPk(dto.getOutstockid());
		dto.setOutStock(outStock);
		return dto;
	}
	
	/**
	 * �����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
	 * @param ITEMS01DTO
	 * @return boolean true:���� false:������
	 */
	public boolean checkRoleManagerByUserID(ITEMS01DTO dto) throws BLException {
		User user = dto.getUser();
		//ȡ��ǰ�û���ɫ����ΪDefineUtils.ITEMS_ROLETYPE�Ľ�ɫ����
		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
		rolecond.setUserid(user.getUserid());
		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
		boolean flag = false;//�Ƿ���Թ������п��
		for(UserRoleInfo ur:urlist){
			//�����ɫ����Ϊ�ĲĹ���Ĭ�Ͻ�ɫ����
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
	 * ��ѯoutstock���еļ�¼
	 */
	public ITEMS01DTO searchOutStockAction(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		//��ȡ��ҳbean
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
		//����DAO�ӿڲ�ѯ
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
					//�����ⵥ�ۺͳ��ⵥ�۶�Ϊ0��������Ʒ����Ϊ���ƣ�1��ʱ�����ɽ���
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
	 * ��ѯ�Ĳ�֪ͨ
	 *   ������ʾ��֧�н����������ʾδ���յ�֧�У�
	 *   ֧����ʾ���������²���Ʒ/������Ʒ������� ��ʾ������Ʒ���
	 */
	public ITEMS01DTO searchOutStockForNoticeAction(ITEMS01DTO dto) throws BLException {
		//ITEMS0144Form form = dto.getItems0144form();
		List<String> outTypeList = new ArrayList<String>();
		outTypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//֧������
		outTypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//�����²�
		
		OutStockSearchVWCondImpl cond = new OutStockSearchVWCondImpl();
		cond.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);
		cond.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
		cond.setOutTypeList(outTypeList);
		//���Ϊ֧���û���ֻ��ѯ�������Ϊ��֧�еļ�¼
//		if(DefineUtils.ZHIH_ORGNO.equals(form.getFlag())){
//			cond.setReqorg_q(dto.getUser().getOrgid());
//		}
//		
		if(dto.getUser().getOrgid().length()>=7 && 
		   DefineUtils.ZHIH_ORGNO.equals(dto.getUser().getOrgid().substring(0,7))){
				cond.setReqorg_q(dto.getUser().getOrgid());
		}
		
		
		List<OutStockVWInfo> outStockList = outStockVWDAO.findByCond(cond, 0, 0);
		// ��ѯ��¼����
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		outStockList = outStockVWDAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		dto.setOutStockList(outStockList);

		return dto;
	}
	
	
	
	
	/**
	 * ��ѯoutstock���еļ�¼(VW)
	 */
	public ITEMS01DTO searchOutStockVWAction(ITEMS01DTO dto) throws BLException {
		OutStockSearchVWCond cond = dto.getOutStockSearchVWCond();	
		List<OutStockVWInfo> outStockList = outStockVWDAO.findByCond(cond, 0, 0);
		
		// ��ѯ��¼����
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		outStockList = outStockVWDAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<Stock> exstockList = new ArrayList<Stock>();//���汻���첢�ҿ���д��ڵĺĲ�
		//��ѯ�����첢�ҿ���д��ڵĺĲĵ�
		for(int i=0,j=outStockList.size();i<j;i++){
			String category = outStockList.get(i).getCategory().toString();
			String seqcode = outStockList.get(i).getSeqcode().toString();
			StockSearchCondImpl stockcond = new StockSearchCondImpl();
			stockcond.setStockorg(DefineUtils.DEFAULT_ORGNO);//����Ĭ�ϻ�����Ϊ���л�����
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
				buff.append("��");
			}
			buff.append(packno);
			oldpackno+=buff.toString();
		}
		
		return oldpackno;
	}
	
	/**
	 * ��ѯoutstock���еļ�¼(�����嵥)
	 */
	public ITEMS01DTO searchOutStockBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// ��ѯ��¼����
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//����DAO�ӿڲ�ѯ
		outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		Map<String,Map<String,String>> outmap = new LinkedHashMap<String,Map<String,String>>();//<����ʱ�䣬<����code�������嵥>>

		for(OutStock outstock:outStockList){
			String outtime = outstock.getOuttime().substring(0,10);//����ʱ��
			String orgcode = outstock.getReqorg();
			String packno = outstock.getPackno();//������

			if(outmap.get(outtime)!=null){
				Map<String,String> packmap = outmap.get(outtime);//<����code�������嵥>
				if(StringUtils.isNotEmpty(packmap.get(orgcode))){
					String oldpackno = packmap.get(orgcode);
					packmap.put(orgcode, setPackno(packno,oldpackno));
				}else{
					packmap.put(orgcode, setPackno(packno,""));
				}
				outmap.put(outtime, packmap);
			}else{
				Map<String,String> packmap = new LinkedHashMap<String,String>();//<����code�������嵥>
				packmap.put(orgcode, setPackno(packno,""));			
				outmap.put(outtime, packmap);
			}
			
		}

		dto.setOutmap(outmap);
		return dto;
	}
	
	/**
	 * ��ѯoutstock���еļ�¼(�����嵥��ϸ)
	 */
	public ITEMS01DTO searchOutStockDetailBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// ��ѯ��¼����
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		outStockList = outStockBL.findOutStockByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		dto.setOsList(outStockList);
		return dto;
	}
	
	/**
	 * ��ѯoutstock���еļ�¼(�����嵥��ϸExcel����)
	 */
	public ITEMS01DTO searchExcelDataBy0148Action(ITEMS01DTO dto) throws BLException {
		OutStockSearchCond cond = dto.getOutStockSearchCond();
		
		List<OutStock> outStockList = outStockBL.findOutStockByCond(cond, 0, 0);
		// ��ѯ��¼����
		int totalCount = outStockList.size();
		if (totalCount == 0) {
			// ��ѯ���ݲ�����
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// ��ѯ���ݼ�������
			return dto;
		}
		//����DAO�ӿڲ�ѯ
		outStockList = outStockBL.findOutStockByCond(cond, 0, 0);

		dto.setOsList(outStockList);
		return dto;
	}
	
	/**
	 * ��Ʒ���죨����outstock��������һ�������¼��
	 */
	public ITEMS01DTO insertOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0141Form form = dto.getItems0141form();
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		//String[] types = form.getTypes();//��Ʒ����
		//String[] seqnos = form.getSeqnos();//���κ�
		//Integer[] bigpacknums = form.getBigpacknums();//���װ����
		//Integer[] smallpacknums = form.getSmallpacknums();//С��װ����
		//String[] itemversions = form.getItemversions();//ƾ֤�汾
		//Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		Integer[] reqnums = form.getReqnums();//��������
		if(categorys!=null){
			for(int i = 0,j = categorys.length;i<j;i++){
				OutStockTB outstock = new OutStockTB();
				//������Ʒ��Ϣ
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
				
				//��������������Ϣ
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//�������ͣ�֧������
				outstock.setReqorg(dto.getOutstockorg());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP);//����״̬�����������
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//����״̬��δ����
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				
				outStockBL.insertOutStock(outstock);
				
				//����stock���еı��������Ʒ��¼��prenum���䶯�������ӣ�
				//Stock oldstock = stockBL.findStockByPk(stockids[i]);
				//StockTB stock = new StockTB();
//				stock.setCategory(categorys[i]);
//				stock.setSeqcode(seqcodes[i]);
				//stock.clone(oldstock);
				//stock.setStockid(stockids[i]);
				//stock.setPrenum(reqnums[i]);//��������
				//stock.setUserid(dto.getUserid());
				//stock.setUsername(dto.getUsername());
				//stockBL.addToStock(stock,DefineUtils.STOCK_PRENUM_SL);
			}
		}
		return dto;
	}
	
	/**
	 * �ж�ҳ���ύ�ĸü�¼�ĳ���״̬�Ƿ������ݿ��иü�¼�ĳ���״̬һ�£����κ�һ����һ���򷵻ش���ҳ
	 * Parameters outstockid,�ü�¼��reqstatus
	 */
	private boolean checkEditStockReqstatus(ITEMS0144Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] reqstatuss = form.getReqstatuss();//����״̬
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
	 * ��Ʒ�����޸�
	 */
	public ITEMS01DTO editOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();	
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		//String[] types = form.getTypes();//��Ʒ����

		//String[] seqnos = form.getSeqnos();//���κ�
		//Integer[] bigpacknums = form.getBigpacknums();//���װ����
		//Integer[] smallpacknums = form.getSmallpacknums();//С��װ����
		//String[] itemversions = form.getItemversions();//ƾ֤�汾
		//Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		//Integer[] reqnums = form.getReqnums();//��������
		Integer[] new_reqnums = form.getNew_reqnums();//��������(�޸ĺ�)
		if(!checkEditStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					OutStockTB outstock = new OutStockTB();
					//������Ʒ��Ϣ
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
					outstock.setReqnum(new_reqnums[i]);//������������Ϊ�޸ĺ������
					outstock.setReqtime(CSEHelper.getCurrentTime());
					//outstock.setType(types[i]);
					
					//��������������Ϣ
					outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);//�������ͣ�֧������
					outstock.setReqorg(dto.getOutstockorg());
					outstock.setReqid(dto.getUserid());
					outstock.setReqname(dto.getUsername());
					outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SLDSP);//����״̬�����������
					outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//����״̬��δ����
					
					outStockBL.insertOutStock(outstock);
					
					//����stock���б��������Ʒ��¼��prenum����ʽΪ��prenum = ��ǰֵ - �޸�ǰ������ + �޸ĺ���������
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
	 * ��Ʒ����ɾ��
	 */
	public ITEMS01DTO delOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		//Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		//Integer[] reqnums = form.getReqnums();//��������
		
		if(!checkEditStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					OutStockTB outstock = new OutStockTB();
					outstock.setOutstockid(outstockids[i]);
					outStockBL.deleteOutStock(outstock);
					
					//����stock���б��������Ʒ��¼��prenum����ʽΪ��prenum = ��ǰֵ - �޸�ǰ������ 
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
	 * �Ӵ����form��ȡֵ����OutStockTB������䷵��(��������)
	 */
	private OutStockTB getNewTB(ITEMS0142Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] outstockorgs = form.getOutstockorgs();//��������
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		String[] seqnos = form.getSeqnos();//���κ�
		String[] outtypes = form.getOuttypes();//��������
		String[] reqorgs = form.getReqorgs();//���û�����
		String[] reqids = form.getReqids();//�����˻��²��ˣɣ�
		String[] reqnames = form.getReqnames();//�����˻��²�������
		String[] reqtimes = form.getReqtimes();//������²�ʱ��
		Integer[] reqnums = form.getReqnums();//��������
		
		Integer[] outnums = form.getOutnums();//ʵ�ʳ�������
		String[] chkreasons = form.getChkreasons();//����˵��
		String[] pakreasons = form.getPakreasons();//����˵��
		String[] packnos = form.getPacknos();//������
		String[] chkids = form.getChkids();//������ID
		String[] chknames = form.getChknames();//����������
		String[] chktimes = form.getChktimes();//����ʱ��
		String[] stockuserids = form.getStockuserids();//����˵�ID
		String[] stocknames = form.getStocknames();//����˵�����
		String[] outtimes = form.getOuttimes();//����ʱ��
		String[] rcvids = form.getRcvids();//������ID
		String[] rcvnames = form.getRcvnames();//����������
		String[] rcvtimes = form.getRcvtimes();//����ʱ��
		//String[] reqstatuss = form.getReqstatuss();//����״̬
		String[] accountstatuss = form.getAccountstatuss();//����״̬
		Double[] inprices = form.getInprices();//��ⵥ�ۣ�δʹ�ã�
		//Double[] outprices = form.getOutprices();//���ⵥ��
		Double[] outamounts = form.getOutamounts();//������
		Integer[] bigpacknums = form.getBigpacknums();//���װ����
		Integer[] smallpacknums = form.getSmallpacknums();//С��װ����
		String[] itemversions = form.getItemversions();//ƾ֤�汾
		Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		Integer[] stocknums = form.getStocknums();//�������
		
		String[] types = form.getTypes();//��Ʒ����
		
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
	 * У�����������Ƿ񳬹��������
	 */
	@SuppressWarnings("unchecked")
	private boolean checkStockNum(ITEMS0142Form form) throws BLException{
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		Integer[] chknums = form.getChknums();//�����������
		//Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		ArrayList totaltype = new ArrayList();//���ڼ�����Ʒ(��ʽ��categorys;seqcodes)
		ArrayList totalnum = new ArrayList();//ÿ����Ʒ������������
		StockSearchCondImpl cond = new StockSearchCondImpl();

		if(outstockids!=null){
			//ȡ�ù��м��ֱ���������Ʒ
			for(int i = 0,j = outstockids.length;i<j;i++){
				String category = categorys[i];
				String seqcode = seqcodes[i];
				String type = category+";"+seqcode;

				if(!checkStockTypeIsInList(totaltype,type)){
					totaltype.add(type);
				}
			}
			
			//ȡ��ÿ�ֱ���������Ʒ��������
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
			
			//У�����������Ƿ񳬹��������
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//��ѯָ�����ͱ�ŵ���Ʒ
				cond.setCategory(category);
				cond.setSeqcode(seqcode);
				cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
				
				Stock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//���������ĺ�
				if(num>stock.getStocknum()){
					flag = true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * �жϸ���Ʒ�����Ƿ��Ѿ�����
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
	 * �ж�ҳ���ύ�ĸü�¼�ĳ���״̬�Ƿ������ݿ��иü�¼�ĳ���״̬һ�£����κ�һ����һ���򷵻ش���ҳ(�������ͬʱ����ͬһ����¼)
	 */
	private boolean checkStockReqstatus(ITEMS0142Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] reqstatuss = form.getReqstatuss();//����״̬
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
	 * ��������
	 */
	public ITEMS01DTO approveOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0142Form form = dto.getItems0142form();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		//Integer[] reqnums = form.getReqnums();//��������
		Integer[] chknums = form.getChknums();//�����������
		Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		String flag = form.getFlag();//1ͨ��  0��ͨ��

		if(!checkStockReqstatus(form) || "0".equals(flag)){
			if(!checkStockNum(form) || "0".equals(flag)){
				if(outstockids!=null){
					for(int i = 0,j = outstockids.length;i<j;i++){
						//���������Ļ�����Ϣ
						OutStockTB outstock = getNewTB(form,i);
						outstock.setChkid(dto.getUserid());
						outstock.setChkname(dto.getUsername());
						outstock.setChktime(CSEHelper.getCurrentTime());
						if("1".equals(flag)){
							//ΪOutStock����������ͨ��ʱ����Ҫ��Ϣ
							outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//����״̬��������
							outstock.setChknum(chknums[i]);//������������
							
							//���ò�ѯ������ѯ
						
							Stock oldStock = stockBL.findStockByPk(stockids[i]);
							
							//����stock���б���������Ʒ��¼��prenum����ʽΪ��prenum = ��ǰֵ  + ��������
							StockTB stockTB = new StockTB();
							stockTB.clone(oldStock);
							stockTB.setStockid(oldStock.getStockid());
							stockTB.setPrenum(oldStock.getPrenum()+chknums[i]);
							stockTB.setUserid(dto.getUserid());
							stockTB.setUsername(dto.getUsername());
							stockTB.setUptime(CSEHelper.getCurrentTime());
							stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SP);
							
							//����outstock��
							outStockBL.insertOutStock(outstock);
						}else{
							//ΪOutStock������������ͨ��ʱ����Ҫ��Ϣ
							outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SPWTG);//����״̬������δͨ��
							outstock.setChknum(chknums[i]);//������������
							
							//���ò�ѯ������ѯ
							//Stock oldStock = stockBL.findStockByPk(stockids[i]);
							
							//����stock���б���������Ʒ��¼��prenum����ʽΪ��prenum = ��ǰֵ - �������� 
//							StockTB stockTB = new StockTB();
//							stockTB.clone(oldStock);
//							stockTB.setStockid(oldStock.getStockid());
//							//stockTB.setPrenum(oldStock.getPrenum()-reqnums[i]);
//							stockTB.setUserid(dto.getUserid());
//							stockTB.setUsername(dto.getUsername());
//							stockTB.setUptime(CSEHelper.getCurrentTime());
//							stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SP);
							
							//����outstock��
							outStockBL.insertOutStock(outstock);
						}
					}
				}
			}else{
				//ͬ����Ʒ���������������������
				dto.setGoToError("SP_NUM_ERROR");
			}
		}else{
			//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
			dto.setGoToError("SP_REQSTATUS_ERROR");
		}
		
		return dto;
	}
	
	/**
	 * �Ӵ����form��ȡֵ����OutStockTB������䷵��(����)
	 */
	private OutStockTB getNewTB(ITEMS0143Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] outstockorgs = form.getOutstockorgs();//��������
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		String[] seqnos = form.getSeqnos();//���κ�
		String[] outtypes = form.getOuttypes();//��������
		String[] reqorgs = form.getReqorgs();//���û�����
		String[] reqids = form.getReqids();//�����˻��²��ˣɣ�
		String[] reqnames = form.getReqnames();//�����˻��²�������
		String[] reqtimes = form.getReqtimes();//������²�ʱ��
		Integer[] reqnums = form.getReqnums();//��������
		Integer[] chknums = form.getChknums();//��������
		
		Integer[] outnums = form.getOutnums();//ʵ�ʳ�������
		String[] chkreasons = form.getChkreasons();//����˵��
		String[] pakreasons = form.getPakreasons();//����˵��
		
		String[] chkids = form.getChkids();//������ID
		String[] chknames = form.getChknames();//����������
		String[] chktimes = form.getChktimes();//����ʱ��
		//String[] stockuserids = form.getStockuserids();//����˵�ID
		//String[] stocknames = form.getStocknames();//����˵�����
		String[] outtimes = form.getOuttimes();//����ʱ��
		String[] rcvids = form.getRcvids();//������ID
		String[] rcvnames = form.getRcvnames();//����������
		String[] rcvtimes = form.getRcvtimes();//����ʱ��
		//String[] reqstatuss = form.getReqstatuss();//����״̬
		String[] accountstatuss = form.getAccountstatuss();//����״̬
		Double[] inprices = form.getInprices();//��ⵥ�ۣ�δʹ�ã�
		//Double[] outprices = form.getOutprices();//���ⵥ��
		Double[] outamounts = form.getOutamounts();//������
		Integer[] bigpacknums = form.getBigpacknums();//���װ����
		Integer[] smallpacknums = form.getSmallpacknums();//С��װ����
		String[] itemversions = form.getItemversions();//ƾ֤�汾
		Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		Integer[] stocknums = form.getStocknums();//�������
		String[] types = form.getTypes();//��Ʒ����

		
		outstock.setChknum(chknums[i]==null?0:chknums[i]);//������������
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
	 * �Ӵ����form��ȡֵ����OutStockTB������䷵��(����)
	 */
	private OutStockDetailTB getNewOutStockDetailTB(OutStock outStock){
		OutStockDetailTB outstockDetail = new OutStockDetailTB();
		
		outstockDetail.setOutstockid(outStock.getOutstockid());
		outstockDetail.setChknum(outStock.getChknum());//������������
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
		//outstockDetail.setOutnum(outStock.getOutnum());//��������
		outstockDetail.setChkreason(outStock.getChkreason());
		outstockDetail.setPackno(outStock.getPackno());
		outstockDetail.setPakreason(outStock.getPakreason());
		outstockDetail.setChkid(outStock.getChkid());
		outstockDetail.setChkname(outStock.getChkname());
		outstockDetail.setChktime(outStock.getChktime());
		
		outstockDetail.setOuttime(outStock.getOuttime());//����ʱ��
		outstockDetail.setRcvid(outStock.getRcvid());
		outstockDetail.setRcvname(outStock.getRcvname());
		outstockDetail.setRcvtime(outStock.getRcvtime());
		outstockDetail.setAccountstatus(outStock.getAccountstatus());
		//outstockDetail.setInprice(outStock.getInprice());
		
		//outstockDetail.setOutamount(outStock.getOutamount());//������
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
	 * У�����������Ƿ񳬹��������
	 */
	@SuppressWarnings("unchecked")
	private String checkOutNum(ITEMS0143Form form) throws BLException{
		String flag = null;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		Integer[] outnums = form.getOutnums();//��������
		//Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		ArrayList totaltype = new ArrayList();//���ڼ�����Ʒ(��ʽ��categorys;seqcodes)
		ArrayList totalnum = new ArrayList();//ÿ����Ʒ�ĳ���������
		StockSearchCondImpl cond = new StockSearchCondImpl();

		if(outstockids!=null){
			//ȡ�ù��м�����Ʒ
			for(int i = 0,j = outstockids.length;i<j;i++){
				String category = categorys[i];
				String seqcode = seqcodes[i];
				String type = category+";"+seqcode;

				if(!checkStockTypeIsInList(totaltype,type)){
					totaltype.add(type);
				}
			}
			
			//ȡ��ÿ����Ʒ��������
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
			
			//У�����������Ƿ񳬹��������
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//��ѯָ�����ͱ�ŵ���Ʒ
				cond.setCategory(category);
				cond.setSeqcode(seqcode);
				cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
				
				Stock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//���������ĺ�
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
	 * �ж�ҳ���ύ�ĸü�¼�ĳ���״̬�Ƿ������ݿ��иü�¼�ĳ���״̬һ�£����κ�һ����һ���򷵻ش���ҳ(�������ͬʱ����ͬһ����¼)
	 * Parameters outstockid,�ü�¼��reqstatus
	 */
	private String checkOutReqstatus(ITEMS0143Form form){
		String flag = null;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] reqstatuss = form.getReqstatuss();//����״̬
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
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
	 * �����·�
	 */
	public ITEMS01DTO distributionOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0143Form form = dto.getItems0143form();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] reqorgs = form.getReqorgs();//�������
		Integer[] chknums = form.getChknums();//��������
		Integer[] outnums = form.getOutnums();//��������
		Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		//String[] packnos = form.getPacknos();//������
		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setInstockorg(DefineUtils.DEFAULT_ORGNO);//���ÿ�����Ϊ��������
		List<String> statuslist = new ArrayList<String>();
		statuslist.add(DefineUtils.ITEMSCODES_STATUS_WCK);//δ����
		statuslist.add(DefineUtils.ITEMSCODES_STATUS_BFCK);//���ֳ���
		
		Double out_price = 0d;//���ⵥ��
		Double out_amount = 0d;//������
		Double out_price_part = 0d;//�����ϸ��ÿ����浥��*��������������Ȼ��������������¼���ܵ�ֵ
		int out_num_part = 0;//��������С��
		boolean falg = false;//�Ƿ��������������
		List<Integer> instockidlist =  new ArrayList<Integer>();
		List<Integer> instockOutnumlist = new ArrayList<Integer>();
		int per_outnum = 0;//ÿ����¼��Ҫ�Ŀ������
		String cor = checkOutReqstatus(form);
		String con = checkOutNum(form);
		if(cor==null){
			if(con==null){
				if(outstockids!=null){						
					//����
					for(int i = 0,j = outstockids.length;i<j;i++){
						//���û�����Ϣ
						OutStockTB outstock = getNewTB(form,i);
						
						outstock.setOuttime(CSEHelper.getCurrentTime());					
						outstock.setStockuserid(dto.getUserid());						
						outstock.setStockname(dto.getUsername());					
						outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
						
						//ΪOutStock�����������·�ʱ����Ҫ��Ϣ
						outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������					
						outstock.setOutnum(outnums[i]);//���ó�������					
						//outstock.setPackno(packnos[i]);//���ð�����
						//outstock.setStockuserid(dto.getUserid());
						//outstock.setStockname(dto.getUsername());
						outstock.setSeqno(getSeqno("O",categorys[i],seqcodes[i],reqorgs[i]));//����������κ�
						
						//���ò�ѯ������ѯ
					
						Stock oldStock = stockBL.findStockByPk(stockids[i]);
						int nowprenum = oldStock.getPrenum()-chknums[i];//�䶯����,��ʽΪ��prenum = ��ǰֵ - ��������
						
						//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��prenum = ��ǰֵ - ��������,stocknum = ��ǰֵ - ʵ�ʳ�������
						
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
						
						//����instock��
						cond.setCategory(categorys[i]);
						cond.setSeqcode(seqcodes[i]);
						cond.setStatus_q(statuslist);
						cond.setInstock_sort(DefineUtils.INSTOCK_SORT_BYINTIME);//��������ʽΪ�������ʱ����������
						
						//������Ʒ�ļ���
						List<InStock> oldInStock = inStockBL.searchInStock(cond, 0, 0);
						
						//������¼��Ҫ�Ŀ������
						per_outnum = outnums[i];
			
						//����������ȳ����ԭ�����μ��ٿ����,ֱ�������������Ϊֹ	
						for(int x = 0 , y = oldInStock.size();x<y;x++){
							InStock outinstock =  oldInStock.get(x);
							per_outnum = outnums[i] - out_num_part;//ȡ�û�����������������Ҫ��
							int true_instocknum = outinstock.getInnum()-outinstock.getOutnum()-outinstock.getLossnum()-outinstock.getHavocnum();//ÿ������ʵ�ʿ����
							if(true_instocknum>per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=outnums[i]){//����
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
												
										}
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add((outnums[i]-out_num_part));
										
										//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//����������ϸ
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������					
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(outnums[i]-out_num_part);//��������
										outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
										outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//������
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
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
										
										//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//����������ϸ
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(true_instocknum);//��������
										outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
										outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//������
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
										outStockDetailBL.insertOutStockDetail(outStockDetail);
									}
								}else{
									InStockTB instockTB = new InStockTB();
									instockTB.clone(outinstock);
									instockTB.setInstockid(outinstock.getInstockid());
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_BFCK);//����״̬�޸�Ϊ�����ֳ���
									instockTB.setOutnum(outinstock.getOutnum()+outnums[i]);//�����ѳ�������
									//instockTB.setUserid(dto.getUserid());
									//instockTB.setUsername(dto.getUsername());
									//instockTB.setIntime(CSEHelper.getCurrentTime());
									inStockBL.insertInStock(instockTB);
									
									//������ⵥ�ۼ����������outstock��
									out_price = outinstock.getOutprice();
									
									if(out_price!=null && out_price>0){
										out_price = round(out_price,4);
										out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										outstock.setOutprice(out_price);
										outstock.setOutamount(out_amount);
									}
									
									//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
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
									//����������ϸ
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]);//��������
									outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
									outStockDetail.setOutprice(out_price);//���ⵥ��
									outStockDetail.setOutamount(out_amount);//������
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
									outStockDetailBL.insertOutStockDetail(outStockDetail);
									break;
								}
								
								
								
							}else if(true_instocknum==per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=outnums[i]){//����
										if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
											out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
											
										}
										instockidlist.add(outinstock.getInstockid());
										instockOutnumlist.add((outnums[i]-out_num_part));
										
										//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//����������ϸ
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(outnums[i]-out_num_part);//��������
										outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
										outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//������
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
										
										//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										StockTB stockTB = new StockTB();
										stockTB.clone(oldStock);
										stockTB.setStockid(oldStock.getStockid());
										stockTB.setPrenum(nowprenum);
										stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
										stockTB.setUserid(dto.getUserid());
										stockTB.setUsername(dto.getUsername());
										stockTB.setUptime(CSEHelper.getCurrentTime());
										Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
										
										//����������ϸ
										OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
										outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
										outStockDetail.setInstockid(outinstock.getInstockid());
										outStockDetail.setOutnum(true_instocknum);//��������
										outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
										outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
										outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//������
										outStockDetail.setStocknum(stock.getStocknum());
										outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
										outStockDetailBL.insertOutStockDetail(outStockDetail);
									}
								}else{
									InStockTB instockTB = new InStockTB();
									instockTB.clone(outinstock);
									instockTB.setInstockid(outinstock.getInstockid());
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_YCK);//����״̬�޸�Ϊ���ѳ���
									instockTB.setOutnum(outinstock.getOutnum()+outnums[i]);//�����ѳ�������
									//instockTB.setUserid(dto.getUserid());
									//instockTB.setUsername(dto.getUsername());
									//instockTB.setIntime(CSEHelper.getCurrentTime());
									inStockBL.insertInStock(instockTB);
									
									//������ⵥ�ۼ����������outstock��
									out_price = outinstock.getOutprice();
									if(out_price!=null && out_price>0){
										out_price = round(out_price,4);
										out_amount = getMultiply(String.valueOf(out_price), String.valueOf(outnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										outstock.setOutprice(out_price);
										outstock.setOutamount(out_amount);
									}
									//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
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
									//����������ϸ
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]);//��������
									outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
									outStockDetail.setOutprice(out_price);//���ⵥ��
									outStockDetail.setOutamount(out_amount);//������
									outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetailBL.insertOutStockDetail(outStockDetail);

									break;
								}
								
							}else{
								//�жϵ�ǰ������С���Ƿ��������������								
								if((out_num_part+true_instocknum)>=outnums[i]){//����
									if(outinstock.getOutprice()!=null && outinstock.getOutprice()>0){
										out_price_part = getAdd(String.valueOf(out_price_part), String.valueOf(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue())).doubleValue();
										
									}
									//out_num_part+=(outnums[i]-out_num_part);
									instockidlist.add(outinstock.getInstockid());
									instockOutnumlist.add((outnums[i]-out_num_part));
									
									//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-(outnums[i]-out_num_part));
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									//����������ϸ
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(outnums[i]-out_num_part);//��������
									outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
									outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
									outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf((outnums[i]-out_num_part))).doubleValue());//������
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
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
									
									//����stock���б��·�����Ʒ��¼��prenum,stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									StockTB stockTB = new StockTB();
									stockTB.clone(oldStock);
									stockTB.setStockid(oldStock.getStockid());
									stockTB.setPrenum(nowprenum);
									stockTB.setStocknum(oldStock.getStocknum()-true_instocknum);
									stockTB.setUserid(dto.getUserid());
									stockTB.setUsername(dto.getUsername());
									stockTB.setUptime(CSEHelper.getCurrentTime());
									Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_CK);
									
									//����������ϸ
									OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outstock);
									outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//����״̬��������				
									outStockDetail.setInstockid(outinstock.getInstockid());
									outStockDetail.setOutnum(true_instocknum);//��������
									outStockDetail.setInprice(outinstock.getInprice());//��ⵥ��
									outStockDetail.setOutprice(outinstock.getOutprice());//���ⵥ��
									outStockDetail.setOutamount(getMultiply(String.valueOf(outinstock.getOutprice()), String.valueOf(true_instocknum)).doubleValue());//������
									outStockDetail.setStocknum(stock.getStocknum());
									outStockDetail.setInseqno(outinstock.getSeqno());//������κ�
									outStockDetailBL.insertOutStockDetail(outStockDetail);
								}
							}
						}
						if(falg){
							//����instock���г����漰�ĸ�����¼
							for(int n=0,m=instockidlist.size();n<m;n++){
								InStockTB instockTB = new InStockTB();
								InStock is = inStockBL.findInStockByPk(instockidlist.get(n));
								int true_num = is.getInnum()-is.getOutnum()-is.getLossnum()-is.getHavocnum();//��������ʵ�ʿ����
								instockTB.clone(is);
								instockTB.setInstockid(is.getInstockid());
								if(instockOutnumlist.get(n)==true_num){
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_YCK);//����״̬�޸�Ϊ���ѳ���
									instockTB.setOutnum(is.getOutnum()+true_num);//�����ѳ�������
								}else{
									instockTB.setStatus(DefineUtils.ITEMSCODES_STATUS_BFCK);//����״̬�޸�Ϊ�����ֳ���
									instockTB.setOutnum(is.getOutnum()+instockOutnumlist.get(n));//�����ѳ�������
								}
								//instockTB.setUserid(dto.getUserid());
								//instockTB.setUsername(dto.getUsername());
								//instockTB.setIntime(CSEHelper.getCurrentTime());
								inStockBL.insertInStock(instockTB);
								
							}
							//������ⵥ�ۼ����������outstock��
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
						//����
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
				//ͬ����Ʒ�ĳ������������������
				dto.setGoToError("CK_NUM_ERROR;"+con);
			}
		}else{
			//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
			dto.setGoToError("CK_REQSTATUS_ERROR;"+cor);
		}
		
		return dto;
	}
	
	/**
	 * �ж�ҳ���ύ�ĸü�¼�ĳ���״̬�Ƿ������ݿ��иü�¼�ĳ���״̬һ�£����κ�һ����һ���򷵻ش���ҳ(�������ͬʱ����ͬһ����¼)
	 * Parameters outstockid,�ü�¼��reqstatus
	 */
	private boolean checkReceiveStockReqstatus(ITEMS0144Form form){
		boolean flag = false;
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] reqstatuss = form.getReqstatuss();//����״̬
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
	 * �Ӵ����form��ȡֵ����OutStockTB������䷵��(����)
	 */
	private OutStockTB getNewTB(ITEMS0144Form form,int i){
		OutStockTB outstock = new OutStockTB();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		String[] outstockorgs = form.getOutstockorgs();//��������
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		String[] seqnos = form.getSeqnos();//���κ�
		String[] outtypes = form.getOuttypes();//��������
		String[] reqorgs = form.getReqorgs();//���û�����
		String[] reqids = form.getReqids();//�����˻��²��ˣɣ�
		String[] reqnames = form.getReqnames();//�����˻��²�������
		String[] reqtimes = form.getReqtimes();//������²�ʱ��
		Integer[] reqnums = form.getReqnums();//��������
		Integer[] chknums = form.getChknums();//��������
		
		Integer[] outnums = form.getOutnums();//ʵ�ʳ�������
		String[] chkreasons = form.getChkreasons();//����˵��
		String[] pakreasons = form.getPakreasons();//����˵��
		
		String[] chkids = form.getChkids();//������ID
		String[] chknames = form.getChknames();//����������
		String[] chktimes = form.getChktimes();//����ʱ��
		String[] stockuserids = form.getStockuserids();//����˵�ID
		String[] stocknames = form.getStocknames();//����˵�����
		String[] outtimes = form.getOuttimes();//����ʱ��
		String[] rcvids = form.getRcvids();//������ID
		String[] rcvnames = form.getRcvnames();//����������
		String[] rcvtimes = form.getRcvtimes();//����ʱ��
		//String[] reqstatuss = form.getReqstatuss();//����״̬
		String[] accountstatuss = form.getAccountstatuss();//����״̬
		Double[] inprices = form.getInprices();//��ⵥ�ۣ�δʹ�ã�
		Double[] outprices = form.getOutprices();//���ⵥ��
		Double[] outamounts = form.getOutamounts();//������
		Integer[] bigpacknums = form.getBigpacknums();//���װ����
		Integer[] smallpacknums = form.getSmallpacknums();//С��װ����
		String[] itemversions = form.getItemversions();//ƾ֤�汾
		Integer[] stockids = form.getStockids();//stock��澲̬��Ϣ�������ID
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		Integer[] stocknums = form.getStocknums();//�������
		String[] types = form.getTypes();//��Ʒ����
		
		outstock.setChknum(chknums[i]==null?0:chknums[i]);//������������
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
	 * ����
	 */
	public ITEMS01DTO receiveOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0144Form form = dto.getItems0144form();
		Integer[] outstockids = form.getOutstockids();//outstock������ID
		Double[] outprices = form.getOutprices();//���ⵥ��
		Double[] outamounts = form.getOutamounts();//������
		Integer[] outnums = form.getOutnums();//��������
		String[] packnos = form.getPacknos();//������

		if(!checkReceiveStockReqstatus(form)){
			if(outstockids!=null){
				for(int i = 0,j = outstockids.length;i<j;i++){
					//���û�����Ϣ
					OutStockTB outstock = getNewTB(form,i);
					outstock.setRcvid(dto.getUserid());
					outstock.setRcvname(dto.getUsername());
					outstock.setRcvtime(CSEHelper.getCurrentTime());
					outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);//����״̬���������
					outstock.setPackno(packnos[i]);
					//����outstock��
					OutStock os = outStockBL.insertOutStock(outstock);
					
					//֧�����
					
					ITEMS0106Form items0106Form = new ITEMS0106Form();
					items0106Form.setOutnum(0);
					items0106Form.setLossnum(0);
					items0106Form.setHavocnum(0);
					items0106Form.setInstockorg(dto.getOutstockorg());//��ǰ��¼�û�����������
					items0106Form.setStockorg(dto.getOutstockorg());//��ǰ��¼�û�����������
					items0106Form.setStatus(DefineUtils.ITEMSCODES_STATUS_WCK);
					items0106Form.setInprice(outprices[i]);//��ⵥ��
					items0106Form.setInamount(outamounts[i]);//�����
					items0106Form.setInnum(outnums[i]);//�������
					
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
					items0106Form.setStocknum(outnums[i]);//�����������
					items0106Form.setLossnum(0);
					items0106Form.setLostnum(0);
					items0106Form.setPrenum(0);
					items0106Form.setOutstockid(os.getOutstockid());
					//����
					insertInStockByReceiveAction(items0106Form);

				}
			}
		}else{
			//ҳ���ύ��¼�ĳ���״̬�����ݿ��м�¼�ĳ���״̬��һ��
			dto.setGoToError("JS_REQSTATUS_ERROR");
		}
		
		return dto;
	}
	
	/**
	 * ����ʱ��֧�����
	 */
	public void insertInStockByReceiveAction(ITEMS0106Form form) throws BLException {
		inStockBL.insertInStock(form);//����InStock��
		stockBL.addToStock(form,DefineUtils.STOCK_PRENUM_JS);

	}
	
	/**
	 * ��Ʒ�²�
	 */
	public ITEMS01DTO allocateOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0146Form form = dto.getItems0146form();
		String[] reqorgs = form.getReqorgs();//�²�������
		Integer[] chknums = form.getChknums();//�²�����
		Stock stock = stockBL.findStockByPk(dto.getStockid());
	
		if(stock!=null){
			for(int i = 0,j = reqorgs.length;i<j;i++){
				OutStockTB outstock = new OutStockTB();
				//������Ʒ��Ϣ
				outstock.setCategory(stock.getCategory());
				outstock.setItemsname(stock.getItemsname());
				outstock.setSeqcode(stock.getSeqcode());
				outstock.setTypecode(stock.getTypecode());
				outstock.setStockid(stock.getStockid());
				outstock.setChknum(chknums[i]);//������������Ϊҳ����д���²�����
				outstock.setType(stock.getType());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqtime(CSEHelper.getCurrentTime());
				//outstock.setStocknum(stocknum);
				
				//�����²��������Ϣ
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//�������ͣ������²�
				outstock.setReqorg(reqorgs[i]);//�������
				outstock.setChkid(dto.getUserid());
				outstock.setChkname(dto.getUsername());
				outstock.setChktime(CSEHelper.getCurrentTime());
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//����״̬��������
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//����״̬��δ����
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				outStockBL.insertOutStock(outstock);
				
				//����stock���еı��²�����Ʒ��¼��prenum���䶯�������ӣ�
				StockTB stock1 = new StockTB();
				stock1.clone(stock);
				stock1.setStockid(dto.getStockid());
				stock1.setPrenum(chknums[i]);//�²�����
				stockBL.addToStock(stock1,DefineUtils.STOCK_PRENUM_XB);//�²�
				
			}
		}

		return dto;
	}
	

	/**
	 * ���ݴ��������ȡ�䲿�ֵ������б�('�²���ѯ'ҳ��'״̬'��)
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
	 * ���ݴ��������ȡ�䲿�ֵ������б�(�ҵ�����ҳ��'״̬'��)
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
	 * ���ݴ��������ȡ�䲿�ֵ������б�(��������ҳ��'״̬'��)
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
	 * ���ݴ��������ȡ��ȫ���������б�
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
	 * ���ݴ��������ȡ��ȫ���������б�
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
	 * ���ݴ��������ȡ�䲿�ֵ������б�(������ҳ��'��������'��)
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
	 * ���ش������֮��
	 * @return
	 */
	private BigDecimal getMultiply(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.multiply(bd2_b);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	private BigDecimal getDivide(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.divide(bd2_b,MathContext.DECIMAL32);
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	private BigDecimal getSubtract(String bd1,String bd2){
		BigDecimal bd1_b = new BigDecimal(bd1); 
		BigDecimal bd2_b = new BigDecimal(bd2); 
		
		return bd1_b.subtract(bd2_b);
	}
	
	/**
	 * ���ش������֮��
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
		double inprice = items0106Form.getInprice();//��ⵥ��
		int innum = items0106Form.getInnum();//�������
		double inamount = getMultiply(String.valueOf(inprice),String.valueOf(innum)).doubleValue(); //����ܽ��
		items0106Form.setInamount(inamount);
		double outprice = items0106Form.getOutprice();//��������
		double outamount = getMultiply(String.valueOf(outprice),String.valueOf(innum)).doubleValue();
		items0106Form.setOutamount(outamount);
		items0106Form.setStocknum(items0106Form.getInnum());
		items0106Form.setLostnum(0);
		items0106Form.setPrenum(0);
		items0106Form.setIntime(CSEHelper.getCurrentTime());			
		items0106Form.setSeqno(this.getSeqno("I", items0106Form.getCategory(), items0106Form.getSeqcode(), DefineUtils.DEFAULT_ORGNO));
		InStock inStock = inStockBL.insertInStock(items0106Form);//����InStock��

		Stock stock = stockBL.addToStock(items0106Form,DefineUtils.STOCK_PRENUM_RK);
		
		//������ϸ��
		OutStockDetailTB outStockDetail = new OutStockDetailTB();		
		outStockDetail.setCategory(items0106Form.getCategory());//��Ʒ����
		outStockDetail.setSeqcode(items0106Form.getSeqcode());//��Ʒ���
		outStockDetail.setTypecode(items0106Form.getTypecode());//��Ʒ�ͺ�
		outStockDetail.setItemsname(items0106Form.getItemsname());//��Ʒ����

		outStockDetail.setInstockid(inStock.getInstockid());
		outStockDetail.setInprice(items0106Form.getInprice());//��ⵥ��
		outStockDetail.setOutprice(items0106Form.getOutprice());//���ⵥ��
		outStockDetail.setOutamount(inamount);//�����
		outStockDetail.setOutnum(items0106Form.getInnum());//�������
		outStockDetail.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
		outStockDetail.setReqorg(DefineUtils.DEFAULT_ORGNO);
		outStockDetail.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_RK);//����Ϊ���
		outStockDetail.setInseqno(items0106Form.getSeqno());//���κ�
		outStockDetail.setOuttime(CSEHelper.getCurrentTime());//���ʱ��
		outStockDetail.setStocknum(stock.getStocknum());
		outStockDetailBL.insertOutStockDetail(outStockDetail);
		dto.setInStock(inStock);
		dto.setStock(stock);
		return dto;
	}

	public ITEMS01DTO searchInStockAction(ITEMS01DTO dto) throws BLException {
		String category = dto.getCategory();//����
		String seqcode = dto.getSeqcode();//���
		
//		User user = dto.getUser();
//		//ȡ��ǰ�û���ɫ����ΪDefineUtils.ITEMS_ROLETYPE�Ľ�ɫ����
//		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
//		rolecond.setUserid(user.getUserid());
//		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
//		boolean flag = false;//�Ƿ���Թ������п��
//		for(UserRoleInfo ur:urlist){
//			//�����ɫ����Ϊ�ĲĹ���Ĭ�Ͻ�ɫ����
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
			cond.setInstockorg(dto.getUser().getOrgid());//�û���������
		}
		
		//cond.setInstockorg_q(dto.getUserorg());
		List<InStock> inStockList = inStockBL.searchInStock(cond, 0, 0);
		int totalCount = inStockList.size();
		if (totalCount == 0) {
			// ��ѯ���ݲ�����
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			// ��ѯ���ݼ�������
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
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
					//����ѽ����򲻿��޸���ⵥ�ۺͳ��ⵥ��
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
		
		//��ѯ����ǰ�Ŀ�����
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			cond.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		if(stockList==null || stockList.size()==0){
			throw new BLException("ITEMS0110.E001");//������������
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
			//���û�������������ڿ��ÿ��ʱ������null��ҳ��ת�ô���ҳ��
			if(innum - outnum - lossnum - javocnum + adjInnum < 0){
				return null;
			}
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			inStockTB.setInnum(inStock.getInnum() + adjInnum);
			InStock newinStock = inStockBL.insertInStock(inStockTB);
			
			//����������ϸ
			OutStockDetailTB outStockDetail = new OutStockDetailTB();
			outStockDetail.setCategory(newinStock.getCategory());//��Ʒ����
			outStockDetail.setSeqcode(newinStock.getSeqcode());//��Ʒ���
			outStockDetail.setTypecode(newinStock.getTypecode());//��Ʒ�ͺ�
			outStockDetail.setItemsname(newinStock.getItemsname());//��Ʒ����
			
			outStockDetail.setInstockid(newinStock.getInstockid());
			outStockDetail.setOutnum(adjInnum);//��������
			outStockDetail.setInprice(newinStock.getInprice());//��ⵥ��
			outStockDetail.setOutprice(newinStock.getOutprice());//���ⵥ��
			outStockDetail.setOutamount(getMultiply(String.valueOf(newinStock.getInprice()), String.valueOf(adjInnum)).doubleValue());//�������
			outStockDetail.setStocknum(allAdjInnums + oldStock.getStocknum());//�������
			outStockDetail.setInseqno(newinStock.getSeqno());//���κ�
			outStockDetail.setOuttime(CSEHelper.getCurrentTime());//����ʱ��
			outStockDetail.setOutstockorg(newinStock.getInstockorg());
			outStockDetail.setReqorg(newinStock.getInstockorg());
			outStockDetail.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_RKTZ);//�������ͣ�������
			outStockDetailBL.insertOutStockDetail(outStockDetail);
		}

		StockTB stockTB = new StockTB();
		stockTB.setCategory(category);
		stockTB.setSeqcode(seqcode);
		stockTB.setPrenum(allAdjInnums);
		stockTB.setUserid(items0111form.getUserid());
		stockTB.setUsername(items0111form.getUsername());
		if(checkRoleManagerByUserID(dto)){
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		
		//�ڿ���ܱ��м�ȥ���ٵĿ��
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_TZ);
		dto.setStock(stock);
		return dto;
	}

	protected ITEMS01DTO useItemsAction(ITEMS01DTO dto) throws BLException {
		ITEMS0116Form items0116form = dto.getItems0116form();
		String category = items0116form.getCategory();
		String seqcode = items0116form.getSeqcode();
		Integer[] instockids = items0116form.getInstockid();//�����inStock��ID
		Integer[] useNums = items0116form.getUseNum();
		//String[] descs = items0116form.getDesc();
		String[] reqorgs = items0116form.getReqorg();
		String[] reqnames = items0116form.getReqname();
		
		Integer allUseItemsNum = 0;

		//��ѯ����ǰ�Ŀ�����
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		if(checkRoleManagerByUserID(dto)){
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			cond.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		
		List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
		if(stockList==null || stockList.size()==0){
			throw new BLException("ITEMS0110.E001");//������������
		}
		Stock oldStock = stockList.get(0);
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];
			Integer useNum = useNums[i];
			allUseItemsNum += useNum;
			String reqorg = reqorgs[i];
			String reqname = reqnames[i];
			InStock inStock = inStockBL.findInStockByPk(instockid);
			//��ʹ�õ��������ڿ�������ʱ(ʹ������+��������+�������+��������>�������)������null��ת�����ҳ��
			if(useNum + inStock.getOutnum() + inStock.getLossnum() + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			InStockTB inStockTB = new InStockTB();
			inStockTB.clone(inStock);
			inStockTB.setInstockid(inStock.getInstockid());
			inStockTB.setOutnum(useNum + inStock.getOutnum());
			inStockBL.insertInStock(inStockTB);
			OutStockTB outStockTB = new OutStockTB();
			//��֧��ʹ��ʱ�����ý���״̬����Ϊ֧����������²�ʱ�ѽ��й�����
			if(DefineUtils.DEFAULT_ORGNO.equals(inStock.getInstockorg())){
				outStockTB.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//����Ϊδ����
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
			outStockTB.setReqorg(reqorg);    //����ʹ���˻���
			outStockTB.setRcvname(reqname);//ʹ��������
			outStockTB.setReqid(dto.getUser().getUserid());//������ID
			outStockTB.setReqname(dto.getUser().getUsername());  //����������

			String time = CSEHelper.getCurrentTime();
			outStockTB.setReqtime(time);//����ʱ��
			outStockTB.setRcvtime(time);//����ʱ��
			outStockTB.setOuttime(time);//����ʱ��
			outStockTB.setInprice(inStock.getInprice());
			outStockTB.setOutprice(inStock.getOutprice());
			outStockTB.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());
			outStockTB.setItemsname(inStock.getItemsname());
			//outStockList.add(outStockTB);
			OutStock outStock1 = outStockBL.insertOutStock(outStockTB);
			
			//����������ϸ
			
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock1);
			outStockDetail.setOutstockid(outStock1.getOutstockid());
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(useNum);//ʹ������
			outStockDetail.setInprice(inStock.getInprice());//��ⵥ��
			outStockDetail.setOutprice(inStock.getOutprice());//���ⵥ��
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//������
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
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		//�ڿ���ܱ��м�ȥʹ�õĲ���
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
			//�����뱨�ϵ��������ڿ�������ʱ(���뱨������+��������+�������+��������>�������)������null��ת�����ҳ��
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
			outStockTB.setReqorg(dto.getUser().getOrgid());//�����˵���������
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
			
			//����������ϸ
//			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
//			outStockDetail.setOutstockid(outStock.getOutstockid());
//			outStockDetail.setInstockid(inStock.getInstockid());
//			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_SHDSP);
//			outStockDetail.setOutnum(useNum);//�������
//			outStockDetail.setInprice(inStock.getInprice());//��ⵥ��
//			outStockDetail.setOutprice(inStock.getOutprice());//���ⵥ��
//			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//������
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
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		//�ڿ���ܱ����á��䶯���������������������
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_SH);
		dto.setStock(stock);
		return dto;
	}

	protected ITEMS01DTO destroyItemsAction(ITEMS01DTO dto) throws BLException {
		ITEMS0116Form items0116form = dto.getItems0116form();
		String category = items0116form.getCategory();
		String seqcode = items0116form.getSeqcode();
		Integer[] instockids = items0116form.getInstockid();//inStock������
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
			outStockTB.setReqorg(dto.getUser().getOrgid());//�����˵���������
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
			//����������ϸ
//			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
//			outStockDetail.setOutstockid(outStock.getOutstockid());
//			outStockDetail.setInstockid(inStock.getInstockid());
//			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_XHDSP);
//			outStockDetail.setOutnum(useNum);//��������
//			outStockDetail.setInprice(inStock.getInprice());//��ⵥ��
//			outStockDetail.setOutprice(inStock.getOutprice());//���ⵥ��
//			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(useNum)).doubleValue());//������
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
			stockTB.setStockorg(DefineUtils.DEFAULT_ORGNO);//��������
		}else{
			stockTB.setStockorg(dto.getUser().getOrgid());//��ǰ�û�����
		}
		//�ڿ���ܱ����á��䶯����������������������
		Stock stock = stockBL.addToStock(stockTB,DefineUtils.STOCK_PRENUM_XH);
		dto.setStock(stock);
		
		return dto;
	}
	
	//���ͨ��
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
			//���������ٵ��������ڿ�������ʱ(������������+��������+�������+��������>�������)������null��ת�����ҳ��
			if(reqNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			outStockTB.setOutnum(reqNum);
//			outStockTB.setReqnum(0);
			outStockTB.setChktime(nowTime);
			outStockTB.setOuttime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			OutStock outStock = outStockBL.insertOutStock(outStockTB);
			
			//��ѯ������ϸ
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
			cond.setStockorg(dto.getUserorg());//��ǰ�û�����
			List<Stock> stockList = stockBL.searchStock(cond, 0, 0);
			if(stockList==null || stockList.size()==0){
				throw new BLException("ITEMS0110.E001");//������������
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
			
			//���³�����ϸ
//			OutStockDetail osd = detailList.get(0);
//			OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
			outStockDetail.setOutstockid(outStock.getOutstockid());
			//outStockDetail.setId(detailList.get(0).getId());
			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(reqNum);//���ͨ������
			outStockDetail.setInprice(inStock.getInprice());//��ⵥ��
			outStockDetail.setOutprice(inStock.getOutprice());//���ⵥ��
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(reqNum)).doubleValue());//������
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
			//���������ٵ��������ڿ�������ʱ(������������+��������+�������+��������>�������)������null��ת�����ҳ��
			if(reqNum + inStock.getOutnum() + inStock.getLossnum()  + inStock.getHavocnum() > inStock.getInnum()){
				return null;
			}
			outStockTB.setOutnum(reqNum);
//			outStockTB.setReqnum(0);
			outStockTB.setChktime(nowTime);
			outStockTB.setOuttime(nowTime);
			outStockTB.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			OutStock outStock = outStockBL.insertOutStock(outStockTB);
			
			//��ѯ������ϸ
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
				throw new BLException("ITEMS0110.E001");//������������
			}
			Stock oldStock = stockList.get(0);

			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			Integer lostNum = oldStock.getLostnum();
			stockTB.setLostnum(lostNum + reqNum);
			stockTB.setStocknum(oldStock.getStocknum() - reqNum);
			Integer preNum = oldStock.getPrenum();
			//�����ڱ䶯���������߱䶯����С���������ٵ�����������ø����������ش���ҳ
			if(preNum == null || preNum == 0 || preNum < reqNum){
				return null;
			}
			stockTB.setPrenum(preNum - reqNum);
			stockTB.setUptime(nowTime);
			stockTB.setUserid(dto.getUserid());
			stockTB.setUsername(dto.getUsername());
			Stock stock = stockBL.saveOrUpdateStock(stockTB);
			
			//���³�����ϸ
//			OutStockDetail osd = detailList.get(0);
//			OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
			OutStockDetailTB outStockDetail = getNewOutStockDetailTB(outStock);
			outStockDetail.setOutstockid(outStock.getOutstockid());
			//outStockDetail.setId(detailList.get(0).getId());
			outStockDetail.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
			outStockDetail.setInstockid(inStock.getInstockid());
			outStockDetail.setOutnum(reqNum);//���ͨ������
			outStockDetail.setInprice(inStock.getInprice());//��ⵥ��
			outStockDetail.setOutprice(inStock.getOutprice());//���ⵥ��
			outStockDetail.setOutamount(getMultiply(String.valueOf(inStock.getOutprice()), String.valueOf(reqNum)).doubleValue());//������
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
		Double[] editInprises = items0110form.getEditInprise();//��Ҫ�޸ĵ���ⵥ��
		Double[] editOutprises = items0110form.getEditOutprise();//��Ҫ�޸ĵĳ��ⵥ��
		List<Integer> outstockidList = new ArrayList<Integer>();
		//List<OutStockDetail> osdList = new ArrayList<OutStockDetail>();
		Map<Integer,List<OutStockDetail>> map = new HashMap<Integer,List<OutStockDetail>>();//<outstockid,List<OutStockDetail>>
		
		for (int i = 0; i < instockids.length; i++) {
			Integer instockid = instockids[i];//inStock������
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
			boolean flag = false;//�Ƿ�Ӧ�ñ�����
			if(detailList!=null && detailList.size()>0){
				for(OutStockDetail detail:detailList){
					//��ѯ��Ӧ�ĳ����¼
					if(detail.getOutstockid()!=null && detail.getOutstockid()!=0){
						OutStock outStock = outStockBL.findOutStockByPk(detail.getOutstockid());
						//��ѯ�ó����¼��Ӧ��ȫ��������ϸ
						detailcond = new OutStockDetailSearchCondImpl();
						detailcond.setOutstockid(outStock.getOutstockid());
						List<OutStockDetail> osdList = outStockDetailBL.searchOutStockDetail(detailcond, 0, 0);
						for(OutStockDetail osd:osdList){
							flag = false;
							//ֻ��ȷʵ������������¼��Ӧ����ϸ��¼�ű��޸�
							if(inStock.getInstockid().equals(osd.getInstockid())){
								flag = true;
							}
							//������⡢������ϸ
							OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);			
							//outStockDetail.setInstockid(inStock.getInstockid());
							if(flag){
								outStockDetail.setInprice(editInprise);//��ⵥ��
								outStockDetail.setOutprice(editOutprise);//���ⵥ��
							}
							if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(osd.getOuttype())
								 || DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(osd.getOuttype())){
								if(flag){
									outStockDetail.setOutamount(getMultiply(String.valueOf(editInprise), String.valueOf(osd.getOutnum())).doubleValue());//�����
									outStockDetailBL.insertOutStockDetail(outStockDetail);
								}
								
							}else if(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_ZHXB.equals(osd.getOuttype())
									|| DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(osd.getOuttype())){
								if(flag){
									outStockDetail.setOutamount(getMultiply(String.valueOf(editOutprise), String.valueOf(osd.getOutnum())).doubleValue());//������
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
						//outstockid�����ڣ���˵������ϸΪ����¼����������¼
						flag = false;
						//ֻ��ȷʵ������������¼��Ӧ����ϸ��¼�ű��޸�
						if(inStock.getInstockid().equals(detail.getInstockid())){
							flag = true;
						}
						//������⡢������ϸ
						OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(detail);			
						//outStockDetail.setInstockid(inStock.getInstockid());
						if(flag){
							outStockDetail.setInprice(editInprise);//��ⵥ��
							outStockDetail.setOutprice(editOutprise);//���ⵥ��
						}
						if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(detail.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(detail.getOuttype())
							 || DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(detail.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(detail.getOuttype())){
							if(flag){
								outStockDetail.setOutamount(getMultiply(String.valueOf(editInprise), String.valueOf(detail.getOutnum())).doubleValue());//�����
								outStockDetailBL.insertOutStockDetail(outStockDetail);
							}
							
						}
						
					}


				}
			}
			
		}
		//���³�����Ϣ
		Double out_price = 0d;//���ⵥ��
		Double out_amount = 0d;//������
		Double out_price_part = 0d;//���ⵥ�ۺϼ�
		if(outstockidList!=null && outstockidList.size()>0){
			for(Integer outstockid:outstockidList){
				OutStock outStock = outStockBL.findOutStockByPk(outstockid);
				OutStockTB ostb = (OutStockTB)SerializationUtils.clone(outStock);	
				out_price = 0d;
				out_amount = 0d;
				out_price_part = 0d;
				
				//�������ƽ�����ۼ�������
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
					
					//����֧�н��ռ�¼
					InStockSearchCondImpl incond = new InStockSearchCondImpl();
					incond.setOutstockid(outstockid);
					List<InStock> inlist = inStockBL.searchInStock(incond, 0, 0);
					for(InStock inStock:inlist){
						InStockTB inStockTB = new InStockTB();
						inStockTB.clone(inStock);
						inStockTB.setInstockid(inStock.getInstockid());
						inStockTB.setInprice(out_price);//����֧�����۸�Ϊ������ĳ���۸�
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
				//���³�����ϸ
				OutStockDetailTB outStockDetail = (OutStockDetailTB)SerializationUtils.clone(osd);
				outStockDetail.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ);
				outStockDetail.setPaytime(paytime);
				outStockDetailBL.insertOutStockDetail(outStockDetail);
			}
			
		}
		return dto;
	}

	public ITEMS01DTO reportInStockAction(ITEMS01DTO dto) throws BLException {
		//��DTO�л�ȡҳ������Ŀ�ʼʱ��ͽ���ʱ��
		String intime_f = dto.getTime_f();
		String intime_t = dto.getTime_t();
		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setIntime_f(intime_f);
		cond.setIntime_t(intime_t);
		cond.setInstockorg(dto.getInstockorg());
		cond.setInstock_sort(DefineUtils.INSTOCK_SORT_BYINCODE);//����Ʒ�������
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
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		pDto.setTotalCount(totalCount);
		inStockList = inStockBL.searchInStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setInStockList(inStockList);
		return dto;
	}
	
	public ITEMS01DTO reportOutStockAction(ITEMS01DTO dto) throws BLException{
		//��DTO�л�ȡҳ������Ŀ�ʼʱ��ͽ���ʱ�䣬��������
		String outtime_f = dto.getTime_f();
		String outtime_t = dto.getTime_t();
		OutStockSearchCondImpl cond = new OutStockSearchCondImpl();
		cond.setOuttime_f(outtime_f);
		cond.setOuttime_t(outtime_t);
		cond.setOuttype(dto.getOuttype());
		cond.setReqorg(dto.getOutstockorg_q());//�������
		cond.setOutstockorg(dto.getOutstockorg());//��������
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
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
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
		if (methodName.equals("insertInStockAction")){ //��Ʒ���
			dto = this.insertInStockAction(dto);
		}
		else if (methodName.equals("adjustStockAction")){ //������
			dto = this.adjustStockAction(dto);
		}
		else if (methodName.equals("useItemsAction")){ //�����ڲ�ʹ��
			dto = this.useItemsAction(dto);
		}
		else if (methodName.equals("wasteItemsAction")){ //�������
			dto = this.wasteItemsAction(dto);
		}
		else if (methodName.equals("destroyItemsAction")){ //��������
			dto = this.destroyItemsAction(dto);
		}
		else if (methodName.equals("approveWaste")){//�������
			dto = this.approveWaste(dto);
		}
		else if (methodName.equals("noApproveWaste")){//�������
			dto = this.noApproveWaste(dto);
		}
		else if (methodName.equals("approveDestroy")){//��������
			dto = this.approveDestroy(dto);
		}
		else if (methodName.equals("noApproveDestroy")){//��������
			dto = this.noApproveDestroy(dto);
		}
		else if (methodName.equals("insertOutStockAction")){//����Ǽ�
			dto = this.insertOutStockAction(dto);
		}
		else if (methodName.equals("editOutStockAction")){//�����޸�
			dto = this.editOutStockAction(dto);
		}
		else if (methodName.equals("delOutStockAction")){//����ɾ��
			dto = this.delOutStockAction(dto);
		}
		else if (methodName.equals("approveOutStockAction")){//��������
			dto = this.approveOutStockAction(dto);
		}
		else if (methodName.equals("distributionOutStockAction")){//�����·�(����)
			dto = this.distributionOutStockAction(dto);
		}
		else if (methodName.equals("receiveOutStockAction")){//����
			dto = this.receiveOutStockAction(dto);
		}
		else if (methodName.equals("allocateOutStockAction")){//�²�
			dto = this.allocateOutStockAction(dto);
		}
		else if (methodName.equals("editInStockAction")){//�޸�
			dto = this.editInStockAction(dto);
		}
		else if (methodName.equals("payAction")){//����
			dto = this.payAction(dto);
		}
		else if (methodName.equals("orgOutStockAction")){//�����²�
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
	 * ��ѯ��Ʒ����
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
			
			//����
			int outCount = 0;
			//��ⵥ��
			Double inPrice = 0.0;
			//���ⵥ��
			Double outPrice = 0.0;
			
			for(OutStockDetail osd : osdList) {
				outCount += osd.getOutnum();
				inPrice = getAdd(String.valueOf(inPrice), String.valueOf(getMultiply(String.valueOf(osd.getOutnum()), String.valueOf(osd.getInprice())).doubleValue())).doubleValue();
				outPrice = getAdd(String.valueOf(outPrice), String.valueOf(getMultiply(String.valueOf(osd.getOutnum()), String.valueOf(osd.getOutprice())).doubleValue())).doubleValue();

			}
			if(0 != outCount) {
				//��������
				vo.setCount(outCount + "");
				inPrice = round(getDivide(String.valueOf(inPrice), String.valueOf(outCount)).doubleValue(),4);
				vo.setCountPrice(outPrice + "");
				vo.setInPrice(inPrice.toString());
				outPrice = round(getDivide(String.valueOf(outPrice), String.valueOf(outCount)).doubleValue(),4);
				vo.setOutPrice(outPrice + "");
				/*	�����㷨��
					ʹ�ã������ⵥ��*����������������ⵥ��*����������
			    	�²��������ⵥ��*����������������ⵥ��*����������
			    	���죺�����ⵥ��*����������������ⵥ��*����������
			    	��ģ�������ⵥ��*����������
			    	���٣�������ⵥ��*����������
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
	 * ��ѯ��Ʒ����
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
		Double total = 0.0;//�����ܼ�
		for(OutStockDetail osd : outStockDetailList) {
			ITEMS01712VO vo = new ITEMS01712VO();
			vo.setOutStockDetail(osd);
			vo.setDate(osd.getOuttime().substring(0,10));
			//����������
			if(DefineUtils.ITEMSCODES_OUTTYPE_RK.equals(osd.getOuttype()) || DefineUtils.ITEMSCODES_OUTTYPE_RKTZ.equals(osd.getOuttype())) {
				vo.setInNum(osd.getOutnum() + "");//�������
				vo.setInPrice(osd.getInprice() + "");//��ⵥ��
				vo.setInCountPrice(osd.getOutamount() + "");//�����
				vo.setOutNum(DefineUtils.SEPARATOR);//��������
				vo.setOutPrice(DefineUtils.SEPARATOR);//���ⵥ��
				vo.setOutCountPrice(DefineUtils.SEPARATOR);//������
				vo.setIncome(DefineUtils.SEPARATOR);//����
				vo.setStockNum(osd.getStocknum() + "");//�������
			} else {
				vo.setInNum(DefineUtils.SEPARATOR);//�������
				vo.setInPrice(osd.getInprice() + "");//��ⵥ��
				vo.setInCountPrice(DefineUtils.SEPARATOR);//�����
				vo.setOutNum(osd.getOutnum() + "");//��������
				vo.setStockNum(osd.getStocknum() + "");//�������
				
				/*	�����㷨
					ʹ�ã������ⵥ��*����������������ⵥ��*����������
			    	�²��������ⵥ��*����������������ⵥ��*����������
			    	���죺�����ⵥ��*����������������ⵥ��*����������
			    	��ģ�������ⵥ��*����������
			    	���٣�������ⵥ��*����������
				 */
				if(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL.equals(osd.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_ZHXB.equals(osd.getOuttype())||
						DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(osd.getOuttype())) {
					vo.setOutPrice(osd.getOutprice() + "");//���ⵥ��
					vo.setOutCountPrice(osd.getOutamount() + "");//������
					vo.setIncome(getMultiply(String.valueOf(getSubtract(String.valueOf(osd.getOutprice()), String.valueOf(osd.getInprice())).doubleValue()), String.valueOf(osd.getOutnum())).doubleValue() + "");//����
	
					total = getAdd(String.valueOf(total), 
								String.valueOf(getMultiply(String.valueOf(getSubtract(String.valueOf(osd.getOutprice()), String.valueOf(osd.getInprice())).doubleValue()), String.valueOf(osd.getOutnum())).doubleValue())).doubleValue();

				} else if(DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(osd.getOuttype()) ||
						DefineUtils.ITEMSCODES_OUTTYPE_XH.equals(osd.getOuttype())) {
					vo.setOutPrice(DefineUtils.SEPARATOR);//���ⵥ��
					vo.setOutCountPrice(DefineUtils.SEPARATOR);//������
					vo.setIncome("-" + getMultiply(String.valueOf(osd.getInprice()),String.valueOf(osd.getOutnum())).doubleValue());//����
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
	 * ���ر���ȡ�������
	 * @param doubleValue ����ȡ������
	 * @param scale С�������λ��
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
		dto.addMessage(new ActionMessage("ITEMS0101.I001","��Ʒ״̬"));
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ������ѯ
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
		log.debug("========������ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = organizationBL.getOrganizationSearchCount(dto
				.getOrganizationSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<Organization> organizationList = organizationBL.searchOrganization(dto
				.getOrganizationSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//���û���ȫ��

		dto.setOrganizationCondList(organizationList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========������ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ȡ�ð�������ȫ���Ļ������󼯺�
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
	 * ȡ�øý��Ļ���ȫ��
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
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý�ɫ��������¼�������
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
	 * ��ѯstock���е���Ʒ(�����²�)
	 */
	public ITEMS01DTO searchStockForOrgAction(ITEMS01DTO dto) throws BLException {
		
		String category = dto.getCategory();
		String typecode_q = dto.getTypecode_q();//��Ʒ����
		
		ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
		cond.setCategory(category);
		cond.setTypecode(typecode_q);
		cond.setStatus(DefineUtils.ITEMSCATEGORY_STATUS_QY);//��״̬Ϊ���õļ�¼
		List<ItemsCategory> itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		//����DAO�ӿڲ�ѯ
		itemsCategoryList = itemsCategoryBL.searchItemsCategory(cond, 0, 0);
		dto.setItemsCategoryList(itemsCategoryList);
		return dto;
	}
	
	/**
	 * �����²�������outstock��������һ�������¼��
	 */
	public ITEMS01DTO orgOutStockAction(ITEMS01DTO dto) throws BLException {
		ITEMS0175Form form = dto.getItems0175form();
		String[] categorys = form.getCategorys();//��Ʒ����
		String[] itemsnames = form.getItemsnames();//��Ʒ����
		String[] seqcodes = form.getSeqcodes();//��Ʒ���
		String[] typecodes = form.getTypecodes();//��Ʒ�ͺ�
		Integer[] reqnums = form.getReqnums();//��������
		Integer[] stocknum = form.getStocknum();//��������
		for(int i = 0;i<reqnums.length;i++){
			if(reqnums[i]>stocknum[i]){
				throw new BLException("ITEMS0175.E002", seqcodes[i], itemsnames[i]);
			}
		}
		String time = CSEHelper.getCurrentTime();
		if(categorys!=null){
			for(int i = 0,j = categorys.length;i<j;i++){
				//��ѯstock
				StockSearchCondImpl scond = new StockSearchCondImpl();
				scond.setCategory(categorys[i]);
				scond.setSeqcode(seqcodes[i]);
				scond.setStockorg(DefineUtils.DEFAULT_ORGNO);
				
				List<Stock> stocklist = stockBL.searchStock(scond, 0, 0);
				if(stocklist==null || stocklist.size()==0){
					throw new BLException("ITEMS0175.E001", form.getSeqcodes()[i], form.getItemsnames()[i]);//��ţ�����Ϊ��������Ʒ��Ϣ������
				}
				Stock stock = stocklist.get(0);
				
				OutStockTB outstock = new OutStockTB();
				//������Ʒ��Ϣ
				outstock.setCategory(categorys[i]);
				outstock.setItemsname(itemsnames[i]);
				outstock.setSeqcode(seqcodes[i]);
				outstock.setTypecode(typecodes[i]);
				outstock.setReqnum(reqnums[i]);
				outstock.setChknum(reqnums[i]);//������������Ϊҳ����д���²�����
				
				outstock.setStockid(stock.getStockid());			
				outstock.setType(stock.getType());
				
				//��������������Ϣ
				outstock.setOuttype(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);//�������ͣ������²�
				outstock.setReqorg(form.getReqorg());
				outstock.setReqid(dto.getUserid());
				outstock.setReqname(dto.getUsername());
				outstock.setReqtime(time);
				outstock.setChkid(dto.getUserid());
				outstock.setChkname(dto.getUsername());
				outstock.setChktime(time);
				outstock.setReqstatus(DefineUtils.ITEMSCODES_REQSTATUS_DCK);//����״̬��������
				outstock.setAccountstatus(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ);//����״̬��δ����
				outstock.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
				
				outStockBL.insertOutStock(outstock);
				
				//����stock���еı��²�����Ʒ��¼��prenum���䶯�������ӣ�
				StockTB stock1 = new StockTB();
				stock1.clone(stock);
				stock1.setStockid(stock.getStockid());
				stock1.setPrenum(reqnums[i]);//�²�����
				stockBL.addToStock(stock1,DefineUtils.STOCK_PRENUM_XB);//�²�
				
			}
		}
		return dto;
	}

	/**
	 * ��ѯ���һ�������Ʒ��Ϣ
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
