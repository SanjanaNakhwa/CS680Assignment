package edu.umb.cs680.hw10;

public class LoggedOut implements State {

    private SecurityContext ctx;
    public LoggedOut(SecurityContext ctx){
        this.ctx = ctx;
    }

    @Override
    public void login(String password)  {
        if ( Authenticator.authenticate(ctx, password)){
            ctx.changeState(new LoggedIn(ctx));
        }
        else{
            System.out.println("Authentication Failed");

        }
    }

    @Override
    public void logout() {
    }
}
