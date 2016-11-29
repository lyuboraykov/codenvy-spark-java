package application.user;

import org.mindrot.jbcrypt.BCrypt;

import static application.Application.userDao;

public class UserController {
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
        return hashedPassword.equals(user.getHashedPassword());
    }

    public static void setPassword(String username, String oldPassword, String newPassword) {
        if (authenticate(username, oldPassword)) {
            String newSalt = BCrypt.gensalt();
            String newPasswordHash = BCrypt.hashpw(newSalt, newPassword);
            // Save to DB
        }
    }
}
