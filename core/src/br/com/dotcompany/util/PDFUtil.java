package br.com.dotcompany.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtil {
	
	private static String localDoArquivo = "C:/Users/servidor 4core/Documents/";

	public static void gerarPdfSimples() {
		// Vari�veis comuns, que ser�o adicionadas aos par�grafos
		String titulo = "Meu primeiro PDF gerado com Java e iText";
		String parNull = "";
		String par1 = "Par�grafo 1";
		String par2 = "Par�grafo 2.";

		// Vari�veis que armazenam o nome do arquivo e seu local
		String nomeDoArquivo = "pdfSimples";

		/**
		 * OBS: Se n�o especificar o nome do arquivo, ele ser� gerado na pasta
		 * raiz do projeto (�bvio). ^^
		 */

		// cria��o do objeto documento
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo
					+ nomeDoArquivo + ".pdf"));
			document.open(); // Abrindo o documento

			// adicionando os par�grafos ao documento
			document.add(new Paragraph(titulo));
			document.add(new Paragraph(parNull));
			document.add(new Paragraph(par1));
			document.add(new Paragraph(par2));

			// Fechando o documento
			document.close();
		}

		catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}

	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo simples, que usa o recurso de adicionar novas c�lulas a uma tabela
	 * pr�-definida.
	 * 
	 * @return
	 */
	public static byte[] criarTabela(int cols) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// 1 - Primeiro se cria o documento
		Document document = new Document();

		try {
			// 2 - Depois define o nome de arquivo
			PdfWriter.getInstance(document, baos);

			// 3 - Abre o Documento
			document.open();

			// 4 - Define as colunas que ter� a tabela, suas propriedades, e
			// 'popula' a tabela.
			PdfPTable table = new PdfPTable(cols);

			// Aqui se cria a nova c�lula, com seus devidos atributos, e a
			// adiciona � tabela.
			Paragraph p = new Paragraph("Pessoa");
			p.setAlignment(Element.ALIGN_RIGHT);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(3);
			table.addCell(cell);

			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("3.1");
			table.getDefaultCell().setGrayFill(0.8f);
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("3.2");

			document.add(table);

			// Fechando o documento
			document.close();

			// Mensagem que aparece no console caso tudo d� certo
			System.out
					.println("Adicionando novas c�lulas, uma forma de Mesclar linhas - OK");
			return baos.toByteArray();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		return null;
	}

	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo que gera uma tabela com c�lulas de tamanhos pr�difinidos,
	 * diferentes umas das outras
	 */
	public static void definirCelulas() {

		// Aqui n�o s� foi criado o documento, como tamb�m definido o tipo de
		// papel que ser� gerado o arquivo. A4
		Document document = new Document(PageSize.A4, 36, 36, 36, 36);
		try {

			PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo
					+ "Celulas com tamanho diferentes.pdf"));
			document.open(); // Abrindo o documento

			float[] widths = { 0.1f, 0.1f, 0.05f, 0.75f };
			PdfPTable table = new PdfPTable(widths);
			table.addCell("10%");
			table.addCell("10%");
			table.addCell("5%");
			table.addCell("75%");
			table.addCell("aa");
			table.addCell("aa");
			table.addCell("a");
			table.addCell("aaaaaaaaaaaaaaa");
			table.addCell("bb");
			table.addCell("bb");
			table.addCell("b");
			table.addCell("bbbbbbbbbbbbbbb");
			table.addCell("cc");
			table.addCell("cc");
			table.addCell("c");
			table.addCell("ccccccccccccccc");
			document.add(table);

			// Adicionando um par�grafo apenas para pular linha
			document.add(new Paragraph("Mudando a Porcentagem:\n\n"));

			widths[0] = 20f;
			widths[1] = 20f;
			widths[2] = 10f;
			widths[3] = 50f;
			table.setWidths(widths);
			document.add(table);

			widths[0] = 40f;
			widths[1] = 40f;
			widths[2] = 20f;
			widths[3] = 300f;
			// Rectangle r = new Rectangle(PageSize.A4.getRight(72),
			// PageSize.A4.getTop(72));
			// table.setWidthPercentage(widths, r);
			document.add(new Paragraph(
					"Usando uma porcentagem de largura absoluta:\n\n"));
			document.add(table);
			document.add(new Paragraph("Definindo sem Porcentagem:\n\n"));
			table.setTotalWidth(300);
			// table.setLockedWidth(true);
			document.add(table);

			// Fechando o documento
			document.close();

			// Mensagem que aparece no console caso tudo d� certo
			System.out.println("C�lulas com tamanho diferente.");
		} catch (Exception de) {
			de.printStackTrace();
		}

	}

	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo que gera um documento com tabelas alinhadas diferentemente.
	 */
	public static void tabelaComAlinhamento() {

		// O PageSize � pra definir o tamanho que ser�o geradas as p�ginas
		Document document = new Document(PageSize.A4);

		try {
			PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo
					+ "Tabela com Alinhamentos diversos.pdf"));
			document.open(); // Abrindo o documento

			PdfPTable table = new PdfPTable(3);

			// Definindo a cor da borda da tabela
			table.getDefaultCell().setBorderColor(BaseColor.GREEN);

			/**
			 * Se for adicionada uma nova c�lula a tabela, deve-se especificar
			 * novamente para esta c�lula todos os atributos que deseja mudar
			 */
			PdfPCell cell = new PdfPCell(new Paragraph("T�tulo com colspan=3"));
			cell.setColspan(3);
			cell.setBorderColor(BaseColor.DARK_GRAY);

			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("3.1");
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("3.2");

			// Definindo uma nova c�lula com borda colorida
			cell = new PdfPCell(new Paragraph("C�lula com borda vermelha"));
			cell.setBorderColor(BaseColor.ORANGE);
			table.addCell(cell);

			// Definindo uma nova c�lula com fundo Cinza e mesclada em duas
			// colunas
			cell = new PdfPCell(new Paragraph(
					"C�lula com fundo Cinza e colspan=2"));
			cell.setColspan(2);
			cell.setBackgroundColor(BaseColor.YELLOW);
			table.addCell(cell);
			document.add(table);

			// Adicionando a tabela ocupando 100% do documento
			table.setWidthPercentage(100);
			document.add(table);

			// Adicionando a tabela ocupando 50% do documento e alinhada a
			// direita.
			table.setWidthPercentage(50);
			table.setHorizontalAlignment(Element.ALIGN_RIGHT);
			document.add(table);

			// Adicionando a tabela alinhada a Esquerda, sem nenhum
			// redimensionamento
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			document.add(table);

			// Fechando o documento
			document.close();

			// Mensagem que aparece no console caso tudo d� certo
			System.out.println("Tabela com Alinhamentos");

		} catch (Exception erro) {
			erro.printStackTrace();
		}

	}

	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo que gera uma tabela dentro da outra, fazendo um tipo de Rowspan
	 */
	public static void tabelaRowspan() {

		Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		try {

			PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo
					+ "Tabela dentro de Tabela.pdf"));
			document.open(); // Abrindo o documento

			PdfPTable table = new PdfPTable(4);
			PdfPTable nested1 = new PdfPTable(2);
			nested1.addCell("1.1");
			nested1.addCell("1.2");
			PdfPTable nested2 = new PdfPTable(1);
			nested2.addCell("2.1");
			nested2.addCell("2.2");

			for (int k = 0; k < 24; ++k) {
				if (k == 1) {
					table.addCell(nested1);
				} else if (k == 20) {
					table.addCell(nested2);
				} else {
					table.addCell("cell " + k);
				}
			}

			document.add(table);

			// Fechando o documento
			document.close();

			// Mensagem que aparece no console caso tudo d� certo
			System.out.println("Tabela dentro de Tabela");

		} catch (Exception de) {
			de.printStackTrace();
		}

	}

	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo que gera uma tabela com imagem imbutida.
	 */
	public static void tabelaComImagem() {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo
					+ "Imagem na Tabela.pdf"));
			document.open(); // Abrindo o documento

			// Deve-se adicionar corretamente o endere�o da imagem.
			Image image = Image.getInstance(localDoArquivo + "dota.jpg");

			/**
			 * Aqui � uma forma diferente de definir quantas linhas e colunas
			 * ter�.. faz isso e adiciona no PdfPTable(); ficanso assim ==>
			 * PdfPTable table = new PdfPTable(widths);
			 */
			// float[] widths = {0f, 0f};

			// Definindo a tabela com duas colunas
			PdfPTable table = new PdfPTable(2);

			// Para inserir cor na borda da tabela, deve-se importar a classe
			// Color
			table.getDefaultCell().setBorderColor(BaseColor.BLUE);

			table.addCell("Esse � meu Cachorro");
			table.addCell(image);

			/**
			 * table.addCell("This two"); table.addCell(new PdfPCell(image,
			 * true));
			 * 
			 * table.addCell("This three"); table.addCell(new PdfPCell(image,
			 * false));
			 */
			document.add(table);

			// Fechando o documento
			document.close();

			// Mensagem que aparece no console caso tudo d� certo
			System.out.println("Imagem na c�lula");

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}
	// -----------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------//

	/**
	 * M�todo que gera uma tabela simples, instanciada da classe Table. N�o tem
	 * tantos recursos quanto a PdfPTable, mas � bom pra se ter uma no��o b�sica
	 */
	// public static void tabelaSimples()
	// {
	//	
	//	
	// Document document = new Document();
	//
	// try {
	//
	// PdfWriter.getInstance(document, new FileOutputStream(localDoArquivo+
	// "tabelaSimples.pdf"));
	// document.open();
	//
	// // adicionando os par�grafo ao documento
	// document.add(new Paragraph("DADOS DO CONTATO:"));
	//
	// // step 4: we create a table and add it to the document
	// Table table = new Table(2, 2); // 2 rows, 2 columns
	// table.addCell("0.0");
	// table.addCell("0.1");
	// table.addCell("1.0");
	// table.addCell("1.1");
	// document.add(table);
	//		
	// //Fechando o documento
	// document.close();
	//		
	// //Mensagem que aparece no console caso tudo d� certo
	// System.out.println("Minha primeira tabela");
	//
	// }
	// catch (DocumentException de) {
	// System.err.println(de.getMessage());
	// }
	// catch (IOException ioe) {
	// System.err.println(ioe.getMessage());
	// }
	//	
	// }
}
