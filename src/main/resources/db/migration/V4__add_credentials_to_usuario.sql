ALTER TABLE usuario
  ADD COLUMN login VARCHAR(180) NULL,
  ADD COLUMN clave VARCHAR(255) NULL;

UPDATE usuario
SET login = CONCAT('user', id)
WHERE login IS NULL OR login = '';

UPDATE usuario
SET clave = '$2a$12$PuZmd/AGFGDPFJjz.M7eEu4k0GdC/eFmqFrTFehLi/ffjMLvDSVuu'  -- bcrypt dummy
WHERE clave IS NULL OR clave = '';

ALTER TABLE usuario
  MODIFY COLUMN login VARCHAR(180) NOT NULL,
  MODIFY COLUMN clave VARCHAR(255) NOT NULL;

CREATE UNIQUE INDEX ux_usuario_login ON usuario(login);

INSERT INTO usuario (nombre, login, clave)
VALUES ('Usuario Demo', 'demo@forohub.com', '$2a$12$PuZmd/AGFGDPFJjz.M7eEu4k0GdC/eFmqFrTFehLi/ffjMLvDSVuu') AS new
ON DUPLICATE KEY UPDATE nombre = new.nombre;