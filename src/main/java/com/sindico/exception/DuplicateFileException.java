/**
 * 
 */
package com.sindico.exception;

/**
 * @author Lucas
 * 
 */
public class DuplicateFileException extends Exception {

	/**
	 * @param fileName
	 */
	public DuplicateFileException(final String fileName) {
		super(
				"Não foi possível criar o arquivo com o nome: "
						+ fileName
						+ ", pois já existe outro arquivo com este nome no diretório de upload. Por favor renomeie o arquivo antes de enviar ");
	}

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5344712019575497385L;

}
