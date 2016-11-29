package application.user;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class UserDao {

    private final List<User> users = ImmutableList.of(
        new User("lyubo", "$2a$10$h.dl5J86rGH7I8bD9bZeZe", "$2a$10$h.dl5J86rGH7I8bD9bZeZeci0pDt0.VwFTGujlnEaZXPf/q7vM5wO"),
        new User("dimo",  "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe", "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe1HlCS4bZJ18JuywdEMLT83E1KDmUhCy"),
        new User("sasho", "$2a$10$E3DgchtVry3qlYlzJCsyxe", "$2a$10$E3DgchtVry3qlYlzJCsyxeSK0fftK4v0ynetVCuDdxGVl1obL.ln2")
    );

    public User getUserByUsername(String username) {
        return users.stream().filter(b -> b.getUsername()
                             .equals(username))
                             .findFirst()
                             .orElse(null);
    }
}
