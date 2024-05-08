<h1 align="center" style="font-weight: bold;">AGRIX</h1>

<p align="center">
 <a href="#technologies">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> 
</p>

<p align="center">
    <b>Agrix is a CRUD-based API that provides essential functionalities for managing farms, crops, and fertilizers. It allows users to create, read, update, and delete information efficiently, facilitating better oversight and optimization of agricultural resources.</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- JPA
- Spring Security

<h2 id="started">🚀 Getting started</h2>

Here you describe how to run your project locally

<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [Java](https://www.java.com/pt-BR/)
- [Docker Compose](https://docs.docker.com/compose/)
- [MySQL](https://www.mysql.com/)

<h3>Cloning</h3>

How to clone your project

```bash
git clone git@github.com:gabesouto/agrix-system.git
```

<h3>Config application.properties</h2>

Complete the  ` application.properties` file  with your MySQL and port info.


<h3>Starting</h3>

How to start your project

```bash
cd agrix-system

```
Install the dependencies
```bash
mvn install
```

Run the application
```bash
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>

Here's a list the main routes of this API, and what are their expected request bodies.
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /persons</kbd>     | creates and register a new  user, see [response details](#post-auth-detail)
| <kbd>POST /auth/login</kbd>     | authenticate user into the api, see [request details](#post-auth-login)
| <kbd>GET /farms</kbd>     | retrieves all registered farms, see [request details](#get-farms)
| <kbd>GET /farms/{farmId}</kbd>     | retrieves all registered farms, see [request details](#get-farm-id)
| <kbd>POST /farms/{farmId}/crops</kbd>     | register crops to a farm, see [request details](#post-crops-farm)
| <kbd>GET /farms/{farmId}/crops</kbd>     | retrieves crops related to a farm, see [request details](#get-crops-farm)
| <kbd>GET /crops</kbd>     | retrieves all crops, see [request details](#get-crops)
| <kbd>GET /crops/cropId</kbd>     | retrieves a specific crop, see [request details](#get-crop-id)
| <kbd>GET /crops/search?</kbd>     | retrieves a specific crop based on the date set on the search params, see [request details](#get-crop-search)
| <kbd>POST /fertilizer</kbd>     | register a new fertilizer, see [request details](#post-fertilizer)
| <kbd>GET /fertilizer</kbd>     | retrieves all  fertilizers, see [request details](#get-fertilizers)
| <kbd>GET /fertilizer/{fertilizerId}</kbd>     | retrieves a specific fertilizer, see [request details](#get-fertilizers-id)
| <kbd>POST /crops/{cropId}/fertilizers/{fertilizerId}</kbd>     | associates  a specific fertilizer to a crop, see [request details](#post-fertilizers-crop)
| <kbd>GET /crops/{cropId}/fertilizers</kbd>     | retrieves fertilizers related to a crop, see [request details](#get-fertilizers-crop)



<h3 id="post-auth-detail">POST /persons</h3>

**REQUEST**
```json
{
  "username": "zerocool",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

**RESPONSE**
```json
{
  "id": 1,
  "username": "zerocool",
  "role": "ADMIN"
}
```


<h3 id="post-auth-login">POST /auth/login</h3>

**REQUEST**
```json
{
  "username": "zerocool",
  "password": "senhasecreta"
}
```

**RESPONSE**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhZ3JpeCIsInN1YiI6Im1ycm9ib3QiLCJleHAiOjE2ODk5ODY2NTN9.lyha4rMcMhFd_ij-farGCXuJy-1Tun1IpJd5Ot6z_5w"
}
```


<h3 id="get-farms">GET /farms</h3>


**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Fazendinha",
    "size": 5.0
  },
  {
    "id": 2,
    "name": "Fazenda do Júlio",
    "size": 2.5
  }
]
```



<h3 id="get-farm-id">GET /farms/{farmId}</h3>


**RESPONSE**
```json
{
  "id": 3,
  "name": "My Cabbages!",
  "size": 3.49
}
```

<h3 id="post-crops-farm">POST /farms/{farmId}/crops</h3>

**REQUEST**
```json
{
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08"
}
```

**RESPONSE**
```json
{
  "id": 1,
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08",
  "farmId": 1
}
```


<h3 id="get-crops-farms">GET /farms/{farmId}/crops</h3>


**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "plantedDate": "2022-12-05",
    "harvestDate": "2023-06-08",
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  }
]
```

<h3 id="get-crops">GET /crops</h3>


**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "farmId": 2
  }
]
```


<h3 id="get-crop-id">GET /crops/{cropId}</h3>


**RESPONSE**
```json
{
  "id": 3,
  "name": "Tomate",
  "plantedArea": 1.9,
  "farmId": 2
}
```

<h3 id="get-crop-search">GET /crops/search?start=2023-01-07&end=2024-01-10</h3>


**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "plantedDate": "2022-02-15",
    "harvestDate": "2023-02-20",
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "plantedDate": "2023-05-22",
    "harvestDate": "2024-01-10",
    "farmId": 2
  }
]
```

<h3 id="post-fertilizer">POST /fertilizer</h3>

**REQUEST**
```json
{
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```

**RESPONSE**
```json
{
  "id": 1,
  "name": "Compostagem",
  "brand": "Feita em casa",
  "composition": "Restos de alimentos"
}
```

<h3 id="get-fertilizers">GET /fertilizers</h3>


**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Compostagem",
    "brand": "Feita em casa",
    "composition": "Restos de alimentos"
  },
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```

<h3 id="get-fertilizers-id">GET /fertilizers/{fertilizerId}</h3>


**RESPONSE**
```json
{
  "id": 3,
  "name": "Adubo",
  "brand": "Feito pelas vaquinhas",
  "composition": "Esterco"
}
```

<h3 id="post-fertilizers-crop">POST /crops/{cropId}/fertilizers/{fertilizerId}</h3>

**RESPONSE**
```json
{
Fertilizante e plantação associados com sucesso!
}
```
<h3 id="get-fertilizers-crop">GET /crops/{cropId}/fertilizers</h3>


**RESPONSE**
```json
[
  {
    "id": 2,
    "name": "Húmus",
    "brand": "Feito pelas minhocas",
    "composition": "Muitos nutrientes"
  },
  {
    "id": 3,
    "name": "Adubo",
    "brand": "Feito pelas vaquinhas",
    "composition": "Esterco"
  }
]
```
#  How To Reach Me:
 <a href="mailto:soutogabriel04@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>
 [![image](https://img.shields.io/badge/Linkedin-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gabrielsouto-developer/)

