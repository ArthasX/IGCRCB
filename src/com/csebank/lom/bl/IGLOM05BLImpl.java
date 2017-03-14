/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.DeptEentertainmentBL;
import com.csebank.lom.bl.task.EEOrgVWBL;
import com.csebank.lom.bl.task.EateryBL;
import com.csebank.lom.bl.task.EentertainmentBL;
import com.csebank.lom.bl.task.EentertainmentStatisticsBL;
import com.csebank.lom.bl.task.EworkingLunchBL;
import com.csebank.lom.bl.task.GinoutstockdetailBL;
import com.csebank.lom.bl.task.GoodsStockBL;
import com.csebank.lom.bl.task.LunchCardBL;
import com.csebank.lom.bl.task.RecptionBL;
import com.csebank.lom.bl.task.SingleGoodsStockBL;
import com.csebank.lom.bl.task.WorkLunchEateryBL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0501Form;
import com.csebank.lom.form.IGLOM0503Form;
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
import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCondSearchCondImpl;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCondImpl;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCondImpl;
import com.csebank.lom.model.condition.GoodsStockSearchCondImpl;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCondImpl;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCondImpl;
import com.csebank.lom.model.entity.ItemsCodesStTB;
import com.csebank.lom.model.entity.WorkLunchEateryVW;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05051VO;
import com.csebank.lom.vo.IGLOM05141VO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;

/**
 *  �Ӵ�����BLʵ��
 */
public class IGLOM05BLImpl extends BaseBLImpl implements IGLOM05BL {
	
	static Log log = LogFactory.getLog(IGLOM05BLImpl.class);
	protected EEOrgVWBL eeOrgVWBL;
	/** ʳ�óɱ���ϢBL */
	protected EateryBL eateryBL;

	
	/** ʳ�ù�������ϢBL */
	protected EworkingLunchBL eworkingLunchBL;
	
	/** ʳ�ýӴ���ϢBL */
	protected EentertainmentBL eentertainmentBL;
	
	/** �����ͳɱ�ͳ����ϢBL */
	protected WorkLunchEateryBL workLunchEateryBL;
	
	/** �Ӵ�ͳ����ϢBL */
	protected EentertainmentStatisticsBL eentertainmentStatisticsBL;
	
	/** ���ŽӴ�ͳ����ϢBL */
	protected DeptEentertainmentBL deptEentertainmentBL;
	
	/** ���ͳ����ϢBL */
	protected GoodsStockBL goodsStockBL;
	
	/** ��һ��Ʒ���ͳ����ϢBL */
	protected SingleGoodsStockBL singleGoodsStockBL;
	
	/** �Ӵ���ϢBL */
	protected RecptionBL recptionBL;
	
	/** �������ϸBL */
	protected GinoutstockdetailBL ginoutstockdetailBL;
	
	/** �Ϳ���ϢBL */
	protected LunchCardBL lunchCardBL;
	
	/**
	 * @param ginoutstockdetailBL the ginoutstockdetailBL to set
	 */
	public void setGinoutstockdetailBL(GinoutstockdetailBL ginoutstockdetailBL) {
		this.ginoutstockdetailBL = ginoutstockdetailBL;
	}
	
	/**
	 * ʳ�óɱ���ϢBL�趨
	 * @param eateryBL ʳ�óɱ���ϢBL
	 */
	public void setEateryBL(EateryBL eateryBL) {
		this.eateryBL = eateryBL;
	}
	
	public void setRecptionBL(RecptionBL recptionBL) {
		this.recptionBL = recptionBL;
	}
	
	/**
	 * ʳ�ù�������ϢBL�趨
	 * @param EworkingLunchBL ʳ�óɱ���ϢBL
	 */
	public void setEworkingLunchBL(EworkingLunchBL eworkingLunchBL) {
		this.eworkingLunchBL = eworkingLunchBL;
	}
	
	/**
	 * �����ͳɱ�ͳ����ϢBL�趨
	 * @param EentertainmentBL �����ͳɱ�ͳ����ϢBL
	 */
	public void setEentertainmentBL(EentertainmentBL eentertainmentBL) {
		this.eentertainmentBL = eentertainmentBL;
	}
	
	/**
	 * �Ӵ�ͳ����ϢBL�趨
	 * @param eentertainmentStatisticsBL �Ӵ�ͳ����ϢBL
	 */
	public void setEentertainmentStatisticsBL(EentertainmentStatisticsBL eentertainmentStatisticsBL) {
		this.eentertainmentStatisticsBL = eentertainmentStatisticsBL;
	}
	
	/**
	 * ʳ�ýӴ���ϢBL�趨
	 * @param workLunchEateryBL ʳ�ýӴ���ϢBL
	 */
	public void setWorkLunchEateryBL(WorkLunchEateryBL workLunchEateryBL) {
		this.workLunchEateryBL = workLunchEateryBL;
	}
	
