/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.GinoutstockdetailBL;
import com.csebank.lom.bl.task.GoodsBL;
import com.csebank.lom.bl.task.GoutstockBL;
import com.csebank.lom.bl.task.GoutstockVWBL;
import com.csebank.lom.bl.task.GstockBL;
import com.csebank.lom.bl.task.GstockVWBL;
import com.csebank.lom.bl.task.InventoryBL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0201Form;
import com.csebank.lom.form.IGLOM0202Form;
import com.csebank.lom.form.IGLOM0203Form;
import com.csebank.lom.form.IGLOM0204Form;
import com.csebank.lom.form.IGLOM0208Form;
import com.csebank.lom.form.IGLOM0211Form;
import com.csebank.lom.form.IGLOM0212Form;
import com.csebank.lom.form.IGLOM0213Form;
import com.csebank.lom.form.IGLOM0214Form;
import com.csebank.lom.form.IGLOM0216Form;
import com.csebank.lom.form.IGLOM0218Form;
import com.csebank.lom.form.IGLOM0220Form;
import com.csebank.lom.form.IGLOM0512Form;
import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.Goods;
import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCondImpl;
import com.csebank.lom.model.condition.GoodsSearchCondImpl;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.condition.GoutstockSearchCondImpl;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.condition.GstockSearchCondImpl;
import com.csebank.lom.model.condition.GstockVWSearchCondImpl;
import com.csebank.lom.model.condition.InventoryInfoSearchCondImpl;
import com.csebank.lom.model.condition.InventorySearchCondImpl;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.csebank.lom.model.entity.GinoutstockdetailTB;
import com.csebank.lom.model.entity.GoutstockTB;
import com.csebank.lom.model.entity.GstockTB;
import com.csebank.lom.model.entity.InventoryInfoVW;
import com.csebank.lom.model.entity.InventoryTB;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;

/**
 *  �Ӵ�����BLʵ��
 */
public class IGLOM02BLImpl extends BaseBLImpl implements IGLOM02BL {
	
	static Log log = LogFactory.getLog(IGLOM02BLImpl.class);

	/** ��Ʒ����BL */
	protected GoodsBL goodsBL;
	
	/** ����BL */
	protected GoutstockBL goutstockBL;
	
	/** �������ϸBL */
	protected GinoutstockdetailBL ginoutstockdetailBL;
	
	/** ���BL */
	protected GstockBL gstockBL;
	
	/** ��Ʒ������Ϣ��ͼBL */
	protected GoutstockVWBL goutstockVWBL;
	
	
	/** Ԥ����Ϣ��ͼBL */
	protected GstockVWBL gstockVWBL;
	
	
	protected CodeDetailBL codeDetailBL;
	
	/** ÿ���̵�BL */
	protected InventoryBL inventoryBL;

