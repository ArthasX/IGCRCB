/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02022VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD02BLImpl extends BaseBLImpl implements IGPRD02BL {
	
	/** ��־����ȡ�� */
	private static final Log log = LogFactory.getLog(IGPRD02BLImpl.class);
	
	/** �û���ɫBL */
	protected UserRoleBL userroleBL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ����BL */
	protected AttachmentBL attachmentBL;

	/**
	 * �û���ɫBL�趨
	 * @param userroleBL �û���ɫBL
	 */
	public void setUserroleBL(UserRoleBL userroleBL) {
		this.userroleBL = userroleBL;
	}
	
	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ����BL�趨
	 * @param attachmentBL ����BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �û���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO searchUserInfoList(IGPRD02DTO dto) throws BLException {
		log.debug("=============�û���ѯ������ʼ=============");
		//ҳ����Ϣȡ��
		IGPRD0201Form form = dto.getIgprd0201Form();
		//��ѯ���ý�ɫ
		List<IG001Info> allList = workFlowDefinitionBL.searchOARoleConfig(new IG001SearchCondImpl());
		List<Integer> roleids = null;
		if(allList!=null){
			for(IG001Info prd:allList){
				if(roleids==null){
					roleids = new ArrayList<Integer>();
				}
				roleids.add(prd.getProroleid());
			}
		}
		if(roleids==null){
			dto.getPagingDto().setTotalCount(0);
			log.debug("===========��ָ�����ý�ɫ=============");
			return dto;
		}
		//��ѯ�����趨
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setOrgid_like(form.getOrgid());
		cond.setRoleid_in(roleids);
		
		// ��ѯ��¼����
		int totalCount = userroleBL.getUserRoleVWSearchCount(cond);
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
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<UserRoleInfo> userroleList = userroleBL.searchUserRoleVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserroleList(userroleList);
		log.debug("=============�û���ѯ������ʼ=============");
		return dto;
	}
	
	
	/**
	 * ��ʼ�����̼�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO initProccessDefinitionInfoAction(IGPRD02DTO dto) throws BLException {
		log.debug("================��ʼ�����̼�����Ϣ������ʼ===============");
		//��ʼ������ͼ
		dto = initFlowChartAction(dto);
		//��ʼ��������Ϣ
		dto = initWorkFlowDefinitionAction(dto);
		log.debug("================��ʼ�����̼�����Ϣ��������===============");
		return dto;
	}

	private IGPRD02DTO initWorkFlowDefinitionAction(IGPRD02DTO dto) throws BLException{
		log.debug("=============��ʼ�����̼�����Ϣ������ʼ============");
		//dto����ȡ��
		String pdid = dto.getPdid();
		//��ѯ�ڵ���Ϣ
		IG333SearchCondImpl ig333_cond = new IG333SearchCondImpl();
		ig333_cond.setPdid(pdid);
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(ig333_cond);
		//������Ϣ���ϣ���IGPRD02022VO���洢ÿ��״̬�����ģ��ٴ��뼯�ϡ�
		List<IGPRD02022VO> rootList = new ArrayList<IGPRD02022VO>();
		//�洢״̬��Ӧ���
		Map<String, Integer> serMap = new HashMap<String, Integer>();
		//����״̬��Ϣ�����뼯��,����˳����Ų��ұ���
		for(int i=0;i<psdList.size();i++){
			IGPRD02022VO vo = new IGPRD02022VO();
			vo.setSerial(i);
			vo.setProcessStatusDefinition(psdList.get(i));
			serMap.put(psdList.get(i).getPsdid(), i);
			rootList.add(vo);
		}
		//��ѯ��������Ϣ
		IG222SearchCondImpl ig222_cond = new IG222SearchCondImpl();
		ig222_cond.setPdid(pdid);
		List<IG222Info> ppdList = workFlowDefinitionBL.searchParticipantDef(ig222_cond);
		//��������˼��ϣ����ڸ��ݽڵ�IDѰ�Ҳ�����
		Map<String, List<IG222Info>> ppdMap = new HashMap<String, List<IG222Info>>();
		for(IG222Info info:ppdList){
			if(ppdMap.get(info.getPsdid()) == null){
				ppdMap.put(info.getPsdid(), new ArrayList<IG222Info>());
			}
			ppdMap.get(info.getPsdid()).add(info);
		}
		//ԾǨ�����ѯ��ȷ��ǰ������
		IG273SearchCondImpl ig273_cond = new IG273SearchCondImpl();
		ig273_cond.setPtdid_like(pdid);
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ig273_cond);
		//����ԾǨ���򣬱��ڴӺ�ڵ��ҵ�ǰ�ڵ�
		Map<String, List<String>> ptdMap = new LinkedHashMap<String, List<String>>();
		for(IG273Info info:ptdList){
			if(ptdMap.get(info.getTpsdid()) == null){
				ptdMap.put(info.getTpsdid(), new ArrayList<String>());
			}
			ptdMap.get(info.getTpsdid()).add(info.getFpsdid());
		}
		//��ѯ��������Ϣ
		IG007SearchCondImpl ig007_cond = new IG007SearchCondImpl();
		ig007_cond.setPdid(pdid);
		ig007_cond.setPidtype("F");
		ig007_cond.setTableColumn("N");
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(ig007_cond);
		//�������ݣ����ڸ��ݱ�����ID���ұ�
		Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
		for(IG007Info info:pidList){
			pidMap.put(info.getPidid(), info);
		}
		//��ѯ��ȱʡȨ��
		IG699SearchCondImpl ig699_cond = new IG699SearchCondImpl();
		ig699_cond.setPdvid_like(pdid);
		List<IG699Info> pqdList = workFlowDefinitionBL.searchParticipantDefaultVariable(ig699_cond);
		//�������ݣ����ڸ���״̬����Ȩ��
		Map<String, List<String>> pqdMap = new LinkedHashMap<String, List<String>>();
		for(IG699Info info:pqdList){
			if(pqdMap.get(info.getPsdid()) == null){
				pqdMap.put(info.getPsdid(), new ArrayList<String>());
			}
			if(StringUtils.isNotEmpty(info.getPidaccess())){
				if(Integer.valueOf(info.getPidaccess()) > 1){
					pqdMap.get(info.getPsdid()).add(info.getPidid());
				}
			}
		}
		//��ѯ���̲���
		IG335SearchCondImpl ig335_cond = new IG335SearchCondImpl();
		ig335_cond.setPsdid_like(pdid);
		List<IG335Info> cldList = workFlowDefinitionBL.searchFormStrategy(ig335_cond);
		//�������ݣ����ڸ���״̬ID���ҵ�ǰ״̬����
		Map<String, List<IG335Info>> cldMap = new HashMap<String, List<IG335Info>>();
		for(IG335Info info : cldList){
			if(cldMap.get(info.getPsdid()) == null){
				cldMap.put(info.getPsdid(), new ArrayList<IG335Info>());
			}
			cldMap.get(info.getPsdid()).add(info);
		}
		for(IGPRD02022VO vo : rootList){
			//ȡ�õ�ǰ״̬�µĲ�����
			List<IG222Info> list = ppdMap.get(vo.getProcessStatusDefinition().getPsdid());
			Map<Role, List<User>> map = new LinkedHashMap<Role, List<User>>();
			if(list != null){
				for(IG222Info info : list){
					if(map.get(info.getRole()) == null){
						map.put(info.getRole(), new ArrayList<User>());
					}
					if(StringUtils.isNotEmpty(info.getUserid())){
						map.get(info.getRole()).add(info.getUser());
					}
				}
			}
			vo.setParticipantMap(map);
			//����ǰ������
			List<String> ptds = ptdMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(ptds != null){
				StringBuffer r = new StringBuffer();
				for(int i=0;i<ptds.size();i++){
					if(i > 0){
						r.append(",");
					}
					r.append(serMap.get(ptds.get(i)));
				}
				vo.setPrepositionTaskSerial(r.toString());
			}
			//���ø�����
			List<String> pqds = pqdMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(pqds != null){
				List<Attachment> attachmentList = new ArrayList<Attachment>(); 
				for(String pidid:pqds){
					IG007Info info = pidMap.get(pidid);
					if(info != null && StringUtils.isNotEmpty(info.getPiddefault())){
						List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(info.getPiddefault());
						if(attList != null){
							attachmentList.addAll(attList);
						}
					}
				}
				vo.setAttList(attachmentList);
			}
			//���ô���ʱ��
			List<IG335Info> clds = cldMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(clds != null){
				int size = clds.size();
				long f = 0;
				for(IG335Info info:clds){
					long d = ((long)info.getNotifyd()) * 24L * 60L;
					long h = ((long)info.getNotifyh()) * 60L;
					long m = info.getNotifym();
					f += d + h + m;
				}
				vo.setHandlingTime((f / size) + "");
			}
		}
		dto.setVoList(rootList);
		log.debug("=============��ʼ�����̼�����Ϣ��������============");
		return dto;
	}

	/**
	 * ��ʼ������ͼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	private IGPRD02DTO initFlowChartAction(IGPRD02DTO dto) throws BLException{
		log.debug("============��ʼ������ͼ������ʼ===========");
		//dto����ȡ��
		String pdid = dto.getPdid();
		//��ѯ���̶�����Ϣ
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
		dto.setProcessDefinition(pd);
		try {
			Document document = DocumentHelper.parseText(pd.getPdxml());
			Element root = document.getRootElement();
			int height = 0;
			for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
				Element next = steps.next();
				int y = Integer.valueOf(next.element("VMLProperties").attributeValue("y").replaceAll("px", ""));
				if(y > height){
					y = height;
				}
			}
			dto.setFlowChartXML(document.asXML().replaceAll("\"", "'"));
			dto.setFlowChartHeight(height + 120);
		} catch (DocumentException e) {
			log.error("",e);
		}
		log.debug("============��ʼ������ͼ��������===========");
		return dto;
	}
}