	/**
	 * ���ŽӴ�ͳ����ϢBL�趨
	 * @param eentertainmentStatisticsBL �Ӵ�ͳ����ϢBL
	 */
	public void setDeptEentertainmentBL(DeptEentertainmentBL deptEentertainmentBL) {
		this.deptEentertainmentBL = deptEentertainmentBL;
	}
	
	
	/**
	 * ���ͳ����ϢBL�趨
	 * @param workLunchEateryBL ���ͳ����ϢBL
	 */
	public void setGoodsStockBL(GoodsStockBL goodsStockBL) {
		this.goodsStockBL = goodsStockBL;
	}
	
	/**
	 * ��һ��Ʒ���ͳ����ϢBL�趨
	 * @param workLunchEateryBL ���ͳ����ϢBL
	 */
	public void setSingleGoodsStockBL(SingleGoodsStockBL singleGoodsStockBL) {
		this.singleGoodsStockBL = singleGoodsStockBL;
	}
	
	/**
	 * �Ϳ���ϢBL�趨
	 * @param workLunchEateryBL �Ϳ���ϢBL
	 */
	public void setLunchCardBL(LunchCardBL lunchCardBL) {
		this.lunchCardBL = lunchCardBL;
	}
	
	//�ɱ�
	/**
	 * ʳ�óɱ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEateryAction(IGLOM05DTO dto) throws BLException {

		log.debug("========ʳ�óɱ���Ϣ������������ʾ����ʼ========");	
		IGLOM0501Form form = dto.getIglom0501Form();
		Eatery rp = eateryBL.searchEateryByKey(form.getEid());
		if ( rp == null ){
			throw new BLException("IGCO10000.E004","ʳ�óɱ�");
		}
		
		//������ʾ�趨
		form.setEid(rp.getEid());
		form.setEdate(rp.getEdate());
		form.setEstaplecost(rp.getEstaplecost());
		form.setEflavouringcost(rp.getEflavouringcost());
		form.setEothercost(rp.getEothercost());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0501Form(form);
		
		log.debug("========ʳ�óɱ���Ϣ������������ʾ��������========");
		return dto;
	}
	
	/**
	 * ʳ�óɱ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertEateryAction(IGLOM05DTO dto) throws BLException {
		log.debug("========ʳ�óɱ���Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0501Form form = dto.getIglom0501Form();
	
		//�ɱ���¼
		this.eateryBL.registEatery(dto.getIglom0501Form());
		
		dto.setIglom0501Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ʳ�óɱ���Ϣ") );

		log.debug("========ʳ�óɱ���Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ʳ�óɱ���Ϣ�趨
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateEateryAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�óɱ���Ϣ�������ʼ========");
		
		//ʳ�óɱ���Ϣ���
		this.eateryBL.updateEatery(dto.getEatery());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ʳ�óɱ���Ϣ") );

		log.debug("========ʳ�óɱ���Ϣ�����������========");

		return dto;
	}
	
	/**
	 * ʳ�óɱ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEateryAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�óɱ���Ϣ��ѯ����ʼ========");
		
		//�ɱ���Ϣ��ѯ����ȡ�� 
		int totalCount = this.eateryBL.getSearchCount(dto.getEaterySearchCond());
		
		if (totalCount == 0) {
			log.debug("========ʳ�óɱ���Ϣ��ѯ���ݲ�����========");
			//ʳ�óɱ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ʳ�óɱ���Ϣ��ѯ���ݼ�������========");
			//ʳ�óɱ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<Eatery> eateryList = this.eateryBL.searchEatery(dto.getEaterySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setEateryList(eateryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========ʳ�óɱ���Ϣ��ѯ��������========");
		
		return dto;
	}
	
	//������
	
	/**
	 * ʳ�ù�������Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEworkingLunchAction(IGLOM05DTO dto) throws BLException {

		log.debug("========ʳ�ù�������Ϣ������������ʾ����ʼ========");	
		IGLOM0503Form form = dto.getIglom0503Form();
		EworkingLunch rp = eworkingLunchBL.searchEworkingLunchByKey(form.getEwlid());
		if ( rp == null ){
			throw new BLException("IGCO10000.E004","ʳ�ù�����");
		}
		
		//������ʾ�趨
		form.setEwlid(rp.getEwlid());
		form.setEwldate(rp.getEwldate());
		form.setLunchcardprince(rp.getLunchcardprince());
		Integer icid[] = new Integer[1];
		icid[0] = rp.getIcid();
		form.setIcidList(icid);
		
		String lunchcardname[] = new String[1];
		lunchcardname[0] = rp.getLunchcardname();
		form.setLunchcardnameList(lunchcardname);
		
		Integer[] lunchcardnum = new Integer[1];
		lunchcardnum[0] = rp.getLunchcardnum();
		form.setLunchcardnumList(lunchcardnum);
		
		form.setLunchcardname(rp.getLunchcardname());
		form.setLunchcardnum(rp.getLunchcardnum());
		form.setIcid(rp.getIcid());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0503Form(form);
		
		log.debug("========ʳ�ù�������Ϣ������������ʾ��������========");
		return dto;
	}
	
	/**
	 * ʳ�ù�������Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertEworkingLunchAction(IGLOM05DTO dto) throws BLException {
		log.debug("========ʳ�óɱ���Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0503Form form = dto.getIglom0503Form();
		
		
		//��Ϳ�����
//		form.setEwlbreakfastcardprice(new BigDecimal(CodeUtils.EWLBREAKFASTCARDPRICE));
//		//��Ϳ�����
//		form.setEwllunchcardprice(new BigDecimal(CodeUtils.EWLLUNCHCARDPRICE));
//		//��Ϳ�����
//		form.setEwlsupperprice(new BigDecimal(CodeUtils.EWLSUPPERPRICE));
//		//1��ȯ����
//		form.setEwloneticketprice(new BigDecimal(CodeUtils.EWLONETICKETPRICE));
//		//2��ȯ����
//		form.setEwltwoticketprice(new BigDecimal(CodeUtils.EWLTWOTICKETPRICE));
//		//3��ȯ����
//		form.setEwlthreeticketprice(new BigDecimal(CodeUtils.EWLTHREETICKETPRICE));
		
		//ʳ�ù�������Ϣ��¼
		for(int i=0; i<form.getIcidList().length; i++){
			form.setIcid(form.getIcidList()[i]);
			form.setLunchcardname(form.getLunchcardnameList()[i]);
			form.setLunchcardnum(form.getLunchcardnumList()[i]);
			if(form.getLunchcardnum()>0){
				ItemsCodesSt ics = lunchCardBL.searchLunchCardByKey(form.getIcid());
				
				form.setLunchcardprince((new BigDecimal(ics.getType()).add(new BigDecimal(ics.getTypecode()))));
				this.eworkingLunchBL.registEworkingLunch(form);
			}
		}
		
		
		dto.setIglom0503Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ʳ�ù�������Ϣ") );

		log.debug("========ʳ�ù�������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ʳ�ù�������Ϣ�趨
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateEworkingLunchAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�ù�������Ϣ�������ʼ========");
		
		//ʳ�ù�������Ϣ���
		IGLOM0503Form form = dto.getIglom0503Form();
		ItemsCodesSt ics = lunchCardBL.searchLunchCardByKey(form.getIcid());
		form.setLunchcardprince((new BigDecimal(ics.getType()).add(new BigDecimal(ics.getTypecode()))));
		this.eworkingLunchBL.updateEworkingLunch(dto.getEworkingLunch());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ʳ�ù�������Ϣ") );

		log.debug("========ʳ�ù�������Ϣ�����������========");

		return dto;
	}
	
	/**
	 * ʳ�ù�������Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEworkingLunchAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�óɱ���Ϣ��ѯ����ʼ========");
		
		//ʳ�ù�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.eworkingLunchBL.getSearchCount(dto.getEworkingLunchSearchCond());
		
		if (totalCount == 0) {
			log.debug("========ʳ�ù�������Ϣ��ѯ���ݲ�����========");
			//ʳ�ù�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ʳ�ù�������Ϣ��ѯ���ݼ�������========");
			//ʳ�ù�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<EworkingLunch> eworkingLunchList = this.eworkingLunchBL.searchEworkingLunch(dto.getEworkingLunchSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setEworkingLunchList(eworkingLunchList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========ʳ�ù�������Ϣ��ѯ��������========");
		
		return dto;
	}
	
	//�Ӵ�
	
	/**
	 * ʳ�ýӴ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initEentertainmentAction(IGLOM05DTO dto) throws BLException {

		log.debug("========ʳ�ýӴ���Ϣ������������ʾ����ʼ========");	
		IGLOM0506Form form = dto.getIglom0506Form();
		Eentertainment rp = eentertainmentBL.searchEentertainmentByKey(form.getEeid());
		if ( rp == null ){
			throw new BLException("IGCO10000.E004","ʳ�ù�����");
		}
		
		//������ʾ�趨
		form.setEeid(rp.getEeid());
		form.setRid(rp.getRid());
		if(rp.getRecptionTB()==null){
			form.setRstatus("");
		}else{
			form.setRstatus(rp.getRecptionTB().getRstatus());
		}
		form.setEeuser(rp.getEeuser());
		form.setEetableprice(rp.getEetableprice());
		form.setEetablenum(rp.getEetablenum());
		form.setEedrinkprice(rp.getEedrinkprice());
		if(rp.getRecptionTB()!=null){
			form.setRname(rp.getRecptionTB().getRname());
		}
		form.setEesmokeprice(rp.getEesmokeprice());
		form.setEeotherprice(rp.getEeotherprice());
		form.setEedate(rp.getEedate());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0506Form(form);
		
		log.debug("========ʳ�ýӴ���Ϣ������������ʾ��������========");
		return dto;
	}
	
	/**
	 * ʳ�ýӴ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertEentertainmentAction(IGLOM05DTO dto) throws BLException {
		log.debug("========ʳ�óɽӴ���Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0506Form form = dto.getIglom0506Form();
	
		//ʳ�ýӴ�������¼
		this.eentertainmentBL.registEentertainment(dto.getIglom0506Form());
		
		dto.setIglom0506Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ʳ���д���Ϣ") );

		log.debug("========ʳ�ýӴ���Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * ʳ�ýӴ���Ϣ�趨
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateEentertainmentAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�ýӴ���Ϣ�������ʼ========");
		
		//ʳ�ýӴ���Ϣ���
		this.eentertainmentBL.updateEentertainment(dto.getEentertainment());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ʳ�ýӴ���Ϣ") );

		log.debug("========ʳ�ýӴ���Ϣ�����������========");

		return dto;
	}
	
	/**
	 * ʳ�ýӴ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEentertainmentAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========ʳ�ýӴ���Ϣ��ѯ����ʼ========");
		
		//ʳ�ýӴ���ѯ����ȡ�� 
		int totalCount = this.eentertainmentBL.getSearchCount(dto.getEentertainmentSearchCond());
		
		if (totalCount == 0) {
			log.debug("========ʳ�ýӴ���Ϣ��ѯ���ݲ�����========");
			//ʳ�ýӴ���ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ʳ�ù�������Ϣ��ѯ���ݼ�������========");
			//ʳ�ýӴ���ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<Eentertainment> eentertainmentList = this.eentertainmentBL.searchEentertainment(dto.getEentertainmentSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setEentertainmentList(eentertainmentList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========ʳ�ýӴ���Ϣ��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �Ӵ�ɾ��
	 * </p>
	 * 
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 * @throws BLException
	 */
	public IGLOM05DTO deleteEentertainmentAction(IGLOM05DTO dto) throws BLException {
		log.debug("========ʳ�ýӴ�ɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteEeid().length;i++ ){
			//֪ͨɾ������
			String eeid = dto.getDeleteEeid()[i];

			eentertainmentBL.deleteEentertainment(new Integer(eeid));
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "ʳ�ýӴ���Ϣ"));
		log.debug("========ʳ�ýӴ�ɾ����������========");
		return dto;
	}
	
	/**
	 * �����ͳɱ�ͳ�Ʋ�ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	@SuppressWarnings("unchecked")
	public IGLOM05DTO searchWorkLunchEateryAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ����ʼ========");
		
		/*
		int totalCount = this.eentertainmentBL.getSearchCount(dto.getEentertainmentSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ���ݲ�����========");
			//ʳ�ýӴ���ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ���ݼ�������========");
			//�����ͳɱ�ͳ�Ʋ�ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		*/
		WorkLunchEaterySearchCondImpl cond = new WorkLunchEaterySearchCondImpl();
		IGLOM0505Form form = dto.getIglom0505Form();
		cond.setSearchtype(form.getSearchtype());
		if("M".equals(form.getSearchtype())){
			//���²�ѯ
			if(!StringUtils.isEmpty(form.getMonth())){
				cond.setEdate(form.getYear()+"/"+(form.getMonth().length()==2?form.getMonth():"0"+form.getMonth()));
			}else if(!StringUtils.isEmpty(form.getYear())){
				cond.setEdate(form.getYear());
			}
		}else if("Y".equals(form.getSearchtype())){
			//�����ѯ
			cond.setEdate(form.getYear());
		}else if("D".equals(form.getSearchtype())){
			//��ϸ��ѯ
			cond.setEdate(form.getEdate());
		}else{
			//�����Ȳ�ѯ
			if(!StringUtils.isEmpty(form.getQuarter())){
				cond.setEdate(form.getQuarter());
				if("1".equals(form.getQuarter())){
					cond.setEtime_from(form.getYear()+"/"+"01");
					cond.setEtime_to(form.getYear()+"/"+"03");
				}else if("2".equals(form.getQuarter())){
					cond.setEtime_from(form.getYear()+"/"+"04");
					cond.setEtime_to(form.getYear()+"/"+"06");
				}else if("3".equals(form.getQuarter())){
					cond.setEtime_from(form.getYear()+"/"+"07");
					cond.setEtime_to(form.getYear()+"/"+"09");
				}else if("4".equals(form.getQuarter())){
					cond.setEtime_from(form.getYear()+"/"+"10");
					cond.setEtime_to(form.getYear()+"/"+"12");
				}
			}else{
				cond.setEdate(form.getYear());
			}
		}
		//��ǰҳ��Ϣȡ��
		List<WorkLunchEatery> workLunchEateryList = this.workLunchEateryBL.searchWorkLunchEatery(cond, 0, 0);
		if("D".equals(form.getSearchtype())){
			for(int i=0; i<workLunchEateryList.size(); i++){
				if("-1.00".equals(workLunchEateryList.get(i).getLunchcardprice())){//�ɱ�
					workLunchEateryList.get(i).setLunchcardname("");
					workLunchEateryList.get(i).setLunchcardprice("");
					workLunchEateryList.get(i).setLunchcardnum("");
				}else{//������
					workLunchEateryList.get(i).setAllcost("");
					workLunchEateryList.get(i).setEflavouringcost("");
					workLunchEateryList.get(i).setEothercost("");
					workLunchEateryList.get(i).setEstaplecost("");
				}
			}
			dto.setWorkLunchEateryList(workLunchEateryList);
		}else{
			//�������
			Map<String,IGLOM05051VO> map = new LinkedHashMap<String,IGLOM05051VO>();
			List<WorkLunchEatery> ljlist = new ArrayList<WorkLunchEatery>();
			List<WorkLunchEatery> relist = new ArrayList<WorkLunchEatery>();
			String num = "0";
			String incost = "0";
			String outcost = "0";
			int count = 0;
			List<String> date = new ArrayList<String>();
			
			//ȷ����¼����
			for(int i=0; i<workLunchEateryList.size(); i++){
				WorkLunchEatery we = workLunchEateryList.get(i);
				if(i==0){
					count++;
					date.add(we.getWldate());
				}else{
					if(!we.getWldate().equals(workLunchEateryList.get(i-1).getWldate())){
						count++;
						date.add(we.getWldate());
					}
				}			
			}
			
			List<WorkLunchEatery> list[] = new ArrayList[count];
			count = 0;
			
			//Ϊ���������
			for(int i=0; i<workLunchEateryList.size(); i++){
				WorkLunchEatery we = workLunchEateryList.get(i);
				if(i==0){
					list[count] = new ArrayList<WorkLunchEatery>();
					list[count].add(we);
				}else{
					if(we.getWldate().equals(workLunchEateryList.get(i-1).getWldate())){
						list[count].add(we);
					}else{
						count++;
						list[count] = new ArrayList<WorkLunchEatery>();
						list[count].add(we);
					}
				}
			}
			
			//�����ĺϼƼ���
			for(int i=0; i<list.length; i++){
				for(int j=0; j<list[i].size(); j++){
					WorkLunchEatery we = list[i].get(j);
					num = String.valueOf(Integer.parseInt(num)+Integer.parseInt(we.getLunchcardnum()));
					incost = LOMHelper.getAdd(new BigDecimal(incost), new BigDecimal(we.getIncost())).toString();
					outcost = LOMHelper.getAdd(new BigDecimal(outcost), new BigDecimal(we.getOutcost())).toString();
					
					if(j==(list[i].size()-1)){
						//��ʼ�����һ������
						String wldate = we.getWldate();
						String allcost = we.getAllcost();
						String estaplecost = we.getEstaplecost();
						String eflavouringcost = we.getEflavouringcost();
						String eothercost = we.getEothercost();
						
						//���һ�ŲͿ�
						if(!("-1.00".equals(we.getLunchcardprice()))){
							we.setWldate("");
							we.setAllcost("");
							we.setEstaplecost("");
							we.setEflavouringcost("");
							we.setEothercost("");
							we.setIncost("");
							we.setOutcost("");
							//ljlist.add(we);
						}
						WorkLunchEatery wef = new WorkLunchEateryVW();
						wef.setWldate(wldate);
						wef.setAllcost(allcost);
						wef.setEstaplecost(estaplecost);
						wef.setEflavouringcost(eflavouringcost);
						wef.setEothercost(eothercost);
						wef.setIncost(incost);
						wef.setOutcost(outcost);
						wef.setLunchcardname("-");
						wef.setLunchcardprice("-");
						wef.setLunchcardnum(num);
						ljlist.add(wef);
						if(ljlist.size()!=1){
							relist = new ArrayList<WorkLunchEatery>();
							relist.add(ljlist.get(ljlist.size()-1));
							for(int c=0; c<(ljlist.size()-1);c++){
								relist.add(ljlist.get(c));
							}
						}else{
							relist = ljlist;
						}
						IGLOM05051VO vo = new IGLOM05051VO();
						vo.setWorkLunchEateryList(relist);
						map.put(date.get(i), vo);
						ljlist = new ArrayList<WorkLunchEatery>();
						num = "0";
						incost = "0";
						outcost = "0";
					}else{
						if(!("-1.00".equals(we.getLunchcardprice()))){
							we.setWldate("");
							we.setAllcost("");
							we.setEstaplecost("");
							we.setEflavouringcost("");
							we.setEothercost("");
							we.setIncost("");
							we.setOutcost("");
							//ljlist.add(we);
						}
					}
				}
			}
			//
			
			//pDto.setTotalCount(totalCount);
			dto.setMapel(map);
		}
		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * �Ӵ�ͳ�Ʋ�ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEentertainmentStatisticsAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========�Ӵ�ͳ�Ʋ�ѯ����ʼ========");
		
		/*
		int totalCount = this.eentertainmentBL.getSearchCount(dto.getEentertainmentSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ���ݲ�����========");
			//ʳ�ýӴ���ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����ͳɱ�ͳ�Ʋ�ѯ���ݼ�������========");
			//�����ͳɱ�ͳ�Ʋ�ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		*/
		EentertainmentStatisticsSearchCondImpl cond = new EentertainmentStatisticsSearchCondImpl();
		IGLOM0508Form form = dto.getIglom0508Form();
		String type="";
		
		if(StringUtils.isEmpty(form.getEtime_from()) && StringUtils.isEmpty(form.getEtime_to())){
			type="all";
		}else{
			if(!StringUtils.isEmpty(form.getEtime_from()) && !StringUtils.isEmpty(form.getEtime_to())){
				type = "FT";
				cond.setEtime_from(form.getEtime_from());
				cond.setEtime_to(form.getEtime_to());
			}else{
				if(!StringUtils.isEmpty(form.getEtime_from())){
					type = "F";
					cond.setEtime_from(form.getEtime_from());
				}else{
					type = "T";
					cond.setEtime_to(form.getEtime_to());
				}
			}
		}
		cond.setEwhere(type);
		//��ǰҳ��Ϣȡ��
		List<EentertainmentStatistics> eentertainmentStatisticsList = this.eentertainmentStatisticsBL.searchEentertainmentStatistics(cond, 0, 0);
		
		dto.setEentertainmentStatisticsList(eentertainmentStatisticsList);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ӵ�ͳ�Ʋ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ŽӴ�ͳ�Ʋ�ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchDeptEentertainmentAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========���ŽӴ�ͳ�Ʋ�ѯ����ʼ========");
		
		DeptEentertainmentSearchCondSearchCondImpl cond = new DeptEentertainmentSearchCondSearchCondImpl();
		IGLOM0509Form form = dto.getIglom0509Form();
		String type="";
		
		if(StringUtils.isEmpty(form.getEtime_from()) && StringUtils.isEmpty(form.getEtime_to())){
			type="all";
		}else{
			if(!StringUtils.isEmpty(form.getEtime_from()) && !StringUtils.isEmpty(form.getEtime_to())){
				type = "FT";
				cond.setEtime_from(form.getEtime_from());
				cond.setEtime_to(form.getEtime_to());
			}else{
				if(!StringUtils.isEmpty(form.getEtime_from())){
					type = "F";
					cond.setEtime_from(form.getEtime_from());
				}else{
					type = "T";
					cond.setEtime_to(form.getEtime_to());
				}
			}
		}
		cond.setEwhere(type);
		//��ǰҳ��Ϣȡ��
		List<DeptEentertainment> deptEentertainmentList = this.deptEentertainmentBL.searchDeptEentertainment(cond, 0, 0);
		
		dto.setDeptEentertainmentList(deptEentertainmentList);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ŽӴ�ͳ�Ʋ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ͳ�Ʋ�ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchGoodsStockAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========���ͳ�Ʋ�ѯ����ʼ========");
		IGLOM0514Form form = dto.getIglom0514Form();
		String date = form.getYear()+"/"+(form.getMonth().length()==2?form.getMonth():"0"+form.getMonth());
		
