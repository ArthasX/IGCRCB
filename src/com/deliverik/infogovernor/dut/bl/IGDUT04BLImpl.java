/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.bl.task.DelayBL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0401Form;
import com.deliverik.infogovernor.dut.model.DelayInfo;

/**
 * ��ʱ����BLʵ��
 */
public class IGDUT04BLImpl extends BaseBLImpl implements IGDUT04BL {
	
	static Log log = LogFactory.getLog(IGDUT04BLImpl.class);

	/** ��ʱ����BL */
	protected DelayBL delayBL;
	
	/**
	 * ��ʱ����BL�趨
	 * @param delayBL
	 */
	public void setDelayBL(DelayBL delayBL) {
		this.delayBL = delayBL;
	}

	/**
	 * ��ʱ�����Ǽ�
	 * @param dto
	 * @return
	 */
	public IGDUT04DTO insertEntityAction(IGDUT04DTO dto) throws BLException{
		IGDUT0401Form form = dto.getIgdut0401Form();
		this.delayBL.registDelay(form);
		return dto;
	}

	/**
	 * ����������ʱ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO searchDelayByCond(IGDUT04DTO dto) throws BLException {
		int totalCount = this.delayBL.getSearchCount(dto.getDelaySearchCond());
		PagingDTO pDto = dto.getPagingDto();
		List<DelayInfo> delayList = this.delayBL.searchDelay(dto.getDelaySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		pDto.setTotalCount(totalCount);
		dto.setDelayList(delayList);
		return dto;
	}

	/**
	 * ��ʱ�������������ʾ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO initDelayAudit(IGDUT04DTO dto) throws BLException {
		log.debug("========��ʱ����������������ʾ����ʼ========");	
		IGDUT0401Form form = dto.getIgdut0401Form();
		DelayInfo delay = delayBL.searchDelayByPK(form.getId());
		
		//������ʾ�趨
		
		form.setDatetime(delay.getDatetime());
		form.setEndtime(delay.getEndtime());
		form.setHzname(delay.getHzname());
		form.setHztel(delay.getHztel());
		form.setId(delay.getId());
		form.setJlname(delay.getJlname());
		form.setJltel(delay.getJltel());
		form.setOperater(delay.getOperater());
		form.setOrgname(delay.getOrgname());
		form.setRemark(delay.getRemark());
		form.setStarttime(delay.getStarttime());
		form.setTitle(delay.getTitle());
		form.setUnlocktime(delay.getUnlocktime());
		form.setMode("1");

		dto.setIgdut0401Form(form);
		
		log.debug("========��ʱ����������������ʾ��������========");
		return dto;
	}

	/**
	 * ��ʱ�����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO updateDelayAuditAction(IGDUT04DTO dto) throws BLException {
		log.debug("========��ʱ�����������ʼ========");
		
		IGDUT0401Form form = dto.getIgdut0401Form();
		delayBL.updateDelay(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��ʱ������Ϣ") );
		
		log.debug("========��ʱ���������������========");
		return dto;
	}

	/**
	 * ��ʱ����ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO deleteDelayAction(IGDUT04DTO dto) throws BLException {
		log.debug("========��ʱ����ɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteId().length;i++ ){
			//��ʱ����ɾ������
			String id = dto.getDeleteId()[i];
			//����DAO��ѯ��������ʶ��ʵ�����
			DelayInfo delay = delayBL.searchDelayByPK(Integer.parseInt(id));
			//�������׳��쳣
			if (delay == null){
				throw new BLException("IGCO10000.E004","ɾ����ʱ��������");
			}
			delayBL.deleteDelay(delay);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "��ʱ������Ϣ"));
		log.debug("========��ʱ����ɾ����������========");
		return dto;
	}

	public IGDUT04DTO getTitle(IGDUT04DTO dto) throws BLException {
		List<LabelValueBean> titleList=new ArrayList<LabelValueBean>();
		LabelValueBean lvb=new LabelValueBean("","");
		titleList.add(lvb);
		lvb=new LabelValueBean("��ʱ","0");
		titleList.add(lvb);
		lvb=new LabelValueBean("����","1");
		titleList.add(lvb);
		dto.setTitleList(titleList);
		return dto;
	}

}
