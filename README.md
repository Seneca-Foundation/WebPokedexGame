# WebPokedexGame

First - run the following docker command for postgres:

    docker run --name pokemonweb-db -p 5432:5432 -e POSTGRES_PASSWORD=yourpassword -e POSTGRES_USER=yourusername -e POSTGRES_DB=pokemondbweb -d postgres

Second - run the following docker command for pg4admin:

    docker run -p 81:80 -e 'PGADMIN_DEFAULT_EMAIL=youremail@email.com' -e 'PGADMIN_DEFAULT_PASSWORD=yourpassword' -d dpage/pgadmin4:snapshot

Browser to localhost:81/browser/ and login.  Add a server, using your ip address as the host and the login information from the first step

Make sure you have the following in your application.properties:

    server.port=80
    spring.jpa.database=POSTGRESQL
    spring.sql.init.platform=pokemondbweb
    spring.datasource.url=jdbc:postgresql://localhost:5432/pokemondbweb
    spring.jpa.show-sql=true
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto=create-drop
    spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    spring.profiles.active=@active.profile@
    spring.web.resources.cache.cachecontrol.no-cache=true
    spring.web.resources.chain.cache=false
    spring.thymeleaf.cache=false
    spring.cache.type=NONE
    spring.thymeleaf.prefix=file:src/main/resources/templates/

Make sure you have the following in your application-yourname.properties, matching the username/password from step 1:

    spring.datasource.url=jdbc:postgresql://localhost:5432/pokemondbweb
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=create-drop
    spring.web.resources.cache.cachecontrol.no-cache=true
    spring.web.resources.chain.cache=false
    spring.thymeleaf.cache=false
    spring.cache.type=NONE

in the .vscode directory - there is a folder called .vscode/launch.json.  It's contents should be this:

    {
        "configurations": [
            {
                "type": "java",
                "name": "Spring Boot-WebPokemonGameApplication<web-pokedex-game>",
                "request": "launch",
                "cwd": "${workspaceFolder}",
                "console": "internalConsole",
                "mainClass": "com.senecafoundation.webpokedexgame.WebPokemonGameApplication",
                "projectName": "web-pokedex-game",
                "args": "--spring.profiles.active=yourname"
            }
        ]
    }

Open your .gitignore file and make sure application-yourname.properties is added to the bottom, or else you might end up checking in your properties file and sharing your password with everyone like Makayla did:

.gitignore:

    application-warren.properties
    application-Cristian.properties
