package Services;
import java.io.IOException;
import java.io.File;

public class FileOperations {
    public static void checkFile(
            String path) {

        File file =
                new File(path);

        System.out.println(
                "Exists : "
                        +
                        file.exists()
        );
    }

    public static void deleteFile(
            String path) {

        File file =
                new File(path);

        if(file.delete()) {

            System.out.println(
                    "File Deleted"
            );
        }
    }

    public static void createDirectory(
            String path) {

        File file =
                new File(path);

        file.mkdir();
    }

    public static void createFile(
            String path)

            throws IOException {

        File file =
                new File(path);

        file.createNewFile();
    }

    public static void listFiles(
            String path) {

        File folder =
                new File(path);

        File[] files =
                folder.listFiles();

        if(files != null) {

            for(File file : files) {

                System.out.println(
                        file.getName()
                );
            }
        }
    }
}
