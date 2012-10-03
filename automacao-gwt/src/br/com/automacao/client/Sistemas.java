package br.com.automacao.client;


public class Sistemas {

	public native static void getSemed()/*-{
		window.open("http://localhost:8080/semed-web/main.html", "uol", 'menubar=yes,type=fullWindow,fullscreen,scrollbars=yes');
	}-*/;
}
