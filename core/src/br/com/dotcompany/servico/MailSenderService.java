package br.com.dotcompany.servico;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import br.com.dotcompany.exception.ShowException;

/**
 * <b>Projeto:</b> comunicacao <br>
 * <b>Pacote:</b> br.com.comunicacao.ctr <br>
 * <b>Título:</b> MailSenderService.java <br>
 * <b>Descrição:</b> <br>
 * 
 * <b>Autor:</b> DotCompany TI <b>Criação:</b> 12/09/2011, 08:56:31
 */
@Service
public class MailSenderService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	private SimpleMailMessage simpleMailMessage;
	private MimeMessageHelper mimeMessageHelper;

	private String to;
	private String[] cc;
	private String subject;
	private String content;
	private String templateName;
	private boolean validate = false;

	public void sendWithTemplate(Map<String, Object> model) {
		mailSender = this.getMailSender();
		simpleMailMessage.setTo(this.getTo());
		simpleMailMessage.setCc(cc);
		simpleMailMessage.setSubject(this.getSubject());
		String result = null;
		try {
			result = mergeTemplateIntoString(this.getTemplateName(), "UTF-8",
					model);
		} catch (Exception e) {
		}
		simpleMailMessage.setText(result);
		mailSender.send(simpleMailMessage);
	}

	public void sendText() {
		mailSender = this.getMailSender();
		simpleMailMessage.setTo(this.getTo());
		simpleMailMessage.setCc(cc);
		simpleMailMessage.setSubject(this.getSubject());
		simpleMailMessage.setText(this.getContent());
		mailSender.send(simpleMailMessage);
	}

	public void sendHtml() {
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setTo(this.getTo());
			helper.setCc(cc);
			helper.setSubject(this.getSubject());
			helper.setText(this.getContent(), true);
		} catch (MessagingException e) {
			ShowException.aspect(e);
		}
		mailSender.send(mimeMessage);
	}

	public void sendHtmlWithImage(String imagePath) {
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(this.getTo());
			helper.setCc(cc);
			helper.setSubject(this.getSubject());
			helper.setText(this.getContent(), true);
			// Content="<html><head></head><body><img src="cid:image"/></body></html>";
			FileSystemResource img = new FileSystemResource(new File(imagePath));
			helper.addInline("image", img);
		} catch (MessagingException e) {
			ShowException.aspect(e);
		}
		mailSender.send(mimeMessage);
	}

	public void sendHtmlWithAttachment(String filePath) {
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(this.getTo());
			helper.setCc(cc);
			helper.setSubject(this.getSubject());
			helper.setText(this.getContent(), true);
			FileSystemResource file = new FileSystemResource(new File(filePath));
			// System.out.println("file.getFilename==="+file.getFilename());
			helper.addAttachment(file.getFilename(), file);
		} catch (MessagingException e) {
			ShowException.aspect(e);
		}
		mailSender.send(mimeMessage);
	}

	public void sendHtmlWithTemplate(Map<String, Object> model) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setTo(this.getTo());
			helper.setCc(this.getCc());
			helper.setSubject(this.getSubject());
			String result = mergeTemplateIntoString(getTemplateName(), model);
			helper.setText(result, true);
			mailSender.send(helper.getMimeMessage());
		} catch (Exception e) {
			ShowException.aspect(e);
		}
	}

	private String mergeTemplateIntoString(String templateLocation,
			Map<String, Object> model) {
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				templateLocation, model);
	}

	private String mergeTemplateIntoString(String templateLocation,
			String encoding, Map<String, Object> model) {
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				templateLocation, encoding, model);
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public MimeMessageHelper getMimeMessageHelper() {
		return mimeMessageHelper;
	}

	public void setMimeMessageHelper(MimeMessageHelper mimeMessageHelper) {
		this.mimeMessageHelper = mimeMessageHelper;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
}