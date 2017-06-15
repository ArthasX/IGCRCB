/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG899DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * 概述: 流程私有变量表业务逻辑实现
  * 功能描述: 流程私有变量表业务逻辑实现
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public class IG899BLImpl extends BaseBLImpl implements
		IG899BL {

	/** 流程私有变量表DAO接口 */
	protected IG899DAO ig899DAO;
	
	/** 流程变量BL */
	protected IG599BL ig599BL;
	
	/**
	 * 流程私有变量表DAO接口设定
	 *
	 * @param ig899DAO 流程私有变量表DAO接口
	 */
	public void setIg899DAO(IG899DAO ig899DAO) {
		this.ig899DAO = ig899DAO;
	}
	
	/**
	 * 流程变量BL设定
	 * 
	 * @param ig599BL 流程变量BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * 流程私有变量表实例取得
	 *
	 * @return 流程私有变量表实例
	 */
	public IG899TB getIG899TBInstance() {
		return new IG899TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG899Info> searchIG899Info() {
		return ig899DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG899Info searchIG899InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG899SearchCond cond) {
		return ig899DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond) {
		return ig899DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond, int start,
			int count) {
		return ig899DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param ig899Info 新增实例
	 * @return 新增实例
	 */
	public IG899Info registIG899Info(IG899Info ig899Info)
		throws BLException {
		return ig899DAO.save(ig899Info);
	}

	/**
	 * 修改处理
	 *
	 * @param ig899Info 修改实例
	 * @return 修改实例
	 */
	public IG899Info updateIG899Info(IG899Info ig899Info)
		throws BLException {
		checkExistInstance(ig899Info.getPpiid());
		return ig899DAO.save(ig899Info);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG899InfoByPK(Integer pk)
		throws BLException {
		ig899DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param ig899Info 删除实例
	 */
	public void deleteIG899Info(IG899Info ig899Info)
		throws BLException {
		ig899DAO.delete(ig899Info);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG899Info checkExistInstance(Integer pk)
		throws BLException {
		IG899Info instance = ig899DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 保存私有变量处理
	 * 
	 * @param ig899InfoList 表单变量集合
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException 
	 */
	public void registIG899Info(List<IG599Info> ig899InfoList, Integer roleid, String userid,String orgid) throws BLException {
		boolean flag = true;
		if(ig899InfoList == null || (roleid == null || roleid == 0) || StringUtils.isEmpty(userid)) {
			flag = false;
		}
		if(flag) {
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			for(IG599Info pi : ig899InfoList) {
				//判断是否私有变量
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pi.getPidaccess())
						&& IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(pi.getPidmode())) {
					cond.setPiid(pi.getPiid());
					cond.setPidid(pi.getPidid());
					cond.setRoleid(roleid);
					//范围是用户
					if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(pi.getPrivatescope())) {
						cond.setUserid(userid);
						cond.setRoleid(null);
						cond.setOrgid(null);
					} else if (IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(pi.getPrivatescope())){
						cond.setUserid(null);
						cond.setRoleid(roleid);
						cond.setOrgid(null);
					} else if (IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(pi.getPrivatescope())){
						cond.setUserid(null);
						cond.setOrgid(orgid);
						cond.setRoleid(null);
					}
					//检索该私有表单是否已保存过
					List<IG899Info> lst_ProcessPrivateInfo = this.searchIG899Info(cond);
					//没保存
					if(lst_ProcessPrivateInfo.isEmpty()) {
						//范围是角色
						IG899TB ppTB = this.getIG899TBInstance();
						ppTB.setPidid(pi.getPidid());
						ppTB.setPiid(pi.getPiid());
						ppTB.setPpiattkey(pi.getPiattkey());
						ppTB.setPpivalue(pi.getPivarvalue());
						ppTB.setPpicommect(pi.getPidcomment());
						//范围是用户
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equals(pi.getPrivatescope())) {
							ppTB.setUserid(userid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equals(pi.getPrivatescope())){
							ppTB.setRoleid(roleid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ORG.equals(pi.getPrivatescope())){
							ppTB.setOrgid(orgid);
						}
						//保存
						this.registIG899Info(ppTB);
					} else if(lst_ProcessPrivateInfo.size() == 1) {
//						如果已保存过，则判断是否值改变
//						if((pi.getPivarvalue()!= null && !pi.getPivarvalue().equals(lst_ProcessPrivateInfo.get(0).getPpivalue()))
//								|| (pi.getPiattkey()!= null && !pi.getPiattkey().equals(lst_ProcessPrivateInfo.get(0).getPpiattkey()))) {
							IG899TB ppTB = (IG899TB)SerializationUtils.clone(lst_ProcessPrivateInfo.get(0));
							ppTB.setPpivalue(pi.getPivarvalue());
							ppTB.setPpicommect(pi.getPidcomment());
							if(StringUtils.isEmpty(ppTB.getPpiattkey())){
								ppTB.setPpiattkey(pi.getPiattkey());
							}
							this.updateIG899Info(ppTB);
//						}
					} else {
						throw new BLException("IGCO10000.E004", pi.getPivarname() + "私有变量值");
					}
					
					//清空ProcessInfo中的值
					IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
					piTB.setPivarvalue(null);
					piTB.setPiattkey(null);
					piTB.setPidcomment(null);
					this.ig599BL.updateIG599Info(piTB);
				}
			}
		}
		else {
			throw new BLException("IGCO10000.E004", "私有变量保存处理参数");
		}
	}

}