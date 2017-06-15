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
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.syslog.bl.task.Mss00008BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00009BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00012BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00013BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00014BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG01DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0101Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0102Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0114Form;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00014SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.entity.Mss00008TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;
import com.deliverik.infogovernor.syslog.vo.IGLOG0003VO;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �豸ʵʱ����ʷ��־ҵ���߼�ʵ����
 * @author ��ʡ
 *
 */
public class IGLOG01BLImpl extends BaseBLImpl implements IGLOG01BL {

	static Log log = LogFactory.getLog(IGLOG01BLImpl.class);
	
	/** �豸��־��taskBL */
	protected Mss00008BL mss00008BL;
	
	/** �豸��־��ʷ��taskBL */
	protected Mss00009BL mss00009BL;
	
	/** ��������taskBL */
	protected CodeDetailBL codeDetailBL;

	private Mss00012BL mss00012BL;
	
	private Mss00013BL mss00013BL;
	
	/** �澯�籩ͳ�Ʊ�taskBL */
	private Mss00014BL mss00014BL;
	
    /** ���̱�����taskBL */
	protected IG599BL  ig599BL;
	
	/** ����ѯʱ�Ĳ�ֵ */
	protected static int lessCount;
	
	/** ���������ѯʱ��¼��ѯ��¼���� */
	protected static int pageDispCount;
	
	protected UserRoleBL userRoleBL;

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public IGLOG01DTO searchUserRole(IGLOG01DTO dto) throws BLException, Exception {
		UserRoleSearchCondImpl userCond = new UserRoleSearchCondImpl();
		userCond.setUserid(dto.getUser().getUserid());
		List<UserRole> userRoleList = this.userRoleBL.searchUserRole(userCond);
		for (UserRole userRole : userRoleList) {
			if(1151 ==userRole.getRoleid()){
				dto.setIsMaintain("1");
			}
		}
		return dto;
	}

	public IGLOG01DTO searchSysLogListAction(IGLOG01DTO dto)
			throws BLException, Exception { 
		log.debug("========�豸ʵʱ��־��Ϣ��ѯ��ʼ========");
		IGLOG0101Form form = dto.getIglog0101Form();
		int totalCount = this.mss00008BL.getSearchCount(form);
		
		if(totalCount == 0){
			log.debug("========�豸ʵʱ��־��Ϣ��ѯ���ݲ�����========");
			return dto;
		}
//		List<Mss00008Info> sysLogList = new ArrayList<Mss00008Info>();
//		if(StringUtils.isNotEmpty(form.getIsRealTimeCollect())&&"1".equals(form.getIsRealTimeCollect())){
//			// ��ҳ����Ϣȡ��
//			PagingDTO pDto = dto.getPagingDto();
//			sysLogList = this.mss00008BL.searchMss00008(form,pDto.getFromCount(), pDto.getPageDispCount());
//			pDto.setTotalCount(totalCount);
//		}else{
//			sysLogList = this.mss00008BL.searchMss00008(form,0,dto.getMaxSearchCount());
//		}
		List<Mss00008Info> sysLogList = this.mss00008BL.searchMss00008(form,0,dto.getMaxSearchCount());
		
		
		dto.setSysLogList(sysLogList);
		log.debug("========�豸ʵʱ��־��Ϣ��ѯ����========");
		return dto;
	}

	
	
