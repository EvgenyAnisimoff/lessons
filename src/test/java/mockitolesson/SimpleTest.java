package mockitolesson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
@RunWith(JUnit4.class)
public class SimpleTest {
    @Test
    public void instantiationTest() {
        PostsDao postsDao = new MamkuEbalPostsDao();
        ThreadDao threadDao = new ThreadDaoImpl(postsDao);
    }

    private static class MamkuEbalPostsDao implements PostsDao{
        @Override
        public List<String> getPosts(long threadId) {
            return Arrays.asList("Mamku ebal");
        }
    }
}
