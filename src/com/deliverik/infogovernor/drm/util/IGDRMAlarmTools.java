package com.deliverik.infogovernor.drm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG506BL;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.CustomQueryBL;
import com.deliverik.infogovernor.drm.bl.task.OptionSencesBL;
import com.deliverik.infogovernor.drm.bl.task.ResponseStrategyBL;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;
import com.deliverik.infogovernor.drm.strategy.StrategyCheckBL;

/**
 * Ӧ������_�澯��鹤����
 * 
 * @author Ken
 *
 */
public class IGDRMAlarmTools {
	static Log log = LogFactory.getLog(IGDRMAlarmTools.class);
	private static FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
	private static SOC0119BL soc0119BL = (SOC0119BL) WebApplicationSupport.getBean("soc0119BL");

	private static ResponseStrategyBL responseStrategyBL = (ResponseStrategyBL) WebApplicationSupport.getBean("responseStrategyBL");

	private static FlowSetBL flowSetBL = (FlowSetBL) WebApplicationSupport.getBean("flowSetBL");
	private static IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
	private static IG506BL ig506BL = (IG506BL) WebApplicationSupport.getBean("ig506BL");
	private static UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
	private static SOC0118BL soc0118BL = (SOC0118BL) WebApplicationSupport.getBean("soc0118BL");
	private static OptionSencesBL optionSencesBL = (OptionSencesBL) WebApplicationSupport.getBean("optionSencesBL");
	/**
	 * ����Ӧ��ָ������
	 * 
	 * @param prtitle
	 * @return
	 */
	public static Integer initDirectProcess(String prtitle, Integer planEiid, Integer[] senceEiids, Integer[] sysEiids, String alarmTime, String alarmMsg, String alarmTitle) {

		WorkFlowLog logInfo = new WorkFlowLog();
		// ���������ó�ϵͳ����Ա
		logInfo.setExecutorid("admin");
		// �����ɫ���óɷ���̨
		logInfo.setExecutorRoleid(1205);
		ProcessRecord processRecord = new ProcessRecord(logInfo);
		processRecord.setTitle(prtitle);
		processRecord.setDescription("�澯����");
		
		Map<String, String> formvalue = new HashMap<String, String>();
		formvalue.put("�¼�����", alarmTitle);
		formvalue.put("�¼��ϱ�ʱ��", alarmTime);
		formvalue.put("�¼�����ʱ��", alarmTime);
		formvalue.put("�¼�����", alarmMsg);
		processRecord.setFormvalue(formvalue);
		// ���̶���
		processRecord.setDefid(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
		Integer prid = 0;
		try {
			// ��������
			prid = flowOptBL.saveProcessAction(processRecord);
			logInfo.setPrid(prid);
			IG500TB processInfo = (IG500TB) ig500BL.searchIG500InfoByKey(prid);
			processInfo.setPrurgency("0");
			ig500BL.updateIG500Info(processInfo);
			User userInfo = userBL.searchUserByKey("admin");
			IG506TB ig506Tb = new IG506TB();
			ig506Tb.setPiorgid(userInfo.getOrgid());
			ig506Tb.setPiorgname(userInfo.getOrgname());
			ig506Tb.setPiphone(userInfo.getUserphone());
			ig506Tb.setPiroleid(1);
			ig506Tb.setPirolename("ϵͳ����Ա");

			ig506Tb.setPiuserid("admin");
			ig506Tb.setPiusername("ϵͳ����Ա");
			ig506Tb.setPrid(prid);
			IG506Info ig506Info = null;
			try{
				ig506Info = ig506BL.registIG506(ig506Tb);
				
				
				
				PublicProcessInfoValue ppiv = new PublicProcessInfoValue(logInfo);
				ppiv.setFormname("�¼��ϱ���");
				ppiv.setFormvalue(""+ig506Info.getPiuid());
				flowSetBL.setPublicProcessInfoValue(ppiv);
			}catch(Exception e){
				log.error("==========�����¼��ϱ�����Ա������===========");
				e.printStackTrace();
			}
			
			
			// ��������-�ʲ�������ϵ
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.PLAN_NAME, planEiid, null);
			// flowSetBL.setProcessEntityRelation(prid,
			// IGDRMCONSTANTS.SCENE_ITEM_NAME, senceEiid, null);
			// ��ӱ�ѡ����
			for (Integer senceEiid : senceEiids) {
				OptionSencesTB osTb = new OptionSencesTB();
				osTb.setPrid(prid);
				osTb.setSenceEiid(senceEiid);
				optionSencesBL.registOptionSences(osTb);
			}
			for (Integer eiid : sysEiids) {
				flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.ITEM_SYSTEM_FORM_NAME, eiid, null,"1");
			}

		} catch (Exception e) {
			log.error("�Զ�����Ӧ��ָ�����̳���!");
			e.printStackTrace();
		}

