package br.com.dotcompany.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class DataUtil implements Serializable {

	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DAY = "d";
	public static final String MONTH = "MM";
	public static final String YEAR = "yyyy";
	public static final String HH_MM = "HH:mm";
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";

	public static int getAno() {
		return getAno(new Date());
	}

	public static int getAno(Date data) {
		return Integer.valueOf(formt(data, DataUtil.YEAR));
	}

	public static int getMes() {
		return getMes(new Date());
	}

	public static int getMes(Date data) {
		return Integer.valueOf(formt(data, DataUtil.MONTH));
	}

	public static int getDiaMesAtual() {
		return Integer.valueOf(formt(new Date(), DataUtil.DAY));
	}

	public static String getData(Date data) {
		return formt(data, DataUtil.DD_MM_YYYY);
	}

	public static String getData() {
		return formt(new Date(), DataUtil.DD_MM_YYYY);
	}

	public static String getHoras() {
		return formt(new Date(), "HH_MM");
	}

	public static String formt(Date data, String pattern) {
		SimpleDateFormat formatData = new SimpleDateFormat(pattern);
		return formatData.format(data);
	}
}