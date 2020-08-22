package app.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {
    private final User[] users = {
            //        Username    Salt for hash                    Hashed password (the password is "password" for all users)
            new User("perwendel", "$2a$10$h.dl5J86rGH7I8bD9bZeZe", "$2a$10$h.dl5J86rGH7I8bD9bZeZeci0pDt0.VwFTGujlnEaZXPf/q7vM5wO"),
            new User("davidase", "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe", "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe1HlCS4bZJ18JuywdEMLT83E1KDmUhCy"),
            new User("<script>alert('hacker')</script>", "$2a$10$E3DgchtVry3qlYlzJCsyxe", "$2a$10$E3DgchtVry3qlYlzJCsyxeSK0fftK4v0ynetVCuDdxGVl1obL.ln2")
    };

    public User getUserByUsername(String username) {
        return Arrays.stream(users).filter(b -> b.username.equals(username)).findFirst().orElse(null);
    }

    public List<String> getAllUserNames() {
        return Arrays.stream(users).map(user -> user.username).collect(Collectors.toList());
    }
}