		return prid;
	}

	/**
	 * ���澯��Ϣ�Ƿ��ܹ���������
	 * 
	 * @param alarmMsg
	 * @throws Exception
	 */
	public static int monitorAlarm(String alarmMsg, boolean isShield) {

		// ��������θ澯,�򲻴���
		if (isShield) {
			return 0;
		}
		String[] contents = alarmMsg.split("[|]");
		String alarmTitle = contents[0];
		
		// �澯ip
		String alarmip = contents[1].substring(1, contents[1].length() - 1);
		//�澯����
		String alarmContent = contents[3];
		
		//�澯����
				String alarmTime = contents[4];
		//�澯���к�
		String alarmSerial = contents[2].substring(1, contents[2].length()-1);

		// ��ѯ���澯�豸���ʲ���Ϣ
		List<Map<String, Object>> result = null;
		try {
			result = getEntityByIP(alarmip);
		} catch (Exception e) {
			log.error("����IP��ѯ�ʲ���Ϣ����,IP>>" + alarmip);
			e.printStackTrace();
			// throw new Exception("����IP��ѯ�ʲ���Ϣ����");
			return 0;
		}

		if (result == null || result.size() == 0) {
			log.error("û���ҵ�IP��Ӧ���豸,IP>>" + alarmip);
			// throw new Exception("û���ҵ�IP��Ӧ���豸");'
			return 0;
		}

		Map<String, Object> entityMap = result.get(0);

//		if (IGDRMCONSTANTS.CUNCU_ESYSCODING.equals(entityMap.get("ESYSCODING").toString())) {
//			// �洢�豸�Ĵ�������
//
//		} else if (IGDRMCONSTANTS.WANGLUO_ESYSCODING.equals(entityMap.get("ESYSCODING").toString())) {
//			// �����豸�Ĵ�������
//		} else 
		{
			// �����豸����ҵ��ϵͳ��Ԥ��

			String[] sysEiids = null;

			sysEiids = getSysId(alarmip);

			if (sysEiids == null) {
				log.warn("========û�в�ѯ����ҵ��ϵͳ,�豸eiid:" + entityMap.get("EIID").toString() + "=========");
				return 0;
			}

			// ��������̵�����
			int successNum = 0;
			for (String sysEiidStr : sysEiids) {
				Integer sysEiid = Integer.valueOf(sysEiidStr);

				// ����ҵ��ϵͳ��ѯԤ��
				Integer[] planEiids = searchPlanBySysId(sysEiid);
				if (planEiids == null || planEiids.length == 0) {
					log.warn("================û���ҵ�<" + entityMap.get("EINAME") + ">ҵ��ϵͳ��ص�ר��Ԥ��==================");
					continue;
				}

				// ����Ԥ���ҵ����ɴ��������ĳ���
				for (Integer planeiid : planEiids) {
					// ��ѯ�������ĳ�����Ϣ
					Integer[] senceEiids = searchSenceByPlan(planeiid);
					// �����ܹ����㴥�������ĳ���id����
					List<Integer> availableSenceEiids = new ArrayList<Integer>();
					SOC0118Info entity = null;
					try {
						entity = soc0118BL.searchEntityItemByKey(planeiid);
					} catch (Exception e) {
						e.printStackTrace();
						log.warn("=======��ѯԤ����Ϣ����Ԥ��Id��" + planeiid + "=========");
					}
					if (senceEiids != null) {
						
						// ����������ѯ��ƥ���ϵĳ���
						senceLoop: for (Integer senceEiid : senceEiids) {
							List<ResponseStrategyInfo> responseStrategyList = searchResponseStrategyBySenceid(senceEiid);
							// ����ó����д�������,���ж��Ƿ��ܹ�����,���������,�򱣴泡����eiid��������
							if (responseStrategyList != null && responseStrategyList.size() > 0) {
								for (ResponseStrategyInfo responseStrategyInfo : responseStrategyList) {
									if (!checkStrategy(responseStrategyInfo, alarmContent)) {
										continue senceLoop;
									}
								}
								availableSenceEiids.add(senceEiid);
							}

						}
						String desc = "�澯����Ӧ�����澯���кţ�"+alarmSerial+"/n/t"+"�澯������"+alarmContent;
						// ����������㴥�������ĳ���,����Ӧ��ָ������

						if (availableSenceEiids.size() > 0) {
							try {
								int prid = initDirectProcess("�澯����Ӧ��_" + entity.getEiname(), planeiid, availableSenceEiids.toArray(new Integer[] { 0 }), new Integer[] { sysEiid }, alarmTime, desc, "�澯-" + entity.getEiname());
								if (prid > 0) {
									successNum++;
									log.info("============ͨ���澯����Ӧ��ָ�����̳ɹ� ,����id" + prid + "=============");
								}
							} catch (Exception e) {
								log.error("==============���ݸ澯�������̱����澯���кš�" + alarmSerial + "��=================");
								e.printStackTrace();
								// throw new Exception("����Ӧ��ָ�����̱���");
							}
						}
					}
				}
			}

			return successNum;
		}



	}

	/**
	 * �ж��Ƿ��ܹ����㴥������
	 * 
	 * @param responseStrategyInfo
	 * @param msg
	 * @return
	 */
	private static boolean checkStrategy(ResponseStrategyInfo responseStrategyInfo, String msg) {

		boolean flag = true;

		String[] keys = responseStrategyInfo.getKeyword().split(" ");

		for (String key : keys) {
			if (StringUtils.isNotEmpty(key)&&!msg.contains(key)) {
				flag = false;
				return false;
			}
		}
		StrategyCheckBL scBL = null;

		if (StringUtils.isNotEmpty(responseStrategyInfo.getHandleBL())) {
			try {
				scBL = (StrategyCheckBL) WebApplicationSupport.getBean(responseStrategyInfo.getHandleBL());

			} catch (Exception e) {
				log.error("==========û���ҳ��������������⴦��BL===========");
				log.error(e.getMessage());
			}
			if (scBL != null)
			flag = scBL.check(msg,responseStrategyInfo.getRsargs());

		}

		return flag;

	}

	/**
	 * ��ѯ���澯�豸���ʲ���Ϣ
	 * 
	 * @param alarmip
	 * @return
	 * @throws BLException
	 */
	private static List<Map<String, Object>> getEntityByIP(String alarmip) throws BLException {
		CustomQueryBL cusQueryBL = (CustomQueryBL) WebApplicationSupport.getBean("customQueryBL");

		String sql = "SELECT EIID , EID,EIIP,EINAME,ESYSCODING  FROM TEMP0167 WHERE eiip = '" + alarmip + "'";
		Map<String, Type> resultField = new HashMap<String, Type>();

		resultField.put("EIID", Hibernate.STRING);
		resultField.put("EID", Hibernate.STRING);
		resultField.put("EIIP", Hibernate.STRING);
		resultField.put("EINAME", Hibernate.STRING);
		resultField.put("ESYSCODING", Hibernate.STRING);
		List<Map<String, Object>> result = null;
		try {
			result = cusQueryBL.queryBySql(sql, resultField);
		} catch (Exception e) {
			log.error("=======����IP��ѯ�豸����,IP:" + alarmip + "=========");
			log.error(e.getMessage());
		}
		return result;
	}

	/**
	 * ����ҵ��ϵͳ��ѯԤ��
	 * 
	 * @param eiid
	 * @throws BLException
	 */
	private static Integer[] searchPlanBySysId(Integer eiid) {


		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();

		cond.setEirrelation("03");

		cond.setEirrelationcode("080-040");

		cond.setDeleteflag("0");
		
		cond.setCldeiid(eiid);

		Set<Integer> planEiidSet = new HashSet<Integer>();
		Integer[] planEiids = null;
		try {
					List<SOC0119Info> elList = soc0119BL.searchEntityItemRelation(cond);
					if(elList!=null&&elList.size()>0){
						
						for (SOC0119Info soc0119Info : elList) {
							planEiidSet.add(soc0119Info.getPareiid());
						}
						planEiids = planEiidSet.toArray(new Integer[0]);
					}
						
						
					
		} catch (Exception e) {
			log.error("����ҵ��ϵͳeiid��ѯ����Ԥ������,ҵ��ϵͳeiid>>>" + eiid);
			log.equals(e.getMessage());
		}

		return planEiids;
	}

	/**
	 * ����Ԥ����ѯ����
	 * 
	 * @param eiid
	 * @throws BLException
	 */
	private static Integer[] searchSenceByPlan(Integer planeiid) {

		Integer[] senceEiids = null;
		
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setPareiid(planeiid);
		cond.setEirrelation("01");
		cond.setEirrelationcode("080-060");
		try {
			senceEiids = soc0119BL.searchCldeiidByPareiid(cond).toArray(new Integer[0]);
		} catch (BLException e) {
			log.error("==============����ר��Ԥ����ѯ��������,Ԥ��id:" + planeiid + "=======================");
			log.equals(e.getMessage());
		}

		return senceEiids;
	}

	/**
	 * ��ѯ�����Ĵ�������
	 */
	private static List<ResponseStrategyInfo> searchResponseStrategyBySenceid(Integer senceid) {
		List<ResponseStrategyInfo> responseStrategyList = null;

		ResponseStrategySearchCondImpl cond = new ResponseStrategySearchCondImpl();

		cond.setSenceid(senceid);

		try {
			responseStrategyList = responseStrategyBL.searchResponseStrategy(cond);
		} catch (BLException e) {
			log.error("=======================��ѯ�����������Գ���,����id:" + senceid + "=====================");
			log.equals(e.getMessage());
		}

		return responseStrategyList;
	}

	/**
	 * ����BSMƽ̨��ȡҵ��ϵͳid
	 */
	private static String[] getSysId(String IP) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlString = ResourceUtility.getString("GETBUINESSEIID_URL");
			URL url = new URL(urlString + IP);

			URLConnection connection = url.openConnection();
			// ����ͨ�õ���������
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (MalformedURLException e) {
			log.equals(e.getMessage());
		}
		catch (IOException e) {
			log.equals(e.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				log.equals(e2.getMessage());
			}
		}

		return ("-1".equals(result) || StringUtils.isEmpty(result) ? null : result.split("_"));

	}

}


