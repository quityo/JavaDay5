package GoogleAuth;

import entities.concretes.User;

public class GoogleAuthManager {
	
	public void register(User user) {
		System.out.println(user.getEmail() +" Isimli Google Hesabi ile Google Uzerinden Kayit Olusturuldu.");
	}
	
	public void login(User user) {
		System.out.println(user.getEmail() + " Isimli Google Hesabi ile Google Uzerinen Giris Yapildi.");
	}
}
