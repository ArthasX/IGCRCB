/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.dlk.hq.Plateform;
import main.java.com.dlk.hq.Property;
import main.java.com.dlk.hq.Server;
import main.java.com.dlk.hq.XmlTemplate;
import main.java.com.dlk.hq.XmlTemplateImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.MetricApi;
import org.hyperic.hq.hqapi1.types.Metric;
import org.hyperic.hq.hqapi1.types.MetricsResponse;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourceResponse;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM01BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM05BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM06BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM08BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM09BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM01DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0102Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCondImpl;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;
import com.deliverik.infogovernor.soc.alarm.model.entity.HQServerTB;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.util.FilesUtil;
import com.deliverik.infogovernor.util.HQUtil;

/**
 * ����ָ��ģ�������
 * 
 * @author wangxing
 * 
 */
public class IGALM01BLImpl extends BaseBLImpl implements IGALM01BL {

	static Log log = LogFactory.getLog(IGALM01BLImpl.class);

	/** �ϴ�������Ϣ���� */
	protected FileUploadBL fileUploadBL;

	protected CRM05BL crm05BL;// xml�ϴ���ʷBL

	protected CRM06BL crm06BL;// ��ض������BL

	protected CRM09BL crm09BL;// ����ģ���ϵBL

	protected CRM08BL crm08BL;// ����ģ�����BL

	protected CodeDetailBL codeDetailBL;// ��������BL

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setCrm05BL(CRM05BL crm05BL) {
		this.crm05BL = crm05BL;
	}

	public void setCrm06BL(CRM06BL crm06BL) {
		this.crm06BL = crm06BL;
	}

	public void setCrm09BL(CRM09BL crm09BL) {
		this.crm09BL = crm09BL;
	}

	public void setCrm08BL(CRM08BL crm08BL) {
		this.crm08BL = crm08BL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public IGALM01DTO importPerfTemplateAction(IGALM01DTO dto)
			throws BLException {

		log.debug("========�ϴ�ָ��ģ�忪ʼ========");
		// ���̶���SQL�ű������ļ�������·��
		String path = ResourceUtility.getString("PERF_IMPORT_FILE_PATH")
				+ File.separator;
		IGALM0102Form form = dto.getIgalm0102Form();
		String filename = form.getXmlFile().getFileName();
		if (!filename.split("\\.")[1].equals("xml")) {
			log.error("�ļ���" + filename + "����ʽ����ȷ");
			dto.addMessage(new ActionMessage("IGALM0101.E002"));
			return dto;
		}
		if (form.getXmlFile() != null) {
			try {
				this.fileUploadBL.saveFile(form.getXmlFile(), path, filename);
			} catch (Exception e) {
				log.error("XML�ļ���" + filename + "���ϴ�ʧ��", e);
				dto.addMessage(new ActionMessage("IGALM0101.E001"));
				return dto;
			}
		}

		CRM05TB bean = new CRM05TB();
		bean.setFilename(filename);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		bean.setUploadtime(format.format(new Date()));
		bean.setFilepath(path);

		CRM05Info info = this.crm05BL.registCRM05(bean);

		try {
			List<HQServerTB> servers = createHQServer(info, dto);

			if (servers != null && servers.size() != 0) {
				if (crateRaltions(servers)) {// ��������serverĬ����Ӹ�server�����µ����й���
					dto.addMessage(new ActionMessage("IGALM0101.I001"));
				} else {
					dto.addMessage(new ActionMessage("IGALM0101.I002"));
				}
			} else {
				dto.addMessage(new ActionMessage("IGALM0101.E003"));
				this.crm05BL.deleteCRM05(info);// ����serverʧ����ɾ���ϴ���¼
			}

		} catch (Exception e) {
			log.error("�ϴ�ָ��ģ��  >> >>", e);
			dto.addMessage(new ActionMessage("IGALM0101.E003"));
			this.crm05BL.deleteCRM05(info);// ����serverʧ����ɾ���ϴ���¼
		}

		log.debug("========�ϴ�ָ��ģ������========");
		return dto;

	}

	/**
	 * ��������serverĬ����Ӹ�server�����µ����й���
	 * 
	 * @param servers
	 */
	private boolean crateRaltions(List<HQServerTB> servers) {

		/** ÿ����������Щ����(�Ȱ����еĹ������ݴӱ��в����ڴ棬Ȼ������֯����) */
		List<CRM08Info> ruletemps = this.crm08BL.searchCRM08();
		if (ruletemps == null || ruletemps.size() == 0) {
			log.warn("��û�����ù���ģ��");
			return false;
		}
		// kye������ID Value���������µ�����ģ��ID
		Map<String, List<Integer>> tempsMap = new HashMap<String, List<Integer>>();
		List<Integer> tempids = null;
		for (int i = 0; i < ruletemps.size(); i++) {
			CRM08Info info = ruletemps.get(i);
			String key = info.getTypecid();
			if (!tempsMap.containsKey(key)) {
				tempids = new ArrayList<Integer>();
				tempsMap.put(key, tempids);
			}
			tempids = tempsMap.get(key);
			tempids.add(info.getRuletempid());
		}

		/** �����ж���õ����ʹӻ��������в��������֯���� */
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.PERF_MONITOR_TYPE.getCcid());
		List<CodeDetail> typeList = codeDetailBL.searchCodeDetail(cond,
				CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);

		if (typeList == null || typeList.size() == 0) {
			log.warn("��û�����ù������ͻ�������(ccid:"
					+ CodeDefine.PERF_MONITOR_TYPE.getCcid() + ")");
			return false;
		}
		// kye�������� Value������ID
		Map<String, String> typesMap = new HashMap<String, String>();
		for (CodeDetail type : typeList) {
			typesMap.put(type.getCvalue().trim(), type.getCid());
		}

		/** Ϊ����������Ӹ������µ����й���ģ�忪ʼ */
		for (HQServerTB server : servers) {
			if (server.getServerid() != null) {
				String serverid = server.getServerid();
				String serverType = server.getServerType().trim();
				String typecid = typesMap.get(serverType);
				List<Integer> temps = tempsMap.get(typecid);// ��ȡ���������µ�����ģ��
				if (temps == null || temps.size() == 0)
					continue;
				for (int i = 0; i < temps.size(); i++) {
					CRM09TB relation = new CRM09TB();
					relation.setServerid(Integer.parseInt(serverid));
					relation.setRuletempid(temps.get(i));
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");
					relation.setCreatetime(format.format(new Date()));
					relation.setMaxalarmnum(0);
					relation.setMaxalarmtime(0);
					try {
						crm09BL.registCRM09(relation);
					} catch (BLException e) {
						log.error("��ӹ����ϵʱ�����쳣");
						continue;
					}
				}
			}
		}
		return true;
	}

