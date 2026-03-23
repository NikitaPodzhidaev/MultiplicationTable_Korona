package ru.shift.io;

public class TablePrinter {
    private final static String SPACE = " ";
    private final static String COLUMN_SECTION = "|";
    private final static String ROW_SECTION = "-";
    private final static String NODE_SECTION = "+";
    private static int size;
    private static int cellWidth;
    private static int firstColumnWidth;
    private static int[][] table;


    private static void setTablePrinter(int[][] table){
        TablePrinter.table = table;
        TablePrinter.size = table[0].length;
        TablePrinter.cellWidth = String.valueOf(size * size).length();
        TablePrinter.firstColumnWidth = String.valueOf(size).length();
    }

    // метод, который инициализирует нужные поля для вывода таблицы + запускает методы по выводу
    public static void printTable(int[][] table){
        setTablePrinter(table);
        printHeader();
        printAllLines();
    }

    /*
    метод-реализация добавления к объекту StringBuilder нескольких одинаковых значений.
    сделано для лучшей, по мнению автора, читаемости
     */
    private static void appender(StringBuilder sb, int count, String appendString){
        if(count < 0) throw new IllegalArgumentException("count < 0");
        if(appendString == null) throw new NullPointerException("appendString is null!");
        if(count != 0) sb.append(appendString.repeat(count));
    }

    // метод, который выводит "шапку" таблицы. вывод сделан отдельно для декомпозиции
    private static void printHeader() {
        StringBuilder sb = new StringBuilder();
        appender(sb, firstColumnWidth, TablePrinter.SPACE);
        for (int col = 0; col < size; col++) {
            sb.append(TablePrinter.COLUMN_SECTION);
            String headerNumberInString = String.valueOf(table[0][col]);
            appender(sb, Math.max(0, cellWidth - headerNumberInString.length()), TablePrinter.SPACE);
            sb.append(headerNumberInString);
        }

        System.out.println(sb);
    }

    // метод, который выводит строки таблицы с числами по типу: 1 | 2 | 3 | 4.
    private static void printAllLines() {
        for (int row = 0; row < table.length; row++) {

            StringBuilder sb = new StringBuilder();
            String firstColumnNumberInString = String.valueOf(table[row][0]);
            int leftPadding = firstColumnWidth - firstColumnNumberInString.length();
            appender(sb, leftPadding, TablePrinter.SPACE);
            sb.append(firstColumnNumberInString);
            sb.append(TablePrinter.COLUMN_SECTION);


            for(int column = 0; column < table.length; column++){
                String tableElementString = String.valueOf(table[row][column]);
                appender(sb, cellWidth-tableElementString.length(), TablePrinter.SPACE);
                sb.append(tableElementString);
                if(column != (table.length-1)) sb.append(TablePrinter.COLUMN_SECTION); // в конце не выводим "|"
            }
            printRowLines();
            System.out.println(sb);
        }
        printRowLines();
    }

    // метод, который выводит разделители между строками таблицы по типу: --+---+---+---+
    private static void printRowLines(){
        StringBuilder sb = new StringBuilder();
        appender(sb, Math.max(0, firstColumnWidth), TablePrinter.ROW_SECTION);
        sb.append(TablePrinter.NODE_SECTION);
        for(int i = 0; i < size; i++){
            appender(sb, cellWidth, TablePrinter.ROW_SECTION);
            if(i != (size-1)) sb.append(TablePrinter.NODE_SECTION);
        }
        System.out.println(sb);

    }
}