	public IGLOG01DTO searchHistorySysLogListAction(IGLOG01DTO dto) throws BLException, Exception {
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ��ʼ========");
		List historySysLogList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0102Form form = dto.getIglog0102Form();
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
	
		int mss00009Count = this.mss00009BL.getSearchCount(form);
		int mss00012Count = this.mss00012BL.getSearchCount(form);
		List<Mss00009Info> currentMonthSysLogAlarmList = new ArrayList<Mss00009Info>(); 
		List<Mss00012Info> historySysLogAlarmList = new ArrayList<Mss00012Info>(); 

		totalCount = mss00009Count + mss00012Count;
		if(totalCount == 0){
			log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
			dto.setTotalcount(totalCount);
			return dto;
		}

		//��ʼ����+ȡ������(�Ȳ�09��)
		if(pDto.getFromCount()+pDto.getPageDispCount() <= mss00009Count){
			lessCount = 0;
			currentMonthSysLogAlarmList = this.mss00009BL.searchMss00009(form,pDto.getFromCount(),pDto.getPageDispCount());
			//06���07��ͬʱ��
		}else if(pDto.getFromCount() <= mss00009Count){
			currentMonthSysLogAlarmList = this.mss00009BL.searchMss00009(form,pDto.getFromCount(),pDto.getPageDispCount());
			pageDispCount = pDto.getPageDispCount() - (mss00009Count - pDto.getFromCount());
			historySysLogAlarmList = this.mss00012BL.searchMSS00012(form,0,pageDispCount);
			lessCount = mss00009Count - pDto.getFromCount();
			//06���Ѿ�����
		}else{
			historySysLogAlarmList = this.mss00012BL.searchMSS00012(form,pDto.getFromCount()-lessCount ,pDto.getPageDispCount());
		}

		Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//ʹ��LinkedHashMap��֤���򲻱�����

		//��map����ת��������ֹ��ʷ����±������ظ��ĸ澯��¼
		if(currentMonthSysLogAlarmList.size()!=0){
			for(Mss00009Info info:currentMonthSysLogAlarmList){
				map.put(info.getId(), info);
			}
		}
		if(historySysLogAlarmList.size()!=0){
			for(Mss00012Info info:historySysLogAlarmList){
				map.put(info.getId(), info);
			}
		}

		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer alarmid = (Integer) iterator.next();
			historySysLogList.add(map.get(alarmid));
		}

		pDto.setTotalCount(totalCount);
		dto.setHistorySysLogList(historySysLogList);
		dto.setTotalcount(totalCount);

