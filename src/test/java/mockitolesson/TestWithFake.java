package mockitolesson;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
public class TestWithFake {

    @Test
    public void testForFiveEntries() {
        List<String> posts = Arrays.asList("first", "second", "third", "fourth", "fifth");
        PostsDao postsDao = new FakePostsDao(posts);
        ThreadDao threadDao = new ThreadDaoImpl(postsDao);
        ThreadPreview threadPreview = threadDao.getThreadPreview(123);
        assertEquals(
                new ThreadPreview("first", Arrays.asList("third", "fourth", "fifth")),
                threadPreview);
    }

    private static class FakePostsDao implements PostsDao {
        private final List<String> posts;

        private FakePostsDao(List<String> posts) {
            this.posts = posts;
        }

        @Override
        public List<String> getPosts(long threadId) {
            return posts;
        }
    }
}
