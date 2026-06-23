# ==SpringBootJourney==

# Day One
**1)What spring boot actually is ?** <br>
  -it consist of Dependency injection,Web,data and security.<br>
  -it has auto configuration so i dont have to manually do it.<br>
  -it has embedded tomcat server that run inside my JAR (Java Archive).<br>

**2)Three core concepts** <br>
  -Dependency injection.<br>
  -Controllers.<br>
  -application.property (i talk to the frame work).<br>

**3)@RestController** <br>
  -This handles incoming request and sends response over the internet for classes without this that class is completley ingored by the Spring.<br>

**4)@GetMapping("/")** <br>
  -When i typed localhost:8080 in my browser it sends GET request, so which method holds this mapping will show up in the browser.<br>


# Day Two
**1)Spring converts Java objects to JSON format automatically.** <br>

**2)@RequestBody** <br>
  -Converts incoming JSON file to a JAVA object.<br>
  -Spring converts JAVA->JSON on the way out, @RequestBody converts JSON->JAVA on the way in<br>

**3)@PostMapping** <br>
  -Handles POST requests.<br>

**4)@Entity** <br>
  -Represents a JAVA class as a database table.<br>

**5)@ (FieldName)** <br>
  -This field is the unique identifier of the database table

**6)@GeneratedValue (strategy= GenerationType.IDENTITY)** <br>
  -Tells JPA to generate value automatically when i add this row(Primary key).<br>

**7)H2 Database**
  -Extremely light weight and embedded inside the application's memory.<br>
