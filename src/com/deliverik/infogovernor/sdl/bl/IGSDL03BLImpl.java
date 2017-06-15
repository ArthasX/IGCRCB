/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.bl.task.SdlDefineInfoBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0302Form;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_Ŀ��ҵ���߼��ӿ�ʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL03BLImpl extends BaseBLImpl implements IGSDL03BL {

	static Log log = LogFactory.getLog(IGSDL03BLImpl.class);

	/** Ŀ����ϢBL */
	protected SdlDefineInfoBL sdlDefineInfoBL;
	

	public void setSdlDefineInfoBL(SdlDefineInfoBL sdlDefineInfoBL) {
		this.sdlDefineInfoBL = sdlDefineInfoBL;
	}

	/**
	 * Ŀ����Ϣ��ѯ����
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO searchSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {

		log.debug("========Ŀ����Ϣ��ѯ����ʼ========");
		
		//Ŀ����Ϣ��ѯ����ȡ�� 
		int totalCount = this.sdlDefineInfoBL.getSearchCount(dto.getSdlDefineInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ŀ����Ϣ��ѯ���ݲ�����========");
			//Ŀ����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ŀ����Ϣ��ѯ���ݼ�������========");
			//Ŀ����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳĿ����Ϣȡ��
		List<SdlDefineInfo> sdlDefineInfoList = this.sdlDefineInfoBL.searchSdlDefineInfo(dto.getSdlDefineInfoSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSdlDefineInfoList(sdlDefineInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ŀ����Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * Ŀ����Ϣ�ǼǴ���
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO insertSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========Ŀ����Ϣ�ǼǴ���ʼ========");
		
		//Ŀ����Ϣ�ǼǴ���
		this.sdlDefineInfoBL.registSdlDefineInfo(dto.getSdlDefineInfo());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "Ŀ�������Ϣ") );

		log.debug("========Ŀ����Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * Ŀ����Ϣ�༭���������ʾ����
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO initSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {

		log.debug("========Ŀ����Ϣ�༭���������ʾ����ʼ========");
		
		IGSDL0302Form form = dto.getIgsdl0302Form();
		
		Integer sdiid = form.getSdiid();
		
		//��ʾ��Ŀ����Ϣȡ��
		SdlDefineInfo sdlDefineInfo = this.sdlDefineInfoBL.searchSdlDefineInfoByKey(sdiid);
		
		if ( sdlDefineInfo == null ){
			throw new BLException("IGCO10000.E004","Ŀ�����");
		}
		form.setSdiyear(sdlDefineInfo.getSdiyear());//���
		form.setSdieiid(sdlDefineInfo.getSdieiid());// ����ʲ�ID
		form.setSdieiname(sdlDefineInfo.getSdieiname());//�ʲ�����
		form.setSdibreakm(sdlDefineInfo.getSdibreakm());// ���ж�ʱ��
		form.setSdibreaky(sdlDefineInfo.getSdibreaky());//���ж�ʱ��
		form.setSdicontinuousm(sdlDefineInfo.getSdicontinuousm());//������ʱ��ٷֱ�
		form.setSdicontinuousy(sdlDefineInfo.getSdicontinuousy());//������ʱ��ٷֱ�
		form.setSdiimpactm(sdlDefineInfo.getSdiimpactm());//��Ӱ��ʱ��
		form.setSdiimpacty(sdlDefineInfo.getSdiimpacty());//��Ӱ��ʱ��
		form.setSdisteadym(sdlDefineInfo.getSdisteadym());//���ȶ�ʱ��ٷֱ�
		form.setSdisteadyy(sdlDefineInfo.getSdisteadyy());//���ȶ�ʱ��ٷֱ�
		form.setSdisafecasem(sdlDefineInfo.getSdisafecasem());//�°�ȫ�¼�����
		form.setSdisafecasey(sdlDefineInfo.getSdisafecasey());//�갲ȫ�¼�����
		form.setSdisafemarkm(sdlDefineInfo.getSdisafemarkm());//�°�ȫ�¼�����
		form.setSdisafemarky(sdlDefineInfo.getSdisafemarky());//�갲ȫ�¼�����
		form.setSdiriskmarkm(sdlDefineInfo.getSdiriskmarkm());//�·��ռ������
		form.setSdiriskmarky(sdlDefineInfo.getSdiriskmarky());//����ռ������
		form.setSdicapacitycasem(sdlDefineInfo.getSdicapacitycasem());//�������¼�����
		form.setSdicapacitycasey(sdlDefineInfo.getSdicapacitycasey());//�������¼�����
		form.setSdicapacitymarkm(sdlDefineInfo.getSdicapacitymarkm());//�������¼�����
		form.setSdicapacitymarky(sdlDefineInfo.getSdicapacitymarky());//�������¼�����
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","Ŀ�������Ϣ"));
		
		log.debug("========Ŀ����Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * Ŀ����Ϣ���´���
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO updateSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========Ŀ����Ϣ���´���ʼ========");
		
		//Ŀ����Ϣ���´���
		this.sdlDefineInfoBL.updateSdlDefineInfo(dto.getSdlDefineInfo());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "Ŀ�������Ϣ") );
		
		log.debug("========Ŀ����Ϣ���´�������========");
		return dto;
	}

	/**
	 * Ŀ����Ϣɾ������
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO deleteSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========Ŀ����Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteSdlDefineInfoid().length;i++ ){
			String sdiid = dto.getDeleteSdlDefineInfoid()[i];
			//Ŀ����Ϣɾ������
			this.sdlDefineInfoBL.deleteSdlDefineInfo(Integer.parseInt(sdiid));
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "Ŀ�������Ϣ") );
		log.debug("========Ŀ����Ϣɾ����������========");
		return dto;
	}

}
