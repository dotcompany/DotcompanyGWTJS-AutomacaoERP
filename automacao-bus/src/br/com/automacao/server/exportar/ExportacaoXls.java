package br.com.automacao.server.exportar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import br.com.automacao.server.UtilServer;
import br.com.automacao.shared.util.ExportacaoListagem;

@SuppressWarnings("unchecked")
public class ExportacaoXls implements IExportacao{

	private HSSFWorkbook wb;
	private CreationHelper ch;
	private CellStyle cssCabecalho;
	private CellStyle cssRodape;
	private CellStyle cssTexto;
	private CellStyle cssNumero;
	private CellStyle cssInteiro;
	private CellStyle cssData;

	/**
	 * Construtor padrao.
	 */
	public ExportacaoXls() {
		wb = new HSSFWorkbook();
		ch = wb.getCreationHelper();

		// estilo
		Font font1 = wb.createFont();
		font1.setFontName("Arial");
		font1.setBoldweight(Font.BOLDWEIGHT_BOLD);

		cssCabecalho = wb.createCellStyle();
		cssCabecalho.setAlignment(CellStyle.ALIGN_CENTER);
		cssCabecalho.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cssCabecalho.setFont(font1);

		cssRodape = wb.createCellStyle();
		cssRodape.setAlignment(CellStyle.ALIGN_CENTER);
		cssRodape.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cssRodape.setFont(font1);
		cssRodape.setDataFormat(wb.createDataFormat().getFormat("#,##0.00"));

		Font font2 = wb.createFont();
		font2.setFontName("Arial");
		cssTexto = wb.createCellStyle();
		cssTexto.setFont(font2);

		cssNumero = wb.createCellStyle();
		cssNumero.setDataFormat(ch.createDataFormat().getFormat("#,##0.00"));

		cssInteiro = wb.createCellStyle();
		cssInteiro.setDataFormat(ch.createDataFormat().getFormat("0"));

		cssData = wb.createCellStyle();
		cssData.setDataFormat(ch.createDataFormat().getFormat("dd/mm/yyyy"));
	}

	@Override
	public byte[] getArquivo(ExportacaoListagem lista) {
		// inicio do arquivo
		HSSFSheet sheet = wb.createSheet(lista.getNome());
		// cabecalho
		getCabecalhoListagem(sheet, lista);
		// corpo
		getCorpoListagem(sheet, lista);
		// rodape
		getRodapeListagem(sheet, lista);
		// retorno
		return wb.getBytes();
	}
	
	/**
	 * Metodo que gera o cabecalho da listagem.
	 * 
	 * @param sheet
	 *            o objeto de planilha.
	 * @param lista
	 *            o objeto de exportacao de listagem.
	 */
	public void getCabecalhoListagem(HSSFSheet sheet, ExportacaoListagem lista) {
		Row lin = sheet.createRow(0);
		lin.setHeightInPoints(30);

		int pos = 0;
		for (int i = 0; i < lista.getRotulos().length; i++) {
			if (lista.getRotulos()[i] != null) {
				Cell col = lin.createCell(pos);
				col.setCellStyle(cssCabecalho);
				col.setCellValue(lista.getRotulos()[i]);
				pos++;
			}
		}
	}

	/**
	 * Metodo que gera o corpo da listagem.
	 * 
	 * @param sheet
	 *            o objeto de planilha.
	 * @param lista
	 *            o objeto de exportacao de listagem.
	 */
	public void getCorpoListagem(HSSFSheet sheet, ExportacaoListagem lista) {
		int fim = lista.getDados().length - lista.getInicio();
		if (lista.getLimite() > 0 && lista.getLimite() < fim) {
			fim = lista.getLimite();
		}

		for (int j = 0; j < fim; j++) {
			Row lin = sheet.createRow(j + 1);
			int pos = 0;

			for (int i = 0; i < lista.getRotulos().length; i++) {
				if (lista.getRotulos()[i] != null) {
					Cell col = lin.createCell(pos);
					setValor(lista.getDados()[j][i], col);
					sheet.autoSizeColumn(pos);
					pos++;
				}
			}
		}
	}

	/**
	 * Metodo que gera o rodape da listagem.
	 * 
	 * @param sheet
	 *            o objeto de planilha.
	 * @param lista
	 *            o objeto de exportacao de listagem.
	 */
	public void getRodapeListagem(HSSFSheet sheet, ExportacaoListagem lista) {
		int reg = lista.getLimite() > 0 ? lista.getLimite() : lista.getDados().length;
		Row lin = sheet.createRow(reg + 1);
		lin.setHeightInPoints(30);
		int pos = 0;

		for (int i = 0; i < lista.getRotulos().length; i++) {
			if (lista.getRotulos()[i] != null) {
//				if (lista.getAgrupamentos()[i] != null) {
//					Cell col = lin.createCell(pos);
//					col.setCellStyle(cssRodape);
//					char letra = (char) (65 + pos);
//					col.setCellFormula(lista.getAgrupamentos()[i].toString() + "(" + letra + "2:" + letra + (reg + 1) + ")");
//				}
				pos++;
			}
		}
	}

	/**
	 * @see AExportacao#getValor(String)
	 */
	public void setValor(String valor, Cell col) {
		valor = getValor(valor);
		// valida se e data
		Pattern data = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
		Matcher mat = data.matcher(valor);
		if (mat.find()) {
			try {
				col.setCellStyle(cssData);
				col.setCellValue(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(valor));
			} catch (Exception e) {
				col.setCellValue(valor);
			}
		} else {
			// valida se é decimal
			Pattern decimal = Pattern.compile("^[0-9]+(\\.[0-9]{3})*\\,[0-9]{2}$");
			mat = decimal.matcher(valor);
			if (mat.find()) {
				valor = valor.replace(".", "").replace(",", ".");
				col.setCellStyle(cssNumero);
				col.setCellValue(Double.parseDouble(valor));
			} else {
				// valida se é numero
				Pattern numero = Pattern.compile("^[0-9]+$");
				mat = numero.matcher(valor);
				if (mat.find()) {
					col.setCellStyle(cssInteiro);
					col.setCellValue(Double.parseDouble(valor));
				} else { // texto e outros
					col.setCellStyle(cssTexto);
					col.setCellValue(valor);
				}
			}
		}
	}
	
	/**
	 * Metodo que identifica o tipo de valor e formata de acordo com a
	 * localizacao.
	 * 
	 * @param valor
	 *            o texto cuja informacao sera avaliada.
	 * @return o texto formato de acordo com o tipo.
	 */
	public String getValor(String valor) {
		String retorno = valor;

		if (valor != null) {
			try {
				Date data = new SimpleDateFormat("MM/dd/yyyy", Locale.US).parse(valor);
				retorno = UtilServer.formataData(data, DateFormat.MEDIUM);
				if (valor.indexOf(":") > 0) {
					data = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss", Locale.US).parse(valor);
					retorno += " " + UtilServer.formataHora(data, DateFormat.MEDIUM);
				}
			} catch (Exception e1) {
				try {
					if (valor.contains(".")) {
						retorno = UtilServer.formataNumero(valor, 1, 2, true);
					} else {
						retorno = Long.parseLong(valor) + "";
					}
				} catch (Exception e4) {
					if (valor.equalsIgnoreCase("true")) {
						retorno = "Sim";
					} else if (valor.equalsIgnoreCase("false")) {
						retorno = "Nao";
					}
				}
			}
		}

		return retorno == null || retorno.equals("") || retorno.equals("null") ? " " : retorno;
	}
}