/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG506BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.CurrentNodeBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.ParentNodeBL;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.bl.task.SocBL;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCondImpl;
import com.ibm.icu.util.Calendar;

/**
 * 概述：应急指挥系统工具类 功能描述：应急指挥系统工具类 创建记录：2014/05/19 修改记录：2014/06/03 LuJiayuan
 * (1)增加初始化时的推送信息以保证所有页面相应的信息是同步的
 */
@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public class IGDRMEmergencyTools {
	static Log log = LogFactory.getLog(IGDRMEmergencyTools.class);

	private static SOC0118BL soc0118BL = (SOC0118BL) WebApplicationSupport
			.getBean("soc0118BL");
	private static FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport
			.getBean("flowSearchBL");
	private static SigninBL signinBL = (SigninBL) WebApplicationSupport
			.getBean("signinBL");
	private static CurrentNodeBL currentNodeBL = (CurrentNodeBL) WebApplicationSupport
			.getBean("currentNodeBL");
	private static EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport
			.getBean("emergencyLogBL");
	private static IG224BL ig224BL = (IG224BL) WebApplicationSupport
			.getBean("ig224BL");
	private static IG222BL ig222BL = (IG222BL) WebApplicationSupport
			.getBean("ig222BL");
	private static UserRoleBL userRoleBL = (UserRoleBL) WebApplicationSupport
			.getBean("userRoleBL");
	private static IG484BL ig484BL = (IG484BL) WebApplicationSupport
			.getBean("ig484BL");
	private static IG483BL ig483BL = (IG483BL) WebApplicationSupport
			.getBean("ig483BL");
	private static EmergencyRelationBL emergencyRelationBL = (EmergencyRelationBL) WebApplicationSupport
			.getBean("emergencyRelationBL");
	private static IG380BL ig380BL = (IG380BL) WebApplicationSupport
			.getBean("ig380BL");
	private static SocBL socBL = (SocBL) WebApplicationSupport.getBean("socBL");
	private static IG560BL ig560BL = (IG560BL) WebApplicationSupport
			.getBean("ig560BL");
	private static SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport
			.getBean("soc0118VWBL");
	private static IG599BL ig599BL = (IG599BL) WebApplicationSupport
			.getBean("ig599BL");
	private static IG731BL ig731BL = (IG731BL) WebApplicationSupport
			.getBean("ig731BL");
	private static IG500BL ig500BL = (IG500BL) WebApplicationSupport
			.getBean("ig500BL");
	private static UserBL userBL = (UserBL) WebApplicationSupport
			.getBean("userBL");
	private static IG333BL ig333BL = (IG333BL) WebApplicationSupport
			.getBean("ig333BL");
	private static CodeDetailDefBL codeDetailDefBL = (CodeDetailDefBL) WebApplicationSupport
			.getBean("codeDetailDefBL");
	/** 流程处理BL */
	protected static WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");


	/**
	 * 根据prid获取当前状态的日志记录信息(初始化)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreCurrentStatusNotisListInit(
			Integer prid) throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的所有日志信息处理开始===============");

		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport
				.getBean("flowSearchBL");

		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport
				.getBean("emergencyLogBL");
		// 根据prid获取当前流程的日志集合
		// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
		LinkedHashMap<String, LinkedList<Map<String, String>>> jsonMap = new LinkedHashMap<String, LinkedList<Map<String, String>>>();
		List<ProcessStatusInfo> psBeanList = flowSearchBL
				.searchCurrentStatus(prid);
		String[] psdids = new String[psBeanList.size()];
		for (int i = 0; i < psBeanList.size(); i++) {
			psdids[i] = psBeanList.get(i).getPsdid();
		}
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setElprid_eq(prid.toString());
		// 修改成倒序排列
		elCond.setDesc(asc);
		elCond.setPsdid_in(psdids);
		List<EmergencyLogInfo> List = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		LinkedList<EmergencyLogInfo> elList = new LinkedList<EmergencyLogInfo>(
				List);

		Map<String, Object> psdMap = new HashMap<String, Object>();

		for (EmergencyLogInfo el : elList) {
			String psdName = el.getElpsdname();
			String psdid = el.getElpsdid();
			psdMap.put(psdName, el.getElpsdid());
			if (StringUtils.isEmpty(psdName)) {
				psdName = "通知信息";
			}
			Map<String, String> logMap = new HashMap<String, String>();
			logMap.put("noticeTime", el.getEllidtime().split(" ")[1]);// 信息发布时间
			logMap.put("noticeContnt", el.getElliinfo().replaceAll("\r\n", " ")
					.replaceAll("\n", " ").trim());// 信息发布内容
			logMap.put("noticeUser", el.getElusername());// 信息发布人
			logMap.put("noticeId", el.getElid().toString());// 信息发布ID
			logMap.put("noticeType", el.getEllitype());// 信息发布类型
			logMap.put("psdname", el.getElpsdname());// 信息发布类型
			if (jsonMap.get(psdid) != null) {
				LinkedList<Map<String, String>> jsonList = jsonMap.get(psdid);
				jsonList.add(logMap);
				jsonMap.put(psdid, jsonList);
			} else {
				LinkedList<Map<String, String>> jsonList = new LinkedList<Map<String, String>>();
				jsonList.add(logMap);
				jsonMap.put(psdid, jsonList);
			}
		}

		// 获取流程当前节点的信息
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();

		for (Map map2 : currentNodes) {

			Date openDate = new Date(map2.get("rslopentime").toString()
					.substring(0, 19).replace("-", "/"));
			// 开始事件ain
			map2.put("opentime", sdf.format(openDate).substring(11));
			Calendar c = Calendar.getInstance();
			c.setTime(openDate);
			int min = map2.get("notifym") == null ? 0 : Integer.valueOf(map2
					.get("notifym").toString());
			c.add(Calendar.MINUTE, min);
			// 预计结束时间
			map2.put("closetime", sdf.format(c.getTime()).substring(11));
			long diffTime = nowDate.getTime() - openDate.getTime();

			StringBuffer useTime = new StringBuffer();
			// 小时
			int hh = (int) (diffTime / 3600000);
			// 分钟
			int mm = (int) (diffTime % 3600000) / 60000;
			// 秒
			int ss = (int) (diffTime % 3600000 % 6000) / 1000;
			useTime.append(hh < 10 ? "0" + hh : hh);
			useTime.append(":");
			useTime.append(mm < 10 ? "0" + mm : mm);
			useTime.append(":");
			useTime.append(ss < 10 ? "0" + ss : ss);
			map2.put("usetime", useTime.toString());
			String psdid = map2.get("psdid").toString();
			map2.remove("notifym");
			map2.remove("rslopentime");
			map2.put("notices", jsonMap.get(psdid));
			String title = map2.get("ppsdid") == null ? map2.get("psdname")
					.toString() : map2.get("ppsdname") + "-"
					+ map2.get("psdname");
			map2.put("title", title);

		}

		// JSON传递信息Map设置
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", currentNodes);
		dataMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============根据prid获取相应应急指挥流程的的所有日志信息处理结束===============");
		return dataMap;
	}

	/**
	 * 根据prid获取相应的日志记录信息(初始化)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessRecordListInit(
			Integer prid) throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的所有日志信息处理开始===============");

		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport
				.getBean("emergencyLogBL");
		// 根据prid获取当前流程的日志集合
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setElprid_eq(prid.toString());
		elCond.setAscs(asc);
		// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		LinkedHashMap<String, LinkedList<Map<String, String>>> jsonMap = new LinkedHashMap<String, LinkedList<Map<String, String>>>();

		for (EmergencyLogInfo el : elList) {

			// 查询父节点的名并拼接到本节点的前面
			ParentNodeBL parentNodeBL = (ParentNodeBL) WebApplicationSupport
					.getBean("parentNodeBL");

			List<Map<String, Object>> parentNodes = parentNodeBL
					.getParentNodes(el.getElpsdid());

			String psdName = "";
			if (parentNodes != null && parentNodes.size() > 0) {
				psdName = parentNodes.get(0).get("psdname") + "-"
						+ el.getElpsdname();
			} else {
				psdName = el.getElpsdname();
			}

			if (StringUtils.isEmpty(psdName)) {
				psdName = "通知信息";
			}
			Map<String, String> logMap = new HashMap<String, String>();
			logMap.put("noticeTime", el.getEllidtime().split(" ")[1]);// 信息发布时间
			logMap.put("noticeContnt", el.getElliinfo().replaceAll("\r\n", " ")
					.replaceAll("\n", " ").trim());// 信息发布内容
			logMap.put("noticeUser", el.getElusername());// 信息发布人
			logMap.put("noticeId", el.getElid().toString());// 信息发布ID
			logMap.put("noticeType", el.getEllitype());// 信息发布类型
			if (jsonMap.get(psdName) != null) {
				LinkedList<Map<String, String>> jsonList = jsonMap.get(psdName);
				jsonList.add(logMap);
				jsonMap.put(psdName, jsonList);
			} else {
				LinkedList<Map<String, String>> jsonList = new LinkedList<Map<String, String>>();
				jsonList.add(logMap);
				jsonMap.put(psdName, jsonList);
			}
		}
		List<Map<String, Object>> dataList = new LinkedList<Map<String, Object>>();
		Iterator<String> ite = jsonMap.keySet().iterator();

		while (ite.hasNext()) {
			String psdName = ite.next();
			LinkedList<Map<String, String>> jsonList = jsonMap.get(psdName);
			LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
			dataMap.put("title", psdName);
			dataMap.put("notices", jsonList);
			dataList.add(dataMap);
		}

		// JSON传递信息Map设置
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", dataList);
		dataMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============根据prid获取相应应急指挥流程的的所有日志信息处理结束===============");
		return dataMap;
	}

	/**
	 * 根据流程ID获取该流程相应的状态顺序列表(初始化时使用)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessStatusListInit(
			Integer prid) throws BLException {
		log.debug("===============根据prid获取相应技术恢复流程的状态排序处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> statusList = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		// 流程当前处理节点的bysequence获取
		String[] currentId = new String[0];
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		// 根据prid获取应急指挥流程主流程的状态字段
		List<ProcessStatusInfo> psiCList = flowSearchBL
				.searchCurrentStatus(prid);

		// 获取所有状态节点的进入时间
		Map<String, String> initTimeMap = getInitTimeMap(prid);
		// 获取所有状态节点的已用时
		Map<String, String> usedTimeMap = getUsedTimeMap(prid);
		// 重新查询当前节点信息
		// 获取流程当前节点的信息
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		List<Object> currentIds = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		for (Map map2 : currentNodes) {

			Date openDate = new Date(map2.get("rslopentime").toString()
					.substring(0, 19).replace("-", "/"));
			// 开始事件ain
			map2.put("opentime", sdf.format(openDate).substring(11));
			Calendar c = Calendar.getInstance();
			c.setTime(openDate);
			int min = map2.get("notifym") == null ? 0 : Integer.valueOf(map2
					.get("notifym").toString());
			c.add(Calendar.MINUTE, min);
			// 预计结束时间
			map2.put("closetime", sdf.format(c.getTime()).substring(11));
			long diffTime = nowDate.getTime() - openDate.getTime();

			StringBuffer useTime = new StringBuffer();
			// 小时
			int hh = (int) (diffTime / 3600000);
			// 分钟
			int mm = (int) (diffTime % 3600000) / 60000;
			// 秒
			int ss = (int) (diffTime % 3600000 % 6000) / 1000;
			useTime.append(hh < 10 ? "0" + hh : hh);
			useTime.append(":");
			useTime.append(mm < 10 ? "0" + mm : mm);
			useTime.append(":");
			useTime.append(ss < 10 ? "0" + ss : ss);
			map2.put("usetime", useTime.toString());
			map2.remove("notifym");
			map2.remove("rslopentime");
			currentIds.add(map2.get("psdid"));
		}
		if (psiCList != null && psiCList.size() > 0) {
			currentId = new String[psiCList.size()];
			for (int i = 0; i < psiCList.size(); i++) {
				ProcessStatusInfo psiInfo = psiCList.get(i);
				currentId[i] = psiInfo.getPsdid();
			}
		}

		// 根据pdid获取应急指挥流程主流程的状态排序集合
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusList(pdid);

		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				String prvenode = psiInfo.getFingerPrint();
				if (prvenode == null) {
					prvenode = "";
				}
				Map<String, String> mapInList = new HashMap<String, String>();
				mapInList.put("psdid", psiInfo.getPsdid());// 状态ID_psdid字段
				mapInList
						.put("statusTime", initTimeMap.get(psiInfo.getPsdid()));// 状态进入时间
				mapInList.put("useTime", usedTimeMap.get(psiInfo.getPsdid()));// 状态已用时
				mapInList.put("psdname", psiInfo.getPsdname());// 状态名称_psdname字段
				mapInList.put("pseq", psiInfo.getBysequence());// 排序字段
				mapInList.put("prvenode", prvenode);// 前置节点ID
				mapInList.put("ppsdid", psiInfo.getPpsdid());// 父节点
				if (StringUtils.isNotEmpty(initTimeMap.get(psiInfo.getPsdid()))
						&& StringUtils.isNotEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "0");// 已完成
				} else if (StringUtils.isEmpty(initTimeMap.get(psiInfo
						.getPsdid()))
						&& StringUtils.isEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "2");// 尚未开始
				} else if (StringUtils.isNotEmpty(initTimeMap.get(psiInfo
						.getPsdid()))
						&& StringUtils.isEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "1");// 正在处理
				}
				statusList.add(mapInList);
			}
		}

		map.put("data", statusList);// 流程状态相应设置
		map.put("currentId", currentNodes);
		map.put("currentIds", currentIds);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_PROCESS);
		map.put("pdid", pdid);
		log.debug("===============根据prid获取相应应急指挥流程的状态排序处理结束===============");
		return map;
	}

	/**
	 * 根据流程ID获取该流程开始时间(初始化时使用)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static String getRestoreProcessOpenTime(Integer prid)
			throws BLException {
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			String propenTime = priList.get(0).getPropentime();
			propenTime = propenTime.replaceFirst("/", "年");
			propenTime = propenTime.replaceFirst("/", "月");
			propenTime = propenTime.replaceFirst(" ", "日 ");
			return propenTime;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			return sdf.format(new Date());
		}
	}

	/**
	 * 获取当前应急指挥流程的相应信息(初始化)
	 * 
	 * @param prid
	 *            当前流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getEmergencyProcessInfo(Integer prid)
			throws BLException {
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理开始===============");
		// 获取"事件发生时间"对应的表单值(表单名称"事件上报时间")
		String oTime = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_OTIME);
		// 获取"事件上报人员"对应的表单值(表单名称"事件上报人")
		String reUser = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_REUSER);
		IG506BL ig506BL = (IG506BL) WebApplicationSupport.getBean("ig506BL");
		IG506Info ig506Info = StringUtils.isEmpty(reUser)? null:ig506BL.searchIG506ByPK(Integer.parseInt(reUser));
		// 事件上报人
		String username = ig506Info != null ? ig506Info.getPiusername() : "";
		// 上报人联系电话
		String userphone = ig506Info != null ? ig506Info.getPiphone() : "";
		// 获取"事件现象概述"对应的表单值(表单名称"事件描述")
		String desc = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_DESC);
		// JSON传递信息Map设置
		Map<String, Object> datamap = new HashMap<String, Object>();
		// 组织数据格式
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		Map<String, String> map4 = new HashMap<String, String>();
		map1.put("name", IGDRMCONSTANTS.EMCPRO_OTIME);
		map1.put("content", oTime);
		dataList.add(map1);
		map2.put("name", IGDRMCONSTANTS.EMCPRO_REUSER);
		map2.put("content", username);
		dataList.add(map2);
		map3.put("name", IGDRMCONSTANTS.EMCPRO_REUSERPHONE);
		map3.put("content", userphone);
		dataList.add(map3);
		map4.put("name", IGDRMCONSTANTS.EMCPRO_DESC);
		map4.put("content", desc.replace("<br>", "").replace("&nbsp;", " ")
				.trim());
		dataList.add(map4);
		datamap.put("planList", dataList);
		datamap.put("type", "24");
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理结束===============");
		return datamap;
	}

	/**
	 * 获取当前应急指挥流程的相应信息(初始化)
	 * 
	 * @param prid
	 *            当前流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessInfo(Integer cldPrid)
			throws BLException {
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理开始===============");
		Integer prid = flowSearchBL.searchProcessRelationForPar(cldPrid);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> mapInMap = new HashMap<String, String>();

		if (prid == null) {
			ProcessRecordInfo prInfo = flowSearchBL.searchProcessInfo(cldPrid,
					null).get(0);
			mapInMap.put("oTime", prInfo.getPropentime());
			mapInMap.put("desc", prInfo.getPrdesc());
			map.put("data", mapInMap);
			map.put("type", IGDRMCONSTANTS.DB_TYPE_EMCINFO);
		} else {
			// 获取"事件发生时间"对应的表单值(表单名称"事件发生时间")
			String oTime = flowSearchBL.searchPublicProcessInfo(prid,
					IGDRMCONSTANTS.EMCPRO_OTIME);
			// 获取"事件现象概述"对应的表单值(表单名称"事件描述")
			String desc = flowSearchBL.searchPublicProcessInfo(prid,
					IGDRMCONSTANTS.EMCPRO_DESC);
			// JSON传递信息Map设置
			// 设置Map值
			mapInMap.put("oTime", oTime);
			mapInMap.put("desc", desc.replace("<br>", "")
					.replace("&nbsp;", " ").trim());
			map.put("data", mapInMap);
			map.put("type", IGDRMCONSTANTS.DB_TYPE_EMCINFO);
		}
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理结束===============");
		return map;
	}

	public static String getProcessStartDate(Integer prid) throws BLException {
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			ProcessRecordInfo prBean = priList.get(0);
			return prBean.getPropentime().split(" ")[0].replaceFirst("/", "年")
					.replaceFirst("/", "月") + "日";
		}
		return "";
	}

	/**
	 * 获取当前应急指挥流程系统消息(公告)
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public static Map<String, Object> getSystemNotice(Integer prid)
			throws BLException {

		log.debug("===============根据prid获取相应应急指挥流程的所有系统日志信息处理开始===============");

		// 获取相关流程的id
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(prid);
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();

		// 根据prid获取当前流程的日志集合
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		elCond.setEllitype_eq("2");
		String[] asc = { "elid", "ellidtime" };
		elCond.setElprid_eq(prid.toString());
		elCond.setAscs(asc);
		// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = getMessageMap();
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// 信息发布时间
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// 信息发布内容
			mapInList.put("noticeUser", el.getElusername());// 信息发布人
			mapInList.put("noticeId", el.getElid().toString());// 信息发布ID
			mapInList.put("noticeType", el.getEllitype());// 信息发布类型
			list.add(mapInList);
		}
		map.put("data", list);
		map.put("type", "7");
		log.debug("===============根据prid获取相应应急指挥流程的的所有系统日志信息处理结束===============");
		return map;

	}

	/**
	 * 获取当前应急指挥流程相关预案资产的相应信息(初始化)
	 * 
	 * @param prid
	 *            当前流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRelPlanProcessInfo(Integer prid)
			throws BLException {
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理开始===============");
		// 获取表单名称为"专项预案"的表单值
		List<ProcessInfoEntityInfo> planList = flowSearchBL
				.searchProcessEntityItem(prid, IGDRMCONSTANTS.EMCPRO_RELPLAN);
		// 获取表单名称为"应急场景"的表单值
		List<ProcessInfoEntityInfo> sceneList = flowSearchBL
				.searchProcessEntityItem(prid, IGDRMCONSTANTS.SCENE_ITEM_NAME);
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		if (planList != null && planList.size() > 0) {
			Integer planeiid = planList.get(0).getEiid();
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(planeiid);
			Map<String, String> mapInMap = new LinkedHashMap<String, String>();

			mapInMap.put("name", "预案名称");
			mapInMap.put("content", soc0118Info.getEiname());
			list.add(mapInMap);
		}
		if (sceneList != null && sceneList.size() > 0) {
			Integer sceneeiid = sceneList.get(0).getEiid();
			SOC0118Info soc0118Info = soc0118BL
					.searchEntityItemByKey(sceneeiid);

			Map<String, String> mapInMap = new LinkedHashMap<String, String>();
			mapInMap.put("name", "场景名称");
			mapInMap.put("content", soc0118Info.getEiname());
			list.add(mapInMap);
		}
		map.put("planList", list);
		map.put("type", "6");
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理结束===============");
		return map;
	}

	/**
	 * 获取当前应急应急处置流程相关预案资产的信息(初始化)
	 * 
	 * @param prid
	 *            场景流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRelPlanProcessInfoForScene(Integer prid)
			throws BLException {
		log.debug("===============根据流程ID获取应急处置流程相关信息处理开始===============");
		// 指挥流程prid
		Integer ecprid = 0;
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		SigninSearchCondImpl sccond = new SigninSearchCondImpl();
		sccond.setSceneprid(prid);
		List<SigninInfo> scList = signinBL.searchSignin(sccond);
		if (scList != null && scList.size() > 0) {
			// 得到指挥流程prid
			ecprid = scList.get(0).getEcprid();
		}
		if (ecprid > 0) {

			// 获取表单名称为"专项预案"的表单值
			List<ProcessInfoEntityInfo> planList = flowSearchBL
					.searchProcessEntityItem(ecprid,
							IGDRMCONSTANTS.EMCPRO_RELPLAN);
			if (planList != null && planList.size() > 0) {
				Integer planeiid = planList.get(0).getEiid();
				SOC0118Info soc0118Info = soc0118BL
						.searchEntityItemByKey(planeiid);
				Map<String, String> mapInMap = new LinkedHashMap<String, String>();

				mapInMap.put("name", "专项预案");
				mapInMap.put("content", soc0118Info.getEiname());
				list.add(mapInMap);
			}
		}
		map.put("planList", list);
		log.debug("===============根据流程ID获取应急指挥流程相关信息处理结束===============");
		return map;
	}

	/**
	 * 根据流程ID获取当前已用时间
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static String getUsedTime(Integer prid) throws BLException {
		String useTime = "00:00:00";
		// 获取起始时间
		String initTime = "";
		String minOpenTime = "";
		// 根据prid获取所有应急指挥流程相应的Log日志信息
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				if (IGDRMCONSTANTS.PROCESS_START_STATUS.equals(psiInfo
						.getPsdcode())) {
					if (StringUtils.isEmpty(minOpenTime)) {
						minOpenTime = psiInfo.getOpentime();// 待发起时间即为事件启动时间
					} else {
						if (minOpenTime.compareTo(psiInfo.getOpentime()) > 0) {// 表明存在在此状态更小的起始时间
							minOpenTime = psiInfo.getOpentime();// 考虑到打回情况需要对进入"待发起"状态最小的值作为流程发起时间
						}
					}
				}
			}
		}

		// 设置流程初始时间
		initTime = minOpenTime;
		ProcessRecordInfo prInfo = flowSearchBL.searchProcessInfo(prid, null)
				.get(0);

		if ("C".equals(prInfo.getPrstatus())
				|| "#".equals(prInfo.getPrstatus())) {
			useTime = getTimeDifference(initTime, prInfo.getPrclosetime());
		} else {
			useTime = getTimeDifference(initTime, "");
		}
		/** 在获取已用时时重新推送所有相关时间信息的数据 */
		// JSON传递信息Map设置
		/** 当前系统时间 */
		Map<String, Object> currMap = new HashMap<String, Object>();
		currMap.put("type", IGDRMCONSTANTS.DB_TYPE_REPUSH_SYSMTIME);
		currMap.put("data", getCurrentDateTime());
		currMap.put("target", prid + "");
		/** 系统已用时 */
		Map<String, Object> usedMap = new HashMap<String, Object>();
		usedMap.put("type", IGDRMCONSTANTS.DB_TYPE_REPUSH_USEDTIME);
		usedMap.put("data", useTime);
		usedMap.put("target", prid + "");

		// 当前系统时间推送
		// messagePushBL.pushMsgForMap(currMap);
		// // flexMessagePushBL.pushMessage(prid, message)
		// //当前已用时推送
		// messagePushBL.pushMsgForMap(usedMap);

		return useTime;
	}

	/**
	 * 获取应急处理流程日志信息 (根据节点分组,倒序)--初始化时调用
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getNoticeInfoForSence(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		EmergencyLogSearchCondImpl cond = new EmergencyLogSearchCondImpl();
		cond.setElprid_eq("" + prid);
		cond.setDesc(new String[] { "ellidtime", "plpsdid" });
		List<EmergencyLogInfo> emlArr = emergencyLogBL
				.searchEmergencyLogByCond(cond);
		// 根据节点分组封装
		for (EmergencyLogInfo emergencyLogInfo : emlArr) {
			List<EmergencyLogInfo> tempArr = map.get(emergencyLogInfo
					.getElpsdid()) == null ? null
					: ((List<EmergencyLogInfo>) map.get(emergencyLogInfo
							.getElpsdid()));
			if (tempArr == null) {
				tempArr = new ArrayList<EmergencyLogInfo>();
			}
			tempArr.add(emergencyLogInfo);
			map.put(emergencyLogInfo.getElpsdid(), tempArr);
		}
		return map;
	}

	/**
	 * 根据当前流程ID获取所有状态的进入时间
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 * @description (1)searchProcessStatusLog会只查找跃迁过的和正在处理中的节点
	 *              (2)需要考虑超过24小时的情况导致打回时只比较时间会出现问题
	 */
	private static Map<String, String> getInitTimeMap(Integer prid)
			throws BLException {
		// 将每个流程节点状态的时间进行记录然后比较用来区分出现跨天导致的只比较时间会出现的问题
		Map<String, String> initDateTimeMap = getInitMap(prid);
		Map<String, String> initTimeMap = getInitMap(prid);
		// 获取流程处理状态日志没有跃迁的节点不显示
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				// 当存在打回重新进入此节点时若进入时间大于预置的设置时间则进行相应的操作
				if (psiInfo.getOpentime().compareTo(
						initDateTimeMap.get(psiInfo.getPsdid())) > 0) {
					initDateTimeMap.put(psiInfo.getPsdid(),
							psiInfo.getOpentime());
					// 此处不考虑打回状态只记录进入当前节点状态的时间
					if (StringUtils.isNotEmpty(psiInfo.getOpentime())) {
						if (psiInfo.getOpentime().split(" ").length > 1) {
							initTimeMap.put(psiInfo.getPsdid(), psiInfo
									.getOpentime().split(" ")[1]);
						}
					}
				}
			}
		}
		return initTimeMap;
	}

	/**
	 * 根据当前流程ID获取所有状态的已用时
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 * @description (1)searchProcessStatusLog会只查找跃迁过的和正在处理中的节点
	 *              (2)正在处理中的话ProcessStatusInfo的getClosetime会为空
	 *              (3)考虑到打回的情况所以需要对处理时间进行累加
	 */
	private static Map<String, String> getUsedTimeMap(Integer prid)
			throws BLException {
		Map<String, String> usedTimeMap = getInitMap(prid);
		// 获取流程处理状态日志没有跃迁的节点不显示
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				// 当前数据行对应已用时计算
				String nowUsed = getTimeDifference(psiInfo.getOpentime(),
						psiInfo.getClosetime());
				usedTimeMap.put(
						psiInfo.getPsdid(),
						getSumForDateTime(usedTimeMap.get(psiInfo.getPsdid()),
								nowUsed));
				usedTimeMap.put(psiInfo.getPsdid() + psiInfo.getPsdid(),
						psiInfo.getClosetime());
			}
		}
		return usedTimeMap;
	}

	/**
	 * 根据当前流程ID获取所有状态节点的初始化时间Map格式 为记录初始化时间和已用时准备的辅助方法
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	private static Map<String, String> getInitMap(Integer prid)
			throws BLException {
		// 设置pdid字段
		String pdid = "";
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		// 根据pdid获取应急指挥流程主流程的状态排序集合
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusList(pdid);
		Map<String, String> initMap = new LinkedHashMap<String, String>();
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psi : psiList) {
				initMap.put(psi.getPsdid(), "");
			}
		}
		return initMap;
	}

	/**
	 * 获取HH:mm:ss格式的时间差
	 * 
	 * @param initTime
	 *            减数时间(yyyy/MM/dd HH:mm:ss格式)
	 * @param finalTime
	 *            被减数时间(yyyy/MM/dd HH:mm:ss格式)传""表示当前系统日期时间作为减数
	 * @return
	 */
	private static String getTimeDifference(String initTime, String finalTime) {
		String dateTime = initTime;
		if (16 == dateTime.length()) {
			dateTime = dateTime + ":00";
		}
		String finalDateTime = finalTime;
		if (StringUtils.isNotEmpty(finalDateTime)) {
			if (16 == finalDateTime.length()) {
				finalDateTime = finalDateTime + ":00";
			}
		}
		// 标准日期时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// 返回显示时间差
		String show = "00:00:00";
		try {
			// 减数日期时间
			Date date = sdf.parse(dateTime);
			// 当前系统日期时间
			Date nowDate = new Date();
			if (StringUtils.isNotEmpty(finalDateTime)) {
				nowDate = sdf.parse(finalDateTime);
			}

			// 当前系统日期时间与减数日期时间的差值
			long diff = nowDate.getTime() - date.getTime();
			long h = diff / (1000 * 60 * 60);
			long m = diff / (1000 * 60) - h * 60;
			long s = diff / (1000) - h * 60 * 60 - m * 60;
			String sh;
			if (h < 10) {
				sh = "0" + h;
			} else {
				sh = h + "";
			}
			String sm;
			if (m < 10) {
				sm = "0" + m;
			} else {
				sm = m + "";
			}
			String ss;
			if (s < 10) {
				ss = "0" + s;
			} else {
				ss = s + "";
			}
			// if(h>=100){
			// show = "99:99:99";
			// }else{
			show = sh + ":" + sm + ":" + ss;
			// }

		} catch (ParseException e) {
			log.debug("===============转换时间方法参数格式出错===============");
			e.printStackTrace();
		}
		return show;
	}

	/**
	 * 考虑到流程节点的打回状态会导致时间的变化
	 * 
	 * @param oldTime
	 *            已存在已用时
	 * @param nowTime
	 *            当前的已用时
	 * @return
	 */
	private static String getSumForDateTime(String oldTime, String nowTime) {
		if (StringUtils.isEmpty(oldTime)) {
			return nowTime;
		} else {
			// 已存在已用时时分秒转化
			String[] old = oldTime.split(":");
			// 当前的已用时时分秒转化
			String[] now = nowTime.split(":");
			// 分钟进位初始为0
			int mCarry = 0;
			// 小时进位初始为0
			int hCarry = 0;
			// 秒累加
			int sSum = Integer.parseInt(old[2]) + Integer.parseInt(now[2]);
			// 分累加
			int mSum = Integer.parseInt(old[1]) + Integer.parseInt(now[1]);
			// 时累加
			int hSum = Integer.parseInt(old[0]) + Integer.parseInt(now[0]);
			int s = 0;
			int m = 0;
			int h = 0;
			if (sSum >= 60) {
				// 和大于60_分进位1
				mCarry = 1;
				s = sSum - 60;
			} else {
				s = sSum;
			}
			if ((mSum + mCarry) >= 60) {
				// 和大于60_时进位1
				hCarry = 1;
				m = (mSum + mCarry) - 60;
			} else {
				m = mSum + mCarry;
			}
			h = hSum + hCarry;
			String show = "00:00:00";
			String sh;
			if (h < 10) {
				sh = "0" + h;
			} else {
				sh = h + "";
			}
			String sm;
			if (m < 10) {
				sm = "0" + m;
			} else {
				sm = m + "";
			}
			String ss;
			if (s < 10) {
				ss = "0" + s;
			} else {
				ss = s + "";
			}
			if (h >= 100) {
				show = "99:59:59";
			} else {
				show = sh + ":" + sm + ":" + ss;
			}
			return show;
		}
	}

	/**
	 * 获取当前系统时间的方法
	 */
	private static String getCurrentDateTime() {
		String dateTime = "1900/01/01 00:00:00";// 默认系统初始化时间
		// String dateTime = DateUtils.getCurrentTime();//此方法只能获取yyyy/MM/dd
		// HH:mm格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateTime = sdf.format(new Date());
		return dateTime;
	}

	/**
	 * 信息发布信息Map初始化
	 * 
	 * @return
	 */
	private static Map<String, String> getMessageMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("noticeTime", "");// 信息发布时间
		map.put("noticeContnt", "");// 信息发布内容
		map.put("noticeUser", "");// 信息发布人
		map.put("noticeId", "");// 信息发布ID
		map.put("noticeType", "");// 信息发布类型
		return map;
	}

	/**
	 * 根据prid获取相应的信息发布信息(初始化)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getMessageInfo(String prid)
			throws BLException {
		// JSON传递信息Map设置
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		EmergencyLogSearchCondImpl elcond = new EmergencyLogSearchCondImpl();
		elcond.setElprid_eq(prid);
		elcond.setEllitype_eq("2");
		String[] asc = { "elid", "ellidtime" };
		elcond.setAscs(asc);
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elcond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("mstime", el.getEllidtime() + ":00");
			map.put("mscontent", el.getElliinfo().replaceAll("\r\n", " ")
					.replaceAll("\n", " ").trim());
			listMap.add(map);
		}
		dataMap.put("mscontentList", listMap);
		dataMap.put("type", "3");
		return dataMap;
	}

	/**
	 * 根据prid获取各决策层人员就位情况的信息(初始化)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestpreDecLayInPlaceList(Integer ecPrid)
			throws BLException {

		log.debug("===============根据prid获取组织架构各层级人员就绪处理开始===============");
		// 返回数据map
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 数据具体形式List
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		// 人员就位信息数据
		List<Map<String, Object>> dataMapList = signinBL
				.searchSigninInitData(ecPrid);
		List<Map<String, Object>> peopleMapList =signinBL.searchSigninPeopleDataByCond(ecPrid);
		String green_peopleName = "";
		String red_peopleName = "";
		if(peopleMapList!=null &&peopleMapList.size()>0){
			for(Map<String,Object> peopleMap:peopleMapList){
				green_peopleName += peopleMap.get("SNAME")+",";
				if(peopleMap.get("SIGNINED")!=null&&!StringUtils.isEmpty(peopleMap.get("SIGNINED").toString()) && peopleMap.get("SIGNINED").toString().equals("1")){
					red_peopleName += peopleMap.get("SNAME")+",";
				}
			}
		}
		for (Map<String, Object> map : dataMapList) {
			if (map.get("SNAME").equals("应急执行层")) {
				Map<String, Object> datamap = new HashMap<String, Object>();
				datamap.put("deparment", map.get("SNAME"));
				datamap.put("name", "暂无");
				datamap.put("green_people", map.get("TOTALCOUNT"));
				if (!StringUtil.isEmpty((String) map.get("INCOUNT"))) {
					datamap.put("red_people", map.get("INCOUNT"));
				} else {
					datamap.put("red_people", "0");
				}
				if(StringUtil.isEmpty(green_peopleName)){
					datamap.put("green_peopleName", "没有参与人");
				}else{
					datamap.put("green_peopleName", green_peopleName);
				}
				if(StringUtil.isEmpty(red_peopleName)){
					datamap.put("red_peopleName", "尚未有人签到");
				}else{
					datamap.put("red_peopleName", red_peopleName);
				}
				
				dataList.add(datamap);
			}

		}

		dataMap.put("emergencyList", dataList);
		dataMap.put("type", "4");
		log.debug("===============根据prid获取组织架构各层级人员就绪处理结束===============");
		return dataMap;
	}

	/**
	 * 根据流程ID获取该流程相应的状态顺序列表(初始化时使用)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessStatusListInit(Integer prid)
			throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的状态排序处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		// 处理事件升级的Map
		Map<String, String> eventUpgrademap = new HashMap<String, String>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			// 获取流程pdid
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig333Map = getIG333Info(pdid);
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			// 待发起结点先入map
			// 当节点名称是"待发起"时变更为"事件上报"
			if (IGDRMCONSTANTS.PROCESS_START_STATUS_LABEL.equals(ig333Map
					.get(ig224info.getPsdid()))) {
				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("flowNodeId", ig224info.getPsdid());
				mapInList.put("flowNodeName",
						IGDRMCONSTANTS.EMC_PROCESS_START_STATUS_LABEL);// 状态名称_psdname字段
				if (StringUtils.isNotEmpty(ig224info.getRslOpenTime()
						.toString())) {
					if (ig224info.getRslOpenTime().toString().split(" ").length > 1) {
						mapInList.put("flowNodeStartTime",
								CommonDefineUtils.DATETIME_SECOND_FORMAT
										.format(ig224info.getRslOpenTime())
										.split(" ")[1].substring(0, 8));
					}
				}
				// 当前数据行对应已用时计算
				if (ig224info.getRslCloseTime() == null
						|| "".equals(ig224info.getRslCloseTime().toString())) {
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(nowDateTime);
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info
									.getRslOpenTime()), datetime);
					mapInList.put("flowNodePassedTime", nowUsed);
				} else {
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info
									.getRslOpenTime()),
							CommonDefineUtils.DATETIME_SECOND_FORMAT
									.format(ig224info.getRslCloseTime()));
					mapInList.put("flowNodePassedTime", nowUsed);
				}
				// flowNodeStatus节点状态0、1、2
				if (ig224info.getRslOpenTime() == null
						|| "".equals(ig224info.getRslOpenTime())) {
					mapInList.put("flowNodeStatus", "2");// 节点状态未开始节点
				} else {
					if (ig224info.getRslCloseTime() == null
							|| "".equals(ig224info.getRslCloseTime())) {
						mapInList.put("flowNodeStatus", "1");// 节点状态1处在当前节点
					} else {
						mapInList.put("flowNodeStatus", "0");// 节点状态0节点已跑过
					}
				}
				list.add(mapInList);
				if (ig333Map.get(ig224info.getPsdid()) != null) {
					ig333Map.remove(ig224info.getPsdid());
				}
				break;
			}
		}
		for (IG224Info ig224info1 : ig224List) {

			if (ig333Map.get(ig224info1.getPsdid()) != null
					&& !IGDRMCONSTANTS.PROCESS_START_STATUS_LABEL
							.equals(ig333Map.get(ig224info1.getPsdid()))) {

				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("flowNodeId", ig224info1.getPsdid());
				mapInList.put("flowNodeName",
						ig333Map.get(ig224info1.getPsdid()));// 状态名称_psdname字段
				if (StringUtils.isNotEmpty(ig224info1.getRslOpenTime()
						.toString())) {
					String date = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(ig224info1.getRslOpenTime());
					if (date.split(" ").length > 1) {
						mapInList.put("flowNodeStartTime",
								date.split(" ")[1].substring(0, 8));
					}
				}
				// 当前数据行对应已用时计算
				if (ig224info1.getRslCloseTime() == null
						|| "".equals(ig224info1.getRslCloseTime().toString())) {
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(nowDateTime);
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info1
									.getRslOpenTime()), datetime);
					mapInList.put("flowNodePassedTime", nowUsed);
				} else {
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info1
									.getRslOpenTime()),
							CommonDefineUtils.DATETIME_SECOND_FORMAT
									.format(ig224info1.getRslCloseTime()));
					mapInList.put("flowNodePassedTime", nowUsed);
				}
				// flowNodeStatus节点状态0、1、2
				if (ig224info1.getRslOpenTime() == null
						|| "".equals(ig224info1.getRslOpenTime())) {
					mapInList.put("flowNodeStatus", "2");// 节点状态未开始节点
				} else {
					if (ig224info1.getRslCloseTime() == null
							|| "".equals(ig224info1.getRslCloseTime())) {
						mapInList.put("flowNodeStatus", "1");// 节点状态1处在当前节点
						// if (IGDRMCONSTANTS.PROCESS_DRICT_DISPOSE
						// .equals(ig333Map.get(ig224info1.getPsdid()))) {
						// 获取应急演练流程id
						String sceneprid = flowSearchBL
								.searchPublicProcessInfo(
										prid,
										IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
						mapInList.put("sceneprid", sceneprid);// 应急演练prid
						// }
					} else {
						mapInList.put("flowNodeStatus", "0");// 节点状态0节点已跑过
						String sceneprid = flowSearchBL
								.searchPublicProcessInfo(
										prid,
										IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
						mapInList.put("sceneprid", sceneprid);// 应急演练prid
					}
				}
				list.add(mapInList);
				if (ig333Map.get(ig224info1.getPsdid()) != null) {
					ig333Map.remove(ig224info1.getPsdid());
				}
			}
		}
		for (Iterator<String> it = ig333Map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("flowNodeName", ig333Map.get(key));
			tempMap.put("flowNodeId", key);
			tempMap.put("flowNodeStatus", "2");
			tempMap.put("flowNodePassedTime", "00:00:00");
			tempMap.put("flowNodeStartTime", "00:00:00");
			list.add(tempMap);
			if (!eventUpgrademap.isEmpty()) {
					list.add(tempMap);
			} 
		}
		map.put("data", list);// 流程状态相应设置
		map.put("type", "2");// 流程状态相应设置
		log.debug("===============根据prid获取相应应急指挥流程的状态排序处理结束===============");
		return map;
	}

	/**
	 * 根据prid获取相应的日志记录信息(初始化)实时跟踪
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessRecordListInit(Integer prid)
			throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的所有日志信息处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig33map = getIG333Info(pdid);
		// 根据prid获取当前流程的日志集合
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setAscs(asc);
		elCond.setElprid_eq(prid.toString());
		elCond.setEllitype_eq("1");
		// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			mapInList.put("noticeId", el.getElid().toString());// 信息发布ID
			mapInList.put("noticeUser", el.getElusername());// 信息发布人
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// 信息发布时间
			mapInList.put("noticeType", el.getEllitype());// 信息发布类型
			mapInList.put("flowNodeId", el.getElpsdid());// 信息发布类型
			mapInList.put("flowNodeName", ig33map.get(el.getElpsdid()));// 信息发布类型
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// 信息发布内容
			list.add(mapInList);
		}
		// Collections.reverse(list);
		map.put("data", list);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============根据prid获取相应应急指挥流程的的所有日志信息处理结束===============");
		return map;
	}

	/**
	 * 根据pdid获取节点信息和节点名称
	 * 
	 * @param pdid
	 *            流程定义ID
	 * @return
	 * @throws BLException
	 */
	private static Map<String, String> getIG333Info(String pdid) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl ig333cond = new IG333SearchCondImpl();
		ig333cond.setPdid(pdid);
		ig333cond.setOrderField("bysequence");
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333cond);
		for (IG333Info info : ig333List) {
			if (!"C".equals(info.getPsdcode())) {
				// psdid-psdname的map
				map.put(info.getPsdid(), info.getPsdname());
			}
		}
		// 事件升级不显示在dashbaord上
		map.remove(IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID);
		// 关闭节点放在最后一位
		for (IG333Info info : ig333List) {
			if ("C".equals(info.getPsdcode())) {
				map.put(info.getPsdid(), info.getPsdname());
			}
		}
		return map;
	}

	/**
	 * 根据pdid获取节点信息和节点名称
	 * 
	 * @param pdid
	 *            流程定义ID
	 * @return
	 * @throws BLException
	 */
	private static Map<String, String> getIG333PsdidInfo(String pdid) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl ig333cond = new IG333SearchCondImpl();
		ig333cond.setPdid(pdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333cond);
		for (IG333Info info : ig333List) {
			if (!"C".equals(info.getPsdcode())) {
				// psdid-psdname的map
				map.put(info.getPsdid(), info.getPpsdid());
			}
		}
		// 事件升级不显示在dashbaord上
		map.remove(IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID);
		// 关闭节点放在最后一位
		for (IG333Info info : ig333List) {
			if ("C".equals(info.getPsdcode())) {
				map.put(info.getPsdid(), info.getPpsdid());
			}
		}
		return map;
	}

	/**
	 * 根据prid获取流程开始时间
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessStartTime(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		ig224cond.setPrstatus("Z");
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		if (ig224List.size() > 0) {
			map.put("sign", "0");
			map.put("time",
					CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(ig224List.get(0).getRslOpenTime()));
		}
		return map;
	}

	/**
	 * 根据prid获取流程已用时间
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessUsedTime(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		// 待发起节点
		ig224cond.setPrstatus("Z");
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		// 关闭
		cond.setPrstatus("C");
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		List<IG224Info> List = ig224BL.findByCondOrderByRslopentime(cond);
		if (List != null && List.size() > 0) {
			map.put("sign", "1");
			String usetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
					.format(List.get(0).getRslCloseTime());
			String nowUsed = getTimeDifference(
					CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224List
							.get(0).getRslOpenTime()), usetime);
			map.put("time", nowUsed);
			if(ig500Info.getPrstatus().equals("C")){
				map.put("sign", "0");
				
			}
			return map;
		}
		if (ig224List.size() > 0) {
			map.put("sign", "1");
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
					.format(nowDateTime);
			String nowUsed = getTimeDifference(
					CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224List
							.get(0).getRslOpenTime()), datetime);
			map.put("time", nowUsed);
		}
		if(ig500Info.getPrstatus().equals("C")){
			map.put("sign", "0");
		}
		return map;
	}

	/**
	 * 根据prid获取流程应急资源
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getSocMap(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 查询关联场景的定义ID
		String pidid = socBL.searchFlowPidid(prid);
		List<SOC0118VW> soc0118VWList = new ArrayList<SOC0118VW>();
		// 查询出此场景所有的应急资源
		if (pidid != null && StringUtils.isNotEmpty(pidid)) {
			IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
			ig560Cond.setPidid_l(pidid + "001");
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			if (ig560List != null && ig560List.size() > 0) {
				for (IG560Info ig560Info : ig560List) {
					if (StringUtils.isNotBlank(ig560Info.getDfvalue())) {
						SOC0118VWInfo soc0118VWInfo = soc0118VWBL
								.searchEntityItemByKey(new SOC0118VWPK(Integer
										.parseInt(ig560Info.getDfvalue().split(
												"_")[0]), Integer
										.parseInt(ig560Info.getDfvalue().split(
												"_")[1])));
						SOC0118VW soc0118VW = (SOC0118VW) SerializationUtils
								.clone(soc0118VWInfo);
						soc0118VW.setFingerPrint(ig560Info.getDfvalue().split(
								"_SOC_")[1]);
						soc0118VWList.add(soc0118VW);
						// 将查询出所有应急资源的模型进行分类
						map.put(ig560Info.getDfvalue().split("_SOC_")[1],
								new ArrayList<SocUtil>());
					}
				}
				int index = 0;
				//过滤应急资源的唯一性
				Map<String,String> keyMap = new HashMap<String, String>();
				for (String key : map.keySet()) {
					String mapKey = "socArr";
					index++;
					List<SocUtil> list = new ArrayList<SocUtil>();
					for (SOC0118VW vw : soc0118VWList) {
						if (vw.getFingerPrint().equals(key)&&keyMap.get(vw.getId() + "_" + vw.getEiid())==null) {
							SocUtil socUtil = new SocUtil();
							socUtil.setEiid(vw.getId() + "_" + vw.getEiid());
							socUtil.setName(vw.getEiname());
							socUtil.setSoctype(vw.getFingerPrint().split("_")[1]);
							keyMap.put(vw.getId() + "_" + vw.getEiid(), vw.getEiname());
							list.add(socUtil);
						}

					}
					// 将应急资源按照应急资源模型分类并且放到map中
					if (list != null && list.size() > 0) {
						resultMap.put(mapKey + index, list);
					}
				}
			}

		}
		// 添加推送的的类型，将应急资源显示出来
		resultMap.put("type", "22");
		return resultMap;
	}

	/**
	 * 根据流程ID获取该流程相应的状态(急指处理流程初始化时使用)
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessStatusForOBDR(Integer prid)
			throws BLException {
		log.debug("===============根据prid获取相应应急指处理流程的状态处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			// flowNodeStatus节点状态0、1、2
			if (ig224info.getRslOpenTime() == null
					|| "".equals(ig224info.getRslOpenTime())) {
				mapInList.put("id", ig224info.getPsdid());// 节点状态未开始节点
				mapInList.put("state", "2");// 节点状态0节点已跑过
				mapInList.put("ppsdid", ig224info.getPpsdid());
			} else {
				if (ig224info.getRslCloseTime() == null
						|| "".equals(ig224info.getRslCloseTime())) {
					mapInList.put("id", ig224info.getPsdid());// 节点状态1处在当前节点
					mapInList.put("state", "1");// 节点状态0节点已跑过
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(nowDateTime);
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info
									.getRslOpenTime()), datetime);
					mapInList.put(
							"startTime",
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(
									ig224info.getRslOpenTime()).split(" ")[1]);
					mapInList.put("useTime", nowUsed);
					mapInList.put("ppsdid", ig224info.getPpsdid());
					// 流程当前处理节点的psdid获取
					String currentPsdid = "";
					// 根据prid获取应急指挥流程主流程的状态字段
					List<ProcessStatusInfo> psiCList = flowSearchBL
							.searchCurrentStatus(prid);
					if (psiCList != null && psiCList.size() > 0) {
						for (ProcessStatusInfo psiInfo : psiCList) {
							// 当前节点id
							currentPsdid = psiInfo.getPsdid();
						}
					}
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(currentPsdid);
					List<IG222Info> ig222InfoList = ig222BL
							.searchIG222Info(ig222cond);
					Set<String> userSet = new HashSet<String>();
					for (IG222Info ig222Info : ig222InfoList) {
						// 循环得到所有处理人，同时去重
						if (!StringUtil.isEmpty(ig222Info.getUserid())) {
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setUserid(ig222Info.getUserid());
							urcond.setRoleid(ig222Info.getRoleid());
							// 当前节点处理人
							List<UserRoleInfo> userList = userRoleBL
									.searchUserRoleVW(urcond);
							if (userList != null && userList.size() > 0) {
								// 单个的处理人
								userSet.add(userList.get(0).getUsername());
							}
						} else {// if1的else,指定到角色的情况
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setRoleid(ig222Info.getRoleid());
							List<UserRoleInfo> userRoleList = userRoleBL
									.searchUserRoleVW(urcond);
							for (UserRoleInfo info : userRoleList) {
								userSet.add(info.getUsername());
							}
						}
					}
					String peopleName = "";
					for (Iterator<String> it = userSet.iterator(); it.hasNext();) {
						peopleName = peopleName + it.next().toString() + ",";
					}
					// 去掉最后一个逗号
					if (peopleName.length() > 0) {
						peopleName = peopleName.substring(0,
								peopleName.length() - 1);
					}
					// 当前节点处理人
					mapInList.put("peopleName", peopleName);

				} else {
					mapInList.put("id", ig224info.getPsdid());// 节点状态0节点已跑过
					mapInList.put("state", "0");// 节点状态0节点已跑过
					mapInList.put("ppsdid", ig224info.getPpsdid());
				}
			}
			list.add(mapInList);
		}
		map.put("step", list);// 流程状态相应设置
		log.debug("===============根据prid获取相应应急处理流程的状态处理结束===============");
		return map;
	}

	/**
	 * 根据prid获取节点id和节点名称
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getIG333InfoForScene(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(prid);
		List<IG224Info> ig224Arr = ig224BL
				.findByCondOrderByRslopentime(ig224Cond);
		Map<String, String> ig33Map = getIG333Info(pdid);
		for (IG224Info info : ig224Arr) {
			Map<String, String> datamap = new LinkedHashMap<String, String>();
			datamap.put("flowNodeId", info.getPsdid());
			datamap.put("flowNodeName", ig33Map.get(info.getPsdid()));
			list.add(datamap);
		}
		Collections.reverse(list);

		map.put("data", list);
		return map;
	}

	/**
	 * 获取当前进度百分比的方法
	 * 
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getPercentNum(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> percentmap = new HashMap<String, Object>();
		// 流程pdid设置
		String pdid = "";
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			// 获取流程pdid
			pdid = priList.get(0).getPrpdid();
		}
		// 流程当前处理节点的psdid获取
		String currentPsdid = "";
		// 根据prid获取应急指挥流程主流程的状态字段
		List<ProcessStatusInfo> psiCList = flowSearchBL
				.searchCurrentStatus(prid);
		if (psiCList != null && psiCList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiCList) {
				// 当前节点id
				currentPsdid = psiInfo.getPsdid();
			}
		} else {

			percentmap.put("percentNum", "100");
			percentmap.put("type", "5");
			return percentmap;
		}
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl ig333cond = new IG333SearchCondImpl();
		ig333cond.setPdid(pdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333cond);
		int size = ig333List.size();
		double per = 60.00 / (size - 2);// 2.一个是“应急处置40%”，一个是“事件升级0%”
		double nowper = 0.0;
		for (IG333Info info : ig333List) {
			// 应急处置
			if (IGDRMCONSTANTS.PROCESS_DRICT_DISPOSE_PSDID.equals(info
					.getPsdid())) {
				map.put(info.getPsdid(), "" + (nowper + 40.0));
				nowper = nowper + 40.0;
			} else {
				// 过滤事件升级
				if (!IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID.equals(info
						.getPsdid())) {
					// 关闭节点最后特殊处理
					if (!"C".equals(info.getPsdcode())) {

						map.put(info.getPsdid(), "" + (nowper + per));
						nowper = nowper + per;
					} else {

						map.put(info.getPsdid(), "100");

					}
				}
			}
		}
		percentmap.put("percentNum", "" + map.get(currentPsdid));
		percentmap.put("type", "5");
		return percentmap;
	}

	/**
	 * 根据流程ID获取该流程相应的状态(急指处理流程初始化时使用)
	 * 
	 * @param prid
	 *            流程组实例ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessStatusForOBDR(Integer pgrid)
			throws BLException {
		log.debug("===============根据prid获取相应应急指处理流程的状态处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		// 流程
		List<Object> list = new LinkedList<Object>();
		// 通过流程组prid查询流程组发起的流程
		IG484SearchCondImpl cond = new IG484SearchCondImpl();
		cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(cond);
		for (int i = 0; i < ig484Lst.size(); i++) {
			Integer prid = ig484Lst.get(i).getPrid();
			String pdid = ig484Lst.get(i).getPdid();
			if (null != prid) {
				Object obj = getPStatusForOBDR(prid, pdid);
				list.add(obj);
			}
		}
		map.put("flowlist", list);
		log.debug("===============根据prid获取相应应急处理流程的状态处理结束===============");
		return map;
	}

	/**
	 * 应急处置-根据流程ID获取该流程相应的状态(急指处理流程初始化时使用)
	 * 
	 * @param prid
	 *            流程组实例ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getPStatusForOBDR(Integer prid,
			String pdid) throws BLException {
		log.debug("===============根据prid获取相应应急指处理流程的状态处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			// flowNodeStatus节点状态0、1、2
			if (ig224info.getRslOpenTime() == null
					|| "".equals(ig224info.getRslOpenTime())) {
				mapInList.put("id", ig224info.getPsdid());// 节点状态未开始节点
				mapInList.put("state", "2");// 节点状态0节点已跑过
			} else {
				if (ig224info.getRslCloseTime() == null
						|| "".equals(ig224info.getRslCloseTime())) {
					mapInList.put("id", ig224info.getPsdid());// 节点状态1处在当前节点
					mapInList.put("state", "1");// 节点状态0节点已跑过
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(nowDateTime);
					String nowUsed = getTimeDifference(
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(ig224info
									.getRslOpenTime()), datetime);
					mapInList.put(
							"startTime",
							CommonDefineUtils.DATETIME_SECOND_FORMAT.format(
									ig224info.getRslOpenTime()).split(" ")[1]);
					mapInList.put("useTime", nowUsed);
					// 流程当前处理节点的psdid获取
					String currentPsdid = "";
					// 根据prid获取应急指挥流程主流程的状态字段
					List<ProcessStatusInfo> psiCList = flowSearchBL
							.searchCurrentStatus(prid);
					if (psiCList != null && psiCList.size() > 0) {
						for (ProcessStatusInfo psiInfo : psiCList) {
							// 当前节点id
							currentPsdid = psiInfo.getPsdid();
						}
					}
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(currentPsdid);
					List<IG222Info> ig222InfoList = ig222BL
							.searchIG222Info(ig222cond);
					Set<String> userSet = new HashSet<String>();
					for (IG222Info ig222Info : ig222InfoList) {
						// 循环得到所有处理人，同时去重
						if (!StringUtil.isEmpty(ig222Info.getUserid())) {
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setUserid(ig222Info.getUserid());
							urcond.setRoleid(ig222Info.getRoleid());
							// 当前节点处理人
							List<UserRoleInfo> userList = userRoleBL
									.searchUserRoleVW(urcond);
							if (userList != null && userList.size() > 0) {
								// 单个的处理人
								userSet.add(userList.get(0).getUsername());
							}
						} else {// if1的else,指定到角色的情况
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setRoleid(ig222Info.getRoleid());
							List<UserRoleInfo> userRoleList = userRoleBL
									.searchUserRoleVW(urcond);
							for (UserRoleInfo info : userRoleList) {
								userSet.add(info.getUsername());
							}
						}
					}
					String peopleName = "";
					for (Iterator<String> it = userSet.iterator(); it.hasNext();) {
						peopleName = peopleName + it.next().toString() + ",";
					}
					// 去掉最后一个逗号
					if (peopleName.length() > 0) {
						peopleName = peopleName.substring(0,
								peopleName.length() - 1);
					}
					// 当前节点处理人
					mapInList.put("peopleName", peopleName);

				} else {
					mapInList.put("id", ig224info.getPsdid());// 节点状态0节点已跑过
					mapInList.put("state", "0");// 节点状态0节点已跑过
				}
			}
			list.add(mapInList);
		}
		map.put("steplist", list);// 流程状态相应设置
		map.put("pdid", pdid);// 流程状态相应设置
		log.debug("===============根据prid获取相应应急处理流程的状态处理结束===============");
		return map;
	}

	/**
	 * 根据应急指挥关联的场景类型 0：组合场景 1：单一场景
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static String getSence(Integer prid) throws BLException {
		String cldtype = "";
		EmergencyRelationSearchCondImpl ercond = new EmergencyRelationSearchCondImpl();
		ercond.setParprid(prid);
		List<EmergencyRelationInfo> erList = emergencyRelationBL
				.searchEmergencyRelationInfo(ercond, 0, 1);
		if (null != erList && erList.size() > 0) {
			cldtype = erList.get(0).getCldType();
		}
		return cldtype;
	}

	/**
	 * 根据pgrid获取流程-开始时间（无需推送）
	 * 
	 * @param pgrid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessStartTime(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 流程组pgrid
		List<Map<String, Object>> pridList = ig483BL
				.searchProcessInfoByCond(pgrid);
		String[] pridArr = null;
		if (null != pridList && pridList.size() > 0) {
			pridArr = new String[pridList.size()];
			for (int i = 0; i < pridList.size(); i++) {
				Map<String, Object> pridMap = pridList.get(i);
				pridArr[i] = (String) pridMap.get("PRID");
			}
		}
		// 取任意一条流程组发起的流程的发起节点的开始时间作为流程组发起时间
		if (null != pridArr && pridArr.length > 0) {
			Integer prid = new Integer(pridArr[0]);
			IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
			ig224cond.setPrid(prid);
			ig224cond.setPrstatus("Z");
			List<IG224Info> ig224List = ig224BL
					.findByCondOrderByRslopentime(ig224cond);
			if (ig224List.size() > 0) {
				map.put("sign", "0");
				map.put("time", CommonDefineUtils.DATETIME_SECOND_FORMAT
						.format(ig224List.get(0).getRslOpenTime()).toString()
						.split(" ")[1]);
				map.put("starttime", CommonDefineUtils.DATETIME_SECOND_FORMAT
						.format(ig224List.get(0).getRslOpenTime()).toString());
			}
		}
		return map;
	}

	/**
	 * 根据pgrid获取流程 - 已用时间（无需推送）
	 * 
	 * @param pgrid
	 *            组合场景流程ID
	 * @return Map<String, Object> map 返回MAP
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessUsedTime(Integer pgrid)
			throws BLException {
		// 返回MAP
		Map<String, Object> map = new HashMap<String, Object>();
		// 1：已用时 0：开始时间
		map.put("sign", "1");
		Map<String, Object> startMap = getGroupProcessStartTime(pgrid);
		String startTime = "";
		try {
			if (startMap.containsKey("starttime")) {
				startTime = startMap.get("starttime").toString();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			log.debug("===============获取组合场景开始时间失败===============");
			map.put("emsg", "获取组合场景开始时间失败!");
		}
		// 默认终止时间为现在时间
		Date nowDate = new Date();
		String endTime = CommonDefineUtils.DATETIME_SECOND_FORMAT
				.format(nowDate);
		// 流程组pgrid
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484cond);
		Boolean isAllClose = true;
		Date closeTime = new Date(0);
		if (null != ig484Lst && ig484Lst.size() > 0) {
			for (IG484Info info : ig484Lst) {
				Integer prid = info.getPrid();
				IG224SearchCondImpl cond = new IG224SearchCondImpl();
				cond.setPrid(prid);
				// 关闭
				cond.setPrstatus("C");
				List<IG224Info> list = ig224BL
						.findByCondOrderByRslopentime(cond);
				if (list == null || list.size() == 0) {
					isAllClose = false;
					break;
				} else {
					Date rslCloseTime = list.get(0).getRslCloseTime();
					closeTime = (closeTime.after(rslCloseTime)) ? closeTime
							: rslCloseTime;
				}
			}
		} else {
			isAllClose = false;
		}
		// 全部组内流程都已经是关闭状态
		if (isAllClose) {
			// 取最后的关闭时间作为终止时间
			endTime = CommonDefineUtils.DATETIME_SECOND_FORMAT
					.format(closeTime);
		}
		// 已用时间
		String useTime = getTimeDifference(startTime, endTime);
		map.put("time", useTime);
		return map;
	}

	/**
	 * 根据prid获取相应的信息发布信息(初始化)-组合场景
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupMessageInfo(Integer pgrid)
			throws BLException {
		// JSON传递信息Map设置
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		// 流程组pgrid
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484cond);
		if (null != ig484Lst && ig484Lst.size() > 0) {
			for (IG484Info info : ig484Lst) {
				Integer prid = info.getPrid();
				EmergencyLogSearchCondImpl elcond = new EmergencyLogSearchCondImpl();
				elcond.setElprid_eq(prid.toString());
				// 消息类型：1：实时追跟踪 2：发布消息
				elcond.setEllitype_eq("2");
				String[] asc = { "elid", "ellidtime" };
				elcond.setAscs(asc);
				List<EmergencyLogInfo> elList = emergencyLogBL
						.searchEmergencyLogByCond(elcond);
				for (EmergencyLogInfo el : elList) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("mstime", el.getEllidtime() + ":00");
					map.put("mscontent",
							el.getElliinfo().replaceAll("\r\n", " ")
									.replaceAll("\n", " ").trim());
					listMap.add(map);
				}
			}
		}
		// 流程组下面所有流程的消息
		dataMap.put("mscontentList", listMap);
		dataMap.put("type", "3");
		return dataMap;
	}

	/**
	 * 根据pgrid获取相应的日志记录信息(初始化)实时跟踪-组
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessRecordListInit(
			Integer pgrid) throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的所有日志信息处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		// 流程组pgrid
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484cond);
		if (null != ig484Lst && ig484Lst.size() > 0) {
			for (IG484Info info : ig484Lst) {
				Integer prid = info.getPrid();
				Map<String, Object> pridMap = getProcessRecordListInitByPrid(prid);
				pridMap.put("pdid", info.getPdid());
				list.add(pridMap);
			}
		}
		map.put("data", list);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============根据prid获取相应应急指挥流程的的所有日志信息处理结束===============");
		return map;
	}

	/**
	 * 根据prid获取相应的日志记录信息(初始化)实时跟踪-组内流程
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessRecordListInitByPrid(
			Integer prid) throws BLException {
		log.debug("===============根据prid获取相应应急指挥流程的所有日志信息处理开始===============");
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig33map = getIG333Info(pdid);

		Map<String, String> ig33PsdidMap = getIG333PsdidInfo(pdid);
		// 根据prid获取当前流程的日志集合
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setAscs(asc);
		elCond.setElprid_eq(prid.toString());
		elCond.setEllitype_eq("1");
		// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			mapInList.put("noticeId", el.getElid().toString());// 信息发布ID
			mapInList.put("noticeUser", el.getElusername());// 信息发布人
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// 信息发布时间
			mapInList.put("noticeType", el.getEllitype());// 信息发布类型
			mapInList.put("flowNodeId", el.getElpsdid());// 信息发布节点ID
			// mapInList.put("ppsdid",
			// ig33PsdidMap.get(el.getElpsdid()));//信息发布节点ID
			mapInList.put("flowNodeName", ig33map.get(el.getElpsdid()));// 信息发布类型
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// 信息发布内容
			// 如果当前节点不是子节点
			if (StringUtils.isBlank(ig33PsdidMap.get(el.getElpsdid()))) {
				list.add(mapInList);
			}
		}
		map.put("data", list);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============根据prid获取相应应急指挥流程的的所有日志信息处理结束===============");
		return map;
	}

	/**
	 * 根据pgrid获取节点id和节点名称
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupIG333InfoForScene(Integer pgrid)
			throws BLException {
		// JSON传递信息Map设置
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		// 流程组pgrid
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484cond);
		if (null != ig484Lst && ig484Lst.size() > 0) {
			for (IG484Info info : ig484Lst) {
				Integer prid = info.getPrid();
				Map<String, Object> pridMap = getGroupIG333InfoForSceneByPrid(prid);
				pridMap.put("pdid", info.getPdid());
				list.add(pridMap);
			}
		}
		Collections.reverse(list);
		map.put("data", list);
		return map;
	}

	/**
	 * 根据prid获取节点id和节点名称
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupIG333InfoForSceneByPrid(
			Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程pdid设置
		String pdid = "";
		// 根据prid获取应急指挥流程主流程的主要信息
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(prid);
		List<IG224Info> ig224Arr = ig224BL
				.findByCondOrderByRslopentime(ig224Cond);
		Map<String, String> ig33Map = getIG333Info(pdid);
		// 父节点idMAP
		Map<String, String> ig33PsdidMap = getIG333PsdidInfo(pdid);
		for (IG224Info info : ig224Arr) {
			Map<String, String> datamap = new LinkedHashMap<String, String>();
			datamap.put("flowNodeId", info.getPsdid());
			datamap.put("flowNodeName", ig33Map.get(info.getPsdid()));
			// 设置当前节点状态：1：正在执行 0：已执行
			String state = "0";
			if (null == info.getRslCloseTime()
					|| "".equals(info.getRslCloseTime().toString())) {
				state = "1";
			}
			datamap.put("state", state);
			// 如果当前节点不是子节点
			if (StringUtils.isBlank(ig33PsdidMap.get(info.getPsdid()))) {
				list.add(datamap);
			}
		}
		Collections.reverse(list);
		map.put("data", list);
		return map;
	}

	/**
	 * 根据prid获取节点id和节点名称TAB
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessList(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// 流程组pgrid
		List<IG500Info> ig500Lst = ig483BL.searchProcess(pgrid);
		Map<String, String> datamap = null;
		for (int i = 0; i < ig500Lst.size(); i++) {
			datamap = new LinkedHashMap<String, String>();
			datamap.put("pdid", ig500Lst.get(i).getPrpdid());
			datamap.put("prid", ig500Lst.get(i).getPrid().toString());
			datamap.put("prtitle", ig500Lst.get(i).getPrtitle());
			list.add(datamap);
		}
		Collections.reverse(list);
		map.put("data", list);
		return map;
	}

	/**
	 * 根据prid获取节点id和节点名称TAB
	 * 
	 * @param prid
	 *            流程ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getTerminateMsgFunc(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 流程组pgrid
		IG484SearchCondImpl cond = new IG484SearchCondImpl();
		cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(cond);
		String psdid = "";
		String psdname = "";
		String ppsdid = "";
		String ppsdname = "";
		String pdname = "";
		if (null != ig484Lst && ig484Lst.size() > 0) {
			Integer[] prid_in = new Integer[ig484Lst.size()];
			for (int i = 0; i < ig484Lst.size(); i++) {
				prid_in[i] = ig484Lst.get(i).getPrid();
			}
			// 根据prid获取当前流程的日志集合
			EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
			String[] desc = { "elid", "ellidtime" };
			elCond.setDesc(desc);// 按时间倒序
			elCond.setPrid_in(prid_in);
			// 获取按发布时间顺序排列的所有发布日志信息这样才能保证页面显示日志时最上侧是最新的时间发布的
			List<EmergencyLogInfo> elList = emergencyLogBL
					.searchEmergencyLogByCondForPage(elCond, 0, 1);
			EmergencyLogInfo logInfo = null;
			if (null != elList && elList.size() > 0) {
				logInfo = elList.get(0);
				psdid = logInfo.getElpsdid();
				psdname = logInfo.getElpsdname();
				ProcessStatusInfo psInfo = flowSearchBL
						.searchProcessStatus(psdid);
				ppsdid = psInfo.getPpsdid();
				if (!StringUtils.isBlank(ppsdid)) {
					ProcessStatusInfo ppsInfo = flowSearchBL
							.searchProcessStatus(ppsdid);
					ppsdname = ppsInfo.getPsdname();
				}
				IG380Info ig380Info = ig380BL.searchIG380InfoByKey(psdid
						.substring(0, 7));
				pdname = ig380Info.getPdname();
			}
		}
		map.put("pdname", pdname);
		map.put("ppsdname", ppsdname);
		map.put("psdname", psdname);
		return map;
	}

	/**
	 * 查询应急处置流程所用的最大时间
	 * 
	 * @param prid
	 *            流程prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getStopTime(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(prid);
		ig224Cond.setPrstatus("C");
		List<IG224Info> ig224List = ig224BL.searchIG224Info(ig224Cond,0,0);
		if(ig224List!=null && ig224List.size()>0){
			IG224Info	ig224Info = ig224List.get(0);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String overTime =  format.format(ig224Info.getRslCloseTime());
			map.put("time",overTime);
		}else{
			//获取流程的开始时间
			Map<String,Object> startTimeMap = getProcessStartTime(prid);
			String startTimeStr = startTimeMap.get("time").toString();
			ComputingTime computingTime = new ComputingTime();
			String maxTime = computingTime.getMaxTime(prid.toString());
				Date daystart = new Date(startTimeStr);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(daystart);
				calendar.set(
						Calendar.MINUTE,
						calendar.get(Calendar.MINUTE)
								+ Integer.parseInt(maxTime));
				String overTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(calendar
						.getTime());
				map.put("time",overTime);
			
		}
			map.put("sign", "1");
			return map;
	}

	/**
	 * 获取流程基本信息
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getBaseMessage(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询所关联的应急指挥流程
		EmergencyRelationSearchCondImpl erCond = new EmergencyRelationSearchCondImpl();
		erCond.setCldprid(prid);
		List<EmergencyRelationInfo> searchEmergencyRelationInfo = emergencyRelationBL
				.searchEmergencyRelationInfo(erCond, 0, 0);
		// 查询599中应急指挥流程的应急预案PIID
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(searchEmergencyRelationInfo.get(0).getParprid());
		ig599Cond.setPivarlabel("专项预案");
		List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		// 查询应急预案资产名称
		IG731SearchCondImpl ig731Cond = new IG731SearchCondImpl();
		ig731Cond.setPrid(searchEmergencyRelationInfo.get(0).getParprid());
		ig731Cond.setPiid(ig599List.get(0).getPiid());
		List<IG731Info> ig731List = ig731BL.searchIG731Info(ig731Cond);
		SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(ig731List
				.get(0).getEiid());
		// 预案名称
		String planName = soc0118Info.getEiname();
		// 场景名称
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		IG380Info ig380Info = ig380BL.searchIG380InfoByKey(ig500Info
				.getPrpdid());
		String senceName = ig380Info.getPdname();
		// 当前节点
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		// 查询参与人并存储
		Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
		List<String> nodeNameList = new ArrayList<String>();
		IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
		for (Map<String, Object> currentNodeMap : currentNodes) {
			nodeNameList.add(currentNodeMap.get("psdname").toString());
			ig222Cond.setPsdid(currentNodeMap.get("psdid").toString());
			List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
			UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
			if (ig222List != null && ig222List.size() > 0) {
				for (IG222Info ig222Info : ig222List) {
					if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
						userCond.setUserida(ig222Info.getUserid());
						List<UserInfo> userList = userBL
								.searchUserInfo(userCond);
						if (userList != null && userList.size() > 0) {
							UserInfo user = (UserInfo) userList.get(0);
							userMap.put(user.getUserida(), user);
						}
					} else {
						List<UserInfo> userInfoList = userBL
								.searchUserByRoleId(ig222Info.getRoleid());
						if (userInfoList != null && userInfoList.size() > 0) {
							for (int i = 0; i < userInfoList.size(); i++) {
								UserInfoVW user = new UserInfoVW();
								BeanUtils.copyProperties(userInfoList.get(i),
										user);
								user.setUserida(((UserTB) userInfoList.get(i))
										.getUserid());
								userMap.put(user.getUserida(), user);
							}
						}
					}
				}
			}
		}
		map.put("planName", planName);
		map.put("senceName", senceName);
		return map;
	}

	/**
	 * 获取流程图
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getFlow(Integer prid) throws BLException {
		//流程已用时长
		String[] flowUseTime = getProcessUsedTime(prid).get("time").toString().split(":");
		//转成分钟数
		//秒数默认近一位
		Integer flowUseTimeLengh = Integer.parseInt(flowUseTime[0])*60+Integer.parseInt(flowUseTime[1])+ 1;
		// 当前节点
		List<Map<String, Object>> currentNodes = currentNodeBL.getCurrentNodes(prid);
		// 记录当前节点拼装成Map
		Map<String, String> curNodesPdidMap = new HashMap<String, String>();
		List<Object> stepList = new ArrayList<Object>();
		for (Map<String, Object> currentNodeMap : currentNodes) {
			curNodesPdidMap.put(currentNodeMap.get("psdid").toString(), currentNodeMap.get("psdid").toString());
		}
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		// 对父节点流程排序
		ComputingTime computingTime = new ComputingTime();
		
		Map<String, String> nodeMap = computingTime.getOrderStep(ig500Info.getPrpdid(), "null");
		Map<String, IG333Info> sortNodeMap = new HashMap<String, IG333Info>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//流程预计最大时间
		String maxTime = computingTime.getMaxTime(prid.toString());
		//判断已用时长是否大于流程预计最大时间
		if(flowUseTimeLengh>Integer.parseInt(maxTime)){
			maxTime = ""+(flowUseTimeLengh+Integer.parseInt(maxTime));
		}
		// 流程的开始时间
		Date flowStartTime = new Date();
		// 按照排序之后的Map来进行存储数据
		if (nodeMap != null && nodeMap.size() > 0) {
			for (String key : nodeMap.keySet()) {
				// 判断不是关闭节点
				if (!key.equals(ig500Info.getPrpdid() + "002")&& !key.equals(ig500Info.getPrpdid() + "001")) {
					sortNodeMap.put(key, ig333BL.searchIG333InfoByKey(key));
				} else if (key.equals(ig500Info.getPrpdid() + "001")) {
					// 获取开始节点的时间
					flowStartTime = (Date) currentNodeBL
							.searchAllNodes(prid, key).get(0)
							.get("expectstarttime");
				}
			}
		}
		// 计算时间
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		int sortNumber = 0;
		if (nodeMap != null && nodeMap.size() > 0) {
			//查询关联的应急指挥流程
			IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
			ig599Cond.setPivarvalue(prid.toString());
			ig599Cond.setPivarname("场景prid");
			List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
			String emPrid = "";
			if(ig599List!=null && ig599List.size()>0){
				emPrid =  ig599List.get(0).getPrid().toString();	
			}else{
				ig599Cond.setPivarname("场景相关流程prid");	
				ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
				emPrid = ig599List.get(0).getPrid().toString();	
			}
			
			/*
			 * 硬性认为表格的每一行都只包含一个节点的参与人信息，那么行号和节点ID都是相对唯一的只，那么处理数据分为如下几部
			 * 1、遍历表格式表单值的每一行，将同一节点信息放在一起
			 */
			Map<String, Map<String, String>> tempMap = new HashMap<String, Map<String,String>>();
			if(!emPrid.isEmpty()){
				IG898SearchCondImpl tableFormCond = new IG898SearchCondImpl();
				tableFormCond.setPrid(Integer.parseInt(emPrid));
				List<IG898Info> tableFormValueList = workFlowOperationBL.searchTableFormValue(tableFormCond);
				for(IG898Info info:tableFormValueList){
					if(tempMap.get(info.getPvrownumber()) == null){
						tempMap.put(info.getPvrownumber(), new HashMap<String, String>());
					}
					if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDID.equals(info.getPvcolname())){
						tempMap.get(info.getPvrownumber()).put("psdid", info.getPvalue());
	        		}else if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
	        			tempMap.get(info.getPvrownumber()).put("users", info.getPvalue());
	        		}
				}
			}
			Map<String, Map<String, UserInfo>> psdUserMap = new HashMap<String, Map<String,UserInfo>>();
			for(Iterator<Entry<String, Map<String, String>>> iter = tempMap.entrySet().iterator();iter.hasNext();){
				Entry<String, Map<String, String>> entry = iter.next();
				Map<String, String> map = entry.getValue();
				String psdid = map.get("psdid");
				String us = map.get("users");
				Map<String, UserInfo> temp = new LinkedHashMap<String, UserInfo>();
				if(StringUtils.isNotEmpty(us)){
					//角色_role_用户
        			String[] roleusers = us.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]角色id#角色name , [1]用户id#用户name_user_用户id#用户name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null && roleAnduser.length > 1){
        						//用户id#用户name
    							String[] users = roleAnduser[1].split("_user_");
    							for(String user : users){
    								if(StringUtils.isNotBlank(user)){
    									String[] userinfo = user.split("#");
    									if(userinfo.length > 1){
    										UserInfoVW u = new UserInfoVW();
    										u.setUsername(userinfo[1]);
    										temp.put(userinfo[0], u);
    									}
    								}
    							}
        					}
        				}
        			}
				}
				psdUserMap.put(psdid, temp);
			}
			
			for (String key : nodeMap.keySet()) {
				if (!key.equals(ig500Info.getPrpdid() + "002") && !key.equals(ig500Info.getPrpdid() + "001")) {
					IG333Info ig333Info = sortNodeMap.get(key);
					Map<String, Object> flowNode = new HashMap<String, Object>();
					sortNumber++;
					// 节点序号
					flowNode.put("sortNumber", "" + sortNumber);
					flowNode.put("psdid", key);
					// 节点的预计开始时间标识
					flowNode.put("expectStartSign", nodeMap.get(key));
					// 节点的预计开始时间
					flowNode.put("expectStartTime",computeExpectStartTime(flowStartTime,nodeMap.get(key)));
					// 节点预计使用时间
					flowNode.put("expectUseTime", getExpectUseTime(ig333Info.getBysequence().replaceAll(" ", "")));
					List<Map<String, Object>> nodeList = currentNodeBL.searchAllNodes(prid, key);
					flowNode.put("psdname", ig333Info.getPsdname());
					if (nodeList != null && nodeList.size() > 0) {
						Map<String, Object> nowNode = nodeList.get(0);
						if (nowNode.get("factstoptime") == null) {
							// 节点实际使用时间
							flowNode.put("factUseTime", "");
							// 节点正在执行类型
							flowNode.put("stepType", "executing");
							// 节点实际执行时间标识
							flowNode.put("factStartSign", "");
							flowNode.put("factStartTime",format.format((Date) nowNode.get("factstarttime")));
						} else {
							// 节点实际执行时间标识
							String factUseTime = getFactUseTime(computeFactUseTime((Date) nowNode.get("factstarttime"),(Date) nowNode.get("factstoptime")));
							
							flowNode.put("factUseTime",factUseTime);
							// 节点实际执行时间标识
							flowNode.put("factStartSign",Double.parseDouble(computeFactUseTime(flowStartTime,(Date) nowNode.get("factstarttime")))/60);
							// 节点是已完成节点
							flowNode.put("stepType", "finish");
							
							flowNode.put("factStartTime",format.format((Date) nowNode.get("factstarttime")));
						}
					} else {
						// 节点实际使用时间
						flowNode.put("factUseTime", "");
						// 节点正在未执行类型
						flowNode.put("stepType", "will");
						// 节点实际执行时间标识
						flowNode.put("factStartSign", "");
						flowNode.put("factStartTime", "");
					}
					// 查询参与人并存储
					
					Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
					//查询当前节点已处理参与人
					List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipantDoneRole(prid, ig333Info.getPsdid());
					if(!ppList.isEmpty()){
						for(IG337Info info:ppList){
							if(StringUtils.isNotEmpty(info.getPpuserid())){
								UserInfoVW user = new UserInfoVW();
								user.setUsername(info.getPpusername());
								userMap.put(info.getPpuserid(), user);
							}
						}
					}else{
						if(!psdUserMap.isEmpty()){
							Map<String, UserInfo> map = psdUserMap.get(ig333Info.getPsdid());
							if(map != null){
								for(Iterator<Entry<String, UserInfo>> iter = map.entrySet().iterator();iter.hasNext();){
									Entry<String, UserInfo> entry = iter.next();
									userMap.put(entry.getKey(), entry.getValue());
								}
							}
						}else{
							IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
							UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
							ig222Cond.setPsdid(ig333Info.getPsdid());
							List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
							if (ig222List != null && ig222List.size() > 0) {
								for (IG222Info ig222Info : ig222List) {
									if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
										userCond.setUserida(ig222Info.getUserid());
										List<UserInfo> userList = userBL.searchUserInfo(userCond);
										if (userList != null && userList.size() > 0) {
											UserInfo user = (UserInfo) userList.get(0);
											userMap.put(user.getUserida(), user);
										}
									} else {
										List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
										if (userInfoList != null&& userInfoList.size() > 0) {
											for (int i = 0; i < userInfoList.size(); i++) {
												UserInfoVW user = new UserInfoVW();
												BeanUtils.copyProperties(userInfoList.get(i), user);
												user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
												userMap.put(user.getUserida(), user);
											}
										}
									}
								}
							}
							
						}
					}
					StringBuffer peopleStr = new StringBuffer();
					StringBuffer userids = new StringBuffer();
					for (String peopleKey : userMap.keySet()) {
						peopleStr.append(userMap.get(peopleKey).getUsername()+ "、");
						userids.append(peopleKey + ",");
					}
					if (peopleStr.length() > 0) {
						flowNode.put("people",peopleStr.toString().substring(0,peopleStr.length() - 1));
						flowNode.put("userids", userids.toString().substring(0, userids.length() - 1));
					} else {
						flowNode.put("people", "");
						flowNode.put("userids", "");
					}

					IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
					ig560Cond.setPsdid(ig333Info.getPsdid());
					// 查询560中的数据并添加到flowDetail中
					List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
					StringBuffer emergencyResources = new StringBuffer();
					if (ig560List != null && ig560List.size() > 0) {
						for (int index = 0; index < ig560List.size(); index++) {
							IG560Info ig560Info = ig560List.get(index);
							if (ig560Info.getPidid().contains("001")&& ig560Info.getDfvalue().split("_").length > 1) {
								SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
								soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
								soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
								List<SOC0118VWInfo> list = soc0118VWBL.searchEntityItem(soc0118Cond);
								if (index < ig560List.size() - 1) {
									emergencyResources.append(ig560Info.getDfvalue().split("_SOC_")[0]+ "_EIID_"+ list.get(0).getEiname() + "*##*");
								} else {
									emergencyResources.append(ig560Info.getDfvalue().split("_SOC_")[0]+ "_EIID_"+ list.get(0).getEiname());
								}
							}
						}
						flowNode.put("emergencyResources",
								emergencyResources.toString());
					} else {
						flowNode.put("emergencyResources", "");
					}
					
					//应急步骤
					if(!ig333Info.getPsddesc().isEmpty()){
						flowNode.put("nodeStep", ig333Info.getPsddesc());
					}else{
						flowNode.put("nodeStep", "");
					}
					//节点日志
					List<Map<String,Object>> stepLogMsgList = new ArrayList<Map<String,Object>>();
					EmergencyLogSearchCondImpl elsCond = new EmergencyLogSearchCondImpl();
					String[] psdidArr = {key};
					elsCond.setElprid_eq(prid.toString());
					elsCond.setPsdid_in(psdidArr);
					List<EmergencyLogInfo> emergencyLogList = emergencyLogBL.searchEmergencyLogByCond(elsCond);
					if(emergencyLogList!=null &&emergencyLogList.size()>0){
						for(int elIndex = 0;elIndex<emergencyLogList.size();elIndex++){
							Map<String,Object> stepMessage = new HashMap<String,Object>();
							EmergencyLogInfo emergencyLogInfo = emergencyLogList.get(elIndex);
							//处理时间
							stepMessage.put("dealTime", emergencyLogInfo.getEllidtime().split(" ")[1]);
							//处理人
							stepMessage.put("dealPeople", emergencyLogInfo.getElusername());
							//处理信息
							stepMessage.put("logMsg", emergencyLogInfo.getElliinfo() == null ? "" : emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
							stepMessage.put("operate", emergencyLogInfo.getOperate());
							stepLogMsgList.add(stepMessage);
						}
						flowNode.put("stepMessageList", stepLogMsgList);
					}else{
						flowNode.put("stepMessageList", "");
					}
					// 如果下个节点是关闭节点则设置为空
					if (ig333Info.getFingerPrint().equals(
							ig500Info.getPrpdid() + "002")) {
						flowNode.put("afterNode", "");
					} else {
						flowNode.put("afterNode", ig333Info.getFingerPrint());
					}
					
					stepList.add(flowNode);
				}
			}
		}
		resultMap.put("stepList", stepList);
		resultMap.put("maxTime", maxTime);
		return resultMap;
	}

	/**
	 * 获取流程的处理日志
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getLogMessage(Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> messageList = new ArrayList<Map<String,Object>>();
		//查询流程日志
		EmergencyLogSearchCondImpl elsCond = new EmergencyLogSearchCondImpl();
		elsCond.setElprid_eq(prid.toString());
		List<EmergencyLogInfo> emergencyLogList = emergencyLogBL.searchEmergencyLogByCond(elsCond);
		if(emergencyLogList!=null &&emergencyLogList.size()>0){
			for(EmergencyLogInfo emergencyLogInfo:emergencyLogList){
				Map<String, Object> messageMap = new HashMap<String, Object>();
				//处理时间
				messageMap.put("time", emergencyLogInfo.getEllidtime().split(" ")[1]);
				//处理日志
				messageMap.put("logMsg", emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
				//处理人
				messageMap.put("peopleHandle", emergencyLogInfo.getElusername());
				//节点名称
				messageMap.put("nodeName", emergencyLogInfo.getElpsdname());
				
				//预计时长
				Map<String, Object> nowNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				String expectUseTime =  nowNode.get("expectusetime").toString().replaceAll(" ", "");
				//获取节点
				Map<String, Object> currentNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				Date factStartTime = (Date)currentNode.get("factstarttime");
				Date factStopTime = new Date();
				if(currentNode.get("factstoptime")!=null){
					factStopTime = (Date)currentNode.get("factstoptime");
				}else{
					String ellidTime = emergencyLogInfo.getEllidtime();
					factStopTime = new Date(ellidTime);
				}
				//实际操作的时间
				String factUseTime = computeFactUseTime(factStartTime,factStopTime);
				Double overPlusTime = Double.parseDouble(expectUseTime)-Double.parseDouble(factUseTime)/60;
				String overPlusTimeStr = String.format("%.2f", overPlusTime);
				messageMap.put("timeRemaining", ""+overPlusTimeStr);
				messageList.add(messageMap);
			}
		}
		map.put("messageList", messageList);
		return map;
	}
	/**
	 * 计算流程预期开始时间
	 * 
	 * @param flowStartTime
	 * @param expectstartsign
	 * @return expectStartTime
	 */
	private static String computeExpectStartTime(Date flowStartTime,
			String expectstartsign) {
		String expectStartTime = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(flowStartTime);
		calendar.set(
				Calendar.MINUTE,
				calendar.get(Calendar.MINUTE)
						+ Integer.parseInt(expectstartsign));
		expectStartTime = new SimpleDateFormat("HH:mm:ss").format(calendar
				.getTime());
		return expectStartTime;

	}

	
	/**
	 * 计算实际使用时间
	 * 
	 * @param factStartTime
	 * @param factOverTime
	 * @return
	 */
	private static String computeFactUseTime(Date factStartTime,
			Date factOverTime) {
		Long factUseTime = (factOverTime.getTime() - factStartTime.getTime())/1000;
			return factUseTime.toString();
	}
	
	/**
	 * 计算流程的使用时间
	 * 
	 * @param expectStartSign
	 * @return
	 */
	private static String getFactUseTime(String expectUseTimeSign) {
		String second = "" + Integer.parseInt(expectUseTimeSign) % 60;
		String hour = "" + Integer.parseInt(expectUseTimeSign) / 3600;
		String minute = "" +  (Integer.parseInt(expectUseTimeSign)/60-Integer.parseInt(hour)*60);
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if(second.length() == 1){
			second = "0" + second;
		}	
		return hour + ":" + minute + ":" + second;
		
	}
	
	
	/**
	 * 计算流程的使用时间
	 * 
	 * @param expectStartSign
	 * @return
	 */
	public static String getExpectUseTime(String expectUseTimeSign) {
		String minute = "" + Integer.parseInt(expectUseTimeSign) % 60;
		String hour = "" + Integer.parseInt(expectUseTimeSign) / 60;
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		return hour + ":" + minute + ":" + "00";
	}

	/**
	 * 查询流程的关闭时间
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getOverTime(Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		//查询出关闭节点的关闭时间
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		cond.setPrstatus("C");
		IG224Info ig224Info = ig224BL.searchIG224Info(cond, 0, 0).get(0);
		// 计算时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String closeTime = format.format(ig224Info.getRslCloseTime());
		map.put("time", closeTime);
		map.put("sign", "1");
		return map;
	}
	
	public static Map<String,Object> getEmergencyFlow(Integer prid) throws BLException{
		Map<String, Object> map = new HashMap<String, Object>();
		//查询所有的节点
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		List<IG224Info> ig224InfoList = ig224BL.searchIG224Info(cond, 0, 0);
		List<Map<String,Object>> flowList = new ArrayList<Map<String,Object>>();
		Date startTime = new Date();
		Date overTime =  new Date();
		
		if(ig224InfoList!=null && ig224InfoList.size()>0){
			//记录开始时间和关闭时间
			for(IG224Info ig224Info:ig224InfoList){
				if(ig224Info.getPrstatus()!=null && ig224Info.getPrstatus().equals("C") ){
					overTime = ig224Info.getRslCloseTime();
				}else if(ig224Info.getPsdid().substring(ig224Info.getPsdid().length()-3, ig224Info.getPsdid().length()).equals("003") ){
					//获取上报节点当开始节点
					startTime  = ig224Info.getRslOpenTime();
				}
			}
			//查询出所有的节点的数据并且赋值
			int index = 0;
			for(IG224Info ig224Info:ig224InfoList){
				if(ig224Info.getPrstatus()==null){
					Map<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put("psdid", ig224Info.getPsdid());
					dataMap.put("factStartTime",  String.format("%.2f",Double.parseDouble(computeFactUseTime(startTime,ig224Info.getRslOpenTime()))/60));
					switch(index){
						case 0:
							dataMap.put("backGroundColor", 0xE38313);
							index++;
							break;
						case 1:
							dataMap.put("backGroundColor", 0xEBA903);
							index++;
							break;
						case 2:
							dataMap.put("backGroundColor", 0x95AC26);
							index++;
							break;
						case 3:
							dataMap.put("backGroundColor", 0x579E36);
							index++;
							break;
						case 4:
							dataMap.put("backGroundColor", 0xF14E51);
							index++;
							break;
						case 5:
							dataMap.put("backGroundColor", 0x5F32B1);
							index++;
							break;
						case 6:
							dataMap.put("backGroundColor", 0x12B5D1);
							index++;
							break;	
					}
					dataMap.put("factUseTime", getFactUseTime(computeFactUseTime(ig224Info.getRslOpenTime(),ig224Info.getRslCloseTime())));
					IG333Info ig333Info = ig333BL.searchIG333InfoByKey(ig224Info.getPsdid());
					dataMap.put("psdname", ig333Info.getPsdname());	
					flowList.add(dataMap);
				}
			}
		}
		map.put("maxTime", String.format("%.2f", Double.parseDouble(computeFactUseTime(startTime,overTime))/60));
		map.put("stepList", flowList);
		return map;
	}
	
	public static  Map<String,Object> getSystemTime() throws BLException{
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateStr = format.format(date);
		map.put("systemTime", dateStr);
		return map;
	}
	/**
	 * 通过条件来查询业务系统的eiid 并且请求,通过业务系统ID更新业务系统应急演练状态(应急指挥和演练流程)
	 * @param prid 流程prid
	 * @param pivarname 流程业务系统表单名称
	 * @param state 业务系统的状态(0:正常,1:计划中,2:演练中,3:演练结束,4:变更计划中,5:变更中,6:变更完成,7:应急中)
	 * @param desc 详细描述
	 * @throws BLException
	 */
	public static void changeSystemState(Integer prid,String pivarname,String state,String desc) throws BLException{
		log.debug("===============查询业务系统表单开始===============");
		log.debug("===============流程prid="+prid+"==============");
		//获取当前的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		String startTime = format.format(nowDate);
		//通过条件来查询业务系统资产的eiid
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(prid);
		ig599Cond.setPivarname(pivarname);
		List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
		List<IG731Info> ig731InfoList = null;
		if(ig599InfoList!=null && ig599InfoList.size()>0){
			IG731SearchCondImpl ig731Cond = new IG731SearchCondImpl();
			ig731Cond.setPrid(prid);
			ig731Cond.setPiid(ig599InfoList.get(0).getPiid());
			ig731InfoList = ig731BL.searchIG731Info(ig731Cond);
		}
		log.debug("===============查询业务系统表单结束===============");
		//调用url
		if(ig731InfoList!=null && ig731InfoList.size()>0){
			//获取切换主备按钮的url
			String changeSystemStateUrl = ResourceUtility.getString("CHANGESYSTEMSTATE_URL");
			for(IG731Info ig731Info:ig731InfoList){
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("systemid", ig731Info.getEiid().toString()));
				list.add(new BasicNameValuePair("state", state));
				list.add(new BasicNameValuePair("starttime", startTime));
				if(StringUtils.isNotEmpty(desc)){
					list.add(new BasicNameValuePair("desc", desc));
				}
				HttpParams params = new BasicHttpParams();
				params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1 * 60 * 1000);
				params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 1 * 60 * 1000);
				
				// 实现将请求 的参数封装封装到HttpEntity中。
				UrlEncodedFormEntity entity;
				try {
					entity = new UrlEncodedFormEntity(list, "utf-8");
					// 使用HttpPost请求方式
					HttpPost httpPost = new HttpPost(changeSystemStateUrl);
					// 设置请求参数到Form中。
					httpPost.setEntity(entity);
					// 实例化一个默认的Http客户端
					DefaultHttpClient client = new DefaultHttpClient(params);
					// 执行请求，并获得响应数据
					log.debug("========================访问url开始===========================");
					log.debug("========================访问url地址："+changeSystemStateUrl+".do?systemid="+ig731Info.getEiid().toString()+"&state="+state+"&starttime="+startTime+"===========================");
					HttpResponse httpResponse = client.execute(httpPost);
					String result1 = EntityUtils.toString(httpResponse.getEntity());
					log.debug("========================访问url返回结果：+"+result1+"===========================");
					log.debug("========================访问url结束===========================");
				} catch (Exception e) {
					log.debug("========================访问url失败原因："+e.getMessage()+"===========================");
					log.debug("========================访问url失败===========================");
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * 通过条件来查询业务系统的eiid 并且请求,通过业务系统ID更新业务系统应急演练状态(变更流程)
	 * @param prid 流程prid
	 * @param state 业务系统的状态(0:正常,1:计划中,2:演练中,3:演练结束,4:变更计划中,5:变更中,6:变更完成,7:应急中)
	 * @param desc 详细描述
	 * @throws BLException
	 */
	public static void changeFlowSystemState(Integer prid,String state,String desc) throws BLException{
		log.debug("===============查询业务系统表单开始===============");
		log.debug("===============流程prid="+prid+"==============");
		//获取当前的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		String startTime = format.format(nowDate);
		String[] nameArr = null;
		//通过条件来查询业务系统资产的eiid
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(prid);
		ig599Cond.setPivarname("更新平台");
		List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(ig599InfoList!=null && ig599InfoList.size()>0){
			IG599Info ig599Info = ig599InfoList.get(0);
			nameArr = ig599Info.getPivarvalue().split("#");
		}
		//所有要更改的资产集合
		List<CodeDetailDef> eiidList = new ArrayList<CodeDetailDef>();
		if(nameArr!=null && nameArr.length>0){
			for(String name:nameArr){
				CodeDetailDefSearchCondImpl codeDetailDefCond = new CodeDetailDefSearchCondImpl();
				codeDetailDefCond.setCcid("304");
				codeDetailDefCond.setCvalue_like(name);
				List<CodeDetailDef> codeDetailDefList = codeDetailDefBL.searchCodeDetailDef(codeDetailDefCond);
				if(codeDetailDefList!=null && codeDetailDefList.size()>0){
					eiidList.addAll(codeDetailDefList);
				}
			}
		}
		log.debug("===============查询业务系统表单结束===============");
		//判断所有的资产并且发送url
		if(eiidList!=null && eiidList.size()>0){
			//获取切换主备按钮的url
			String changeSystemStateUrl = ResourceUtility.getString("CHANGESYSTEMSTATE_URL");
			for(CodeDetailDef codeDetailDef:eiidList){
				//判断数据是否正确
				if(codeDetailDef.getCvalue().split("-").length>1){
					List<NameValuePair> list = new ArrayList<NameValuePair>();
					list.add(new BasicNameValuePair("systemid", codeDetailDef.getCvalue().split("-")[1]));
					list.add(new BasicNameValuePair("state", state));
					list.add(new BasicNameValuePair("starttime", startTime));
					if(StringUtils.isNotEmpty(desc)){
						list.add(new BasicNameValuePair("desc", desc));
					}
					HttpParams params = new BasicHttpParams();
					params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1 * 60 * 1000);
					params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 1 * 60 * 1000);
					
					// 实现将请求 的参数封装封装到HttpEntity中。
					UrlEncodedFormEntity entity;
					try {
						entity = new UrlEncodedFormEntity(list, "utf-8");
						// 使用HttpPost请求方式
						HttpPost httpPost = new HttpPost(changeSystemStateUrl);
						// 设置请求参数到Form中。
						httpPost.setEntity(entity);
						// 实例化一个默认的Http客户端
						log.debug("========================访问url开始===========================");
						log.debug("========================访问url地址："+changeSystemStateUrl+".do?systemid="+codeDetailDef.getCvalue().split("-")[1]+"&state="+state+"&starttime="+startTime+"===========================");
						DefaultHttpClient client = new DefaultHttpClient(params);
						// 执行请求，并获得响应数据
						HttpResponse httpResponse = client.execute(httpPost);
						String result1 = EntityUtils.toString(httpResponse.getEntity());
						log.debug("========================访问url返回结果：+"+result1+"===========================");
						log.debug("========================访问url结束===========================");
					} catch (Exception e) {
						log.debug("========================访问url失败原因："+e.getMessage()+"===========================");
						log.debug("========================访问url失败===========================");
						e.printStackTrace();
					}
				}else{
					log.debug("访问url错误数据："+codeDetailDef.getCvalue());
				}
			}
		}
	}
	/**
	 * 拼装详细描述字段
	 * @param workNumStr 工单号 
	 * @param prtitle 标题
	 * @return 详细描述字段
	 * @throws BLException 
	 */
	public static String getDesc(Integer prid) throws BLException{
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		String desc = "["+ig500Info.getPrserialnum()+"]["+ig500Info.getPrtitle()+"]";
		return desc;
	}
}
