package mockitolesson;

import java.util.List;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
public interface PostsDao {
    public List<String> getPosts(long threadId);
}
