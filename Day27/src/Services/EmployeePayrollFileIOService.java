package Services;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class EmployeePayrollFileIOService {

    public static void main(String[] args)

            throws IOException {

        File directory =

                new File(
                        "EmployeeData"
                );

        if(!directory.exists()) {

            directory.mkdir();
        }

        File file =

                new File(
                        "EmployeeData/payroll.txt"
                );

        if(!file.exists()) {

            file.createNewFile();
        }

        System.out.println(
                "File Exists : "
                        + file.exists()
        );

        System.out.println(
                "Directory Exists : "
                        + directory.exists()
        );

        System.out.println(
                "Files:"
        );

        Arrays.stream(
                directory.listFiles()
        ).forEach(
                System.out::println
        );
    }
}