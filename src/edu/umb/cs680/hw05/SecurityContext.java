
package edu.umb.cs680.hw05;

//context
public class SecurityContext {
    private State currentState;
    public String user;

    public SecurityContext(String user) {
        this.currentState = new LoggedOut(this);
        this.user = user;
    }

    public void changeState(State newState){
        this.currentState = newState;
    }

    public void login(String password){
        this.currentState.login(password);
    }

    public void logout(){
        this.currentState.logout();
    }

    public boolean isActive(){
        if (this.currentState instanceof LoggedIn){
            return true;
        }
        return false;
    }

    public State getState() {
        return this.currentState;
    }
}
