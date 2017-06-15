/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.vir.IGVIRCONSTANTS;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR13DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1302Form;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR13BLImpl extends BaseBLImpl implements IGVIR13BL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGVIR13BLImpl.class);
	
	/** vCenter����BL */
	protected VIM01BL vim01BL;
	
	/** vCenter����BL */
	protected VIMBL vimBL;
	
	/** vm��ϢBL */
	protected VIM03BL vim03BL;

	/**
	 * vCenter����BL�趨
	 * @param vim01BL vCenter����BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * vCenter����BL�趨
	 * @param vimBL vCenter����BL
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vm��ϢBL�趨
	 * @param vim03BL vm��ϢBL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	/**
	 * ��ѯvCenter��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVCenterAction(IGVIR13DTO dto) throws BLException {
		log.debug("============vCenter��Ϣ��ѯ������ʼ============");
		List<VIM01Info> list = vim01BL.searchVIM01();
		List<LabelValueBean> beanList = new ArrayList<LabelValueBean>();
		if(list != null && list.size() > 0){
			for(VIM01Info info:list){
				LabelValueBean bean = new LabelValueBean();
				bean.setLabel(info.getVcname());
				bean.setValue(info.getVcid() + "");
				beanList.add(bean);
			}
			dto.setLabelValueBeanList(beanList);
		}
		log.debug("============vCenter��Ϣ��ѯ��������============");
		return dto;
	}
	
	/**
	 * ��ȡ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO getHostsAction(IGVIR13DTO dto) throws BLException {
		log.debug("================��ȡ����������ʼ===============");
		//dto����ȡ��
		Integer vcid = dto.getVcid();
		List<Host> list = vimBL.searchHostByVcid(vcid);
		Set<String> hostnames = new LinkedHashSet<String>();
		for(Host host:list){
			hostnames.add(host.getName());
		}
		Gson gson = new Gson();
        String result = gson.toJson(hostnames);
        dto.setJsonResult(result);
        gson = null;
		log.debug("================��ȡ������������===============");
		return dto;
	}
	
	/**
	 * vm��Ϣ��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVMInfoAction(IGVIR13DTO dto) throws BLException {
		log.debug("===========vm��Ϣ��ѯ������ʼ==============");
		//dto����ȡ��
		String hostname = dto.getHostname();
		Integer vcid = dto.getVcid();
		//ʵ������ѯ����
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setStatus(IGVIRCONSTANTS.VM_STATUS_C);
		cond.setHostname(hostname);
		cond.setVcid(vcid);
		int totalCount = vim03BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		List<VIM03Info> list = vim03BL.searchVim03(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setVim03List(list);
		log.debug("===========vm��Ϣ��ѯ��������==============");
		return dto;
	}
	
	/**
	 * ��ʼ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO initVmInfoAction(IGVIR13DTO dto) throws BLException {
		log.debug("============��ʼ�����������Ϣ������ʼ============");
		//dto����ȡ��
		IGVIR1302Form form = dto.getIgvir1302Form();
		VIM03Info info = vim03BL.searchVim03ByPK(form.getId());
		this.copyProperties(form, info);
		log.debug("============��ʼ�����������Ϣ��������============");
		return dto;
	}
	
	/**
	 * �����Ϣ�༭
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO editVmInfoAction(IGVIR13DTO dto) throws BLException{
		log.debug("================�����Ϣ�༭������ʼ==============");
		//dto����ȡ��
		IGVIR1302Form form = dto.getIgvir1302Form();
		//��ѯ�����Ϣ
		VIM03TB entity = (VIM03TB) vim03BL.searchVim03ByPK(form.getId());
		entity.setUserid(form.getUserid());
		entity.setUserName(form.getUserName());
		entity.setOrgsyscoding(form.getOrgsyscoding());
		entity.setOrgname(form.getOrgname());
		entity.setIp(form.getIp());
		vim03BL.updateVim03(entity);
		log.debug("================�����Ϣ�༭��������==============");
		return dto;
	}
}
