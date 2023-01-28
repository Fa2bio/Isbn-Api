<h1>Isbn-API</h1>

> Status: Finished ✔️

## Contents
  
* [What is it?](#what-is-it)
* [Requirements](#requirements)
* [Technologies Used](#technologies)
* [Installation](#installation)
* [Run Application](#run-application)

## <a name="what-is-it"></a>What is it?

- This API queries a book through ISBN-10 or ISBN-13 code and returns a Json with the some of his foremost information of that book.
- The base url that this api consumes is https://www.googleapis.com/books/v1/volumes?q=isbn:{isbn}

## <a name="requirements"></a>Requirements

- Java 11+
- Spring Boot
- Lombok

## <a name="technologies"></a>Technologies Used

- Java
- Spring Boot (version 2.7.7)
- Lombok
- Google Gson
- Model Mapper

## <a name="installation"></a>Installation
- Clone the repository for your device;
- Import it as a MAVEN project.

## <a name="run-application"></a>Run Application
- After meeting the requirements and installation, run the main method in IsbnApplication.java at a spring boot app;
- Make a HTTP GET request at http://localhost:8080/isbn/{isbn};
- You'll get the ensuring Json return:
###
```xml
{
    "title": "Animal Farm",
    "publishedDate": "2019",
    "description": "A beautiful graphic adaptation of George Orwell's timeless and timely allegorical novel. \"All animals are equal, but some animals are more equal than others.\" In 1945, George Orwell, called \"the conscience of his generation,\" created an enduring, devastating story of new tyranny replacing old, and power corrupting even the noblest of causes. Today it is all too clear that Orwell's masterpiece is still fiercely relevant wherever cults of personality thrive, truths are twisted by those in power, and freedom is under attack. Now, in this fully authorized edition, the artist Odyr translates the world and message of Animal Farm into a gorgeously imagined graphic novel. Old Major, Napoleon, Squealer, Snowball, Boxer, and all the animals of Animal Farm come to life in this newly envisaged classic. From his individual brushstrokes to the freedom of his page design, Odyr's adaptation seamlessly moves between satire and fable and will appeal to all ages, just as Orwell intended.",
    "language": "en",
    "pageCount": 179,
    "isbn_10": "0358093155",
    "isbn_13": "9780358093152",
    "authors": [
        "George Orwell"
    ]
}
```
