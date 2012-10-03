package br.com.dotcompany.util;

import java.io.ByteArrayOutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtil {

	public static byte[] exportXls(List<String> header, List<Object> values)
			throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		WritableWorkbook workbook = Workbook.createWorkbook(os);
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);

		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		cf.setAlignment(Alignment.CENTRE);
		cf.setVerticalAlignment(VerticalAlignment.CENTRE);
		cf.setBackground(Colour.GREEN);

		int l = 0;
		int c = 2;
		int size = header.size();

		for (String h : header) {
			Label label = new Label(c++, l, h, cf);
			sheet.addCell(label);
		}

		wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
		cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		cf.setBackground(Colour.WHITE);

		l = 2;
		c = 2;

		for (Object value : values) {
			Label label = new Label(c++, l, String.valueOf(value), cf);
			sheet.addCell(label);
			if (c > size) {
				c = 2;
				l++;
			}
		}

		workbook.write();
		workbook.close();

		try {
			return os.toByteArray();
		} finally {
			os.close();
		}
	}
}