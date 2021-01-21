package edu.montana.esof322.demo.methods;

public class BadRoutine {

    private static final StatusType SUCCESS =StatusType.SUCCESS;
    private static final int POINTS_PER_INCH = 42;
    private double[][] corpExpense;
    private int[] profit;
    private int[] revenue;
    private ExpenseHolder expense;

    void handleStuff(CORP_DATA inputRec, int crntQtr, EMP_DATA empRec,
                     double estimRevenue, double ytdRevenue, int screenX, int screenY,
                     COLOR_TYPE newColor, COLOR_TYPE prevColor, StatusType status,
                     int expenseType )
    {
        int i;
        for ( i = 0; i < 100; i++ ) {
            inputRec.revenue[i] = 0;
            inputRec.expense[i] = corpExpense[ crntQtr ][ i ];
        }
        UpdateCorpDB( empRec );
        estimRevenue = ytdRevenue * 4.0 / (double) crntQtr;
        newColor = prevColor;
        status = SUCCESS;
        if ( expenseType == 1 ) {
            for ( i = 0; i < 12; i++ )
                profit[i] = revenue[i] - expense.type1[i];
        }
        else if ( expenseType == 2 ) {
                  profit[i] = revenue[i] - expense.type2[i];
                  }
        else if ( expenseType == 3 )
                  profit[i] = revenue[i] - expense.type3[i];
    }

    void extractToMethodDemo(int deviceUnits) {
        int points = deviceUnits *
                (POINTS_PER_INCH / deviceUnitsPerInch());
    }

    //========================================
    // Garbage...
    //========================================
    private void UpdateCorpDB(EMP_DATA empRec) {
    }

    private class CORP_DATA {
        public int[] revenue;
        public double[] expense;
    }

    private class EMP_DATA {
    }

    private class COLOR_TYPE {
    }

    private enum StatusType {
        SUCCESS
    }

    private class ExpenseHolder {
        public int[] type1;
        public int[] type2;
        public int[] type3;
    }

    private int deviceUnitsPerInch() {
        return 0;
    }

}
