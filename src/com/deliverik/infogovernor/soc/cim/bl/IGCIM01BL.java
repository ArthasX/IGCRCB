package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGCIM01BL extends BaseBL {


	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemAction(IGCIM01DTO dto) throws BLException;


	/**
	 * 设备配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 设备关系管理画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 设备关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 设备关系编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0307Action(IGCIM01DTO dto) throws BLException;


	/**
	 * 设备下发信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchNewAndReciveEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备上缴信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchUsingEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备报废信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchCanScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备批量下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGCIM01DTO dto) throws BLException;
	/**
	 * 设备上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGCIM01DTO dto) throws BLException;
	/**
	 * 查询指定eiid的待上缴设备
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityPayByEiidAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchPreScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchScrapEntityItemAction(IGCIM01DTO dto) throws BLException;
	
	public IGCIM01DTO searchReceiveEntityItemAction(IGCIM01DTO dto) throws BLException;
	public void entityCancelPreScrapBatchAction(IGCIM01DTO dto) throws BLException;
	public void entityPreScrapAction(IGCIM01DTO dto) throws BLException;
	public void entityScrapBatchAction(IGCIM01DTO dto) throws BLException;
	public void entityScrapAction(IGCIM01DTO dto) throws BLException;
	public void entityPreScrapBatchAction(IGCIM01DTO dto) throws BLException;
	
	public void entityCancelPreScrapAction(IGCIM01DTO dto) throws BLException;
	/**
	 *设备信息编辑画面初期显示处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initEntityItem(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备批量入库登记编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemLableAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomain(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 获取历史版本更新时间
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<SOC0128Info> getVersionUpdateTime(String eiid)throws BLException;
	
	/**
	 * 初始化资产配置信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO initXMLInfo(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 查看配置信息指定结点的信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO readXMLNodeInfo(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 比较2个版本配置信息XML中的数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareXMLInfoByVersion(IGCIM01DTO dto) throws BLException;
	

	/**
	 * 设备配置信息版本比较画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305ActionForXML(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306BelongAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEiBelongRelationListAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * 设备依赖关系登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemEiBelongRelationAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备依赖关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEiBelongRelationAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 设备关系树画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0346Action(IGCIM01DTO dto) throws BLException ;
	
	
	/**
	 * 设备关系树画面初期化处理(显示全树，顶级EI为根)
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0149Action(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * 包含树
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public IGCIM01DTO getContainTree0149Action(IGCIM01DTO dto) throws BLException;
	/**
	 * 设备配置信息编辑处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO editEntityItemAction(IGCIM01DTO dto) throws BLException,
	FileNotFoundException, IOException;
	/**
	 * 保存符合IG规范的XML文件中的数据
	 * @param filepath
	 * @param user
	 */
	public void insertIntoDBFromXMLFirst(IGCIM0104Form form,User user) throws BLException, FileNotFoundException, IOException;
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0104Action(IGCIM01DTO dto) throws BLException;

	/**
	 *设备信息修改处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItem(IGCIM01DTO dto)throws BLException;

	/**
	 * 
	 * @return 
	 */
	public IGCIM01DTO insertEntityItemRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 
	 * @return 
	 */
	public IGCIM01DTO updateEntityItemRelationAction(IGCIM01DTO dto);
	
	//add from igasm08bl
	//add from igasm08bl
	//add from igasm08bl
	
	/**
	 * 应用信息查询处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 应用信息登记处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 应用信息删除处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0124Action(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0148Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO editEntityItemActionApp(IGCIM01DTO dto) throws BLException,
	FileNotFoundException, IOException;
	
	public IGCIM01DTO editIGCIM0148ActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException;

	/**
	 * 应用配置信息历史记录画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0125Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用关系管理画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0126Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用关系删除处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用关系编辑画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0127Action(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用关系登记处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;

	/**
	 * 应用关系变更处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO updateEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	获取应用关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchRelationListActionApp(IGCIM01DTO dto) throws BLException;
	

	/**
	 *应用信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGCIM01DTO initEntityItemApp(IGCIM01DTO dto) throws BLException;
	/**
	 *应用信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGCIM01DTO updateEntityItemApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 获取应用编号最大值
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemLableActionApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是应用资产管理角色负责人
	 * 
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomainApp(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	获取FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchFSRelationListAction(IGCIM01DTO dto) throws BLException;
	
	/**
	 *	新增FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertFSRelationAction(IGCIM01DTO dto) throws BLException ;
	
	/**
	 *	删除FS关联关系处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteFSRelationAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 配置源数据版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getRciVersionsAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 当前最新版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCurrentNewCriVersionAction(IGCIM01DTO dto) throws BLException;

	/**
	 * 当前采集信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoList(IGCIM01DTO dto) throws BLException;

	/**
	 * 历史版本信息取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getHostoryVersions(IGCIM01DTO dto) throws BLException;

	/**
	 * 配置源数据多版本信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareVersionsAction(IGCIM01DTO dto) throws BLException;
	
	
	/**
	 * 设备关系树画面初期化处理
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGAIM0146Action(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * 包含树
	 *
	 * @param eibrList 节点集合
	 * @param ei 父级资产节点
	 * @param parNode 父级节点
	 */
	public IGCIM01DTO getContainTree(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * 获取当前某个命令下的所有采集结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand(IGCIM01DTO dto) throws BLException ;
	
	/**
	 * 命令详细对比结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand2(IGCIM01DTO dto) throws BLException;

	public IGCIM01DTO searchIGCIM0135Action(IGCIM01DTO dto)throws BLException;
	public IGCIM01DTO searchIGCIM0139Action(IGCIM01DTO dto) throws BLException ;
	public IGCIM01DTO searchIGCIM0140Action(IGCIM01DTO dto)throws BLException;

	public IGCIM01DTO searchIGCIM0136Action(IGCIM01DTO dto)throws BLException;

	public IGCIM01DTO initIGAIM0137Action(IGCIM01DTO dto)throws BLException;
	
	/**初始化查询指标*/
	public IGCIM01DTO initIGCIM0155Action(IGCIM01DTO dto) throws BLException ;

	/**
	 * 阜新拓扑，应用维护关系树
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO getBusinessTree(IGCIM01DTO dto) throws BLException;

	/**
	 * 阜新拓扑，应用关系登记初始化
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO initIGCIM0152Action(IGCIM01DTO dto) throws BLException;

	/**
	 *  阜新拓扑，应用关系登记处理
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp2(IGCIM01DTO dto) throws BLException;

	/**
	 * 关系类型查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchRelationType(IGCIM01DTO dto) throws BLException;
	
	/**
	 * 查找日志信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchSoc0153List(IGCIM01DTO dto)throws BLException;
	/**
	 * 查询网络设备端口状态
	 */
	public IGCIM01DTO searchIGCIM0911Action(IGCIM01DTO dto) throws BLException;
	
	
    /**
     *  资产自定义报表导出处理
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO exportReport(IGCIM01DTO dto) throws BLException;
    
    /**
	 * 查询倒入信息
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO searchSoc0113Info(IGCIM01DTO dto);
	/**
     *  获取resourceid
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getResid(IGCIM01DTO dto) throws BLException;

	public IGCIM01DTO searchSOC0118(IGCIM01DTO dto) throws BLException;
	
    /**
     *  获取资产相关流程
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getProcessByEiid(IGCIM01DTO dto) throws BLException;
    
    /**
     *  获取资产服务记录
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getMaintainByEiid(IGCIM01DTO dto) throws BLException;
    
    public IGCIM01DTO searchSOC0118ByHost(IGCIM01DTO dto) throws BLException;
}
