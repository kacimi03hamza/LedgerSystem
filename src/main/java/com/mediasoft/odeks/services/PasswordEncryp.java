package com.mediasoft.odeks.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class PasswordEncryp  implements PasswordEncoder{

	@Override
	public String encode(CharSequence arg0) {
		String hashed=BCrypt.hashpw(arg0.toString(), BCrypt.gensalt(12));
		return hashed;
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		System.out.println(arg1+" arg1");
		System.out.println(arg0+" 0");
		return BCrypt.checkpw(arg0.toString(), arg1.toString());
	}

}
