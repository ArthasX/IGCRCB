/**   
 * @Title: IGVen01BL.java 
 * @Package com.deliverik.infogovernor.ven.bl 
 * @Description: TODO
 * @author wangyaowen@Deliverik.com 
 * @date 2014-12-1 上午10:55:23 
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

	/** 流程查询功能API设置 */
	protected SysManageBL sysManageBL;

	/** 风险监测表BL */
	protected RiskMonitoringBL riskMonitoringBL;

	/** 监测工作填报表BL */
	protected MonitoringWorkBL monitoringWorkBL;

	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;

	/** 历史记录附件业务逻辑BL */
	protected AttachmentBL attachmentBL;

	/**
	 * 功能：风险监测查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             修改记录：null
	 */
	public IGVEN02DTO searchRiskMonitoringAction(IGVEN02DTO dto) throws BLException {

		IGVEN0201Form igVEN0201Form = dto.getIgVEN0201Form();
		RiskMonitoringSearchCondImpl cond = new RiskMonitoringSearchCondImpl();
		cond.setRsid(igVEN0201Form.getRsid());// 风险策略主键id

		// 检查任务名称
		cond.setRmname(igVEN0201Form.getRmname());
		// 计划开始时间
		cond.setRmstartdate_from(igVEN0201Form.getRmstartdate_from());
		cond.setRmstartdate_to(igVEN0201Form.getRmstartdate_to());
		// 实际完成时间
		cond.setRmenddate_from(igVEN0201Form.getRmenddate_from());
		cond.setRmenddate_to(igVEN0201Form.getRmenddate_to());

		List<RiskMonitoringInfo> list = this.riskMonitoringBL.searchRiskMonitoring(cond, 0, 0);
		// 查询记录总数
		int totalCount = (list == null ? 0 : list.size());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<RiskMonitoringInfo> rcrList = this.riskMonitoringBL.searchRiskMonitoring(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskMonitoringInfos(rcrList);

		log.debug("========最近一次风险检查结果查询处理终了========");

		return dto;
	}

	/**
	 * 功能：风险监测工作查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             修改记录：null
	 */
	public IGVEN02DTO initIGVEN0202Action(IGVEN02DTO dto) throws BLException {

		MonitoringWorkSearchCondImpl cond = new MonitoringWorkSearchCondImpl();
		cond.setRmid(dto.getIgVEN0202Form().getRmid());// 风险策略主键id
		cond.setEiname(dto.getIgVEN0202Form().getEiname());//指标名称
		cond.setEilabel(dto.getIgVEN0202Form().getEilabel());//指标编号

		int totalCount = this.monitoringWorkBL.getSearchCount(cond);
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<MonitoringWorkInfo> monitoringWorkInfos = this.monitoringWorkBL.searchMonitoringWork(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setMonitoringWorkInfos(monitoringWorkInfos);
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * 流程查询功能API设置设定
	 * 
	 * @param sysManageBL
	 *            流程查询功能API设置
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 风险监测表BL设定
	 * 
	 * @param riskMonitoringBL
	 *            风险监测表BL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * 监测工作填报表BL设定
	 * 
	 * @param monitoringWorkBL
	 *            监测工作填报表BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * 文件上传BL设定
	 * 
	 * @param fileUploadBL
	 *            文件上传BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 历史记录附件业务逻辑BL设定
	 * 
	 * @param attachmentBL
	 *            历史记录附件业务逻辑BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 功能：风险检查结果保存
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             修改记录：null
	 */
	public synchronized IGVEN02DTO insertMonitoringWorkAction(IGVEN02DTO dto) throws BLException {

		IGVEN0203Form form = dto.getIgVEN0203Form();
		Integer[] rmids = form.getRmids();// 主键
		String[] results = form.getResults();// 监测结果
		String[] resultdescs = form.getResultdescs();// 结果说明
		Integer[] filenum = form.getFilenum();
		// User user = dto.getUser();// 当前用户
		if (rmids != null) {
			for (int i = 0, j = rmids.length; i < j; i++) {
				MonitoringWorkInfo mwiInfo = this.monitoringWorkBL.searchMonitoringWorkByPK(rmids[i]);
				MonitoringWorkTB mwtb = (MonitoringWorkTB) SerializationUtils.clone(mwiInfo);
				mwtb.setResult(results[i]);// 监测结果
				mwtb.setResultdesc(resultdescs[i]);// 结果说明

				AttachmentTB attachment = new AttachmentTB();
				String attkey = IGStringUtils.getAttKey();// 附件id
				attachment.setAttkey(attkey);

				// 上传文件检测
				Map<Integer, FormFile> filemap = form.getFileMap();

				FormFile file = filemap.get(filenum[i]);
				if (file != null && file.getFileSize() > 0) {
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();

					// 根目录
					pathBuf.append(rootPath);
					// 当前模块目录
					pathBuf.append("ven");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// 文件上传处理
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}

					// 上传文件名保存
					attachment.setAttname(attkey + "_" + fileName.toString());
					// 上传文件名URL
					attachment.setAtturl("ven");

					this.attachmentBL.registAttachment(attachment);
				}

				mwtb.setMwattachkey(attkey);// 附件

				this.monitoringWorkBL.updateMonitoringWork(mwtb);
			}

			MonitoringWorkSearchCondImpl monitoringWorkCond = new MonitoringWorkSearchCondImpl();
			monitoringWorkCond.setRmid(form.getRmid());
			List<MonitoringWorkInfo> monitoringWorkInfoList = this.monitoringWorkBL.searchMonitoringWork(monitoringWorkCond, 0, 0);
			// 插入进度
			Integer rate = 0;
			// 查询出总的数量
			int sum = monitoringWorkInfoList.size();
			monitoringWorkCond.setResult_isNotNull("1");
			monitoringWorkInfoList = this.monitoringWorkBL.searchMonitoringWork(monitoringWorkCond, 0, 0);
			// 查询出已经需要处理的工作数量
			int count = monitoringWorkInfoList.size();
			// 计算出已处理完成的数量
			rate = (int) (((double) count / (double) sum) * 100);

			RiskMonitoringInfo info = this.riskMonitoringBL.searchRiskMonitoringByPK(form.getRmid());
			RiskMonitoringTB tb = (RiskMonitoringTB) info;
			// 如果进度为100,则该任务已完成
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
			// 将进度重新插入到该检查任务上
			tb.setRmrate(rate.toString());
			// 更新数据
			this.riskMonitoringBL.updateRiskMonitoring(tb);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I003", "检查工作执行成功。"));
		return dto;
	}

}
