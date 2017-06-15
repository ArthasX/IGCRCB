/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;


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

public interface NoticeBL extends BaseBL {
	
	/**
	 * 获取通知记录
	 * 
	 * @param cond NoticeSearchCond
	 * @param start int
	 * @param count int
	 * @return List<Notice>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public List<Notice> searchNotice(NoticeSearchCond cond, int start, int count) throws BLException;
	
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
	
	public int getSearchCount(NoticeSearchCond cond) throws BLException;
	
	/**
	 * <p>
	 * Description: 通过主键查询相应记录
	 * </p>
	 */
	
	public Notice searchNoticeByKey(Integer nid);
	
	/**
	 * <p>
	 * Description: 发布通知
	 * </p>
	 */
	
	public Notice registNotice(Notice notice) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除通知
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException;
	
	/**
	 * <p>
	 * Description: 更新通知
	 * </p>
	 */
	
	public Notice updateNotice(Notice notice) throws BLException;
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid);
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list);
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list, String temp);
}
