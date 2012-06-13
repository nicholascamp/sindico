/**
 * 
 */
package com.sindico.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sindico.exception.DuplicateFileException;
import com.sindico.service.UploadService;

/**
 * The Class UploadServiceImpl.
 * 
 * @author lucas.oliveira
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

	/** The logger. */
	private static Logger	logger	= LoggerFactory
											.getLogger(UploadServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.org.sesc.upload.service.UploadService#uploadFile(org.apache.commons
	 * .fileupload.FileItem, java.lang.String, java.lang.String)
	 */
	@Override
	public String uploadFile(final FileItem fileItem, final String fileName,
			final String absolutePath) throws DuplicateFileException {
		FileOutputStream outputStream;
		InputStream inputStream;
		String returnName = "";

		try {
			byte[] buffer = new byte[1024];
			int length;

			File file = new File(absolutePath + fileName);

			if (!file.exists()) {

				try {
					file.createNewFile();
				} catch (SecurityException e) {
					logger.error("Não foi possível criar o arquivo. Por favor, verifique as permissões de sistema.");
				}
			} else {
				throw new DuplicateFileException(fileName);
			}

			inputStream = fileItem.getInputStream();
			outputStream = new FileOutputStream(file);

			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}

			outputStream.flush();
			outputStream.close();
			inputStream.close();
			returnName = file.getName();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.org.sesc.upload.service.UploadService#downloadFile(java.lang.String)
	 */
	@Override
	public File downloadFile(final String filePath) {
		File file = new File(filePath);

		return file;
	}

}