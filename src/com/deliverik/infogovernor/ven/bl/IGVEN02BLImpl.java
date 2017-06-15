/**   
 * @Title: IGVen01BL.java 
 * @Package com.deliverik.infogovernor.ven.bl 
 * @Description: TODO
 * @author wangyaowen@Deliverik.com 
 * @date 2014-12-1 ����10:55:23 
 * @version V1.0   
 */
package com.deliverik.infogovernor.ven.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.dto.IGVEN02DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0201Form;
import com.deliverik.infogovernor.ven.form.IGVEN0203Form;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCondImpl;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCondImpl;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

public class IGVEN02BLImpl implements IGVEN02BL {

	static Log log = LogFactory.getLog(IGVEN02BLImpl.class);

	/** ���̲�ѯ����API���� */
	protected SysManageBL sysManageBL;

	/** ���ռ���BL */
	protected RiskMonitoringBL riskMonitoringBL;

	/** ��⹤�����BL */
	protected MonitoringWorkBL monitoringWorkBL;

	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;

	/** ��ʷ��¼����ҵ���߼�BL */
	protected AttachmentBL attachmentBL;

	/**
	 * ���ܣ����ռ���ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             �޸ļ�¼��null
	 */
	public IGVEN02DTO searchRiskMonitoringAction(IGVEN02DTO dto) throws BLException {

		IGVEN0201Form igVEN0201Form = dto.getIgVEN0201Form();
		RiskMonitoringSearchCondImpl cond = new RiskMonitoringSearchCondImpl();
		cond.setRsid(igVEN0201Form.getRsid());// ���ղ�������id

		// �����������
		cond.setRmname(igVEN0201Form.getRmname());
		// �ƻ���ʼʱ��
		cond.setRmstartdate_from(igVEN0201Form.getRmstartdate_from());
		cond.setRmstartdate_to(igVEN0201Form.getRmstartdate_to());
		// ʵ�����ʱ��
		cond.setRmenddate_from(igVEN0201Form.getRmenddate_from());
		cond.setRmenddate_to(igVEN0201Form.getRmenddate_to());

		List<RiskMonitoringInfo> list = this.riskMonitoringBL.searchRiskMonitoring(cond, 0, 0);
		// ��ѯ��¼����
		int totalCount = (list == null ? 0 : list.size());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<RiskMonitoringInfo> rcrList = this.riskMonitoringBL.searchRiskMonitoring(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskMonitoringInfos(rcrList);

		log.debug("========���һ�η��ռ������ѯ��������========");

		return dto;
	}

	/**
	 * ���ܣ����ռ�⹤����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             �޸ļ�¼��null
	 */
	public IGVEN02DTO initIGVEN0202Action(IGVEN02DTO dto) throws BLException {

		MonitoringWorkSearchCondImpl cond = new MonitoringWorkSearchCondImpl();
		cond.setRmid(dto.getIgVEN0202Form().getRmid());// ���ղ�������id
		cond.setEiname(dto.getIgVEN0202Form().getEiname());//ָ������
		cond.setEilabel(dto.getIgVEN0202Form().getEilabel());//ָ����

		int totalCount = this.monitoringWorkBL.getSearchCount(cond);
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<MonitoringWorkInfo> monitoringWorkInfos = this.monitoringWorkBL.searchMonitoringWork(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setMonitoringWorkInfos(monitoringWorkInfos);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * ���̲�ѯ����API�����趨
	 * 
	 * @param sysManageBL
	 *            ���̲�ѯ����API����
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * ���ռ���BL�趨
	 * 
	 * @param riskMonitoringBL
	 *            ���ռ���BL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * ��⹤�����BL�趨
	 * 
	 * @param monitoringWorkBL
	 *            ��⹤�����BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * �ļ��ϴ�BL�趨
	 * 
	 * @param fileUploadBL
	 *            �ļ��ϴ�BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ��ʷ��¼����ҵ���߼�BL�趨
	 * 
	 * @param attachmentBL
	 *            ��ʷ��¼����ҵ���߼�BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * ���ܣ����ռ��������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             �޸ļ�¼��null
	 */
	public synchronized IGVEN02DTO insertMonitoringWorkAction(IGVEN02DTO dto) throws BLException {

		IGVEN0203Form form = dto.getIgVEN0203Form();
		Integer[] rmids = form.getRmids();// ����
		String[] results = form.getResults();// �����
		String[] resultdescs = form.getResultdescs();// ���˵��
		Integer[] filenum = form.getFilenum();
		// User user = dto.getUser();// ��ǰ�û�
		if (rmids != null) {
			for (int i = 0, j = rmids.length; i < j; i++) {
				MonitoringWorkInfo mwiInfo = this.monitoringWorkBL.searchMonitoringWorkByPK(rmids[i]);
				MonitoringWorkTB mwtb = (MonitoringWorkTB) SerializationUtils.clone(mwiInfo);
				mwtb.setResult(results[i]);// �����
				mwtb.setResultdesc(resultdescs[i]);// ���˵��

				AttachmentTB attachment = new AttachmentTB();
				String attkey = IGStringUtils.getAttKey();// ����id
				attachment.setAttkey(attkey);

				// �ϴ��ļ����
				Map<Integer, FormFile> filemap = form.getFileMap();

				FormFile file = filemap.get(filenum[i]);
				if (file != null && file.getFileSize() > 0) {
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();

					// ��Ŀ¼
					pathBuf.append(rootPath);
					// ��ǰģ��Ŀ¼
					pathBuf.append("ven");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// �ļ��ϴ�����
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}

					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + fileName.toString());
					// �ϴ��ļ���URL
					attachment.setAtturl("ven");

					this.attachmentBL.registAttachment(attachment);
				}

				mwtb.setMwattachkey(attkey);// ����

				this.monitoringWorkBL.updateMonitoringWork(mwtb);
			}

			MonitoringWorkSearchCondImpl monitoringWorkCond = new MonitoringWorkSearchCondImpl();
			monitoringWorkCond.setRmid(form.getRmid());
			List<MonitoringWorkInfo> monitoringWorkInfoList = this.monitoringWorkBL.searchMonitoringWork(monitoringWorkCond, 0, 0);
			// �������
			Integer rate = 0;
			// ��ѯ���ܵ�����
			int sum = monitoringWorkInfoList.size();
			monitoringWorkCond.setResult_isNotNull("1");
			monitoringWorkInfoList = this.monitoringWorkBL.searchMonitoringWork(monitoringWorkCond, 0, 0);
			// ��ѯ���Ѿ���Ҫ����Ĺ�������
			int count = monitoringWorkInfoList.size();
			// ������Ѵ�����ɵ�����
			rate = (int) (((double) count / (double) sum) * 100);

			RiskMonitoringInfo info = this.riskMonitoringBL.searchRiskMonitoringByPK(form.getRmid());
			RiskMonitoringTB tb = (RiskMonitoringTB) info;
			// �������Ϊ100,������������
			if (rate == 100) {
				Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				tb.setRmenddate(format.format(time));
			}
			if (rate > 100) {
				rate = 100;
				Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				tb.setRmenddate(format.format(time));
			}
			// ���������²��뵽�ü��������
			tb.setRmrate(rate.toString());
			// ��������
			this.riskMonitoringBL.updateRiskMonitoring(tb);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I003", "��鹤��ִ�гɹ���"));
		return dto;
	}

}
