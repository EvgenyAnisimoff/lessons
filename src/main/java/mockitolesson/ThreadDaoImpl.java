package mockitolesson;

import java.util.List;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
public class ThreadDaoImpl implements ThreadDao {
    private final PostsDao postsDao;

    public ThreadDaoImpl(PostsDao postsDao) {
        this.postsDao = postsDao;
    }

    @Override
    public ThreadPreview getThreadPreview(long threadId) {
        List<String> posts = postsDao.getPosts(threadId);
        if (posts.isEmpty()) return null;

        String opPost = posts.get(0);
        int fromIndex = Math.max(1, posts.size() - 3);
        List<String> tailPosts = posts.subList(fromIndex, posts.size());
        return new ThreadPreview(opPost, tailPosts);
    }
}
