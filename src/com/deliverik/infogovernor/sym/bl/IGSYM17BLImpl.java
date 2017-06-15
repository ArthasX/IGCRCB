/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG105TB;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ����: ���̲����趨ҵ���߼�ʵ��
 * �������������̲����趨ҵ���߼�ʵ��
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public class IGSYM17BLImpl extends BaseBLImpl implements IGSYM17BL {

	static Log log = LogFactory.getLog(IGSYM17BLImpl.class);
	
	/** �ָ��� */
	protected final static String split = "#";
	
	/** ���̶�����ϢBL */
	protected IG380BL ig380BL;
	
	/** ����״̬��ϢBL */
	protected IG333BL ig333BL;
	
	/** ����ģ����ϢBL */
	protected IG259BL ig259BL;
	
	/** ���̲�����ϢBL */
	protected IG105BL ig105BL;
	
	/** ����������ϢBL */
	protected CodeListUtils codeListUtils;
	
	/**
	 * ����������ϢBL�趨
	 * 
	 * @param codeListUtils����������ϢBL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	
	/**
	 * ���̶�����ϢBL�趨
	 * 
	 * @param ig380BL���̶�����ϢBL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * ����״̬��ϢBL�趨
	 * 
	 * @param ig333BL����״̬��ϢBL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}
	
	/**
	 * ����ģ����ϢBL�趨
	 * @param processTemplateBL����ģ����ϢBL
	 */
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}
	
	/**
	 * ���̲�����ϢBL�趨
	 * @param processStrategyDefBL���̲�����ϢBL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}
	
	/**
	 * ���ܣ����̶�����Ϣ��ѯ����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchProcessDefinitionAction(IGSYM17DTO dto) throws BLException {
		
		log.debug("========���̶�����Ϣ��ѯ����ʼ========");
		
		IGSYM1701Form form = dto.getIgSYM1701Form();
		
		//�����ѯ����
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		
		String[] pttype_str = form.getPttype().split("_");
		
		Integer[] pttype_int = new Integer[pttype_str.length];
		
		//�ַ�����ת������������
		for(int i = 0; i < pttype_str.length; i++) {
			pttype_int[i] = new Integer(pttype_str[i]);
		}
		//����ģ��ID����
		cond.setPrTypeArray(pttype_int);
		
		String[] ptstatuses = new String[2];
		ptstatuses[0] = "a";//����
		ptstatuses[1] = "t";//����
		cond.setPdstatuses(ptstatuses);
		
		//���̶�����Ϣ��ѯ����ȡ�� 
		int totalCount = this.ig380BL.getIG380InfoSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========���̶�����Ϣ��ѯ���ݲ�����========");
			//���̶�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���̶�����Ϣ��ѯ���ݼ�������========");
			//���̶�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ���̶�����Ϣȡ��
		List<IG380Info> processDefinitionList = this.ig380BL.searchIG380Info(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setProcessDefinitionList(processDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���̶�����Ϣ��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ܣ����̲����趨��ѯ����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO initIGSYM1702Action(IGSYM17DTO dto) throws BLException {
		
		log.debug("========���̲����趨��ѯ����ʼ========");
		
		IGSYM1702Form form = dto.getIgSYM1702Form();
		
		//��ȡ����������Ϣ
		dto.setProcessDefinition(this.ig380BL.searchIG380InfoByKey(form.getPdid()));
		
		//�������̲���Map
		Map<String, String> strategyMap = new LinkedHashMap<String, String>();
		
		dto = this.searchPrstatusList(dto);
		
		dto.setMaxPsdversion(this.ig105BL.getMaxgPsdversion(form.getPdid()));//��ǰ�������汾��
		
		List<IG105Info> processStrategyDefList = null;
		
		//�жϲ����Ƿ���ڰ汾
		if(dto.getMaxPsdversion() != null && dto.getMaxPsdversion() > 0) {
			//��ѯָ�����̶���ID��ǰ���Լ���
			IG105SearchCondImpl processStrategyDefCond = new IG105SearchCondImpl();
			
			processStrategyDefCond.setPdid(form.getPdid());//���̶���ID
			
			//�趨��ǰ��ѡ��Ĳ��԰汾��
			if(form.getPsdversion() != null && form.getPsdversion() > 0) {
				processStrategyDefCond.setPsdversion(form.getPsdversion());//�����ʷ�汾��
			} else {
				processStrategyDefCond.setPsdversion(dto.getMaxPsdversion());//��������б���ѯ���汾
				form.setPsdversion(dto.getMaxPsdversion());
			}
			
			processStrategyDefList  = this.ig105BL.searchIG105Info(processStrategyDefCond, 0, 0);
			
		} else {
			processStrategyDefList = new ArrayList<IG105Info>();
		}
		
		//�ж�����״̬�Ƿ��������ӵ�״̬
		boolean flag = true;
		
		//������̲���Map���ѵ�ǰ����״̬Ϊ��׼
		for(LabelValueBean bean : dto.getPrstatusList()) {//����״̬����
			
			for(IG105Info processStrategyDef : processStrategyDefList) {//��ǰ���Լ���
				//״̬������趨��Ԥ�ڽ��ʱ��
				if(bean.getValue().equals(processStrategyDef.getPrstatus()) 
						&& (processStrategyDef.getExpecttime() != null && processStrategyDef.getExpecttime() > 0)) {
					//��״̬���趨���ԣ��趨Ԥ�ڽ��ʱ�䡣key��״̬ + split + �����̶ȣ�������֮ǰ����Ľ����ȱ�ɾ�������
					strategyMap.put(bean.getValue() + split + processStrategyDef.getPrurgency(), processStrategyDef.getExpecttime().toString());
					flag = false;
				}
			}
			if(flag){
				for(LabelValueBean prurgency : dto.getPrurgencyList()) {
					//�����ӵ�״̬���趨Ԥ�ڽ��ʱ��Ϊ��
					strategyMap.put(bean.getValue() + split + prurgency.getValue(), null);
				}
			}
		}
		
		dto.setStrategyMap(strategyMap);
		
		log.debug("========���̲����趨��ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ܣ����̲����趨�༭����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO editIGSYM1702Action(IGSYM17DTO dto) throws BLException {
		
		log.debug("========���̲����趨�༭����ʼ========");
		
		IGSYM1702Form form = dto.getIgSYM1702Form();
		
		//��ȡ��ǰ�������汾
		Integer version = this.ig105BL.getMaxgPsdversion(form.getPdid()) + 1;
		
		//��ȡ��ǰʱ��
		String datatime = IGStringUtils.getCurrentDateTime();
		
		//��ȡ���̲���Map
		Map<String,String> strategyMap = form.getStrategyMap();
		
		Set<Map.Entry<String,String>> set = strategyMap.entrySet();
		
		//���������¼
		for(Iterator<Map.Entry<String,String>> iter = set.iterator(); iter.hasNext();){
			
			Map.Entry<String,String> entry = iter.next();
			
			IG105TB psdTB = new IG105TB();
			
			psdTB.setPdid(form.getPdid());//���̶���ID

			psdTB.setPrstatus(entry.getKey().split(split)[0]);//����״̬

			psdTB.setPrurgency(entry.getKey().split(split)[1]);//�����̶�
			
			psdTB.setPsdversion(version);//���԰汾

			if(StringUtils.isNotEmpty(entry.getValue())) {
				psdTB.setExpecttime(Double.parseDouble(entry.getValue()));//�������ʱ��
			}

			psdTB.setCreatetime(datatime);//���Դ���ʱ��
			
			//�������
			this.ig105BL.registIG105Info(psdTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "���̲�����Ϣ����") );
		
		log.debug("========���̲����趨�༭��������========");
		
		return dto;
	}
	
	/**
	 * ���ܣ�����״̬�б�ͽ����̶Ȳ�ѯ����
	 * 		�Զ������̴�ProcessStatusDef�в�ѯ
	 * 		�������̴�CodeDetail�в�ѯ
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchPrstatusList(IGSYM17DTO dto) throws BLException {
		
		log.debug("========����״̬�б�ͽ����̶Ȳ�ѯ����ʼ========");
		
		//��ȡ����ģ��ID
		Integer ptid = dto.getIgSYM1702Form().getPtid();
		
		//��������״̬�б�
		List<LabelValueBean> prstatusList = null;
		
		//��ȡ��ǰ�������ͽ����̶�
		List<LabelValueBean> prurgencyList = null;
		
		//�����¼�,����,���
		if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_I.equals(ptid)) {
			prstatusList = this.searchPrstatusList(IGPROCESSType.INCIDENT_PRTYPE);
			prurgencyList = this.searchPrurgencyList("PROCESS_PRIORITY_I");
		} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_P.equals(ptid)){
			prstatusList = this.searchPrstatusList(IGPROCESSType.PROBLEM_PRTYPE);
			prurgencyList = this.searchPrurgencyList("PURGENCY_GRADE_CODE");
		} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_C.equals(ptid)){
			prstatusList = this.searchPrstatusList(IGPROCESSType.CHANGE_PRTYPE);
			prurgencyList = this.searchPrurgencyList("CURGENCY_GRADE_CODE");
		} else {//�Զ�������
			
			prurgencyList = this.searchPrurgencyList("WDURGENCY_GRADE_CODE");
			
			prstatusList = new ArrayList<LabelValueBean>();
			
			//��ѯָ�����̶���ID��ǰ״̬����
			IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
			
			processStatusDefCond.setPdid(dto.getIgSYM1702Form().getPdid());
			
			List<IG333Info> processStatusDefList  = this.ig333BL.searchIG333Info(processStatusDefCond);
			
			//���˷���״̬
			IG333Info psd = null;
			for(Iterator<IG333Info> iter = processStatusDefList.iterator(); iter.hasNext();) {
				psd = iter.next();
				if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode())) {
					iter.remove();
				} else {
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode())) {
						
						prstatusList.add(new LabelValueBean("����������ʱ", psd.getPsdcode()));//�������״̬�б�
					} else {
						prstatusList.add(new LabelValueBean(psd.getPsdname(), psd.getPsdcode()));//�������״̬�б�
					}
				}
			}
		}
		
		dto.setPrstatusList(prstatusList);
		
		dto.setPrurgencyList(prurgencyList);
		
		log.debug("========����״̬�б�ͽ����̶Ȳ�ѯ��������========");
		
		return dto;
	}
	
	/**
	 * ���ܣ���������״̬�б�
	 * 
	 * @param codeDefine String
	 * @return List<LabelValueBean>
	 */
	public List<LabelValueBean> searchPrstatusList(String codeDefine) throws BLException {
		List<LabelValueBean> prstatusList = codeListUtils.getCodeList(CodeDefine.getCodeDefine(
				codeDefine + "_STRATEGY_STATUS").getCcid(), null, null, false, false);
		if(prstatusList == null || prstatusList.size() == 0) {
			throw new BLException("IGCO10000.E004","���趨���Ե�״̬����");
		}
		LabelValueBean bean = null;
		//cid�������ʶ-����״̬���˴�valueȡ����״̬
		for(Iterator<LabelValueBean> iter = prstatusList.iterator(); iter.hasNext();) {
			bean = iter.next();
			bean.setValue(bean.getValue().split("-")[1]);
		}
		return prstatusList;
	}
	
	/**
	 * ���ܣ����̽������б�
	 * 
	 * @param codeDefine String
	 * @return List<LabelValueBean>
	 */
	public List<LabelValueBean> searchPrurgencyList(String codeDefine) throws BLException {
		
		List<LabelValueBean> prurgencyList = codeListUtils.getCodeList(CodeDefine.getCodeDefine(
				codeDefine).getCcid(), null, null, false, false);
		if(prurgencyList == null || prurgencyList.size() == 0) {
			throw new BLException("IGCO10000.E004","�����̶Ȼ���");
		}
		return prurgencyList;
	}
	
}
