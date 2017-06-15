/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00005BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00006BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00007BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0001Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0002Form;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �豸ʵʱ����ʷ��־�澯ҵ���߼�ʵ����
 * @author ��ʡ
 *
 */
public class IGLOG00BLImpl extends BaseBLImpl implements IGLOG00BL {

	static Log log = LogFactory.getLog(IGLOG00BLImpl.class);
	
	/** �澯��Ϣ���taskBL */
	protected Mss00005BL mss00005BL;
	
	/** �澯��Ϣ�±�taskBL */
	protected Mss00006BL mss00006BL;
	
	/** �澯��Ϣ��ʷ��taskBL */
	protected Mss00007BL mss00007BL;
	
	/** ���������ѯʱ��¼��ʼλ�� */
	protected static int fromCount;
	
	/** ���������ѯʱ��¼��ѯ��¼���� */
	protected static int pageDispCount;
	
	/** ��������taskBL */
	protected CodeDetailBL codeDetailBL;
	
    /** ���̱�����taskBL */
	protected IG599BL  ig599BL;
	
	
	
	/**
	 * ���̱�����taskBL�趨
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}
	
	public IGLOG00DTO searchSysLogAlarmListAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========�豸�澯��Ϣ��ѯ��ʼ========");
		IGLOG0001Form form = dto.getIglog0001Form();
		int totalCount = this.mss00005BL.getSearchCount(form);
		
		if(totalCount == 0){
			log.debug("========�豸�澯��Ϣ��ѯ���ݲ�����========");
			dto.setTotalcount(totalCount);
			return dto;
		}
		if(totalCount > dto.getMaxSearchCount()){
			log.debug("========������ѯ����¼��========");
			return dto;
		}
		List<Mss00005Info> sysLogAlarmList = this.mss00005BL.searchMss00005(form);
		dto.setSysLogAlarmList(sysLogAlarmList);
		dto.setTotalcount(totalCount);
		log.debug("========�豸�澯��Ϣ��ѯ����========");
		return dto;
	}


	public IGLOG00DTO searchHistorySysLogAlarmListAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ��ʼ========");
		List hisSysLogAlarmList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0002Form form = dto.getIglog0002Form();
		String timeFrom = form.getAlarmtime_from();//2013/01/01 09:54
		String timeTo = form.getAlarmtime_to();
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date beginDay = null;
		Date endDay = null;
		if(StringUtils.isNotEmpty(timeFrom)) {
			beginDay = format.parse(timeFrom);
		}
		if(StringUtils.isNotEmpty(timeTo)) {
			endDay = format.parse(timeTo); 
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		/** �����ʼ�ͽ���ʱ���Ϊ�� ���� ��ʼ�ͽ���ʱ�����3�����ڣ�ֱ�����±��ѯ */
		if((beginDay != null && endDay != null && getMonths(beginDay, today)<3 && getMonths(endDay, today)<3)){
			totalCount = this.mss00006BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
		/** �������ʱ����3����֮ǰ��֮ǰ��ֱ������ʷ���ѯ */
		}else if(endDay != null && getMonths(endDay, today)>2){
			totalCount = this.mss00007BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00007BL.searchMss00007(form,pDto.getFromCount(),pDto.getPageDispCount());
		}else{
			int mss00006Count = this.mss00006BL.getSearchCount(form);
			int mss00007Count = this.mss00007BL.getSearchCount(form);
			List<Mss00006Info> currentMonthSysLogAlarmList = new ArrayList<Mss00006Info>(); 
			List<Mss00007Info> historySysLogAlarmList = new ArrayList<Mss00007Info>(); 
			
			totalCount = mss00006Count + mss00007Count;
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			//��ʼ����+ȡ������(�Ȳ�06��)
			if(pDto.getFromCount()+pDto.getPageDispCount() <= mss00006Count){
				currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
			//06���07��ͬʱ��
			}else if(pDto.getFromCount() <= mss00006Count){
				fromCount = 0;
				currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
				pageDispCount = pDto.getPageDispCount() - (mss00006Count - pDto.getFromCount());
				historySysLogAlarmList = this.mss00007BL.searchMss00007(form,fromCount,pageDispCount);
				fromCount = pageDispCount;
			//06���Ѿ�����
			}else{
				historySysLogAlarmList = this.mss00007BL.searchMss00007(form,fromCount,pDto.getPageDispCount());
				fromCount = fromCount + pDto.getPageDispCount();
			}
			
			Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//ʹ��LinkedHashMap��֤���򲻱�����
			
			//��map����ת��������ֹ��ʷ����±������ظ��ĸ澯��¼
			if(currentMonthSysLogAlarmList.size()!=0){
				for(Mss00006Info info:currentMonthSysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			if(historySysLogAlarmList.size()!=0){
				for(Mss00007Info info:historySysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				Integer alarmid = (Integer) iterator.next();
				hisSysLogAlarmList.add(map.get(alarmid));
			}
		}
		pDto.setTotalCount(totalCount);
		dto.setHistorySysLogAlarmList(hisSysLogAlarmList);
		dto.setTotalcount(totalCount);
		
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ����========");
		return dto;
	}


	public IGLOG00DTO FixSysLogAlarmsAction(IGLOG00DTO dto) throws BLException,
			Exception {
		log.debug("========�豸��־�澯��Ϣ�޸���ʼ========");
		IGLOG0001Form form = dto.getIglog0001Form();
		List<Mss00005Info> sysLogAlarmList = this.mss00005BL.searchMss00005(form);
		for(Mss00005Info info:sysLogAlarmList){
//			Mss00006TB instance6 = this.mss00006BL.getMss00006TBInstance();
			Mss00005TB instance5 =(Mss00005TB)SerializationUtils.clone(info);
//			instance6.setAlarmid(info.getAlarmid());
//			instance6.setAlarmstate(1);//1:fixed 0:not fixed
			instance5.setAlarmstate(1);//1:fixed 0:not fixed
//			instance6.setAlarmtime(info.getAlarmtime());
//			instance6.setDeviceid(info.getDevceid());
//			instance6.setDeviceip(info.getDeviceip());
//			instance6.setDevicename(info.getDevicename());
//			instance6.setRuleconditionid(info.getRuleconditionid());
//			instance6.setRuleid(info.getRuleid());
//			instance6.setRulelevel(info.getRulelevel());
//			instance6.setSyslogmsg(info.getSyslogmsg());
//			instance6.setSyslogtime(info.getSyslogtime());
//			instance6.setSystime(new Date());//for trigger
			
//			this.mss00006BL.registMss00006(instance6);//insert into month-alerm
			this.mss00005BL.updateMss00005(instance5);//update day-alerm
		}
		log.debug("========�豸��־�澯��Ϣ�޸�����========");
		return dto;
	}

	public IGLOG00DTO searchHistorySysLogAlarmListNopageAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ��ʼ========");
		List hisSysLogAlarmList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0002Form form = dto.getIglog0002Form();
		String timeFrom = form.getAlarmtime_from();
		String timeTo = form.getAlarmtime_to();
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date beginDay = null;
		Date endDay = null;
		if(StringUtils.isNotEmpty(timeFrom)) {
			beginDay = format.parse(timeFrom);
		}
		if(StringUtils.isNotEmpty(timeTo)) {
			endDay = format.parse(timeTo); 
		}
		
		/** �����ʼ�ͽ���ʱ���Ϊ�� ���� ��ʼ�ͽ���ʱ�����3�����ڣ�ֱ�����±��ѯ */
		if((beginDay != null && endDay != null && getMonths(beginDay, today)<3 && getMonths(endDay, today)<3)){
			totalCount = this.mss00006BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00006BL.searchMss00006(form);
		/** �������ʱ����3����֮ǰ��֮ǰ��ֱ������ʷ���ѯ */
		}else if(endDay != null && getMonths(endDay, today)>2){
			totalCount = this.mss00007BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00007BL.searchMss00007(form);
		}else{
			int mss00006Count = this.mss00006BL.getSearchCount(form);
			int mss00007Count = this.mss00007BL.getSearchCount(form);
			List<Mss00006Info> currentMonthSysLogAlarmList = new ArrayList<Mss00006Info>(); 
			List<Mss00007Info> historySysLogAlarmList = new ArrayList<Mss00007Info>(); 
			
			totalCount = mss00006Count + mss00007Count;
			if(totalCount == 0){
				log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========������ѯ����¼��========");
				return dto;
			}
			currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form);
			historySysLogAlarmList = this.mss00007BL.searchMss00007(form);
			
			Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//ʹ��LinkedHashMap��֤���򲻱�����
			
			//��map����ת��������ֹ��ʷ����±������ظ��ĸ澯��¼
			if(currentMonthSysLogAlarmList.size()!=0){
				for(Mss00006Info info:currentMonthSysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			if(historySysLogAlarmList.size()!=0){
				for(Mss00007Info info:historySysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				Integer alarmid = (Integer) iterator.next();
				hisSysLogAlarmList.add(map.get(alarmid));
			}
		}
		dto.setHistorySysLogAlarmList(hisSysLogAlarmList);
		
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ����========");
		return dto;
	}
	
	/**
	* ������������֮����������
	* 
	* @param date1
	* @param date2
	* @return
	* @author ��ʡ
	*/
	public static int getMonths(Date date1, Date date2)throws Exception {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date1);
	  
	    
	    int year = c.get(Calendar.YEAR);
	    int month = c.get(Calendar.MONTH);
	    
	    c.setTime(date2);
	    int year1 = c.get(Calendar.YEAR);
	    int month1 = c.get(Calendar.MONTH);
	    
	    int result;
	    if(year==year1) 
	    	result=month1-month;//�������������£����·ݲ�
	    else 
	    	result=12*(year1-year)+month1-month;//�������������£����·ݲ�

	    return result;
	}
	
	public void setMss00005BL(Mss00005BL mss00005BL) {
		this.mss00005BL = mss00005BL;
	}
	
	public void setMss00006BL(Mss00006BL mss00006BL) {
		this.mss00006BL = mss00006BL;
	}

	public void setMss00007BL(Mss00007BL mss00007BL) {
		this.mss00007BL = mss00007BL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}


	public IGLOG00DTO getAlarmPriority(IGLOG00DTO dto) throws Exception {
		String alarmPrioritiesStr = "";
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        dto.setAlarmPrioritiesList(cds);
        for(CodeDetail cd:cds){
        	alarmPrioritiesStr = alarmPrioritiesStr + cd.getCid()+"&"+cd.getCvalue()+",";
        }
        dto.setAlarmPrioritiesStr(alarmPrioritiesStr);
        return dto;
	}
	
//	/**
//	 * �豸�澯�����̵��б�
//	 * @���� zhaoyong
//	 */
	public IGLOG00DTO searchSysLogAlarmListActionWithProcess(IGLOG00DTO dto)
			throws BLException {
//		log.debug("========��ѯ�����̵��豸�澯�б���ʼ========");
//		//�´���һ�����ϣ�����Ŵ������̵ĸ澯��Ϣ
//		List<IGLOG0003VO> list_vo = new ArrayList<IGLOG0003VO>();
//		//��ѯ���д��и澯id������
//		//ʵ����IG599��ѯ����
//		IG599SearchCondImpl cond = new IG599SearchCondImpl();
//		cond.setPivarname("�豸�澯id");
//		List<IG599Info> list_ig599 = ig599BL.searchIG599InfosByCond(cond);
//		//���ʵʱ�澯��Ϣ��Ϊ�ձ����ü���
//		if(dto.getSysLogAlarmList()!=null){
//			for( Mss00005Info info:dto.getSysLogAlarmList()){
//				IGLOG0003VO vo = new IGLOG0003VO();
//				vo.setAlarmid(info.getAlarmid());
//				vo.setAlarmstate(info.getAlarmstate());
//				vo.setAlarmtime(info.getAlarmtime());
//				vo.setDevceid(info.getDevceid());
//				vo.setDeviceip(info.getDeviceip());
//				vo.setDevicename(info.getDevicename());
//				vo.setRuleconditionid(info.getRuleconditionid());
//				vo.setRuleid(info.getRuleid());
//				vo.setRulelevel(info.getRulelevel());
//				vo.setSyslogmsg(info.getSyslogmsg());
//				vo.setSyslogtime(info.getSyslogtime());
//		        for(IG599Info ig599:list_ig599){
//		        	if(String.valueOf(info.getAlarmid()).equals(ig599.getPivarvalue())){		        				        		
//		        		vo.setPrid(ig599.getPrid());
//		        		break;
//		        	}
//		        }
//		        if(vo.getPrid()==null){
//		        	vo.setPrid(0);
//		        }
//		        list_vo.add(vo);
//			}
//		}
//		dto.setList_vo(list_vo);
//		
//		log.debug("========��ѯ�����̵��豸�澯�б������========");
//		
		return dto;
	}

	public IGLOG00DTO getRefreshRate(IGLOG00DTO dto) throws BLException {
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid("950");
        condimpl.setCid("4");
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String rate = cds.get(0).getCvalue();
        if(StringUtils.isEmpty(rate) || "0".equals(rate)) rate = "60";
        dto.setRefreshRate(rate.trim());
		return dto;
	}

}
	


