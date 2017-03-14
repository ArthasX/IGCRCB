/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���չ���_������ʾ����_ACTION
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public class IGFXK07BLImpl extends BaseBLImpl implements IGFXK07BL {

	/** ��־���� */
	private static Log log = LogFactory.getLog(IGFXK07BLImpl.class);
	
	/**���ռƻ�*/
	private  final String planPrpdid = "01003";
	

	/**��������*/
	private  final String questModfiy= "01002";

	/**��������*/
	private  final String riskpg= "01001";
	

	/** ������ʾ����BL */
	private RiskmanagerwaringBL riskmanagerwaringBL;

	/** ������Ա��� */
	private AcceptuserBL acceptuserBL;
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	/** �ļ����� */
	protected AttachmentBL attachmentBL;
	/** ������BL */
	protected SendMessageBL sendMessageBL;
	/** ���ʼ� */
	protected SendMailBL sendMailBL;
	/** ��ѯBL */
	protected SysManageBL sysManageBL;

	/** �û���ѯ */
	protected UserBL userBL;
	
	/**������ѯBL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** �����¼�BL */
	protected RiskcaseVWBL riskcaseVWBL;
	
	/**���յ�*/
	protected RiskPointVMBL riskPointVMBL;
	
	/**�����*/
	protected CheckItemVWBL checkItemVWBL;

	/**
	 * ������趨
	 * @param checkItemVWBL �����
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}


	/**
	 * ���յ��趨
	 * @param riskPointVMBL ���յ�
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}

	
	/**
	 * �����¼�BL�趨
	 * @param riskcaseVWBL �����¼�BL
	 */
	public void setRiskcaseVWBL(RiskcaseVWBL riskcaseVWBL) {
		this.riskcaseVWBL = riskcaseVWBL;
	}

	/**
	 * ������ʾ����BL�趨
	 * 
	 * @param riskmanagerwaringBL
	 *            ������ʾ����BL
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
	 * ������Ա����趨
	 * 
	 * @param acceptuserBL
	 *            ������Ա���
	 */
	public void setAcceptuserBL(AcceptuserBL acceptuserBL) {
		this.acceptuserBL = acceptuserBL;
	}

	/**
	 * �û���ѯ�趨
	 * 
	 * @param userBL
	 *            �û���ѯ
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ������BL�趨
	 * 
	 * @param sendMessageBL
	 *            ������BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * ���ʼ��趨
	 * 
	 * @param sendMailBL
	 *            ���ʼ�
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * ��ѯBL�趨
	 * 
	 * @param sysManageBL
	 *            ��ѯBL
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
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
	 * �ļ������趨
	 * 
	 * @param attachmentBL
	 *            �ļ�����
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �������� ������ʾ���
	 * 
	 * @param Riskmanagerwaring
	 *            ����ʵ��
	 * @return ����ʵ��
	 */
	public IGFXK07DTO addRiskmanagerwaring(IGFXK07DTO dto)
			throws BLException {
		log.debug("======================������ʾ��ӿ�ʼ======================");
		IGFXK0700Form form = (IGFXK0700Form) dto.getAttachFile();
		if (form.getFileList(0).getFile() != null
				&& !form.getFileList(0).getFile().getFileName().equals("")) {
			/** ����key */
			String attkey = insertFileListAction(dto);
			form.setRwkey(attkey);
		}
		/** ������ʾ��Ϣʵ�嶨�� */
		RiskmanagerwaringTB instance = new RiskmanagerwaringTB();
		/** ������ʾʵ�帳ֵ */
		instance.setRwname(dto.getForm().getRwname());
		instance.setNorgid(dto.getForm().getNorgid());
		instance.setNorgname(dto.getForm().getNorgname());
		instance.setNtel(dto.getForm().getNtel());
		instance.setNtime(dto.getForm().getNtime());
		instance.setNuserid(dto.getForm().getNuserid());
		instance.setNusername(dto.getForm().getNusername());
		instance.setRwcontext(dto.getForm().getRwcontext());
		instance.setRwkey(dto.getForm().getRwkey());
		log.debug("======================������ʾ��ӽ���======================");
		/**������ʾ��Ϣ����*/
		RiskmanagerwaringInfo info = this.riskmanagerwaringBL.registRiskmanagerwaring(instance);
		// ������ʾ�Ƿ���ӳɹ�
		if (null != info && !"".equals(info)) {

			/** ���÷�����ʾ���� */
			dto.setRwid(info.getRwid());
			/** ���ջ������� */
			dto.setAporgname(form.getAporgname());
			/** ���ջ����� */
			String aporgid[] = form.getAporgid();

			/** ���û����� */
			dto.setAporgid(aporgid);
			/** ��ӻ�����ʶ */
			dto.setSign("1");
			/** ������ʾ��ӳɹ� */
			if (null != form.getUsid() && !"".equals(form.getUsid())) {
				dto.setSign("2");
				/** �����û�ID��ȡ */
				dto.setUsid(form.getUsid());
				/** �����û�����ȡ */
				dto.setUsname(form.getUsname());
			}
			/** ���ö������� */
			StringBuffer smsContext = new StringBuffer();
			smsContext.append("������ʾ���ƣ�");
			smsContext.append(dto.getForm().getRwname());
			smsContext.append(",��ʾ������");
			smsContext.append(dto.getForm().getRwcontext());
			smsContext.append(",����ʱ�䣺");
			smsContext.append(dto.getForm().getNtime());

			/** �����ʼ����� */
			StringBuffer mailTitle = new StringBuffer();
			mailTitle.append("������ʾ���ƣ�");
			mailTitle.append(dto.getForm().getRwname());

			dto.setSmsContext(smsContext.toString());
			dto.setMailTitle(mailTitle.toString());
			// ���ý���BL ��ӽ�����
			this.addAcceptuserInfo(dto);
		}
		return dto;
	}

	/**
	 * �ļ���Ӵ���
	 * 
	 * @return filekey
	 */
	private String insertFileListAction(IGFXK07DTO dto) throws BLException {
		IGFXK0700Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		if (form.getFileListInfo().get(0).getFile() != null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		List<FormFileInfo> astFormFileInfo = form.getFileListInfo();
		for (int i = 0; i < astFormFileInfo.size(); i++) {
			FormFile file = astFormFileInfo.get(i).getFile();
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("sym");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}

	private AcceptuserInfo addAcceptuserInfo(IGFXK07DTO dto) throws BLException {
		/** �������ʵ�� */
		AcceptuserTB info = null;
		/** ȡ���ջ����� */
		String[] aporgid = dto.getAporgid();

		for (int i = 0; i < aporgid.length; i++) {
			System.out.println(aporgid[i]);

			/** ʵ��ʵ���� */
			info = new AcceptuserTB();

			/** ������ʾ��Ϣrwid */
			info.setRwid(dto.getRwid());
			/** ������յ���Ա */
			if ("2".equals(dto.getSign())) {
				/** ����û�ID */
				info.setApuserid(dto.getUsid()[i]);
				/** ����û��� */
				info.setApusername(dto.getUsname()[i]);

				// �û�������
				this.sendMessageBL.sendSmsToUser(dto.getUsid()[i],dto.getSmsContext());
				// �����û�ID��ȡ�û���Ϣ
				User user = this.userBL.searchUserByKey(dto.getUsid()[i]);
				/**�ʼ�����*/
				String[] address;

				if (StringUtils.isNotEmpty(user.getUseremail())) {
					// //��ʼ������Ϊ1��String��������
					address = new String[1];
					// ��ȡ�û������ַ���뵽����
					address[0] = user.getUseremail();
					// �÷��ʼ�
					this.sendMailBL.sendMail(dto.getMailTitle(),
							dto.getSmsContext(), address);
				}
			}else{
			// ���ݻ������ȡ�����������û�
			UserSearchCondImpl cond = new UserSearchCondImpl();
			cond.setOrgid(aporgid[i]);
			List<User> users = this.userBL.searchUser(cond);

			String[] address;

			for (int y = 0; y < users.size(); y++) {

				this.sendMessageBL.sendSmsToUser(users.get(y).getUserid(),
						dto.getSmsContext());

				if (StringUtils.isNotEmpty(users.get(y).getUseremail())) {
					// //��ʼ������Ϊ1��String��������
					address = new String[1];
					// ��ȡ�û������ַ���뵽����
					address[0] = users.get(y).getUseremail();
					// �÷��ʼ�
					this.sendMailBL.sendMail(dto.getMailTitle(),dto.getSmsContext(), address);
				}
			}
			}
			/** ��ӻ����� */
			info.setAporgid(aporgid[i]);
			/** ��ӻ������� */
			info.setAporgname(dto.getAporgname()[i]);
			/** ����bl���Ӱ������� */
			this.acceptuserBL.registAcceptuser(info);
		}

		return null;
	}

	/**
	 * ������ʾ��ѯ
	 * 
	 */

	public IGFXK07DTO searchRiskmanagerwaring(IGFXK07DTO dto)
			throws BLException {
		// dto����ȡ��
		IGFXK0700Form form = dto.getForm();
		/** ������ʾ��ʼ����ѯ�������趨 */
		RiskmanagerwaringSearchCondImpl riskCond = new RiskmanagerwaringSearchCondImpl();
		this.copyProperties(riskCond, form);
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = riskmanagerwaringBL.getSearchCount(riskCond);
		if (totalCount == 0) {

			log.debug("========�û����ݼ������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========�û��������ݼ�������========");
			// �û��������ݼ�������
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		// ������ʾ��Ϣ��ѯ
		List<RiskmanagerwaringInfo> list = riskmanagerwaringBL
				.searchRiskmanagerwaring(riskCond, pDto.getFromCount(),
						pDto.getPageDispCount());

		/** ���չ�����ʾ�����߲�ѯ�����趨 */
		AcceptuserSearchCondImpl acceptCond = new AcceptuserSearchCondImpl();
		/** �������� */
		acceptCond.setApusername(dto.getForm().getUsername_s());
		/** ���ղ���id */
		acceptCond.setAporgid(dto.getForm().getOrgid_s());

		List<AcceptuserInfo> acceptList = this.acceptuserBL
				.searchAcceptuser(acceptCond);
		
		AcceptuserSearchCondImpl acceptShowCond = new AcceptuserSearchCondImpl();
		//Ҫ�����н�����Ա������ʾ����ר��list
		List<AcceptuserInfo> acceptShowList = this.acceptuserBL
				.searchAcceptuser(acceptShowCond);

		//��������Ϣ����
		Map<Integer, List<AcceptuserInfo>> map = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : acceptList) {
			if (map.get(info.getRwid()) == null) {
				map.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			map.get(info.getRwid()).add(info);
		}
		//Ҫ�����н�����Ա������ʾ����ר��map
		Map<Integer, List<AcceptuserInfo>> showMap = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : acceptShowList) {
			if (showMap.get(info.getRwid()) == null) {
				showMap.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			showMap.get(info.getRwid()).add(info);
		}
		/***���ظ�ҳ��vo*/
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
		log.debug("===================Ӧ�����̲�ѯ����===================");
		return null;
	}

	public IGFXK07DTO searchRiskmanagerwaringById(IGFXK07DTO dto)
			throws BLException {
		/** ������ʾ��Ϣ��ѯ */
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
		/** ���չ�����ʾ�����߲�ѯ�����趨 */
		AcceptuserSearchCondImpl cond = new AcceptuserSearchCondImpl();
		cond.setRwid(dto.getRwid());
		/** ������ʾ�����˲�ѯ */
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
	 * ���չ�����ҳ��ѯ
	 * @return �ĸ�list����
	 */
	public IGFXK07DTO getProcessRecords(IGFXK07DTO dto) throws BLException {
		log.debug("========��ѯ������¼����ʼ========");
		IGFXK0700Form form =dto.getIgfxk0700Form();
		User user =form.getUser();
		// ����DAO�ӿڲ�ѯ
		IG500SearchCondImpl ig500cond=new IG500SearchCondImpl();
		/**���ռƻ���ѯ����*/
		ig500cond.setPrpdid(planPrpdid);
		ig500cond.setOrder("prstatus desc,pr.propentime");
		ig500cond.setSing("desc");
		/**���ռƻ���ѯ����*/
		int prlistsize=0;
		
		/**���ռƻ���ѯ*/
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(ig500cond,0,5, null);
		//����ǲ�ѯ���˷��ռƻ�
		if("1".equals(form.getRiskselecttype())){
			
			for (int j=0;j<prList.size();j++){
				IG500Info info = prList.get(j);
				//�ж��û�ID�Ƿ����
				if(!user.getUserid().equals(info.getPruserid())){
					//�Ƴ�
					prList.remove(j);
					j=j-1;
				}else{
					prlistsize++;
				}
			}
			
		}else{
			prlistsize=prList.size();
		}
		
		/**�����嵥�����趨*/
		RiskcaseVWSearchCondImpl riskCaseCond = new RiskcaseVWSearchCondImpl();
		/**�����嵥��ѯ*/
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
		/**�����嵥��ѯ����*/
		int qdlistsize=riskcaseVWBL.getSearchCount(riskCaseCond);
		/**�����嵥��ѯ*/
		ig500cond.setPrpdid(questModfiy);
		
		/**�������Ĳ�ѯ*/
		List<IG500Info> qmList =workFlowOperationBL.searchProcessByType(ig500cond, 0, 0, null);
		/**�������Ĳ�ѯ����*/
		int qmlistsize=qmList.size();
		
		
		/**�������������趨*/
		ig500cond.setPrpdid(riskpg);
		/**����������ѯ*/
		List<IG500Info> pgList =workFlowOperationBL.searchProcessByType(ig500cond, 0, 0, null);
		/**����������ѯ����*/
		int pglistsize=0;
		//����ǲ�ѯ��������
		if("1".equals(form.getPgworkselecttype())){
			
			for (int j=0;j<pgList.size();j++){
				IG500Info info = pgList.get(j);
				//�ж��û�ID�Ƿ����
				if(!user.getUserid().equals(info.getPruserid())){
					//�Ƴ�
					pgList.remove(j);
					j=j-1;
				}else{
					pglistsize++;
				}
			}
			
		}else{
			pglistsize=pgList.size();
		}
		
		/**��������ִ��*/
		int pgExcing = 0;
		
		/**�������� ���*/
		int pgYear = 0;
		for (IG500Info info:pgList){
			if(!"C".equals(info.getPrstatus())){
				pgExcing++;
			}
			
			if(info.getPropentime().contains("2014")){
				pgYear++;
			}
		}
		
		
		
		/**������ʾ��ѯ */
		List<RiskmanagerwaringInfo> riskList = riskmanagerwaringBL.searchRiskmanagerwaring(new  RiskmanagerwaringSearchCondImpl(),0,4);
		dto.setPgExcing(pgExcing);
		dto.setPgYear(pgYear);
		
		/**������ʾ������Ϣ��ѯ*/
		List<AcceptuserInfo> apList = acceptuserBL.searchAcceptuser();
		
		Map<Integer, List<AcceptuserInfo>> map = new LinkedHashMap<Integer, List<AcceptuserInfo>>();
		for (AcceptuserInfo info : apList) {
			if (map.get(info.getRwid()) == null) {
				map.put(info.getRwid(), new ArrayList<AcceptuserInfo>());
			}
			map.get(info.getRwid()).add(info);
		}
		/**ƴװ���ظ�ҳ��ķ�����ʾ��������*/
		List<IGFXK07012VO> voList = new ArrayList<IGFXK07012VO>();
		for (RiskmanagerwaringInfo info : riskList) {
			IGFXK07012VO vo = new IGFXK07012VO();
			vo.setRisk(info);
			vo.setAcceptuserList(map.get(info.getRwid()));
			voList.add(vo);
		}
		/**������ʾ��ѯ ����*/
		int risklistsize=voList.size();
		
		/**���յ�������ѯ*/
		RiskPointVMSearchCondImpl riskPointCond = new RiskPointVMSearchCondImpl();
		riskPointCond.setSyscoding("999017");
		int riskCount = riskPointVMBL.searchRiskPointVM(riskPointCond, 0,0).size();
		/**���������*/
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
		log.debug("========��ѯ������¼��������========");
		return dto;
	}
}
