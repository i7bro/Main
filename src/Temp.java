import org.apache.commons.csv.*;
import edu.duke.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Pars {
    public static void listExporters(CSVParser parser, String expOfInterest) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(expOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public static String CountryInfo (CSVParser parser, String country) {
        String str = "no country";
        for (CSVRecord record: parser) {
            String strCounty = record.get("Country");
            String export = record.get("Exports");
            String count = record.get("Value (dollars)");
            if (strCounty.contains(country)) {
                str = strCounty + ": " + export
                                   + ": " + count + " dollars";
            }
        }
        return str;
    }
    public static void listExportersTwoProd(CSVParser parser, String exp1, String exp2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exp1) && export.contains(exp2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public static int numbersOfExp (CSVParser parser, String expItem) {
        int numbOfExp = 0;
        for (CSVRecord record: parser) {
            String export = record.get("Exports");
            if (export.contains(expItem))
                numbOfExp += 1;
        }
        return numbOfExp;
    }

    public static void bigExporters (CSVParser parser, String sum) {
        for (CSVRecord record: parser) {
            String amount = record.get("Value (dollars)");
            if (amount.length() > sum.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + amount);
            }
        }
    }
}
class Temp {
    public static void main(String[] args) throws Exception {
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        Pars.bigExporters(parser, "$999,999,999,999");
    }
}

