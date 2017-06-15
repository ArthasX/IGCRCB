/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 接待客人业务逻辑接口
 */
public interface RecptionGuestBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RecptionGuestSearchCond cond);
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RecptionGuestInfoCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rgid 接待ID
	 * @return 接待ID
	 */
	public RecptionGuest searchRecptionGuestByKey(Integer rgid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班接待信息
	 */
	public List<RecptionGuest> searchRecptionGuestAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionGuest> searchRecptionGuest(RecptionGuestSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RecptionGuest 登录数据
	 * @return 值班接待信息
	 */
	public RecptionGuest registRecptionGuest(RecptionGuest recptionguest) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rgid 接待ID
	 * @throws BLException
	 */
	public void deleteRecptionGuest(Integer rgid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param recptionguest 变更数据
	 * @return 值班接待信息
	 */
	public RecptionGuest updateRecptionGuest(RecptionGuest recptionguest) throws BLException;
   
	
	/**
	 * 接待客人查询画面
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RecptionGuestInfo> searchRecptionGuestInfo(RecptionGuestInfoCond cond, int start, int count);
}
