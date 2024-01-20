## Getting Started

#### 1. Clone the repository:

```bash
git clone https://github.com/visheshks04/UserAuthDemo.git
```

#### 2. Navigate to the directory
```
cd spring-boot-jwt-auth
```

#### 3. Configuration in the application.properties
```
application.security.jwt.secret-key=yourSecretKey
```

#### 4. Signup and Login

```
POST /api/user/signUp
POST /api/user/login
```
both take in a "username" and "password" field in RequestBody

#### 5. Protected API

```
GET /api/hello
```
required the bearer token generated at login
