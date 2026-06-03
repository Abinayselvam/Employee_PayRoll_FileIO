package Services;

import java.nio.file.*;

public class EmployeePayRollWatcherService {
    public static void main(String[] args)

            throws Exception {

        WatchService watchService =

                FileSystems
                        .getDefault()
                        .newWatchService();

        Path path =
                Paths.get(
                        "EmployeeData"
                );

        path.register(

                watchService,

                StandardWatchEventKinds
                        .ENTRY_CREATE,

                StandardWatchEventKinds
                        .ENTRY_DELETE
        );

        System.out.println(
                "Watching Directory..."
        );

        while(true) {

            WatchKey key =
                    watchService.take();

            for(WatchEvent<?> event
                    : key.pollEvents()) {

                System.out.println(

                        event.kind()

                                +

                                " : "

                                +

                                event.context()
                );
            }

            key.reset();
        }
    }

}
