package Test;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {

    @Test
    void givenFile_WhenCreated_ShouldExist() {

        File file =

                new File(
                        "sample.txt"
                );

        assertFalse(
                file.exists()
        );
    }
}