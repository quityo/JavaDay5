package business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() >= 6) {
			System.out.println("Sifre, en az 6 karakter uzunlugunda olmali.");
			return;
		}
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			System.out.println("E-Mail adresi, (example@example.com) formatinda olmali.");
			return;
		}
		if (userDao.getByMail(user.getEmail()) != null) {
			System.out.println("Kullanici mevcut.");
			return;
		}
		if (user.getFirstName().length() > 2 || user.getLastName().length() > 2) {
			System.out.println("Isim, Soyisim 2 karakterden fazla olmali.");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gönderilen e postayi dogrulamak için 3'e ve Enter'a basin : ");
		int selecetion = scanner.nextInt();
		if (selecetion != 3) {
			System.out.println("Hata :  Dogrulama Islemi Basarisiz.");
			return;
		}

		userDao.register(user);
	}

	@Override
	public void login(User user) {
		if (user.getEmail() == null || user.getPassword() == null) {
			System.out.println("Email ve Sifre Kisimlarini Doldurmak zorunludur.");
			return;
		}
//		
		userDao.login(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User getByMail(String mail) {
		return userDao.getByMail(mail);
	}

}
