package edu.montana.esof322.demo.program;

public interface BadProgram {
    void initializeCommandStack();
    void pushCommand(Command command);
    Command popCommand();
    void shutdownCommandStack();
    void initializeReportFormatting();
    void FormatReport(Report report);
    void printReport(Report report);
    void initializeGlobalData();
    void ShutdownGlobalData();
}
