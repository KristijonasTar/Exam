import com.eisgroup.javaexam.library.Library;
import com.eisgroup.javaexam.library.test.BaseLibraryTest;

public class MainTest extends BaseLibraryTest {
    @Override
    protected Library getLibrary() {
        return new MainLibrary();
    }
}
