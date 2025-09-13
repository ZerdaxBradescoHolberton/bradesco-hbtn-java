import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;

    public Blog() {
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void adicionarPostagem(Post post) {
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {
        return posts.stream().map(Post::getAutor).distinct().collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        posts.stream().map(Post::getCategoria).forEach(s -> {
            int quantidade= (int) posts.stream().filter(post -> post.getCategoria().equals(s)).count();
            contagem.put(s, quantidade);
        });
        return contagem;
    }
}