package com.siml.shop.member.util;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.siml.shop.member.dao.MemberDAO;
import com.siml.shop.member.dto.MemberDTO;

@Component
public class MailSenderService {
	@Inject
	private MemberDAO memberDao;
	@Inject
	private JavaMailSender mailSender;
	
	public String SendId(String name, String email) {
		String result = "";
		String subject = "";
		String text = "";
		
		MemberDTO memberDto = memberDao.findId(name, email);
		if(memberDto!=null) {
			MimeMessage msg = mailSender.createMimeMessage();
			subject = memberDto.getName() + "님 SIML Shop 아이디 찾기입니다.";
			text = memberDto.getName() + "님의 아이디는 " + memberDto.getId() + "입니다.";
			try {
				msg.setSubject(subject);
				msg.setText(text);
				msg.setRecipient(RecipientType.TO, new InternetAddress(memberDto.getEmail()));
				mailSender.send(msg);
				result = "메일로 ID 정보를 전송하였습니다.";
			}catch(MessagingException e) {
				e.printStackTrace();
				result = "메일 전송에 실패했습니다. 다시 한 번 시도해주세요.";
			}
		}else {
			result = "해당 정보에 해당하는 가입 정보가 없습니다. 확인해주세요.";
		}
		return result;
	}
	
	public String SendPw(String name, String email, String id) {
		String result = "";
		String subject = "";
		String text = "";
		String randomPw = getRandomPassword();
		
		MemberDTO memberDto = memberDao.findPasswd(name, email, id);
		if(memberDto != null) {
			int pwUpdateResult = memberDao.updatePasswd(id, randomPw);
			if(pwUpdateResult > 0) {
				MimeMessage msg = mailSender.createMimeMessage();
				subject = memberDto.getName() + "님 SIML Shop 비밀번호 찾기입니다.";
				text = memberDto.getName() + "님의 비밀번호는 " + randomPw + "입니다.";
				try {
					msg.setSubject(subject);
					msg.setText(text);
					msg.setRecipient(RecipientType.TO, new InternetAddress(memberDto.getEmail()));
					mailSender.send(msg);
					result = "메일로 임시 비밀번호를 전송하였습니다.";
				}catch(MessagingException e) {
					e.printStackTrace();
					result = "메일 전송에 실패했습니다. 다시 한 번 시도해주세요.";
				}
			}else {
				result = "비밀번호 발급에 실패했습니다. 다시 한 번 시도해주세요.";
			}
		}else {
			result = "해당 정보에 해당하는 가입 정보가 없습니다. 확인해주세요.";
		}
		return result;
	}
	
	public String getRandomPassword() {
		char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k',
                'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9'};
		
		StringBuilder sb = new StringBuilder("");
		Random rn = new Random();
		for(int i = 0; i < 6; i++) {
			sb.append(charaters[rn.nextInt(charaters.length)]);
		}
		return sb.toString();
	}
}
