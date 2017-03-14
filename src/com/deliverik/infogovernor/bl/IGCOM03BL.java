package com.deliverik.infogovernor.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.FsLvVgTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCondImpl;
import com.deliverik.infogovernor.dto.IGCOM03DTO;

/**
 * 查询HELP业务逻辑接口
 *
 *
 */
public interface IGCOM03BL extends BaseBL {


	/**
	 * 资产信息查询
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchEntityAction(IGCOM03DTO dto) throws BLException;

	/**
	 * 资产项信息查询
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchEntityItemAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 配置详细信息画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0303Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 配置详细信息画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0328Action(IGCOM03DTO dto) throws BLException;

	/**
	 * 数据详细信息画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0304Action(IGCOM03DTO dto) throws BLException;

	/**
	 * 数据详细信息查询处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO searchCodeDetailAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询关系图
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchRelationAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询资产模型名称
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchEntityNameAction(IGCOM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询资产模型名称
	 * </p>
	 * 
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	
	public IGCOM03DTO searchEntityNameActionSOC(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 资产配置项信息版本比较画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException
	 */
	public IGCOM03DTO initIGCOM0307Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 配置信息历史记录画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0308Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 配置信息历史记录画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCIM0147Action(IGCOM03DTO dto) throws BLException;
	
//	/**
//	 * 关系图查看关系画面初期化处理
//	 *
//	 * @param dto IGCOM03DTO
//	 * @return IGCOM03DTO
//	 */
//	public IGCOM03DTO initIGCOM0303RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * 根据传入的属性名称获取集合中该属性下全部内容组成的下拉列表
	 * @param srbList
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<LabelValueBean> getParContentList(List<FsLvVgTB> srbList,String name) throws Exception;
	
	/** 
     *  资产关系图画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0314Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 影响分析图画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0321Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 域拓扑图画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 * @throws BLException 
	 */
	public IGCOM03DTO initIGCOM0324Action(IGCOM03DTO dto) throws BLException;
	
	/**
	 * 配置信息显示画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO showConfigAction(IGCOM03DTO dto) throws BLException ;
	
	/**
	 * 资产项信息查询
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItemByEiid(IGCOM03DTO dto) throws BLException;    
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> searchSnapshotRelation(IGCOM03DTO dto)throws BLException;
	
	/**
	 * 关系图查看关系画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0319RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * 关系图查看关系画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0320RelationAction(IGCOM03DTO dto) throws Exception;
	
	/**
	 * 关系图查看关系画面初期化处理
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM03DTO initIGCOM0322RelationAction(IGCOM03DTO dto) throws Exception;
	/**
	 * 制作应该XML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createAppXml(SOC0121SearchCond  cond)throws Exception;
	/**
	 * 制作MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createMetaXml(SOC0121SearchCond  cond,String symid)throws Exception;
	
	/**
	 * 制作MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createXml(SOC0121SearchCond  meta_diskcond,SOC0121SearchCond  storage_Dacond,SOC0121SearchCond host_facond,String strStorageEilabel)throws Exception;

	/**
	 * 制作MetaXML
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public String createDiskXml(SOC0121SearchCond  meta_diskcond,SOC0121SearchCond  host_Diskcond,SOC0121SearchCondImpl app_hostcond)throws Exception;
	/**
	 * 资产项信息new查询
	 * 
	 * @param dto
	 *            IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCOM03DTO searchEntityItem0327Action(IGCOM03DTO dto) throws BLException;

	public IGCOM03DTO getEsyscodingList(IGCOM03DTO dto) throws BLException;

	public IGCOM03DTO searchSOC0118(IGCOM03DTO dto) throws BLException;

}
