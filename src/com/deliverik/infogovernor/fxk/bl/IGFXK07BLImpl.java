/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.bl.task.RiskcaseVWBL;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.fxk.bl.task.AcceptuserBL;
import com.deliverik.infogovernor.fxk.bl.task.RiskmanagerwaringBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCondImpl;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCondImpl;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;
import com.deliverik.infogovernor.fxk.vo.IGFXK07012VO;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险管理_风险提示管理_ACTION
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXK07BLImpl extends BaseBLImpl implements IGFXK07BL {

	/** 日志配置 */
	private static Log log = LogFactory.getLog(IGFXK07BLImpl.class);
	
	/**风险计划*/
	private  final String planPrpdid = "01003";
	

	/**问题整改*/
	private  final String questModfiy= "01002";

	/**风险评估*/
	private  final String riskpg= "01001";
	

	/** 风险提示管理BL */
	private RiskmanagerwaringBL riskmanagerwaringBL;

	/** 风险人员添加 */
	private AcceptuserBL acceptuserBL;
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	/** 文件处理 */
	protected AttachmentBL attachmentBL;
	/** 发短信BL */
	protected SendMessageBL sendMessageBL;
	/** 发邮件 */
	protected SendMailBL sendMailBL;
	/** 查询BL */
	protected SysManageBL sysManageBL;

	/** 用户查询 */
	protected UserBL userBL;
	
	/**工作查询BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 风险事件BL */
	protected RiskcaseVWBL riskcaseVWBL;
	
	/**风险点*/
	protected RiskPointVMBL riskPointVMBL;
	
	/**检查项*/
	protected CheckItemVWBL checkItemVWBL;

	/**
	 * 检查项设定
	 * @param checkItemVWBL 检查项
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}


	/**
	 * 风险点设定
	 * @param riskPointVMBL 风险点
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}

	
	/**
	 * 风险事件BL设定
	 * @param riskcaseVWBL 风险事件BL
	 */
	public void setRiskcaseVWBL(RiskcaseVWBL riskcaseVWBL) {
		this.riskcaseVWBL = riskcaseVWBL;
	}

	/**
	 * 风险提示管理BL设定
	 * 
	 * @param riskmanagerwaringBL
	 *            风险提示管理BL
	 */
	public void setRiskmanagerwaringBL(RiskmanagerwaringBL riskmanagerwaringBL) {
		this.riskmanagerwaringBL = riskmanagerwaringBL;
	}

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 风险人员添加设定
	 * 
	 * @param acceptuserBL
	 *            风险人员添加
	 */
	public void setAcceptuserBL(AcceptuserBL acceptuserBL) {
		this.acceptuserBL = acceptuserBL;
	}

	/**
	 * 用户查询设定
	 * 
	 * @param userBL
	 *            用户查询
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 发短信BL设定
	 * 
	 * @param sendMessageBL
	 *            发短信BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 发邮件设定
	 * 
	 * @param sendMailBL
	 *            发邮件
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * 查询BL设定
	 * 
	 * @param sysManageBL
	 *            查询BL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
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
	 * 文件处理设定
	 * 
	 * @param attachmentBL
	 *            文件处理
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 新增处理 风险提示添加
	 * 
	 * @param Riskmanagerwaring
	 *            新增实例
	 * @return 新增实例
	 */
	public IGFXK07DTO addRiskmanagerwaring(IGFXK07DTO dto)
			throws BLException {
		log.debug("======================风险提示添加开始======================");
		IGFXK0700Form form = (IGFXK0700Form) dto.getAttachFile();
		if (form.getFileList(0).getFile() != null
				&& !form.getFileList(0).getFile().getFileName().equals("")) {
			/** 附件key */
			String attkey = insertFileListAction(dto);
			form.setRwkey(attkey);
		}
		/** 风险提示信息实体定义 */
		RiskmanagerwaringTB instance = new RiskmanagerwaringTB();
		/** 风险提示实体赋值 */
		instance.setRwname(dto.getForm().getRwname());
		instance.setNorgid(dto.getForm().getNorgid());
		instance.setNorgname(dto.getForm().getNorgname());
		instance.setNtel(dto.getForm().getNtel());
		instance.setNtime(dto.getForm().getNtime());
		instance.setNuserid(dto.getForm().getNuserid());
		instance.setNusername(dto.getForm().getNusername());
		instance.setRwcontext(dto.getForm().getRwcontext());
		instance.setRwkey(dto.getForm().getRwkey());
		log.debug("======================风险提示添加结束======================");
		/**风险提示信息新增*/
		RiskmanagerwaringInfo info = this.riskmanagerwaringBL.registRiskmanagerwaring(instance);
		// 风险提示是否添加成功
		if (null != info && !"".equals(info)) {

			/** 设置风险提示主键 */
			dto.setRwid(info.getRwid());
			/** 接收机构名称 */
			dto.setAporgname(form.getAporgname());
			/** 接收机构码 */
			String aporgid[] = form.getAporgid();

			/** 设置机构码 */
			dto.setAporgid(aporgid);
			/** 添加机构标识 */
			dto.setSign("1");
			/** 风险提示添加成功 */
			if (null != form.getUsid() && !"".equals(form.getUsid())) {
				dto.setSign("2");
				/** 接收用户ID获取 */
				dto.setUsid(form.getUsid());
				/** 接收用户名获取 */
				dto.setUsname(form.getUsname());
			}
			/** 设置短信内容 */
			StringBuffer smsContext = new StringBuffer();
			smsContext.append("风险提示名称：");
			smsContext.append(dto.getForm().getRwname());
			smsContext.append(",提示描述：");
			smsContext.append(dto.getForm().getRwcontext());
			smsContext.append(",推送时间：");
			smsContext.append(dto.getForm().getNtime());

			/** 设置邮件内容 */
			StringBuffer mailTitle = new StringBuffer();
			mailTitle.append("风险提示名称：");
			mailTitle.append(dto.getForm().getRwname());

			dto.setSmsContext(smsContext.toString());
			dto.setMailTitle(mailTitle.toString());
			// 调用接收BL 添加接收人
			this.addAcceptuserInfo(dto);
		}
		return dto;
	}

	/**
	 * 文件添加处理
	 * 
	 * @return filekey
	 */
	private String insertFileListAction(IGFXK07DTO dto) throws BLException {
		IGFXK0700Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

		String attkey = null;
		if (form.getFileListInfo().get(0).getFile() != null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		List<FormFileInfo> astFormFileInfo = form.getFileListInfo();
		for (int i = 0; i < astFormFileInfo.size(); i++) {
			FormFile file = astFormFileInfo.get(i).getFile();
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("sym");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// 上传文件名保存
				attachment.setAttname(attkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}

	private AcceptuserInfo addAcceptuserInfo(IGFXK07DTO dto) throws BLException {
		/** 定义接收实体 */
		AcceptuserTB info = null;
		/** 取接收机构码 */
		String[] aporgid = dto.getAporgid();

		for (int i = 0; i < aporgid.length; i++) {
			System.out.println(aporgid[i]);

			/** 实体实例化 */
			info = new AcceptuserTB();

			/** 设置提示信息rwid */
			info.setRwid(dto.getRwid());
			/** 如果接收到人员 */
			if ("2".equals(dto.getSign())) {
				/** 添加用户ID */
				info.setApuserid(dto.getUsid()[i]);
				/** 添加用户名 */
				info.setApusername(dto.getUsname()[i]);

				// 用户发短信
				this.sendMessageBL.sendSmsToUser(dto.getUsid()[i],dto.getSmsContext());
				// 根据用户ID获取用户信息
				User user = this.userBL.searchUserByKey(dto.getUsid()[i]);
				/**邮件数组*/
				String[] address;

				if (StringUtils.isNotEmpty(user.getUseremail())) {
					// //初始化长度为1的String类型数组
					address = new String[1];
					// 获取用户邮箱地址加入到数组
					address[0] = user.getUseremail();
					// 用发邮件
					this.sendMailBL.sendMail(dto.getMailTitle(),
							dto.getSmsContext(), address);
				}
			}else{
			// 根据机构码获取机构下所有用户
			UserSearchCondImpl cond = new UserSearchCondImpl();
			cond.setOrgid(aporgid[i]);
			List<User> users = this.userBL.searchUser(cond);

			String[] address;

			for (int y = 0; y < users.size(); y++) {

				this.sendMessageBL.sendSmsToUser(users.get(y).getUserid(),
						dto.getSmsContext());

				if (StringUtils.isNotEmpty(users.get(y).getUseremail())) {
					// //初始化长度为1的String类型数组
					address = new String[1];
					// 获取用户邮箱地址加入到数组
					address[0] = users.get(y).getUseremail();
					// 用发邮件
					this.sendMailBL.sendMail(dto.getMailTitle(),dto.getSmsContext(), address);
				}
			}
			}
			/** 添加机构码 */
			info.setAporgid(aporgid[i]);
			/** 添加机构名称 */
			info.setAporgname(dto.getAporgname()[i]);
			/** 调用bl增加啊接收人 */
			this.acceptuserBL.registAcceptuser(info);
		}

		return null;
	}

	/**
	 * 风险提示查询
	 * 
	 */

	public IGFXK07DTO searchRiskmanagerwaring(IGFXK07DTO dto)
			throws BLException {
		// dto参数取得
		IGFXK0700Form form = dto.getForm();
		/** 风险提示初始化查询条件及设定 */
		RiskmanagerwaringSearchCondImpl riskCond = new RiskmanagerwaringSearchCondImpl();
		this.copyProperties(riskCond, form);
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = riskmanagerwaringBL.getSearchCount(riskCond);
		if (totalCount == 0) {

			log.debug("========用户数据检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========用户检索数据件数过多========");
			// 用户检索数据件数过多
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		// 风险提示信息查询
		List<RiskmanagerwaringInfo> list = riskmanagerwaringBL
				.searchRiskmanagerwaring(riskCond, pDto.getFromCount(),
						pDto.getPageDispCount());

		/** 风险管理提示接收者查询条件设定 */
		AcceptuserSearchCondImpl acceptCond = new AcceptuserSearchCondImpl();
		/** 接收人名 */
		acceptCond.setApusername(dto.getForm().getUsername_s());
		/** 接收部门id */
		acceptCond.setAporgid(dto.getForm().getOrgid_s());

		List<AcceptuserInfo> acceptList = this.acceptuserBL
				.searchAcceptuser(acceptCond);
		
		AcceptuserSearchCondImpl acceptShowCond = new AcceptuserSearchCondImpl();
		//要将所有接收人员部门显示出来专用list
		List<AcceptuserInfo> acceptShowList = this.acceptuserBL
				.searchAcceptuser(acceptShowCond);

		//将接收信息设置
		Map<Integer, List<AcceptuserInfo>> map = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : acceptList) {
			if (map.get(info.getRwid()) == null) {
				map.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			map.get(info.getRwid()).add(info);
		}
		//要将所有接收人员部门显示出来专用map
		Map<Integer, List<AcceptuserInfo>> showMap = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : acceptShowList) {
			if (showMap.get(info.getRwid()) == null) {
				showMap.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			showMap.get(info.getRwid()).add(info);
		}
		/***返回给页面vo*/
		List<IGFXK07012VO> voList = new ArrayList<IGFXK07012VO>();
		for (RiskmanagerwaringInfo info : list) {
			if(map.get(info.getRwid())==null){
				continue;
			}
			IGFXK07012VO vo = new IGFXK07012VO();
			vo.setRisk(info);
			vo.setAcceptuserList(showMap.get(info.getRwid()));
			voList.add(vo);
		}

		dto.setVoList(voList);

		pDto.setTotalCount(voList.size());
		dto.addMessage(new ActionMessage("IGCO10000.I002", voList.size()));
		log.debug("===================应急流程查询结束===================");
		return null;
	}

	public IGFXK07DTO searchRiskmanagerwaringById(IGFXK07DTO dto)
			throws BLException {
		/** 风险提示信息查询 */
		RiskmanagerwaringInfo risk = this.riskmanagerwaringBL
				.searchRiskmanagerwaringByPK(dto.getRwid());
		/** dto */
		IGFXK0700Form form = new IGFXK0700Form();
		form.setNusername(risk.getNusername());
		form.setNtel(risk.getNtel());
		form.setNorgname(risk.getNorgname());
		form.setNtime(risk.getNtime());
		form.setRwname(risk.getRwname());
		form.setRwcontext(risk.getRwcontext());
		form.setRwkey(risk.getRwkey());
		form.setType("0");
		/** 风险管理提示接收者查询条件设定 */
		AcceptuserSearchCondImpl cond = new AcceptuserSearchCondImpl();
		cond.setRwid(dto.getRwid());
		/** 风险提示接收人查询 */
		List<AcceptuserInfo> apList = this.acceptuserBL.searchAcceptuser(cond);
		if (apList.get(0).getApuserid() != null
				&& !"".equals(apList.get(0).getApuserid())) {
			form.setType("1");
		}
		dto.setForm(form);
		dto.setAcceptList(apList);
		return dto;
	}

	/***
	 * 风险管理首页查询
	 * @return 四个list集合
	 */
	public IGFXK07DTO getProcessRecords(IGFXK07DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
		IGFXK0700Form form =dto.getIgfxk0700Form();
		User user =form.getUser();
		// 调用DAO接口查询
		IG500SearchCondImpl ig500cond=new IG500SearchCondImpl();
		/**风险计划查询条件*/
		ig500cond.setPrpdid(planPrpdid);
		ig500cond.setOrder("prstatus desc,pr.propentime");
		ig500cond.setSing("desc");
		/**风险计划查询条数*/
		int prlistsize=0;
		
		/**风险计划查询*/
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(ig500cond,0,5, null);
		//如果是查询个人风险计划
		if("1".equals(form.getRiskselecttype())){
			
			for (int j=0;j<prList.size();j++){
				IG500Info info = prList.get(j);
				//判断用户ID是否相等
				if(!user.getUserid().equals(info.getPruserid())){
					//移出
					prList.remove(j);
					j=j-1;
				}else{
					prlistsize++;
				}
			}
			
		}else{
			prlistsize=prList.size();
		}
		
		/**风险清单条件设定*/
		RiskcaseVWSearchCondImpl riskCaseCond = new RiskcaseVWSearchCondImpl();
		/**风险清单查询*/
		List<RiskcaseVWInfo> qdList = riskcaseVWBL.searchRiskcaseVW(riskCaseCond, 0, 0);
		int qdExcing = 0;
		int qdYear = 0;
		for (RiskcaseVWInfo info :qdList){
			if(!"2".equals(info.getEISTATUS())){
				qdExcing++;
			}
			if(info.getRiskcatchtime().contains("2014")){
				qdYear++;
			}
		}
		dto.setQdExcing(qdExcing);
		dto.setQdYear(qdYear);
		/**风险清单查询条数*/
		int qdlistsize=riskcaseVWBL.getSearchCount(riskCaseCond);
		/**问题清单查询*/
		ig500cond.setPrpdid(questModfiy);
		
		/**问题整改查询*/
		List<IG500Info> qmList =workFlowOperationBL.searchProcessByType(ig500cond, 0, 0, null);
		/**问题整改查询条数*/
		int qmlistsize=qmList.size();
		
		
		/**风险评估条件设定*/
		ig500cond.setPrpdid(riskpg);
		/**风险评估查询*/
		List<IG500Info> pgList =workFlowOperationBL.searchProcessByType(ig500cond, 0, 0, null);
		/**风险评估查询条数*/
		int pglistsize=0;
		//如果是查询风险评估
		if("1".equals(form.getPgworkselecttype())){
			
			for (int j=0;j<pgList.size();j++){
				IG500Info info = pgList.get(j);
				//判断用户ID是否相等
				if(!user.getUserid().equals(info.getPruserid())){
					//移出
					pgList.remove(j);
					j=j-1;
				}else{
					pglistsize++;
				}
			}
			
		}else{
			pglistsize=pgList.size();
		}
		
		/**风险评估执行*/
		int pgExcing = 0;
		
		/**风险评估 年度*/
		int pgYear = 0;
		for (IG500Info info:pgList){
			if(!"C".equals(info.getPrstatus())){
				pgExcing++;
			}
			
			if(info.getPropentime().contains("2014")){
				pgYear++;
			}
		}
		
		
		
		/**风险提示查询 */
		List<RiskmanagerwaringInfo> riskList = riskmanagerwaringBL.searchRiskmanagerwaring(new  RiskmanagerwaringSearchCondImpl(),0,4);
		dto.setPgExcing(pgExcing);
		dto.setPgYear(pgYear);
		
		/**风险提示接收信息查询*/
		List<AcceptuserInfo> apList = acceptuserBL.searchAcceptuser();
		
		Map<Integer, List<AcceptuserInfo>> map = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : apList) {
			if (map.get(info.getRwid()) == null) {
				map.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			map.get(info.getRwid()).add(info);
		}
		/**拼装返回给页面的风险提示部分内容*/
		List<IGFXK07012VO> voList = new ArrayList<IGFXK07012VO>();
		for (RiskmanagerwaringInfo info : riskList) {
			IGFXK07012VO vo = new IGFXK07012VO();
			vo.setRisk(info);
			vo.setAcceptuserList(map.get(info.getRwid()));
			voList.add(vo);
		}
		/**风险提示查询 条数*/
		int risklistsize=voList.size();
		
		/**风险点条数查询*/
		RiskPointVMSearchCondImpl riskPointCond = new RiskPointVMSearchCondImpl();
		riskPointCond.setSyscoding("999017");
		int riskCount = riskPointVMBL.searchRiskPointVM(riskPointCond, 0,0).size();
		/**检查项条数*/
		CheckItemVWSearchCondImpl checkItemCond = new CheckItemVWSearchCondImpl();
		checkItemCond.setSyscoding("999018");
		int checkCount = checkItemVWBL.searchCheckItemVW(checkItemCond,0, 0).size();
		dto.setRiskCount(riskCount);
		dto.setCheckCount(checkCount);
		dto.setVoList(voList);
		dto.setPrList(prList);
		dto.setQdList(qdList);
		dto.setQuestModfiy(qmList);
		dto.setRiskpg(pgList);
		dto.setRisklistsize(risklistsize);
		dto.setPrlistsize(prlistsize);
		dto.setPglistsize(pglistsize);
		dto.setQdlistsize(qdlistsize);
		dto.setQmlistsize(qmlistsize);
		log.debug("========查询工作记录处理终了========");
		return dto;
	}
}
