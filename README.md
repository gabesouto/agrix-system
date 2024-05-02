<h1 align="center" style="font-weight: bold;">AGRIX</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
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
| <kbd>POST /persons</kbd>     | creates and register a new  user [response details](#post-auth-detail)
| <kbd>POST /auth/login</kbd>     | authenticate user into the api see [request details](#post-auth-login)

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
