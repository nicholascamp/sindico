/**
 * 
 */
package com.sindico.enums;

/**
 * @author Lucas
 * 
 */
public enum Estado {

	AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES(
			"ES"), GO("GO"), MA("MA"), MT("MT"), MS("MS"), MG("MG"), PA("PA"), PR(
			"PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), RR(
			"RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");

	private String	estado;

	Estado(final String estado) {
		this.estado = estado;
	}

	public static Estado fromEstado(final String estado) {
		for (Estado e : values()) {
			if (e.estado.equals(estado)) {
				return e;
			}
		}
		return null;
	}

}
