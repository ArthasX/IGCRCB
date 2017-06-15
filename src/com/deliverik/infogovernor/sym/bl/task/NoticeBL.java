/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface NoticeBL extends BaseBL {
	
	/**
	 * ��ȡ֪ͨ��¼
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
	 * Description: ��ѯ��¼����
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
	 * Description: ͨ��������ѯ��Ӧ��¼
	 * </p>
	 */
	
	public Notice searchNoticeByKey(Integer nid);
	
	/**
	 * <p>
	 * Description: ����֪ͨ
	 * </p>
	 */
	
	public Notice registNotice(Notice notice) throws BLException;
	
	/**
	 * <p>
	 * Description: ɾ��֪ͨ
	 * </p>
	 */
	
	public void deleteNotice(Integer nid) throws BLException;
	
	/**
	 * <p>
	 * Description: ����֪ͨ
	 * </p>
	 */
	
	public Notice updateNotice(Notice notice) throws BLException;
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid);
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list);
	public List<DateWorkVWInfo> searchDateWorkInfo(String date, String userid, List<UserRoleInfo> list, String temp);
}
