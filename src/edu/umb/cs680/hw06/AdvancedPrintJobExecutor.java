package edu.umb.cs680.hw06;

import edu.umb.cs680.hw05.LoggedIn;
import edu.umb.cs680.hw05.SecurityContext;

public class AdvancedPrintJobExecutor extends PrintJobExecutor{

    @Override
    public void doAuthentication(String password, SecurityContext ctx) {
        try {
            ctx.login(password);
        }

        catch(Exception e){
            throw e;
        }

    }

    @Override
    public void doAccessControl() {
    }

    @Override
    public void doPrint(PrintJob job,  String password, SecurityContext ctx) {
        try {
            doAuthentication(password, ctx);
        }

        catch (Exception e){
            doErrorHandling();
        }
        if(ctx.getState() instanceof LoggedIn) {
            execute(job, password, ctx);
        }
        else{
            doErrorHandling();
        }

    }
    @Override
    public void doErrorHandling() {
        System.out.println("Job Aborted");

    }
}
