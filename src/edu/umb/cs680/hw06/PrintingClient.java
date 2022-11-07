package edu.umb.cs680.hw06;

import edu.umb.cs680.hw05.SecurityContext;

public class PrintingClient {

    public static void main(String[] args) {
        SimplePrintJobExecutor se = new SimplePrintJobExecutor();
        PrintJob job1 = new PrintJob(1);
        SecurityContext ctx = new SecurityContext("ABC");
        se.doPrint(job1,"123",ctx);

        AdvancedPrintJobExecutor ae = new AdvancedPrintJobExecutor();
        PrintJob job2 = new PrintJob(2);
        SecurityContext ctx2 = new SecurityContext("DEF");
        ae.doPrint(job2,"456", ctx2);

        AdvancedPrintJobExecutor ae1 = new AdvancedPrintJobExecutor();
        PrintJob job3 = new PrintJob(3);
        SecurityContext ctx3 = new SecurityContext("DEF");
        ae1.doPrint(job3,"4567", ctx3);
    }


}
