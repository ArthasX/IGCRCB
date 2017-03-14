/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.dbm.bl.task.ChangeTendencyBL;
import com.deliverik.infogovernor.dbm.bl.task.IncidentTendencyBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCondImpl;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCondImpl;
import com.deliverik.infogovernor.kgm.bl.task.KnowLedgeInfoBL;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * @����������������������ҳBL
 * @���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.����ͳ��
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public class IGDBM03BLImpl extends BaseBLImpl implements IGDBM03BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**�¼�����BL*/
	protected IncidentTendencyBL incidentTendencyBL;
	
	/**�������BL*/
	protected ChangeTendencyBL changeTendencyBL;
	
	private CodeDetailBL codeDetailBL;
	
	/**֪ʶ���ѯBL */
	protected KnowLedgeInfoBL knowLedgeInfoBL;
	
	/** ���񹤵�BL */
	protected IG933BL ig933BL;
	
	/**
	 * ֪ʶ���ѯBL�趨
	 * @param knowLedgeInfoBL ֪ʶ���ѯBL
	 */
	public void setKnowLedgeInfoBL(KnowLedgeInfoBL knowLedgeInfoBL) {
		this.knowLedgeInfoBL = knowLedgeInfoBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}


	public void setIncidentTendencyBL(IncidentTendencyBL incidentTendencyBL) {
		this.incidentTendencyBL = incidentTendencyBL;
	}


	public void setChangeTendencyBL(ChangeTendencyBL changeTendencyBL) {
		this.changeTendencyBL = changeTendencyBL;
	}


    /**
	 * ���񹤵�BL�趨
	 * @param ig933BL ���񹤵�BL
	 */
	public void setIg933BL(IG933BL ig933bl) {
		ig933BL = ig933bl;
	}

	/**
     * 
     * ����:������ҳ�¼�����������󡢹�������ȡ�ô���
     * @param IGDBM03DTO dto
     * @return �¼�����������󡢹�����
     * @throws BLException
     */
    public IGDBM03DTO getProcessCount(IGDBM03DTO dto)  throws BLException{
        IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPrclosetime(null);
        List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        int countI = 0;
        int countP = 0;
        int countC = 0;
        int countS = 0;
        int countF = 0;
        for (IG500Info prBean : dataList) {
        	 for (CodeDetail cd : cds) {
        		 if(prBean.getPrpdid().startsWith(cd.getCvalue())){
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
        				 countI ++ ;
        			 }
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.PROBLEM_PRTYPE))){
        				 countP ++ ;
        			 }
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))){
        				 countC ++ ;
        			 }
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.SERVICE_PRTYPE))){
        				 countS ++ ;
        			 }
        		 }
             }
        }
        List<IG933Info> list = ig933BL.searchIG933InfoAll();
        if(list != null){
        	countF = list.size();
        }
        dto.setProcessCount("" + countI + "|" + countC + "|" + countP + "|" + countS + "|" + countF);
        return dto;
    }

	
	/**
	 * ����:���ɴ�����ҳ����ƻ�����xml
	 * @param IGDBM03DTO dto
	 * @return ����ƻ�����
	 * @throws BLException
	 */
	public IGDBM03DTO setChangePlan(IGDBM03DTO dto) throws BLException {
		String incident_prpdid = "01084";//Ĭ��ֵ
    	CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> codes = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : codes) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))){
        		incident_prpdid = cd.getCvalue();
        	}
        }
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
				//bug fix by wxd
				int dayofweek = c.get(Calendar.DAY_OF_WEEK);
				if(dayofweek==1){//sunday=1 �й�������
					dayofweek=7;
				}else{
					dayofweek=dayofweek-1;
				}
				c.add(Calendar.DATE,-dayofweek);
				//bug fix by wxd
			} else if ("back".equals(turnPageFlag)) {// ������ǰ�������ȡ�����ܵ�һ��
				c.add(Calendar.DATE, -8);
			}
			String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ROOT>\n";
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrpdid(incident_prpdid);
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
				          " url=\"IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01084&propentime="+formatChangePlan.format(c.getTime())+"&prclosetime="+ formatChangePlan.format(c.getTime()) + "&actname=ACT02SVC0401\"" +
				          " amount=\"4\"" +
				          " returnValue=\"" +formatterYMD.format(c.getTime()) + "\">\n";
				cond.setPropentime_like(formatChangePlan.format(c.getTime()));
				List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
				if(dataList !=null && dataList.size() >0){
					if(dataList.size()>3){
						dataList=dataList.subList(0, 3);
					}
					

					for(int j=0;j<dataList.size();j++){
						IG500Info prbean=dataList.get(j);
						String prtitle = prbean.getPrtitle();
						if (prtitle.getBytes().length > 10) {
                            for (int k = 0; ; k++) {
                                if(prtitle.substring(0, k).getBytes().length > 8) {
                                    prtitle = prtitle.substring(0, k-1) + "��";
                                    break;
                                }
                            }
                        }
						content = content + " <cplan color=\"1\">"+(j+1)+"." + prtitle +  "</cplan>\n";
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
	 * ����:���ɱ��¸��¼����Ͳ�ͬ����������xml
	 * @param IGDBM03DTO dto
	 * @return ���¸��¼����Ͳ�ͬ����������
	 * @throws BLException
	 */
	public IGDBM03DTO setAllTypeEventCount(IGDBM03DTO dto)  throws BLException{

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
     * @param IGDBM03DTO dto
     * @return �����¼�����
     * @throws BLException
     */
    public IGDBM03DTO getCurrentMouthEventCount(IGDBM03DTO dto)  throws BLException{
        Calendar  c=new  GregorianCalendar();//�½����ڶ���  
        int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
        
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
     * @param IGDBM03DTO dto
     * @return ������������
     * @throws BLException
     */
    public IGDBM03DTO getCurrentMouthProblemCount(IGDBM03DTO dto)  throws BLException{
        Calendar  c=new  GregorianCalendar();//�½����ڶ���  
        int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
        
        IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPropentime(startDate);
        cond.setPrclosetime(endDate);
        cond.setPrTypeArray(new String[]{"C","CD"});
        
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
	 * ����:��������������͹�������ȡ�ô���
	 * @param IGDBM03DTO dto
	 * @return �������͹�������
	 * @throws BLException
	 */
	public IGDBM03DTO getAllTypeWorkCount(IGDBM03DTO dto)  throws BLException{
		Random rand = new Random();
		
		
		dto.setAllTypeWorkCount(""+(rand.nextInt(99)+1) +"|" +(rand.nextInt(99)+1) +"|"+ (rand.nextInt(99)+1)+"|"+ (rand.nextInt(99)+1)+"|"+ (rand.nextInt(99)
				         +1)+",����Ѳ��|ϵͳ����|���ݵ���|ҵ��֧��|���մ���");
		return dto;
	}
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGDBM03DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException���¼����ƣ�
	 */
	public IGDBM03DTO setEventAvgCost(IGDBM03DTO dto)  throws BLException{
		String date = IGStringUtils.getCurrentDate();
		List<IncidentTendency> incidentList = new ArrayList<IncidentTendency>();
		IncidentTendencySearchCondImpl cond = new IncidentTendencySearchCondImpl();
		cond.setItyear(date.substring(0,4));
		cond.setItday(date.substring(8,10));
		incidentList = incidentTendencyBL.findIncidentTendencyByCond(cond, 0, 0);
		//����12���µĹر��¼�����
		int amount01 = 0;
		int amount02 = 0;
		int amount03 = 0;
		int amount04 = 0;
		int amount05 = 0;
		int amount06 = 0;
		int amount07 = 0;
		int amount08 = 0;
		int amount09 = 0;
		int amount10 = 0;
		int amount11 = 0;
		int amount12 = 0;
		//����12���µ�ƽ�����ʱ��
		int sucrate01 = 0;
		int sucrate02 = 0;
		int sucrate03 = 0;
		int sucrate04 = 0;
		int sucrate05 = 0;
		int sucrate06 = 0;
		int sucrate07 = 0;
		int sucrate08 = 0;
		int sucrate09 = 0;
		int sucrate10 = 0;
		int sucrate11 = 0;
		int sucrate12 = 0;
		
		int zuidashuliang = 5;
		int zuidashijian = 10;
		if(incidentList != null){
			for(int i = 0; i < incidentList.size(); i++){
				if(incidentList.get(i).getItamount() > zuidashuliang){
					zuidashuliang = incidentList.get(i).getItamount();
				}
				if(incidentList.get(i).getItaveragetime() > zuidashijian){
					zuidashijian = incidentList.get(i).getItaveragetime();
				}
				if("01".equals(incidentList.get(i).getItmonth())){
					amount01 = incidentList.get(i).getItamount();
					sucrate01 = incidentList.get(i).getItaveragetime();
				}else if("02".equals(incidentList.get(i).getItmonth())){
					amount02 = incidentList.get(i).getItamount();
					sucrate02 = incidentList.get(i).getItaveragetime();
				}else if("03".equals(incidentList.get(i).getItmonth())){
					amount03 = incidentList.get(i).getItamount();
					sucrate03 = incidentList.get(i).getItaveragetime();
				}else if("04".equals(incidentList.get(i).getItmonth())){
					amount04 = incidentList.get(i).getItamount();
					sucrate04 = incidentList.get(i).getItaveragetime();
				}else if("05".equals(incidentList.get(i).getItmonth())){
					amount05 = incidentList.get(i).getItamount();
					sucrate05 = incidentList.get(i).getItaveragetime();
				}else if("06".equals(incidentList.get(i).getItmonth())){
					amount06 = incidentList.get(i).getItamount();
					sucrate06 = incidentList.get(i).getItaveragetime();
				}else if("07".equals(incidentList.get(i).getItmonth())){
					amount07 = incidentList.get(i).getItamount();
					sucrate07 = incidentList.get(i).getItaveragetime();
				}else if("08".equals(incidentList.get(i).getItmonth())){
					amount08 = incidentList.get(i).getItamount();
					sucrate08 = incidentList.get(i).getItaveragetime();
				}else if("09".equals(incidentList.get(i).getItmonth())){
					amount09 = incidentList.get(i).getItamount();
					sucrate09 = incidentList.get(i).getItaveragetime();
				}else if("10".equals(incidentList.get(i).getItmonth())){
					amount10 = incidentList.get(i).getItamount();
					sucrate10 = incidentList.get(i).getItaveragetime();
				}else if("11".equals(incidentList.get(i).getItmonth())){
					amount11 = incidentList.get(i).getItamount();
					sucrate11 = incidentList.get(i).getItaveragetime();
				}else if("12".equals(incidentList.get(i).getItmonth())){
					amount12 = incidentList.get(i).getItamount();
					sucrate12 = incidentList.get(i).getItaveragetime();
				}
			}
		}
		if(zuidashuliang != 5){
			if(zuidashuliang%5 != 0){
				zuidashuliang = (zuidashuliang/5 + 1)*5;
			}
		}
		if(zuidashijian != 10){
			if(zuidashijian%5 != 0){
				zuidashijian = (zuidashijian/5 + 1)*5;
			}
		}
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    
	    content = content+"<LEFTMAXVALUE>" + zuidashuliang + "</LEFTMAXVALUE>";
	    content = content+"<RIGHTMAXVALUE>" + zuidashijian + "</RIGHTMAXVALUE>";
	    content = content+"<LEFTLINE>" ;
	    content = content+"<value>" + amount01 + "</value>";
	    content = content+"<value>" + amount02 + "</value>";
	    content = content+"<value>" + amount03 + "</value>";
	    content = content+"<value>" + amount04 + "</value>";
	    content = content+"<value>" + amount05 + "</value>";
	    content = content+"<value>" + amount06 + "</value>";
	    content = content+"<value>" + amount07 + "</value>";
	    content = content+"<value>" + amount08 + "</value>";
	    content = content+"<value>" + amount09 + "</value>";
	    content = content+"<value>" + amount10 + "</value>";
	    content = content+"<value>" + amount11 + "</value>";
	    content = content+"<value>" + amount12 + "</value>";
	    content = content+"</LEFTLINE>" ;
	    content = content+"<RIGHTLINE>" ;
	    content = content+"<value>" + sucrate01 + "</value>";
	    content = content+"<value>" + sucrate02 + "</value>";
	    content = content+"<value>" + sucrate03 + "</value>";
	    content = content+"<value>" + sucrate04 + "</value>";
	    content = content+"<value>" + sucrate05 + "</value>";
	    content = content+"<value>" + sucrate06 + "</value>";
	    content = content+"<value>" + sucrate07 + "</value>";
	    content = content+"<value>" + sucrate08 + "</value>";
	    content = content+"<value>" + sucrate09 + "</value>";
	    content = content+"<value>" + sucrate10 + "</value>";
	    content = content+"<value>" + sucrate11 + "</value>";
	    content = content+"<value>" + sucrate12 + "</value>";
	    content = content+"</RIGHTLINE>" ;
	    content = content+"</ROOT>";
	    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:���ɴ�����ҳ�������������ƽ�������xml
	 * @param IGDBM03DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException
	 */
	public IGDBM03DTO setproProblemAvgSolute(IGDBM03DTO dto)  throws BLException{

		
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
	 * @param IGDBM03DTO dto
	 * @return �������������ƽ�������
	 * @throws BLException(�������)
	 */
	public IGDBM03DTO setproChangeAvgSuccess(IGDBM03DTO dto)  throws BLException{

		
		String date = IGStringUtils.getCurrentDate();
		List<ChangeTendency> incidentList = new ArrayList<ChangeTendency>();
		ChangeTendencySearchCondImpl cond = new ChangeTendencySearchCondImpl();
		cond.setCtyear(date.substring(0,4));
		cond.setCtday(date.substring(8,10));
		incidentList = changeTendencyBL.findChangeTendencyByCond(cond, 0, 0);
		//����12���µĹر��¼�����
		int amount01 = 0;
		int amount02 = 0;
		int amount03 = 0;
		int amount04 = 0;
		int amount05 = 0;
		int amount06 = 0;
		int amount07 = 0;
		int amount08 = 0;
		int amount09 = 0;
		int amount10 = 0;
		int amount11 = 0;
		int amount12 = 0;
		//����12���µĳɹ���
		double sucrate01 = 0;
		double sucrate02 = 0;
		double sucrate03 = 0;
		double sucrate04 = 0;
		double sucrate05 = 0;
		double sucrate06 = 0;
		double sucrate07 = 0;
		double sucrate08 = 0;
		double sucrate09 = 0;
		double sucrate10 = 0;
		double sucrate11 = 0;
		double sucrate12 = 0;
		
		int zuidashuliang = 5;
		if(incidentList != null){
			for(int i = 0; i < incidentList.size(); i++){
				if(incidentList.get(i).getCtamount() > zuidashuliang){
					zuidashuliang = incidentList.get(i).getCtamount();
				}
				if("01".equals(incidentList.get(i).getCtmonth())){
					amount01 = incidentList.get(i).getCtamount();
					sucrate01 = incidentList.get(i).getCtsucRate();
				}else if("02".equals(incidentList.get(i).getCtmonth())){
					amount02 = incidentList.get(i).getCtamount();
					sucrate02 = incidentList.get(i).getCtsucRate();
				}else if("03".equals(incidentList.get(i).getCtmonth())){
					amount03 = incidentList.get(i).getCtamount();
					sucrate03 = incidentList.get(i).getCtsucRate();
				}else if("04".equals(incidentList.get(i).getCtmonth())){
					amount04 = incidentList.get(i).getCtamount();
					sucrate04 = incidentList.get(i).getCtsucRate();
				}else if("05".equals(incidentList.get(i).getCtmonth())){
					amount05 = incidentList.get(i).getCtamount();
					sucrate05 = incidentList.get(i).getCtsucRate();
				}else if("06".equals(incidentList.get(i).getCtmonth())){
					amount06 = incidentList.get(i).getCtamount();
					sucrate06 = incidentList.get(i).getCtsucRate();
				}else if("07".equals(incidentList.get(i).getCtmonth())){
					amount07 = incidentList.get(i).getCtamount();
					sucrate07 = incidentList.get(i).getCtsucRate();
				}else if("08".equals(incidentList.get(i).getCtmonth())){
					amount08 = incidentList.get(i).getCtamount();
					sucrate08 = incidentList.get(i).getCtsucRate();
				}else if("09".equals(incidentList.get(i).getCtmonth())){
					amount09 = incidentList.get(i).getCtamount();
					sucrate09 = incidentList.get(i).getCtsucRate();
				}else if("10".equals(incidentList.get(i).getCtmonth())){
					amount10 = incidentList.get(i).getCtamount();
					sucrate10 = incidentList.get(i).getCtsucRate();
				}else if("11".equals(incidentList.get(i).getCtmonth())){
					amount11 = incidentList.get(i).getCtamount();
					sucrate11 = incidentList.get(i).getCtsucRate();
				}else if("12".equals(incidentList.get(i).getCtmonth())){
					amount12 = incidentList.get(i).getCtamount();
					sucrate12 = incidentList.get(i).getCtsucRate();
				}
			}
		}
		
		if(zuidashuliang != 5){
			if(zuidashuliang%5 != 0){
				zuidashuliang = (zuidashuliang/5 + 1)*5;
			}
		}
		 
		    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		    
		    content = content+"<LEFTMAXVALUE>" + zuidashuliang + "</LEFTMAXVALUE>";
		    content = content+"<RIGHTMAXVALUE>" + "100" + "</RIGHTMAXVALUE>";
		    content = content+"<LEFTLINE>" ;
		    content = content+"<value>" + amount01 + "</value>";
		    content = content+"<value>" + amount02 + "</value>";
		    content = content+"<value>" + amount03 + "</value>";
		    content = content+"<value>" + amount04 + "</value>";
		    content = content+"<value>" + amount05 + "</value>";
		    content = content+"<value>" + amount06 + "</value>";
		    content = content+"<value>" + amount07 + "</value>";
		    content = content+"<value>" + amount08 + "</value>";
		    content = content+"<value>" + amount09 + "</value>";
		    content = content+"<value>" + amount10 + "</value>";
		    content = content+"<value>" + amount11 + "</value>";
		    content = content+"<value>" + amount12 + "</value>";
		    content = content+"</LEFTLINE>" ;
		    content = content+"<RIGHTLINE>" ;
		    content = content+"<value>" + sucrate01 + "</value>";
		    content = content+"<value>" + sucrate02 + "</value>";
		    content = content+"<value>" + sucrate03 + "</value>";
		    content = content+"<value>" + sucrate04 + "</value>";
		    content = content+"<value>" + sucrate05 + "</value>";
		    content = content+"<value>" + sucrate06 + "</value>";
		    content = content+"<value>" + sucrate07 + "</value>";
		    content = content+"<value>" + sucrate08 + "</value>";
		    content = content+"<value>" + sucrate09 + "</value>";
		    content = content+"<value>" + sucrate10 + "</value>";
		    content = content+"<value>" + sucrate11 + "</value>";
		    content = content+"<value>" + sucrate12 + "</value>";
		    content = content+"</RIGHTLINE>" ;
		    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}

	/**
	 * ����:�����¼����ȼ���Ӱ��̶ȡ������̶�xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setproincidentInfo(IGDBM03DTO dto)  throws BLException{
		Calendar  c=new  GregorianCalendar();//�½����ڶ���  
		int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
		IG500SearchCondImpl processrecordsearchcondimpl = new IG500SearchCondImpl();
		processrecordsearchcondimpl.setPrTypeArray(new String[]{"I"});
		processrecordsearchcondimpl.setPropentime(startDate);
		processrecordsearchcondimpl.setPrclosetime(endDate);
		String xml  = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		//���ȼ�
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		List<CodeDetail> cds = new ArrayList<CodeDetail>();
		cond.setCcid(CodeDefine.getCodeDefine("PROCESS_PRIORITY_I").getCcid());
		cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if(cds != null){
			xml +="<PIEGRAPH>";
			for(int i = 0; i < cds.size(); i++){
				processrecordsearchcondimpl.setPrpriority(cds.get(i).getCid());
				xml +="<VALUE title='"+cds.get(i).getCvalue()+"'>"+workFlowOperationBL.getProcessRecordSearchCount(processrecordsearchcondimpl)+"</VALUE>";
			}
			xml +="</PIEGRAPH>";
		}
		
		//�����̶�
		cond.setCcid(CodeDefine.getCodeDefine("IURGENCY_GRADE_CODE").getCcid());
		cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if(cds != null){
			xml +="<PIEGRAPH>";
			for(int i = 0; i < cds.size(); i++){
				processrecordsearchcondimpl.setPrpriority(null);
				processrecordsearchcondimpl.setPrurgency(cds.get(i).getCid());
				xml +="<VALUE title='"+cds.get(i).getCvalue()+"'>"+workFlowOperationBL.getProcessRecordSearchCount(processrecordsearchcondimpl)+"</VALUE>";
			}
			xml +="</PIEGRAPH>";
		}
		
		//Ӱ��̶�
		cond.setCcid(CodeDefine.getCodeDefine("IMPACT_GRADE_CODE").getCcid());
		cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if(cds != null){
			xml +="<PIEGRAPH>";
			for(int i = 0; i < cds.size(); i++){
				processrecordsearchcondimpl.setPrurgency(null);
				processrecordsearchcondimpl.setPrpriority(null);
				processrecordsearchcondimpl.setPrimpact(cds.get(i).getCid());
				xml +="<VALUE title='"+cds.get(i).getCvalue()+"'>"+workFlowOperationBL.getProcessRecordSearchCount(processrecordsearchcondimpl)+"</VALUE>";
			}
			xml +="</PIEGRAPH>";
		}
		
		
		
		xml +="</ROOT>";
		dto.setResultXML(xml);
		return dto;
	}
	
	/**
	 * ����:����֪ʶ����ռ��xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setKnowledgeInfo(IGDBM03DTO dto)  throws BLException{
		KnowledgeSearchCondImpl knowledgesearchcond = new KnowledgeSearchCondImpl();
		int totalCount = knowLedgeInfoBL.getSearchCount(knowledgesearchcond);
		String xml  = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		List<CodeDetail> cds = new ArrayList<CodeDetail>();
		cond.setCcid(CodeDefine.getCodeDefine("KNOWLEDGE_TYPE_CODE").getCcid());
		cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		if(cds != null){
			int sum = 0;
			int num = 0;
			xml +="<PIEGRAPH>";
			for(int i = 0; i < cds.size(); i++){
				knowledgesearchcond.setKnclass_like(cds.get(i).getSyscoding().substring(0, 6));
				num = knowLedgeInfoBL.getSearchCount(knowledgesearchcond);
				sum = sum + num;
				xml +="<VALUE title='"+cds.get(i).getCvalue()+"'>"+num+"</VALUE>";
			}

			xml +="<VALUE title='"+"�޷���"+"'>"+(totalCount-sum)+"</VALUE>";

			xml +="</PIEGRAPH>";
		}
		
		xml +="</ROOT>";
		dto.setResultXML(xml);
		return dto;
	}
	
	
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}


	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public static void main(String[] args){
		Calendar c=Calendar.getInstance();
		//c.getFirstDayOfWeek();
		for (int i = 1; i <= 7; i++) {
			
			System.out.println();
		}
	}
	
}