	/**
	 * delete ALM0102 Action
	 */
	public IGALM01DTO deleteALM0102Action(IGALM01DTO dto) throws BLException {

		IGALM0102Form form = dto.getIgalm0102Form();
		String[] deleteIds = form.getDeleteId();
		
		try {

			CodeListUtils codeListUtils = this.getCodeListUtils();
			HQApi hqapi = HQUtil.getHQApi(codeListUtils);
			
			for (String deleteId : deleteIds) {

				CRM06SearchCondImpl crm06cond = new CRM06SearchCondImpl();
				crm06cond.setFileid_eq(deleteId);
				List<CRM06VWInfo> crmo6List = crm06BL.searchCRM06VW(crm06cond,
						0, 0);
				CRM05Info crm05 = crm05BL.searchCRM05ByPK(Integer.parseInt(deleteId));
				
				if (crmo6List != null && crmo6List.size() != 0) {
					
					for (CRM06VWInfo crm06 : crmo6List) {

						CRM09SearchCondImpl crm09cond = new CRM09SearchCondImpl();
						crm09cond.setServerid_eq(String.valueOf(crm06
								.getServerid()));
						List<CRM09Info> crm09List = crm09BL
								.searchCRM09(crm09cond);
						if (crm09List == null || crm09List.size() == 0) {
							continue;
						}
						for (CRM09Info crm09 : crm09List) {
							crm09BL.deleteCRM09(crm09);
						}
						crm06BL.deleteCRM06ByPK(crm06.getServerid());

						// ��ȡhq apiʧ��
						if (hqapi == null) {
							log.error("����hq serverʧ��");
							dto.addMessage(new ActionMessage("IGALM0101.E005"));
							return dto;
						}
						ResourceResponse presource = hqapi.getResourceApi()
								.getPlatformResource(crm06.getHost(), true,
										true);
						List<Resource> serverList = presource.getResource()
								.getResource();

						for (Resource resource : serverList) {
							if (resource.getName().equals(
									crm06.getHqservername())) {
								hqapi.getResourceApi().deleteResource(
										resource.getId());
							}
						}
					}
				} 

				crm05BL.deleteCRM05(crm05);
				FilesUtil.deleteFile(crm05.getFilepath()+crm05.getFilename());
			}

		} catch (Exception e) {
			throw new BLException();
		}
		return dto;
	}

