/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.prj.bl.task.ProjectLogBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectPlanBL;
import com.deliverik.infogovernor.prj.dto.ProjectPlanDTO;
import com.deliverik.infogovernor.prj.form.ProjectPlanForm;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCondImpl;
import com.deliverik.infogovernor.prj.model.entity.ProjectPlanTB;
import com.deliverik.infogovernor.prj.vo.MilestoneInfo;
import com.deliverik.infogovernor.util.PRJHelper;

public class IGPRJ02BLImpl implements IGPRJ02BL {
	
	static Log log = LogFactory.getLog(IGPRJ02BLImpl.class);
	
	protected ProjectLogBL projectLogBL;
	
	protected ProjectPlanBL projectPlanBL;
	
	/** 注入文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 注入附件上传BL */
	protected AttachmentBL attachmentBL;
	
	public void setProjectLogBL(ProjectLogBL projectLogBL) {
		this.projectLogBL = projectLogBL;
	}

	public void setProjectPlanBL(ProjectPlanBL projectPlanBL) {
		this.projectPlanBL = projectPlanBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	//插入项目计划
	public ProjectPlanDTO insertEntityAction(ProjectPlanDTO dto) throws BLException {
		ProjectPlanForm form = (ProjectPlanForm)dto.getProjectPlan();
		ProjectLog projectLog = dto.getProjectLog();
		if(!IGStringUtils.isValidBytes(form.getPplinfo(),2000)){
			throw new BLException("项目计划总体描述过长");
		}
		
		// 存附件，并返回key
		String riskattkey = "";
		if(StringUtils.isNotEmpty(form.getPplriskatt())){			
			// 存附件，并返回key
			riskattkey = form.getPplriskatt();
		}
		// 调用附件方法
		if (form.getFileMap() != null && form.getFileMap().size() > 0) {
			riskattkey = insertFileAction(form.getFileMap(),form.getPplriskatt());
		}
		if (riskattkey != null) {
			// 为实体设置附件号
			form.setPplriskatt(riskattkey);
		}
		this.projectPlanBL.saveProjectPlan(form);
		this.projectLogBL.saveProjectLog(projectLog);
		return dto;
	}

	//得到最新状态的milestone
	private ProjectPlan getCurrentProjectPlan(ProjectPlanDTO dto) throws BLException {   
		Integer projectId = dto.getProjectId();
		ProjectPlanSearchCondImpl cond = new ProjectPlanSearchCondImpl();
		cond.setPid(projectId);
		cond.setPplstatus("A");
		List<ProjectPlan> projectPlanList = this.projectPlanBL.findByCond(cond, 0, 0);
		ProjectPlan projectPlan = new ProjectPlanTB();
		if(projectPlanList!=null&&projectPlanList.size()>0){
			projectPlan = projectPlanList.get(0);
		}
		
		return projectPlan;
	}
	
	//得到每个计划的最新版本
	private ProjectPlan getCurrentProjectPlanv(ProjectPlanDTO dto) throws BLException {   
		Integer projectId = dto.getProjectId();
		ProjectPlanSearchCondImpl cond = new ProjectPlanSearchCondImpl();
		cond.setPid(projectId);
		cond.setPplstatus(dto.getPplstatus());
		
		cond.setOrderdesc("pplversion");
		List<ProjectPlan> projectPlanList = this.projectPlanBL.findByCond(cond, 0, 0);
		if(projectPlanList!=null&&projectPlanList.size()>0){
			ProjectPlan projectPlan = projectPlanList.get(0);
			List<Attachment> attachmentList = null;
			if(StringUtils.isNotEmpty(projectPlan.getPplriskatt())){
				attachmentList = this.attachmentBL.searchAttachmentsByAttkey(projectPlan.getPplriskatt());
				dto.setAttachmentList(attachmentList);
			}
			return projectPlan;
		}
		else{
			return null;
		}
		
		
	}

	//获取当前里程碑
	public ProjectPlanDTO getCurrentMS(ProjectPlanDTO dto) throws BLException {
		
		ProjectPlanSearchCondImpl condt = new ProjectPlanSearchCondImpl();
		condt.setPid(dto.getProjectId());
		List<ProjectPlan> qyiGList = this.projectPlanBL.findByCond(condt, 0, 0);
		List<MilestoneInfo> milestoneInfoList = new ArrayList<MilestoneInfo>();
		int i=0;
		for(ProjectPlan pp:qyiGList){
			MilestoneInfo milestoneInfoVO = new MilestoneInfo();
			milestoneInfoVO.setMsIndex(String.valueOf(i));
//			milestoneInfoVO.setMsStatus(milestoneElements[1]);
			milestoneInfoVO.setMsName(pp.getPpltitle());
			milestoneInfoVO.setMsCloseDate(pp.getPplclosetime());
			milestoneInfoVO.setMsPlanDate(pp.getPplopentime());
			milestoneInfoVO.setMsplanDesc(pp.getPplinfo());
			milestoneInfoVO.setMsConfirmDate(pp.getPplshuttime());
			milestoneInfoVO.setMsConfirmDesc(pp.getPpldesc());
			
			
			List<Attachment> attachmentList = null;
			if(StringUtils.isNotEmpty(pp.getPplriskatt())){
				attachmentList = this.attachmentBL.searchAttachmentsByAttkey(pp.getPplriskatt());
				milestoneInfoVO.setAttachmentList(attachmentList);
			}
			milestoneInfoList.add(milestoneInfoVO);
			i++;
		}
		ProjectPlan projectPlan = this.getCurrentProjectPlan(dto);
		dto.setMilestoneInfoList(milestoneInfoList);
		dto.setProjectPlan(projectPlan);
		return dto;
	}
	
	//获取当前里程碑
	public ProjectPlanDTO getCurrentMSv(ProjectPlanDTO dto) throws BLException {
		ProjectPlan projectPlan = this.getCurrentProjectPlanv(dto);
		if(projectPlan==null){
			ProjectPlanTB projectPlanTB = new ProjectPlanTB();
			projectPlanTB.setPplversion(0);
			projectPlanTB.setPplstatus(dto.getPplstatus());
			projectPlanTB.setPid(dto.getProjectId());
//			projectPlanTB.setPplopentime(IGStringUtils.getCurrentDate());
			projectPlan = projectPlanTB;
		}
		dto.setProjectPlan(projectPlan);
		
		Integer projectId = dto.getProjectId();
		ProjectPlanSearchCondImpl cond = new ProjectPlanSearchCondImpl();
		cond.setPid(projectId);
		cond.setOrderdesc("pplstatus");
		List<ProjectPlan> projectPlanList = this.projectPlanBL.findByCond(cond, 0, 0);
		if(projectPlanList!=null&&projectPlanList.size()>0){
			ProjectPlan ppmax = projectPlanList.get(0);
			dto.setPtime(ppmax.getPplclosetime());
			String stemp = ppmax.getPplstatus();
			byte[] b2s = stemp.getBytes();
			b2s[0] =  Integer.valueOf(Integer.valueOf(b2s[0])+1).byteValue();
			dto.setPstatus(new String(b2s));
			
			//取前一个状态的时间		
			ProjectPlanSearchCondImpl condt = new ProjectPlanSearchCondImpl();
			condt.setPid(projectId);
			if(!"A".equals(dto.getPplstatus())&&!StringUtils.isEmpty(dto.getPplstatus())){
				String stempt = dto.getPplstatus();
				byte[] b2st = stempt.getBytes();
				b2st[0] =  Integer.valueOf(Integer.valueOf(b2st[0])-1).byteValue();
				condt.setPplstatus(new String(b2st));
				condt.setOrderdesc("pplstatus");
				List<ProjectPlan> qyiGList = this.projectPlanBL.findByCond(condt, 0, 0);
				if(qyiGList!=null&&qyiGList.size()>0){
					dto.setSygTime(qyiGList.get(0).getPplopentime());
				}
			}
		}else{
			dto.setPstatus("A");
		}
		
		return dto;
	}
	
	//获取当前里程碑
	public ProjectPlanDTO getCurrentMSj(ProjectPlanDTO dto) throws BLException {
		ProjectPlan projectPlan = this.getCurrentProjectPlanv(dto);
		if(projectPlan==null){
			ProjectPlanTB projectPlanTB = new ProjectPlanTB();
			projectPlanTB.setPplversion(0);
			projectPlanTB.setPplstatus(dto.getPplstatus());
			projectPlanTB.setPid(dto.getProjectId());
			projectPlanTB.setPplopentime(IGStringUtils.getCurrentDate());
			projectPlan = projectPlanTB;
		}
		dto.setProjectPlan(projectPlan);
		
		Integer projectId = dto.getProjectId();
		ProjectPlanSearchCondImpl cond = new ProjectPlanSearchCondImpl();
		cond.setPid(projectId);
		cond.setOrderdesc("pplstatus");	//按计划进展倒序，以便取最新的计划
		List<ProjectPlan> projectPlanList = this.projectPlanBL.findByCond(cond, 0, 0);
		if(projectPlanList!=null&&projectPlanList.size()>0){
			ProjectPlan ppmax = projectPlanList.get(0);
			dto.setPtime(ppmax.getPplclosetime());
			String stemp = ppmax.getPplstatus();
			dto.setPstatus(stemp);
		}else{
			dto.setPstatus("");	//若没有计划，初始化一个计划状态为空（小于字母A即可）
		}
		
		return dto;
	}
	
	//设置颜色
	public ProjectPlanDTO setColor(ProjectPlanDTO dto) throws BLException {
		dto.setColorA("e3f3ff");
		dto.setColorB("e3f3ff");
		dto.setColorC("e3f3ff");
		dto.setColorD("e3f3ff");
		dto.setColorE("e3f3ff");
		dto.setColorF("e3f3ff");
		dto.setColorG("e3f3ff");
		Integer projectId = dto.getProjectId();
		ProjectPlanSearchCondImpl cond = new ProjectPlanSearchCondImpl();
		cond.setPid(projectId);
		cond.setOrderdesc("pplstatus");
		List<ProjectPlan> projectPlanList = this.projectPlanBL.findByCond(cond, 0, 0);
		for(ProjectPlan pp:projectPlanList){
			if("A".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorA("a2f49c");
				}
			}else if("B".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorB("a2f49c");
				}
			}else if("C".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorC("a2f49c");
				}
			}else if("D".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorD("a2f49c");
				}
			}else if("E".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorE("a2f49c");
				}
			}else if("F".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorF("a2f49c");
				}
			}else if("G".equals(pp.getPplstatus())){
				if(StringUtils.isNotEmpty(pp.getPplshuttime())){
					dto.setColorG("a2f49c");
				}
			}
			
		}
		//高亮显示以选中计划
		if ("A".equals(dto.getPplstatus())) {
			dto.setColorA("ffffff");
		} else if ("B".equals(dto.getPplstatus())) {
			dto.setColorB("ffffff");
		} else if ("C".equals(dto.getPplstatus())) {
			dto.setColorC("ffffff");
		} else if ("D".equals(dto.getPplstatus())) {
			dto.setColorD("ffffff");
		} else if ("E".equals(dto.getPplstatus())) {
			dto.setColorE("ffffff");
		} else if ("F".equals(dto.getPplstatus())) {
			dto.setColorF("ffffff");
		} else if ("G".equals(dto.getPplstatus())) {
			dto.setColorG("ffffff");
		}
		return dto;
	}

	//调整里程碑
	public ProjectPlanDTO adjustMS(ProjectPlanDTO dto) throws BLException {
		ProjectPlan oldProjectPlan = this.getCurrentProjectPlan(dto);
		
		ProjectPlanTB projectPlanTB = new ProjectPlanTB();//更新旧版状态
		projectPlanTB.setPid(oldProjectPlan.getPid());
		projectPlanTB.setPpldate(oldProjectPlan.getPpldate());
		projectPlanTB.setPpldesc(oldProjectPlan.getPpldesc());
		projectPlanTB.setPplid(oldProjectPlan.getPplid());
		projectPlanTB.setPplinfo(oldProjectPlan.getPplinfo());
		projectPlanTB.setPplversion(oldProjectPlan.getPplversion());
		projectPlanTB.setPplstatus("I");
		if(!IGStringUtils.isValidBytes(dto.getProjectPlan().getPplinfo(),2000)){
			throw new BLException("IGPRJ0101.E002");
		}
		this.projectPlanBL.saveProjectPlan(projectPlanTB);
		
		ProjectPlan newProjectPlan = dto.getProjectPlan();
		this.projectPlanBL.saveProjectPlan(newProjectPlan);
		return dto;
	}
	
	//调整计划
	public ProjectPlanDTO adjustMSv(ProjectPlanDTO dto) throws BLException {
		ProjectPlan newProjectPlan = dto.getProjectPlan();
		ProjectPlanForm form = (ProjectPlanForm)dto.getProjectPlan();
		// 存附件，并返回key
		String riskattkey = "";
		if(StringUtils.isNotEmpty(form.getPplriskatt())){			
			// 存附件，并返回key
			riskattkey = form.getPplriskatt();
		}
		// 调用附件方法
		if (form.getFileMap() != null && form.getFileMap().size() > 0) {
			riskattkey = insertFileAction(form.getFileMap(),form.getPplriskatt());
		}
		if (riskattkey != null) {
			// 为实体设置附件号
			form.setPplriskatt(riskattkey);
		}
		
		this.projectPlanBL.saveProjectPlan(newProjectPlan);
		return dto;
	}
	
	public ProjectPlanDTO updateProjectPlan(ProjectPlanDTO dto) throws BLException{
		ProjectPlanForm form = dto.getProjectPlanForm();
		Integer projectPlanId = form.getPplid();
		if(projectPlanId==null||projectPlanId<1){
			throw new BLException();
		}
		ProjectPlan projectPlan = projectPlanBL.findByPK(projectPlanId);
		ProjectPlanTB newProjectPlan = (ProjectPlanTB) SerializationUtils.clone(projectPlan);
		newProjectPlan.setPplshuttime(form.getPplshuttime());
		projectPlanBL.updateProjectPlan(newProjectPlan);
		return dto;
	}

	//确认里程碑
	public ProjectPlanDTO confirmMS(ProjectPlanDTO dto) throws BLException {
		
		String confirmPplInfo = dto.getProjectPlan().getPplinfo();
		
		ProjectPlan oldProjectPlan = this.getCurrentProjectPlan(dto);
		ProjectPlanTB projectPlanTB = new ProjectPlanTB();//更新旧版状态
		projectPlanTB.setPid(oldProjectPlan.getPid());
		projectPlanTB.setPpldate(oldProjectPlan.getPpldate());
		projectPlanTB.setPpldesc(oldProjectPlan.getPpldesc());
		projectPlanTB.setPplid(oldProjectPlan.getPplid());
		String oldPplinfo = oldProjectPlan.getPplinfo();
		projectPlanTB.setPplinfo(oldPplinfo);
		Integer versionId = oldProjectPlan.getPplversion();
		projectPlanTB.setPplversion(versionId);
		projectPlanTB.setPplstatus("I");
		this.projectPlanBL.saveProjectPlan(projectPlanTB);
		
		String [] confirmMSs = confirmPplInfo.split(";");
		for (int i = 0; i < confirmMSs.length; i++) {
			String[] confirmMS = confirmMSs[i].split(":");
			String confirmIndex = confirmMS[0];
			String confirmDate = confirmMS[1];
			String confirmDesc = confirmMS[2];
			oldPplinfo = PRJHelper.verifyMilestone(oldPplinfo, confirmIndex, confirmDate, confirmDesc);
		}
		
		projectPlanTB.setPplversion(versionId + 1);  //新版本信息
		projectPlanTB.setPplstatus("A");
		projectPlanTB.setPplid(null);
		projectPlanTB.setPplinfo(oldPplinfo);
		this.projectPlanBL.saveProjectPlan(projectPlanTB);
		
		return dto;
		
	}

	//获取里程碑状态
	public ProjectPlanDTO getCurrentForViewMS(ProjectPlanDTO dto) throws BLException {
		
		final String noDone = "toleration";             //未到期未完成
		final String notDoneExDate = "no_response";     //到期未完成
		final String done = "advance"; 		        	//按时或提前完成	
		final String doneExDate = "lag";     	        //超期完成
		
		Date todayDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(todayDate);
		dto = this.getCurrentMS(dto);
		List<MilestoneInfo> milestoneInfoList = dto.getMilestoneInfoList();
		for (MilestoneInfo milestoneInfo : milestoneInfoList) {
			if(StringUtils.isEmpty(milestoneInfo.getMsConfirmDate())){   //未确认
				if(milestoneInfo.getMsCloseDate().compareTo(today) >= 0){  //未完成且未到期
					milestoneInfo.setMsColor(noDone);
				} else {
					milestoneInfo.setMsColor(notDoneExDate);  //到期未完成
				}
			} else {    //已确认
				if(milestoneInfo.getMsCloseDate().compareTo(milestoneInfo.getMsConfirmDate()) >= 0){   //按时或提前完成	
					milestoneInfo.setMsColor(done);
				} else {
					milestoneInfo.setMsColor(doneExDate);
				}
			}
		}
		/**获得项目日志*/
		ProjectLogSearchCondImpl plCond = new ProjectLogSearchCondImpl();
		plCond.setPid(dto.getProjectId());
		List<ProjectLog> projectLogList = projectLogBL.findByCond(plCond, 0, 0);
		Map<String,String> projectLogMap = new HashMap<String,String>();
		if(projectLogList!=null){
			for(ProjectLog pjlog:projectLogList){
				if(StringUtils.isNotEmpty(pjlog.getPltime())&&pjlog.getPltime().length()>10){
					projectLogMap.put(pjlog.getPltime().substring(0,10),String.valueOf(pjlog.getPlid()));
				}
				
			}
		}
		dto.setProjectLogMap(projectLogMap);
		
		return dto;
	}
	
	/**
	 * 附件添加调用方法
	 * 
	 * @param ystr
	 * @return
	 */
	private String insertFileAction(Map<Integer, FormFile> fileMap,String riskatt) throws BLException {

		log.debug("========插入上传文档操作开始========");
		
		// 设定附件实体
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测
		Map<Integer, FormFile> keymap = fileMap;
		String riskattkey = null;
		if(StringUtils.isNotEmpty(riskatt)){
			riskattkey = riskatt;
			attachment.setAttkey(riskattkey);
		}else{			
			// 附件编号判断，赋值
			if (keymap != null && keymap.size() > 0) {
				
				riskattkey = IGStringUtils.getAttKey();
				
				attachment.setAttkey(riskattkey);
			}
		}
		// 转换
		Iterator<Integer> iterator = keymap.keySet().iterator();
		// 循环上传文件
		while (iterator.hasNext()) {
			FormFile file = (FormFile) keymap.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("ins");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(),
							riskattkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// 上传文件名保存
				attachment.setAttname(riskattkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("ins");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		log.debug("========插入上传文档操作结束========");
		return riskattkey;
	}
}
