/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;

/**
 * @Description: 流程驱动业务逻辑接口
 * @Author  
 * @History 2010-9-13     新建 
 * 			2012-3-20	  新增  120320： 创意流程时，可以删除“提交”和“提交人确认”的附件
 * @Version V1.0
 */
public interface IGPRR01BL extends BaseBL {
	
	/**
	 * 流程发起页面初始化
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0101Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 流程发起页面初始化
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0102Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 *查看流程_角色信息查询处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchReadProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 页面初始化并确定该参与者在页面中可以进行的操作
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionList(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程跃迁 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO flow(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 发起流程 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO createProcessAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlAction(IGPRR01DTO dto) throws BLException;
	/**
	 * 组合场景流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchGroupFlowChartXml(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 获取执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchProcessExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO adjustExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 获取OA执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchAssignOAPersonAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: OA执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO assignOAPersonAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程状态日志查看 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO searchRecordStatusLogAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 流程跳转JSP取得
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchForwardJsp(IGPRR01DTO dto) throws Exception;
	
	/**
	 * <p>
	 * Description: 获取表单日志记录
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getVarRecordLogs(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 可参与流程角色取得
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessRoleListAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * 普通节点SUPER分派初始化
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0113Action(IGPRR01DTO dto) throws BLException;
	
	/**
	 * SUPER角色参与者分派处理
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantBySuper(IGPRR01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 通过流程id和login用户查询授权者
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getAuthorizeuser(IGPRR01DTO dto) throws BLException ;
	
	public IGPRR01DTO getRecordLogs(IGPRR01DTO dto) throws BLException;
	public IGPRR01DTO terminate(IGPRR01DTO dto) throws BLException;
	public Map<String,List<Attachment>> getProcessInfo(int prid) throws BLException;
	
	//====>120320Begin
	/**
	 * 删除附件信息
	 * 
	 * @param attid
	 * @param rlid
	 * @throws BLException
	 */
	public boolean deleteFile(Integer attid, Integer rlid) throws BLException;
	//====>120320End
	
	/**
	 * 指定状态可分派角色（包括用户）查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantDefToBeAssignAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * 指定状态可分派角色（不包括用户）查询
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchRoleDefToBeAssignAction(IGPRR01DTO dto) throws Exception;
	
	/**
	 * <p>
	 * Description: 普通用户调整执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO adjustExecutorsForNormalUserAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 分派保存执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO saveExecutorsAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 查询定义流程的排序ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchActionSortID(IGPRR01DTO dto) throws BLException;
	
	/**
     * <p>
     * Description: 取得流程自定义的分派页面URL信息
     * </p>
     * 
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     * @throws BLException
     * @update
     */
    
    public IGPRR01DTO getAssignPageAction(IGPRR01DTO dto) throws BLException;
    
    /**
     * 当前流程类型启用版本的PDID取得处理（7位的PDID取得处理）
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR01DTO searchPdid7BitAction(IGPRR01DTO dto) throws BLException;
	
	//====>130225Begin 
	/**
	 * 根据机构查询执行人
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException 
	 */
	public IGPRR01DTO searchProcessExecutor(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 将执行人添加为参与者
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO addProcessExecutor(IGPRR01DTO dto) throws BLException;
	//====>130225End
	
	/**
	 * 机构super改派
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantByOrgSuper(IGPRR01DTO dto) throws BLException;

	/**
	 * 取得流程参与人信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantInfoActon(IGPRR01DTO dto) throws BLException;

	/**
	 * 表单值复制
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO copyProcessInfoValueAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据流程ID查询关联了该流程的流程记录
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getProcessRecordByRelations(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 发起角色信息查询处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchInitProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 可调整参与者查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAdjustParticipantAction(List<IG333Info> lst_ProcessStatusDef, IGPRR01DTO dto) throws BLException;
	
	/**
	 * 可分派参与者查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAssignParticipantAction(IGPRR01DTO dto) throws BLException;

	/**
	 * 生成子流程的流程图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchChileFlowChartAction(IGPRR01DTO dto) throws BLException;
	/**
	 * 流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlActionForDrm(IGPRR01DTO dto) throws BLException;
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessInfoLog(IGPRR01DTO dto) throws BLException;
	
	/**
	 * 根据流程prid获取流程工单号
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchSerialNum(IGPRR01DTO dto) throws BLException;
}
