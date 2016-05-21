package mockitolesson;

import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Author: Evgeny Anisimoff
 * Created: 16/05/16.
 */
public class ThreadPreview {
    private final String opPost;
    private final List<String> tailPosts;

    public ThreadPreview(String opPost, List<String> tailPosts) {
        this.opPost = opPost;
        this.tailPosts = unmodifiableList(tailPosts);
    }

    public String getOpPost() {
        return opPost;
    }

    public List<String> getTailPosts() {
        return tailPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreadPreview that = (ThreadPreview) o;

        if (opPost != null ? !opPost.equals(that.opPost) : that.opPost != null) return false;
        if (tailPosts != null ? !tailPosts.equals(that.tailPosts) : that.tailPosts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = opPost != null ? opPost.hashCode() : 0;
        result = 31 * result + (tailPosts != null ? tailPosts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ThreadPreview{" +
                "opPost='" + opPost + '\'' +
                ", tailPosts=" + tailPosts +
                '}';
    }
}
