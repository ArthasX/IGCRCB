package com.deliverik.infogovernor.soc.vir.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR07DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0702Form;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM01TB;

/**
 * ���⻯����ҵ���߼�ʵ��
 *
 */
public class IGVIR07BLImpl extends BaseBLImpl implements IGVIR07BL{

	static Log log = LogFactory.getLog(IGVIR07BLImpl.class);
	
	/** vCenter����BL */
	protected VIM01BL vim01BL;
	
	/**
	 * vCenter����BL
	 * @param vim01BL vCenter����BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}
	
	/**
	 * vCenter��Ϣ�������޸�
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO registVIM01(IGVIR07DTO dto) throws BLException {
		log.debug("========vCenter��Ϣ������ʼ========");
		IGVIR0702Form form = dto.getIgVIR0702Form();
		VIM01TB bean = new VIM01TB();
		bean.setVcname(form.getVcname());
		bean.setVcurl(form.getVcurl());
		bean.setVcusername(form.getVcusername());
		bean.setVcpassword(form.getVcpassword());
		if("0".equals(form.getMode())){
			vim01BL.registVIM01(bean);
		}else{
			bean.setVcid(form.getVcid());
			vim01BL.updateVIM01(bean);
		}
		log.debug("========vCenter��Ϣ��������========");
		return dto;
	}

	/**
	 * vCenter��Ϣȫ��ѯ
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO searchVIM01(IGVIR07DTO dto) throws BLException {
		log.debug("========vCenter��Ϣ������ʼ========");
		List<VIM01Info> vim01InfoList = vim01BL.searchVIM01();
		dto.setVim01InfoList(vim01InfoList);
		log.debug("========vCenter��Ϣ��������========");
		return dto;
	}
	
	/**
	 * vCenter��Ϣ������ѯ
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO searchVIM01ByPK(IGVIR07DTO dto) throws BLException {
		log.debug("========vCenter��Ϣ������ʼ========");
		IGVIR0702Form form = dto.getIgVIR0702Form();
		VIM01Info beanInfo = vim01BL.searchVIM01ByPK(form.getVcid());		
		form.setVcname(beanInfo.getVcname());
		form.setVcurl(beanInfo.getVcurl());
		form.setVcusername(beanInfo.getVcusername());
		form.setVcpassword(beanInfo.getVcpassword());
		log.debug("========vCenter��Ϣ��������========");
		return dto;
	}
	
	/**
	 * vCenter��Ϣ����ɾ��
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO deleteVIM01ByPK(IGVIR07DTO dto) throws BLException {
		log.debug("========vCenter��Ϣ������ʼ========");
		IGVIR0702Form form = dto.getIgVIR0702Form();
		vim01BL.deleteVIM01ByPK(form.getVcid());
		log.debug("========vCenter��Ϣ��������========");
		return dto;
	}
	
	/**
	 * URLΨһУ��
	 *
	 * @param dto IGVIR07DTO
	 * @return IGVIR07DTO
	 */
	public IGVIR07DTO checkVIM01ByURL(IGVIR07DTO dto) throws BLException {
		log.debug("========vCenter URLΨһУ�鿪ʼ========");
		IGVIR0702Form form = dto.getIgVIR0702Form();
		VIM01SearchCondImpl cond = new VIM01SearchCondImpl();
		cond.setVcurl(form.getVcurl());
		List<VIM01Info> VIM01list = vim01BL.searchVIM01(cond);
		if(VIM01list != null && VIM01list.size() > 0){
			dto.setUrlcheckflag("1");
		}else{
			dto.setUrlcheckflag("0");
		}
		log.debug("========vCenter URLΨһУ������========");
		return dto;
	}
	
}
