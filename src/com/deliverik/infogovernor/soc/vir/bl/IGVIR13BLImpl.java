/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR13BLImpl extends BaseBLImpl implements IGVIR13BL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGVIR13BLImpl.class);
	
	/** vCenter连接BL */
	protected VIM01BL vim01BL;
	
	/** vCenter操作BL */
	protected VIMBL vimBL;
	
	/** vm信息BL */
	protected VIM03BL vim03BL;

	/**
	 * vCenter连接BL设定
	 * @param vim01BL vCenter连接BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * vCenter操作BL设定
	 * @param vimBL vCenter操作BL
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vm信息BL设定
	 * @param vim03BL vm信息BL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

	/**
	 * 查询vCenter信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVCenterAction(IGVIR13DTO dto) throws BLException {
		log.debug("============vCenter信息查询操作开始============");
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
		log.debug("============vCenter信息查询操作结束============");
		return dto;
	}
	
	/**
	 * 获取主机操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO getHostsAction(IGVIR13DTO dto) throws BLException {
		log.debug("================获取主机操作开始===============");
		//dto参数取得
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
		log.debug("================获取主机操作结束===============");
		return dto;
	}
	
	/**
	 * vm信息查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO searchVMInfoAction(IGVIR13DTO dto) throws BLException {
		log.debug("===========vm信息查询操作开始==============");
		//dto参数取得
		String hostname = dto.getHostname();
		Integer vcid = dto.getVcid();
		//实例化查询条件
		Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
		cond.setStatus(IGVIRCONSTANTS.VM_STATUS_C);
		cond.setHostname(hostname);
		cond.setVcid(vcid);
		int totalCount = vim03BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<VIM03Info> list = vim03BL.searchVim03(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setVim03List(list);
		log.debug("===========vm信息查询操作结束==============");
		return dto;
	}
	
	/**
	 * 初始化虚机信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO initVmInfoAction(IGVIR13DTO dto) throws BLException {
		log.debug("============初始化虚机配置信息操作开始============");
		//dto参数取得
		IGVIR1302Form form = dto.getIgvir1302Form();
		VIM03Info info = vim03BL.searchVim03ByPK(form.getId());
		this.copyProperties(form, info);
		log.debug("============初始化虚机配置信息操作结束============");
		return dto;
	}
	
	/**
	 * 虚机信息编辑
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR13DTO editVmInfoAction(IGVIR13DTO dto) throws BLException{
		log.debug("================虚机信息编辑操作开始==============");
		//dto参数取得
		IGVIR1302Form form = dto.getIgvir1302Form();
		//查询虚机信息
		VIM03TB entity = (VIM03TB) vim03BL.searchVim03ByPK(form.getId());
		entity.setUserid(form.getUserid());
		entity.setUserName(form.getUserName());
		entity.setOrgsyscoding(form.getOrgsyscoding());
		entity.setOrgname(form.getOrgname());
		entity.setIp(form.getIp());
		vim03BL.updateVim03(entity);
		log.debug("================虚机信息编辑操作结束==============");
		return dto;
	}
}
