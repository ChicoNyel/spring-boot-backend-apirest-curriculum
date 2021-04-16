/* Populate tablas curriculum */

INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES (1, 'alan', '$2a$10$cKBwV6RZdYPdchk5sSvfxuNOBbleR0iRVKyhDFExzUSyAnS/.ALsC', 1, 'Alan', 'Moreno', 'Barca3420@gmail.com');
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES (2, 'matias', '$2a$10$lLOiNStmQz93yMsdlW3LT.0US7IQgHwCevy.kvZB6IQhkzKsDE3eK', 1, 'Matias', 'Moreno', 'matias@gmail.com');

INSERT INTO roles (id, nombre) VALUES (1, 'ROLE_USER');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);

INSERT INTO personas (id, usuario_id, calle, ciudad, email, estado_civil, fecha_nacimiento, imagen, nacionalidad, numero, presentacion, primer_apellido, primer_nombre, run, segundo_apellido, segundo_nombre, telefono) VALUES (1, 1, 'Cerro Alto', 'Chillan', 'Barca3420@gmail.com', 'Soltero', '1996-08-27', '', 'Chileno', 191, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem placeat, eaque itaque fuga possimus dolorum perspiciatis iste! Voluptas nam ab vel, tenetur voluptates dolorum magni possimus, repellat assumenda, perferendis recusandae.', 'Moreno', 'Alan', '19.414.709-0', 'Pando', 'Andy', '+569 4865 1020');
INSERT INTO personas (id, usuario_id, calle, ciudad, email, estado_civil, fecha_nacimiento, imagen, nacionalidad, numero, presentacion, primer_apellido, primer_nombre, run, segundo_apellido, segundo_nombre, telefono) VALUES (2, 2, 'Alguna calle de Providencia', 'Santiago', 'matias@gmail.com', 'Soltero', '1994-01-28', '', 'Chileno', 3213, 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem placeat, eaque itaque fuga possimus dolorum perspiciatis iste! Voluptas nam ab vel, tenetur voluptates dolorum magni possimus, repellat assumenda, perferendis recusandae.', 'Moreno', 'Matias', '18.312.541-5', 'Pando', 'Alexander', '+569 3214 3256');

INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (1, 'Spring Framework', 'Java', 'Backend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (2, 'Django', 'Python', 'Backend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (3, 'Laravel', 'PHP', 'Backend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (4, 'NodeJS', 'JavaScript', 'Backend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (5, 'Angular', 'JavaScript', 'Frontend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (6, 'React', 'JavaScript', 'Frontend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (7, 'Vue', 'JavaScript', 'Frontend');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (8, 'Flutter', 'Dart', 'Movil');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (9, 'Android', 'Java', 'Movil');
INSERT INTO tecnologias (id, nombre, lenguaje, tipo) VALUES (10, 'Machine Learning', 'Python', 'Inteligencia Artificial');

INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (1, 8, 1, 1);
INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (2, 5, 2, 1);
INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (3, 5, 3, 1);
INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (4, 8, 2, 2);
INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (5, 8, 10, 2);
INSERT INTO conocimientos (id, autoevaluacion, tecnologia_id, persona_id) VALUES (6, 5, 6, 2);

INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (1, '2016-03-08', '2021-03-09', 'Universidad del Bio-Bio', 'Universitaria', 'Ingeniero Civil Informatico', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (2, '2019-08-27', '2020-01-02', 'Udemy', 'Certificacion', 'Spring Boot', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (3, '2021-01-16', '2021-02-20', 'Udemy', 'Certificacion', 'Angular', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (4, '2021-01-16', '2021-02-20', 'Udemy', 'Certificacion', 'Django', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (5, '2021-01-16', '2021-02-20', 'Udemy', 'Certificacion', 'NodeJS', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, persona_id) VALUES (6, '2016-03-08', '2021-03-09', 'Universidad Federico Santa Maria', 'Universitaria', 'Ingeniero Civil Informatico', 2);

INSERT INTO experiencias (id, lugar, descripcion, fecha_inicio, fecha_termino, persona_id) VALUES (1, 'Universidad de Concepción', 'Software Developer', '2020-01-03', '2020-03-20', 1);
INSERT INTO experiencias (id, lugar, descripcion, fecha_inicio, fecha_termino, persona_id) VALUES (2, 'IBM.', 'Practicante Software Developer', '2020-08-03', '2021-02-20', 2);
INSERT INTO experiencias (id, lugar, descripcion, fecha_inicio, fecha_termino, persona_id) VALUES (3, 'Neural Solutions', 'Data Scientist,', '2020-03-03', '2020-12-20', 2);
INSERT INTO experiencias (id, lugar, descripcion, fecha_inicio, fecha_termino, persona_id) VALUES (4, 'Nursoft.', 'Practicante DevOps Engineer', '2020-01-03', '2020-02-20', 2);
