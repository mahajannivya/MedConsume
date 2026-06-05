# MedConsume - Medicine Verification Platform (Spring Boot)

## What this project includes
- Spring Boot (REST) backend
- H2 in-memory database (easy to run)
- Entities: User, Medicine, TestRequest, LabReport, Complaint
- Repositories, Services, Controllers (simple, clear architecture)
- OpenAPI UI (Swagger) available at `/swagger-ui.html` when running
- Seed data inserted at startup

## How to run
1. Ensure you have Java 17+ and Maven installed.
2. Unzip the project and open a terminal at project root.
3. Run:
   ```
   mvn spring-boot:run
   ```
4. The app runs on `http://localhost:8080`.
5. H2 console: `http://localhost:8080/h2-console` (jdbc url: `jdbc:h2:mem:meddb`)
6. API examples:
   - GET `/api/medicines` - list medicines
   - POST `/api/medicines` - create medicine (JSON body)
   - POST `/api/tests` - request a test
   - POST `/api/reports` - lab submits report
   - POST `/api/complaints` - file a complaint
   - GET `/api/admin/dashboard` - admin overview

## Notes & Next steps
- This is a minimal viable version intended for local development and learning.
- For production, add:
  - Authentication & Authorization (JWT / OAuth2)
  - Persistent DB (MySQL / PostgreSQL)
  - File storage for lab reports (S3), email notifications
  - Robust validation, DTOs, exception handling, logging
  - Tests (unit + integration)
  - Containerization (Docker) and CI/CD
