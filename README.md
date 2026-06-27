# ==Spring Boot Journey==

# Day One
  **1) What spring boot actually is ?** <br>
    - it consist of Dependency injection,Web,data and security.<br>
    - it has auto configuration so i dont have to manually do it.<br>
    - it has embedded tomcat server that run inside my JAR (Java Archive).<br>

  **2) Three core concepts** <br>
    - Dependency injection.<br>
    - Controllers.<br>
    - application.property (i talk to the frame work).<br>

  **3) @RestController** <br>
    - This handles incoming request and sends response over the internet for classes without this that class is completley ingored by the Spring.<br>

  **4) @GetMapping("/")** <br>
    - When i typed localhost:8080 in my browser it sends GET request, so which method holds this mapping will show up in the browser.<br>


# Day Two
  **1) Spring converts Java objects to JSON format automatically.** <br>

  **2) @RequestBody** <br>
    - Converts incoming JSON file to a JAVA object.<br>
    - Spring converts JAVA->JSON on the way out, @RequestBody converts JSON->JAVA on the way in<br>

  **3) @PostMapping** <br>
    - Handles POST requests.<br>

  **4) @Entity** <br>
    - Represents a JAVA class as a database table.<br>

  **5) @ (FieldName)** <br>
    - This field is the unique identifier of the database table

  **6) @GeneratedValue (strategy= GenerationType.IDENTITY)** <br>
    - Tells JPA to generate value automatically when i add this row(Primary key).<br>

  **7) H2 Database**
    - Extremely light weight and embedded inside the application's memory.<br>


# Day Three
  **1) @DeleteMapping("/tasks/{uniqueIdentifier}")** <br>
    - Handles DELETE request.<br>
    - @PathVariable(Tells spring to take this {uniqueIdenti} from the URL and pass it as parameter).<br>

  **2) @PutMapping("/tasks/{uniqueIdentifier}")** <br>
    - Handles UPDATE request.<br>
    - 2 parameters(@PathVariable uniqueIdentifier, @RequestBody Object object).<br>
    - before saving , object.setUniqueIdentifier(uniqueIdentifier).<br>

  **3) Connected my backend to a permenent database(PostgreSQL)** <br>

  **4) @Service** <br>
    - Tells spring this class contains business logics.<br>


# Day Four
  **1) @ControllerAdvice**<br>
    - Catches escaped exception in this class.<br>

  **2) @ExceptionHandler(ExceptionName.class)** <br>
    - Tells spring to , Catch this particular exception.<br>

  **3) ResponseEntity** <br>
    - Lets you controll HTTP status code.<br> 

  **4) @NotBlank(message="your error handling message")** <br>
    - Tells this feild cannot be empty.<br>

  **5) @Valid** <br>
    - Tells check this method before running.<br>

  **6) @Table(name="tablename")** <br>
    - Create a table with name tablename. <br>

  **7) @Column(unique = true)** <br>
    - Make sure that two users cannot have same username.<br>

  **8) Optional** <br>
    - A container with something has or doesnt.<br>

  **9) @Component** <br>
    - Tells spring to create and manage an instance of this class , so i dont need to write New keyword.<br>

  **10) PasswordEncoder** <br>
    - Take user's plain password and convert into Hashing.<br>
