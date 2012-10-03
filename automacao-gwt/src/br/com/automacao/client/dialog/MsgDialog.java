package br.com.automacao.client.dialog;

import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.ProgressBar;
import com.google.gwt.user.client.Timer;

public class MsgDialog {
	
	public static MessageBox info(String title, String msg) {
		return info(title, msg, null);
	}

	public static MessageBox error(String message) {
		return alert("Erro", message);
	}

	public static MessageBox message(String message) {
		return info("Mensagem", message);
	}

	public static MessageBox message(String message,
			Listener<MessageBoxEvent> callback) {
		return info("Mensagem", message, callback);
	}

	public static MessageBox info(String title, String msg,
			Listener<MessageBoxEvent> callback) {
		return MessageBox.info(title, msg, callback);
	}

	public static MessageBox alert(String title, String msg) {
		return alert(title, msg, null);
	}

	public static MessageBox alert(String title, String msg,
			Listener<MessageBoxEvent> callback) {
		return MessageBox.alert(title, msg, callback);
	}

	public static MessageBox confirm(String title, String msg) {
		return confirm(title, null);
	}

	public static MessageBox confirm(String title, String msg,
			Listener<MessageBoxEvent> callback) {
		return MessageBox.confirm(title, msg, callback);
	}

	public static MessageBox status() {
		return MessageBox.wait("Aguarde", "", "");
	}

	public static MessageBox status(String message) {
		return MessageBox.wait("Aguarde", message, "");
	}

	public static MessageBox status(String caption, String progressText) {
		return MessageBox.wait("Aguarde", caption, progressText);
	}

	public static MessageBox progress(String caption) {
		final MessageBox box = MessageBox.progress("Aguarde", caption,
				"Iniciando");
		final ProgressBar bar = box.getProgressBar();
		final Timer t = new Timer() {
			float i;

			@Override
			public void run() {
				bar.updateProgress(i / 100, (int) i + "% Completo");
				i += 5;
				if (i > 105) {
					cancel();
					box.close();
				}
			}
		};
		t.scheduleRepeating(500);
		return box;
	}
}