package edu.umb.cs680.hw06;

import edu.umb.cs680.hw05.SecurityContext;

abstract class PrintJobExecutor {
    public void execute(PrintJob job,String password, SecurityContext ctx){
        System.out.println("Job with job ID"+ job.id + " added for printing");
    }

    public abstract void doAuthentication(String password, SecurityContext ctx);

    public abstract void doAccessControl();

    public abstract void doPrint(PrintJob job, String password, SecurityContext ctx);

    public abstract void doErrorHandling();

}
