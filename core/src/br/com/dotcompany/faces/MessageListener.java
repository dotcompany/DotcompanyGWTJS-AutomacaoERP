package br.com.dotcompany.faces;

import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.dotcompany.context.FacesCtxHolder;
import br.com.dotcompany.type.MsgType;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.faces <br>
 * <b>Título:</b> MessageListener.java <br>
 * <b>Descrição:</b> <br>
 * <b>Company:</b> DotCompany TI LTDA. <br>
 * 
 * Copyright (c) 2011 DotCompany - Todos os direitos reservados.
 * 
 * <b>Autor:</b> Danylo <b>Criação:</b> 18/08/2011, 09:44:53
 */
@SuppressWarnings("serial")
public class MessageListener implements PhaseListener {

	public void afterPhase(PhaseEvent arg0) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	/**
	 * Listener que habilita a div de erros
	 */
	public void beforePhase(PhaseEvent e) {
		// so ativa se existir um contexto do FacesServlet
		FacesContext ctx = FacesContext.getCurrentInstance();
		if (ctx != null) {
			Iterator<String> idsArray = ctx.getClientIdsWithMessages();
			// se existir mensagens ativa o MODAL.
			if (idsArray.hasNext()) {
				processSubmitMessages(ctx);
			}
		}
	}

	private void processSubmitMessages(FacesContext ctx) {
		MsgType tipo = MsgType.VALIDACAO;
		if (FacesCtxHolder.getAttRequest(MsgType.TIPO.name()) != null) {
			tipo = (MsgType) FacesCtxHolder.getAttRequest(String
					.valueOf(MsgType.TIPO.name()));
		}
		FacesCtxHolder.setAttRequest(MsgType.MODAL.name(), Boolean.TRUE);
		FacesCtxHolder.setAttRequest(MsgType.TIPO.name(), tipo);
	}
}