	/**
	 * create HQ Server
	 * 
	 * @param bean
	 */
	private List<HQServerTB> createHQServer(CRM05Info bean, IGALM01DTO dto)
			throws Exception {

		if (bean == null) {
			log.error("CRM05TB have not data");
			return null;
		}
		String plateformName = null;
		XmlTemplate xmlTemplate = null;
		List<HQServerTB> servers = null;

		String createMessage = "FAILURE";

		try {

			xmlTemplate = new XmlTemplateImpl();
			String fileName = bean.getFilepath() + bean.getFilename();
			List<Plateform> plateformList = xmlTemplate
					.getPlateformListByTemplatePath(fileName);

			// ��ȡxml����ʧ��
			if (plateformList == null || plateformList.size() == 0) {
				createMessage = createMessage + bean.getFilename() + " ��û������";
				dto.addMessage(new ActionMessage("IGALM0101.E004"));
				log.error(createMessage);
				return null;
			}

			servers = new ArrayList<HQServerTB>();
			CodeListUtils codeListUtils = this.getCodeListUtils();
			HQApi hqapi = HQUtil.getHQApi(codeListUtils);

			// ��ȡhq apiʧ��
			if (hqapi == null) {
				log.error("����hq serverʧ��");
				dto.addMessage(new ActionMessage("IGALM0101.E005"));
				return null;
			}

			for (Plateform plateform : plateformList) {

				plateformName = plateform.getName();

				// xml���ݲ�����
				if (plateformName == null || "".equals(plateformName)) {
					dto.addMessage(new ActionMessage("IGALM0101.E006"));
					log.warn(">> >> ƽ̨���Ʋ���Ϊ��");
					return null;
				}

				List<Server> serverList = HQUtil.getHQServer(plateform);
				ResourceResponse resourceResponse = getPlatformResourceResponse(
						hqapi, plateformName);

				// ͨ��api��ȡƽ̨�ɹ�
				if ("SUCCESS".equals(resourceResponse.getStatus().toString())) {

					for (Server server : serverList) {

						HQServerTB hqServerTB = this.getHQServerTB(
								plateformName, fileName, server,
								bean.getFileid());
						// ���server���ݳɹ�
						if (hqServerTB != null
								&& "SUCCESS".equals(hqServerTB.getStatus())) {

							hqServerTB = this.createHQServer(hqServerTB, hqapi,
									dto, plateformName, resourceResponse);
							// ����server�ɹ�
							if (hqServerTB != null) {

								servers.add(hqServerTB);
								createMessage = "SUCCESS";
								hqServerTB.setStatus(createMessage);
								hqServerTB.setCreateMessage(createMessage);

							}
						} else {
							dto.addMessage(new ActionMessage("IGALM0101.E008"));
							log.warn(hqServerTB.getStatus());
						}
					}
				} else {
					dto.addMessage(new ActionMessage("IGALM0101.E009"));
					createMessage = createMessage + ", û��" + plateformName
							+ "��ƽ̨";
					log.warn(createMessage);
				}
			}
		} catch (Exception e) {
			log.error("�ϴ�ָ��ģ��  >> >> ����server�쳣", e);
			throw new Exception();
		}

		return servers;
	}

	/**
	 * get HQServer TB
	 * 
	 * @param plateformName
	 * @param fileName
	 * @param server
	 * @param fileId
	 * @return
	 */
	private HQServerTB getHQServerTB(String plateformName, String fileName,
			Server server, int fileId) {

		HQServerTB hqServerTB = new HQServerTB();
		hqServerTB.setPlantformName(plateformName);
		hqServerTB.setServerName(server.getName());
		hqServerTB.setServerType(server.getType());

		List<Property> propertyList = server.getPropertyList().get(0)
				.getProperty();

		for (Property property : propertyList) {

			hqServerTB = HQUtil.splitHQServer(property.getName(),
					property.getValue(), fileName, hqServerTB);
		}
		hqServerTB.setFileId(fileId);
		return hqServerTB;
	}

