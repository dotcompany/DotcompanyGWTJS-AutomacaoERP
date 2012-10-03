package br.com.automacao.service.servlet;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import br.com.automacao.client.service.SessaoService;

@SuppressWarnings("serial")
@Service("sessionManager")
public class SessaoServiceImpl extends BaseService implements SessaoService {

	@Override
	public void colocarNaSessao(String key, Serializable value) {
		HttpSession session = getThreadLocalRequest().getSession();
		session.setAttribute(key, value);
	}

	@Override
	public Serializable retirarDaSessao(String key) {
		HttpSession session = getThreadLocalRequest().getSession();
		return (Serializable) session.getAttribute(key);
	}
}