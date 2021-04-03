/* Populate tablas curriculum */
INSERT INTO users (id, enabled, fecha_registro, password, username, calle, ciudad, email, estado_civil, fecha_nacimiento, imagen, nacionalidad, numero, presentacion, primer_apellido, primer_nombre, run, segundo_apellido, segundo_nombre, telefono) VALUES (1, true, '2021-04-02', '12345', 'nyel', 'Cerro Alto', 'Chillan', 'Barca3420@gmail.com', 'Soltero', '1996-08-27', '', 'Chileno', 191, '', 'Moreno', 'Alan', '19.414.709-0', 'Pando', 'Andy', '+569 4865 1020');
INSERT INTO authorities (id, authority, user_id) VALUES (1, 'Estandar', 1);
INSERT INTO conocimientos (id, autoevaluacion, descripcion, usuario_id) VALUES (1, 8, 'Java', 1);
INSERT INTO estudios (id, fecha_inicio, fecha_termino, lugar, tipo, titulo, usuario_id) VALUES (1, '2016-03-08', '2021-03-09', 'Universidad del Bio-Bio', 'Universitaria', 'Ingeniero Civil Informatico', 1);
INSERT INTO experiencias (id, descripcion, fecha_inicio, fecha_termino, usuario_id) VALUES (1, 'Fue una experiencia bastante grata', '2020-01-03', '2020-03-20', 1);
