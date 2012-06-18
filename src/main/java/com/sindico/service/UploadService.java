/**
 * 
 */
package com.sindico.service;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

/**
 * The Interface UploadService.
 * 
 * @author lucas.oliveira
 */
public interface UploadService {

	/**
	 * Download file.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the file
	 */
	File downloadFile(String filePath);

	/**
	 * Upload file.
	 * 
	 * @param fileItem
	 *            the file item
	 * @param fileName
	 *            the file name
	 * @param absolutePath
	 *            the absolute path
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	String uploadFile(FileItem fileItem, String fileName, String absolutePath)
			throws Exception;
}