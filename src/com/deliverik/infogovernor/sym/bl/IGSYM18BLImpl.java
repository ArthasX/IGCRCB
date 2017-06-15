/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.entity.IG622TB;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;

/**
 * 概述: 首页管理逻辑实现
 * 功能描述：首页管理逻辑实现
 * 创建记录：崔学志    2012/11/14
 * 修改记录：
 */
@SuppressWarnings("deprecation")
public class IGSYM18BLImpl extends BaseBLImpl implements IGSYM18BL {

	static Log log = LogFactory.getLog(IGSYM18BLImpl.class);
	/** 首页管理bl*/
	private IG622BL ig622BL;
	/**
	 *首页管理bl 设定
	 *	
	 * @param ig622bl the ig622BL to set
	 */
	public void setIg622BL(IG622BL ig622bl) {
		ig622BL = ig622bl;
	}
	/**
	 * 首页管理查询全部
	 * 
	 */
	public IGSYM18DTO searchFirstJspInfoAction(IGSYM18DTO dto)
			throws BLException {
		log.debug("========首页管理查询处理开始========");
		List<IG622Info> list = ig622BL.searchIG622Info();
		List<IG622Info> list2 = new ArrayList<IG622Info>();
		for (IG622Info ig622Info : list) {
			//删除S运维首页
			if(!"S".equals(ig622Info.getHpid()))
			{
				list2.add(ig622Info);
			}
		}
		
		dto.setFirstJspInfoList(list2);
		log.debug("========首页管理查询处理终了========");
		return dto;
	}
	/**
	 * 首页管理 登记
	 */
	public IGSYM18DTO insertFirstJspInfoAction(IGSYM18DTO dto)
			throws BLException {
		log.debug("========首页管理登记处理开始========");
		String hpid = getHpid();
		IG622TB ig622info = ig622BL.getIG622TBInstance();
		try {
			BeanUtils.copyProperties(ig622info, dto.getIgSYM1802Form());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ig622info.setHpid(hpid);
		ig622BL.registIG622Info(ig622info);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "首页信息") );
		log.debug("========首页管理登记处理终了========");
		return dto;
	}
	/**
	 * 得到ig622最大值+1
	 *
	 *崔学志
	 *2012-11-14下午3:13:20
	 * @return
	 */
	private String getHpid()throws BLException {
		List<IG622Info> list = ig622BL.searchIG622Info();
		int max = 0;
		for (IG622Info ig622Info : list) {
			//判断是否是数字					
			if(NumberUtils.isNumber(ig622Info.getHpid()))
			{
				if(Integer.parseInt(ig622Info.getHpid()) > max)
				{
					max = Integer.parseInt(ig622Info.getHpid());
				}
			}			
		}
		//超过3位数 数据库存不下
		if(max > 1000)
		{
			throw new BLException("IGSYM0101.E002");
		}
		return String.valueOf(max+1);
	}
	/**
	 * 根据主键查询
	 */
	
	public IGSYM18DTO searchFirstJspInfoByPKAction(IGSYM18DTO dto)throws BLException  {
		log.debug("========首页管理查询处理开始========");
		//根据主键查询
		IG622Info info = ig622BL.searchIG622InfoByPK(dto.getIgSYM1802Form().getHpid());
		List<IG622Info> list = new ArrayList<IG622Info>();
		list.add(info);
		dto.setFirstJspInfoList(list);
		log.debug("========首页管理查询处理终了========");
		return dto;
	}
	/**
	 * 首页管理修改
	 */
	public IGSYM18DTO editFirstJspInfoAction(IGSYM18DTO dto) throws BLException {
		log.debug("========首页管理修改处理开始========");
		IG622TB ig622info = ig622BL.getIG622TBInstance();
		try {
			BeanUtils.copyProperties(ig622info, dto.getIgSYM1802Form());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ig622BL.updateIG622Info(ig622info);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "首页信息") );
		log.debug("========首页管理修改处理终了========");
		return dto;
	}
	/**
	 * 首页管理删除
	 */
	public IGSYM18DTO deleteFirstJspInfoAction(IGSYM18DTO dto) throws BLException {
		log.debug("========首页管理删除处理开始========");
		//根据主键
		ig622BL.deleteIG622InfoByPK(dto.getIgSYM1802Form().getHpid());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "首页信息") );
		log.debug("========首页管理删除处理终了========");
		return dto;
		
	}
	
	
}
