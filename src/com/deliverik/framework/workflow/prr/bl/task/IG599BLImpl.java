/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG599DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * <p>概述:流程变量信息业务逻辑实现</p>
 * <p>功能描述：1.登入或更新流程变量</p>
 * <p>          2.登入流程变量</p>
 * <p>          3.保存流程变量参数值</p>
 * <p>          4.更新流程变量参数值</p>
 * <p>          5.更新流程变量参数值(批量更新)</p>
 * <p>          6.根据流程记录ID获取流程变量参数值信息集合</p>
 * <p>          7.自定义流程关闭状态变量信息集合取得</p>
 * <p>          8.根据查询条件获取流程变量参数值信息集合</p>
 * <p>          9.根据流程变量ID获取流程变量参数值信息集合</p>
 * <p>          10.获取附件实例</p>
 * <p>          11.流程变量参数值信息存在检查</p>
 * <p>创建记录：</p>
 */
public class IG599BLImpl extends BaseBLImpl implements IG599BL {

	/** 流程变量业务逻辑DAO*/
	protected IG599DAO ig599DAO;

	/**
	 * 流程变量业务逻辑DAO
	 * 
	 * @param ig599DAO 流程变量业务逻辑DAO
	 */
	public void setIg599DAO(IG599DAO ig599DAO) {
		this.ig599DAO = ig599DAO;
	}

	/**
	 * 功能：登入或更新流程变量
	 * @param 流程变量List
	 * @return 流程变量List
	 * @throws BLException
	 */
	public List<IG599Info> saveOrUpdIG599Infos(List<IG599Info> prInfoList)
			throws BLException {
		List<IG599Info> newList = new ArrayList<IG599Info>();
		String pidaccess = null;
		for(IG599Info pi : prInfoList){
			pidaccess = pi.getPidaccess();
			IG599TB processInfo = (IG599TB)ig599DAO.save(pi);
			processInfo.setPidaccess(pidaccess);
			newList.add(processInfo);
		}
		
		return newList;
		//ig599DAO.saveOrUpdateAll(prInfoList);
	}

	/**
	 * 功能：登入流程变量
	 * @param IG599Info 流程变量
	 * @return ProcessInfo 流程变量
	 */
	public IG599Info saveIG599Info(IG599Info prInfo)
			throws BLException {
		return ig599DAO.save(prInfo);
	}

	/**
	 * 功能：保存流程变量参数值
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public void registIG599Infos(List<IG599Info> ig599InfoList) throws BLException{
		ig599DAO.saveOrUpdateAll(ig599InfoList);
	}
	
	/**
	 * 功能：更新流程变量参数值
	 * @param 流程变量参数值
	 * @throws BLException
	 */
	public void updateIG599Info(IG599Info pi) throws BLException{
		ig599DAO.save(pi);
	}
	
	/**
	 * 功能：更新流程变量参数值（批量更新）
	 * @param 流程变量参数值集合
	 * @throws BLException
	 */
	public void updateIG599Infos(List<IG599Info> ig599InfoList) throws BLException{
		ig599DAO.saveOrUpdateAll(ig599InfoList);
	}
	
	/**
	 * 功能：根据流程记录ID获取流程变量参数值信息集合
	 * @param 流程ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchIG599InfosByKey(Integer processId){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(processId);
		List<IG599Info> prInfoList = ig599DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	/**
	 * 根据查询条件获取流程变量参数值信息集合
	 * @param 流程变量参数值信息集合
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByCond(IG599SearchCond cond){
		List<IG599Info> prInfoList = ig599DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	
	/**
	 * 功能：根据流程变量ID获取流程变量参数值信息集合
	 * @param piid 流程变量ID
	 * @throws BLException 
	 */
	public IG599Info searchIG599InfoByPiid(Integer piid) throws BLException{
		return checkExistProcessInfo(piid);
	}
	
	/**
	 * 功能：获取附件实例
	 * 
	 * @return ProcessInfoTB
	 */
	
	public IG599TB getIG599TBInstance(){
		return new IG599TB();
	}
	
	/**
	 * 功能：流程变量参数值信息存在检查
	 * 
	 * @param piid 流程变量ID
	 * @return 流程变量参数值信息
	 * @throws BLException 
	 */
	private IG599Info checkExistProcessInfo(Integer piid) throws BLException{
		IG599Info info = ig599DAO.findByPK(piid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程变量参数值基本");
		}
		
		return info;
	}
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchIG599InfoForClose(Integer prid, String pdid, String userid){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);
		cond.setPdid(pdid);
		cond.setUserid(userid);
		List<IG599Info> prInfoList = ig599DAO.searchIG599InfoForClose(cond);
		return prInfoList;
	}
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchIG599InfoForSee(Integer prid, String pdid, String userid){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);
		cond.setPdid(pdid);
		cond.setUserid(userid);
		List<IG599Info> prInfoList = ig599DAO.searchIG599InfoForSee(cond);
		return prInfoList;
	}
	
	
	/**
	 * 功能：查询当前最大流水号
	 * @param prserialnum 流水号
	 * @param label 名称
	 * @return 最大流水号
	 */
	public String searchMaxSerialnum(String serialnum, String label) {
		String strSerialnum = ig599DAO.searchMaxSerialnum(serialnum, label);
		return strSerialnum;
	}
}
