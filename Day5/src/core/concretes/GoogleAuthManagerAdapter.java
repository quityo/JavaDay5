package core.concretes;

import GoogleAuth.GoogleAuthManager;
import core.abstracts.AuthService;
import entities.concretes.User;

public class GoogleAuthManagerAdapter implements AuthService{
    private final GoogleAuthManager googleAuthManager;

    public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
        this.googleAuthManager = googleAuthManager;
    }

    @Override
    public void register(User user) {
        googleAuthManager.register(user);
    }

    @Override
    public void login(User user) {
        googleAuthManager.login(user);
    }
}