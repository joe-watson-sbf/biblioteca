### Java Spring Boot Api y MongoDB

**Una aplicación que permita administrar un Biblioteca Publica.**



- ## Peticion: GET

  **Description:** Obtener todos los recursos
  
  **URL:** http://localhost:8080/api/library
  
  



- ## Peticion: GET

   **Description:** Obtener recursos por categoria o tipo

   **URL:** http://localhost:8080/api/library/search?type=[el tipo aqui]&category=[categoria aqui]
   
   **Exemple:** http://localhost:8080/api/library/search?type=Book&category=Programmation
   
   
     
     
- ## Peticion: GET

  **Description:** Obtener un recurso prestado sino un mensaje texto
  
  **URL:** http://localhost:8080/api/library
  
  **Exemple:** http://localhost:8080/api/library/search/61750c9cdb45d1497be1bb3e
  
  
  
  
  - ## Peticion: POST

  **Description:** Crear un nuevo recurso
  
  **URL:** http://localhost:8080/api/library
  
  
  
  
  - ## Peticion: GET

  **Description:** Verifique si un recurso se encuentra disponible
  
  **URL:** http://localhost:8080/api/library/availability/{recursoId}
  
  **Exemple:** http://localhost:8080/api/library/availability/617508c6be546732aba73338
  
  
  
  
  
- ## Peticion: POST

  **Description:** Hacer prestamo de un recurso
  
  **URL:** http://localhost:8080/api/library/loan/{recursoId}
  
  **Exemple:** http://localhost:8080/api/library/loan/617508c6be546732aba73338
  
  
  
  
  
