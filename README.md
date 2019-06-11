<<<<<<< HEAD
# RestApiApp

=======
# Cassandra-REST-API
Simple REST API with Cassandra
>>>>>>> aed262bbb723150e3a9c884b6cf154277e68e85c

  <h3>Endpoints:<h3>
  
  1) POST /api/message
  2) GET /api/{emailValue}
  3) POST /api/send
  
  <h3>Usage examples:<h3>
  
  1) Storing message into Cassandra:
     <br>POST /api/message -d {"email": "john123@example.com", "title": "No title", "content":"Simple text", "magic_number":130}
  2) Getting all messages with email specified int the {emailValue} path variable: 
  <br>GET /api/john123@example.com
  3) Sending messages with magic_number specified in the request body:
    <br>POST /api/send -d {"magic_number":130}
