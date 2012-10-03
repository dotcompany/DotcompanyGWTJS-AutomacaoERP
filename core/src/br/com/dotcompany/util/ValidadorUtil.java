package br.com.dotcompany.util;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ResourceBundleMessageProducer;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.NITValidator;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.ie.IEAcreValidator;
import br.com.caelum.stella.validation.ie.IEAlagoasValidator;
import br.com.caelum.stella.validation.ie.IEAmapaValidator;
import br.com.caelum.stella.validation.ie.IEAmazonasValidator;
import br.com.caelum.stella.validation.ie.IEBahiaValidator;
import br.com.caelum.stella.validation.ie.IECearaValidator;
import br.com.caelum.stella.validation.ie.IEDistritoFederalValidator;
import br.com.caelum.stella.validation.ie.IEEspiritoSantoValidator;
import br.com.caelum.stella.validation.ie.IEGoiasValidator;
import br.com.caelum.stella.validation.ie.IEMaranhaoValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoDoSulValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoValidator;
import br.com.caelum.stella.validation.ie.IEMinasGeraisValidator;
import br.com.caelum.stella.validation.ie.IEParaValidator;
import br.com.caelum.stella.validation.ie.IEParaibaValidator;
import br.com.caelum.stella.validation.ie.IEParanaValidator;
import br.com.caelum.stella.validation.ie.IEPernambucoValidator;
import br.com.caelum.stella.validation.ie.IEPiauiValidator;
import br.com.caelum.stella.validation.ie.IERioDeJaneiroValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoNorteValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoSulValidator;
import br.com.caelum.stella.validation.ie.IERondoniaValidator;
import br.com.caelum.stella.validation.ie.IERoraimaValidator;
import br.com.caelum.stella.validation.ie.IESantaCatarinaValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import br.com.caelum.stella.validation.ie.IESergipeValidator;
import br.com.caelum.stella.validation.ie.IETocantinsValidator;
import br.com.dotcompany.type.EstadosBrType;

/**
 * Classe de valida��o de CNPJ, CPF, Inscri��o Estadual e T�tulo
 * Eleitoral
 * 
 * @author sergio
 * 
 */

public class ValidadorUtil {

	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
			"StellaValidationMessages", new Locale("pt", "BR"));
	private static MessageProducer messageProducer = new ResourceBundleMessageProducer(
			resourceBundle);
	private static boolean isFormatted = true;
	private static CPFValidator cpfValidator = new CPFValidator(
			messageProducer, isFormatted);
	private static CNPJValidator cnpjValidator = new CNPJValidator(
			messageProducer, isFormatted);
	private static NITValidator nitValidator = new NITValidator(
			messageProducer, isFormatted);
	private static TituloEleitoralValidator teValidator = new TituloEleitoralValidator(
			messageProducer);

	/**
	 * 
	 * Valida cpf
	 * 
	 * @param cpf
	 */
	public static void validaCPF(String cpf) {
		cpfValidator.assertValid(cpf);
	}

	/**
	 * Valida cnpj
	 * 
	 * @param cnpj
	 */
	public static void validaCNPJ(String cnpj) {
		cnpjValidator.assertValid(cnpj);
	}

	/**
	 * Valida numero de identifica��o do trabalhador
	 * 
	 * @param nit
	 */
	public static void validaNumeroIdentificacaoTrabalhador(String nit) {
		nitValidator.assertValid(nit);
	}

	/**
	 * Valida numero do titulo de eleitor
	 * 
	 * @param titulo
	 */
	public static void validaTituloEleitor(String titulo) {
		teValidator.assertValid(titulo);
	}

	public static void validaInscricaoEstadual(String uf, String ie) {
		if (confereEstado(EstadosBrType.AC, uf)) {
			new IEAcreValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.AL, uf)) {
			new IEAlagoasValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.AM, uf)) {
			new IEAmazonasValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.AP, uf)) {
			new IEAmapaValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.BA, uf)) {
			new IEBahiaValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.CE, uf)) {
			new IECearaValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.DF, uf)) {
			new IEDistritoFederalValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.ES, uf)) {
			new IEEspiritoSantoValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.GO, uf)) {
			new IEGoiasValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.MA, uf)) {
			new IEMaranhaoValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.MG, uf)) {
			new IEMinasGeraisValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.MS, uf)) {
			new IEMatoGrossoDoSulValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.MT, uf)) {
			new IEMatoGrossoValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.PA, uf)) {
			new IEParaValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.PB, uf)) {
			new IEParaibaValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.PE, uf)) {
			new IEPernambucoValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.PI, uf)) {
			new IEPiauiValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.PR, uf)) {
			new IEParanaValidator(messageProducer, isFormatted).assertValid(ie);
		} else if (confereEstado(EstadosBrType.RJ, uf)) {
			new IERioDeJaneiroValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.RN, uf)) {
			new IERioGrandeDoNorteValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.RO, uf)) {
			new IERondoniaValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.RR, uf)) {
			new IERoraimaValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.RS, uf)) {
			new IERioGrandeDoSulValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.SC, uf)) {
			new IESantaCatarinaValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.SE, uf)) {
			new IESergipeValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.SP, uf)) {
			new IESaoPauloValidator(messageProducer, isFormatted)
					.assertValid(ie);
		} else if (confereEstado(EstadosBrType.TO, uf)) {
			new IETocantinsValidator(messageProducer, isFormatted)
					.assertValid(ie);
		}
	}

	private static boolean confereEstado(EstadosBrType estado, String uf) {
		return estado.toString().toLowerCase().equals(uf.toLowerCase());
	}
}