<h1 align="center" style="font-weight: bold;">AGRIX</h1>

<p align="center">
 <a href="#technologies">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Collaborators</a> •
 <a href="#contribute">Contribute</a>
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
mvn install
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

´´´

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




<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/61896274?v=4" width="100px;" alt="Fernanda Kipper Profile Picture"/><br>
        <sub>
          <b>Fernanda Kipper</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://t.ctcdn.com.br/n7eZ74KAcU3iYwnQ89-ul9txVxc=/400x400/smart/filters:format(webp)/i490769.jpeg" width="100px;" alt="Elon Musk Picture"/><br>
        <sub>
          <b>Elon Musk</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://miro.medium.com/max/360/0*1SkS3mSorArvY9kS.jpg" width="100px;" alt="Foto do Steve Jobs"/><br>
        <sub>
          <b>Steve Jobs</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h2 id="contribute">📫 Contribute</h2>

Here you will explain how other developers can contribute to your project. For example, explaining how can create their branches, which patterns to follow and how to open an pull request

1. `git clone https://github.com/Fernanda-Kipper/text-editor.git`
2. `git checkout -b feature/NAME`
3. Follow commit patterns
4. Open a Pull Request explaining the problem solved or feature made, if exists, append screenshot of visual modifications and wait for the review!

<h3>Documentations that might help</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)
