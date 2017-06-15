/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCondImpl;
import com.deliverik.infogovernor.sym.model.dao.DateWorkVWDAO;
import com.deliverik.infogovernor.sym.model.dao.NoticeTBDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class NoticeBLImpl extends BaseBLImpl implements NoticeBL {
	
	/**
	 * 通知相关操作DAO
	 */
	
	protected NoticeTBDAO noticeTBDAO;
	protected DateWorkVWDAO dateWorkVWDAO;

	/**
	 * 设置NoticeTBDAO
	 * @param noticeTBDAO NoticeTBDAO
	 */
	
	public void setNoticeTBDAO(NoticeTBDAO noticeTBDAO) {
		this.noticeTBDAO = noticeTBDAO;
	}
	public void setDateWorkVWDAO(DateWorkVWDAO dateWorkVWDAO) {
		this.dateWorkVWDAO = dateWorkVWDAO;
	}
	
	/**
	 * <p>
	 * Description: 查询记录总数
	 * </p>
	 * 
	 * @param cond NoticeSearchCond
	 * @return int
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public int getSearchCount(NoticeSearchCond cond){
		return noticeTBDAO.getSearchCount(cond);
	}
	
	/**
	 * <p>
	 * Description: 通知查询
	 * </p>
	 * 
	 * @param cond NoticeSearchCond
	 * @param start int
	 * @param count int
	 * @return List<Notice>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public List<Notice> searchNotice(NoticeSearchCond cond, int start, int count){
		List<Notice> ret = noticeTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * <p>
	 * Description: 删除通知
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException {
		Notice notice = checkExistNotice(nid);
		noticeTBDAO.delete(notice);
	}
	

	/**
	 * <p>
	 * Description: 发布通知
	 * </p>
	 */
	
	public Notice registNotice(Notice notice) throws BLException {
		Notice ret = noticeTBDAO.save(notice);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 通过主键查询相应记录
	 * </p>
	 */
	
	public Notice searchNoticeByKey(Integer nid) {
		Notice ret = noticeTBDAO.findByPK(nid);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 更新通知
	 * </p>
	 */
	
	public Notice updateNotice(Notice notice) throws BLException {
		checkExistNotice(notice.getNid());
		Notice ret = noticeTBDAO.save(notice);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: 查询是否存在该主键ID的通知
	 * </p>
	 */
	protected Notice checkExistNotice(Integer nid) throws BLException{
		Notice info = noticeTBDAO.findByPK(nid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","通知基本");
		}
		
		return info;
	}
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid){
		NoticeSearchCondImpl nsc = new NoticeSearchCondImpl();
		nsc.setDate(date);
		nsc.setUserid(userid);
		List<DateWorkVWInfo> info = dateWorkVWDAO.findByCond(nsc);
		return info;
	}
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list){
		NoticeSearchCondImpl nsc = new NoticeSearchCondImpl();
		nsc.setDate(date);
		nsc.setUserid(userid);
		List<DateWorkVWInfo> info = dateWorkVWDAO.findByCond(nsc, list);
		return info;
	}
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list, String temp){
		NoticeSearchCondImpl nsc = new NoticeSearchCondImpl();
		nsc.setDate(date);
		nsc.setUserid(userid);
		List<DateWorkVWInfo> info = dateWorkVWDAO.findByCond(nsc, list, "");
		return info;
	}
}
