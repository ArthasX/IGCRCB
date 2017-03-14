/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM07BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM08BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM09BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0202Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;
import com.deliverik.infogovernor.util.CodeDefine;


/**
 * ����ģ�������
 * @author wangxing
 */
public class IGALM02BLImpl extends BaseBLImpl implements IGALM02BL {
	
	static Log log = LogFactory.getLog(IGALM02BLImpl.class);
	
	protected CRM07BL crm07BL;//����������
	
	protected CRM08BL crm08BL;//����ģ�������
	
	protected CRM09BL crm09BL;//����ģ���ϵ������
	
	protected CodeDetailBL	codeDetailBL;

	public void setCrm07BL(CRM07BL crm07BL) {
		this.crm07BL = crm07BL;
	}

	public void setCrm08BL(CRM08BL crm08BL) {
		this.crm08BL = crm08BL;
	}

	public void setCrm09BL(CRM09BL crm09BL) {
		this.crm09BL = crm09BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}


	public IGALM02DTO insertRuleTempAndCondition(IGALM02DTO dto) throws BLException{
		
		IGALM0201Form form = dto.getIgalm0201Form();
		
		/** ע�����ģ�� */
		CRM08TB ruleTempBean = new CRM08TB();
		ruleTempBean.setRuletempname(form.getRuletempname());
		String ccid = form.getCategoryid().split("#")[0];
		String cid = form.getCategoryid().split("#")[1];
		ruleTempBean.setTypeccid(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		ruleTempBean.setTypecid(form.getTypeid());
		ruleTempBean.setCategoryccid(ccid);
		ruleTempBean.setCategorycid(cid);
		ruleTempBean.setRulecondition(Integer.parseInt(form.getRulecondition()));
		ruleTempBean.setTempstate(Integer.parseInt(form.getTempstate()));
		ruleTempBean.setDetail(form.getTempdesc());
		ruleTempBean.setAlarmlevel(Integer.parseInt(form.getLevel()));
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ruleTempBean.setCreatetime(format.format(new Date()));
		CRM08Info info = crm08BL.registCRM08(ruleTempBean);
		
		/** ע��ģ������ */
		String[] conditions = form.getAlarmconditions();
		for(int i=0;i<conditions.length;i++){
			CRM07TB ruleConditionBean = new CRM07TB();
			ruleConditionBean.setRuletempid(info.getRuletempid());
			ruleConditionBean.setAlarmmsg(form.getAlarmmsgs()[i]);
			ruleConditionBean.setAlarmcondition(Integer.parseInt(conditions[i]));
			ruleConditionBean.setCreatetime(format.format(new Date()));
			crm07BL.registCRM07(ruleConditionBean);
		}
		return dto;
	}

	/**
	 * ��ѯ�������
	 */
	public IGALM02DTO searchMonitorType(IGALM02DTO dto) throws BLException {
		log.debug("========��ѯ������Ϳ�ʼ========");
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond, 0);
		List<LabelValueBean> monitorTypeList=new ArrayList<LabelValueBean>();
		monitorTypeList.add(new LabelValueBean("",""));
		for (int i = 0; i < codeDetailList.size(); i++) {
			CodeDetail codeDetail = codeDetailList.get(i);
			String cvalue = codeDetail.getCvalue();
			String cid = codeDetail.getCid();
			monitorTypeList.add(new LabelValueBean(cvalue,cid));
		}
		dto.setMonitorTypeList(monitorTypeList);
		log.debug("========��ѯ������ͽ���========");
		return dto;
	}

	/**
	 * ��ѯ����ģ��
	 */
	public IGALM02DTO searchRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========��ѯ����ģ�忪ʼ========");
		IGALM0202Form form = dto.getIgalm0202Form();
		String ruletempname = form.getRuletempname_like();//ģ����
		Integer tempstate = form.getTempstate_eq();//ģ��״̬
		//ģ��״̬ ,0:ͣ��,1:����,2:ȫ��
		if(tempstate==2){
			tempstate=null;
		}
		String typecid = form.getTypecid();//ģ������
		CRM08SearchCondImpl cond=new CRM08SearchCondImpl();
		cond.setRuletempname(ruletempname);
		cond.setTempstate(tempstate);
		cond.setTypeccid_eq(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		cond.setTypecid_eq(typecid);
		
		int totalCount = crm08BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========����ģ�岻����========");
			//����ģ�岻����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========����ģ���������========");
			//����ģ���������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<CRM08Info> crm08InfoList = crm08BL.searchCRM08(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setCrm08InfoList(crm08InfoList);
		
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ѯ����ģ�����========");
		return dto;
	}

