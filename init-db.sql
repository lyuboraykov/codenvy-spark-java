USE www;

CREATE TABLE electives
(
  title VARCHAR(128),
  decription VARCHAR(1024),
  lecturer VARCHAR(128)
);

INSERT INTO electives (title, decription, lecturer)
VALUES ("Програмиране с Go", "Да научим Go", "Николай Бачийски");

INSERT INTO electives (title, decription, lecturer)
VALUES ("АКДУ", "Да завършим ФМИ", "Свелин Иванов");

INSERT INTO electives (title, decription, lecturer)
VALUES ("Уеб Технологии", "Да научим уеба", "Милен Иванов");