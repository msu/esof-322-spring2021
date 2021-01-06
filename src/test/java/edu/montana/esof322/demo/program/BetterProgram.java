package edu.montana.esof322.demo.program;

public interface BetterProgram {
    void initializeCommandStack();
    // Moved to a CommandStack object
//    void pushCommand(Command command);
//    Command popCommand();
    void shutdownCommandStack();
    void initializeReportManager();
    void shutdownReportManager();
    // Moved to a ReportManager object
//    void initializeReportFormatting();
//    void FormatReport(Report report);
//    void printReport(Report report);
    void initializeGlobalData();
    void shutdownGlobalData();
}
