/**
 * 
 */
package com.sindico.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sindico.service.UploadService;

@Controller
@RequestMapping(value = "file")
public class UploadController {

	@Resource(name = "appConfiguration")
	private Properties		aplicationConfig;

	private UploadService	uploadService;

	private static Logger	logger	= LoggerFactory
											.getLogger(UploadController.class);

	/**
	 * @return the uploadService
	 */
	public UploadService getUploadService() {
		return uploadService;
	}

	/**
	 * @param uploadService
	 *            the uploadService to set
	 */
	@Autowired
	public void setUploadService(final UploadService uploadService) {
		this.uploadService = uploadService;
	}

	/**
	 * Upload file.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param model
	 *            the model
	 * @return the model
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ModelAttribute
	public Model uploadFile(final HttpServletRequest request,
			final HttpServletResponse response, final Model model)
			throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<String> fileNames = new ArrayList<String>();
		String fileName = "";

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {

			FileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(factory);

			List<?> items = upload.parseRequest(request);

			Iterator<?> iterator = items.iterator();

			String absolutePath = createDirectories(aplicationConfig
					.getProperty("filesFolder"));

			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();
				if (!item.isFormField()) {
					fileName = renameFile(item.getName());
					fileNames.add(uploadService.uploadFile(item, fileName,
							absolutePath));
				}

			}
		}

		model.addAttribute("files", fileNames);
		return model;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView downloadFile(final HttpServletRequest request,
			final HttpServletResponse response) {
		String fileName = request.getParameter("filePath");
		File file = uploadService.downloadFile(aplicationConfig.getProperty(
				"filesFolder").concat(fileName));

		String mimetype = new MimetypesFileTypeMap().getContentType(file);
		response.setContentType((mimetype != null) ? mimetype
				: "application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");

		try {
			InputStream inputStream = new FileInputStream(file);

			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();

		} catch (FileNotFoundException e) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} catch (IOException e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return null;
	}

	private String createDirectories(final String absolutePath) {

		File directory = new File(absolutePath);

		if (!directory.exists()) {
			try {
				directory.mkdirs();
			} catch (Exception e) {
				logger.error("Não foi possível criar os diretórios. Por favor, verifique as permissões de sistema.");
			}
		}

		return absolutePath;
	}

	private String renameFile(String fileName) {
		Date date = new Date();
		String timeStamp = new Timestamp(date.getTime()).toString().replaceAll(
				"[\b\\\t\\\n\\\f\\r\\.\\:\\ ]", "-");

		// subString para retirar os milisegundos do timeStamp
		timeStamp = timeStamp.substring(0, timeStamp.length() - 4);

		fileName = Normalizer
				.normalize(fileName, java.text.Normalizer.Form.NFD);
		fileName = fileName.replaceAll("[^\\p{ASCII}]", "").replaceAll(
				"[\b\\\t\\\n\\\f\\r\\ \\'\\-\\:\\ ]", "_");
		int lastPosition = fileName.lastIndexOf('.');
		if (lastPosition == -1) {
			return fileName;
		} else {
			String sufix = fileName.substring(lastPosition, fileName.length());
			return fileName.substring(0, lastPosition).concat(
					"_" + timeStamp + sufix);
		}
	}
}