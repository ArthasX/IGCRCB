/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 规则模板控制类
 * @author wangxing
 */
public class IGALM02BLImpl extends BaseBLImpl implements IGALM02BL {
	
	static Log log = LogFactory.getLog(IGALM02BLImpl.class);
	
	protected CRM07BL crm07BL;//条件控制类
	
	protected CRM08BL crm08BL;//规则模板控制类
	
	protected CRM09BL crm09BL;//规则模板关系控制类
	
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
		
		/** 注册规则模板 */
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
		
		/** 注册模板条件 */
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
	 * 查询监控类型
	 */
	public IGALM02DTO searchMonitorType(IGALM02DTO dto) throws BLException {
		log.debug("========查询监控类型开始========");
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
		log.debug("========查询监控类型结束========");
		return dto;
	}

	/**
	 * 查询规则模板
	 */
	public IGALM02DTO searchRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========查询规则模板开始========");
		IGALM0202Form form = dto.getIgalm0202Form();
		String ruletempname = form.getRuletempname_like();//模板名
		Integer tempstate = form.getTempstate_eq();//模板状态
		//模板状态 ,0:停用,1:可用,2:全部
		if(tempstate==2){
			tempstate=null;
		}
		String typecid = form.getTypecid();//模板类型
		CRM08SearchCondImpl cond=new CRM08SearchCondImpl();
		cond.setRuletempname(ruletempname);
		cond.setTempstate(tempstate);
		cond.setTypeccid_eq(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		cond.setTypecid_eq(typecid);
		
		int totalCount = crm08BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========规则模板不存在========");
			//规则模板不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========规则模板件数过多========");
			//规则模板件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<CRM08Info> crm08InfoList = crm08BL.searchCRM08(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setCrm08InfoList(crm08InfoList);
		
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========查询规则模板结束========");
		return dto;
	}

	/**
	 * 删除规则模板
	 */
	public IGALM02DTO deleteRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========模板删除处理开始========");
		//循环删除
		for( int i=0;i<dto.getDeleteId().length;i++ ){
			int ruletempid = Integer.parseInt(dto.getDeleteId()[i]);//主键
			CRM08Info crm08Info = crm08BL.searchCRM08ByPK(ruletempid);
			int tempstate = crm08Info.getTempstate();//模板状态 ,0:停用,1:可用
			//启用状态的模板不能删除
			if(tempstate==1){
				dto.addMessage(new ActionMessage("IGALM0202.I001",""));
				continue;
			}
			
			//删除模板
			crm08BL.deleteCRM08ByPK(ruletempid);
			
			//删除模板规则条件
			CRM07SearchCondImpl crm07cond=new CRM07SearchCondImpl();
			crm07cond.setRuletempid(ruletempid);
			List<CRM07Info> crm07InfoList = crm07BL.searchCRM07(crm07cond);
			for (CRM07Info info : crm07InfoList) {
				crm07BL.deleteCRM07(info);
			}
			
			//删除模板关系
			CRM09SearchCondImpl crm09cond=new CRM09SearchCondImpl();
			crm09cond.setRuletempid_eq(ruletempid);
			List<CRM09Info> crm09InfoList = crm09BL.searchCRM09(crm09cond);
			for (CRM09Info info : crm09InfoList) {
				crm09BL.deleteCRM09(info);
			}
		}
		log.debug("========模板删除处理结束========");
		return dto;
	}

	/**
	 * 规则模板修改页面初始化
	 */
	public IGALM02DTO initRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========规则模板修改页面初始化开始========");
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
		//查询监控指标
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
		log.debug("========规则模板修改页面初始化结束========");
		return dto;
	}

	/**
	 * 规则模板修改
	 */
	public IGALM02DTO updateRuleTemp(IGALM02DTO dto) throws BLException {
		log.debug("========规则模板修改开始========");
		IGALM0201Form form = dto.getIgalm0201Form();
		String ruletempid = form.getRuletempid();
		CRM08TB ruleTempBean = (CRM08TB) crm08BL.searchCRM08ByPK(Integer.parseInt(ruletempid));
		
		/** 修改规则模板 */
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
		
		/** 模板条件先删除再注册 */
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
		log.debug("========规则模板修改结束========");
		return dto;
	}

	/**
	 * 规则模板状态修改 
	 */
	public IGALM02DTO updateRuleTempState(IGALM02DTO dto) throws BLException {
		log.debug("========规则模板状态修改开始========");
		IGALM0202Form form = dto.getIgalm0202Form();
		Integer ruletempid = form.getRuletempid();
		Integer tempstate = form.getTempstate();
		CRM08TB crm08TB = (CRM08TB) crm08BL.searchCRM08ByPK(ruletempid);
		crm08TB.setTempstate(tempstate);
		crm08BL.updateCRM08(crm08TB);
		log.debug("========规则模板状态修改结束========");
		return dto;
	}
	
}