	/**
	 * create HQ Server
	 * 
	 * @param presource
	 * @param hqServerTB
	 * @param hqapi
	 * @param dto
	 * @param plateformName
	 * @return
	 * @throws Exception
	 */
	private HQServerTB createHQServer(HQServerTB hqServerTB, HQApi hqapi,
			IGALM01DTO dto, String plateformName,
			ResourceResponse resourceResponse) throws Exception {

		boolean hqServerExist = false;
		boolean dbServerExist = false;
		CRM06Info crm06Info = null;
		Resource sResource = null;
		ResourceResponse rResponse = null;

		Resource presource = getPlatformResource(hqapi, hqServerTB,
				resourceResponse);

		List<Resource> serverResourceList = presource.getResource();

		for (Resource serverResource : serverResourceList) {
			if (serverResource.getName().equals(hqServerTB.getServerName())) {
				hqServerExist = true;
				sResource = serverResource;
			}
		}

		CRM06SearchCondImpl cond = new CRM06SearchCondImpl();
		cond.setServerName(hqServerTB.getServerName());
		List<CRM06VWInfo> crmo6List = crm06BL.searchCRM06VW(cond, 0, 0);

		if (crmo6List.size() != 0) {
			dbServerExist = true;
		}

		if (hqServerExist && dbServerExist) {
			dto.addMessage(new ActionMessage("IGALM0101.E007"));
			return null;
		} else if (!hqServerExist && dbServerExist) {

			rResponse = hqapi.getResourceApi().createServer(
					hqServerTB.getResourcePrototype(), presource,
					hqServerTB.getServerName(), hqServerTB.getConfig());
			hqServerTB = openMetric(hqServerTB, hqapi, plateformName);
			// ����crm06
			crm06Info = this.updateCRMO6(hqServerTB, crmo6List);

		} else if (hqServerExist && !dbServerExist) {
			hqServerTB.setHqserverid(sResource.getId());
			hqServerTB.setHqservername(sResource.getName());
			crm06Info = insertCRMO6(hqServerTB);

		} else if (!hqServerExist && !dbServerExist) {

			rResponse = hqapi.getResourceApi().createServer(
					hqServerTB.getResourcePrototype(), presource,
					hqServerTB.getServerName(), hqServerTB.getConfig());
			hqServerTB = openMetric(hqServerTB, hqapi, plateformName);
			crm06Info = insertCRMO6(hqServerTB);
		}

		if (rResponse != null
				&& !"SUCCESS".equals(rResponse.getStatus().toString())
				&& crm06Info != null) {
			crm06BL.deleteCRM06(crm06Info);
			log.warn(hqServerTB.getServerName() + " ����ʧ��");
			dto.addMessage(new ActionMessage("IGALM0101.E008"));
			return null;
		}
		if (crm06Info != null) {
			hqServerTB.setServerid(String.valueOf(crm06Info.getServerid()));
		}

		return hqServerTB;
	}

	/**
	 * open Metric
	 * 
	 * @param hqServerTB
	 * @param hqapi
	 * @throws Exception
	 */
	private HQServerTB openMetric(HQServerTB hqServerTB, HQApi hqapi,
			String plateformName) throws Exception {

		ResourceResponse presource = hqapi.getResourceApi()
				.getPlatformResource(plateformName, true, true);
		List<Resource> serverList = presource.getResource().getResource();

		if (serverList == null || serverList.size() == 0) {
			return hqServerTB;
		}

		for (Resource resource : serverList) {
			List<Metric> metricList = null;
			if (resource.getName().equals(hqServerTB.getServerName())) {

				MetricApi metricApi = hqapi.getMetricApi();
				MetricsResponse response = metricApi
						.getMetrics(resource, false);
				List<Metric> metrics = response.getMetric();
				if (metrics == null || metrics.size() == 0) {
					log.warn(">> >> hq metrics is null, response name ="
							+ hqServerTB.getResourcePrototypeName());
					return hqServerTB;
				}
				metricList = new ArrayList<Metric>();

				for (Metric metric : metrics) {
					metric.setEnabled(true);
					if (hqServerTB.getInterval() != null
							|| HQUtil.isNumber(hqServerTB.getInterval())) {
						metric.setInterval(Long.parseLong(hqServerTB
								.getInterval()));
						metricList.add(metric);
					}
				}
				metricApi.syncMetrics(metricList);
				hqServerTB.setHqserverid(resource.getId());
				hqServerTB.setHqservername(resource.getName());
			}
		}

		return hqServerTB;
	}