	/**
	 * ɾ������ģ��
	 */
	public IGALM02DTO deleteRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========ģ��ɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteId().length;i++ ){
			int ruletempid = Integer.parseInt(dto.getDeleteId()[i]);//����
			CRM08Info crm08Info = crm08BL.searchCRM08ByPK(ruletempid);
			int tempstate = crm08Info.getTempstate();//ģ��״̬ ,0:ͣ��,1:����
			//����״̬��ģ�岻��ɾ��
			if(tempstate==1){
				dto.addMessage(new ActionMessage("IGALM0202.I001",""));
				continue;
			}
			
			//ɾ��ģ��
			crm08BL.deleteCRM08ByPK(ruletempid);
			
			//ɾ��ģ���������
			CRM07SearchCondImpl crm07cond=new CRM07SearchCondImpl();
			crm07cond.setRuletempid(ruletempid);
			List<CRM07Info> crm07InfoList = crm07BL.searchCRM07(crm07cond);
			for (CRM07Info info : crm07InfoList) {
				crm07BL.deleteCRM07(info);
			}
			
			//ɾ��ģ���ϵ
			CRM09SearchCondImpl crm09cond=new CRM09SearchCondImpl();
			crm09cond.setRuletempid_eq(ruletempid);
			List<CRM09Info> crm09InfoList = crm09BL.searchCRM09(crm09cond);
			for (CRM09Info info : crm09InfoList) {
				crm09BL.deleteCRM09(info);
			}
		}
		log.debug("========ģ��ɾ���������========");
		return dto;
	}

	/**
	 * ����ģ���޸�ҳ���ʼ��
	 */
	public IGALM02DTO initRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========����ģ���޸�ҳ���ʼ����ʼ========");
		IGALM0201Form form = dto.getIgalm0201Form();
		String ruletempid = form.getRuletempid();
		CRM08Info crm08Info = crm08BL.searchCRM08ByPK(Integer.parseInt(ruletempid));
		form.setRuletempname(crm08Info.getRuletempname());
		form.setTypeid(crm08Info.getTypecid());
		form.setCategoryid(crm08Info.getCategoryccid()+"#"+crm08Info.getCategorycid());
		form.setRulecondition(crm08Info.getRulecondition().toString());
		form.setTempstate(crm08Info.getTempstate().toString());
		form.setLevel(crm08Info.getAlarmlevel().toString());
		form.setTempdesc(crm08Info.getDetail());
		List<CRM07TB> crm07TBList = crm08Info.getCrm07TBList();
		dto.setCrm07TBList(crm07TBList);
		//��ѯ���ָ��
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.PERF_MONITOR_CATEGORY.getCcid());
		cond.setPcid(crm08Info.getTypecid());
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		List<LabelValueBean> monitorIndexList=new ArrayList<LabelValueBean>();
		monitorIndexList.add(new LabelValueBean("",""));
		for (int i = 0; i < codeDetailList.size(); i++) {
			CodeDetail codeDetail = codeDetailList.get(i);
			String cvalue = codeDetail.getCvalue();
			String ccid = codeDetail.getCcid();
			String cid = codeDetail.getCid();
			String categoryid=ccid+"#"+cid;
			monitorIndexList.add(new LabelValueBean(cvalue,categoryid));
		}
		dto.setMonitorIndexList(monitorIndexList);
		log.debug("========����ģ���޸�ҳ���ʼ������========");
		return dto;
	}

	/**
	 * ����ģ���޸�
	 */
	public IGALM02DTO updateRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========����ģ���޸Ŀ�ʼ========");
		IGALM0201Form form = dto.getIgalm0201Form();
		String ruletempid = form.getRuletempid();
		CRM08TB ruleTempBean = (CRM08TB) crm08BL.searchCRM08ByPK(Integer.parseInt(ruletempid));
		
		/** �޸Ĺ���ģ�� */
		ruleTempBean.setRuletempname(form.getRuletempname());
		String ccid = form.getCategoryid().split("#")[0];
		String cid = form.getCategoryid().split("#")[1];
		ruleTempBean.setTypeccid(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		ruleTempBean.setTypecid(form.getTypeid());
		ruleTempBean.setCategoryccid(ccid);
		ruleTempBean.setCategorycid(cid);
		ruleTempBean.setRulecondition(Integer.parseInt(form.getRulecondition()));
		ruleTempBean.setTempstate(Integer.parseInt(form.getTempstate()));
		ruleTempBean.setDetail(form.getTempdesc());
		ruleTempBean.setAlarmlevel(Integer.parseInt(form.getLevel()));
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ruleTempBean.setCreatetime(format.format(new Date()));
		CRM08Info info = crm08BL.updateCRM08(ruleTempBean);
		
		/** ģ��������ɾ����ע�� */
		List<CRM07TB> crm07TBList = ruleTempBean.getCrm07TBList();
		if(crm07TBList!=null){
			for (CRM07TB crm07tb : crm07TBList) {
				crm07BL.deleteCRM07(crm07tb);
			}
		}
		
		String[] conditions = form.getAlarmconditions();
		for(int i=0;i<conditions.length;i++){
			CRM07TB ruleConditionBean = new CRM07TB();
			ruleConditionBean.setRuletempid(info.getRuletempid());
			ruleConditionBean.setAlarmmsg(form.getAlarmmsgs()[i]);
			ruleConditionBean.setAlarmcondition(Integer.parseInt(conditions[i]));
			ruleConditionBean.setCreatetime(format.format(new Date()));
			crm07BL.registCRM07(ruleConditionBean);
		}
		log.debug("========����ģ���޸Ľ���========");
		return dto;
	}

	/**
	 * ����ģ��״̬�޸� 
	 */
	public IGALM02DTO updateRuleTempState(IGALM02DTO dto) throws BLException {
		log.debug("========����ģ��״̬�޸Ŀ�ʼ========");
		IGALM0202Form form = dto.getIgalm0202Form();
		Integer ruletempid = form.getRuletempid();
		Integer tempstate = form.getTempstate();
		CRM08TB crm08TB = (CRM08TB) crm08BL.searchCRM08ByPK(ruletempid);
		crm08TB.setTempstate(tempstate);
		crm08BL.updateCRM08(crm08TB);
		log.debug("========����ģ��״̬�޸Ľ���========");
		return dto;
	}
	
}
