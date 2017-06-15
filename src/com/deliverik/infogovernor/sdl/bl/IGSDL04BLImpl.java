/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.sdl.bl.task.SdlInfoBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0402Form;
import com.deliverik.infogovernor.sdl.model.SdlInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息业务逻辑接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL04BLImpl extends BaseBLImpl implements IGSDL04BL {

	static Log log = LogFactory.getLog(IGSDL04BLImpl.class);

	/** 信息BL */
	protected SdlInfoBL sdlInfoBL;
	
	/** 附件BL */
	protected AttachmentBL attachmentBL;
	
	/** 上传附件BL */
	protected FileUploadBL fileUploadBL;

	public void setSdlInfoBL(SdlInfoBL sdlInfoBL) {
		this.sdlInfoBL = sdlInfoBL;
	}
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 信息查询处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoAction(IGSDL04DTO dto) throws BLException {

		log.debug("========信息查询处理开始========");
		
		//信息查询件数取得 
		int totalCount = this.sdlInfoBL.getSearchCount(dto.getSdlInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========信息查询数据不存在========");
			//信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========信息查询数据件数过多========");
			//信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<SdlInfo> sdlInfoList = this.sdlInfoBL.searchSdlInfo(dto.getSdlInfoSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSdlInfoList(sdlInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 信息详细信息处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoDetailAction(IGSDL04DTO dto) throws BLException{
		SdlInfo sdlinfo = this.sdlInfoBL.searchSdlInfoByKey(dto.getSiid());
		dto.setSdlInfo(sdlinfo);
		String attkey = sdlinfo.getSiattkey();
		if(StringUtils.isNotEmpty(attkey)){
			List<Attachment> attachmentList = this.attachmentBL.searchAttachmentsByAttkey(attkey);
			dto.setAttachmentList(attachmentList);
		}
		return dto;
	}

	/**
	 * 信息处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO insertSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========信息处理开始========");
		IGSDL0402Form form = (IGSDL0402Form)dto.getSdlInfo();
		try {
			form.setSifacttime(getBetweenTimeNumber(form.getSibegin(),form.getSiend()));
		} catch (Exception e) {
			throw new BLException("IGCO10000.E019");
		}
		form.setSidate(IGStringUtils.getCurrentDateTime());
		String attkey = this.uploadFile(form.getFileMap(),form.getSiattkey());
		form.setSiattkey(attkey);
		//信息处理
		this.sdlInfoBL.registSdlInfo(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "基本信息") );

		log.debug("========信息处理终了========");
		return dto;
	}

	/**
	 * 信息编辑画面初期显示处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO initSdlInfoAction(IGSDL04DTO dto) throws BLException {

		log.debug("========信息编辑画面初期显示处理开始========");
		
		IGSDL0402Form form = dto.getIgsdl0402Form();
		
		Integer sdiid = form.getSiid();
		
		//显示用信息取得
		SdlInfo sdlInfo = this.sdlInfoBL.searchSdlInfoByKey(sdiid);
		
		if ( sdlInfo == null ){
			throw new BLException("IGCO10000.E004","基本");
		}
		form.setSitype(sdlInfo.getSitype());//类别
		form.setSidesc(sdlInfo.getSidesc());// 说明
		form.setSibegin(sdlInfo.getSibegin());//开始时间
		form.setSiend(sdlInfo.getSiend());//结束时间
		form.setSimark(sdlInfo.getSimark());//评分
		form.setSieiid(sdlInfo.getSieiid());//相关资产ID
		form.setSieiname(sdlInfo.getSieiname());//相关资产名称
		form.setSiprid(sdlInfo.getSiprid());//相关流程ID
		form.setSiprtitle(sdlInfo.getSiprtitle());//相关流程名称
		form.setSiattkey(sdlInfo.getSiattkey());//附件
		form.setSidate(sdlInfo.getSidate());//日期
		form.setSifacttime(sdlInfo.getSifacttime());//实际时间
		
		//编辑模式设定
		form.setMode("1");
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","基本信息"));
		
		log.debug("========信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 信息更新处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO updateSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========信息更新处理开始========");
		IGSDL0402Form form = (IGSDL0402Form)dto.getSdlInfo();
		try {
			form.setSifacttime(getBetweenTimeNumber(form.getSibegin(),form.getSiend()));
		} catch (Exception e) {
			throw new BLException("IGCO10000.E019");
		}
		String attkey = this.uploadFile(form.getFileMap(),form.getSiattkey());
		
		form.setSiattkey(attkey);
		//信息更新处理
		this.sdlInfoBL.updateSdlInfo(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "基本信息") );
		
		log.debug("========信息更新处理终了========");
		return dto;
	}

	/**
	 * 信息删除处理
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO deleteSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteSdlInfoid().length;i++ ){
			String sdiid = dto.getDeleteSdlInfoid()[i];
			//信息删除处理
			this.sdlInfoBL.deleteSdlInfo(Integer.parseInt(sdiid));
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "基本信息") );
		log.debug("========信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 比较时间
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1小时=60分钟=3600秒=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;计算天数之差
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}
	
	/**
	 * <p>
	 * 检验用户是否上传了附件
	 * </p>
	 * 
	 * @param fileMap 存放附件的Map集合
	 * @return true-有附件，false-无附件
	 * @author liupeng@deliverik.com
	 */

	public boolean checkFileMap(Map<Integer, FormFile> fileMap) {
		return fileMap != null && fileMap.size() > 0 ? true : false;
	}
	
	/**
	 * <p>
	 * 上传附件操作，附件存入指定的文件夹中，附件名称的信息存入数据库
	 * </p>
	 * 
	 * @param fileMap 存放附件的Map集合
	 * @return 附件唯一标识attkey，没有附件返回null，与指定的历史记录关联
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public String uploadFile(Map<Integer, FormFile> fileMap ,String attkeyOld) throws BLException {
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		String attkey = null;
		boolean flag = true;
		if (checkFileMap(fileMap)) {
			if(attkeyOld != null && !"".equals(attkeyOld)){
				attkey = attkeyOld;
			}else{
				attkey = IGStringUtils.getAttKey();
			}
			Set<Entry<Integer, FormFile>> entries = fileMap.entrySet();
			Iterator<Entry<Integer, FormFile>> iterator = entries.iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, FormFile> entry = (Map.Entry<Integer, FormFile>) iterator
						.next();
				FormFile file = entry.getValue();
				if (file != null && file.getFileSize() > 0) {
					AttachmentTB attachment = attachmentBL
							.getAttachmentTBInstance();
					attachment.setAttkey(attkey);
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// 根目录
					pathBuilder.append(rootPath);
					// 一级菜单id
					pathBuilder.append("sdl").append(File.separator);
					// 文件上传处理
					try {
						fileUploadBL.saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
					// 上传文件名保存
					attachment.setAttname(attkey + "_" + file.getFileName());
					// 上传文件路径保存
					attachment.setAtturl("sdl");
					attachmentList.add(attachment);
				}
			}
			if (attachmentList.size() > 0) {
				attachmentBL.registAttachments(attachmentList);
				flag = false;
			}
		}
		return flag ? null : attkey;
	}


}
