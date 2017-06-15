/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0306BL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0306TB;


/**
 * ����:�Զ����ɸ澯
 * �޸ļ�¼��
 */
public class AutoAlarmRun implements Job{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** log���� */
	static Log log = LogFactory.getLog(AutoAlarmRun.class);
	

/*
	protected static ReportConfigurationBL reportConfigurationBL = (ReportConfigurationBL) WebApplicationSupport
			.getBean("reportConfigurationBL");*/

	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			log.debug("================================�Զ����ɸ澯��ʼ "+new Date()+"=======================================");  
			SOC0306BL soc0306BL = (SOC0306BL) WebApplicationSupport
					.getBean("natureIuportAlarmBL");
			//����ǰһ������
			Calendar c = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			c.setTime(new Date());
			c.add(Calendar.DATE, -1);
			Date d2 = c.getTime();
			String yestoday = df.format(d2);

			List colList = soc0306BL.searchSymmetrixAlarm(yestoday);
			SOC0306SearchCondImpl cond=new SOC0306SearchCondImpl();
			cond.setDataitmes(yestoday);
			List<SOC0306Info> natureIuportAlarmList=soc0306BL.findSoc0306ByCond(cond, 0, 0);
			List<String> listTemp=new ArrayList<String>();
			if(natureIuportAlarmList!=null&&natureIuportAlarmList.size()>0){
				if(colList!=null&&colList.size()>0){
					for(SOC0306Info natureIuportAlarm:natureIuportAlarmList){
						String symmid_Datatime=natureIuportAlarm.getSymmid()+":"+natureIuportAlarm.getDataitmes();
						listTemp.add(symmid_Datatime);
					}
					//ѭ��������ȱʧ���ܵ������ݵı�����¼
					for(int i=0;i<colList.size();i++){
						Object[] coll = (Object[]) colList.get(i);
						String symmid_DatatimeTwo=(String)coll[0]+":"+yestoday;
						if(!listTemp.contains(symmid_DatatimeTwo)){
							SOC0306TB niaTB = new SOC0306TB();
							niaTB.setSymmid((String)coll[0]);
							niaTB.setSymtype((String)coll[1]);
							niaTB.setDataitmes(yestoday);
							soc0306BL.saveSoc0306(niaTB);
						}
					}
				}
			}else{
				if(colList!=null&&colList.size()>0){
					//ѭ��������ȱʧ���ܵ������ݵı�����¼
					for(int i=0;i<colList.size();i++){
						Object[] coll = (Object[]) colList.get(i);
						SOC0306TB niaTB = new SOC0306TB();
						niaTB.setSymmid((String)coll[0]);
						niaTB.setSymtype((String)coll[1]);
						niaTB.setDataitmes(yestoday);
						soc0306BL.saveSoc0306(niaTB);
					}
				}
			}
		} catch (Exception e) {
			log.debug(e);  
			e.printStackTrace();
		}
	}
}
