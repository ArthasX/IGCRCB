/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 延时解锁BL实现
 */
public class IGDUT04BLImpl extends BaseBLImpl implements IGDUT04BL {
	
	static Log log = LogFactory.getLog(IGDUT04BLImpl.class);

	/** 延时解锁BL */
	protected DelayBL delayBL;
	
	/**
	 * 延时解锁BL设定
	 * @param delayBL
	 */
	public void setDelayBL(DelayBL delayBL) {
		this.delayBL = delayBL;
	}

	/**
	 * 延时解锁登记
	 * @param dto
	 * @return
	 */
	public IGDUT04DTO insertEntityAction(IGDUT04DTO dto) throws BLException{
		IGDUT0401Form form = dto.getIgdut0401Form();
		this.delayBL.registDelay(form);
		return dto;
	}

	/**
	 * 条件检索延时解锁信息
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
	 * 延时解锁变更初期显示处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO initDelayAudit(IGDUT04DTO dto) throws BLException {
		log.debug("========延时解锁变更画面初期显示处理开始========");	
		IGDUT0401Form form = dto.getIgdut0401Form();
		DelayInfo delay = delayBL.searchDelayByPK(form.getId());
		
		//画面显示设定
		
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
		
		log.debug("========延时解锁变更画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 延时解锁变更处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO updateDelayAuditAction(IGDUT04DTO dto) throws BLException {
		log.debug("========延时解锁变更处理开始========");
		
		IGDUT0401Form form = dto.getIgdut0401Form();
		delayBL.updateDelay(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "延时解锁信息") );
		
		log.debug("========延时解锁变更处理终了========");
		return dto;
	}

	/**
	 * 延时解锁删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO deleteDelayAction(IGDUT04DTO dto) throws BLException {
		log.debug("========延时解锁删除处理开始========");
		//循环删除
		for( int i=0;i<dto.getDeleteId().length;i++ ){
			//延时解锁删除主键
			String id = dto.getDeleteId()[i];
			//调用DAO查询该主键标识的实体对象
			DelayInfo delay = delayBL.searchDelayByPK(Integer.parseInt(id));
			//不存在抛出异常
			if (delay == null){
				throw new BLException("IGCO10000.E004","删除延时解锁基本");
			}
			delayBL.deleteDelay(delay);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "延时解锁信息"));
		log.debug("========延时解锁删除处理终了========");
		return dto;
	}

	public IGDUT04DTO getTitle(IGDUT04DTO dto) throws BLException {
		List<LabelValueBean> titleList=new ArrayList<LabelValueBean>();
		LabelValueBean lvb=new LabelValueBean("","");
		titleList.add(lvb);
		lvb=new LabelValueBean("延时","0");
		titleList.add(lvb);
		lvb=new LabelValueBean("解锁","1");
		titleList.add(lvb);
		dto.setTitleList(titleList);
		return dto;
	}

}