	/**
	 * @param inventoryBL
	 */
	public void setInventoryBL(InventoryBL inventoryBL) {
		this.inventoryBL = inventoryBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
    public String getCodeValue(String code) throws BLException {
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setSyscoding(code);
		List<CodeDetail> codeDetailList = this.codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		if(codeDetailList!=null && codeDetailList.size()>0){
			return codeDetailList.get(0).getCvalue();
		}else{
			return "";
		}
		
		
	}
	
	
	/**
	 * @param goutstockVWBL the goutstockVWBL to set
	 */
	public void setGoutstockVWBL(GoutstockVWBL goutstockVWBL) {
		this.goutstockVWBL = goutstockVWBL;
	}

	/**
	 * @param gstockVWBL the gstockVWBL to set
	 */
	public void setGstockVWBL(GstockVWBL gstockVWBL) {
		this.gstockVWBL = gstockVWBL;
	}

	/**
	 * @param gstockBL the gstockBL to set
	 */
	public void setGstockBL(GstockBL gstockBL) {
		this.gstockBL = gstockBL;
	}

	/**
	 * @param ginoutstockdetailBL the ginoutstockdetailBL to set
	 */
	public void setGinoutstockdetailBL(GinoutstockdetailBL ginoutstockdetailBL) {
		this.ginoutstockdetailBL = ginoutstockdetailBL;
	}

	/**
	 * @param goutstockBL the goutstockBL to set
	 */
	public void setGoutstockBL(GoutstockBL goutstockBL) {
		this.goutstockBL = goutstockBL;
	}

	public void setGoodsBL(GoodsBL goodsBL) {
		this.goodsBL = goodsBL;
	}


	public IGLOM02DTO insertGoodsAction(IGLOM02DTO dto) throws BLException {
		Goods goods = dto.getGoods();
		String category = goods.getGcategory();
		String code = goods.getGcode();
		GoodsSearchCondImpl cond = new GoodsSearchCondImpl();
		cond.setGcategory(category);
		cond.setGcode(code);
		if(!"1".equals(dto.getIglom0201Form().getMode())){
			int count = goodsBL.getSearchCount(cond);
			if(count > 0){
				throw new BLException("IGLOM0200.E001", "ͬһ������Ʒ��Ų����ظ�");
			}			
		}
		Goods retGoods = goodsBL.registGoods(dto.getGoods());
		dto.setGoods(retGoods);
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒ�޸�"));	
		return dto;
	}

	public IGLOM02DTO searchGoodsAction(IGLOM02DTO dto) throws BLException {
		GoodsSearchCondImpl cond = new GoodsSearchCondImpl();
		cond.setGname(dto.getIglom0202Form().getGname_q());
		cond.setGcategory(dto.getIglom0202Form().getGcategory());
		cond.setGstatus(dto.getIglom0202Form().getGstatus());
		PagingDTO pDto = dto.getPagingDto();
		
		int totalCount = this.goodsBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<Goods> goodsList = goodsBL.searchGoods(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setGoodsList(goodsList);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		return dto;
	}
	
	public String searchGoodsCodeAction(String gcategory) throws BLException {
		String goodCode = "";
		List<Goods> goodsList = goodsBL.searchGoods(gcategory.substring(0,6));
		if(goodsList.size()==0){
			goodCode = gcategory.substring(0,6)+"00001";
		}else{
			goodCode = (new BigDecimal(goodsList.get(0).getGcode())).add(new BigDecimal(1)).toString();
		}
		return goodCode;
	}


	public IGLOM02DTO searchGoodsByKey(IGLOM02DTO dto) throws BLException {
		IGLOM0201Form iglom0201Form = dto.getIglom0201Form();
		Goods goods = goodsBL.searchGoodsByKey(iglom0201Form.getGid());
		iglom0201Form.setGcategory(goods.getGcategory());
		iglom0201Form.setGcode(goods.getGcode());
		iglom0201Form.setGname(goods.getGname());
		iglom0201Form.setGstatus(goods.getGstatus());
		iglom0201Form.setGunit(goods.getGunit());
		iglom0201Form.setGprice(goods.getGprice());
		iglom0201Form.setGwarningnum(goods.getGwarningnum());
		iglom0201Form.setGreason(goods.getGreason());
		iglom0201Form.setGcategoryname(goods.getGcategoryname());
		iglom0201Form.setMode("1");
		return dto;
	}

	public IGLOM02DTO deleteGoodsAction(IGLOM02DTO dto) throws BLException {
		IGLOM0202Form iglom0202Form = dto.getIglom0202Form();
		Integer[] goodids = iglom0202Form.getDeleteGoodid();
		for (int i = 0; i < goodids.length; i++) {
			goodsBL.deleteGoods(goodids[i]);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒɾ��"));	
		return dto;
	}

	protected IGLOM02DTO insertInStockAction(IGLOM02DTO dto) throws BLException {
		String currentTime = LOMHelper.getCurrentTime();
		IGLOM0203Form iglom0203Form = dto.getIglom0203Form();
		iglom0203Form.setGiodtype(IGLOMCONSTANTS.GIODTYPE_RK);
		iglom0203Form.setGiodtime(currentTime);
		iglom0203Form.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);
		iglom0203Form.setGioduser(dto.getUser().getUserid());
		iglom0203Form.setGiodusername(dto.getUser().getUsername());
		iglom0203Form.setGiodhavocnum(0);
		iglom0203Form.setGiodreliefnum(0);
		iglom0203Form.setGiodchknum(0);
		iglom0203Form.setGiodoutnum(0);
		iglom0203Form.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
		List<Ginoutstockdetail> gIOStockList = ginoutstockdetailBL.searchGinoutstockdetail(iglom0203Form, 0, 0);
		if(gIOStockList != null && gIOStockList.size() > 0){
			throw new BLException("IGLOM0200.E001", "ͬһ����ͬһ��Ųɹ����Ų�����ͬ");
		}
		Ginoutstockdetail ginoutstockdetail = ginoutstockdetailBL.registGinoutstockdetail(iglom0203Form);
		
		GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
		gStockCond.setGscode(ginoutstockdetail.getGiodcode());
		gStockCond.setGscategory(ginoutstockdetail.getGiodcategory());
		gStockCond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
		List<Gstock> gStockList = gstockBL.searchGstock(gStockCond, 0, 0);
		
		GstockTB gStockTB = new GstockTB();
		if(gStockList.size() == 0){			
			gStockTB.setGscategory(ginoutstockdetail.getGiodcategory());
			gStockTB.setGsname(ginoutstockdetail.getGiodname());
			gStockTB.setGscode(ginoutstockdetail.getGiodcode());
			gStockTB.setGsnum(ginoutstockdetail.getGiodinnum());
			gStockTB.setGsavgprice(ginoutstockdetail.getGiodinprice());
			gStockTB.setGsfreezenum(0);
			gStockTB.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
		} else {
			gStockTB = (GstockTB)SerializationUtils.clone(gStockList.get(0));
			Integer sumNum = gStockTB.getGsnum() + ginoutstockdetail.getGiodinnum();
			double allPrice = LOMHelper.getAdd(LOMHelper.getMultiply(gStockTB.getGsnum()+"", gStockTB.getGsavgprice()+"") + "",
					LOMHelper.getDivide(ginoutstockdetail.getGiodinnum() + "", ginoutstockdetail.getGiodinprice()+"") + "").doubleValue();
			double avgprice = LOMHelper.getDivide(allPrice+"", sumNum+"").doubleValue();
			gStockTB.setGsavgprice(new BigDecimal(avgprice));
			gStockTB.setGsnum(sumNum);
		}
		gStockTB.setGsuserid(dto.getUser().getUserid());
		gStockTB.setGsusername(dto.getUser().getUsername());
		gStockTB.setGsdate(currentTime);
		Gstock gs = gstockBL.registGstock(gStockTB);

		GinoutstockdetailTB gitb = (GinoutstockdetailTB)SerializationUtils.clone(ginoutstockdetail);
		gitb.setGsnum(gs.getGsnum());
		ginoutstockdetailBL.updateGinoutstockdetail(gitb);
		
		
		return dto;
	}

	
	protected IGLOM02DTO editInStockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0204Form iglom0204Form = dto.getIglom0204Form();
		Integer[] selectids = iglom0204Form.getSelectids();
//		String[] giodunits = iglom0204Form.getGiodunits();
		BigDecimal[] giodinprices = iglom0204Form.getGiodinprices();
		Integer[] giodinnums = iglom0204Form.getGiodinnums();
		for (int i = 0; i < selectids.length; i++) {
			Ginoutstockdetail gIOStockDetail = ginoutstockdetailBL.searchGinoutstockdetailByKey(selectids[i]);
			Integer inStockNum = gIOStockDetail.getGiodinnum();
			if(gIOStockDetail.getGioid() != null){
				throw new BLException("IGLOM0200.E001", "�����б䶯�������²���");
			}
			if(giodinnums[i] < gIOStockDetail.getGiodhavocnum()){
				throw new BLException("IGLOM0200.E001", "�����������С���Ѿ���������");
			}
			GinoutstockdetailTB gIOStockDetailTB = (GinoutstockdetailTB)SerializationUtils.clone(gIOStockDetail);
//			gIOStockDetailTB.setGiodunit(giodunits[i]);
			gIOStockDetailTB.setGiodinprice(giodinprices[i]);
			gIOStockDetailTB.setGiodinnum(giodinnums[i]);
			ginoutstockdetailBL.registGinoutstockdetail(gIOStockDetailTB);
			
			String gscategory = gIOStockDetail.getGiodcategory();
			String gscode = gIOStockDetail.getGiodcode();
			String org = gIOStockDetail.getGiodorg();
			GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
			gStockCond.setGscategory(gscategory);
			gStockCond.setGscode(gscode);
			gStockCond.setGsorg(org);
			Gstock gStock = gstockBL.searchGstock(gStockCond, 0, 0).get(0);
			GstockTB gStockTB = (GstockTB)SerializationUtils.clone(gStock);
			Integer sumNum = gStockTB.getGsnum() - inStockNum + giodinnums[i];
			double allPrice = LOMHelper.getAdd(LOMHelper.getMultiply((gStockTB.getGsnum()- gIOStockDetail.getGiodinnum())+"", gStockTB.getGsavgprice()+"")+"",
					LOMHelper.getMultiply(giodinnums[i]+"", giodinprices[i]+"")+"").doubleValue();
				
			double avgprice = LOMHelper.getDivide(allPrice+"", sumNum+"").doubleValue();
			gStockTB.setGsavgprice(new BigDecimal(avgprice));
			gStockTB.setGsnum(sumNum);
			gstockBL.registGstock(gStockTB);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒ�޸�"));	
		return dto;
	}
	
	protected IGLOM02DTO deleteInStockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0204Form iglom0204Form = dto.getIglom0204Form();
		Integer[] selectids = iglom0204Form.getSelectids();
		for (int i = 0; i < selectids.length; i++) {
			Ginoutstockdetail gIOStockDetail = ginoutstockdetailBL.searchGinoutstockdetailByKey(selectids[i]);
			
			String outStockNum = new BigDecimal(gIOStockDetail.getGiodreliefprice()==null ? "0": gIOStockDetail.getGiodreliefprice().toString()).add(
					 new BigDecimal(String.valueOf(gIOStockDetail.getGiodoutnum()==null ? "0": gIOStockDetail.getGiodoutnum())).add(
					 new BigDecimal(String.valueOf(gIOStockDetail.getGiodhavocnum()==null ? "0": gIOStockDetail.getGiodhavocnum())))).toString();		 
			if(!"0".equals(outStockNum)){
				throw new BLException("IGLOM0200.E001", "����Ʒ�ѳ��⣬����ɾ����");
			}
		}
		for (int i = 0; i < selectids.length; i++) {
			Ginoutstockdetail gIOStockDetail = ginoutstockdetailBL.searchGinoutstockdetailByKey(selectids[i]);
			if(gIOStockDetail.getGioid() != null){
				throw new BLException("IGLOM0200.E001", "�����б䶯�������²���");
			}
			if(gIOStockDetail.getGiodhavocnum() != null && gIOStockDetail.getGiodhavocnum() != 0){
				throw new BLException("IGLOM0200.E001", "�����б䶯�������²���");
			}
			String gscategory = gIOStockDetail.getGiodcategory();
			String gscode = gIOStockDetail.getGiodcode();
			String org = gIOStockDetail.getGiodorg();
			String reqnum = gIOStockDetail.getGiodreqnum();
			
			GoutstockSearchCondImpl gOutStockCond = new GoutstockSearchCondImpl();
			gOutStockCond.setGocategory(gscategory);
			gOutStockCond.setGocode(gscode);
			gOutStockCond.setGoorg(org);
			gOutStockCond.setGoreqnum(reqnum);
			List<Goutstock> gOutStockList = goutstockBL.searchGoutstock(gOutStockCond, 0, 0);
			Integer osfreezenum = 0;
			for (Goutstock goutstock : gOutStockList) {
				osfreezenum += goutstock.getGochknum();
				goutstockBL.deleteGoutstock(goutstock.getGoid());
			}
			
			GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
			gStockCond.setGscategory(gscategory);
			gStockCond.setGscode(gscode);
			gStockCond.setGsorg(org);
			Gstock gStock = gstockBL.searchGstock(gStockCond, 0, 0).get(0);
			Integer sumNum = gStock.getGsnum() - gIOStockDetail.getGiodinnum();
			if(0 == sumNum){
				gstockBL.deleteGstock(gStock.getGsid());
			} else {
				GstockTB gStockTB = (GstockTB)SerializationUtils.clone(gStock);
				double allPrice = LOMHelper.getMultiply((gStockTB.getGsnum()- gIOStockDetail.getGiodinnum())+"", gStockTB.getGsavgprice()+"").doubleValue();
				double avgprice = LOMHelper.getDivide(allPrice+"", sumNum+"").doubleValue();
				gStockTB.setGsavgprice(new BigDecimal(avgprice));
				gStockTB.setGsnum(sumNum);
				gStockTB.setGsfreezenum(gStockTB.getGsfreezenum() - osfreezenum);
				gstockBL.registGstock(gStockTB);
			}
			
			ginoutstockdetailBL.deleteGinoutstockdetail(selectids[i]);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒɾ��"));	
		return dto;
	}
	
	/**
	 * �������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	protected IGLOM02DTO destroyStockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0211Form iglom0211Form = dto.getIglom0211Form();
		Integer[] selectids = iglom0211Form.getSelectids();
		Integer[] giodhavocnums = iglom0211Form.getGiodhavocnums();//�����������
		String[] goreasons = iglom0211Form.getGoreasons();//˵��
		for (int i = 0; i < selectids.length; i++) {
			Ginoutstockdetail gIOStockDetail = ginoutstockdetailBL.searchGinoutstockdetailByKey(selectids[i]);
			if(gIOStockDetail.getGiodinnum() - gIOStockDetail.getGiodhavocnum()- gIOStockDetail.getGiodreliefnum()- gIOStockDetail.getGiodoutnum()
					- giodhavocnums[i] < 0){
				throw new BLException("IGLOM0200.E001", gIOStockDetail.getGiodname() + "�ĺ����������ܴ��ڿ������");
			}
			String gscategory = gIOStockDetail.getGiodcategory();
			String gscode = gIOStockDetail.getGiodcode();
			String gsname = gIOStockDetail.getGiodname();
			String org = gIOStockDetail.getGiodorg();
			//String reqnum = gIOStockDetail.getGiodreqnum();
			
			GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
			gStockCond.setGscategory(gscategory);
			gStockCond.setGscode(gscode);
			gStockCond.setGsorg(org);
			
			Gstock gStock = gstockBL.searchGstock(gStockCond, 0, 0).get(0);
			if(giodhavocnums[i] > gStock.getGsnum()){
				throw new BLException("IGLOM0200.E001", gIOStockDetail.getGiodname() + "�ĺ����������ܴ��ڿ������");
			}

			GoutstockTB gOutStockTB = new GoutstockTB();
			gOutStockTB.setGocategory(gscategory);
			gOutStockTB.setGocode(gscode);
			gOutStockTB.setGoname(gsname);
			gOutStockTB.setGouser(dto.getUser().getUserid());
			gOutStockTB.setGousername(dto.getUser().getUsername());
			gOutStockTB.setGoreqnum(gIOStockDetail.getGiodreqnum());//�ɹ�������
			gOutStockTB.setGostatus(IGLOMCONSTANTS.GIODSTATUS_DSP);
			gOutStockTB.setGotype(IGLOMCONSTANTS.GIODTYPE_HX);
			gOutStockTB.setGochknum(giodhavocnums[i]);//������������
			gOutStockTB.setGoreason(goreasons[i]);//˵��
			gOutStockTB.setGoorg(org);
			goutstockBL.registGoutstock(gOutStockTB);
			
			
			
			
			GstockTB gStockTB = (GstockTB)SerializationUtils.clone(gStock);
			gStockTB.setGsnum(gStockTB.getGsnum()-giodhavocnums[i]);
			gStockTB.setGsfreezenum(gStockTB.getGsfreezenum() + giodhavocnums[i]);
			Gstock gs = gstockBL.registGstock(gStockTB);
			
			GinoutstockdetailTB gIOStockTB = (GinoutstockdetailTB)SerializationUtils.clone(gIOStockDetail);
			gIOStockTB.setGsnum(gs.getGsnum());
			ginoutstockdetailBL.updateGinoutstockdetail(gIOStockTB);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒ��������"));	
		return dto;
	}
	
	public IGLOM02DTO searchGoutStockAction(IGLOM02DTO dto) throws BLException {
		GoutstockSearchCond cond = dto.getGoutstockSearchCond();
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = this.goutstockBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<Goutstock> goutstockList = goutstockBL.searchGoutstock(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		List<Goutstock> goutstockListall = goutstockBL.searchGoutstock(cond, 
				0, 0);
		dto.setGoutstockTBList(goutstockList);
		dto.setGoutstockTBListall(goutstockListall);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		return dto;
	}
	
	/**
	 * ���������ѯ��������ļ�¼
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM02DTO searchGoutStockVWForDestroyAction(IGLOM02DTO dto) throws BLException {
		GoutstockVWSearchCond cond = dto.getGoutstockVWSearchCond();
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = this.goutstockVWBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<GoutstockVWInfo> goutstockList = goutstockVWBL.searchGoutstockVW(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		dto.setGoutstockVWList(goutstockList);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		return dto;
	}
	
	/**
	 * ��������ͨ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	protected IGLOM02DTO approveDestroyAction(IGLOM02DTO dto) throws BLException {
		IGLOM0212Form iglom0212Form = dto.getIglom0212Form();
		Integer[] selectids = iglom0212Form.getSelectids();
		for (int i = 0; i < selectids.length; i++) {

			Goutstock goutstock = goutstockBL.searchGoutstockByKey(selectids[i]);
			String gscategory = goutstock.getGocategory();
			String gscode = goutstock.getGocode();
			String org = goutstock.getGoorg();
			String reqnum = goutstock.getGoreqnum();
			
			GinoutstockdetailSearchCondImpl gIOStockCond = new GinoutstockdetailSearchCondImpl();
			gIOStockCond.setGiodcategory(gscategory);
			gIOStockCond.setGiodcode(gscode);
			gIOStockCond.setGiodorg(org);
			gIOStockCond.setGiodreqnum(reqnum);
			gIOStockCond.setGiodtype(IGLOMCONSTANTS.GIODTYPE_RK);
			List<Ginoutstockdetail> gIOStockList = ginoutstockdetailBL.searchGinoutstockdetail(gIOStockCond, 0, 0);
			Ginoutstockdetail gIOStock = gIOStockList.get(0);
			GinoutstockdetailTB gIOStockTB = (GinoutstockdetailTB)SerializationUtils.clone(gIOStock);
			gIOStockTB.setGiodhavocnum(gIOStockTB.getGiodhavocnum()+goutstock.getGochknum());//�����������
			Integer giodoutnum = gIOStockTB.getGiodoutnum() == null ? 0 : gIOStockTB.getGiodoutnum();
			//�ж��ѳ�������+�Ѻ�������+���κ�����������+�ѵ��������Ƿ�����������
			if(giodoutnum + gIOStockTB.getGiodhavocnum() + gIOStockTB.getGiodreliefnum() > gIOStockTB.getGiodinnum()){
				throw new BLException("IGLOM0200.E001", "�����������ܴ��ڿ��ÿ������");
			}
			
			ginoutstockdetailBL.registGinoutstockdetail(gIOStockTB);
			
			GoutstockTB goutstockTB = (GoutstockTB)SerializationUtils.clone(goutstock);
			goutstockTB.setGostatus(IGLOMCONSTANTS.GIODSTATUS_CKWC);
			goutstockTB.setGochkid(dto.getUser().getUserid());
			goutstockTB.setGochkkname(dto.getUser().getUsername());
			goutstockTB.setGoinnum(goutstock.getGochknum());
			goutstockTB.setGotime(LOMHelper.getCurrentTime());
			goutstockTB.setGooutprice(gIOStockTB.getGiodinprice());
			Goutstock retGoutStock = goutstockBL.registGoutstock(goutstockTB);
			
			//����������ϸ
			GinoutstockdetailTB gIOStockDetailTB = new GinoutstockdetailTB();
			gIOStockDetailTB.setGiodtype(IGLOMCONSTANTS.GIODTYPE_HX);//��������
			gIOStockDetailTB.setGiodcategory(gscategory);
			gIOStockDetailTB.setGiodcode(gscode);
			gIOStockDetailTB.setGiodorg(org);
			gIOStockDetailTB.setGiodreqnum(reqnum);
			gIOStockDetailTB.setGiodinnum(retGoutStock.getGochknum());
			gIOStockDetailTB.setGiodunit(retGoutStock.getGounit());
			gIOStockDetailTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_CKWC);//����״̬
			gIOStockDetailTB.setGiodchkid(dto.getUser().getUserid());
			gIOStockDetailTB.setGiodchkkname(dto.getUser().getUsername());
			gIOStockDetailTB.setGiodtime(LOMHelper.getCurrentTime());
			gIOStockDetailTB.setGoid(retGoutStock.getGoid());
			gIOStockDetailTB.setGioid(gIOStockTB.getGiodid());
			gIOStockDetailTB.setGiodname(goutstock.getGoname());
			ginoutstockdetailBL.registGinoutstockdetail(gIOStockDetailTB);
			
			GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
			gStockCond.setGscategory(gscategory);
			gStockCond.setGscode(gscode);
			gStockCond.setGsorg(org);
			Gstock gStock = gstockBL.searchGstock(gStockCond, 0, 0).get(0);
			GstockTB gStockTB = (GstockTB)SerializationUtils.clone(gStock);
			gStockTB.setGsfreezenum(gStockTB.getGsfreezenum() - goutstock.getGochknum());
			gstockBL.registGstock(gStockTB);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒ��������"));	
		return dto;
	}
	
	/**
	 * ����������ͨ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	protected IGLOM02DTO noApproveDestroyAction(IGLOM02DTO dto) throws BLException {
		IGLOM0212Form iglom0212Form = dto.getIglom0212Form();
		Integer[] selectids = iglom0212Form.getSelectids();
		for (int i = 0; i < selectids.length; i++) {
			Goutstock goutstock = goutstockBL.searchGoutstockByKey(selectids[i]);
			String gscategory = goutstock.getGocategory();
			String gscode = goutstock.getGocode();
			String org = goutstock.getGoorg();
			GoutstockTB goutstockTB = (GoutstockTB)SerializationUtils.clone(goutstock);
			goutstockTB.setGostatus(IGLOMCONSTANTS.GIODSTATUS_SPWTG);
			goutstockTB.setGochkid(dto.getUser().getUserid());
			goutstockTB.setGochkkname(dto.getUser().getUsername());
			goutstockTB.setGoinnum(0);
			goutstockTB.setGotime(LOMHelper.getCurrentTime());
			goutstockBL.registGoutstock(goutstockTB);
			GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
			gStockCond.setGscategory(gscategory);
			gStockCond.setGscode(gscode);
			gStockCond.setGsorg(org);
			Gstock gStock = gstockBL.searchGstock(gStockCond, 0, 0).get(0);
			GstockTB gStockTB = (GstockTB)SerializationUtils.clone(gStock);
			gStockTB.setGsfreezenum(gStock.getGsfreezenum() - goutstock.getGochknum());
			gStockTB.setGsnum(gStock.getGsnum() + goutstock.getGochknum());
			gstockBL.registGstock(gStockTB);
		}
		dto.addMessage(new ActionMessage("IGLOM0202.I001", "��Ʒ��������"));	
		return dto;
	}
	

	public IGLOM02DTO searchGIOStockDetailAction(IGLOM02DTO dto) throws BLException {
		GinoutstockdetailSearchCond cond = dto.getGIOStockDetailCond();
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = this.ginoutstockdetailBL.searchGinoutstockdetail(cond, 
				0, 0, "").size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<GinoutStockDetailVW> gIOStockDetailList = ginoutstockdetailBL.searchGinoutstockdetail(cond, 
				pDto.getFromCount(), pDto.getPageDispCount(), "");
		for(int i=0; i<gIOStockDetailList.size(); i++){
			GinoutStockDetailVW gs = gIOStockDetailList.get(i);
			int giodhavocnum = 0;
			int giodreliefnum = 0;
			int giodoutnum = 0;
			if(gs.getGiodhavocnum()!=null){
				giodhavocnum = Integer.parseInt(gs.getGiodhavocnum().toString());
			}
			if(gs.getGiodreliefnum()!=null){
				giodreliefnum = Integer.parseInt(gs.getGiodreliefnum());
			}
			if(gs.getGiodoutnum()!=null){
				giodoutnum = gs.getGiodoutnum();
			}
			int out = giodhavocnum + giodreliefnum +giodoutnum;
			if(gs.getGiodinnum().intValue() == out){
				totalCount--;
			}
		}
		dto.setGinoutStockDetailVWList(gIOStockDetailList);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		return dto;
	}

	public IGLOM02DTO searchIODetailAction(IGLOM02DTO dto) throws BLException {
		String category = dto.getIglom0215Form().getCategory();
		GinoutstockdetailSearchCondImpl giodetailCond = new GinoutstockdetailSearchCondImpl();
		giodetailCond.setGiodcategory(category);
		giodetailCond.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
		giodetailCond.setGiodtype(CodeUtils.GIODTYPE_INSTOCK);
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = this.ginoutstockdetailBL.searchGinoutstockdetail(giodetailCond, 
				0, 0, "").size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if (totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<GinoutStockDetailVW> gIOStockDetailList = ginoutstockdetailBL.searchGinoutstockdetail(giodetailCond, 
				pDto.getFromCount(), pDto.getPageDispCount(), "");
		
		dto.setGinoutStockDetailVWList(gIOStockDetailList);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		return dto;
	}

	public IGLOM02DTO searchGoodsIODetailAction(IGLOM02DTO dto) throws BLException {
		IGLOM0216Form iglom0216Form = dto.getIglom0216Form();
//		iglom0216Form.setGiodorg(dto.getUser().getOrgid());
		List<Ginoutstockdetail> gIOStockDetailList = ginoutstockdetailBL.searchGinoutstockdetail(iglom0216Form, 0, 0);
		
		Integer stockNum = 0;
		Integer[] totalStockNum = new Integer[gIOStockDetailList.size()];
		String gname = null;
		for (int i = 0; i < gIOStockDetailList.size(); i++) {
			Ginoutstockdetail gIOStock = gIOStockDetailList.get(i);
			if(gIOStock.getGiodtype().equals(CodeUtils.GIODTYPE_INSTOCK)){
				stockNum = gIOStock.getGiodinnum();
				gname = gIOStock.getGiodname();
				totalStockNum[i] = stockNum;
			} else {
				totalStockNum[i] = totalStockNum[i - 1] - gIOStock.getGiodinnum();
			}
		}
		dto.setGname(gname);
		dto.setTotalStockNum(totalStockNum);
		dto.setGIOStockDetailList(gIOStockDetailList);
		return dto;
	}
	
	public IGLOM02DTO searchGoodsIODetail0218Action(IGLOM02DTO dto) throws BLException {
		IGLOM0218Form iglom0218Form = dto.getIglom0218Form();
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = ginoutstockdetailBL.searchGinoutstockdetail(iglom0218Form, 
				0, 0).size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<Ginoutstockdetail> gIOStockDetailList = ginoutstockdetailBL.searchGinoutstockdetail(iglom0218Form, 
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setGIOStockDetailList(gIOStockDetailList);
		return dto;
	}
	
	/*********************************************���Ԥ��********************************************************************/
	
	/**
	 * ���Ԥ����ѯACTION
	 */
	public IGLOM02DTO searchGstockWarningAction(IGLOM02DTO dto) throws BLException {
		IGLOM0213Form form = dto.getIglom0213Form();
		String warntype = form.getWarntype();//��ѯ���ͣ���Ԥ����ѯ���ٽ�Ԥ����ѯ��
		Integer num = form.getWarnnum();//�ٽ�����
		GstockVWSearchCondImpl cond = new GstockVWSearchCondImpl();
		cond.setWarntype(warntype);
		if(IGLOMCONSTANTS.WARN_TYPE_LJYJ.equals(warntype)){
			cond.setWarnnum(num);
		}
		cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������

		List<GstockVWInfo> gstockList = gstockVWBL.searchGstockVW(cond, 0, 0);
		int totalCount = gstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		gstockList = gstockVWBL.searchGstockVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setGstockVWList(gstockList);
		
		return dto;
	}
	
	/*********************************************���ͳ��********************************************************************/
	
	/**
	 * ���ͳ�Ʋ�ѯACTION
	 */
	public IGLOM02DTO searchGstockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0214Form form = dto.getIglom0214Form();
		String gscategory = form.getGscategory();
		GstockSearchCondImpl cond = new GstockSearchCondImpl();
		cond.setGscategory(gscategory);//��Ʒ����
		cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������

		List<Gstock> gstockList = gstockBL.searchGstock(cond, 0, 0);
		int totalCount = gstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		gstockList = gstockBL.searchGstock(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setGstockList(gstockList);
		
		return dto;
	}
	
	/**
	 * ���ͳ�Ƶ���ACTION
	 */
	public IGLOM02DTO searchGstockForExcelAction(IGLOM02DTO dto) throws BLException {
		IGLOM0214Form form = dto.getIglom0214Form();
		String gscategory = form.getGscategory();
		GstockSearchCondImpl cond = new GstockSearchCondImpl();
		cond.setGscategory(gscategory);//��Ʒ����
		cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������

		List<Gstock> gstockList = gstockBL.searchGstock(cond, 0, 0);
		int totalCount = gstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		gstockList = gstockBL.searchGstock(cond, 0, 0);
		pDto.setTotalCount(totalCount);
		dto.setGstockList(gstockList);
		
		return dto;
	}
	
	/*********************************************��Ʒ����********************************************************************/
	
	/**
	 * ��ѯ��ָ���Ӵ������¼��ص�������Ʒ��ϢACTION
	 */
	public IGLOM02DTO searchGoodsForRecptionAction(IGLOM02DTO dto) throws BLException {
		IGLOM0203Form form = dto.getIglom0203Form();
		Integer rid = form.getRid();//�Ӵ���������ID
		//String name = form.getGsname();//��Ʒ����
		GoutstockSearchCondImpl cond = new GoutstockSearchCondImpl();
		cond.setRid(rid);
		cond.setHascategory(form.isHascategory());//�Ƿ�����Ʒcode
		List<Goutstock> goutstockList = goutstockBL.searchGoutstock(cond, 0, 0);
		int totalCount = goutstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		goutstockList = goutstockBL.searchGoutstock(cond, 0, 0);
		
		List<Goutstock> list = new ArrayList<Goutstock>();
		boolean flag = true;
		int num = 0;
		BigDecimal totalprice = new BigDecimal(0);
		BigDecimal gooutprice = new BigDecimal(0);
		for(Goutstock gs:goutstockList){
			flag = true;
			num = 0;
			String category = gs.getGocategory();//��Ʒ����
			String gocode = gs.getGocode();//��Ʒ���

			for(Goutstock os:goutstockList){
				if(category.equals(os.getGocategory()) && gocode.equals(os.getGocode())){
					num+=os.getGoinnum();
					totalprice = totalprice.add(LOMHelper.getMultiply(new BigDecimal(os.getGoinnum()), os.getGooutprice()));
					
				}
			}
			GoutstockTB gtb = (GoutstockTB)SerializationUtils.clone(gs);
			gtb.setGoinnum(num);
			Double pr = LOMHelper.round(String.valueOf(totalprice),2);
			totalprice = new BigDecimal(String.valueOf(pr));
			gtb.setGooutprice(totalprice);
			for(Goutstock os:list){
				if(category.equals(os.getGocategory()) && gocode.equals(os.getGocode())){
					flag = false;
					break;
				}
			}
			if(flag){
				list.add(gtb);
			}
			
		}

		pDto.setTotalCount(totalCount);
		dto.setGoutstockTBList(list);

		return dto;
	}
	
	
	
	
	
	/**
	 * ʳ������ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForSTAction(IGLOM02DTO dto) throws BLException {
		IGLOM0512Form form = dto.getIglom0512Form();
		String category = form.getGscategory();//��Ʒ����
		String name = form.getGsname();//��Ʒ����
		GstockSearchCondImpl cond = new GstockSearchCondImpl();
		cond.setGscategory(category);
		cond.setGsname(name);
		cond.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);//��������Ϊʳ��
		List<Gstock> goutstockList = gstockBL.searchGstock(cond, 0, 0);
		int totalCount = goutstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		goutstockList = gstockBL.searchGstock(cond, 0, 0);
		pDto.setTotalCount(totalCount);
		dto.setGstockList(goutstockList);
		
		return dto;
	}
	
	
	/**
	 * ��Ʒ����ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForApplyAction(IGLOM02DTO dto) throws BLException {
		IGLOM0203Form form = dto.getIglom0203Form();
		String category = form.getGscategory();//��Ʒ����
		if(IGLOMCONSTANTS.ST_ORGSYSCODING.equals(form.getGoorg())){
			category = IGLOMCONSTANTS.ST_SEARCH_TYPE;
		}
		String name = form.getGsname();//��Ʒ����
		GstockSearchCondImpl cond = new GstockSearchCondImpl();
		cond.setGscategory(category);
		cond.setGsname(name);
		cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������
		List<Gstock> goutstockList = gstockBL.searchGstock(cond, 0, 0);
		int totalCount = goutstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		goutstockList = gstockBL.searchGstock(cond, 0, 0);
		pDto.setTotalCount(totalCount);
		dto.setGstockList(goutstockList);
		
//		String category = form.getGiodcategory();//��Ʒ����
//		//String code = form.getGiodcode();//��Ʒ���
//		String name = form.getGiodname();//��Ʒ����
//		String giodreqnum = form.getGiodreqnum();//�ɹ����뵥���
//		GoutstockVWSearchCondImpl cond = new GoutstockVWSearchCondImpl();
//		cond.setGiodcategory(category);
//		cond.setGiodname(name);
//		cond.setGiodreqnum(giodreqnum);
//		cond.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������
//		//cond.setGsstatus(IGLOMCONSTANTS.GOODS_STATUS_ENABLE);//��״̬Ϊ���õļ�¼
//		List<GoutstockVWInfo> goutstockList = goutstockVWBL.searchGoutstockVW(cond, 0, 0);
//		int totalCount = goutstockList.size();
//		if (totalCount == 0) {
//			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
//			return dto;
//		}
//		if (totalCount > dto.getMaxSearchCount() ) {
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//		//��ȡ��ҳbean
//		PagingDTO pDto = dto.getPagingDto();
//		//����DAO�ӿڲ�ѯ
//		goutstockList = goutstockVWBL.searchGoutstockVW(cond, 0, 0);
//		pDto.setTotalCount(totalCount);
//		dto.setGoutstockList(goutstockList);
//		
		return dto;
	}
	
	/**
	 * ����ҳ���ѯACTION
	 */
	public IGLOM02DTO searchGoodsForEditAction(IGLOM02DTO dto) throws BLException {
		IGLOM0208Form form = dto.getIglom0208Form();
		String category = form.getGscategory();//��Ʒ����
		//String code = form.getGiodcode();//��Ʒ���
		String name = form.getGsname();//��Ʒ����
		//String giodreqnum = form.getGiodreqnum();//�ɹ����뵥���
		GstockSearchCondImpl cond = new GstockSearchCondImpl();
		cond.setGscategory(category);
		cond.setGsname(name);
		cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������
		//cond.setGsstatus(IGLOMCONSTANTS.GOODS_STATUS_ENABLE);//��״̬Ϊ���õļ�¼
		List<Gstock> goutstockList = gstockBL.searchGstock(cond, 0, 0);
		int totalCount = goutstockList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		goutstockList = gstockBL.searchGstock(cond, 0, 0);
		pDto.setTotalCount(totalCount);
		dto.setGstockList(goutstockList);
		
		return dto;
	}
	
	/**
	 * ������ϸ��¼�趨
	 */
	private GinoutstockdetailTB insertGOutStockDetailAction(Goutstock goutstock,Integer giodid,Integer innum,String reqnum,Integer gsnum) throws BLException{
		GinoutstockdetailTB gsdTB = new GinoutstockdetailTB();
		gsdTB.setGiodcategory(goutstock.getGocategory());
		gsdTB.setGiodcode(goutstock.getGocode());
		gsdTB.setGiodname(goutstock.getGoname());
		gsdTB.setGiodtime(goutstock.getGotime());//����ʱ��
		gsdTB.setGiodinnum(innum);//��������
		gsdTB.setGiodorg(goutstock.getGoorg());
		gsdTB.setGiodreqnum(goutstock.getGoreqnum());//�ɹ����뵥����
		gsdTB.setGiodtype(goutstock.getGotype());//��������
		gsdTB.setGiodstatus(goutstock.getGostatus());//����״̬
		gsdTB.setGiodreqorg(goutstock.getGoreqorg());//���û���
		gsdTB.setGiodrequsername(goutstock.getGorequsername());//����������
		gsdTB.setGioduser(goutstock.getGouser());//�Ǽ���ID
		gsdTB.setGiodusername(goutstock.getGousername());//�Ǽ�������
		gsdTB.setGioid(giodid);
		gsdTB.setGsnum(gsnum);//ʵʱ�����
		gsdTB.setGiodreqnum(reqnum);//�ɹ����뵥����
		gsdTB.setGiodoutnum(innum);//��������
		
		return gsdTB;
	}
	
	/**
	 * ����������ϸ��¼
	 */
	private void insertGOutStockDetailAction(Goutstock goutstock,Integer giodid,Integer goid,String giodreqnum,Integer innum,String reqnum,Integer gsnum) throws BLException{
		GinoutstockdetailTB gsdTB = new GinoutstockdetailTB();
		gsdTB.setGiodcategory(goutstock.getGocategory());
		gsdTB.setGiodcode(goutstock.getGocode());
		gsdTB.setGiodname(goutstock.getGoname());
		gsdTB.setGiodtime(goutstock.getGotime());//����ʱ��
		gsdTB.setGiodinnum(innum);//��������
		gsdTB.setGiodorg(goutstock.getGoorg());
		gsdTB.setGiodreqnum(giodreqnum);//�ɹ����뵥����
		gsdTB.setGiodtype(goutstock.getGotype());//��������
		gsdTB.setGiodstatus(goutstock.getGostatus());//����״̬
		gsdTB.setGiodreqorg(goutstock.getGoreqorg());//���û���
		gsdTB.setGiodrequsername(goutstock.getGorequsername());//����������
		gsdTB.setGioduser(goutstock.getGouser());//�Ǽ���ID
		gsdTB.setGiodusername(goutstock.getGousername());//�Ǽ�������
		gsdTB.setGioid(giodid);
		gsdTB.setGoid(goid);
		gsdTB.setGsnum(gsnum);//ʵʱ�����
		gsdTB.setGiodreqnum(reqnum);//�ɹ����뵥����
		gsdTB.setGiodoutnum(innum);//��������

		ginoutstockdetailBL.registGinoutstockdetail(gsdTB);

	}
	
	/**
	 * ���������ϸ��¼
	 */
	private void updateGinoutStockDetailAction(Integer outnum,String type,String status,Ginoutstockdetail oldinstock,Integer gsnum) throws BLException{
		GinoutstockdetailTB gsdTB = (GinoutstockdetailTB)SerializationUtils.clone(oldinstock);
		
		if(IGLOMCONSTANTS.GIODTYPE_LY.equals(type)){
			//����ʱ
			gsdTB.setGiodoutnum(outnum);//��������
		}else if(IGLOMCONSTANTS.GIODTYPE_TJ.equals(type)){
			//����ʱ
			gsdTB.setGiodreliefnum(outnum);//��������
		}
		gsdTB.setGiodstatus(status);//���״̬(0:����� 1:�����)
		//gsdTB.setGsnum(gsnum);//ʵʱ�����
		ginoutstockdetailBL.updateGinoutstockdetail(gsdTB);
	}
	
	/**
	 * ���¿���¼
	 */
	private Gstock updateGstockAction(Integer num,Gstock oldstock,User user) throws BLException{
		GstockTB gstockTB = (GstockTB)SerializationUtils.clone(oldstock);
		gstockTB.setGsnum(num);
		gstockTB.setGsuserid(user.getUserid());
		gstockTB.setGsusername(user.getUsername());
		gstockTB.setGsdate(IGStringUtils.getCurrentDateTime());
		Gstock gs = gstockBL.updateGstock(gstockTB);
		return gs;
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
	 * У��������������ʳ������������Ƿ񳬹��������
	 */
	@SuppressWarnings("unchecked")
	private boolean checkOutNum(IGLOM0203Form form) throws BLException{
		boolean flag = false;

		String[] categorys = form.getGcategorys();//��Ʒ����
		String[] seqcodes = form.getGcodes();//��Ʒ���
		Integer[] outnums = form.getGoinnums();//��������
		ArrayList totaltype = new ArrayList();//���ڼ�����Ʒ(��ʽ��categorys;codes)
		ArrayList totalnum = new ArrayList();//ÿ����Ʒ�ĳ���������
		GstockSearchCondImpl cond = new GstockSearchCondImpl();

		if(categorys!=null){
			//ȡ�ù��м�����Ʒ
			for(int i = 0,j = categorys.length;i<j;i++){
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
				for(int x = 0,y = categorys.length;x<y;x++){
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
			
			//У����������Ƿ񳬹��������
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];//��Ʒ����
				String seqcode = totaltype.get(i).toString().split(";")[1];//��Ʒ���
				//��ѯָ�����ͱ�ŵ���Ʒ
				cond.setGscategory(category);
				cond.setGscode(seqcode);
				cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//Ĭ�϶�������
				List<Gstock> stockList = gstockBL.searchGstock(cond, 0, 0);
				
				Gstock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//���������ĺ�
				if(num>stock.getGsnum()){
					flag = true;
					String goorg = form.getGoorg();//���û���
					if(IGLOMCONSTANTS.ST_ORGSYSCODING.equals(goorg)){
						throw new BLException("IGLOM0205.E004",seqcode,stock.getGsname());//ʳ�����
					}else{
						throw new BLException("IGLOM0205.E003",seqcode,stock.getGsname());//��Ʒ����
					}
					
				}
			}
		}
		return flag;
	}
	
	/**
	 * У��ʳ�ó��������Ƿ񳬹��������
	 */
	@SuppressWarnings("unchecked")
	private boolean checkOutNumForST(IGLOM0512Form form) throws BLException{
		boolean flag = false;

		String[] categorys = form.getGcategorys();//��Ʒ����
		String[] seqcodes = form.getGcodes();//��Ʒ���
		Integer[] outnums = form.getGoinnums();//��������
		ArrayList totaltype = new ArrayList();//���ڼ�����Ʒ(��ʽ��categorys;codes)
		ArrayList totalnum = new ArrayList();//ÿ����Ʒ�ĳ���������
		GstockSearchCondImpl cond = new GstockSearchCondImpl();

		if(categorys!=null){
			//ȡ�ù��м�����Ʒ
			for(int i = 0,j = categorys.length;i<j;i++){
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
				for(int x = 0,y = categorys.length;x<y;x++){
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
			
			//У����������Ƿ񳬹��������
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//��ѯָ�����ͱ�ŵ���Ʒ
				cond.setGscategory(category);
				cond.setGscode(seqcode);
				cond.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);//Ĭ��ʳ�û��������
				List<Gstock> stockList = gstockBL.searchGstock(cond, 0, 0);
				
				Gstock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//���������ĺ�
				if(num>stock.getGsnum()){
					flag = true;
					throw new BLException("IGLOM0512.E001",seqcode,stock.getGsname());
				}
			}
		}
		return flag;
	}
	
	/**
	 * У����������Ƿ񳬹��������
	 */
	@SuppressWarnings("unchecked")
	private boolean checkOutNumForEdit(IGLOM0208Form form) throws BLException{
		boolean flag = false;

		String[] categorys = form.getGcategorys();//��Ʒ����
		String[] seqcodes = form.getGcodes();//��Ʒ���
		Integer[] outnums = form.getGoinnums();//��������
		ArrayList totaltype = new ArrayList();//���ڼ�����Ʒ(��ʽ��categorys;codes)
		ArrayList totalnum = new ArrayList();//ÿ����Ʒ�ĳ���������
		GstockSearchCondImpl cond = new GstockSearchCondImpl();

		if(categorys!=null){
			//ȡ�ù��м�����Ʒ
			for(int i = 0,j = categorys.length;i<j;i++){
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
				for(int x = 0,y = categorys.length;x<y;x++){
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
			
			//У����������Ƿ񳬹��������
			for(int i = 0,j = totaltype.size();i<j;i++){
				String category = totaltype.get(i).toString().split(";")[0];
				String seqcode = totaltype.get(i).toString().split(";")[1];
				//��ѯָ�����ͱ�ŵ���Ʒ
				cond.setGscategory(category);
				cond.setGscode(seqcode);
				cond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//Ĭ�϶�������
				List<Gstock> stockList = gstockBL.searchGstock(cond, 0, 0);
				
				Gstock stock = stockList.get(0);
				Integer num = Integer.valueOf(totalnum.get(i).toString());//���������ĺ�
				if(num>stock.getGsnum()){
					flag = true;
					throw new BLException("IGLOM0208.E003",seqcode,stock.getGsname());
				}
			}
		}
		return flag;
	}
	
	/**
	 * ʳ�������ϸ��¼�趨
	 */
	private GinoutstockdetailTB setGoutStockDetailForSTAction(Goutstock goutstock,User user) throws BLException{
		//��ѯ�Ѵ��ڵĿ����Ϣ
		GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
		gStockCond.setGscode(goutstock.getGocode());
		gStockCond.setGscategory(goutstock.getGocategory());
		gStockCond.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		List<Gstock> gStockList = gstockBL.searchGstock(gStockCond, 0, 0);
		
		
		GinoutstockdetailTB gsdTB = new GinoutstockdetailTB();
		gsdTB.setGiodcategory(goutstock.getGocategory());
		gsdTB.setGiodcode(goutstock.getGocode());
		gsdTB.setGiodname(goutstock.getGoname());
		gsdTB.setGiodtime(goutstock.getGotime());//����ʱ��
		gsdTB.setGiodtype(CodeUtils.GIODTYPE_INSTOCK);//�������
		gsdTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//���״̬
		gsdTB.setGioduser(user.getUserid());
		gsdTB.setGiodusername(user.getUsername());
		gsdTB.setGiodhavocnum(0);//��������
		gsdTB.setGiodreliefnum(0);//��������
		gsdTB.setGiodoutnum(0);//��������
		gsdTB.setGiodinnum(goutstock.getGoinnum());//�������
		gsdTB.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);//��������Ϊ��ʳ��
		if(gStockList!=null && gStockList.size()>0){
			gsdTB.setGsnum(goutstock.getGoinnum()+gStockList.get(0).getGsnum());//ʵʱ�����
		}else{
			gsdTB.setGsnum(goutstock.getGoinnum());
		}
		
		return gsdTB;
	}
	
	
	/**
	 * ����ʳ�ÿ���¼
	 */
	private void insertGStockForSTAction(Ginoutstockdetail ginoutstockdetail,User user) throws BLException{
		GstockSearchCondImpl gStockCond = new GstockSearchCondImpl();
		gStockCond.setGscode(ginoutstockdetail.getGiodcode());
		gStockCond.setGscategory(ginoutstockdetail.getGiodcategory());
		gStockCond.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		List<Gstock> gStockList = gstockBL.searchGstock(gStockCond, 0, 0);
		
		GstockTB gStockTB = new GstockTB();
		if(gStockList.size() == 0){			
			gStockTB.setGscategory(ginoutstockdetail.getGiodcategory());
			gStockTB.setGsname(ginoutstockdetail.getGiodname());
			gStockTB.setGscode(ginoutstockdetail.getGiodcode());
			gStockTB.setGsnum(ginoutstockdetail.getGiodinnum());
			gStockTB.setGsavgprice(ginoutstockdetail.getGiodinprice());
			gStockTB.setGsfreezenum(0);
			gStockTB.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		} else {
			gStockTB = (GstockTB)SerializationUtils.clone(gStockList.get(0));
			Integer sumNum = gStockTB.getGsnum() + ginoutstockdetail.getGiodinnum();
			BigDecimal allPrice = LOMHelper.getAdd(
				String.valueOf(LOMHelper.getMultiply(String.valueOf(gStockTB.getGsnum()), String.valueOf(gStockTB.getGsavgprice()))),
				String.valueOf(LOMHelper.getMultiply(String.valueOf(ginoutstockdetail.getGiodinnum()), String.valueOf(ginoutstockdetail.getGiodinprice())))
			);
			BigDecimal avgprice = LOMHelper.getDivide(String.valueOf(allPrice), String.valueOf(sumNum));
			gStockTB.setGsavgprice(avgprice);
			gStockTB.setGsnum(sumNum);
		}
		gStockTB.setGsuserid(user.getUserid());
		gStockTB.setGsusername(user.getUsername());
		gStockTB.setGsdate(ginoutstockdetail.getGiodtime());
		gstockBL.registGstock(gStockTB);

	}
	
	/**
	 * ��Ʒ����
	 */
	public IGLOM02DTO insertGoutStockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0203Form form = dto.getIglom0203Form();
		User user = dto.getUser();
		String[] gcategorys = form.getGcategorys();//��Ʒ����
		String[] gnames = form.getGnames();//��Ʒ����
		String[] gcodes = form.getGcodes();//��Ʒ���
		Integer[] goinnums = form.getGoinnums();//��������
		String[] goreasons = form.getGoreasons();//˵��
		String goorg = form.getGoorg();//���û���
		String gorequsername = form.getGorequsername();//������
		String goreqnum = form.getGoreqnum();//�ɹ����뵥���
		Integer rid = form.getRid();//�Ӵ�����ID
		
		boolean flag = false;
		if(IGLOMCONSTANTS.ST_ORGSYSCODING.equals(goorg)){
			flag = true;
		}
		
		Double out_price = 0d;//���ⵥ��
		Double out_amount = 0d;//������
		Double out_price_part = 0d;//�����ϸ��ÿ����浥��*��������������Ȼ��������������¼���ܵ�ֵ
		int out_num_part = 0;//��������С��
		boolean falg = false;//�Ƿ��������������
		List<Integer> instockidlist =  new ArrayList<Integer>();
		List<Integer> instockOutnumlist = new ArrayList<Integer>();
		int per_outnum = 0;//ÿ����¼��Ҫ�Ŀ������
		if(!checkOutNum(form)){
			if(gcategorys!=null){
				for(int i = 0,j = gcategorys.length;i<j;i++){
					if(goinnums[i]!=null && goinnums[i]!=0){
						List<GinoutstockdetailTB> inoutStocklist =  new ArrayList<GinoutstockdetailTB>();
						List<GinoutstockdetailTB> inoutStockForSTlist =  new ArrayList<GinoutstockdetailTB>();
						
						GoutstockTB goutstock = new GoutstockTB();
						//������Ʒ��Ϣ
						goutstock.setGocategory(gcategorys[i]);
						goutstock.setGoname(gnames[i]);
						goutstock.setGocode(gcodes[i]);
						goutstock.setGoinnum(goinnums[i]);
						goutstock.setGoreason(goreasons[i]);
						
						//�������õ������Ϣ
						goutstock.setGotype(IGLOMCONSTANTS.GOTYPE_LY);//��������Ϊ����
						goutstock.setGoorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������
						goutstock.setGotime(IGStringUtils.getCurrentDateTime());//����ʱ��
						goutstock.setGoreqnum(goreqnum);//�ɹ����뵥���
						goutstock.setGoinnum(goinnums[i]);//��������
						goutstock.setGostatus(IGLOMCONSTANTS.GOSTATUS_CKWC);//����״̬Ϊ�������
						goutstock.setGoreqorg(goorg);//���û���
						goutstock.setGorequsername(gorequsername);//����������
						goutstock.setGouser(user.getUserid());//�Ǽ���ID
						goutstock.setGousername(user.getUsername());//�Ǽ�������
						goutstock.setRid(rid);//�Ӵ�����ID
						
						//��ѯ�����Ϣ��
						GstockSearchCondImpl stockcond = new GstockSearchCondImpl();
						stockcond.setGscategory(gcategorys[i]);
						stockcond.setGscode(gcodes[i]);
						stockcond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
						List<Gstock> oldStockList = gstockBL.searchGstock(stockcond, 0, 0);
						Gstock oldStock;
						if(oldStockList!=null && oldStockList.size()==1){
							oldStock = oldStockList.get(0);
						}else{
							throw new BLException("IGLOM0205.E001");//�����Ϣ������
						}
						 
									
						//��ѯ�����ϸ��
						GinoutstockdetailSearchCondImpl cond = new GinoutstockdetailSearchCondImpl();
						cond.setGiodcategory(gcategorys[i]);
						cond.setGiodcode(gcodes[i]);
						cond.setGiodtype(IGLOMCONSTANTS.GIODTYPE_RK);//����Ϊ���
						cond.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//״̬Ϊ �����
						cond.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
						
						//������Ʒ�ļ���
						List<Ginoutstockdetail> oldInStock = ginoutstockdetailBL.searchGinoutstockdetail(cond, 0, 0);
						
						if(oldInStock==null || oldInStock.size()==0){
							throw new BLException("IGLOM0205.E002");//��Ʒ�����Ϣ������
						}
						
						//������¼��Ҫ�Ŀ������
						per_outnum = goinnums[i];
			
						//����������ȳ����ԭ�����μ��ٿ����,ֱ�������������Ϊֹ	
						for(int x = 0 , y = oldInStock.size();x<y;x++){
							Ginoutstockdetail outinstock =  oldInStock.get(x);
							per_outnum = goinnums[i] - out_num_part;//ȡ�û�����������������Ҫ��
							int true_instocknum = outinstock.getGiodinnum()-outinstock.getGiodoutnum()-outinstock.getGiodreliefnum()-outinstock.getGiodhavocnum();//ÿ������ʵ�ʿ����
							if(true_instocknum>per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(out_price_part, LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue());
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����GSTOCK���б��·�����Ʒ��¼��GSNUM����ʽΪ��GSNUM = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ��¼
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
										

										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
									}
								}else{
									

									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));//���ⵥ��
										//goutstock.setOutamount(out_amount);
									}
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);
									
									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodoutnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_LY,IGLOMCONSTANTS.GIODSTATUS_KCY,outinstock,(gs.getGsnum()));
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));
									
									//ʳ������ʱҪ����ʳ������¼
									if(flag){
										//����ʳ�������ϸ��¼
										GinoutstockdetailTB gstb = setGoutStockDetailForSTAction(goutstock,user);
										gstb.setGoid(goutstock1.getGoid());
										gstb.setGiodinprice(goutstock1.getGooutprice());//��ⵥ��
										Ginoutstockdetail giosd = ginoutstockdetailBL.registGinoutstockdetail(gstb);
										
										//��������¼
										insertGStockForSTAction(giosd,user);
									}

									break;
								}
							}else if(true_instocknum==per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
											
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
									}
								}else{
									
									
									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
										//outstock.setOutamount(out_amount);
									}
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);
									
									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodoutnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_LY,IGLOMCONSTANTS.GIODSTATUS_KCW,outinstock,(gs.getGsnum()));				
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));
									
									//ʳ������ʱҪ����ʳ������¼
									if(flag){
										//����ʳ�������ϸ��¼
										GinoutstockdetailTB gstb = setGoutStockDetailForSTAction(goutstock,user);
										gstb.setGoid(goutstock1.getGoid());
										gstb.setGiodinprice(goutstock1.getGooutprice());//��ⵥ��
										Ginoutstockdetail giosd = ginoutstockdetailBL.registGinoutstockdetail(gstb);
										
										//��������¼
										insertGStockForSTAction(giosd,user);
									}
									
									break;
								}
								
							}else{
								//�жϵ�ǰ������С���Ƿ��������������								
								if((out_num_part+true_instocknum)>=goinnums[i]){//����
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
									}
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add((goinnums[i]-out_num_part));
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
									falg = true;
									break;
								}else{
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
									}
									out_num_part+=true_instocknum;
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add(true_instocknum);
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
								}
							}
						}
						if(falg){
							//��ѯ�����Ϣ��
							GstockSearchCondImpl stockcond1 = new GstockSearchCondImpl();
							stockcond1.setGscategory(gcategorys[i]);
							stockcond1.setGscode(gcodes[i]);
							stockcond1.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
							List<Gstock> oldStockList1 = gstockBL.searchGstock(stockcond, 0, 0);
							Gstock oldStock1;
							if(oldStockList1!=null && oldStockList1.size()==1){
								oldStock1 = oldStockList1.get(0);
							}else{
								throw new BLException("IGLOM0205.E001");//�����Ϣ������
							}
							
							
							//����GINOUTSTOCKDETAIL���г����漰�ĸ�����¼
							for(int n=0,m=instockidlist.size();n<m;n++){					
								Ginoutstockdetail is = ginoutstockdetailBL.searchGinoutstockdetailByKey(instockidlist.get(n));
								int true_num = is.getGiodinnum()-is.getGiodoutnum()-is.getGiodreliefnum()-is.getGiodhavocnum();//��������ʵ�ʿ����
								GinoutstockdetailTB instockTB = (GinoutstockdetailTB)SerializationUtils.clone(is);

								if(instockOutnumlist.get(n)==true_num){
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCW);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodoutnum()+true_num);//��������������
								}else{
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodoutnum()+instockOutnumlist.get(n));//�����ѳ�������
								}
								instockTB.setGsnum(oldStock1.getGsnum());
								ginoutstockdetailBL.updateGinoutstockdetail(instockTB);
							}
							
							//ʳ������ʱҪ����ʳ������¼
							if(flag){
								//����ʳ������¼
								inoutStockForSTlist.add(setGoutStockDetailForSTAction(goutstock,user));
							}
							
							//������ⵥ�ۼ����������outstock��
							if(out_price_part!=null){
								out_price = LOMHelper.getDivide(String.valueOf(out_price_part), String.valueOf(goinnums[i])).doubleValue();
								out_price = round(out_price,4);
								out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
								out_amount = round(out_amount,4);
								goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
								//outstock.setOutamount(out_amount);
							}
							Goutstock goutstock2 = goutstockBL.registGoutstock(goutstock);
							
							//����������ϸ��¼
							if(inoutStocklist!=null && inoutStocklist.size()>0){
								for(GinoutstockdetailTB gstb:inoutStocklist){
									gstb.setGoid(goutstock2.getGoid());
									ginoutstockdetailBL.registGinoutstockdetail(gstb);
								}
							}
							
							if(flag){
								//����ʳ�������ϸ��¼
								if(inoutStockForSTlist!=null && inoutStockForSTlist.size()>0){
									for(GinoutstockdetailTB gstb:inoutStockForSTlist){
										gstb.setGoid(goutstock2.getGoid());
										gstb.setGiodinprice(goutstock2.getGooutprice());//��ⵥ��
										Ginoutstockdetail giosd = ginoutstockdetailBL.registGinoutstockdetail(gstb);
										
										//��������¼
										insertGStockForSTAction(giosd,user);
									}
								}
							}
							
							
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

			}
		}else{
			//ͬ����Ʒ�ĳ������������������
			dto.setGotoError("CK_NUM_ERROR");
		}
		return dto;
	}
	
	
	
	
	/**
	 * ʳ�ó���
	 */
	public IGLOM02DTO insertGoutStockForSTAction(IGLOM02DTO dto) throws BLException {
		IGLOM0512Form form = dto.getIglom0512Form();
		User user = dto.getUser();
		String[] gcategorys = form.getGcategorys();//��Ʒ����
		String[] gnames = form.getGnames();//��Ʒ����
		String[] gcodes = form.getGcodes();//��Ʒ���
		Integer[] goinnums = form.getGoinnums();//��������
		String goorg = IGLOMCONSTANTS.ST_ORGSYSCODING;//form.getGoorg();//���û���
		String gorequsername = form.getGorequsername();//������
		String goreqnum = form.getGoreqnum();//�ɹ����뵥���
		Integer rid = form.getRid();//�Ӵ�����ID
		
		Double out_price = 0d;//���ⵥ��
		Double out_amount = 0d;//������
		Double out_price_part = 0d;//�����ϸ��ÿ����浥��*��������������Ȼ��������������¼���ܵ�ֵ
		int out_num_part = 0;//��������С��
		boolean falg = false;//�Ƿ��������������
		List<Integer> instockidlist =  new ArrayList<Integer>();
		List<Integer> instockOutnumlist = new ArrayList<Integer>();
		int per_outnum = 0;//ÿ����¼��Ҫ�Ŀ������
		if(!checkOutNumForST(form)){
			if(gcategorys!=null){
				for(int i = 0,j = gcategorys.length;i<j;i++){
					if(goinnums[i]!=null && goinnums[i]!=0){
						List<GinoutstockdetailTB> inoutStocklist =  new ArrayList<GinoutstockdetailTB>();
						
						GoutstockTB goutstock = new GoutstockTB();
						//������Ʒ��Ϣ
						goutstock.setGocategory(gcategorys[i]);
						goutstock.setGoname(gnames[i]);
						goutstock.setGocode(gcodes[i]);
						goutstock.setGoinnum(goinnums[i]);
						
						//�������õ������Ϣ
						goutstock.setGotype(IGLOMCONSTANTS.GOTYPE_LY);//��������Ϊ����
						
						goutstock.setGoorg(IGLOMCONSTANTS.ST_ORGSYSCODING);//��������Ϊʳ��
						
						goutstock.setGotime(IGStringUtils.getCurrentDateTime());//����ʱ��
						goutstock.setGoreqnum(goreqnum);//�ɹ����뵥���
						goutstock.setGoinnum(goinnums[i]);//��������
						goutstock.setGostatus(IGLOMCONSTANTS.GOSTATUS_CKWC);//����״̬Ϊ�������
						goutstock.setGoreqorg(goorg);//���û���
						goutstock.setGorequsername(gorequsername);//����������
						goutstock.setGouser(user.getUserid());//�Ǽ���ID
						goutstock.setGousername(user.getUsername());//�Ǽ�������
						goutstock.setRid(rid);//�Ӵ�����ID
						
						//��ѯ�����Ϣ��
						GstockSearchCondImpl stockcond = new GstockSearchCondImpl();
						stockcond.setGscategory(gcategorys[i]);
						stockcond.setGscode(gcodes[i]);
						stockcond.setGsorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
						List<Gstock> oldStockList = gstockBL.searchGstock(stockcond, 0, 0);
						Gstock oldStock;
						if(oldStockList!=null && oldStockList.size()==1){
							oldStock = oldStockList.get(0);
						}else{
							throw new BLException("IGLOM0205.E001");//�����Ϣ������
						}
						 
									
						//��ѯ�����ϸ��
						GinoutstockdetailSearchCondImpl cond = new GinoutstockdetailSearchCondImpl();
						cond.setGiodcategory(gcategorys[i]);
						cond.setGiodcode(gcodes[i]);
						cond.setGiodtype(IGLOMCONSTANTS.GIODTYPE_RK);//����Ϊ���
						cond.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//״̬Ϊ �����
						cond.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
						
						//������Ʒ�ļ���
						List<Ginoutstockdetail> oldInStock = ginoutstockdetailBL.searchGinoutstockdetail(cond, 0, 0);
						
						if(oldInStock==null || oldInStock.size()==0){
							throw new BLException("IGLOM0205.E002");//��Ʒ�����Ϣ������
						}
						
						//������¼��Ҫ�Ŀ������
						per_outnum = goinnums[i];
			
						//����������ȳ����ԭ�����μ��ٿ����,ֱ�������������Ϊֹ	
						for(int x = 0 , y = oldInStock.size();x<y;x++){
							Ginoutstockdetail outinstock =  oldInStock.get(x);
							per_outnum = goinnums[i] - out_num_part;//ȡ�û�����������������Ҫ��
							int true_instocknum = outinstock.getGiodinnum()-outinstock.getGiodoutnum()-outinstock.getGiodreliefnum()-outinstock.getGiodhavocnum();//ÿ������ʵ�ʿ����
							if(true_instocknum>per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(out_price_part, LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue());
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����GSTOCK���б��·�����Ʒ��¼��GSNUM����ʽΪ��GSNUM = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ��¼
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));

										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
										
									}
								}else{
									
									
									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));//���ⵥ��
										//goutstock.setOutamount(out_amount);
									}
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);

									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodoutnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_LY,IGLOMCONSTANTS.GIODSTATUS_KCY,outinstock,(gs.getGsnum()));
									
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));

									break;
								}
							}else if(true_instocknum==per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
											
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
									}
								}else{
									
									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
										//outstock.setOutamount(out_amount);
									}
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);
									
									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodoutnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_LY,IGLOMCONSTANTS.GIODSTATUS_KCW,outinstock,(gs.getGsnum()));				
									
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));
									
									break;
								}
								
							}else{
								//�жϵ�ǰ������С���Ƿ��������������								
								if((out_num_part+true_instocknum)>=goinnums[i]){//����
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
									}
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add((goinnums[i]-out_num_part));
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
									falg = true;
									break;
								}else{
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
									}
									out_num_part+=true_instocknum;
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add(true_instocknum);
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
								}
							}
						}
						if(falg){
							//��ѯ�����Ϣ��
							GstockSearchCondImpl stockcond1 = new GstockSearchCondImpl();
							stockcond1.setGscategory(gcategorys[i]);
							stockcond1.setGscode(gcodes[i]);
							stockcond1.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
							List<Gstock> oldStockList1 = gstockBL.searchGstock(stockcond, 0, 0);
							Gstock oldStock1;
							if(oldStockList1!=null && oldStockList1.size()==1){
								oldStock1 = oldStockList1.get(0);
							}else{
								throw new BLException("IGLOM0205.E001");//�����Ϣ������
							}
							
							//����GINOUTSTOCKDETAIL���г����漰�ĸ�����¼
							for(int n=0,m=instockidlist.size();n<m;n++){					
								Ginoutstockdetail is = ginoutstockdetailBL.searchGinoutstockdetailByKey(instockidlist.get(n));
								int true_num = is.getGiodinnum()-is.getGiodoutnum()-is.getGiodreliefnum()-is.getGiodhavocnum();//��������ʵ�ʿ����
								GinoutstockdetailTB instockTB = (GinoutstockdetailTB)SerializationUtils.clone(is);

								if(instockOutnumlist.get(n)==true_num){
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCW);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodoutnum()+true_num);//��������������
								}else{
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodoutnum()+instockOutnumlist.get(n));//�����ѳ�������
								}
								instockTB.setGsnum(oldStock1.getGsnum());
								ginoutstockdetailBL.updateGinoutstockdetail(instockTB);
							}
							//������ⵥ�ۼ����������outstock��
							if(out_price_part!=null){
								out_price = LOMHelper.getDivide(String.valueOf(out_price_part), String.valueOf(goinnums[i])).doubleValue();
								out_price = round(out_price,4);
								out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
								out_amount = round(out_amount,4);
								goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
								//outstock.setOutamount(out_amount);
							}
							Goutstock goutstock2 = goutstockBL.registGoutstock(goutstock);
							
							//����������ϸ��¼
							if(inoutStocklist!=null && inoutStocklist.size()>0){
								for(GinoutstockdetailTB gstb:inoutStocklist){
									gstb.setGoid(goutstock2.getGoid());
									ginoutstockdetailBL.registGinoutstockdetail(gstb);
								}
							}
							
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

			}
		}else{
			//ͬ����Ʒ�ĳ������������������
			dto.setGotoError("CK_NUM_ERROR");
		}
		return dto;
	}
	
	
	/**
	 * ��Ʒ����
	 */
	public IGLOM02DTO editGoutStockAction(IGLOM02DTO dto) throws BLException {
		IGLOM0208Form form = dto.getIglom0208Form();
		User user = dto.getUser();
		String[] gcategorys = form.getGcategorys();//��Ʒ����
		String[] gnames = form.getGnames();//��Ʒ����
		String[] gcodes = form.getGcodes();//��Ʒ���
		Integer[] goinnums = form.getGoinnums();//��������
		String goorg = form.getGoorg();//���û���
		String gorequsername = form.getGorequsername();//������
		String goreqnum = form.getGoreqnum();//�ɹ����뵥���
		Integer rid = form.getRid();//�Ӵ�����ID
		
//		boolean flag = false;
//		if(IGLOMCONSTANTS.ST_ORGSYSCODING.equals(goorg)){
//			flag = true;
//		}
		
		Double out_price = 0d;//���ⵥ��
		Double out_amount = 0d;//������
		Double out_price_part = 0d;//�����ϸ��ÿ����浥��*��������������Ȼ��������������¼���ܵ�ֵ
		int out_num_part = 0;//��������С��
		boolean falg = false;//�Ƿ��������������
		List<Integer> instockidlist =  new ArrayList<Integer>();
		List<Integer> instockOutnumlist = new ArrayList<Integer>();
		int per_outnum = 0;//ÿ����¼��Ҫ�Ŀ������
		if(!checkOutNumForEdit(form)){
			if(gcategorys!=null){
				for(int i = 0,j = gcategorys.length;i<j;i++){
					if(goinnums[i]!=null && goinnums[i]!=0){
						List<GinoutstockdetailTB> inoutStocklist =  new ArrayList<GinoutstockdetailTB>();
						
						GoutstockTB goutstock = new GoutstockTB();
						//������Ʒ��Ϣ
						goutstock.setGocategory(gcategorys[i]);
						goutstock.setGoname(gnames[i]);
						goutstock.setGocode(gcodes[i]);
						goutstock.setGoinnum(goinnums[i]);
						
						//�������õ������Ϣ
						goutstock.setGotype(IGLOMCONSTANTS.GOTYPE_TJ);//��������Ϊ����

						goutstock.setGoorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������
						
						goutstock.setGotime(IGStringUtils.getCurrentDateTime());//����ʱ��
						goutstock.setGoreqnum(goreqnum);//�ɹ����뵥���
						goutstock.setGoinnum(goinnums[i]);//��������
						goutstock.setGostatus(IGLOMCONSTANTS.GOSTATUS_CKWC);//����״̬Ϊ�������
						goutstock.setGoreqorg(goorg);//���û���
						goutstock.setGorequsername(gorequsername);//����������
						goutstock.setGouser(user.getUserid());//�Ǽ���ID
						goutstock.setGousername(user.getUsername());//�Ǽ�������
						goutstock.setRid(rid);//�Ӵ�����ID
						
						//��ѯ�����Ϣ��
						GstockSearchCondImpl stockcond = new GstockSearchCondImpl();
						stockcond.setGscategory(gcategorys[i]);
						stockcond.setGscode(gcodes[i]);
						stockcond.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
						List<Gstock> oldStockList = gstockBL.searchGstock(stockcond, 0, 0);
						Gstock oldStock;
						if(oldStockList!=null && oldStockList.size()==1){
							oldStock = oldStockList.get(0);
						}else{
							throw new BLException("IGLOM0205.E001");//�����Ϣ������
						}
						 
						//��ѯ��Ʒת�ƶ���
						GoodsSearchCondImpl goodscond = new GoodsSearchCondImpl();
						goodscond.setGcategory(gcategorys[i]);
						goodscond.setGcode(gcodes[i]);
						List<Goods> goodsList = goodsBL.searchGoods(goodscond, 0, 0);
						Goods goods;
						if(goodsList!=null && goodsList.size()==1){
							goods = goodsList.get(0);
						}else{
							throw new BLException("IGLOM0208.E001");//�����Ϣ������
						}
						Double gprice = LOMHelper.getAdd(String.valueOf(goods.getGprice()),String.valueOf(100)).doubleValue();//��Ʒת�ƶ��ۣ�%��
									
						//��ѯ�����ϸ��
						GinoutstockdetailSearchCondImpl cond = new GinoutstockdetailSearchCondImpl();
						cond.setGiodcategory(gcategorys[i]);
						cond.setGiodcode(gcodes[i]);
						cond.setGiodtype(IGLOMCONSTANTS.GIODTYPE_RK);//����Ϊ���
						cond.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//״̬Ϊ �����
						cond.setGiodorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
						
						//������Ʒ�ļ���
						List<Ginoutstockdetail> oldInStock = ginoutstockdetailBL.searchGinoutstockdetail(cond, 0, 0);
						
						if(oldInStock==null || oldInStock.size()==0){
							throw new BLException("IGLOM0208.E002");//��Ʒ�����Ϣ������
						}
						
						//������¼��Ҫ�Ŀ������
						per_outnum = goinnums[i];
						
						//����������ȳ����ԭ�����μ��ٿ����,ֱ�������������Ϊֹ	
						for(int x = 0 , y = oldInStock.size();x<y;x++){
							Ginoutstockdetail outinstock =  oldInStock.get(x);
							per_outnum = goinnums[i] - out_num_part;//ȡ�û�����������������Ҫ��
							int true_instocknum = outinstock.getGiodinnum()-outinstock.getGiodoutnum()-outinstock.getGiodreliefnum()-outinstock.getGiodhavocnum();//ÿ������ʵ�ʿ����
							if(true_instocknum>per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(out_price_part, LOMHelper.getMultiply(String.valueOf(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue())), String.valueOf((goinnums[i]-out_num_part))).doubleValue());
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����GSTOCK���б��·�����Ʒ��¼��GSNUM����ʽΪ��GSNUM = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ��¼
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));

										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
										
									}
								}else{
									
									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									
									//������Ʒת�ƶ��ۼ�����ⵥ��
									out_price = LOMHelper.getDivide(String.valueOf(LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(gprice)).doubleValue()), String.valueOf(100)).doubleValue(); 
										
									
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));//���ⵥ��
										//goutstock.setOutamount(out_amount);
									}
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);

									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodreliefnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_TJ,IGLOMCONSTANTS.GIODSTATUS_KCY,outinstock,(gs.getGsnum()));
									
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));

									break;
								}
							}else if(true_instocknum==per_outnum){
								if(out_num_part!=0){//δ��ֱ�����������Ҫ
									//�жϵ�ǰ������С���Ƿ��������������								
									if((out_num_part+true_instocknum)>=goinnums[i]){//����
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
											
										}
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add((goinnums[i]-out_num_part));
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
										falg = true;
										break;
									}else{
										if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
											out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
											
										}
										out_num_part+=true_instocknum;
										instockidlist.add(outinstock.getGiodid());
										instockOutnumlist.add(true_instocknum);
										
										//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
										Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
										
										//����������ϸ
										inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
										
									}
								}else{
									
									//������ⵥ�ۼ����������goutstock��
									out_price = outinstock.getGiodinprice().doubleValue();
									
									//������Ʒת�ƶ��ۼ�����ⵥ��
									out_price = LOMHelper.getDivide(String.valueOf(LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(gprice)).doubleValue()), String.valueOf(100)).doubleValue(); 
										
									if(out_price!=null){
										out_price = round(out_price,4);
										out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
										out_amount = round(out_amount,4);
										goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
										//outstock.setOutamount(out_amount);
									}
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-goinnums[i]),oldStock,user);
									
									//���������ϸ
									updateGinoutStockDetailAction((outinstock.getGiodreliefnum()+goinnums[i]),IGLOMCONSTANTS.GIODTYPE_TJ,IGLOMCONSTANTS.GIODSTATUS_KCW,outinstock,(gs.getGsnum()));				
									
									
									Goutstock goutstock1 = goutstockBL.registGoutstock(goutstock);
									
									//����������ϸ
									insertGOutStockDetailAction(goutstock1,outinstock.getGiodid(),goutstock1.getGoid(),outinstock.getGiodreqnum(),(goinnums[i]),outinstock.getGiodreqnum(),(gs.getGsnum()));
									
									break;
								}
								
							}else{
								//�жϵ�ǰ������С���Ƿ��������������								
								if((out_num_part+true_instocknum)>=goinnums[i]){//����
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue()), String.valueOf((goinnums[i]-out_num_part))).doubleValue())).doubleValue();
									}
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add((goinnums[i]-out_num_part));
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-(goinnums[i]-out_num_part)),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(goinnums[i]-out_num_part),outinstock.getGiodreqnum(),(gs.getGsnum())));
									
									falg = true;
									break;
								}else{
									if(outinstock.getGiodinprice()!=null && outinstock.getGiodinprice().doubleValue()>0){
										out_price_part = LOMHelper.getAdd(String.valueOf(out_price_part), String.valueOf(LOMHelper.getMultiply(String.valueOf(LOMHelper.getMultiply(String.valueOf(outinstock.getGiodinprice()), String.valueOf(gprice)).doubleValue()), String.valueOf(true_instocknum)).doubleValue())).doubleValue();
									}
									out_num_part+=true_instocknum;
									instockidlist.add(outinstock.getGiodid());
									instockOutnumlist.add(true_instocknum);
									
									//����stock���б��·�����Ʒ��¼��stocknum����ʽΪ��stocknum = ��ǰֵ - ʵ�ʳ�������
									Gstock gs = updateGstockAction((oldStock.getGsnum()-true_instocknum),oldStock,user);
									
									//����������ϸ
									inoutStocklist.add(insertGOutStockDetailAction(goutstock,outinstock.getGiodid(),(true_instocknum),outinstock.getGiodreqnum(),(gs.getGsnum())));
								}
							}
						}
						if(falg){
							//��ѯ�����Ϣ��
							GstockSearchCondImpl stockcond1 = new GstockSearchCondImpl();
							stockcond1.setGscategory(gcategorys[i]);
							stockcond1.setGscode(gcodes[i]);
							stockcond1.setGsorg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);
							List<Gstock> oldStockList1 = gstockBL.searchGstock(stockcond, 0, 0);
							Gstock oldStock1;
							if(oldStockList1!=null && oldStockList1.size()==1){
								oldStock1 = oldStockList1.get(0);
							}else{
								throw new BLException("IGLOM0205.E001");//�����Ϣ������
							}
							
							
							//����GINOUTSTOCKDETAIL���г����漰�ĸ�����¼
							for(int n=0,m=instockidlist.size();n<m;n++){					
								Ginoutstockdetail is = ginoutstockdetailBL.searchGinoutstockdetailByKey(instockidlist.get(n));
								int true_num = is.getGiodinnum()-is.getGiodoutnum()-is.getGiodreliefnum()-is.getGiodhavocnum();//��������ʵ�ʿ����
								GinoutstockdetailTB instockTB = (GinoutstockdetailTB)SerializationUtils.clone(is);

								if(instockOutnumlist.get(n)==true_num){
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCW);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodreliefnum()+true_num);//�����ѵ�������
								}else{
									instockTB.setGiodstatus(IGLOMCONSTANTS.GIODSTATUS_KCY);//����״̬�޸�Ϊ�������
									instockTB.setGiodoutnum(is.getGiodreliefnum()+instockOutnumlist.get(n));//�����ѳ�������
								}
								instockTB.setGsnum(oldStock1.getGsnum());
								ginoutstockdetailBL.updateGinoutstockdetail(instockTB);
							}
							//������ⵥ�ۼ����������outstock��
							if(out_price_part!=null){
								out_price = LOMHelper.getDivide(String.valueOf(out_price_part), String.valueOf(goinnums[i])).doubleValue();
								//������Ʒת�ƶ��ۼ�����ⵥ��
								out_price = LOMHelper.getDivide(String.valueOf(LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(gprice)).doubleValue()), String.valueOf(100)).doubleValue(); 

								out_price = round(out_price,4);
								out_amount = LOMHelper.getMultiply(String.valueOf(out_price), String.valueOf(goinnums[i])).doubleValue();
								out_amount = round(out_amount,4);
								goutstock.setGooutprice(new BigDecimal(String.valueOf(out_price)));
								//outstock.setOutamount(out_amount);
							}
							Goutstock goutstock2 = goutstockBL.registGoutstock(goutstock);
							
							//����������ϸ��¼
							if(inoutStocklist!=null && inoutStocklist.size()>0){
								for(GinoutstockdetailTB gstb:inoutStocklist){
									gstb.setGoid(goutstock2.getGoid());
									ginoutstockdetailBL.registGinoutstockdetail(gstb);
								}
							}
							
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

			}
		}else{
			//ͬ����Ʒ�ĳ������������������
			dto.setGotoError("CK_NUM_ERROR");
		}
		return dto;
	}
	
	/**
	 * ÿ���̵�
	 *  
	 * @param dto IGLOM02DTO
	 * @return IGLOM02DTO
	 */
	public IGLOM02DTO searchInventoryAction(IGLOM02DTO dto) throws BLException {
		IGLOM0220Form form = dto.getIglom0220Form();
		InventorySearchCondImpl cond = new InventorySearchCondImpl();
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());

		List<Inventory> inventoryList = inventoryBL.searchInventory(cond, 0, 0);
		int totalCount = inventoryList.size();
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGLOM0205.I001",0));
			return dto;
		}
		dto.setInventoryList(inventoryList);
		
		return dto;
	}
	
	
	
	
	
	
	/**
	 * ÿ���̵��Զ���������
	 * 
	 * @throws BLException
	 */
	public void insertInventoryInfoAction() throws BLException {
		
		//��ǰ�̴�����
		String date = IGStringUtils.getCurrentDate().substring(0, 7);
		//ȡ����
		String month = IGStringUtils.getCurrentDate().substring(5, 7);
		if("01".equals(month)){
			month = "12";
		}else{
			int temp = Integer.parseInt(month) - 1;
			if(temp < 10){
				month = "0" + String.valueOf(temp);
			}else{
				month = String.valueOf(temp);
			}
		}
		String predate = IGStringUtils.getCurrentYear() + "/" + month;
		
		InventoryInfoSearchCondImpl cond = new InventoryInfoSearchCondImpl();
		
		cond.setDate_from(date + "/00 00:00");		//���¿�ʼ
		log.debug("========��ʼ���ڣ�"+cond.getDate_from());
		cond.setDate_to(date + "/31 23:59");		//���½���
		log.debug("========�������ڣ�"+cond.getDate_to());
//		cond.setPredate_from(predate + "/00 00:00");//���¿�ʼ
		cond.setPredate_from(predate);//���¿�ʼ
//		cond.setPredate_to(predate + "/31 23:59");	//���½���
		
		cond.setOrg(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//��������Ϊ��������
		List<InventoryInfo> list = this.inventoryBL.searchInventoryInfo(cond, 0, 0);
		log.debug("========��ѯ����=========��"+list.size()+"��=============");
		for(InventoryInfo in:list){
			InventoryInfoVW inVW = (InventoryInfoVW)SerializationUtils.clone(in);
			InventoryTB inTB = new InventoryTB();
			inTB.setAverage(inVW.getAverage());
			inTB.setInventorydate(date);
			inTB.setInid(null);
			inTB.setCmhavoamount(inVW.getCmhavoamount() == null?0:inVW.getCmhavoamount());
			inTB.setCmhavomoney(inVW.getCmhavomoney() == null?new BigDecimal(0):inVW.getCmhavomoney());
			inTB.setCminputamount(inVW.getCminputamount() == null?0:inVW.getCminputamount());
			inTB.setCminputmoney(inVW.getCminputmoney() == null?new BigDecimal(0):inVW.getCminputmoney());
			inTB.setCmoutamount(inVW.getCmoutamount() == null?0:inVW.getCmoutamount());
			inTB.setCmoutmoney(inVW.getCmoutmoney() == null?new BigDecimal(0):inVW.getCmoutmoney());
			inTB.setCmregamount(inVW.getCmregamount() == null?0:inVW.getCmregamount());
			inTB.setCmregmoney(inVW.getCmregmoney() == null?new BigDecimal(0):inVW.getCmregmoney());
			inTB.setCmsurplusamount(inVW.getCmsurplusamount() == null?0:inVW.getCmsurplusamount());
			inTB.setCmsurplusmoney(inVW.getCmsurplusmoney() == null?new BigDecimal(0):inVW.getCmsurplusmoney());
			inTB.setGoodscategory(inVW.getGoodscategory());
			inTB.setGoodscode(inVW.getGoodscode());
			inTB.setGoodsname(inVW.getGoodsname());
			inTB.setLminventoryamount(inVW.getLminventoryamount() == null?0:inVW.getLminventoryamount());
			inTB.setLminventorymoney(inVW.getLminventorymoney() == null?new BigDecimal(0):inVW.getLminventorymoney());
			this.inventoryBL.registInventory(inTB);
		}
		
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
		if(scale>2){
			scale = 2;
		}
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}

	public synchronized IGLOM02DTO doStock(IGLOM02DTO dto, String methodName) throws BLException {
		if (methodName.equals("insertInStockAction")){ //��Ʒ���
			dto = this.insertInStockAction(dto);
		}
		else if (methodName.equals("insertGoutStockAction")){ //��Ʒ����
			dto = this.insertGoutStockAction(dto);
		}
		else if (methodName.equals("editGoutStockAction")){ //��Ʒ����
			dto = this.editGoutStockAction(dto);
		}
		else if (methodName.equals("insertGoutStockForSTAction")){ //ʳ�ó���
			dto = this.insertGoutStockForSTAction(dto);
		}
		else if (methodName.equals("editInStockAction")){ //������
			dto = this.editInStockAction(dto);
		}
		else if (methodName.equals("deleteInStockAction")){ //�������
			dto = this.deleteInStockAction(dto);
		}
		else if (methodName.equals("destroyStockAction")){//�������
			dto = this.destroyStockAction(dto);
		}
		else if (methodName.equals("approveDestroyAction")){//��������ͨ��
			dto = this.approveDestroyAction(dto);
		}
		else if (methodName.equals("noApproveDestroyAction")){//����������ͨ��
			dto = this.noApproveDestroyAction(dto);
		}
		return dto;
	}
}
