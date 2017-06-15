/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;


/**
 * @�������������г���ҳBL
 * @���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.������
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 * @������¼�������� 2010/10/26
 * @version 1.0
 */

public class IGDBM02BLImpl extends BaseBLImpl implements IGDBM02BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**
	 * ����:�г���ҳ�������ؼ�
	 * @param IGDBM02DTO dto
	 * @return ��ϵͳ�������
	 * @throws BLException
	 */
	public IGDBM02DTO getMonitor(IGDBM02DTO dto) throws BLException{
		String monitor="";	
		monitor = "1|1|1|1|1|1|1|1|1|1|1";
		dto.setMonitor(monitor);
		return dto;
	}
	
	
	/**
	 * 
	 * ����:������ҳ�¼������⡢�������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �¼����������������
	 * @throws BLException
	 */
	public IGDBM02DTO getProcessCount(IGDBM02DTO dto)  throws BLException{
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
		int countI = 0;
		int countW = 0;
		int countC = 0;
		for(IG500Info prBean:dataList){
			if(("I".equals(prBean.getPrtype())||"ID".equals(prBean.getPrtype()))){
				if(StringUtils.isEmpty(prBean.getPrclosetime())){
					countI++;
				}
			}
			if(StringUtils.isNotEmpty(prBean.getPrtype())){
				if(prBean.getPrtype().startsWith("W")){
					if(StringUtils.isEmpty(prBean.getPrclosetime())){
						if("WA".equals(prBean.getPrtype())){
							if(!"D".equals(prBean.getPrstatus())){
								countW++;	
							}
						}else{							
							countW++;
						}
					}
				}
			}
			if(("C".equals(prBean.getPrtype())||"CD".equals(prBean.getPrtype()))){
				if(StringUtils.isEmpty(prBean.getPrclosetime())&&!"D".equals(prBean.getPrstatus())){
					countC++;
				}
			}
		}
		
		dto.setProcessCount(""+countI+"|" +countW+"|"+ countC);
		return dto;
	}
	
	
	/**
	 * ����:���ɴ�����ҳ����ƻ�����xml
	 * @param IGDBM02DTO dto
	 * @return ����ƻ�����
	 * @throws BLException
	 */
	public IGDBM02DTO setChangePlan(IGDBM02DTO dto) throws BLException {
		Date paramDate = new Date(); // Ĭ��ȡ��ϵͳʱ��
		String turnPageFlag = ""; // ��ҳ��־
		SimpleDateFormat formatterYearMonth = new SimpleDateFormat("yyyy �� MM �� ");
		SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
		SimpleDateFormat formatterYMD = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatChangePlan = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		String valueOfDate = dto.getValueOfDate();// ȡ�ô������ڲ���
		
		try {
			// ������ʽΪ'next|yyyyMMdd'�����ݣ�backΪ��ǰ��ҳ��nextΪ���ҳ
			if (valueOfDate != null && !"".equals(valueOfDate)) {
				int location = valueOfDate.indexOf("|");
				turnPageFlag = valueOfDate.substring(0,location);
				paramDate  = formatterYMD.parse(valueOfDate.substring(location + 1));
				//paramDate
				c.setTime(paramDate);
				//changeFlag = false;
			}

			if ("".equals(turnPageFlag)) {// ������ʼ�������ȡ�ñ��ܵ�һ��
				int dayofweek = c.get(Calendar.DAY_OF_WEEK);
				c.add(Calendar.DATE, 1 - dayofweek);
			} else if ("back".equals(turnPageFlag)) {// ������ǰ�������ȡ�����ܵ�һ��
				c.add(Calendar.DATE, -8);
			}
			String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ROOT>\n";
			IG500SearchCondImpl cond = new IG500SearchCondImpl();

			for (int i = 1; i <= 7; i++) {
				c.add(Calendar.DATE, 1);
				
				//<dateroot yearmonth="2010��11��" day="08" color="1" week="����һ" url="http://wwww.baidu.com" amount="4" returnValue = "20101108">
				content = content + "<dateroot yearmonth= \"" + formatterYearMonth.format(c.getTime()) + "\"" +
				          " day=\"" + formatterDay.format(c.getTime()) + "\"" ;
				if("������".equals(getWeekStr(i))||"������".equals(getWeekStr(i))){
					content = content +" color=\"2\"";
				}else{
					content = content +" color=\"1\"";
				}
				         
				content = content + " week=\"" + getWeekStr(i) + "\"" +
				          " url=\"IGSVC0401.do?selectstatus=1\"" +
				          " amount=\"4\"" +
				          " returnValue=\"" +formatterYMD.format(c.getTime()) + "\">\n";
				cond.setPrTypeArray(new String[]{"C"});
				cond.setPrStatusArray(new String[]{"E","V","C"});
				cond.setPrplantime_like(formatChangePlan.format(c.getTime()));
				List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
				if(dataList !=null && dataList.size() >0){
					if(dataList.size()>3){
						dataList=dataList.subList(0, 3);
					}
					for(int j=0;j<dataList.size();j++){
						IG500Info prbean=dataList.get(j);
						content = content + " <cplan color=\"1\">"+(j+1)+"."+prbean.getPrtitle()+"</cplan>\n";
					}
					for(int j=0;j<(3-dataList.size());j++){
						content = content + " <cplan color=\"1\"></cplan>\n";
					}
					content = content + " </dateroot>\n";
				}else{
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " </dateroot>\n";
				}
			}
				
			content = content + "</ROOT>\n";
			dto.setChangePlanCalender(content);
		} catch (Exception e) {
			throw new BLException();
		}
		return dto;
	}
	
	
	/**
	 * ����:�����͵����ֱ�ɺ��ֵ�����
	 * @param int dayofweek
	 * @return ����X
	 * @throws BLException
	 */
	private  String getWeekStr(int dayofweek){   
		  String week = "";   
		  switch ( dayofweek )
			{
				case 1:
					 week = "����һ"; 
					break;
				case 2:
					 week = "���ڶ�"; 
					break;
				case 3:
					 week = "������"; 
					break;
				case 4:
					 week = "������"; 
					break;
				case 5:
					 week = "������"; 
					break;
				case 6:
					 week = "������"; 
					break;
				case 7:
					 week = "������"; 
					break;
			}		
		 
		  return week;   
		 }    
	
	/**
	 * ����:������ҳ�����¼�����ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �����¼�����
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthEventCount(IGDBM02DTO dto)  throws BLException{
		Calendar  c=new  GregorianCalendar();//�½����ڶ���  
		int  year=c.get(Calendar.YEAR);//��ȡ���  
		int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
		String startDate = year+"/"+month+"/01";
		String endDate = year+"/"+month+"/31";
		
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(startDate);
		cond.setPrclosetime(endDate);
		cond.setPrTypeArray(new String[]{"I","ID"});
		
		List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
		if(dataList != null){
			dto.setCurrentMouthEventCount(dataList.size());
		}else{
			dto.setCurrentMouthEventCount(0);
		}
		
		return dto;
	}
	
	/**
	 * ����:������ҳ������������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return ������������
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthProblemCount(IGDBM02DTO dto)  throws BLException{
		Calendar  c=new  GregorianCalendar();//�½����ڶ���  
		int  year=c.get(Calendar.YEAR);//��ȡ���  
		int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
		String startDate = year+"/"+month+"/01";
		String endDate = year+"/"+month+"/31";
		
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(startDate);
		cond.setPrclosetime(endDate);
		cond.setPrTypeArray(new String[]{"P","PD"});
		
		List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
		if(dataList != null){
			dto.setCurrentMouthProblemCount(dataList.size());
		}else{
			dto.setCurrentMouthProblemCount(0);
		}
		return dto;
	}
	
	/**
	 * 
	 * ����:������ҳ�����Ĺ�������ȡ�ô���
	 * @param IGDBM02DTO dto
	 * @return �����Ĺ�������
	 * @throws BLException
	 */
	public IGDBM02DTO getWorkCount(IGDBM02DTO dto)  throws BLException{
		Random rand = new Random();
		
		int a = rand.nextInt(15)+5;
		int b = rand.nextInt(15)+5;
		int c = rand.nextInt(15)+5;
		dto.setWorkCount(""+a +"|" +b +"|"+ c
				         +",��������|��������|�з�����");
		return dto;
	}
	

	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGDBM02DTO dto
	 * @return �¼�������ƽ�����ʱ��
	 * @throws BLException
	 */
	public IGDBM02DTO setEventAvgCost(IGDBM02DTO dto)  throws BLException{

		
		    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		    
		    content = content+"<LEFTMAXVALUE>" + "5" + "</LEFTMAXVALUE>";
		    content = content+"<RIGHTMAXVALUE>" + "150" + "</RIGHTMAXVALUE>";
		    content = content+"<LEFTLINE>" ;
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"<value>" + "5" + "</value>";
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"<value>" + "2" + "</value>";
		    content = content+"<value>" + "0" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "2" + "</value>";
		    content = content+"<value>" + "2" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "1" + "</value>";
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"</LEFTLINE>" ;
		    content = content+"<RIGHTLINE>" ;
		    content = content+"<value>" + "130" + "</value>";
		    content = content+"<value>" + "120" + "</value>";
		    content = content+"<value>" + "110" + "</value>";
		    content = content+"<value>" + "80" + "</value>";
		    content = content+"<value>" + "70" + "</value>";
		    content = content+"<value>" + "40" + "</value>";
		    content = content+"<value>" + "20" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "150" + "</value>";
		    content = content+"<value>" + "114" + "</value>";
		    content = content+"<value>" + "39" + "</value>";
		    content = content+"<value>" + "133" + "</value>";
		    content = content+"</RIGHTLINE>" ;
		    content = content+"</ROOT>";
		   dto.setResultXML(content);
		return dto;
	}
	

	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM02DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM02DTO setproProblemAvgSolute(IGDBM02DTO dto)  throws BLException{
		    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		    
		    content = content+"<LEFTMAXVALUE>" + "6" + "</LEFTMAXVALUE>";
		    content = content+"<RIGHTMAXVALUE>" + "100" + "</RIGHTMAXVALUE>";
		    content = content+"<LEFTLINE>" ;
		    content = content+"<value>" + "1" + "</value>";
		    content = content+"<value>" + "5" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "2" + "</value>";
		    content = content+"<value>" + "0" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "2" + "</value>";
		    content = content+"<value>" + "5" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "1" + "</value>";
		    content = content+"<value>" + "6" + "</value>";
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"</LEFTLINE>" ;
		    content = content+"<RIGHTLINE>" ;
		    content = content+"<value>" + "95" + "</value>";
		    content = content+"<value>" + "80" + "</value>";
		    content = content+"<value>" + "84" + "</value>";
		    content = content+"<value>" + "80" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "83" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "99" + "</value>";
		    content = content+"<value>" + "83" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "93" + "</value>";
		    content = content+"<value>" + "83" + "</value>";
		    content = content+"</RIGHTLINE>" ;
		    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	

	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM02DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM02DTO setproChangeAvgSuccess(IGDBM02DTO dto)  throws BLException{

		 
		    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		    
		    content = content+"<LEFTMAXVALUE>" + "26" + "</LEFTMAXVALUE>";
		    content = content+"<RIGHTMAXVALUE>" + "100" + "</RIGHTMAXVALUE>";
		    content = content+"<LEFTLINE>" ;
		    content = content+"<value>" + "11" + "</value>";
		    content = content+"<value>" + "15" + "</value>";
		    content = content+"<value>" + "14" + "</value>";
		    content = content+"<value>" + "22" + "</value>";
		    content = content+"<value>" + "20" + "</value>";
		    content = content+"<value>" + "14" + "</value>";
		    content = content+"<value>" + "26" + "</value>";
		    content = content+"<value>" + "5" + "</value>";
		    content = content+"<value>" + "4" + "</value>";
		    content = content+"<value>" + "10" + "</value>";
		    content = content+"<value>" + "6" + "</value>";
		    content = content+"<value>" + "3" + "</value>";
		    content = content+"</LEFTLINE>" ;
		    content = content+"<RIGHTLINE>" ;
		    content = content+"<value>" + "99" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "83" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "81" + "</value>";
		    content = content+"<value>" + "90" + "</value>";
		    content = content+"<value>" + "85" + "</value>";
		    content = content+"<value>" + "89" + "</value>";
		    content = content+"<value>" + "99" + "</value>";
		    content = content+"<value>" + "95" + "</value>";
		    content = content+"</RIGHTLINE>" ;
		    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:�����ɹ�������ͼ
	 * @param IGDBM02DTO dto
	 * @return �����ɹ���
	 * @throws BLException
	 */
	public IGDBM02DTO getPLine(IGDBM02DTO dto) throws BLException{
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
	 * ����:�����ɹ����Ǳ�
	 * @param IGDBM02DTO dto
	 * @return �����ɹ�����
	 * @throws BLException
	 */
	public IGDBM02DTO getStudy(IGDBM02DTO dto)throws BLException{
		dto.setMeter(95);
		return dto;
	}


	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}


	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
}

