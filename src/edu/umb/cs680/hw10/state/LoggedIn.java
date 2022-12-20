package edu.umb.cs680.hw10.state;

public class LoggedIn implements State {

    private SecurityContext ctx;

    public LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }


    @Override
    public void login(String password) {
        if (!ctx.isActive()){
            ctx.changeState( new LoggedOut(ctx) );
            ctx.login(password);
        }

    }

    @Override
    public void logout() {
        ctx.changeState(new LoggedOut(ctx));
    }
}
