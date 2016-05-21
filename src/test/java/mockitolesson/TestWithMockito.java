package mockitolesson;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
public class TestWithMockito {
    private final long THREAD_ID = 123;

    @Test
    public void testThreadPreview() {
        test(
                asList("1", "2", "3", "4", "5"),
                new ThreadPreview("1", asList("3", "4", "5")));

        test(
                asList("1", "2", "3", "4"),
                new ThreadPreview("1", asList("2", "3", "4")));

        test(
                asList("1", "2", "3"),
                new ThreadPreview("1", asList("2", "3")));

        test(
                asList("1", "2"),
                new ThreadPreview("1", asList("2")));

        test(
                asList("1"),
                new ThreadPreview("1", Collections.<String>emptyList()));

        test(
                Collections.<String>emptyList(),
                null);
    }

    private void test(List<String> posts, ThreadPreview expectedThreadPreview) {
        PostsDao postsDao = Mockito.mock(PostsDao.class);
        when(postsDao.getPosts(THREAD_ID)).thenReturn(posts);

        ThreadDao threadDao = new ThreadDaoImpl(postsDao);
        ThreadPreview threadPreview = threadDao.getThreadPreview(THREAD_ID);
        assertEquals(expectedThreadPreview, threadPreview);
    }

    @Test
    public void checkPostsDaoCalledOnce() {
        PostsDao postsDao = Mockito.mock(PostsDao.class);
        when(postsDao.getPosts(THREAD_ID)).thenReturn(asList("1", "2", "3"));

        ThreadDao threadDao = new ThreadDaoImpl(postsDao);
        threadDao.getThreadPreview(THREAD_ID);

        verify(postsDao).getPosts(THREAD_ID);
        verify(postsDao, never()).getPosts(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPropagatesException() {
        PostsDao postsDao = Mockito.mock(PostsDao.class);
        when(postsDao.getPosts(THREAD_ID)).thenThrow(new IllegalArgumentException());

        ThreadDao threadDao = new ThreadDaoImpl(postsDao);
        threadDao.getThreadPreview(THREAD_ID);
    }
}
