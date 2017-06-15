/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��Ϣҵ���߼��ӿ�ʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL04BLImpl extends BaseBLImpl implements IGSDL04BL {

	static Log log = LogFactory.getLog(IGSDL04BLImpl.class);

	/** ��ϢBL */
	protected SdlInfoBL sdlInfoBL;
	
	/** ����BL */
	protected AttachmentBL attachmentBL;
	
	/** �ϴ�����BL */
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
	 * ��Ϣ��ѯ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO searchSdlInfoAction(IGSDL04DTO dto) throws BLException {

		log.debug("========��Ϣ��ѯ����ʼ========");
		
		//��Ϣ��ѯ����ȡ�� 
		int totalCount = this.sdlInfoBL.getSearchCount(dto.getSdlInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ϣ��ѯ���ݲ�����========");
			//��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ϣ��ѯ���ݼ�������========");
			//��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<SdlInfo> sdlInfoList = this.sdlInfoBL.searchSdlInfo(dto.getSdlInfoSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSdlInfoList(sdlInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��Ϣ��ϸ��Ϣ����
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
	 * ��Ϣ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO insertSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========��Ϣ����ʼ========");
		IGSDL0402Form form = (IGSDL0402Form)dto.getSdlInfo();
		try {
			form.setSifacttime(getBetweenTimeNumber(form.getSibegin(),form.getSiend()));
		} catch (Exception e) {
			throw new BLException("IGCO10000.E019");
		}
		form.setSidate(IGStringUtils.getCurrentDateTime());
		String attkey = this.uploadFile(form.getFileMap(),form.getSiattkey());
		form.setSiattkey(attkey);
		//��Ϣ����
		this.sdlInfoBL.registSdlInfo(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "������Ϣ") );

		log.debug("========��Ϣ��������========");
		return dto;
	}

	/**
	 * ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO initSdlInfoAction(IGSDL04DTO dto) throws BLException {

		log.debug("========��Ϣ�༭���������ʾ����ʼ========");
		
		IGSDL0402Form form = dto.getIgsdl0402Form();
		
		Integer sdiid = form.getSiid();
		
		//��ʾ����Ϣȡ��
		SdlInfo sdlInfo = this.sdlInfoBL.searchSdlInfoByKey(sdiid);
		
		if ( sdlInfo == null ){
			throw new BLException("IGCO10000.E004","����");
		}
		form.setSitype(sdlInfo.getSitype());//���
		form.setSidesc(sdlInfo.getSidesc());// ˵��
		form.setSibegin(sdlInfo.getSibegin());//��ʼʱ��
		form.setSiend(sdlInfo.getSiend());//����ʱ��
		form.setSimark(sdlInfo.getSimark());//����
		form.setSieiid(sdlInfo.getSieiid());//����ʲ�ID
		form.setSieiname(sdlInfo.getSieiname());//����ʲ�����
		form.setSiprid(sdlInfo.getSiprid());//�������ID
		form.setSiprtitle(sdlInfo.getSiprtitle());//�����������
		form.setSiattkey(sdlInfo.getSiattkey());//����
		form.setSidate(sdlInfo.getSidate());//����
		form.setSifacttime(sdlInfo.getSifacttime());//ʵ��ʱ��
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","������Ϣ"));
		
		log.debug("========��Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * ��Ϣ���´���
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO updateSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========��Ϣ���´���ʼ========");
		IGSDL0402Form form = (IGSDL0402Form)dto.getSdlInfo();
		try {
			form.setSifacttime(getBetweenTimeNumber(form.getSibegin(),form.getSiend()));
		} catch (Exception e) {
			throw new BLException("IGCO10000.E019");
		}
		String attkey = this.uploadFile(form.getFileMap(),form.getSiattkey());
		
		form.setSiattkey(attkey);
		//��Ϣ���´���
		this.sdlInfoBL.updateSdlInfo(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "������Ϣ") );
		
		log.debug("========��Ϣ���´�������========");
		return dto;
	}

	/**
	 * ��Ϣɾ������
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGSDL04DTO deleteSdlInfoAction(IGSDL04DTO dto) throws BLException {
		log.debug("========��Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteSdlInfoid().length;i++ ){
			String sdiid = dto.getDeleteSdlInfoid()[i];
			//��Ϣɾ������
			this.sdlInfoBL.deleteSdlInfo(Integer.parseInt(sdiid));
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "������Ϣ") );
		log.debug("========��Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * �Ƚ�ʱ��
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1Сʱ=60����=3600��=3600000
		long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;��������֮��
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d2.getTime() - d1.getTime()) / mins;
		return (int) timeNumber;
	}
	
	/**
	 * <p>
	 * �����û��Ƿ��ϴ��˸���
	 * </p>
	 * 
	 * @param fileMap ��Ÿ�����Map����
	 * @return true-�и�����false-�޸���
	 * @author liupeng@deliverik.com
	 */

	public boolean checkFileMap(Map<Integer, FormFile> fileMap) {
		return fileMap != null && fileMap.size() > 0 ? true : false;
	}
	
	/**
	 * <p>
	 * �ϴ�������������������ָ�����ļ����У��������Ƶ���Ϣ�������ݿ�
	 * </p>
	 * 
	 * @param fileMap ��Ÿ�����Map����
	 * @return ����Ψһ��ʶattkey��û�и�������null����ָ������ʷ��¼����
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
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuilder pathBuilder = new StringBuilder();
					// ��Ŀ¼
					pathBuilder.append(rootPath);
					// һ���˵�id
					pathBuilder.append("sdl").append(File.separator);
					// �ļ��ϴ�����
					try {
						fileUploadBL.saveFile(file, pathBuilder.toString(),
								attkey + "_" + file.getFileName());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + file.getFileName());
					// �ϴ��ļ�·������
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
