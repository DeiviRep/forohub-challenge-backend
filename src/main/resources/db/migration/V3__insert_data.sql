INSERT INTO topico (id, titulo, mensaje, fecha_creacion, status, autor_id, curso_id) VALUES
  (6, 'NullPointer al iniciar', 'Excepción al levantar contexto', '2024-08-10 10:30:00', 'ABIERTO', 1, 1),
  (7, 'CORS en producción', 'Error CORS con dominios', '2025-01-12 09:00:00', 'CERRADO', 2, 2),
  (8, 'ORM en Python', 'Duda entre SQLAlchemy y Django ORM', '2026-02-01 12:00:00', 'ABIERTO', 3, 3)
ON DUPLICATE KEY UPDATE titulo = VALUES(titulo);