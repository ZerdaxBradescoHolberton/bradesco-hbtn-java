import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        posts.stream().filter(post1 -> post1.getAutor().equals(post.getAutor())
                && post1.getTitulo().equals(post.getTitulo())).findAny().ifPresent(post1 -> {
                    throw new RuntimeException("Postagem jah existente");
        });
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return posts.stream().map(Post::getAutor).collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new TreeMap<>();
        posts.stream().map(Post::getCategoria).forEach(s -> {
            int quantidade= (int) posts.stream().filter(post -> post.getCategoria().equals(s)).count();
            contagem.put(s, quantidade);
        });
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return posts.stream().filter(post -> post.getAutor().equals(autor))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categorias) {
        return posts.stream().filter(post -> post.getCategoria().equals(categorias))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> categoriasPosts = new TreeMap<>();
        Arrays.stream(Categorias.values()).forEach(categorias -> {
            Set<Post> postsCategoria = posts.stream().filter(post -> post.getCategoria().equals(categorias))
                    .collect(Collectors.toCollection(TreeSet::new));
            categoriasPosts.put(categorias, postsCategoria);
        });
        return categoriasPosts;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> autoresPosts = new TreeMap<>();
        obterTodosAutores().forEach(autor -> {
            Set<Post> postsAutor = posts.stream().filter(post -> post.getAutor().equals(autor))
                    .collect(Collectors.toCollection(TreeSet::new));
            autoresPosts.put(autor, postsAutor);
        });
        return autoresPosts;
    }
}