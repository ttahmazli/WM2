## Installing
configure application.properties: 
##REST API
#### Registration
POST| http://localhost:8080/user/register

request body:
 ```sh
{  
    "email": "example@ada.edu.az",
    "password": "password",
    "fisrtName": "fisrtName",
   "lastName": "lastName"
}
 ```
#### Authorization 
 ```sh
 TYPE: Basic Auth:
                    username: email 
                    password: password
 ```
#### Book
POST: http://localhost:8080/book
request body:
```sh
{  
    "category": "category",
      "title": "title",
        "price": price,
        "author": "author"
}
```
GET: http://localhost:8080/book/all

GET: http://localhost:8080/book/{id}

POST: http://localhost:8080/book/category
request body:
```sh
{  
    "category": "Crime"
}
 ```
POST: http://localhost:8080/book/get

request body:
```sh
{  
    "category": "category",
      "title": "title",
        "author": "author"
}
```

#### Take  a book
POST: http://localhost:8080/user/add
request body:
```sh
{  
    "id": bookId
}
 ```

#### Drop a book
POST: http://localhost:8080/user/drop
request body:
```sh
{  
    "id": bookId
}
 ```
####  user books 
POST: http://localhost:8080/user/books