		log.debug("========�豸��ʷ�澯��Ϣ��ѯ����========");
		return dto;
	}
	
	
	public IGLOG01DTO searchHistorySysLogListNopageAction(IGLOG01DTO dto) throws BLException, Exception {
		log.debug("========�豸��ʷ�澯��Ϣ��ѯ��ʼ========");
		List hisSysLogList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0102Form form = dto.getIglog0102Form();

		int mss00009Count = this.mss00009BL.getSearchCount(form);
		int mss00012Count = this.mss00012BL.getSearchCount(form);
		List<Mss00009Info> currentMonthSysLogList = new ArrayList<Mss00009Info>(); 
		List<Mss00012Info> historySysLogList = new ArrayList<Mss00012Info>(); 

		totalCount = mss00009Count + mss00012Count;
		if(totalCount == 0){
			log.debug("========�豸��ʷ�澯��Ϣ��ѯ���ݲ�����========");
			return dto;
		}
		currentMonthSysLogList = this.mss00009BL.searchMss00009(form);
		historySysLogList = this.mss00012BL.searchMSS00012(form);
	
		Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//ʹ��LinkedHashMap��֤���򲻱�����

		//��map����ת��������ֹ��ʷ����±������ظ��ĸ澯��¼
		if(currentMonthSysLogList.size()!=0){
			for(Mss00009Info info:currentMonthSysLogList){
				map.put(info.getId(), info);
			}
		}
		if(historySysLogList.size()!=0){
			for(Mss00012Info info:historySysLogList){
				map.put(info.getId(), info);
			}
		}

		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer alarmid = (Integer) iterator.next();
			hisSysLogList.add(map.get(alarmid));
		}
		
		dto.setHistorySysLogList(hisSysLogList);

		log.debug("========�豸��ʷ�澯��Ϣ��ѯ����========");
		return dto;
	}
	
	
	public void setMss00008BL(Mss00008BL mss00008BL) {
		this.mss00008BL = mss00008BL;
	}
	
	public void setMss00009BL(Mss00009BL mss00009BL) {
		this.mss00009BL = mss00009BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setMss00012BL(Mss00012BL mss00012BL) {
		this.mss00012BL = mss00012BL;
	}
	
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	public void setMss00013BL(Mss00013BL mss00013BL) {
		this.mss00013BL = mss00013BL;
	}
	
	public void setMss00014BL(Mss00014BL mss00014BL) {
		this.mss00014BL = mss00014BL;
	}



	public IGLOG01DTO getAlarmPriority(IGLOG01DTO dto) throws Exception {
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
	
		// ��ȡcodedetail��
	public IGLOG01DTO getCodeList(IGLOG01DTO dto) throws BLException {
		ArrayList<CodeDetail> li = new ArrayList<CodeDetail>();
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setCcid("951");
		List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl,
				CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		for (CodeDetail code : cds) {
			li.add(code);
		}
		dto.setRuleli(li);

		return dto;
	}
	
	public IGLOG01DTO getRefreshRate(IGLOG01DTO dto) throws BLException {
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid("950");
        condimpl.setCid("4");
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String rate = cds.get(0).getCvalue();
        if(StringUtils.isEmpty(rate) || "0".equals(rate)) rate = "60";
        dto.setRefreshRate(rate.trim());
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
	
	/**
	 * �豸�澯�����̵��б�
	 * @���� zhaoyong
	 */
	public IGLOG01DTO searchSysLogAlarmListActionWithProcess(IGLOG01DTO dto)
			throws BLException {
		log.debug("========��ѯ�����̵��豸�澯�б���ʼ========");
		//�´���һ�����ϣ�����Ŵ������̵ĸ澯��Ϣ
		List<IGLOG0003VO> list_vo = new ArrayList<IGLOG0003VO>();
		//��ѯ���д��и澯id������
		//ʵ����IG599��ѯ����
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivarname("�澯ID");
		List<IG599Info> list_ig599 = ig599BL.searchIG599InfosByCond(cond);
		//���ʵʱ�澯��Ϣ��Ϊ�ձ����ü���
		if(dto.getSysLogList()!=null){
			for( Mss00008Info info:dto.getSysLogList()){
				IGLOG0003VO vo = new IGLOG0003VO();
				vo.setId(info.getID());
				vo.setAlarmmsg(info.getAlarmmsg());
				vo.setCreatetime(info.getCreatetime());
				vo.setDevceid(info.getDeviceid());
				vo.setDeviceip(info.getDeviceip());
				vo.setDevicename(vo.getDevicename());
				vo.setIsalarm(info.getIsalarm());
				vo.setRulelevel(info.getRulelevel());
				
		        for(IG599Info ig599:list_ig599){
		        	if(StringUtils.isEmpty(ig599.getPivarvalue())) continue;
		        	if(String.valueOf(info.getID()).equals(ig599.getPivarvalue().split("#")[0])){		        				        		
		        		vo.setPrid(ig599.getPrid());
		        		break;
		        	}
		        }
		        if(vo.getPrid()==null){
		        	vo.setPrid(0);
		        }
		        list_vo.add(vo);
			}
		}
		dto.setList_vo(list_vo);
		
		log.debug("========��ѯ�����̵��豸�澯�б������========");
		
		return dto;
	}
	
	/**
	 * �豸��ʷ�澯�����̵��б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOG01DTO searchSysLogHistoryAlarmListActionWithProcess(IGLOG01DTO dto)
			throws BLException {
		log.debug("========��ѯ�����̵��豸��ʷ�澯�б���ʼ========");
		//�´���һ�����ϣ�����Ŵ������̵ĸ澯��Ϣ
		List<IGLOG0003VO> list_vo = new ArrayList<IGLOG0003VO>();
		//��ѯ���д��и澯id������
		//ʵ����IG599��ѯ����
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivarname("�澯ID");
		List<IG599Info> list_ig599 = ig599BL.searchIG599InfosByCond(cond);
		//���ʵʱ�澯��Ϣ��Ϊ�ձ����ü���
		if(dto.getHistorySysLogList()!=null){
			for(Object obj:dto.getHistorySysLogList()){
				if(obj instanceof Mss00009Info){
					Mss00009Info info = (Mss00009Info) obj;
					IGLOG0003VO vo = new IGLOG0003VO();
					vo.setId(info.getId());
					vo.setAlarmmsg(info.getAlarmmsg());
					vo.setCreatetime(info.getCreatetime());
					vo.setDevceid(info.getDeviceid());
					vo.setDeviceip(info.getDeviceip());
					vo.setDevicename(vo.getDevicename());
					vo.setIsalarm(info.getIsalarm());
					vo.setRulelevel(info.getRulelevel());
					vo.setState(info.getState());
					vo.setStarttime(info.getStarttime());
					vo.setEndtime(info.getEndtime());
			        for(IG599Info ig599:list_ig599){
			        	if(StringUtils.isEmpty(ig599.getPivarvalue())) continue;
			        	if(String.valueOf(info.getPrid()).equals(ig599.getPivarvalue().split("#")[0])){		        				        		
			        		vo.setPrid(ig599.getPrid());
			        		break;
			        	}
			        }
			        if(vo.getPrid()==null){
			        	vo.setPrid(0);
			        }
			        list_vo.add(vo);
				}else if(obj instanceof Mss00012Info){
					Mss00012Info info = (Mss00012Info) obj;
					IGLOG0003VO vo = new IGLOG0003VO();
					vo.setId(info.getId());
					vo.setAlarmmsg(info.getAlarmmsg());
					vo.setCreatetime(info.getCreatetime());
					vo.setDevceid(info.getDeviceid());
					vo.setDeviceip(info.getDeviceip());
					vo.setDevicename(vo.getDevicename());
					vo.setIsalarm(info.getIsalarm());
					vo.setRulelevel(info.getRulelevel());
					vo.setState(info.getState());
					vo.setStarttime(info.getStarttime());
					vo.setEndtime(info.getEndtime());
			        for(IG599Info ig599:list_ig599){
			        	if(StringUtils.isEmpty(ig599.getPivarvalue())) continue;
			        	if(String.valueOf(info.getPrid()).equals(ig599.getPivarvalue().split("#")[0])){		        				        		
			        		vo.setPrid(ig599.getPrid());
			        		break;
			        	}
			        }
			        if(vo.getPrid()==null){
			        	vo.setPrid(0);
			        }
			        list_vo.add(vo);
				}
			}
		}
		dto.setList_vo(list_vo);
		
		log.debug("========��ѯ�����̵��豸��ʷ�澯�б������========");
		return dto;
	}


	/**
	 * syslog�澯�޸�
	 * @���� ��ʡ
	 */
	public IGLOG01DTO FixSysLogAlarmsAction(IGLOG01DTO dto) throws BLException {
		IGLOG0101Form form = dto.getIglog0101Form();
		String[] ids = form.getIds();

		for(String id:ids){
			Mss00008Info info = mss00008BL.searchMss00008ByPK(Integer.parseInt(id));
//			if(info.getIsalarm() != 1){//�����syslog���Ǹ澯
//				continue;
//			}
			moveSyslogToHistoryTB(info,0);
		}
		return dto;
	}
	
	/**
	 * ��ʵʱ���syslog�ƶ�����ʷ��
	 * @param info
	 * @throws BLException 
	 */
	private void moveSyslogToHistoryTB(Mss00008Info info , Integer state) throws BLException{
		
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		Mss00009TB bean = new Mss00009TB();
		bean.setAlarmmsg(info.getAlarmmsg());
		bean.setCreatetime(info.getCreatetime());
		String starttime;
		if(StringUtils.isEmpty(info.getStarttime())) starttime = format.format(new Date());
		else starttime = info.getStarttime();
		bean.setStarttime(starttime);
		bean.setEndtime(format.format(today));
		bean.setDeviceid(info.getDeviceid());
		bean.setDeviceip(info.getDeviceip());
		bean.setDevicename(info.getDevicename());
		bean.setIsalarm(info.getIsalarm());
		bean.setRulelevel(info.getRulelevel());
		bean.setState(state);//����Ϊ���޸�״̬
		mss00009BL.registMss00009(bean);
		mss00008BL.deleteMss00008(info);
	}


	/**
	 * ��ȡsyslogʵ��
	 * 
	 */
	public IGLOG01DTO getSysLogBean(IGLOG01DTO dto) throws BLException {
		IGLOG0101Form form = dto.getIglog0101Form();
		String id = form.getId();
		Mss00008Info bean;
		if(StringUtils.isEmpty(id)) bean = new Mss00008TB();
		else bean = mss00008BL.searchMss00008ByPK(Integer.parseInt(id));
		dto.setSyslogbean(bean);
		return dto;
	}


	/**
	 * �豸��־�����߼�
	 * 	��1�������ݸ���뾯���α� 
	 *	��2����syslogʵʱ��������������ļ�¼������ʷ������״̬��Ϊ����״̬
	 *  ��3��Ȼ��ʵʱ������ɾ��
	 */
	public IGLOG01DTO doFilter(IGLOG01DTO dto) throws BLException {
		
		//��ȡ������
		IGLOG0101Form form = dto.getIglog0101Form();
		String msg= form.getContent();
		String ip = form.getIp_eq();
		String level = form.getPriority_eq();
		
		/**
		 * �˴��߼�����˵����
		 * ���ӣ�����ԭ�м�¼�� IP  		LEVEL 		MSG
		 * 		       1.1.1.1        3        "ABC"
		 * 	   Ҫ����ļ�¼�� IP  		LEVEL 		MSG
		 * 			   1.1.1.1        3          ��
		 *     �ȰѰ�ԭ�м�¼ɾ�����ٲ����¼�¼
		 * 
		 */
		Mss00013SearchCondImpl cond = new Mss00013SearchCondImpl();
		cond.setContent(msg);
		cond.setPriority_eq(level);
		cond.setIp_eq(ip);
		List<Mss00013Info> list = mss00013BL.searchMss00013(cond);
		for(Mss00013Info info:list){
			mss00013BL.deleteMss00013(info);
		}
		
		//�����ݴ���澯���α�
		Mss00013TB filterbean = new Mss00013TB();
		filterbean.setAlarmmsg(msg);
		filterbean.setRulelevel(level);
		filterbean.setDeviceip(ip);
		Mss00013Info filterRule = mss00013BL.registMss00013(filterbean);
		
		//syslog�����߼�
		String filterip = filterRule.getDeviceip();
		String filterlevel = filterRule.getRulelevel();
		String filtermsg = filterRule.getAlarmmsg();
		List<Mss00008Info> sysLogList = this.mss00008BL.searchMss00008();
		
		for(Mss00008Info info: sysLogList){
			if(!info.getDeviceip().equals(filterip)) continue;
			if(StringUtils.isNotEmpty(filterlevel) && StringUtils.isNotEmpty(filtermsg)){
				if(filterlevel.equals(info.getRulelevel()) && info.getAlarmmsg().indexOf(filtermsg.trim())!= -1){
					moveSyslogToHistoryTB(info,2);
				}
			}else if(StringUtils.isNotEmpty(filterlevel) && StringUtils.isEmpty(filtermsg)){
				if(filterlevel.equals(info.getRulelevel())){
					moveSyslogToHistoryTB(info,2);
				}
			}else if(StringUtils.isNotEmpty(filtermsg) && StringUtils.isEmpty(filterlevel)){
				if(info.getAlarmmsg().indexOf(filtermsg.trim())!= -1){
					moveSyslogToHistoryTB(info,2);
				}
			}else if(StringUtils.isEmpty(filterlevel) && StringUtils.isEmpty(filtermsg)){
				moveSyslogToHistoryTB(info,2);
			}
		}
		return dto;
	}
	
	public void moveFilterSyslogToHistoryDB() throws Exception {
		Mss00008SearchCondImpl cond = new Mss00008SearchCondImpl();
		cond.setIsalarm("2");
		List<Mss00008Info> list = mss00008BL.searchMss00008(cond);
		for(Mss00008Info info:list){
			Mss00009TB tb = new Mss00009TB();
			tb.setAlarmmsg(info.getAlarmmsg());
			tb.setCreatetime(info.getCreatetime());
			tb.setDeviceid(info.getDeviceid());
			tb.setDeviceip(info.getDeviceip());
			tb.setDevicename(info.getDevicename());
			tb.setEndtime(info.getCreatetime());
			tb.setIsalarm(info.getIsalarm());
			tb.setRulelevel(info.getRulelevel());
			tb.setStarttime(info.getStarttime());
			tb.setState(2);
			mss00009BL.registMss00009(tb);
			mss00008BL.deleteMss00008(info);
		}
	}
	
	
	public IGLOG01DTO getAlarmTotalcount(IGLOG01DTO dto) throws Exception{
		Mss00008SearchCondImpl cond = new Mss00008SearchCondImpl();
		cond.setIsalarm("1");
		int count = mss00008BL.getSearchCount(cond);
		dto.setTotalcount(count);
		return dto;
	}
	
	/** ��ʼ����ѯҳ�� **/
	public IGLOG01DTO echoData(IGLOG01DTO dto) throws BLException {
		IGLOG0114Form form = dto.getIglog0114Form();
		int totalCount = 0;
		totalCount=mss00013BL.getSearchCount(form);
		if (totalCount == 0) {
			log.debug("========��Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		
		
		pDto.setTotalCount(totalCount);
		List<Mss00013Info> list_ig00013 = mss00013BL.searchMss00013(form,pDto.getFromCount(), pDto.getPageDispCount());
		dto.setLi(list_ig00013);
		return dto;
	}

	
	public void deleteData(IGLOG01DTO dto) throws BLException {

		IGLOG0114Form form = dto.getIglog0114Form();

		for (Integer ruletempid : form.getId()) {
			mss00013BL.deleteMss00013ByPK(ruletempid);
		}

	}
	
	// mss00013���̨ɾ���߼�
	public void delete00013TB(IGLOG01DTO dto) throws BLException {
		List HistorySysLogList = new ArrayList();
		HistorySysLogList = dto.getCheckedsyslogList();
		if (!dto.getCheckedsyslogList().isEmpty()) {
			for (Object obj : HistorySysLogList) {
				if (obj instanceof Mss00009Info) {

					Mss00009Info mss0009info = (Mss00009Info) obj;
					
					if(mss0009info.getState() != 3){//������Ǹ澯�籩
						// ����009����Ϣ�����α���Ϣ
						changeInfo(mss0009info, dto);
					}else{//����Ǹ澯�籩
						String alarmIP = mss0009info.getDeviceip();//��ȡIP
						deleteAlarmStormRecordByIp(alarmIP);
					}
				} else if (obj instanceof Mss00012Info) { // ����0012����Ϣ�����α���Ϣ
					Mss00012Info mss0012info = (Mss00012Info) obj;
					if(mss0012info.getState() != 3){
						changeInfo(mss0012info, dto);
					}else{
						String alarmIP = mss0012info.getDeviceip();
						deleteAlarmStormRecordByIp(alarmIP);
					}
					
				}

			}

		}

	}
	
	private void deleteAlarmStormRecordByIp(String alarmIP) throws BLException{
		Mss00014SearchCondImpl cond = new Mss00014SearchCondImpl();
		cond.setIp_eq(alarmIP);
		List<Mss00014Info> records = mss00014BL.searchMss00014(cond);
		if(records == null || records.size() == 0) return;
		Mss00014Info record = records.get(0);
		mss00014BL.deleteMss00014ByPK(record.getId());
	}
	

	private void changeInfo(Object obj, IGLOG01DTO dto) {

		if (obj instanceof Mss00009Info) {

			Mss00009Info mss0009info = (Mss00009Info) obj;

			// ��ȡ���α�ȫ����Ϣ
			for (Mss00013Info mss00013info : dto.getLi()) { // �ж�IP�Ƿ����
				if (mss0009info.getDeviceip()
						.equals(mss00013info.getDeviceip())) { // ���Ip������жϸ澯�����IP
					if ((mss0009info.getRulelevel().equals(mss00013info
							.getRulelevel()))
							&& (mss0009info.getAlarmmsg().indexOf(mss00013info
									.getAlarmmsg())) != -1) {
						try {
							if (mss00013info != null) {
								mss00013BL.deleteMss00013(mss00013info);
								log.info("mss00013ɾ���ɹ�");
							} else {
								log.info("mss00013��������Ϣ");

							}

						} catch (BLException e) {
							log.info("mss00013ɾ��ʧ��");
							e.printStackTrace();
						}

					}
				}
				// ���Ip�����ֱ��������һ��ѭ��
				else {
					continue;
				}
			}
		} else if (obj instanceof Mss00012Info) { // ����0012����Ϣ�����α���Ϣ
			Mss00012Info mss0012info = (Mss00012Info) obj;

			for (Mss00013Info mss00013info : dto.getLi()) { // �ж�IP�Ƿ����
				if (mss0012info.getDeviceip()
						.equals(mss00013info.getDeviceip())) { // ���Ip������жϸ澯�����IP
					if ((mss0012info.getRulelevel().equals(mss00013info
							.getRulelevel()))
							&& (mss0012info.getAlarmmsg().indexOf(mss00013info
									.getAlarmmsg())) != -1) {
						try {
							if (mss00013info != null) {
								mss00013BL.deleteMss00013(mss00013info);
								log.info("mss00013ɾ���ɹ�");
							} else {
								log.info("mss00013��������Ϣ");

							}

						} catch (BLException e) {
							log.info("mss00013ɾ��ʧ��");
							e.printStackTrace();
						}

					}
				}
				// ���Ip�����ֱ��������һ��ѭ��
				else {
					continue;
				}
			}

		}

	}

	// ��ѯѡ���syslog��Ϣ;
	public IGLOG01DTO searchHistoryChecked(IGLOG01DTO dto) throws BLException,
			Exception {
		List historySysLogList = new ArrayList();
		// ��ѯ��ѡ��syslog��Ϣ
		List<Mss00009Info> currentMonthSysLogAlarmList = new ArrayList<Mss00009Info>();
		List<Mss00012Info> historySysLogAlarmList = new ArrayList<Mss00012Info>();
		currentMonthSysLogAlarmList = mss00009BL.searchMss00009(dto
				.getIglog0102Form());
		historySysLogAlarmList = mss00012BL.searchMSS00012(dto
				.getIglog0102Form());
		Map<Integer, Object> map = new LinkedHashMap<Integer, Object>();// ʹ��LinkedHashMap��֤���򲻱�����

		// ��map����ת��������ֹ��ʷ����±������ظ��ĸ澯��¼
		if (currentMonthSysLogAlarmList.size() != 0) {
			for (Mss00009Info info : currentMonthSysLogAlarmList) {
				map.put(info.getId(), info);
			}
		}
		if (historySysLogAlarmList.size() != 0) {
			for (Mss00012Info info : historySysLogAlarmList) {
				map.put(info.getId(), info);
			}
		}

		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer alarmid = (Integer) iterator.next();
			historySysLogList.add(map.get(alarmid));
			dto.setCheckedsyslogList(historySysLogList);
		}

		return dto;

	}

	// ��ѯmss00013��
	public IGLOG01DTO findAllMS00013(IGLOG01DTO dto) {

		List<Mss00013Info> list_ig00013 = mss00013BL.searchMss00013();
		dto.setLi(list_ig00013);
		return dto;
	}

	public boolean SearchCount(IGLOG01DTO dto) {
		int a = mss00013BL.getSearchCount(dto.getIglog0114Form());
		if (a == 0) {
			return false;
		} else {

			return true;
		}
	}


}