	/**
	 * update CRMO6
	 * 
	 * @param hqServerTB
	 * @return
	 * @throws Exception
	 */
	private CRM06Info updateCRMO6(HQServerTB hqServerTB,
			List<CRM06VWInfo> crmo6List) throws Exception {
		CRM06Info crm06Info = null;
		for (CRM06VWInfo crm06vm : crmo6List) {
			CRM06TB crm06 = new CRM06TB();
			crm06.setServerid(crm06vm.getServerid());
			crm06.setFileid(crm06vm.getFileid());
			crm06.setServername(hqServerTB.getServerName());
			crm06.setServertype(hqServerTB.getServerType());
			crm06.setIp(crm06vm.getIp());
			crm06.setStatus(crm06vm.getStatus());
			crm06.setAlarmstatus("1");
			crm06.setHost(hqServerTB.getPlantformName());
			crm06.setHqserverid(hqServerTB.getHqserverid());
			crm06.setHqservername(hqServerTB.getHqservername());
			crm06Info = crm06BL.updateCRM06(crm06);
		}
		return crm06Info;
	}

	/**
	 * insert CRMO6
	 * 
	 * @param hqServerTB
	 * @throws Exception
	 */
	private CRM06Info insertCRMO6(HQServerTB hqServerTB) throws Exception {

		CRM06TB crm06 = new CRM06TB();
		crm06.setFileid(hqServerTB.getFileId());
		crm06.setCreatemessage(hqServerTB.getCreateMessage());
		crm06.setIp(hqServerTB.getServerIp());
		crm06.setStatus(hqServerTB.getStatusNum());
		crm06.setServername(hqServerTB.getServerName());
		crm06.setServertype(hqServerTB.getServerType());
		crm06.setHost(hqServerTB.getPlantformName());
		crm06.setAlarmstatus("1");
		crm06.setHqserverid(hqServerTB.getHqserverid());
		crm06.setHqservername(hqServerTB.getHqservername());

		CRM06Info crm06Info = crm06BL.registCRM06(crm06);
		return crm06Info;
	}

	/**
	 * get Platform Resource Response
	 * 
	 * @param hqapi
	 * @param hqServerTB
	 * @return
	 * @throws Exception
	 */
	private ResourceResponse getPlatformResourceResponse(HQApi hqapi,
			String plantformName) throws Exception {

		ResourceResponse resourceResponse = hqapi.getResourceApi()
				.getPlatformResource(plantformName, true, true);

		return resourceResponse;
	}

	/**
	 * get Platform Resource
	 * 
	 * @param hqapi
	 * @param hqServerTB
	 * @param resourceResponse
	 * @return
	 * @throws Exception
	 */
	private Resource getPlatformResource(HQApi hqapi, HQServerTB hqServerTB,
			ResourceResponse resourceResponse) throws Exception {
		Resource presource = resourceResponse.getResource();
		return presource;
	}

	/**
	 * get CodeList Utils
	 * 
	 * @return
	 * @throws Exception
	 */
	private CodeListUtils getCodeListUtils() throws Exception {
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport
				.getBean("codeListUtils");
		return codeListUtils;
	}

	/*
	 * Server xml �ϴ���ʷ��¼��ѯ
	 */
	public IGALM01DTO searchALM0102Action(IGALM01DTO dto) throws BLException {
		// ��ѯ����
		int totalCount = crm05BL.getSearchCount(dto.getCrm05SearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ����DAO�ӿڲ�ѯ ������־
		List<CRM05Info> crm05InfoList = crm05BL.searchCRM05(
				dto.getCrm05SearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		pDto.setPageDispCount(12);
		pDto.setTotalCount(totalCount);
		dto.setIgalm0102List(crm05InfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========�ϴ���ʷ��¼��ѯ��������========");
		return dto;
	}
}
