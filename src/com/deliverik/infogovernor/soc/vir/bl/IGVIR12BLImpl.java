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
 * ���⻯����ҵ���߼�ʵ��
 *
 */
public class IGVIR12BLImpl extends BaseBLImpl implements IGVIR12BL{

	static Log log = LogFactory.getLog(IGVIR12BLImpl.class);
	
	/** vCenter����BL */
	protected VIM01BL vim01BL;
	
	/** ���⻯����bl*/
	protected VIMBL vimBL;

	/**
	 * vCenter����BL�趨
	 * @param vim01BL vCenter����BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * ���⻯����bl�趨
	 * @param vimBL ���⻯����bl
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vCenter��host��Ϣȡ��
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getvCenterList(IGVIR12DTO dto) throws BLException {
		log.debug("========��ʼ========");
		return dto;
	}
	
	/**
	 * vCenter��host��Ϣȡ��
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
	 * �������߹ر����
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
	 * ʹ�������ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO initIGVIR1202Action(IGVIR12DTO dto) throws BLException {
		log.debug("==========��Դʹ�������ʼ��������ʼ==========");
		dto = searchVCenterConnectInfoAction(dto);
		if(dto.getVim01List() != null && dto.getVim01List().size() > 0){
			dto.setVcid(dto.getVim01List().get(0).getVcid());
		}
		//��ѯHost��Ϣ
		dto = searchHostInfoByVCenter(dto);
		log.debug("==========��Դʹ�������ʼ����������==========");
		return dto;
	}
	
	/**
	 * ָ��vCenterHost��Դʹ�������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO searchHostUsedAction(IGVIR12DTO dto) throws BLException {
		log.debug("===========ָ��vCenterHost��Դʹ�������ѯ������ʼ============");
		dto = searchVCenterConnectInfoAction(dto);
		//��ѯHost��Ϣ
		dto = searchHostInfoByVCenter(dto);
		log.debug("===========ָ��vCenterHost��Դʹ�������ѯ��������============");
		return dto;
	}
	
	/**
	 * ����vCenter��ѯHost��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR12DTO searchHostInfoByVCenter(IGVIR12DTO dto) throws BLException {
		log.debug("================����vCenter��ѯHost��Ϣ������ʼ===================");
		//dto����ȡ��
		Integer vcid = dto.getVcid();
		List<Host> hostList = vimBL.searchHostByVcid(vcid);
		dto.setHostList(hostList);
		log.debug("================����vCenter��ѯHost��Ϣ��������===================");
		return dto;
	}
	
	/**
	 * ��ѯ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGVIR12DTO searchVCenterConnectInfoAction(IGVIR12DTO dto) throws BLException{
		log.debug("==========������Ϣ��ѯ������ʼ==========");
		List<VIM01Info> list = vim01BL.searchVIM01();
		dto.setVim01List(list);
		log.debug("==========������Ϣ��ѯ��������==========");
		return dto;
	}
}
