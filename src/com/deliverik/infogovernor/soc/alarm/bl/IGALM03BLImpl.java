/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM06BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM08BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM09BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0301Form;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0302Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;
import com.deliverik.infogovernor.util.CodeDefine;


/**
 * 	监控对象控制类
 *	@author wangxing
 *	2013.08.01
 */
public class IGALM03BLImpl extends BaseBLImpl implements IGALM03BL {
	
	static Log log = LogFactory.getLog(IGALM03BLImpl.class);
	
	protected CRM06BL crm06BL;//监控对象BL
	
	protected CRM08BL crm08BL;//规则模板BL
	
	protected CRM09BL crm09BL;//监控对象与规则模板关系BL
	
	protected CodeDetailBL codeDetailBL;

	public void setCrm06BL(CRM06BL crm06BL) {
		this.crm06BL = crm06BL;
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

	/**
	 * 获取监控对象视图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO searchIGALM03Action(IGALM03DTO dto) throws BLException {
		//查询总数
		IGALM0301Form form = dto.getIgalm0301Form();
		CRM06SearchCondImpl cond = new CRM06SearchCondImpl();
		cond.setIp_like(form.getIp_like());
		cond.setServerName_like(form.getServername_like());
		cond.setFileid_eq(form.getFileid());
		int totalCount = crm06BL.getSearchVWCount(cond);
		if(totalCount==0){
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		pDto.setPageDispCount(12);
		
		//监控对象列表（视图）查询
		List<CRM06VWInfo> crm06InfoList = crm06BL.searchCRM06VW(cond, pDto.getFromCount(),pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setCrm06InfoList(crm06InfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * 修改监控对象状态，决定是否生成告警
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO changeStatus(IGALM03DTO dto) throws BLException {
		IGALM0301Form form = dto.getIgalm0301Form();
		String serverid = form.getServerid();
		String alarmstatus = form.getAlarmstatus();
		CRM06Info info = crm06BL.searchCRM06ByPK(Integer.parseInt(serverid));
		CRM06TB bean = (CRM06TB)SerializationUtils.clone(info);
		if("1".equals(alarmstatus)) bean.setAlarmstatus("0");
		if("0".equals(alarmstatus)) bean.setAlarmstatus("1");
		crm06BL.updateCRM06(bean);
		return dto;
	}

	/**
	 * 获取某类型下的所有规则
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO getRuleTemps(IGALM03DTO dto) throws BLException {
		IGALM0302Form form = dto.getIgalm0302Form();
		String serverType = form.getType();
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCvalue(serverType.trim());
		cond.setCcid(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		//通过类型名获取类型实体
		CodeDetail bean = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1).get(0);
		CRM08SearchCondImpl crm08cond = new CRM08SearchCondImpl();
		crm08cond.setTypecid_eq(bean.getCid());
		crm08cond.setTypeccid_eq(bean.getCcid());
		//该类型下的所有规则
		List<CRM08Info> ruleTempsTotal = crm08BL.searchCRM08(crm08cond);		
		
		String serverid = form.getServerid();
		CRM09SearchCondImpl crm09cond = new CRM09SearchCondImpl();
		crm09cond.setServerid_eq(serverid);
		List<CRM09Info> relations = crm09BL.searchCRM09(crm09cond);
		List<Integer> rutempids = new ArrayList<Integer>();
		for(CRM09Info info:relations){
			rutempids.add(info.getRuletempid());
		}
		if(rutempids.size() != 0){//如果该对象拥有至少一个规则
			crm08cond = new CRM08SearchCondImpl();
			crm08cond.setRuletempids(rutempids);
			//该监控对象所拥有的规则
			List<CRM08Info> ruleTemps = crm08BL.searchCRM08(crm08cond);
			dto.setRuleTemps(ruleTemps);
		
			//该对象还未拥有的规则
			List<CRM08Info> ruleTempsNeed = new ArrayList<CRM08Info>();
			index:
			for(int i=0;i<ruleTempsTotal.size();i++){
				CRM08Info currentTemp = ruleTempsTotal.get(i);
				for(int j=0;j<ruleTemps.size();j++){
					if(currentTemp.getRuletempid().equals(ruleTemps.get(j).getRuletempid())) 
						continue index;
				}
				ruleTempsNeed.add(currentTemp);
			}
			dto.setRuleTempsNeed(ruleTempsNeed);
		}else{//如果该对象还没有配置过规则
			dto.setRuleTempsNeed(ruleTempsTotal);
		}
		
		return dto;
	}
	
	/**
	 * 配置监控对象告警规则
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO insertRuleTemps(IGALM03DTO dto) throws BLException {
		
		IGALM0302Form form = dto.getIgalm0302Form();
		String serverid = form.getServerid();
		String maxalarmtime = form.getMaxalarmtime();
		String maxalarmnum = form.getMaxalarmnum();
		String[] ruletempids = form.getRuletempids();
		
		String ip = form.getIp();
		String ip2 = form.getIp2();
		CRM06Info crm06info = this.crm06BL.searchCRM06ByPK(Integer.parseInt(serverid));
		CRM06TB crm06bean = (CRM06TB) SerializationUtils.clone(crm06info);
		crm06bean.setIp(ip);
		crm06bean.setIp2(ip2);
		this.crm06BL.updateCRM06(crm06bean);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String now = format.format(new Date());
		
		/** 删除该server所有的规则模板 */
		CRM09SearchCondImpl cond = new CRM09SearchCondImpl();
		cond.setServerid_eq(serverid);
		List<CRM09Info> crm09List =  crm09BL.searchCRM09(cond);
		if(crm09List.size() != 0){
			for(CRM09Info info : crm09List){
				crm09BL.deleteCRM09(info);
			}
		}
		
		if(ruletempids == null || ruletempids.length == 0 || ruletempids[0].equals("null"))  return dto;
		
		/** 添加新的模板 */
		for(String ruletempid:ruletempids){
			
			CRM09TB bean = null;

			bean = new CRM09TB();
			bean.setServerid(Integer.parseInt(serverid));
			bean.setRuletempid(Integer.parseInt(ruletempid));
			if(StringUtils.isEmpty(maxalarmnum)) bean.setMaxalarmnum(0);
			else bean.setMaxalarmnum(Integer.parseInt(maxalarmnum));
			if(StringUtils.isEmpty(maxalarmtime)) bean.setMaxalarmtime(0);
			else bean.setMaxalarmtime(Integer.parseInt(maxalarmtime));
			bean.setCreatetime(now);
			crm09BL.registCRM09(bean);
		
		}
		return dto;
	}

	public IGALM03DTO getCRM09Info(IGALM03DTO dto) throws BLException {
		IGALM0302Form form = dto.getIgalm0302Form();
		String serverid = form.getServerid();
		CRM09Info bean = null;
		
		CRM09SearchCondImpl cond = new CRM09SearchCondImpl();
		cond.setServerid_eq(serverid);
		List<CRM09Info> infos = crm09BL.searchCRM09(cond);
		if(infos.size() != 0) bean = infos.get(0);
		else bean = new CRM09TB();
		dto.setCrm09Info(bean);
		
		return dto;
	}
	
}
