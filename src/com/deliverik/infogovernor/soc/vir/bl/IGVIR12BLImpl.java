package com.deliverik.infogovernor.soc.vir.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * 虚拟化管理业务逻辑实现
 *
 */
public class IGVIR12BLImpl extends BaseBLImpl implements IGVIR12BL{

	static Log log = LogFactory.getLog(IGVIR12BLImpl.class);
	
	/** vCenter管理BL */
	protected VIM01BL vim01BL;
	
	/** 虚拟化管理bl*/
	protected VIMBL vimBL;

	/**
	 * vCenter管理BL设定
	 * @param vim01BL vCenter管理BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * 虚拟化管理bl设定
	 * @param vimBL 虚拟化管理bl
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vCenter、host信息取得
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getvCenterList(IGVIR12DTO dto) throws BLException {
		log.debug("========开始========");
		return dto;
	}
	
	/**
	 * vCenter、host信息取得
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getHostInfo(IGVIR12DTO dto) throws BLException {
		String treeId = dto.getTreeId();
		String[] tree_id = treeId.split("_",2);
    	Integer vcid = Integer.parseInt(tree_id[0]);
    	String hostname = tree_id[1];
    	Host host = vimBL.getHostInfo(vcid, hostname);
    	dto.setHost(host);
		return dto;
	}

	/**
	 * 启动或者关闭虚机
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO startOrStopPowerOfVM(IGVIR12DTO dto) throws BLException {
		String treeId = dto.getTreeId();
		String[] tree_id = treeId.split("_",2);
    	Integer vcid = Integer.parseInt(tree_id[0]);
    	String hostname = tree_id[1];
    	vimBL.oprateVM(vcid, hostname, dto.getVmName(), dto.getOprateType());
		return dto;
	}
	
	/**
	 * 使用情况初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO initIGVIR1202Action(IGVIR12DTO dto) throws BLException {
		log.debug("==========资源使用情况初始化操作开始==========");
		dto = searchVCenterConnectInfoAction(dto);
		if(dto.getVim01List() != null && dto.getVim01List().size() > 0){
			dto.setVcid(dto.getVim01List().get(0).getVcid());
		}
		//查询Host信息
		dto = searchHostInfoByVCenter(dto);
		log.debug("==========资源使用情况初始化操作结束==========");
		return dto;
	}
	
	/**
	 * 指定vCenterHost资源使用情况查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO searchHostUsedAction(IGVIR12DTO dto) throws BLException {
		log.debug("===========指定vCenterHost资源使用情况查询操作开始============");
		dto = searchVCenterConnectInfoAction(dto);
		//查询Host信息
		dto = searchHostInfoByVCenter(dto);
		log.debug("===========指定vCenterHost资源使用情况查询操作结束============");
		return dto;
	}
	
	/**
	 * 根据vCenter查询Host信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR12DTO searchHostInfoByVCenter(IGVIR12DTO dto) throws BLException {
		log.debug("================根据vCenter查询Host信息操作开始===================");
		//dto参数取得
		Integer vcid = dto.getVcid();
		List<Host> hostList = vimBL.searchHostByVcid(vcid);
		dto.setHostList(hostList);
		log.debug("================根据vCenter查询Host信息操作结束===================");
		return dto;
	}
	
	/**
	 * 查询连接信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR12DTO searchVCenterConnectInfoAction(IGVIR12DTO dto) throws BLException{
		log.debug("==========连接信息查询操作开始==========");
		List<VIM01Info> list = vim01BL.searchVIM01();
		dto.setVim01List(list);
		log.debug("==========连接信息查询操作结束==========");
		return dto;
	}
}
