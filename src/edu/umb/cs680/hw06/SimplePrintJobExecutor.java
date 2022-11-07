package edu.umb.cs680.hw06;

import edu.umb.cs680.hw05.SecurityContext;

public class SimplePrintJobExecutor extends PrintJobExecutor {

    @Override
    public void doAuthentication(String password, SecurityContext ctx) {

    }

    @Override
    public void doAccessControl() {

    }

    @Override
    public void doPrint(PrintJob job, String password, SecurityContext ctx) {
        execute(job,null,null);
    }

    @Override
    public void doErrorHandling() {

    }
}
