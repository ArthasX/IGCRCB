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
 * 应急管理_告警检查工具类
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
	 * 发起应急指挥流程
	 * 
	 * @param prtitle
	 * @return
	 */
	public static Integer initDirectProcess(String prtitle, Integer planEiid, Integer[] senceEiids, Integer[] sysEiids, String alarmTime, String alarmMsg, String alarmTitle) {

		WorkFlowLog logInfo = new WorkFlowLog();
		// 发起人设置成系统管理员
		logInfo.setExecutorid("admin");
		// 发起角色设置成服务台
		logInfo.setExecutorRoleid(1205);
		ProcessRecord processRecord = new ProcessRecord(logInfo);
		processRecord.setTitle(prtitle);
		processRecord.setDescription("告警发起");
		
		Map<String, String> formvalue = new HashMap<String, String>();
		formvalue.put("事件名称", alarmTitle);
		formvalue.put("事件上报时间", alarmTime);
		formvalue.put("事件发生时间", alarmTime);
		formvalue.put("事件描述", alarmMsg);
		processRecord.setFormvalue(formvalue);
		// 流程定义
		processRecord.setDefid(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
		Integer prid = 0;
		try {
			// 发起流程
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
			ig506Tb.setPirolename("系统管理员");

			ig506Tb.setPiuserid("admin");
			ig506Tb.setPiusername("系统管理员");
			ig506Tb.setPrid(prid);
			IG506Info ig506Info = null;
			try{
				ig506Info = ig506BL.registIG506(ig506Tb);
				
				
				
				PublicProcessInfoValue ppiv = new PublicProcessInfoValue(logInfo);
				ppiv.setFormname("事件上报人");
				ppiv.setFormvalue(""+ig506Info.getPiuid());
				flowSetBL.setPublicProcessInfoValue(ppiv);
			}catch(Exception e){
				log.error("==========保存事件上报人人员表单出错===========");
				e.printStackTrace();
			}
			
			
			// 设置流程-资产关联关系
			flowSetBL.setProcessEntityRelation(prid, IGDRMCONSTANTS.PLAN_NAME, planEiid, null);
			// flowSetBL.setProcessEntityRelation(prid,
			// IGDRMCONSTANTS.SCENE_ITEM_NAME, senceEiid, null);
			// 添加备选场景
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
			log.error("自动发起应急指挥流程出错!");
			e.printStackTrace();
		}

		return prid;
	}

	/**
	 * 检查告警信息是否能够触发场景
	 * 
	 * @param alarmMsg
	 * @throws Exception
	 */
	public static int monitorAlarm(String alarmMsg, boolean isShield) {

		// 如果当屏蔽告警,则不处理
		if (isShield) {
			return 0;
		}
		String[] contents = alarmMsg.split("[|]");
		String alarmTitle = contents[0];
		
		// 告警ip
		String alarmip = contents[1].substring(1, contents[1].length() - 1);
		//告警内容
		String alarmContent = contents[3];
		
		//告警内容
				String alarmTime = contents[4];
		//告警序列号
		String alarmSerial = contents[2].substring(1, contents[2].length()-1);

		// 查询出告警设备的资产信息
		List<Map<String, Object>> result = null;
		try {
			result = getEntityByIP(alarmip);
		} catch (Exception e) {
			log.error("根据IP查询资产信息出错,IP>>" + alarmip);
			e.printStackTrace();
			// throw new Exception("根据IP查询资产信息出错");
			return 0;
		}

		if (result == null || result.size() == 0) {
			log.error("没有找到IP对应的设备,IP>>" + alarmip);
			// throw new Exception("没有找到IP对应的设备");'
			return 0;
		}

		Map<String, Object> entityMap = result.get(0);

//		if (IGDRMCONSTANTS.CUNCU_ESYSCODING.equals(entityMap.get("ESYSCODING").toString())) {
//			// 存储设备的触发方法
//
//		} else if (IGDRMCONSTANTS.WANGLUO_ESYSCODING.equals(entityMap.get("ESYSCODING").toString())) {
//			// 网络设备的触发方法
//		} else 
		{
			// 其他设备调用业务系统类预案

			String[] sysEiids = null;

			sysEiids = getSysId(alarmip);

			if (sysEiids == null) {
				log.warn("========没有查询到到业务系统,设备eiid:" + entityMap.get("EIID").toString() + "=========");
				return 0;
			}

			// 发起的流程的数量
			int successNum = 0;
			for (String sysEiidStr : sysEiids) {
				Integer sysEiid = Integer.valueOf(sysEiidStr);

				// 根据业务系统查询预案
				Integer[] planEiids = searchPlanBySysId(sysEiid);
				if (planEiids == null || planEiids.length == 0) {
					log.warn("================没有找到<" + entityMap.get("EINAME") + ">业务系统相关的专项预案==================");
					continue;
				}

				// 遍历预案找到构成触发条件的场景
				for (Integer planeiid : planEiids) {
					// 查询出关联的场景信息
					Integer[] senceEiids = searchSenceByPlan(planeiid);
					// 定义能够满足触发条件的场景id集合
					List<Integer> availableSenceEiids = new ArrayList<Integer>();
					SOC0118Info entity = null;
					try {
						entity = soc0118BL.searchEntityItemByKey(planeiid);
					} catch (Exception e) {
						e.printStackTrace();
						log.warn("=======查询预案信息报错，预案Id：" + planeiid + "=========");
					}
					if (senceEiids != null) {
						
						// 遍历场景查询能匹配上的场景
						senceLoop: for (Integer senceEiid : senceEiids) {
							List<ResponseStrategyInfo> responseStrategyList = searchResponseStrategyBySenceid(senceEiid);
							// 如果该场景有触发规则,则判断是否能够满足,如果能满足,则保存场景的eiid到集合中
							if (responseStrategyList != null && responseStrategyList.size() > 0) {
								for (ResponseStrategyInfo responseStrategyInfo : responseStrategyList) {
									if (!checkStrategy(responseStrategyInfo, alarmContent)) {
										continue senceLoop;
									}
								}
								availableSenceEiids.add(senceEiid);
							}

						}
						String desc = "告警触发应急，告警序列号："+alarmSerial+"/n/t"+"告警描述："+alarmContent;
						// 如果存在满足触发条件的场景,则发起应急指挥流程

						if (availableSenceEiids.size() > 0) {
							try {
								int prid = initDirectProcess("告警触发应急_" + entity.getEiname(), planeiid, availableSenceEiids.toArray(new Integer[] { 0 }), new Integer[] { sysEiid }, alarmTime, desc, "告警-" + entity.getEiname());
								if (prid > 0) {
									successNum++;
									log.info("============通过告警发起应急指挥流程成功 ,流程id" + prid + "=============");
								}
							} catch (Exception e) {
								log.error("==============根据告警发起流程报错，告警序列号《" + alarmSerial + "》=================");
								e.printStackTrace();
								// throw new Exception("发起应急指挥流程报错");
							}
						}
					}
				}
			}

			return successNum;
		}



	}

	/**
	 * 判断是否能够满足触发条件
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
				log.error("==========没有找场景触发策略特殊处理BL===========");
				log.error(e.getMessage());
			}
			if (scBL != null)
			flag = scBL.check(msg,responseStrategyInfo.getRsargs());

		}

		return flag;

	}

	/**
	 * 查询出告警设备的资产信息
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
			log.error("=======根据IP查询设备报错,IP:" + alarmip + "=========");
			log.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 根据业务系统查询预案
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
			log.error("根据业务系统eiid查询关联预案出错,业务系统eiid>>>" + eiid);
			log.equals(e.getMessage());
		}

		return planEiids;
	}

	/**
	 * 根据预案查询场景
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
			log.error("==============根据专项预案查询场景出错,预案id:" + planeiid + "=======================");
			log.equals(e.getMessage());
		}

		return senceEiids;
	}

	/**
	 * 查询场景的触发策略
	 */
	private static List<ResponseStrategyInfo> searchResponseStrategyBySenceid(Integer senceid) {
		List<ResponseStrategyInfo> responseStrategyList = null;

		ResponseStrategySearchCondImpl cond = new ResponseStrategySearchCondImpl();

		cond.setSenceid(senceid);

		try {
			responseStrategyList = responseStrategyBL.searchResponseStrategy(cond);
		} catch (BLException e) {
			log.error("=======================查询场景触发策略出错,场景id:" + senceid + "=====================");
			log.equals(e.getMessage());
		}

		return responseStrategyList;
	}

	/**
	 * 请求BSM平台获取业务系统id
	 */
	private static String[] getSysId(String IP) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlString = ResourceUtility.getString("GETBUINESSEIID_URL");
			URL url = new URL(urlString + IP);

			URLConnection connection = url.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
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


