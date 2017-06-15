/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * 	��ض��������
 *	@author wangxing
 *	2013.08.01
 */
public class IGALM03BLImpl extends BaseBLImpl implements IGALM03BL {
	
	static Log log = LogFactory.getLog(IGALM03BLImpl.class);
	
	protected CRM06BL crm06BL;//��ض���BL
	
	protected CRM08BL crm08BL;//����ģ��BL
	
	protected CRM09BL crm09BL;//��ض��������ģ���ϵBL
	
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
	 * ��ȡ��ض�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO searchIGALM03Action(IGALM03DTO dto) throws BLException {
		//��ѯ����
		IGALM0301Form form = dto.getIgalm0301Form();
		CRM06SearchCondImpl cond = new CRM06SearchCondImpl();
		cond.setIp_like(form.getIp_like());
		cond.setServerName_like(form.getServername_like());
		cond.setFileid_eq(form.getFileid());
		int totalCount = crm06BL.getSearchVWCount(cond);
		if(totalCount==0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		pDto.setPageDispCount(12);
		
		//��ض����б���ͼ����ѯ
		List<CRM06VWInfo> crm06InfoList = crm06BL.searchCRM06VW(cond, pDto.getFromCount(),pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setCrm06InfoList(crm06InfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * �޸ļ�ض���״̬�������Ƿ����ɸ澯
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
	 * ��ȡĳ�����µ����й���
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
		//ͨ����������ȡ����ʵ��
		CodeDetail bean = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1).get(0);
		CRM08SearchCondImpl crm08cond = new CRM08SearchCondImpl();
		crm08cond.setTypecid_eq(bean.getCid());
		crm08cond.setTypeccid_eq(bean.getCcid());
		//�������µ����й���
		List<CRM08Info> ruleTempsTotal = crm08BL.searchCRM08(crm08cond);		
		
		String serverid = form.getServerid();
		CRM09SearchCondImpl crm09cond = new CRM09SearchCondImpl();
		crm09cond.setServerid_eq(serverid);
		List<CRM09Info> relations = crm09BL.searchCRM09(crm09cond);
		List<Integer> rutempids = new ArrayList<Integer>();
		for(CRM09Info info:relations){
			rutempids.add(info.getRuletempid());
		}
		if(rutempids.size() != 0){//����ö���ӵ������һ������
			crm08cond = new CRM08SearchCondImpl();
			crm08cond.setRuletempids(rutempids);
			//�ü�ض�����ӵ�еĹ���
			List<CRM08Info> ruleTemps = crm08BL.searchCRM08(crm08cond);
			dto.setRuleTemps(ruleTemps);
		
			//�ö���δӵ�еĹ���
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
		}else{//����ö���û�����ù�����
			dto.setRuleTempsNeed(ruleTempsTotal);
		}
		
		return dto;
	}
	
	/**
	 * ���ü�ض���澯����
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
		
		/** ɾ����server���еĹ���ģ�� */
		CRM09SearchCondImpl cond = new CRM09SearchCondImpl();
		cond.setServerid_eq(serverid);
		List<CRM09Info> crm09List =  crm09BL.searchCRM09(cond);
		if(crm09List.size() != 0){
			for(CRM09Info info : crm09List){
				crm09BL.deleteCRM09(info);
			}
		}
		
		if(ruletempids == null || ruletempids.length == 0 || ruletempids[0].equals("null"))  return dto;
		
		/** ����µ�ģ�� */
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
