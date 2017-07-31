/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.workItem.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.bl.task.WorkLogBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCondImpl;

/**
 * 
 * @Description ������-����ʵ������BLʵ��
 *
 * @date 2017��6��22��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindBLImpl extends BaseBLImpl implements WorkRemindBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(WorkRemindBLImpl.class);
	
	/** ���Ͷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** ��������BL */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** ����ʵ��BL */
	protected WorkInstanceBL workInstanceBL;
	
	/** ������־BL */
	protected WorkLogBL workLogBL; 
	
	/** ������������ϸBL */
	protected CodeDetailBL codeDetailBL;
	
	/**
	 * ���Ͷ���BL�趨
	 *
	 * @param sendMessageBL ���Ͷ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}
	
	/**
	 * ��������BL�趨
	 * @param ��������BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}


	/**
	 * ����ʵ��BL�趨
	 * @param ����ʵ��BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}

	/**
	 * ������־BL
	 * @param ������־BL
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}

	/**
	 * ������������ϸBL�趨
	 * @param ������������ϸBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ����ʵ������
	 */
	public void workInstanceRemind() throws BLException{
		log.info("=========����ʵ�����ѿ�ʼ=========");
		//����ʵ��ÿ������
		everyDayRemind();
		//����ʵ����ʱ����
		overTimeTips();
    	log.info("=========����ʵ�����ѽ���=========");
    }
	
	/**
	 * ����ʵ��ÿ������
	 * @throws BLException
	 */
	public void everyDayRemind() throws BLException{
		log.info("=========����ʵ��ÿ�����Ѵ���ʼ=========");
		
		//=====1.���ù��������BL<��������ʵ�����췢������й���ʵ���������ݹ���ʵ��״̬Ϊ��δִ�л�ִ���У�״̬����ɸѡ>=====
		List<WorkInstanceInfo> workInstance = workInstanceBL.findInstanceByTips();
		
		//=====2.����Ϊ�գ�<ѭ�����������ȡÿһ������ʵ����ִ����>=====
		if(workInstance!=null && workInstance.size()>0){
			for (int i = 0; i < workInstance.size(); i++) {
				//��ȡִ����id
				String excutorId = workInstance.get(i).getExcutorId();
				//��ȡִ����name
				String excutorName = workInstance.get(i).getExcutorName();
				
				//=====3.Ȼ��<���ݹ���wiid��ʵ��������������������־��>����<����btnAction�ֶ�Ϊ1��1Ϊ[�ύ]������0Ϊ[����]����������������Ϊϵͳ��ǰ����likeɸѡ>����ȷ�ϵ�����=====
				WorkLogSearchCondImpl logCond = new WorkLogSearchCondImpl();
				logCond.setWiid(workInstance.get(i).getWiid());	//�����������ʵ��wiid
				logCond.setTitleDate(IGStringUtils.getCurrentDate());	//��������������
				logCond.setBtnAction("1");	//���ò�����ťΪ1��1���ύ��2�����棩
				//����BL������ȷ�Ϲ�����ִ������־��Ϣ����
				List<WorkLogInfo> workLog = workLogBL.searchWorkLog(logCond);
				
				//=====4.�����־��Ϣ��Ϊ�գ�ɸѡ��Ͷ�Ӧ����ʵ�����<��ִ����һһ�滻>��Ϊ������Ҫ���ѹ���ʵ����ȫ��ִ����,��Ϊ�������Ѿ���ɸѡ�滻��ʣ����û�=====
				if(workLog!=null && workLog.size()>0){
					
					//ɸѡ��δȷ�ϵ��չ�����ִ���ˣ����ж�������
					for (int j = 0; j < workLog.size(); j++) {
						
						if(excutorId.contains(workLog.get(j).getExcutorId()+"��")){
							//�滻����������userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId()+"��","");
							
						}else{
							//�滻������������userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId(),"");
						}
						
						//������������ġ�����
						if(StringUtils.isNotEmpty(excutorId) && "��".equals(excutorId.substring(excutorId.length()-1))){
							
							excutorId = excutorId.substring(0, excutorId.length()-1);
						}
						if(StringUtils.isNotEmpty(excutorId)){
							for (int x = 0; x < excutorId.split("��").length; x++) {
								//����ÿ�����Ѷ���
								sendEveryDayMessage(excutorId.split("��")[x], 
										workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
								
								log.info("�������������������ѷ���ÿ�չ������Ѷ��ŵĹ������ƣ�"+workInstance.get(i).getWdname()
										+"�����ѵ��û�ID��"+excutorId.split("��")[x]+"�����ѵ��û�����"+excutorName.split("��")[x]+"��������������������");
							}
						}
					}
				}else{
					//��Ҫһһ���Ѹù���ʵ����ִ����
					if(StringUtils.isNotEmpty(excutorId)){
						for (int x = 0; x < excutorId.split("��").length; x++) {
							//����ÿ�����Ѷ���
							sendEveryDayMessage(excutorId.split("��")[x], 
									workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
							log.info("�������������������ѷ���ÿ�չ������Ѷ��ŵĹ������ƣ�"+workInstance.get(i).getWdname()
									+"�����ѵ��û�ID��"+excutorId.split("��")[x]+"�����ѵ��û�����"+excutorName.split("��")[x]+"��������������������");
						}
					}
				}
				
			}
		}
		log.info("=========����ʵ��ÿ�����Ѵ���ʼ=========");
	}
	
	/**
	 * ������ʱ����
	 * @throws BLException
	 */
	public void overTimeTips() throws BLException{
		log.info("==========����ʵ����ʱ���Ѵ���ʼ==========");
		//=====1.���ù��������BL<��������ʵ�����췢������й���ʵ���������ݹ���ʵ��״̬Ϊ��δִ�л�ִ���У�״̬����ɸѡ>=====
		List<WorkInstanceInfo> workInstance = workInstanceBL.findInstanceByTips();
		
		//=====2.����Ϊ�գ�<ѭ�����������ȡÿһ������ʵ����ִ����>=====
		if(workInstance!=null && workInstance.size()>0){
			for (int i = 0; i < workInstance.size(); i++) {
				//��ȡִ����id
				String excutorId = workInstance.get(i).getExcutorId();
				//��ȡִ����name
				String excutorName = workInstance.get(i).getExcutorName();
				//ȡ�ù�����������
				WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(workInstance.get(i).getWdid());
				
				//=====3.Ȼ��<���ݹ���wiid��ʵ��������������������־��>����<����btnAction�ֶ�Ϊ1��1Ϊ[�ύ]������0Ϊ[����]����������������Ϊϵͳ��ǰ����likeɸѡ>����ȷ�ϵ�����=====
				WorkLogSearchCondImpl logCond = new WorkLogSearchCondImpl();
				logCond.setWiid(workInstance.get(i).getWiid());	//�����������ʵ��wiid
				logCond.setTitleDate(IGStringUtils.getCurrentDate());	//��������������
				logCond.setBtnAction("1");	//���ò�����ťΪ1��1���ύ��2�����棩
				//����BL������ȷ�Ϲ�����ִ������־��Ϣ����
				List<WorkLogInfo> workLog = workLogBL.searchWorkLog(logCond);
				
				//=====4.�����־��Ϣ��Ϊ�գ�ɸѡ��Ͷ�Ӧ����ʵ�����<��ִ����һһ�滻>��Ϊ������ݳ�ʱ�������ü��㣬
				//���ѳ�ʱͨ����������ȫ��ִ����,��Ϊ�ո��ݳ�ʱ�������ü��㣬���ѳ�ʱ���Ѿ���ɸѡ�滻��ʣ����û�=====
				if(workLog!=null && workLog.size()>0){
					
					//ɸѡ��δȷ�ϵ��չ�����ִ���ˣ����ж�������
					for (int j = 0; j < workLog.size(); j++) {
						
						if(excutorId.contains(workLog.get(j).getExcutorId()+"��")){
							//�滻����������userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId()+"��","");
							
						}else{
							//�滻������������userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId(),"");
						}
						
						//������������ġ�����
						if(StringUtils.isNotEmpty(excutorId) && "��".equals(excutorId.substring(excutorId.length()-1))){
							
							excutorId = excutorId.substring(0, excutorId.length()-1);
						}
						
						//δȷ�Ϲ�����ִ���˽����
						if(StringUtils.isNotEmpty(excutorId)){
							
							for (int x = 0; x < excutorId.split("��").length; x++) {
								
								//��ȡ����ʵ��Ԥ�����ʱ��+��ʱ�������� > ϵͳ���ڣ�����Ҫ���ѣ����� ������
								Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
										Integer.parseInt(workDefinitionInfo.getOvertimeTipsTime()));
								
								if(compairDate(dateAfter, new Date())==-1){
									
									//���ͳ�ʱ���Ѷ���
									sendOverTimeMessage(excutorId.split("��")[x], 
											workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
									log.info("�������������������Ѽ��뷢�ͳ�ʱ�������Ѷ��ŵĹ������ƣ�"+workInstance.get(i).getWdname()
											+"�����ѵ��û�ID��"+excutorId.split("��")[x]+"�����ѵ��û�����"+excutorName.split("��")[x]+"��������������������");
								};
								
							}
						}
					}
				}else{
					//����ʵ������ִ���˽����
					if(StringUtils.isNotEmpty(excutorId)){
						for (int x = 0; x < excutorId.split("��").length; x++) {
							//��ȡ����ʵ��+��ʱ�������� > ϵͳ���ڣ�����Ҫ���ѣ����� ������
							Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
									Integer.parseInt(workDefinitionInfo.getOvertimeTipsTime()));
							
							if(compairDate(dateAfter, new Date())==-1){
								
								//���ͳ�ʱ���Ѷ���
								sendOverTimeMessage(excutorId.split("��")[x], 
										workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
								log.info("�������������������Ѽ��뷢�ͳ�ʱ�������Ѷ��ŵĹ������ƣ�"+workInstance.get(i).getWdname()
										+"�����ѵ��û�ID��"+excutorId.split("��")[x]+"�����ѵ��û�����"+excutorName.split("��")[x]+"��������������������");
							};
						}
					}
				}
				
			}
		}
		log.info("==========����ʵ����ʱ���Ѵ������==========");
	}
	
	
	/**
	 * @Description ����ÿ�����Ѷ���
	 * @param userid �û�userid
	 * @param workName ��������
	 * @param launchDate ������������
	 * @return
	 */
	private String sendEveryDayMessage(String userid,String workName,String launchDate){
		//��������
		String msg = "ÿ�չ������ѣ�����һ�ݹ�������Ϊ��"+workName+"���������ǣ�"+launchDate+" �Ĺ�������������������ɹ�����";
		//���Ͷ���
		sendMessageBL.sendSmsToUser(userid, msg);
		return msg;
	}
	
	/**
	 * @Description ���ͳ�ʱ���Ѷ���
	 * @param userid �û�userid
	 * @param workName ��������
	 * @param launchDate ������������
	 * @return
	 */
	private String sendOverTimeMessage(String userid,String workName,String launchDate){
		//��������
		String msg = "������ʱ���ѣ�����һ�ݹ�������Ϊ��"+workName+"���������ǣ�"+launchDate+" �Ĺ����ѳ�ʱ������������ɹ�����";
		//���Ͷ���
		sendMessageBL.sendSmsToUser(userid, msg);
		return msg;
	}
	
	/**
	 * ��ȡ���ں��������
	 * @param d ���������
	 * @param day ���ӵ�����
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //���õ�ϵͳ����
        now.setTime(d);
        //ϵͳ����+��
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * �Ƚ����ڴ�С
	 * @param dt1 ����1
	 * @param dt2 ����2
	 * @return ����1������1>����2������-1������1<����2������0������1=����2
	 */
	private int compairDate(Date dt1,Date dt2){
		
		if(dt1.getTime() > dt2.getTime()){
			return 1;
		}else if(dt1.getTime() < dt2.getTime()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * �ַ�����ʽת������
	 * @param str �ַ���
	 * @return ����
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("�ַ���ǿת�����ڸ�ʽʧ�ܣ�Ҫת�����ַ���:"+str+"\n�ࣺWorkRemindBLImpl��������strParseDate() Line��331\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
}
