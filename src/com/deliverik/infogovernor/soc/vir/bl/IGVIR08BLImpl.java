package com.deliverik.infogovernor.soc.vir.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByOrgVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByProjVWBL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03CountByUserVWBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR08DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0801Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0803Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0805Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;

/**
 * ���⻯����ҵ���߼�ʵ��
 *
 */
public class IGVIR08BLImpl extends BaseBLImpl implements IGVIR08BL{

	static Log log = LogFactory.getLog(IGVIR08BLImpl.class);
	
	/** ������Դͳ��BL */
	protected VIM03CountByUserVWBL vim03CountByUserVWBL;
	protected VIM03CountByOrgVWBL vim03CountByOrgVWBL;
	protected VIM03CountByProjVWBL vim03CountByProjVWBL;
	
	protected VIM03BL vim03BL;
	
	protected UserBL userBL;
	
	protected OrganizationBL organizationBL;

	/**
	 * ������Դͳ��BL�趨
	 * @param vim03CountByUserVWBL ������Դͳ��BL
	 */
	public void setVim03CountByUserVWBL(VIM03CountByUserVWBL vim03CountByUserVWBL) {
		this.vim03CountByUserVWBL = vim03CountByUserVWBL;
	}

	/**
	 * vim03CountByOrgVWBL�趨
	 * @param vim03CountByOrgVWBL vim03CountByOrgVWBL
	 */
	public void setVim03CountByOrgVWBL(VIM03CountByOrgVWBL vim03CountByOrgVWBL) {
		this.vim03CountByOrgVWBL = vim03CountByOrgVWBL;
	}

	/**
	 * vim03CountByProjVWBL�趨
	 * @param vim03CountByProjVWBL vim03CountByProjVWBL
	 */
	public void setVim03CountByProjVWBL(VIM03CountByProjVWBL vim03CountByProjVWBL) {
		this.vim03CountByProjVWBL = vim03CountByProjVWBL;
	}

	/**
	 * vim03BL�趨
	 * @param vim03BL vim03BL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	/**
	 * userBL�趨
	 * @param userBL userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * organizationBL�趨
	 * @param organizationBL organizationBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByUser(IGVIR08DTO dto) throws BLException {
		log.debug("========������Դͳ�Ʋ�ѯ��ʼ�����û���========");
		// ��ѯ��¼����
		IGVIR0801Form form = dto.getIgVIR0801Form();
		VIM03CountByUserVWSearchCondImpl cond = new VIM03CountByUserVWSearchCondImpl();
		cond.setUserid_like(form.getUserid_like());
		cond.setUsername_like(form.getUsername_like());
		cond.setOrgsyscoding_like(form.getOrgsyscoding_like());
		
		List<VIM03CountByUserVWInfo> listAll = vim03CountByUserVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// ��ѯ��¼����
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByUserVWInfo> vim03uList = vim03CountByUserVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		dto.setVim03uList(vim03uList);
		log.debug("========������Դͳ�Ʋ�ѯ���ˣ����û���========");
		return dto;
	}
	
	/**
	 * ������Դͳ��(���û�)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByUser(IGVIR08DTO dto) throws BLException{
		
//		User user = userBL.searchUserByKey(dto.getIgVIR0802Form().getUserid());
//		dto.setUser(user);
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setUserid_eq(dto.getIgVIR0802Form().getUserid());
		cond.setProgress_eq("100");
		List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
		dto.setOneVim03uList(vim03List);
		return dto;
	}
	
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByOrg(IGVIR08DTO dto) throws BLException {
		log.debug("========������Դͳ�Ʋ�ѯ��ʼ����������========");
		// ��ѯ��¼����
		IGVIR0803Form form = dto.getIgVIR0803Form();
		VIM03CountByOrgVWSearchCondImpl cond = new VIM03CountByOrgVWSearchCondImpl();
		cond.setOrgsyscoding_like(form.getOrgsyscoding_like());
		
		List<VIM03CountByOrgVWInfo> listAll = vim03CountByOrgVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// ��ѯ��¼����
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByOrgVWInfo> vim03oList = vim03CountByOrgVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		dto.setVim03oList(vim03oList);
		log.debug("========������Դͳ�Ʋ�ѯ���ˣ���������========");
		return dto;
	}
	
	/**
	 * ������Դͳ��(������)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03ByOrg(IGVIR08DTO dto) throws BLException{
//		OrganizationSearchCondImpl ocond = new OrganizationSearchCondImpl();
//		ocond.setOrgsyscoding(dto.getIgVIR0804Form().getOrgsyscoding());
//		ocond.setIs_in_use("1");
//		List<Organization> orgList = organizationBL.searchOrganization(ocond);
//		if(orgList != null && orgList.size() > 0){
//			Organization orgbean = orgList.get(0);
//			dto.setOrgbean(orgbean);
			
			Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
			cond.setOrgsyscoding_eq(dto.getIgVIR0804Form().getOrgsyscoding());
			cond.setProgress_eq("100");
			List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
			dto.setOneVim03oList(vim03List);
//		}
		
		return dto;
	}
	
	/**
	 * ������Դͳ��
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO searchVim03(IGVIR08DTO dto) throws BLException{
		String searchType = dto.getIgVIR0802Form().getSearchType();
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		if("ctrl".equals(dto.getIgVIR0802Form().getShowType())){
			if("user".equals(searchType)){
				cond.setUserid_eq(dto.getIgVIR0802Form().getUserid());
			}else if("org".equals(searchType)){
				cond.setOrgsyscoding_eq(dto.getIgVIR0802Form().getOrgsyscoding());
			}else if("proj".equals(searchType)){
				cond.setPid_eq(dto.getIgVIR0802Form().getPid_eq());
			}
		}else{
			if("user".equals(searchType)){
				cond.setUserid_eq(dto.getLoginUser().getUserid());
			}else if("org".equals(searchType)){
				cond.setOrgsyscoding_eq(dto.getLoginUser().getOrgid());
			}
		}
		cond.setProgress_eq("100");
		List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
		dto.setOneVim03List(vim03List);
		return dto;
	}
	
	/**
	 * ������Դͳ��(����Ŀ)
	 *
	 * @param dto IGVIR08DTO
	 * @return IGVIR08DTO
	 */
	public IGVIR08DTO getVim03CountByProj(IGVIR08DTO dto) throws BLException {
		log.debug("========������Դͳ�Ʋ�ѯ��ʼ������Ŀ��========");
		// ��ѯ��¼����
		IGVIR0805Form form = dto.getIgVIR0805Form();
		VIM03CountByProjVWSearchCondImpl cond = new VIM03CountByProjVWSearchCondImpl();
		cond.setPname_like(form.getPname_like());
		
		List<VIM03CountByProjVWInfo> listAll = vim03CountByProjVWBL.findByCond(cond, 0, 0);
		if(listAll == null || listAll.size() == 0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// ��ѯ��¼����
		int totalCount = listAll.size();
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		List<VIM03CountByProjVWInfo> vim03pList = vim03CountByProjVWBL.findByCond(cond,pDto.getFromCount(), pDto.getPageDispCount());
		dto.setVim03pList(vim03pList);
		log.debug("========������Դͳ�Ʋ�ѯ���ˣ�����Ŀ��========");
		return dto;
	}
}
