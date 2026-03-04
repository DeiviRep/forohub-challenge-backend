-- USUARIOS
INSERT INTO usuario (id, nombre) VALUES
  (1, 'Ana Pérez'),
  (2, 'Juan López'),
  (3, 'María García')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

-- CURSOS
INSERT INTO curso (id, nombre) VALUES
  (1, 'Java Spring'),
  (2, 'JavaScript'),
  (3, 'Python')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

-- TÓPICOS
INSERT INTO topico (id, titulo, mensaje, fecha_creacion, status, autor_id, curso_id)
VALUES
  (1, 'Error 500 al publicar', 'Se produce 500 al enviar el formulario de crear post', NOW(), 'ABIERTO', 1, 1),
  (2, 'Duda con @Transactional', '¿Cuándo usar @Transactional en métodos de servicio?', NOW(), 'ABIERTO', 2, 1),
  (3, 'Fetch Lazy vs Eager', '¿Cuál es la mejor práctica para relaciones en JPA?', NOW(), 'CERRADO', 1, 1),
  (4, 'Axios 404 en frontend', 'Petición GET devuelve 404 con params en JS', NOW(), 'ABIERTO', 2, 2),
  (5, 'Error de indentación', 'Problemas con espacios/tabs en Python', NOW(), 'ABIERTO', 3, 3)
ON DUPLICATE KEY UPDATE
  titulo = VALUES(titulo),
  mensaje = VALUES(mensaje),
  status  = VALUES(status);

-- RESPUESTAS
INSERT INTO respuesta (id, mensaje, topico_id, fecha_creacion, autor_id, solucion)
VALUES
  (1, 'Revisa el controller y el manejo de excepciones', 1, NOW(), 2, 0),
  (2, 'Prueba con @Transactional en el método que persiste', 2, NOW(), 1, 0),
  (3, 'Usa LAZY por defecto y JOIN FETCH en lecturas', 3, NOW(), 2, 1),
  (4, 'Verifica la ruta y query params en el cliente', 4, NOW(), 1, 0),
  (5, 'Configura el editor para 4 espacios en Python', 5, NOW(), 3, 1)
ON DUPLICATE KEY UPDATE
  mensaje = VALUES(mensaje),
  solucion = VALUES(solucion);