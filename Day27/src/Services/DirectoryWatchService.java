package Services;
import java.io.IOException;
import java.nio.file.*;

public class DirectoryWatchService {

    public void watchDirectory(
            String path)

            throws IOException,
            InterruptedException {

        WatchService watchService =

                FileSystems
                        .getDefault()
                        .newWatchService();

        Path dir =
                Paths.get(path);

        dir.register(

                watchService,

                StandardWatchEventKinds
                        .ENTRY_CREATE,

                StandardWatchEventKinds
                        .ENTRY_DELETE,

                StandardWatchEventKinds
                        .ENTRY_MODIFY
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