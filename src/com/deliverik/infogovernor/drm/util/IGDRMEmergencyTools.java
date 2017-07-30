/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ������Ӧ��ָ��ϵͳ������ ����������Ӧ��ָ��ϵͳ������ ������¼��2014/05/19 �޸ļ�¼��2014/06/03 LuJiayuan
 * (1)���ӳ�ʼ��ʱ��������Ϣ�Ա�֤����ҳ����Ӧ����Ϣ��ͬ����
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
	/** ���̴���BL */
	protected static WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");


	/**
	 * ����prid��ȡ��ǰ״̬����־��¼��Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreCurrentStatusNotisListInit(
			Integer prid) throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�������־��Ϣ������ʼ===============");

		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport
				.getBean("flowSearchBL");

		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport
				.getBean("emergencyLogBL");
		// ����prid��ȡ��ǰ���̵���־����
		// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
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
		// �޸ĳɵ�������
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
				psdName = "֪ͨ��Ϣ";
			}
			Map<String, String> logMap = new HashMap<String, String>();
			logMap.put("noticeTime", el.getEllidtime().split(" ")[1]);// ��Ϣ����ʱ��
			logMap.put("noticeContnt", el.getElliinfo().replaceAll("\r\n", " ")
					.replaceAll("\n", " ").trim());// ��Ϣ��������
			logMap.put("noticeUser", el.getElusername());// ��Ϣ������
			logMap.put("noticeId", el.getElid().toString());// ��Ϣ����ID
			logMap.put("noticeType", el.getEllitype());// ��Ϣ��������
			logMap.put("psdname", el.getElpsdname());// ��Ϣ��������
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

		// ��ȡ���̵�ǰ�ڵ����Ϣ
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();

		for (Map map2 : currentNodes) {

			Date openDate = new Date(map2.get("rslopentime").toString()
					.substring(0, 19).replace("-", "/"));
			// ��ʼ�¼�ain
			map2.put("opentime", sdf.format(openDate).substring(11));
			Calendar c = Calendar.getInstance();
			c.setTime(openDate);
			int min = map2.get("notifym") == null ? 0 : Integer.valueOf(map2
					.get("notifym").toString());
			c.add(Calendar.MINUTE, min);
			// Ԥ�ƽ���ʱ��
			map2.put("closetime", sdf.format(c.getTime()).substring(11));
			long diffTime = nowDate.getTime() - openDate.getTime();

			StringBuffer useTime = new StringBuffer();
			// Сʱ
			int hh = (int) (diffTime / 3600000);
			// ����
			int mm = (int) (diffTime % 3600000) / 60000;
			// ��
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

		// JSON������ϢMap����
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", currentNodes);
		dataMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�������־��Ϣ��������===============");
		return dataMap;
	}

	/**
	 * ����prid��ȡ��Ӧ����־��¼��Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessRecordListInit(
			Integer prid) throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�������־��Ϣ������ʼ===============");

		EmergencyLogBL emergencyLogBL = (EmergencyLogBL) WebApplicationSupport
				.getBean("emergencyLogBL");
		// ����prid��ȡ��ǰ���̵���־����
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setElprid_eq(prid.toString());
		elCond.setAscs(asc);
		// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		LinkedHashMap<String, LinkedList<Map<String, String>>> jsonMap = new LinkedHashMap<String, LinkedList<Map<String, String>>>();

		for (EmergencyLogInfo el : elList) {

			// ��ѯ���ڵ������ƴ�ӵ����ڵ��ǰ��
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
				psdName = "֪ͨ��Ϣ";
			}
			Map<String, String> logMap = new HashMap<String, String>();
			logMap.put("noticeTime", el.getEllidtime().split(" ")[1]);// ��Ϣ����ʱ��
			logMap.put("noticeContnt", el.getElliinfo().replaceAll("\r\n", " ")
					.replaceAll("\n", " ").trim());// ��Ϣ��������
			logMap.put("noticeUser", el.getElusername());// ��Ϣ������
			logMap.put("noticeId", el.getElid().toString());// ��Ϣ����ID
			logMap.put("noticeType", el.getEllitype());// ��Ϣ��������
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

		// JSON������ϢMap����
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", dataList);
		dataMap.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�������־��Ϣ��������===============");
		return dataMap;
	}

	/**
	 * ��������ID��ȡ��������Ӧ��״̬˳���б�(��ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessStatusListInit(
			Integer prid) throws BLException {
		log.debug("===============����prid��ȡ��Ӧ�����ָ����̵�״̬��������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> statusList = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		// ���̵�ǰ�����ڵ��bysequence��ȡ
		String[] currentId = new String[0];
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		// ����prid��ȡӦ��ָ�����������̵�״̬�ֶ�
		List<ProcessStatusInfo> psiCList = flowSearchBL
				.searchCurrentStatus(prid);

		// ��ȡ����״̬�ڵ�Ľ���ʱ��
		Map<String, String> initTimeMap = getInitTimeMap(prid);
		// ��ȡ����״̬�ڵ������ʱ
		Map<String, String> usedTimeMap = getUsedTimeMap(prid);
		// ���²�ѯ��ǰ�ڵ���Ϣ
		// ��ȡ���̵�ǰ�ڵ����Ϣ
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		List<Object> currentIds = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		for (Map map2 : currentNodes) {

			Date openDate = new Date(map2.get("rslopentime").toString()
					.substring(0, 19).replace("-", "/"));
			// ��ʼ�¼�ain
			map2.put("opentime", sdf.format(openDate).substring(11));
			Calendar c = Calendar.getInstance();
			c.setTime(openDate);
			int min = map2.get("notifym") == null ? 0 : Integer.valueOf(map2
					.get("notifym").toString());
			c.add(Calendar.MINUTE, min);
			// Ԥ�ƽ���ʱ��
			map2.put("closetime", sdf.format(c.getTime()).substring(11));
			long diffTime = nowDate.getTime() - openDate.getTime();

			StringBuffer useTime = new StringBuffer();
			// Сʱ
			int hh = (int) (diffTime / 3600000);
			// ����
			int mm = (int) (diffTime % 3600000) / 60000;
			// ��
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

		// ����pdid��ȡӦ��ָ�����������̵�״̬���򼯺�
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusList(pdid);

		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				String prvenode = psiInfo.getFingerPrint();
				if (prvenode == null) {
					prvenode = "";
				}
				Map<String, String> mapInList = new HashMap<String, String>();
				mapInList.put("psdid", psiInfo.getPsdid());// ״̬ID_psdid�ֶ�
				mapInList
						.put("statusTime", initTimeMap.get(psiInfo.getPsdid()));// ״̬����ʱ��
				mapInList.put("useTime", usedTimeMap.get(psiInfo.getPsdid()));// ״̬����ʱ
				mapInList.put("psdname", psiInfo.getPsdname());// ״̬����_psdname�ֶ�
				mapInList.put("pseq", psiInfo.getBysequence());// �����ֶ�
				mapInList.put("prvenode", prvenode);// ǰ�ýڵ�ID
				mapInList.put("ppsdid", psiInfo.getPpsdid());// ���ڵ�
				if (StringUtils.isNotEmpty(initTimeMap.get(psiInfo.getPsdid()))
						&& StringUtils.isNotEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "0");// �����
				} else if (StringUtils.isEmpty(initTimeMap.get(psiInfo
						.getPsdid()))
						&& StringUtils.isEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "2");// ��δ��ʼ
				} else if (StringUtils.isNotEmpty(initTimeMap.get(psiInfo
						.getPsdid()))
						&& StringUtils.isEmpty(usedTimeMap.get(psiInfo
								.getPsdid() + psiInfo.getPsdid()))) {
					mapInList.put("ppstate", "1");// ���ڴ���
				}
				statusList.add(mapInList);
			}
		}

		map.put("data", statusList);// ����״̬��Ӧ����
		map.put("currentId", currentNodes);
		map.put("currentIds", currentIds);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_PROCESS);
		map.put("pdid", pdid);
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�״̬����������===============");
		return map;
	}

	/**
	 * ��������ID��ȡ�����̿�ʼʱ��(��ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static String getRestoreProcessOpenTime(Integer prid)
			throws BLException {
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			String propenTime = priList.get(0).getPropentime();
			propenTime = propenTime.replaceFirst("/", "��");
			propenTime = propenTime.replaceFirst("/", "��");
			propenTime = propenTime.replaceFirst(" ", "�� ");
			return propenTime;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
			return sdf.format(new Date());
		}
	}

	/**
	 * ��ȡ��ǰӦ��ָ�����̵���Ӧ��Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ��ǰ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getEmergencyProcessInfo(Integer prid)
			throws BLException {
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ������ʼ===============");
		// ��ȡ"�¼�����ʱ��"��Ӧ�ı���ֵ(��������"�¼��ϱ�ʱ��")
		String oTime = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_OTIME);
		// ��ȡ"�¼��ϱ���Ա"��Ӧ�ı���ֵ(��������"�¼��ϱ���")
		String reUser = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_REUSER);
		IG506BL ig506BL = (IG506BL) WebApplicationSupport.getBean("ig506BL");
		IG506Info ig506Info = StringUtils.isEmpty(reUser)? null:ig506BL.searchIG506ByPK(Integer.parseInt(reUser));
		// �¼��ϱ���
		String username = ig506Info != null ? ig506Info.getPiusername() : "";
		// �ϱ�����ϵ�绰
		String userphone = ig506Info != null ? ig506Info.getPiphone() : "";
		// ��ȡ"�¼��������"��Ӧ�ı���ֵ(��������"�¼�����")
		String desc = flowSearchBL.searchPublicProcessInfo(prid,
				IGDRMCONSTANTS.EMCPRO_DESC);
		// JSON������ϢMap����
		Map<String, Object> datamap = new HashMap<String, Object>();
		// ��֯���ݸ�ʽ
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
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ��������===============");
		return datamap;
	}

	/**
	 * ��ȡ��ǰӦ��ָ�����̵���Ӧ��Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ��ǰ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestoreProcessInfo(Integer cldPrid)
			throws BLException {
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ������ʼ===============");
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
			// ��ȡ"�¼�����ʱ��"��Ӧ�ı���ֵ(��������"�¼�����ʱ��")
			String oTime = flowSearchBL.searchPublicProcessInfo(prid,
					IGDRMCONSTANTS.EMCPRO_OTIME);
			// ��ȡ"�¼��������"��Ӧ�ı���ֵ(��������"�¼�����")
			String desc = flowSearchBL.searchPublicProcessInfo(prid,
					IGDRMCONSTANTS.EMCPRO_DESC);
			// JSON������ϢMap����
			// ����Mapֵ
			mapInMap.put("oTime", oTime);
			mapInMap.put("desc", desc.replace("<br>", "")
					.replace("&nbsp;", " ").trim());
			map.put("data", mapInMap);
			map.put("type", IGDRMCONSTANTS.DB_TYPE_EMCINFO);
		}
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ��������===============");
		return map;
	}

	public static String getProcessStartDate(Integer prid) throws BLException {
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			ProcessRecordInfo prBean = priList.get(0);
			return prBean.getPropentime().split(" ")[0].replaceFirst("/", "��")
					.replaceFirst("/", "��") + "��";
		}
		return "";
	}

	/**
	 * ��ȡ��ǰӦ��ָ������ϵͳ��Ϣ(����)
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public static Map<String, Object> getSystemNotice(Integer prid)
			throws BLException {

		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�����ϵͳ��־��Ϣ������ʼ===============");

		// ��ȡ������̵�id
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(prid);
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();

		// ����prid��ȡ��ǰ���̵���־����
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		elCond.setEllitype_eq("2");
		String[] asc = { "elid", "ellidtime" };
		elCond.setElprid_eq(prid.toString());
		elCond.setAscs(asc);
		// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = getMessageMap();
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// ��Ϣ����ʱ��
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// ��Ϣ��������
			mapInList.put("noticeUser", el.getElusername());// ��Ϣ������
			mapInList.put("noticeId", el.getElid().toString());// ��Ϣ����ID
			mapInList.put("noticeType", el.getEllitype());// ��Ϣ��������
			list.add(mapInList);
		}
		map.put("data", list);
		map.put("type", "7");
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�����ϵͳ��־��Ϣ��������===============");
		return map;

	}

	/**
	 * ��ȡ��ǰӦ��ָ���������Ԥ���ʲ�����Ӧ��Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ��ǰ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRelPlanProcessInfo(Integer prid)
			throws BLException {
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ������ʼ===============");
		// ��ȡ��������Ϊ"ר��Ԥ��"�ı���ֵ
		List<ProcessInfoEntityInfo> planList = flowSearchBL
				.searchProcessEntityItem(prid, IGDRMCONSTANTS.EMCPRO_RELPLAN);
		// ��ȡ��������Ϊ"Ӧ������"�ı���ֵ
		List<ProcessInfoEntityInfo> sceneList = flowSearchBL
				.searchProcessEntityItem(prid, IGDRMCONSTANTS.SCENE_ITEM_NAME);
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		if (planList != null && planList.size() > 0) {
			Integer planeiid = planList.get(0).getEiid();
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(planeiid);
			Map<String, String> mapInMap = new LinkedHashMap<String, String>();

			mapInMap.put("name", "Ԥ������");
			mapInMap.put("content", soc0118Info.getEiname());
			list.add(mapInMap);
		}
		if (sceneList != null && sceneList.size() > 0) {
			Integer sceneeiid = sceneList.get(0).getEiid();
			SOC0118Info soc0118Info = soc0118BL
					.searchEntityItemByKey(sceneeiid);

			Map<String, String> mapInMap = new LinkedHashMap<String, String>();
			mapInMap.put("name", "��������");
			mapInMap.put("content", soc0118Info.getEiname());
			list.add(mapInMap);
		}
		map.put("planList", list);
		map.put("type", "6");
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ��������===============");
		return map;
	}

	/**
	 * ��ȡ��ǰӦ��Ӧ�������������Ԥ���ʲ�����Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ��������ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRelPlanProcessInfoForScene(Integer prid)
			throws BLException {
		log.debug("===============��������ID��ȡӦ���������������Ϣ������ʼ===============");
		// ָ������prid
		Integer ecprid = 0;
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		SigninSearchCondImpl sccond = new SigninSearchCondImpl();
		sccond.setSceneprid(prid);
		List<SigninInfo> scList = signinBL.searchSignin(sccond);
		if (scList != null && scList.size() > 0) {
			// �õ�ָ������prid
			ecprid = scList.get(0).getEcprid();
		}
		if (ecprid > 0) {

			// ��ȡ��������Ϊ"ר��Ԥ��"�ı���ֵ
			List<ProcessInfoEntityInfo> planList = flowSearchBL
					.searchProcessEntityItem(ecprid,
							IGDRMCONSTANTS.EMCPRO_RELPLAN);
			if (planList != null && planList.size() > 0) {
				Integer planeiid = planList.get(0).getEiid();
				SOC0118Info soc0118Info = soc0118BL
						.searchEntityItemByKey(planeiid);
				Map<String, String> mapInMap = new LinkedHashMap<String, String>();

				mapInMap.put("name", "ר��Ԥ��");
				mapInMap.put("content", soc0118Info.getEiname());
				list.add(mapInMap);
			}
		}
		map.put("planList", list);
		log.debug("===============��������ID��ȡӦ��ָ�����������Ϣ��������===============");
		return map;
	}

	/**
	 * ��������ID��ȡ��ǰ����ʱ��
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static String getUsedTime(Integer prid) throws BLException {
		String useTime = "00:00:00";
		// ��ȡ��ʼʱ��
		String initTime = "";
		String minOpenTime = "";
		// ����prid��ȡ����Ӧ��ָ��������Ӧ��Log��־��Ϣ
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				if (IGDRMCONSTANTS.PROCESS_START_STATUS.equals(psiInfo
						.getPsdcode())) {
					if (StringUtils.isEmpty(minOpenTime)) {
						minOpenTime = psiInfo.getOpentime();// ������ʱ�伴Ϊ�¼�����ʱ��
					} else {
						if (minOpenTime.compareTo(psiInfo.getOpentime()) > 0) {// ���������ڴ�״̬��С����ʼʱ��
							minOpenTime = psiInfo.getOpentime();// ���ǵ���������Ҫ�Խ���"������"״̬��С��ֵ��Ϊ���̷���ʱ��
						}
					}
				}
			}
		}

		// �������̳�ʼʱ��
		initTime = minOpenTime;
		ProcessRecordInfo prInfo = flowSearchBL.searchProcessInfo(prid, null)
				.get(0);

		if ("C".equals(prInfo.getPrstatus())
				|| "#".equals(prInfo.getPrstatus())) {
			useTime = getTimeDifference(initTime, prInfo.getPrclosetime());
		} else {
			useTime = getTimeDifference(initTime, "");
		}
		/** �ڻ�ȡ����ʱʱ���������������ʱ����Ϣ������ */
		// JSON������ϢMap����
		/** ��ǰϵͳʱ�� */
		Map<String, Object> currMap = new HashMap<String, Object>();
		currMap.put("type", IGDRMCONSTANTS.DB_TYPE_REPUSH_SYSMTIME);
		currMap.put("data", getCurrentDateTime());
		currMap.put("target", prid + "");
		/** ϵͳ����ʱ */
		Map<String, Object> usedMap = new HashMap<String, Object>();
		usedMap.put("type", IGDRMCONSTANTS.DB_TYPE_REPUSH_USEDTIME);
		usedMap.put("data", useTime);
		usedMap.put("target", prid + "");

		// ��ǰϵͳʱ������
		// messagePushBL.pushMsgForMap(currMap);
		// // flexMessagePushBL.pushMessage(prid, message)
		// //��ǰ����ʱ����
		// messagePushBL.pushMsgForMap(usedMap);

		return useTime;
	}

	/**
	 * ��ȡӦ������������־��Ϣ (���ݽڵ����,����)--��ʼ��ʱ����
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
		// ���ݽڵ�����װ
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
	 * ���ݵ�ǰ����ID��ȡ����״̬�Ľ���ʱ��
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 * @description (1)searchProcessStatusLog��ֻ����ԾǨ���ĺ����ڴ����еĽڵ�
	 *              (2)��Ҫ���ǳ���24Сʱ��������´��ʱֻ�Ƚ�ʱ����������
	 */
	private static Map<String, String> getInitTimeMap(Integer prid)
			throws BLException {
		// ��ÿ�����̽ڵ�״̬��ʱ����м�¼Ȼ��Ƚ��������ֳ��ֿ��쵼�µ�ֻ�Ƚ�ʱ�����ֵ�����
		Map<String, String> initDateTimeMap = getInitMap(prid);
		Map<String, String> initTimeMap = getInitMap(prid);
		// ��ȡ���̴���״̬��־û��ԾǨ�Ľڵ㲻��ʾ
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				// �����ڴ�����½���˽ڵ�ʱ������ʱ�����Ԥ�õ�����ʱ���������Ӧ�Ĳ���
				if (psiInfo.getOpentime().compareTo(
						initDateTimeMap.get(psiInfo.getPsdid())) > 0) {
					initDateTimeMap.put(psiInfo.getPsdid(),
							psiInfo.getOpentime());
					// �˴������Ǵ��״ֻ̬��¼���뵱ǰ�ڵ�״̬��ʱ��
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
	 * ���ݵ�ǰ����ID��ȡ����״̬������ʱ
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 * @description (1)searchProcessStatusLog��ֻ����ԾǨ���ĺ����ڴ����еĽڵ�
	 *              (2)���ڴ����еĻ�ProcessStatusInfo��getClosetime��Ϊ��
	 *              (3)���ǵ���ص����������Ҫ�Դ���ʱ������ۼ�
	 */
	private static Map<String, String> getUsedTimeMap(Integer prid)
			throws BLException {
		Map<String, String> usedTimeMap = getInitMap(prid);
		// ��ȡ���̴���״̬��־û��ԾǨ�Ľڵ㲻��ʾ
		List<ProcessStatusInfo> psiList = flowSearchBL
				.searchProcessStatusLog(prid);
		if (psiList != null && psiList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiList) {
				// ��ǰ�����ж�Ӧ����ʱ����
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
	 * ���ݵ�ǰ����ID��ȡ����״̬�ڵ�ĳ�ʼ��ʱ��Map��ʽ Ϊ��¼��ʼ��ʱ�������ʱ׼���ĸ�������
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	private static Map<String, String> getInitMap(Integer prid)
			throws BLException {
		// ����pdid�ֶ�
		String pdid = "";
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		// ����pdid��ȡӦ��ָ�����������̵�״̬���򼯺�
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
	 * ��ȡHH:mm:ss��ʽ��ʱ���
	 * 
	 * @param initTime
	 *            ����ʱ��(yyyy/MM/dd HH:mm:ss��ʽ)
	 * @param finalTime
	 *            ������ʱ��(yyyy/MM/dd HH:mm:ss��ʽ)��""��ʾ��ǰϵͳ����ʱ����Ϊ����
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
		// ��׼����ʱ���ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// ������ʾʱ���
		String show = "00:00:00";
		try {
			// ��������ʱ��
			Date date = sdf.parse(dateTime);
			// ��ǰϵͳ����ʱ��
			Date nowDate = new Date();
			if (StringUtils.isNotEmpty(finalDateTime)) {
				nowDate = sdf.parse(finalDateTime);
			}

			// ��ǰϵͳ����ʱ�����������ʱ��Ĳ�ֵ
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
			log.debug("===============ת��ʱ�䷽��������ʽ����===============");
			e.printStackTrace();
		}
		return show;
	}

	/**
	 * ���ǵ����̽ڵ�Ĵ��״̬�ᵼ��ʱ��ı仯
	 * 
	 * @param oldTime
	 *            �Ѵ�������ʱ
	 * @param nowTime
	 *            ��ǰ������ʱ
	 * @return
	 */
	private static String getSumForDateTime(String oldTime, String nowTime) {
		if (StringUtils.isEmpty(oldTime)) {
			return nowTime;
		} else {
			// �Ѵ�������ʱʱ����ת��
			String[] old = oldTime.split(":");
			// ��ǰ������ʱʱ����ת��
			String[] now = nowTime.split(":");
			// ���ӽ�λ��ʼΪ0
			int mCarry = 0;
			// Сʱ��λ��ʼΪ0
			int hCarry = 0;
			// ���ۼ�
			int sSum = Integer.parseInt(old[2]) + Integer.parseInt(now[2]);
			// ���ۼ�
			int mSum = Integer.parseInt(old[1]) + Integer.parseInt(now[1]);
			// ʱ�ۼ�
			int hSum = Integer.parseInt(old[0]) + Integer.parseInt(now[0]);
			int s = 0;
			int m = 0;
			int h = 0;
			if (sSum >= 60) {
				// �ʹ���60_�ֽ�λ1
				mCarry = 1;
				s = sSum - 60;
			} else {
				s = sSum;
			}
			if ((mSum + mCarry) >= 60) {
				// �ʹ���60_ʱ��λ1
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
	 * ��ȡ��ǰϵͳʱ��ķ���
	 */
	private static String getCurrentDateTime() {
		String dateTime = "1900/01/01 00:00:00";// Ĭ��ϵͳ��ʼ��ʱ��
		// String dateTime = DateUtils.getCurrentTime();//�˷���ֻ�ܻ�ȡyyyy/MM/dd
		// HH:mm��ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateTime = sdf.format(new Date());
		return dateTime;
	}

	/**
	 * ��Ϣ������ϢMap��ʼ��
	 * 
	 * @return
	 */
	private static Map<String, String> getMessageMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("noticeTime", "");// ��Ϣ����ʱ��
		map.put("noticeContnt", "");// ��Ϣ��������
		map.put("noticeUser", "");// ��Ϣ������
		map.put("noticeId", "");// ��Ϣ����ID
		map.put("noticeType", "");// ��Ϣ��������
		return map;
	}

	/**
	 * ����prid��ȡ��Ӧ����Ϣ������Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getMessageInfo(String prid)
			throws BLException {
		// JSON������ϢMap����
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
	 * ����prid��ȡ�����߲���Ա��λ�������Ϣ(��ʼ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getRestpreDecLayInPlaceList(Integer ecPrid)
			throws BLException {

		log.debug("===============����prid��ȡ��֯�ܹ����㼶��Ա����������ʼ===============");
		// ��������map
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// ���ݾ�����ʽList
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		// ��Ա��λ��Ϣ����
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
			if (map.get("SNAME").equals("Ӧ��ִ�в�")) {
				Map<String, Object> datamap = new HashMap<String, Object>();
				datamap.put("deparment", map.get("SNAME"));
				datamap.put("name", "����");
				datamap.put("green_people", map.get("TOTALCOUNT"));
				if (!StringUtil.isEmpty((String) map.get("INCOUNT"))) {
					datamap.put("red_people", map.get("INCOUNT"));
				} else {
					datamap.put("red_people", "0");
				}
				if(StringUtil.isEmpty(green_peopleName)){
					datamap.put("green_peopleName", "û�в�����");
				}else{
					datamap.put("green_peopleName", green_peopleName);
				}
				if(StringUtil.isEmpty(red_peopleName)){
					datamap.put("red_peopleName", "��δ����ǩ��");
				}else{
					datamap.put("red_peopleName", red_peopleName);
				}
				
				dataList.add(datamap);
			}

		}

		dataMap.put("emergencyList", dataList);
		dataMap.put("type", "4");
		log.debug("===============����prid��ȡ��֯�ܹ����㼶��Ա������������===============");
		return dataMap;
	}

	/**
	 * ��������ID��ȡ��������Ӧ��״̬˳���б�(��ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessStatusListInit(Integer prid)
			throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�״̬��������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		// �����¼�������Map
		Map<String, String> eventUpgrademap = new HashMap<String, String>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			// ��ȡ����pdid
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig333Map = getIG333Info(pdid);
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			// ������������map
			// ���ڵ�������"������"ʱ���Ϊ"�¼��ϱ�"
			if (IGDRMCONSTANTS.PROCESS_START_STATUS_LABEL.equals(ig333Map
					.get(ig224info.getPsdid()))) {
				Map<String, String> mapInList = new LinkedHashMap<String, String>();
				mapInList.put("flowNodeId", ig224info.getPsdid());
				mapInList.put("flowNodeName",
						IGDRMCONSTANTS.EMC_PROCESS_START_STATUS_LABEL);// ״̬����_psdname�ֶ�
				if (StringUtils.isNotEmpty(ig224info.getRslOpenTime()
						.toString())) {
					if (ig224info.getRslOpenTime().toString().split(" ").length > 1) {
						mapInList.put("flowNodeStartTime",
								CommonDefineUtils.DATETIME_SECOND_FORMAT
										.format(ig224info.getRslOpenTime())
										.split(" ")[1].substring(0, 8));
					}
				}
				// ��ǰ�����ж�Ӧ����ʱ����
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
				// flowNodeStatus�ڵ�״̬0��1��2
				if (ig224info.getRslOpenTime() == null
						|| "".equals(ig224info.getRslOpenTime())) {
					mapInList.put("flowNodeStatus", "2");// �ڵ�״̬δ��ʼ�ڵ�
				} else {
					if (ig224info.getRslCloseTime() == null
							|| "".equals(ig224info.getRslCloseTime())) {
						mapInList.put("flowNodeStatus", "1");// �ڵ�״̬1���ڵ�ǰ�ڵ�
					} else {
						mapInList.put("flowNodeStatus", "0");// �ڵ�״̬0�ڵ����ܹ�
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
						ig333Map.get(ig224info1.getPsdid()));// ״̬����_psdname�ֶ�
				if (StringUtils.isNotEmpty(ig224info1.getRslOpenTime()
						.toString())) {
					String date = CommonDefineUtils.DATETIME_SECOND_FORMAT
							.format(ig224info1.getRslOpenTime());
					if (date.split(" ").length > 1) {
						mapInList.put("flowNodeStartTime",
								date.split(" ")[1].substring(0, 8));
					}
				}
				// ��ǰ�����ж�Ӧ����ʱ����
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
				// flowNodeStatus�ڵ�״̬0��1��2
				if (ig224info1.getRslOpenTime() == null
						|| "".equals(ig224info1.getRslOpenTime())) {
					mapInList.put("flowNodeStatus", "2");// �ڵ�״̬δ��ʼ�ڵ�
				} else {
					if (ig224info1.getRslCloseTime() == null
							|| "".equals(ig224info1.getRslCloseTime())) {
						mapInList.put("flowNodeStatus", "1");// �ڵ�״̬1���ڵ�ǰ�ڵ�
						// if (IGDRMCONSTANTS.PROCESS_DRICT_DISPOSE
						// .equals(ig333Map.get(ig224info1.getPsdid()))) {
						// ��ȡӦ����������id
						String sceneprid = flowSearchBL
								.searchPublicProcessInfo(
										prid,
										IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
						mapInList.put("sceneprid", sceneprid);// Ӧ������prid
						// }
					} else {
						mapInList.put("flowNodeStatus", "0");// �ڵ�״̬0�ڵ����ܹ�
						String sceneprid = flowSearchBL
								.searchPublicProcessInfo(
										prid,
										IGDRMCONSTANTS.DIRECT_FROM_NAME_SCENE_PRID);
						mapInList.put("sceneprid", sceneprid);// Ӧ������prid
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
		map.put("data", list);// ����״̬��Ӧ����
		map.put("type", "2");// ����״̬��Ӧ����
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�״̬����������===============");
		return map;
	}

	/**
	 * ����prid��ȡ��Ӧ����־��¼��Ϣ(��ʼ��)ʵʱ����
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessRecordListInit(Integer prid)
			throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�������־��Ϣ������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig33map = getIG333Info(pdid);
		// ����prid��ȡ��ǰ���̵���־����
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setAscs(asc);
		elCond.setElprid_eq(prid.toString());
		elCond.setEllitype_eq("1");
		// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			mapInList.put("noticeId", el.getElid().toString());// ��Ϣ����ID
			mapInList.put("noticeUser", el.getElusername());// ��Ϣ������
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// ��Ϣ����ʱ��
			mapInList.put("noticeType", el.getEllitype());// ��Ϣ��������
			mapInList.put("flowNodeId", el.getElpsdid());// ��Ϣ��������
			mapInList.put("flowNodeName", ig33map.get(el.getElpsdid()));// ��Ϣ��������
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// ��Ϣ��������
			list.add(mapInList);
		}
		// Collections.reverse(list);
		map.put("data", list);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�������־��Ϣ��������===============");
		return map;
	}

	/**
	 * ����pdid��ȡ�ڵ���Ϣ�ͽڵ�����
	 * 
	 * @param pdid
	 *            ���̶���ID
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
				// psdid-psdname��map
				map.put(info.getPsdid(), info.getPsdname());
			}
		}
		// �¼���������ʾ��dashbaord��
		map.remove(IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID);
		// �رսڵ�������һλ
		for (IG333Info info : ig333List) {
			if ("C".equals(info.getPsdcode())) {
				map.put(info.getPsdid(), info.getPsdname());
			}
		}
		return map;
	}

	/**
	 * ����pdid��ȡ�ڵ���Ϣ�ͽڵ�����
	 * 
	 * @param pdid
	 *            ���̶���ID
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
				// psdid-psdname��map
				map.put(info.getPsdid(), info.getPpsdid());
			}
		}
		// �¼���������ʾ��dashbaord��
		map.remove(IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID);
		// �رսڵ�������һλ
		for (IG333Info info : ig333List) {
			if ("C".equals(info.getPsdcode())) {
				map.put(info.getPsdid(), info.getPpsdid());
			}
		}
		return map;
	}

	/**
	 * ����prid��ȡ���̿�ʼʱ��
	 * 
	 * @param prid
	 *            ����ID
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
	 * ����prid��ȡ��������ʱ��
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessUsedTime(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		// ������ڵ�
		ig224cond.setPrstatus("Z");
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		// �ر�
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
	 * ����prid��ȡ����Ӧ����Դ
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getSocMap(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// ��ѯ���������Ķ���ID
		String pidid = socBL.searchFlowPidid(prid);
		List<SOC0118VW> soc0118VWList = new ArrayList<SOC0118VW>();
		// ��ѯ���˳������е�Ӧ����Դ
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
						// ����ѯ������Ӧ����Դ��ģ�ͽ��з���
						map.put(ig560Info.getDfvalue().split("_SOC_")[1],
								new ArrayList<SocUtil>());
					}
				}
				int index = 0;
				//����Ӧ����Դ��Ψһ��
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
					// ��Ӧ����Դ����Ӧ����Դģ�ͷ��ಢ�ҷŵ�map��
					if (list != null && list.size() > 0) {
						resultMap.put(mapKey + index, list);
					}
				}
			}

		}
		// �������͵ĵ����ͣ���Ӧ����Դ��ʾ����
		resultMap.put("type", "22");
		return resultMap;
	}

	/**
	 * ��������ID��ȡ��������Ӧ��״̬(��ָ�������̳�ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessStatusForOBDR(Integer prid)
			throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�������̵�״̬������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			// flowNodeStatus�ڵ�״̬0��1��2
			if (ig224info.getRslOpenTime() == null
					|| "".equals(ig224info.getRslOpenTime())) {
				mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬δ��ʼ�ڵ�
				mapInList.put("state", "2");// �ڵ�״̬0�ڵ����ܹ�
				mapInList.put("ppsdid", ig224info.getPpsdid());
			} else {
				if (ig224info.getRslCloseTime() == null
						|| "".equals(ig224info.getRslCloseTime())) {
					mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬1���ڵ�ǰ�ڵ�
					mapInList.put("state", "1");// �ڵ�״̬0�ڵ����ܹ�
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
					// ���̵�ǰ�����ڵ��psdid��ȡ
					String currentPsdid = "";
					// ����prid��ȡӦ��ָ�����������̵�״̬�ֶ�
					List<ProcessStatusInfo> psiCList = flowSearchBL
							.searchCurrentStatus(prid);
					if (psiCList != null && psiCList.size() > 0) {
						for (ProcessStatusInfo psiInfo : psiCList) {
							// ��ǰ�ڵ�id
							currentPsdid = psiInfo.getPsdid();
						}
					}
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(currentPsdid);
					List<IG222Info> ig222InfoList = ig222BL
							.searchIG222Info(ig222cond);
					Set<String> userSet = new HashSet<String>();
					for (IG222Info ig222Info : ig222InfoList) {
						// ѭ���õ����д����ˣ�ͬʱȥ��
						if (!StringUtil.isEmpty(ig222Info.getUserid())) {
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setUserid(ig222Info.getUserid());
							urcond.setRoleid(ig222Info.getRoleid());
							// ��ǰ�ڵ㴦����
							List<UserRoleInfo> userList = userRoleBL
									.searchUserRoleVW(urcond);
							if (userList != null && userList.size() > 0) {
								// �����Ĵ�����
								userSet.add(userList.get(0).getUsername());
							}
						} else {// if1��else,ָ������ɫ�����
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
					// ȥ�����һ������
					if (peopleName.length() > 0) {
						peopleName = peopleName.substring(0,
								peopleName.length() - 1);
					}
					// ��ǰ�ڵ㴦����
					mapInList.put("peopleName", peopleName);

				} else {
					mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬0�ڵ����ܹ�
					mapInList.put("state", "0");// �ڵ�״̬0�ڵ����ܹ�
					mapInList.put("ppsdid", ig224info.getPpsdid());
				}
			}
			list.add(mapInList);
		}
		map.put("step", list);// ����״̬��Ӧ����
		log.debug("===============����prid��ȡ��ӦӦ���������̵�״̬��������===============");
		return map;
	}

	/**
	 * ����prid��ȡ�ڵ�id�ͽڵ�����
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getIG333InfoForScene(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
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
	 * ��ȡ��ǰ���Ȱٷֱȵķ���
	 * 
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getPercentNum(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> percentmap = new HashMap<String, Object>();
		// ����pdid����
		String pdid = "";
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			// ��ȡ����pdid
			pdid = priList.get(0).getPrpdid();
		}
		// ���̵�ǰ�����ڵ��psdid��ȡ
		String currentPsdid = "";
		// ����prid��ȡӦ��ָ�����������̵�״̬�ֶ�
		List<ProcessStatusInfo> psiCList = flowSearchBL
				.searchCurrentStatus(prid);
		if (psiCList != null && psiCList.size() > 0) {
			for (ProcessStatusInfo psiInfo : psiCList) {
				// ��ǰ�ڵ�id
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
		double per = 60.00 / (size - 2);// 2.һ���ǡ�Ӧ������40%����һ���ǡ��¼�����0%��
		double nowper = 0.0;
		for (IG333Info info : ig333List) {
			// Ӧ������
			if (IGDRMCONSTANTS.PROCESS_DRICT_DISPOSE_PSDID.equals(info
					.getPsdid())) {
				map.put(info.getPsdid(), "" + (nowper + 40.0));
				nowper = nowper + 40.0;
			} else {
				// �����¼�����
				if (!IGDRMCONSTANTS.PROCESS_CASE_UPGRADE_PSDID.equals(info
						.getPsdid())) {
					// �رսڵ�������⴦��
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
	 * ��������ID��ȡ��������Ӧ��״̬(��ָ�������̳�ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ������ʵ��ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessStatusForOBDR(Integer pgrid)
			throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�������̵�״̬������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		// ����
		List<Object> list = new LinkedList<Object>();
		// ͨ��������prid��ѯ�����鷢�������
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
		log.debug("===============����prid��ȡ��ӦӦ���������̵�״̬��������===============");
		return map;
	}

	/**
	 * Ӧ������-��������ID��ȡ��������Ӧ��״̬(��ָ�������̳�ʼ��ʱʹ��)
	 * 
	 * @param prid
	 *            ������ʵ��ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getPStatusForOBDR(Integer prid,
			String pdid) throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�������̵�״̬������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		IG224SearchCondImpl ig224cond = new IG224SearchCondImpl();
		ig224cond.setPrid(prid);
		List<IG224Info> ig224List = ig224BL
				.findByCondOrderByRslopentime(ig224cond);
		for (IG224Info ig224info : ig224List) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			// flowNodeStatus�ڵ�״̬0��1��2
			if (ig224info.getRslOpenTime() == null
					|| "".equals(ig224info.getRslOpenTime())) {
				mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬δ��ʼ�ڵ�
				mapInList.put("state", "2");// �ڵ�״̬0�ڵ����ܹ�
			} else {
				if (ig224info.getRslCloseTime() == null
						|| "".equals(ig224info.getRslCloseTime())) {
					mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬1���ڵ�ǰ�ڵ�
					mapInList.put("state", "1");// �ڵ�״̬0�ڵ����ܹ�
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
					// ���̵�ǰ�����ڵ��psdid��ȡ
					String currentPsdid = "";
					// ����prid��ȡӦ��ָ�����������̵�״̬�ֶ�
					List<ProcessStatusInfo> psiCList = flowSearchBL
							.searchCurrentStatus(prid);
					if (psiCList != null && psiCList.size() > 0) {
						for (ProcessStatusInfo psiInfo : psiCList) {
							// ��ǰ�ڵ�id
							currentPsdid = psiInfo.getPsdid();
						}
					}
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(currentPsdid);
					List<IG222Info> ig222InfoList = ig222BL
							.searchIG222Info(ig222cond);
					Set<String> userSet = new HashSet<String>();
					for (IG222Info ig222Info : ig222InfoList) {
						// ѭ���õ����д����ˣ�ͬʱȥ��
						if (!StringUtil.isEmpty(ig222Info.getUserid())) {
							UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
							urcond.setUserid(ig222Info.getUserid());
							urcond.setRoleid(ig222Info.getRoleid());
							// ��ǰ�ڵ㴦����
							List<UserRoleInfo> userList = userRoleBL
									.searchUserRoleVW(urcond);
							if (userList != null && userList.size() > 0) {
								// �����Ĵ�����
								userSet.add(userList.get(0).getUsername());
							}
						} else {// if1��else,ָ������ɫ�����
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
					// ȥ�����һ������
					if (peopleName.length() > 0) {
						peopleName = peopleName.substring(0,
								peopleName.length() - 1);
					}
					// ��ǰ�ڵ㴦����
					mapInList.put("peopleName", peopleName);

				} else {
					mapInList.put("id", ig224info.getPsdid());// �ڵ�״̬0�ڵ����ܹ�
					mapInList.put("state", "0");// �ڵ�״̬0�ڵ����ܹ�
				}
			}
			list.add(mapInList);
		}
		map.put("steplist", list);// ����״̬��Ӧ����
		map.put("pdid", pdid);// ����״̬��Ӧ����
		log.debug("===============����prid��ȡ��ӦӦ���������̵�״̬��������===============");
		return map;
	}

	/**
	 * ����Ӧ��ָ�ӹ����ĳ������� 0����ϳ��� 1����һ����
	 * 
	 * @param prid
	 *            ����ID
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
	 * ����pgrid��ȡ����-��ʼʱ�䣨�������ͣ�
	 * 
	 * @param pgrid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessStartTime(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// ������pgrid
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
		// ȡ����һ�������鷢������̵ķ���ڵ�Ŀ�ʼʱ����Ϊ�����鷢��ʱ��
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
	 * ����pgrid��ȡ���� - ����ʱ�䣨�������ͣ�
	 * 
	 * @param pgrid
	 *            ��ϳ�������ID
	 * @return Map<String, Object> map ����MAP
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessUsedTime(Integer pgrid)
			throws BLException {
		// ����MAP
		Map<String, Object> map = new HashMap<String, Object>();
		// 1������ʱ 0����ʼʱ��
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
			log.debug("===============��ȡ��ϳ�����ʼʱ��ʧ��===============");
			map.put("emsg", "��ȡ��ϳ�����ʼʱ��ʧ��!");
		}
		// Ĭ����ֹʱ��Ϊ����ʱ��
		Date nowDate = new Date();
		String endTime = CommonDefineUtils.DATETIME_SECOND_FORMAT
				.format(nowDate);
		// ������pgrid
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
				// �ر�
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
		// ȫ���������̶��Ѿ��ǹر�״̬
		if (isAllClose) {
			// ȡ���Ĺر�ʱ����Ϊ��ֹʱ��
			endTime = CommonDefineUtils.DATETIME_SECOND_FORMAT
					.format(closeTime);
		}
		// ����ʱ��
		String useTime = getTimeDifference(startTime, endTime);
		map.put("time", useTime);
		return map;
	}

	/**
	 * ����prid��ȡ��Ӧ����Ϣ������Ϣ(��ʼ��)-��ϳ���
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupMessageInfo(Integer pgrid)
			throws BLException {
		// JSON������ϢMap����
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		// ������pgrid
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPgrid(pgrid);
		List<IG484Info> ig484Lst = ig484BL.searchIG484(ig484cond);
		if (null != ig484Lst && ig484Lst.size() > 0) {
			for (IG484Info info : ig484Lst) {
				Integer prid = info.getPrid();
				EmergencyLogSearchCondImpl elcond = new EmergencyLogSearchCondImpl();
				elcond.setElprid_eq(prid.toString());
				// ��Ϣ���ͣ�1��ʵʱ׷���� 2��������Ϣ
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
		// �����������������̵���Ϣ
		dataMap.put("mscontentList", listMap);
		dataMap.put("type", "3");
		return dataMap;
	}

	/**
	 * ����pgrid��ȡ��Ӧ����־��¼��Ϣ(��ʼ��)ʵʱ����-��
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessRecordListInit(
			Integer pgrid) throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�������־��Ϣ������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		// ������pgrid
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
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�������־��Ϣ��������===============");
		return map;
	}

	/**
	 * ����prid��ȡ��Ӧ����־��¼��Ϣ(��ʼ��)ʵʱ����-��������
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getProcessRecordListInitByPrid(
			Integer prid) throws BLException {
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵�������־��Ϣ������ʼ===============");
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
		List<ProcessRecordInfo> priList = flowSearchBL.searchProcessInfo(prid,
				null);
		if (priList != null && priList.size() > 0) {
			pdid = priList.get(0).getPrpdid();
		}
		Map<String, String> ig33map = getIG333Info(pdid);

		Map<String, String> ig33PsdidMap = getIG333PsdidInfo(pdid);
		// ����prid��ȡ��ǰ���̵���־����
		EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
		String[] asc = { "elid", "ellidtime" };
		elCond.setAscs(asc);
		elCond.setElprid_eq(prid.toString());
		elCond.setEllitype_eq("1");
		// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
		List<EmergencyLogInfo> elList = emergencyLogBL
				.searchEmergencyLogByCond(elCond);
		for (EmergencyLogInfo el : elList) {
			Map<String, String> mapInList = new LinkedHashMap<String, String>();
			mapInList.put("noticeId", el.getElid().toString());// ��Ϣ����ID
			mapInList.put("noticeUser", el.getElusername());// ��Ϣ������
			mapInList.put("noticeTime", el.getEllidtime().split(" ")[1]);// ��Ϣ����ʱ��
			mapInList.put("noticeType", el.getEllitype());// ��Ϣ��������
			mapInList.put("flowNodeId", el.getElpsdid());// ��Ϣ�����ڵ�ID
			// mapInList.put("ppsdid",
			// ig33PsdidMap.get(el.getElpsdid()));//��Ϣ�����ڵ�ID
			mapInList.put("flowNodeName", ig33map.get(el.getElpsdid()));// ��Ϣ��������
			mapInList.put(
					"noticeContnt",
					el.getElliinfo().replaceAll("\r\n", " ")
							.replaceAll("\n", " ").trim());// ��Ϣ��������
			// �����ǰ�ڵ㲻���ӽڵ�
			if (StringUtils.isBlank(ig33PsdidMap.get(el.getElpsdid()))) {
				list.add(mapInList);
			}
		}
		map.put("data", list);
		map.put("type", IGDRMCONSTANTS.DB_TYPE_NOTICE);
		log.debug("===============����prid��ȡ��ӦӦ��ָ�����̵ĵ�������־��Ϣ��������===============");
		return map;
	}

	/**
	 * ����pgrid��ȡ�ڵ�id�ͽڵ�����
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupIG333InfoForScene(Integer pgrid)
			throws BLException {
		// JSON������ϢMap����
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		// ������pgrid
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
	 * ����prid��ȡ�ڵ�id�ͽڵ�����
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupIG333InfoForSceneByPrid(
			Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ����pdid����
		String pdid = "";
		// ����prid��ȡӦ��ָ�����������̵���Ҫ��Ϣ
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
		// ���ڵ�idMAP
		Map<String, String> ig33PsdidMap = getIG333PsdidInfo(pdid);
		for (IG224Info info : ig224Arr) {
			Map<String, String> datamap = new LinkedHashMap<String, String>();
			datamap.put("flowNodeId", info.getPsdid());
			datamap.put("flowNodeName", ig33Map.get(info.getPsdid()));
			// ���õ�ǰ�ڵ�״̬��1������ִ�� 0����ִ��
			String state = "0";
			if (null == info.getRslCloseTime()
					|| "".equals(info.getRslCloseTime().toString())) {
				state = "1";
			}
			datamap.put("state", state);
			// �����ǰ�ڵ㲻���ӽڵ�
			if (StringUtils.isBlank(ig33PsdidMap.get(info.getPsdid()))) {
				list.add(datamap);
			}
		}
		Collections.reverse(list);
		map.put("data", list);
		return map;
	}

	/**
	 * ����prid��ȡ�ڵ�id�ͽڵ�����TAB
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getGroupProcessList(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		// ������pgrid
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
	 * ����prid��ȡ�ڵ�id�ͽڵ�����TAB
	 * 
	 * @param prid
	 *            ����ID
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getTerminateMsgFunc(Integer pgrid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// ������pgrid
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
			// ����prid��ȡ��ǰ���̵���־����
			EmergencyLogSearchCondImpl elCond = new EmergencyLogSearchCondImpl();
			String[] desc = { "elid", "ellidtime" };
			elCond.setDesc(desc);// ��ʱ�䵹��
			elCond.setPrid_in(prid_in);
			// ��ȡ������ʱ��˳�����е����з�����־��Ϣ�������ܱ�֤ҳ����ʾ��־ʱ���ϲ������µ�ʱ�䷢����
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
	 * ��ѯӦ�������������õ����ʱ��
	 * 
	 * @param prid
	 *            ����prid
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
			//��ȡ���̵Ŀ�ʼʱ��
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
	 * ��ȡ���̻�����Ϣ
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getBaseMessage(Integer prid)
			throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��ѯ��������Ӧ��ָ������
		EmergencyRelationSearchCondImpl erCond = new EmergencyRelationSearchCondImpl();
		erCond.setCldprid(prid);
		List<EmergencyRelationInfo> searchEmergencyRelationInfo = emergencyRelationBL
				.searchEmergencyRelationInfo(erCond, 0, 0);
		// ��ѯ599��Ӧ��ָ�����̵�Ӧ��Ԥ��PIID
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(searchEmergencyRelationInfo.get(0).getParprid());
		ig599Cond.setPivarlabel("ר��Ԥ��");
		List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		// ��ѯӦ��Ԥ���ʲ�����
		IG731SearchCondImpl ig731Cond = new IG731SearchCondImpl();
		ig731Cond.setPrid(searchEmergencyRelationInfo.get(0).getParprid());
		ig731Cond.setPiid(ig599List.get(0).getPiid());
		List<IG731Info> ig731List = ig731BL.searchIG731Info(ig731Cond);
		SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(ig731List
				.get(0).getEiid());
		// Ԥ������
		String planName = soc0118Info.getEiname();
		// ��������
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		IG380Info ig380Info = ig380BL.searchIG380InfoByKey(ig500Info
				.getPrpdid());
		String senceName = ig380Info.getPdname();
		// ��ǰ�ڵ�
		List<Map<String, Object>> currentNodes = currentNodeBL
				.getCurrentNodes(prid);
		// ��ѯ�����˲��洢
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
	 * ��ȡ����ͼ
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getFlow(Integer prid) throws BLException {
		//��������ʱ��
		String[] flowUseTime = getProcessUsedTime(prid).get("time").toString().split(":");
		//ת�ɷ�����
		//����Ĭ�Ͻ�һλ
		Integer flowUseTimeLengh = Integer.parseInt(flowUseTime[0])*60+Integer.parseInt(flowUseTime[1])+ 1;
		// ��ǰ�ڵ�
		List<Map<String, Object>> currentNodes = currentNodeBL.getCurrentNodes(prid);
		// ��¼��ǰ�ڵ�ƴװ��Map
		Map<String, String> curNodesPdidMap = new HashMap<String, String>();
		List<Object> stepList = new ArrayList<Object>();
		for (Map<String, Object> currentNodeMap : currentNodes) {
			curNodesPdidMap.put(currentNodeMap.get("psdid").toString(), currentNodeMap.get("psdid").toString());
		}
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		// �Ը��ڵ���������
		ComputingTime computingTime = new ComputingTime();
		
		Map<String, String> nodeMap = computingTime.getOrderStep(ig500Info.getPrpdid(), "null");
		Map<String, IG333Info> sortNodeMap = new HashMap<String, IG333Info>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//����Ԥ�����ʱ��
		String maxTime = computingTime.getMaxTime(prid.toString());
		//�ж�����ʱ���Ƿ��������Ԥ�����ʱ��
		if(flowUseTimeLengh>Integer.parseInt(maxTime)){
			maxTime = ""+(flowUseTimeLengh+Integer.parseInt(maxTime));
		}
		// ���̵Ŀ�ʼʱ��
		Date flowStartTime = new Date();
		// ��������֮���Map�����д洢����
		if (nodeMap != null && nodeMap.size() > 0) {
			for (String key : nodeMap.keySet()) {
				// �жϲ��ǹرսڵ�
				if (!key.equals(ig500Info.getPrpdid() + "002")&& !key.equals(ig500Info.getPrpdid() + "001")) {
					sortNodeMap.put(key, ig333BL.searchIG333InfoByKey(key));
				} else if (key.equals(ig500Info.getPrpdid() + "001")) {
					// ��ȡ��ʼ�ڵ��ʱ��
					flowStartTime = (Date) currentNodeBL
							.searchAllNodes(prid, key).get(0)
							.get("expectstarttime");
				}
			}
		}
		// ����ʱ��
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		int sortNumber = 0;
		if (nodeMap != null && nodeMap.size() > 0) {
			//��ѯ������Ӧ��ָ������
			IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
			ig599Cond.setPivarvalue(prid.toString());
			ig599Cond.setPivarname("����prid");
			List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
			String emPrid = "";
			if(ig599List!=null && ig599List.size()>0){
				emPrid =  ig599List.get(0).getPrid().toString();	
			}else{
				ig599Cond.setPivarname("�����������prid");	
				ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
				emPrid = ig599List.get(0).getPrid().toString();	
			}
			
			/*
			 * Ӳ����Ϊ�����ÿһ�ж�ֻ����һ���ڵ�Ĳ�������Ϣ����ô�кźͽڵ�ID�������Ψһ��ֻ����ô�������ݷ�Ϊ���¼���
			 * 1����������ʽ����ֵ��ÿһ�У���ͬһ�ڵ���Ϣ����һ��
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
					//��ɫ_role_�û�
        			String[] roleusers = us.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]��ɫid#��ɫname , [1]�û�id#�û�name_user_�û�id#�û�name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null && roleAnduser.length > 1){
        						//�û�id#�û�name
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
					// �ڵ����
					flowNode.put("sortNumber", "" + sortNumber);
					flowNode.put("psdid", key);
					// �ڵ��Ԥ�ƿ�ʼʱ���ʶ
					flowNode.put("expectStartSign", nodeMap.get(key));
					// �ڵ��Ԥ�ƿ�ʼʱ��
					flowNode.put("expectStartTime",computeExpectStartTime(flowStartTime,nodeMap.get(key)));
					// �ڵ�Ԥ��ʹ��ʱ��
					flowNode.put("expectUseTime", getExpectUseTime(ig333Info.getBysequence().replaceAll(" ", "")));
					List<Map<String, Object>> nodeList = currentNodeBL.searchAllNodes(prid, key);
					flowNode.put("psdname", ig333Info.getPsdname());
					if (nodeList != null && nodeList.size() > 0) {
						Map<String, Object> nowNode = nodeList.get(0);
						if (nowNode.get("factstoptime") == null) {
							// �ڵ�ʵ��ʹ��ʱ��
							flowNode.put("factUseTime", "");
							// �ڵ�����ִ������
							flowNode.put("stepType", "executing");
							// �ڵ�ʵ��ִ��ʱ���ʶ
							flowNode.put("factStartSign", "");
							flowNode.put("factStartTime",format.format((Date) nowNode.get("factstarttime")));
						} else {
							// �ڵ�ʵ��ִ��ʱ���ʶ
							String factUseTime = getFactUseTime(computeFactUseTime((Date) nowNode.get("factstarttime"),(Date) nowNode.get("factstoptime")));
							
							flowNode.put("factUseTime",factUseTime);
							// �ڵ�ʵ��ִ��ʱ���ʶ
							flowNode.put("factStartSign",Double.parseDouble(computeFactUseTime(flowStartTime,(Date) nowNode.get("factstarttime")))/60);
							// �ڵ�������ɽڵ�
							flowNode.put("stepType", "finish");
							
							flowNode.put("factStartTime",format.format((Date) nowNode.get("factstarttime")));
							flowNode.put("factOverTime",format.format((Date) nowNode.get("factstoptime")));
						}
					} else {
						// �ڵ�ʵ��ʹ��ʱ��
						flowNode.put("factUseTime", "");
						// �ڵ�����δִ������
						flowNode.put("stepType", "will");
						// �ڵ�ʵ��ִ��ʱ���ʶ
						flowNode.put("factStartSign", "");
						flowNode.put("factStartTime", "");
					}
					// ��ѯ�����˲��洢
					
					Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
					//��ѯ��ǰ�ڵ��Ѵ���������
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
						peopleStr.append(userMap.get(peopleKey).getUsername()+ "��");
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
					// ��ѯ560�е����ݲ����ӵ�flowDetail��
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
					
					//Ӧ������
					if(!ig333Info.getPsddesc().isEmpty()){
						flowNode.put("nodeStep", ig333Info.getPsddesc());
					}else{
						flowNode.put("nodeStep", "");
					}
					//�ڵ���־
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
							//����ʱ��
							stepMessage.put("dealTime", emergencyLogInfo.getEllidtime().split(" ")[1]);
							//������
							stepMessage.put("dealPeople", emergencyLogInfo.getElusername());
							//������Ϣ
							stepMessage.put("logMsg", emergencyLogInfo.getElliinfo() == null ? "" : emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
							stepMessage.put("operate", emergencyLogInfo.getOperate());
							stepLogMsgList.add(stepMessage);
						}
						flowNode.put("stepMessageList", stepLogMsgList);
					}else{
						flowNode.put("stepMessageList", "");
					}
					// ����¸��ڵ��ǹرսڵ�������Ϊ��
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
	 * ��ȡ���̵Ĵ�����־
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getLogMessage(Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> messageList = new ArrayList<Map<String,Object>>();
		//��ѯ������־
		EmergencyLogSearchCondImpl elsCond = new EmergencyLogSearchCondImpl();
		elsCond.setElprid_eq(prid.toString());
		List<EmergencyLogInfo> emergencyLogList = emergencyLogBL.searchEmergencyLogByCond(elsCond);
		if(emergencyLogList!=null &&emergencyLogList.size()>0){
			for(EmergencyLogInfo emergencyLogInfo:emergencyLogList){
				Map<String, Object> messageMap = new HashMap<String, Object>();
				//����ʱ��
				messageMap.put("time", emergencyLogInfo.getEllidtime().split(" ")[1]);
				//������־
				messageMap.put("logMsg", emergencyLogInfo.getElliinfo().replaceAll("<br>", ""));
				//������
				messageMap.put("peopleHandle", emergencyLogInfo.getElusername());
				//�ڵ�����
				messageMap.put("nodeName", emergencyLogInfo.getElpsdname());
				
				//Ԥ��ʱ��
				Map<String, Object> nowNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				String expectUseTime =  nowNode.get("expectusetime").toString().replaceAll(" ", "");
				//��ȡ�ڵ�
				Map<String, Object> currentNode = currentNodeBL.searchAllNodes(prid, emergencyLogInfo.getElpsdid()).get(0);
				Date factStartTime = (Date)currentNode.get("factstarttime");
				Date factStopTime = new Date();
				if(currentNode.get("factstoptime")!=null){
					factStopTime = (Date)currentNode.get("factstoptime");
				}else{
					String ellidTime = emergencyLogInfo.getEllidtime();
					factStopTime = new Date(ellidTime);
				}
				//ʵ�ʲ�����ʱ��
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
	 * ��������Ԥ�ڿ�ʼʱ��
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
	 * ����ʵ��ʹ��ʱ��
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
	 * �������̵�ʹ��ʱ��
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
	 * �������̵�ʹ��ʱ��
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
	 * ��ѯ���̵Ĺر�ʱ��
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	public static Map<String, Object> getOverTime(Integer prid) throws BLException {
		Map<String, Object> map = new HashMap<String, Object>();
		//��ѯ���رսڵ�Ĺر�ʱ��
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		cond.setPrstatus("C");
		IG224Info ig224Info = ig224BL.searchIG224Info(cond, 0, 0).get(0);
		// ����ʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String closeTime = format.format(ig224Info.getRslCloseTime());
		map.put("time", closeTime);
		map.put("sign", "1");
		return map;
	}
	
	public static Map<String,Object> getEmergencyFlow(Integer prid) throws BLException{
		Map<String, Object> map = new HashMap<String, Object>();
		//��ѯ���еĽڵ�
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		List<IG224Info> ig224InfoList = ig224BL.searchIG224Info(cond, 0, 0);
		List<Map<String,Object>> flowList = new ArrayList<Map<String,Object>>();
		Date startTime = new Date();
		Date overTime =  new Date();
		
		if(ig224InfoList!=null && ig224InfoList.size()>0){
			//��¼��ʼʱ��͹ر�ʱ��
			for(IG224Info ig224Info:ig224InfoList){
				if(ig224Info.getPrstatus()!=null && ig224Info.getPrstatus().equals("C") ){
					overTime = ig224Info.getRslCloseTime();
				}else if(ig224Info.getPsdid().substring(ig224Info.getPsdid().length()-3, ig224Info.getPsdid().length()).equals("003") ){
					//��ȡ�ϱ��ڵ㵱��ʼ�ڵ�
					startTime  = ig224Info.getRslOpenTime();
				}
			}
			//��ѯ�����еĽڵ�����ݲ��Ҹ�ֵ
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
	 * ͨ����������ѯҵ��ϵͳ��eiid ��������,ͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬(Ӧ��ָ�Ӻ���������)
	 * @param prid ����prid
	 * @param pivarname ����ҵ��ϵͳ��������
	 * @param state ҵ��ϵͳ��״̬(0:����,1:�ƻ���,2:������,3:��������,4:����ƻ���,5:�����,6:������,7:Ӧ����)
	 * @param desc ��ϸ����
	 * @throws BLException
	 */
	public static void changeSystemState(Integer prid,String pivarname,String state,String desc) throws BLException{
		log.debug("===============��ѯҵ��ϵͳ������ʼ===============");
		log.debug("===============����prid="+prid+"==============");
		//��ȡ��ǰ��ʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		String startTime = format.format(nowDate);
		//ͨ����������ѯҵ��ϵͳ�ʲ���eiid
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
		log.debug("===============��ѯҵ��ϵͳ��������===============");
		//����url
		if(ig731InfoList!=null && ig731InfoList.size()>0){
			//��ȡ�л�������ť��url
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
				
				// ʵ�ֽ����� �Ĳ�����װ��װ��HttpEntity�С�
				UrlEncodedFormEntity entity;
				try {
					entity = new UrlEncodedFormEntity(list, "utf-8");
					// ʹ��HttpPost����ʽ
					HttpPost httpPost = new HttpPost(changeSystemStateUrl);
					// �������������Form�С�
					httpPost.setEntity(entity);
					// ʵ����һ��Ĭ�ϵ�Http�ͻ���
					DefaultHttpClient client = new DefaultHttpClient(params);
					// ִ�����󣬲������Ӧ����
					log.debug("========================����url��ʼ===========================");
					log.debug("========================����url��ַ��"+changeSystemStateUrl+".do?systemid="+ig731Info.getEiid().toString()+"&state="+state+"&starttime="+startTime+"===========================");
					HttpResponse httpResponse = client.execute(httpPost);
					String result1 = EntityUtils.toString(httpResponse.getEntity());
					log.debug("========================����url���ؽ����+"+result1+"===========================");
					log.debug("========================����url����===========================");
				} catch (Exception e) {
					log.debug("========================����urlʧ��ԭ��"+e.getMessage()+"===========================");
					log.debug("========================����urlʧ��===========================");
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * ͨ����������ѯҵ��ϵͳ��eiid ��������,ͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬(�������)
	 * @param prid ����prid
	 * @param state ҵ��ϵͳ��״̬(0:����,1:�ƻ���,2:������,3:��������,4:����ƻ���,5:�����,6:������,7:Ӧ����)
	 * @param desc ��ϸ����
	 * @throws BLException
	 */
	public static void changeFlowSystemState(Integer prid,String state,String desc) throws BLException{
		log.debug("===============��ѯҵ��ϵͳ������ʼ===============");
		log.debug("===============����prid="+prid+"==============");
		//��ȡ��ǰ��ʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date nowDate = new Date();
		String startTime = format.format(nowDate);
		String[] nameArr = null;
		//ͨ����������ѯҵ��ϵͳ�ʲ���eiid
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(prid);
		ig599Cond.setPivarname("����ƽ̨");
		List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(ig599InfoList!=null && ig599InfoList.size()>0){
			IG599Info ig599Info = ig599InfoList.get(0);
			nameArr = ig599Info.getPivarvalue().split("#");
		}
		//����Ҫ���ĵ��ʲ�����
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
		log.debug("===============��ѯҵ��ϵͳ��������===============");
		//�ж����е��ʲ����ҷ���url
		if(eiidList!=null && eiidList.size()>0){
			//��ȡ�л�������ť��url
			String changeSystemStateUrl = ResourceUtility.getString("CHANGESYSTEMSTATE_URL");
			for(CodeDetailDef codeDetailDef:eiidList){
				//�ж������Ƿ���ȷ
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
					
					// ʵ�ֽ����� �Ĳ�����װ��װ��HttpEntity�С�
					UrlEncodedFormEntity entity;
					try {
						entity = new UrlEncodedFormEntity(list, "utf-8");
						// ʹ��HttpPost����ʽ
						HttpPost httpPost = new HttpPost(changeSystemStateUrl);
						// �������������Form�С�
						httpPost.setEntity(entity);
						// ʵ����һ��Ĭ�ϵ�Http�ͻ���
						log.debug("========================����url��ʼ===========================");
						log.debug("========================����url��ַ��"+changeSystemStateUrl+".do?systemid="+codeDetailDef.getCvalue().split("-")[1]+"&state="+state+"&starttime="+startTime+"===========================");
						DefaultHttpClient client = new DefaultHttpClient(params);
						// ִ�����󣬲������Ӧ����
						HttpResponse httpResponse = client.execute(httpPost);
						String result1 = EntityUtils.toString(httpResponse.getEntity());
						log.debug("========================����url���ؽ����+"+result1+"===========================");
						log.debug("========================����url����===========================");
					} catch (Exception e) {
						log.debug("========================����urlʧ��ԭ��"+e.getMessage()+"===========================");
						log.debug("========================����urlʧ��===========================");
						e.printStackTrace();
					}
				}else{
					log.debug("����url�������ݣ�"+codeDetailDef.getCvalue());
				}
			}
		}
	}
	/**
	 * ƴװ��ϸ�����ֶ�
	 * @param workNumStr ������ 
	 * @param prtitle ����
	 * @return ��ϸ�����ֶ�
	 * @throws BLException 
	 */
	public static String getDesc(Integer prid) throws BLException{
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(prid);
		String desc = "["+ig500Info.getPrserialnum()+"]["+ig500Info.getPrtitle()+"]";
		return desc;
	}
}