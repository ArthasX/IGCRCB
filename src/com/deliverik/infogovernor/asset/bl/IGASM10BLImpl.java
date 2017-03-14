package com.deliverik.infogovernor.asset.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG313BL;
import com.deliverik.framework.asset.bl.task.IG545BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;
import com.deliverik.infogovernor.asset.form.IGASM1004Form;

/**
 * ����ͳ��ҵ���߼�ʵ��
 *
 */
public class IGASM10BLImpl extends BaseBLImpl implements IGASM10BL {

	static Log log = LogFactory.getLog(IGASM10BLImpl.class);

	/** �ʲ���ϢBL */
	protected IG117BL ig117BL;

	/** �ʲ�������BL */
	protected IG800BL ig800BL;
	
	/** ��������ͼBL */
	protected IG013BL ig013BL;
	
	/** �������ϵBL */
	protected IG313BL ig313BL;
	
	/** �ʲ�������ϢBL */
	protected IG225BL ig225BL;
	
	/** �ʲ���������BL */
	protected IG545BL ig545BL;
	
	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;
	
	/** �ʲ�������ϢBL */
	protected SOC0109BL soc0109BL;
	protected SOC0107BL soc0107BL;
	protected SOC0118BL soc0118BL;
	protected SOC0119BL soc0119BL;
	
	

	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}


	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}


	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}


	public void setIg545BL(
			IG545BL ig545BL) {
		this.ig545BL = ig545BL;
	}


	public void setIg225BL(IG225BL ig225BL) {
		this.ig225BL = ig225BL;
	}
	
	
	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}
	
	public void setIg800BL(IG800BL ig800BL) {
		this.ig800BL = ig800BL;
	}

	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setIg313BL(
			IG313BL ig313BL) {
		this.ig313BL = ig313BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	/**
	 * <p>
	 * ��ѯ�ʲ�ģ������
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGASM01DTO searchConfigurationsByEntity(IGASM01DTO dto) throws BLException{
		log.debug("========��ѯ�ʲ�ģ�����Կ�ʼ========");
		
		//�ʲ�������Ϣ��ѯ����ȡ�� 
		List<SOC0117Info> list = this.soc0117BL.getParentNodesByEsyscoding(dto.getEsyscoding());
		
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCseq(1);
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
			map.put(e.getEname(), configurationList);
			
		}

		dto.setConfigurationMap(map);
		log.debug("========��ѯ�ʲ�ģ�����Խ���========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ʲ�ģ�����Զ�Ӧ��ȡֵ��Χ����
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public List<LabelValueBean> searchCcdvalueByCoption(String coption) throws BLException{
		log.debug("========��ѯȡֵ��Χ��ʼ========");
		
		//�ʲ�ģ�����Զ�Ӧ��ȡֵ��Χȡ�� 
		List<LabelValueBean> list = this.ig545BL.searchLabelValueBeanList(coption);
		log.debug("========��ѯȡֵ��Χ����========");
		
		return list;
	}

	/**
	 * ��������Ϣ��ѯ����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO searchEntityItemAction(IGASM10DTO dto) throws BLException {

		log.debug("========��������Ϣ��ѯ����ʼ========");
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getEntityItemVWSearchCond(), cond);
		int totalCount =this.soc0118BL.getEntityItemVWSearchCount(cond);
		//��������Ϣ��ѯ����ȡ�� 
//		int totalCount = this.ig013BL.getIG688InfoSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��������Ϣ��ѯ���ݲ�����========");
			//��������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��������Ϣ��ѯ���ݼ�������========");
			//��������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��������Ϣȡ��
//		List<IG688Info> entityItemVWInfoList = this.ig013BL.searchIG688Info(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<SOC0124Info> socEntityItemVWInfoList = this.soc0118BL.searchEntityItemVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setSocEntityItemVWInfoList(socEntityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������������Ϣ��ϸ������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1004Action(IGASM10DTO dto) throws BLException {

		log.debug("========������������Ϣ�༭������ڻ�����ʼ========");
		
		IGASM1004Form form = dto.getIgasm1004Form();
		
		//��������Ϣ����
		SOC0124Info socEntityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
				
		
		if ( socEntityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		dto.setSocEntityItemVWInfo(socEntityItemVWInfo);
		form.setEsyscoding_q(socEntityItemVWInfo.getEsyscoding());
//		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
//		Boolean flag = this.ig013BL.checkIG688InfoDomain(dto.getUser(), entityItemVWInfo);
//		this.soc0118BL.
//
//		if(!flag) {
//			dto.addMessage(new ActionMessage("IGCO10000.E022"));
//			dto.setFlag(flag);
//			return dto;
//		}else{
//			dto.setFlag(flag);
//		}
		
		//������������Ϣȫ����ѯ
				SOC0129SearchCondImpl soc0129Cond = new SOC0129SearchCondImpl();
				soc0129Cond.setEiid(form.getEiid()+"");
				soc0129Cond.setEsyscoding_q(form.getEsyscoding_q());
				
		//������������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(soc0129Cond);
		
		if (totalCount == 0) {
			log.debug("========������������Ϣ��ѯ���ݲ�����========");
			//������������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������������Ϣ��ѯ���ݼ�������========");
			//������������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		
		List<SOC0129Info> socConfigItemVWInfoList = this.soc0107BL.searchConfigItemVW(soc0129Cond, 0, 0);
		
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		for(SOC0129Info e : socConfigItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
			}
			map.get(e.getCcategory()).add(e);
		}	
		dto.setSocConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========������������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * ������������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1005Action(IGASM10DTO dto) throws BLException {
		log.debug("========������������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//��������Ϣ����
		SOC0124Info socEntityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.valueOf(dto.getIgasm1005Form().getEiid()));
				
		
		if ( socEntityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		dto.setSocEntityItemVWInfo(socEntityItemVWInfo);
		
		
		if (socEntityItemVWInfo.getEiversion() == 0 && socEntityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		
		if ((dto.getIgasm1005Form().getCiversion())!=null) {
			dto.getIgasm1005Form().setCiversion(String.valueOf(socEntityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��		
		List<SOC0128Info> socConfigItemVersionTime = this.soc0118BL.searchVersionUpdateTime(dto.getIgasm1005Form().getEiid());
		
//		dto.setConfigItemVersionTime(this.ig013BL.searchVersionUpdateTime(dto.getIgasm1005Form().getEiid()));
		
		dto.setSocConfigItemVersionTime(socConfigItemVersionTime);
		
		log.debug("========������������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * �������ϵ��������ڻ�����
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1006Action(IGASM10DTO dto) throws BLException {
		log.debug("========�������ϵ��������ڻ�����ʼ========");
		
		//��������Ϣ����
		SOC0124Info socEntityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.valueOf(dto.getIgasm1006Form().getEiid()));
				
		
		if ( socEntityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","������");
		}
		
		dto.setSocEntityItemVWInfo(socEntityItemVWInfo);
		
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
//		Map<String,List<IG313Info>> parmap = new LinkedHashMap<String,List<IG313Info>>();
		//���������ϵ����
//		IG313SearchCondImpl parcond = new IG313SearchCondImpl();
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		
		
		parcond.setPareiid(Integer.parseInt(dto.getIgasm1006Form().getEiid()));
		parcond.setParversion(socEntityItemVWInfo.getEiversion());
		parcond.setParsmallversion(socEntityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		
		//�������ϵ��Ϣ��ѯ����ȡ�� 
//		int totalCount = this.ig313BL.getIG313InfoSearchCount(parcond);
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������ϵ��Ϣ��ѯ���ݼ�������========");
			//�������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//�������ϵ��Ϣȫ������
//		List<IG313Info> parEntityItemRelationList = this.ig313BL.searchMaxIG313Info(parcond);
		List<SOC0119Info> socParEntityItemRelationList = this.soc0119BL.searchMaxEntityItemRelation(parcond);
		dto.setParCount(socParEntityItemRelationList.size());
		for(SOC0119Info e : socParEntityItemRelationList){
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getParEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
				if(!parmap.containsKey(key)){
					parmap.put(key, new ArrayList<SOC0119Info>());
				}
				((IG313TB)e).setParflag("0");
				parmap.get(key).add(e);
			}
		
		dto.setSocParEntityItemRelationList(socParEntityItemRelationList);

		//���������ϵ����
		//������ϵ����
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		if((dto.getIgasm1006Form().getEiid())!=null){
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm1006Form().getEiid()));}
		cldcond.setCldversion(socEntityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(socEntityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//�������ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������ϵ��Ϣ��ѯ���ݼ�������========");
			//�������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//�������ϵ��Ϣȫ������
		List<SOC0119Info> socCldEntityItemRelationList = this.soc0119BL.searchMaxEntityItemRelation(cldcond);
//		this.ig313BL.searchMaxIG313Info(cldcond);
		
		dto.setParCount(dto.getParCount()+socCldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(SOC0119Info e : socCldEntityItemRelationList){
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!parmap.containsKey(key)){
				parmap.put(key, new ArrayList<SOC0119Info>());
			}
			((SOC0119TB)e).setParflag("1");
			parmap.get(key).add(e);
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setSocParEntityItemRelationMap(parmap);

		log.debug("========�������ϵ��������ڻ���������========");
		return dto;
	}
}