//		GoodsStockSearchCondImpl cond = new GoodsStockSearchCondImpl();
//		
//		cond.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
//		cond.setGiodcategory(IGLOMCONSTANTS.ST_SEARCH_TYPE);
//		cond.setEdate(form.getYear()+"/"+(form.getMonth().length()==2?form.getMonth():"0"+form.getMonth()));
//		List<GoodsStock> goodsStockList=null;
		Map<String,IGLOM05141VO> map = new LinkedHashMap<String,IGLOM05141VO>();
		int incount = 0;
		int outcount = 0;
		int nowcount = 0;//zui
		String tempTime="fasle";
		int gioid=0;
		GinoutstockdetailSearchCondImpl cond1 = new GinoutstockdetailSearchCondImpl();
		cond1.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		cond1.setGiodcategory(IGLOMCONSTANTS.ST_SEARCH_TYPE);
		cond1.setGiotime_f(date+"/01");
		cond1.setGiotime_t(date+"/31");
		List<Ginoutstockdetail> resList = this.ginoutstockdetailBL.searchGinoutstockdetail(cond1, 0, 0);
		List<String> codelist = new ArrayList<String>();
		String temp;
		for(Ginoutstockdetail giod:resList){
			boolean flag = true;
			
			for(String code:codelist){
				temp=giod.getGiodname()+"-"+giod.getGiodcode();
				if(temp.equals(code)){
					flag = false;
					break;
				}
			}
			if(flag){
				codelist.add(giod.getGiodname()+"-"+giod.getGiodcode());
			}
		}
		
		
		for(String code:codelist){
			IGLOM05141VO vo = new IGLOM05141VO();
			int innum = 0;
			int outnum = 0;
			int nownum = 0;
			for(Ginoutstockdetail giod:resList){
				if((giod.getGiodname()+"-"+giod.getGiodcode()).equals(code)){
					if(tempTime.equals("fasle")){//���ʱ�仹û���ʼ��
						tempTime=giod.getGiodtime();
						gioid=giod.getGiodid();
						nownum=giod.getGsnum();
					}else{
						if(giod.getGiodtime().compareTo(tempTime)>0){//�����ǰ���ʱ�������һ����¼ʱ��
							tempTime=giod.getGiodtime();
							gioid=giod.getGiodid();
							nownum=giod.getGsnum();
						}
						if(giod.getGiodtime().compareTo(tempTime)==0){//���ʱ�����
							if(giod.getGiodid()>gioid){//ʱ����ͬ����£������ǰ���id���ڼ�¼id����ôȥ����ֵ
								tempTime=giod.getGiodtime();
								gioid=giod.getGiodid();
								nownum=giod.getGsnum();
							}
						}
					}
					
					if(IGLOMCONSTANTS.GIODTYPE_RK.equals(giod.getGiodtype())){
						innum+=giod.getGiodinnum();
						
						
					}else if(IGLOMCONSTANTS.GIODTYPE_LY.equals(giod.getGiodtype())){
						outnum+=giod.getGiodinnum();
					}
				}else{
					nowcount = 0;//zui
					tempTime="fasle";
					gioid=0;
				}
			}
			
			vo.setInnum(String.valueOf(innum));
			vo.setOutnum(String.valueOf(outnum));
			vo.setNownum(String.valueOf(nownum));
			map.put(code, vo);
			incount+=innum;
			outcount+=outnum;
			nowcount+=nownum;
		}
		dto.setMap(map);
		dto.setInnum(String.valueOf(incount));
		dto.setOutnum(String.valueOf(outcount));
		dto.setNownum(String.valueOf(nowcount));
		
		log.debug("========���ͳ�Ʋ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ͳ����ϸ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchGoodsStockDetailAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========���ͳ����ϸ��ѯ����ʼ========");
		
		GoodsStockSearchCondImpl cond = new GoodsStockSearchCondImpl();
		IGLOM0514Form form = dto.getIglom0514Form();
		cond.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		cond.setEdate(form.getYear()+"/"+(form.getMonth().length()==2?form.getMonth():"0"+form.getMonth()));
		cond.setGoods(form.getGoods());
		cond.setFlag(form.getFlag());
		List<GoodsStock> goodsStockList=null;
		goodsStockList = this.goodsStockBL.searchGoodsStockDetail(cond, 0, 0);
		
		dto.setGoodsStockList(goodsStockList);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ͳ����ϸ��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ��һ��Ʒ���ͳ�Ʋ�ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchSingleGoodsStockAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========���ͳ�Ʋ�ѯ����ʼ========");
		
		SingleGoodsStockSearchCondImpl cond = new SingleGoodsStockSearchCondImpl();
		IGLOM0515Form form = dto.getIglom0515Form();
		cond.setGiodorg(IGLOMCONSTANTS.ST_ORGSYSCODING);
		cond.setGiodcategory(IGLOMCONSTANTS.ST_SEARCH_TYPE);
		cond.setGoods(form.getGoods());
		cond.setGiodcode(form.getGiodcode());
		cond.setEtime_from(form.getEtime_from());
		cond.setEtime_to(form.getEtime_to());
		List<SingleGoodsStock> singleGoodsStockList=null;
		if("report".equals(form.getEdate())){
			singleGoodsStockList = this.singleGoodsStockBL.searchSingleGoodsStock(cond, 0, 0);
		}else{
			List<SingleGoodsStock> totalCount = this.singleGoodsStockBL.getSearchCount(cond);
			int count = totalCount.size();
			if (count == 0) {
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			}
			PagingDTO pDto = dto.getPagingDto();
			//��ǰҳ��Ϣȡ��
			singleGoodsStockList = this.singleGoodsStockBL.searchSingleGoodsStock(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(count);
		}
		
		dto.setSingleGoodsStockList(singleGoodsStockList);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ͳ�Ʋ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * �Ϳ���Ϣ�Ǽ�
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO insertLunchCardAction(IGLOM05DTO dto) throws BLException {
		log.debug("========�Ϳ���Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0518Form form = dto.getIglom0518Form();
	
		//�ɱ���¼
		this.lunchCardBL.registLunchCard(dto.getIglom0518Form());
		
		dto.setIglom0518Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�Ϳ���Ϣ") );

		log.debug("========�Ϳ���Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �Ϳ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchLunchCardAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========�Ϳ���Ϣ��ѯ����ʼ========");
		
		//�ɱ���Ϣ��ѯ����ȡ�� 
		int totalCount = this.lunchCardBL.getSearchCount(dto.getLunchCardSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�Ϳ���Ϣ��ѯ���ݲ�����========");
			//ʳ�óɱ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ϳ���Ϣ��ѯ���ݼ�������========");
			//ʳ�óɱ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<ItemsCodesSt> lunchCardList = this.lunchCardBL.searchLunchCard(dto.getLunchCardSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setItemsCodesList(lunchCardList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ϳ���Ϣ��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ������_�Ϳ���Ϣ��ѯ
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchELunchCardAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========�Ϳ���Ϣ��ѯ����ʼ========");

		//��ǰҳ��Ϣȡ��
		List<ItemsCodesSt> lunchCardList = this.lunchCardBL.searchLunchCard(dto.getLunchCardSearchCond(), 0, 0);
		
		dto.setItemsCodesList(lunchCardList);
		
		log.debug("========�Ϳ���Ϣ��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * �Ϳ�״̬���Ĵ���
	 * 
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO changeLunchCardAction(IGLOM05DTO dto) throws BLException {
		log.debug("========�Ϳ�״̬���Ĵ���ʼ========");
		IGLOM0519Form form = dto.getIglom0519Form();
		
		ItemsCodesSt ics = this.lunchCardBL.searchLunchCardByKey(form.getIcid());

		ItemsCodesStTB icsTB = (ItemsCodesStTB)SerializationUtils.clone(ics);
		
		if(IGLOMCONSTANTS.GOODS_STATUS_ENABLE.equals(form.getDesc())) {
			icsTB.setDesc(IGLOMCONSTANTS.GOODS_STATUS_DISABLE);
			this.lunchCardBL.updateLunchCard(icsTB);
			dto.addMessage(new ActionMessage("IGLOM0519.I001") );
		}else{
			icsTB.setDesc(IGLOMCONSTANTS.GOODS_STATUS_ENABLE);
			this.lunchCardBL.updateLunchCard(icsTB);
			dto.addMessage(new ActionMessage("IGLOM0519.I001") );
		}
		log.debug("========�Ϳ�״̬���Ĵ�������========");
		return dto;
	}
	
	/**
	 * �Ϳ���Ϣ���������ʾ����
	 *
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO initLunchCardAction(IGLOM05DTO dto) throws BLException {

		log.debug("========�Ϳ���Ϣ������������ʾ����ʼ========");	
		IGLOM0518Form form = dto.getIglom0518Form();
		ItemsCodesSt ics = lunchCardBL.searchLunchCardByKey(form.getIcid());
		if ( ics == null ){
			throw new BLException("IGCO10000.E004","�Ϳ�");
		}
		
		//������ʾ�趨
		form.setIcid(ics.getIcid());
		form.setSelectid(ics.getSelectid());
		form.setPrince(ics.getType());
		form.setDesc(ics.getDesc());
		form.setTypename(ics.getTypename());
		form.setAllowance(ics.getTypecode());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0518Form(form);
		
		log.debug("========�Ϳ���Ϣ������������ʾ��������========");
		return dto;
	}
	
	/**
	 * �Ϳ���Ϣ�趨
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO updateLunchCardAction(IGLOM05DTO dto) throws BLException {
		
		log.debug("========�Ϳ���Ϣ�������ʼ========");
		
		//ʳ�ýӴ���Ϣ���
		this.lunchCardBL.updateLunchCard(dto.getItemsCodes());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�Ϳ���Ϣ") );

		log.debug("========�Ϳ���Ϣ�����������========");

		return dto;
	}
	/**
	 * 
	 * ʳ���д����Ż��ܲ�ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWAction(IGLOM05DTO dto) throws BLException{
		log.debug("========ʳ���д����Ż�����Ϣ��ѯ����ʼ========");

		//��ǰҳ��Ϣȡ��
		List<EEOrg> eeOrgList = this.eeOrgVWBL.searchEEOrgVW(dto.getEeOrgVWSearchCond(), 0, 0);
	
		dto.setEeOrgVWList(eeOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("=========ʳ���д����Ż�����Ϣ��ѯ����ʼ========");
		return dto;
	}
	/**
	 * 
	 * ʳ���д����Ż�����ϸ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchEEOrgVWDetail(IGLOM05DTO dto) throws BLException{
		log.debug("========ʳ���д����Ż�����ϸ��Ϣ��ѯ����ʼ========");

		//��ǰҳ��Ϣȡ��
		List<Eentertainment> eeOrgList = this.eeOrgVWBL.searchEEOrgVWDetail(dto.getEeSearchCond(), 0, 0);
	
		dto.setEentertainmentList(eeOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("=========ʳ���д����Ż�����ϸ��Ϣ��ѯ����ʼ========");
		return dto;
	}
	
	/**
	 * 
	 * ʳ����Ʒ������ϸ��ѯ
	 * @param dto IGLOM05DTO
	 * @return IGLOM05DTO
	 */
	public IGLOM05DTO searchGoutDetailInfo(IGLOM05DTO dto) throws BLException{
		log.debug("========ʳ����Ʒ������ϸ��Ϣ��ѯ����ʼ========");

		//ʳ��������ϸ��ѯ 

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��Ϣȡ��
		List<GoutDetailInfo> goutDetailInfoList = this.ginoutstockdetailBL.getGoutDetailInfo(dto.getGoutDetailSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
	     List<GoutDetailInfo> tempList=this.ginoutstockdetailBL.getGoutDetailInfo(dto.getGoutDetailSearchCond(), 0,0);
	     if(tempList!=null){
	    	 int totalCount=tempList.size();
	    	 if (totalCount == 0) {
	 			log.debug("========ʳ����Ʒ������ϸ��Ϣ������========");
	 			//ʳ�ù�������Ϣ��ѯ���ݲ�����
	 			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
	 			return dto;
	 		} 
	 		if ( totalCount > dto.getMaxSearchCount() ) {
	 			log.debug("========ʳ����Ʒ������ϸ��Ϣ��ѯ���ݼ�������========");
	 			//ʳ�ù�������Ϣ��ѯ���ݼ�������
	 			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
	 			return dto;
	 		}
	 		pDto.setTotalCount(totalCount);

			
	     }
	     dto.setGoutDetailInfoList(goutDetailInfoList);
			
	     dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		
		
		log.debug("=========ʳ����Ʒ������ϸ��Ϣ��ѯ����ʼ========");
		return dto;
	}
	public EEOrgVWBL getEeOrgVWBL() {
		return eeOrgVWBL;
	}

	public void setEeOrgVWBL(EEOrgVWBL eeOrgVWBL) {
		this.eeOrgVWBL = eeOrgVWBL;
	}
}
