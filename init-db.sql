USE www;

CREATE TABLE electives
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(128),
  description VARCHAR(1024),
  lecturer VARCHAR(128)
);

INSERT INTO electives (title, description, lecturer)
VALUES ("Programming with Go", "Let's learn Go", "Nikolay Batchiyski");

INSERT INTO electives (title, description, lecturer)
VALUES ("AKDU", "Let's Graduate", "Svetlin Ivanov");

INSERT INTO electives (title, description, lecturer)
VALUES ("Web technologies", "Let's learn the web", "Milen Ivanov");