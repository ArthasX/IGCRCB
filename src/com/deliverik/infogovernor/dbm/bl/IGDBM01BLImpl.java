/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.util.SerializationHelper;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * @�������������г���ҳBL
 * @���������� 1.���ط��п���Ƿ�
 *           2.������
 *           3.������ATM��POS�ɹ����Ǳ���
 *           4.������ATM��POS�ɹ�����ͼ
 *           5.��ǰ����ͳ��
 *           6.����ƻ���ѯ
 *           7.IT��Ӫ����
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public class IGDBM01BLImpl extends BaseBLImpl implements IGDBM01BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	protected IG500BL ig500BL;
	protected UserRoleBL userRoleBL;
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**
	 * ����:�����ɹ�������ͼ
	 * @param IGDBM01DTO dto
	 * @return �����ɹ���
	 * @throws BLException
	 */
	public IGDBM01DTO getPLine(IGDBM01DTO dto) throws BLException{
		Random rand = new Random();
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
		content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"</ROOT>";
	    dto.setResultXML(content);
		return dto;
		
	}
	
	/**
	 * ����:��ǰ��������ͼ
	 * @param IGDBM01DTO dto
	 * @return ��ǰ������
	 * @throws BLException
	 */
	public IGDBM01DTO getCurrentWorkPiller(IGDBM01DTO dto) throws BLException{
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
		int countI = 0;
		int countP = 0;
		int countC = 0;
		int countW = 0;
		if(dataList!=null&&dataList.size() >0){
			for(IG500Info prBean:dataList){
				if("I".equals(prBean.getPrtype())||"ID".equals(prBean.getPrtype())){
					countI++;
				}else if("P".equals(prBean.getPrtype())||"PD".equals(prBean.getPrtype())){
					countP++;
				}else if("C".equals(prBean.getPrtype())||"CD".equals(prBean.getPrtype())){
					countC++;
				}else if("W".equals(prBean.getPrtype())||"WD".equals(prBean.getPrtype())){
					countW++;
				}
			}
		}

		String currentWorks = countI+","+countP+","+countC+","+countW;
		dto.setCurrentWork(currentWorks);
		return dto;
		
	}
	
	/**
	 * ����:��ͼ��������
	 * @param IGDBM01DTO dto
	 * @return �����д�������Ľ�����
	 * @throws BLException
	 */
	public IGDBM01DTO getMap(IGDBM01DTO dto)throws BLException{
		
		String mapname = dto.getMapname();

        Random rand = new Random(new Date().getTime());
		Integer imga = rand.nextInt(3)+1;
		Integer imgb = rand.nextInt(3)+1;
		Integer imgc = rand.nextInt(3)+1;
		Integer vara = 0;
		Integer varb = 0;
		Integer varc = 0;
		if("��������".equals(mapname)){
			vara = 300;
			varb = 200;
			varc = 90;
		}else if("����������".equals(mapname)){
			vara = 37;
			varb = 19;
			varc = 20;
		}else if("��������".equals(mapname)){
			vara = 76;
			varb = 45;
			varc = 72;
		}else if("��������".equals(mapname)){
			vara = 31;
			varb = 20;
			varc = 36;
		}else if("��������".equals(mapname)){
			vara = 54;
			varb = 33;
			varc = 68;
		}else if("������".equals(mapname)){
			vara = 89;
			varb = 68;
			varc = 59;
		}
		
		
		dto.setMaps(vara.toString()+":"+imga.toString()+"|"+varb.toString()+":"+imgb.toString()+"|"+varc.toString()+":"+imgc.toString());
		return dto;
	}
	
	/**
	 * ����:�����ɹ����Ǳ�
	 * @param IGDBM01DTO dto
	 * @return �����ɹ�����
	 * @throws BLException
	 */
	public IGDBM01DTO getStudy(IGDBM01DTO dto)throws BLException{
		dto.setMeter(95);
		return dto;
	}
	
	
	
	/**
	 * ����:�г���ҳ�������ؼ�
	 * @param IGDBM01DTO dto
	 * @return ��ϵͳ�������
	 * @throws BLException
	 */
	public IGDBM01DTO getMonitor(IGDBM01DTO dto) throws BLException{
		String monitor="";
		monitor = "1|1|1|1|1|1|1|1|1|1|1";
		dto.setMonitor(monitor);
		return dto;
	}
	
	
	/**
	 * ����:���ɱ��¸��¼����Ͳ�ͬ����������xml
	 * @param IGDBM01DTO dto
	 * @return ���¼����Ͳ�ͬ����������
	 * @throws BLException
	 */
	public IGDBM01DTO setAllTypeEventCount(IGDBM01DTO dto)  throws BLException{

		    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
	
		    content = content+"<hardware>" ;
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"n\">" + 0 + "</value>";
		    content = content+"<value type=\"n\">" + 3 + "</value>";
		    content = content+"<value type=\"n\">" + 5 + "</value>";
		    content = content+"</hardware>" ;
		    
		    content = content+"<business>" ;
		    content = content+"<value type=\"n\">" + 0 + "</value>";
		    content = content+"<value type=\"n\">" + 0 + "</value>";
		    content = content+"<value type=\"n\">" + 0 + "</value>";
		    content = content+"<value type=\"n\">" + 2 + "</value>";
		    content = content+"<value type=\"n\">" + 2 + "</value>";
		    content = content+"</business>" ;
		    
		    content = content+"<net>" ;
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"n\">" + 2 + "</value>";
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"r\">" + 13 + "</value>";
		    content = content+"<value type=\"t\">" + 17 + "</value>";
		    content = content+"</net>" ;
		    
		    content = content+"<system>" ;
		    content = content+"<value type=\"n\">" + 0 + "</value>";
		    content = content+"<value type=\"o\">" + 5 + "</value>";
		    content = content+"<value type=\"n\">" + 3 + "</value>";
		    content = content+"<value type=\"n\">" + 2 + "</value>";
		    content = content+"<value type=\"n\">" + 10 + "</value>";
		    content = content+"</system>" ;
		    
		    content = content+"<general>" ;
		    content = content+"<value type=\"n\">" + 3 + "</value>";
		    content = content+"<value type=\"o\">" + 7 + "</value>";
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"n\">" + 1 + "</value>";
		    content = content+"<value type=\"t\">" + 12 + "</value>";
		    content = content+"</general>" ;
		    content = content+"</ROOT>";
		   dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:�г���ҳ����xml
	 * @param IGDBM01DTO dto
	 * @return ÿ�¸�����
	 * @throws BLException
	 */
	public IGDBM01DTO setCalendar(IGDBM01DTO dto) throws BLException {
		int year = dto.getYear();
		int month = dto.getMonth();
		List<UserRoleInfo> userRoleList; //��ǰ��¼�û����н�ɫ����
		String searchDate = "";
		
		//��ѯ��ǰ��¼�û����н�ɫ���Ͽ�ʼ
		UserRoleVWSearchCondImpl userRolecond = new UserRoleVWSearchCondImpl();
		userRolecond.setUserid(dto.getUser().getUserid());
		userRoleList = userRoleBL.searchUserRoleVW(userRolecond, 0, 0);
		//��ѯ��ǰ��¼�û����н�ɫ���Ͻ���
		
		//��ѯ����������в����߼�¼��ʼ
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPrtype("C");
//		cond.setTodo(true);
		cond.setPrplantime(year+"/"+month+"/01");
		cond.setPrduration(year+"/"+month+"/31");
		List<IG677Info> dataList = ig500BL.searchProcessRecordInfo(cond, 0, 0);
		//��ѯ����������в����߼�¼����
		Map<String,String> urlMap = getProcessPageUrl();
		int maxDay = this.getMonthLastDay(year, month); //ȡ�õ�ǰ���������
		String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
		String aboutMePrid = null;
		String aboutGroupPrid= null;
		String havedPrid = null;
		for (int i = 1; i <= maxDay; i++) {
			if(i<10){
				searchDate = year+"/"+month+"/0"+i;
			}else{
				searchDate = year+"/"+month+"/"+i;
			}
			aboutMePrid = isAboutMeProcess(dataList,dto.getUser().getUserid(),searchDate);
			aboutGroupPrid = isAboutGroupProcess(dataList,userRoleList,searchDate);
			havedPrid = isHavedProcess(dataList,searchDate);
			
			if(StringUtils.isNotEmpty(aboutMePrid)){       //�жϵ����Ƿ��и�����ص�����
				content = content+ "<p type=\"a\" url=\""+urlMap.get("C")+aboutMePrid+"\">" + i+ "</p>";
				continue;
			}else if(StringUtils.isNotEmpty(aboutGroupPrid)){           //�жϵ����Ƿ��и��ҽ�ɫ��ص�����
				content = content+ "<p type=\"b\" url=\""+urlMap.get("C")+aboutGroupPrid+"\">" + i+ "</p>";
				continue;
			}else if(StringUtils.isNotEmpty(havedPrid)){                             //�жϵ����Ƿ�������
				content = content+ "<p type=\"c\" url=\""+urlMap.get("C")+havedPrid+"\">" + i+ "</p>";
				continue;
			}else{
				content = content+ "<p type=\"n\" url=\""+urlMap.get("C")+"\">" + i+ "</p>";
				continue;
			}
		}
		
		content = content + "</ROOT>";
		dto.setResultXML(content);
		return dto;
	}
	/**
	 * ����:ȡ��������ϸҳURL
	 * @return Map<PTTYPE,URL>
	 * @throws BLException
	 */
	private Map<String,String> getProcessPageUrl()throws BLException{
		Map<String,String> urlMap = new HashMap<String,String>();
		List<IG259Info> processTemplateList = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		if(processTemplateList!=null){
			for(IG259Info ptBean:processTemplateList){
				urlMap.put(ptBean.getPttype(), ptBean.getPtdetailpg());
			}
		}
		return urlMap;
	}
	/**
	 * ����:�ж������Ƿ���ҽ�ɫ�й�ϵ
	 * @return prid���й� or null�� �޹�
	 * @throws BLException
	 */
	private String isAboutGroupProcess(List<IG677Info> processInfoList,List<UserRoleInfo> userRoleList,String searchDate){
		if(userRoleList == null || processInfoList==null){
			return null;
		}
		Integer userRoleId;
		for(UserRoleInfo urBean:userRoleList){
			userRoleId = urBean.getRoleid();
			for(IG677Info priBean:processInfoList){
				String prplanTime = priBean.getPrplantime();
				if(StringUtils.isNotEmpty(prplanTime)&&prplanTime.indexOf(searchDate)!=-1){
					if(String.valueOf(userRoleId).equals(String.valueOf(priBean.getPproleid()))){
						return String.valueOf(priBean.getPrid());
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * ����:�ж������Ƿ�����й�ϵ
	 * @return prid���й� or null�� �޹�
	 * @throws BLException
	 */
	private String isAboutMeProcess(List<IG677Info> processInfoList,String userId,String searchDate){
		if(processInfoList == null){
			return null;
		}
		for(IG677Info priBean:processInfoList){
			String prplanTime = priBean.getPrplantime();
			if(StringUtils.isNotEmpty(prplanTime)&&prplanTime.indexOf(searchDate)!=-1){
				if(userId.equals(priBean.getPpuserid())){
					return String.valueOf(priBean.getPrid());
				}
			}
		}
		return null;
	}
	
	/**
	 * ����:�жϵ����Ƿ�������
	 * @return prid���й� or null�� �޹�
	 * @throws BLException
	 */
	private String isHavedProcess(List<IG677Info> processInfoList,String searchDate){
		if(processInfoList==null){
			return null;
		}
		for(IG677Info priBean:processInfoList){
			String prplanTime = priBean.getPrplantime();
			if(StringUtils.isNotEmpty(prplanTime)&&prplanTime.indexOf(searchDate)!=-1){
				return String.valueOf(priBean.getPrid());
			}
		}
		return null;
	}
	
	public int getMonthLastDay(int year, int month){   
	    Calendar a = Calendar.getInstance();
	    a.set(Calendar.YEAR, year);
	    a.set(Calendar.MONTH, month - 1);
	    a.set(Calendar.DATE, 1);//����������Ϊ���µ�һ��
	    a.roll(Calendar.DATE, -1);//���ڻع�һ�죬Ҳ�������һ��
	    int maxDate = a.get(Calendar.DATE);
	    return maxDate;
	}
	
	/**
	 * ����:�г���ҳIT����
	 * @param IGDBM01DTO dto
	 * @return ÿ�±�������⡢�¼�����
	 * @throws BLException
	 */
	public IGDBM01DTO setITChart(IGDBM01DTO dto)  throws BLException{
		IG500SearchCondImpl cond500=new IG500SearchCondImpl();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy/MM");


		List<IG500Info> List_cpi=ig500BL.searchIG500Info(cond500);
		List<IG500Info> things = new ArrayList<IG500Info>();
		List<IG500Info> question = new ArrayList<IG500Info>();
		List<IG500Info> changes = new ArrayList<IG500Info>();
		
		
		for (IG500Info ig500Info : List_cpi) {
			if(ig500Info.getPrtype()==null){continue;}
			if(ig500Info.getPrtype().startsWith("C")){
				IG500Info newObj=(IG500Info)SerializationHelper.clone(ig500Info);
				changes.add(newObj);
			}
			if(ig500Info.getPrtype().startsWith("P")){
				IG500Info newObj=(IG500Info)SerializationHelper.clone(ig500Info);
				question.add(newObj);
			}
			if(ig500Info.getPrtype().startsWith("I")){
				IG500Info newObj=(IG500Info)SerializationHelper.clone(ig500Info);
				things.add(newObj);
			}
		}
		//����ȡ���ݵĲ���
		List<Integer> thingsCount = new ArrayList<Integer>();
		List<Integer> questionCount = new ArrayList<Integer>();
		List<Integer> changesCount = new ArrayList<Integer>();
		String whitchMonth=null;


		for (int i = 11; i>=0; i--) {
			int countC = 0;
			Calendar whereBegin=Calendar.getInstance();
			whereBegin.add(Calendar.MONTH, -i);
			whitchMonth=sf.format(whereBegin.getTime());
			for (IG500Info cInfo : changes) {
				if(cInfo.getPropentime().indexOf(whitchMonth) != -1){
					countC++;
				}
			}
			changesCount.add(countC);
		}
		
		for (int i = 11; i>=0; i--) {
			int countP = 0;
			Calendar whereBegin=Calendar.getInstance();
			whereBegin.add(Calendar.MONTH, -i);
			whitchMonth=sf.format(whereBegin.getTime());
			for (IG500Info cInfo : question) {
				if(cInfo.getPropentime().indexOf(whitchMonth) != -1){
					countP++;
				}
			}
			questionCount.add(countP);
		}
		
		for (int i = 11; i>=0; i--) {
			int countI = 0;
	    	Calendar whereBegin=Calendar.getInstance();
	    	whereBegin.add(Calendar.MONTH, -i);
	    	whitchMonth=sf.format(whereBegin.getTime());
	    	for (IG500Info cInfo : things) {
	    		if(cInfo.getPropentime().indexOf(whitchMonth) != -1){
	    			countI++;
	    		}
			}
	    	thingsCount.add(countI);
		}
	    
		//������������xml
		String content = "<?xml version=\'1.0\' encoding=\'UTF-8\'?><ROOT>";
	    content = content+"<MAXVALUE>"+getMinModFive(thingsCount, questionCount, changesCount)+"</MAXVALUE>";
	    
	    content=content+"<MONTH>";
	    for (int i = 11; i >= 0; i--) {//����һ��
	    	Calendar getMonth = Calendar.getInstance();
	    	getMonth.add(Calendar.MONTH, -i);
	    	content = content+"<value>"+sf.format(getMonth.getTime()).substring(5)+"</value>";
	    }
	    content=content+"</MONTH>";
	    
	    content = content+"<PILLAR>";
	    for(int i=0;i<thingsCount.size();i++){
	    	content = content+"<value>"+thingsCount.get(i)+"</value>";
	    }
	    content = content+"</PILLAR>";
	    
	    content = content+"<AREA>";
	    for(int i=0;i<questionCount.size();i++){
	    	content = content+"<value>"+questionCount.get(i)+"</value>";
	    }
	    content = content+"</AREA>";
	    
	    content = content+"<LINE>";
	    for(int i=0;i<changesCount.size();i++){
	    	content = content+"<value>"+changesCount.get(i)+"</value>";
	    }
	    content = content+"</LINE>";
	    
	    content = content+"</ROOT>";
	    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:ȡ�ò�С������list��������������ܱ�5������������
	 * @return ��С������list��������������ܱ�5������������
	 * @throws BLException
	 */
	public int getMinModFive(List<Integer> list1,List<Integer> list2,List<Integer> list3){
		int mmf = 0;
		for(int i=0;i<list1.size();i++){
			int cur = (Integer)list1.get(i);
			if(cur>mmf){
				mmf=cur;
			}
		}
		for(int i=0;i<list2.size();i++){
			int cur = (Integer)list2.get(i);	
			if(cur>mmf){
				mmf=cur;
			}
		}
		for(int i=0;i<list3.size();i++){
			int cur = (Integer)list3.get(i);
			if(cur>mmf){
				mmf=cur;
			}
		}
		while(mmf%5!=0){
			mmf++;
		}
		return mmf;
	}

	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public UserRoleBL getUserRoleBL() {
		return userRoleBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
}

