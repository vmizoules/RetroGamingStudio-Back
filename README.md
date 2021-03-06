# Subject :

Link : `https://github.com/bkuchcik/cours-jee-isima/blob/master/sujets/Sujet%20TP%20final.pdf`

# API of RetroGamingStudio project

Front-End is available at : [RetroGamingStudio-Front](https://github.com/vmizoules/RetroGamingStudio-Front)

## Game :

Read All : GET `http://localhost:8080/games`

Read One : GET `http://localhost:8080/games/2`

Write One : POST `http://localhost:8080/games`

    {
        "name":"Mario Bros 1",
        "gameFranchise": "1",  // Optional
        "description":"Easiest game in the world!",
        "consoles":[1,2],
        "image":"dGVzdA=="
    }

Delete One : `DELETE http://localhost:8080/games/2`

Add playability score on a game : `POST http://localhost:8080/games/1/playabilityScores`

	{
		"score": 5
	}

Add graphics score on a game : `POST http://localhost:8080/games/1/graphicsScores`

	{
		"score": 2
	}

Add interest score on a game : `POST http://localhost:8080/games/1/interestScores`

	{
		"score": 3
	}


## Console :

Read All : GET `http://localhost:8080/consoles`

Read One : GET `http://localhost:8080/consoles/2`

Write : POST `http://localhost:8080/consoles`

    {
        "name":"ps3"
    }

Delete One : `DELETE http://localhost:8080/consoles/2`

## Game Franchise :

Read All : GET `http://localhost:8080/gameFranchises`

Read One : GET `http://localhost:8080/gameFranchises/2`

Write : POST `http://localhost:8080/gameFranchises`

    {
        "name":"Mario"
    }

Delete One : `DELETE http://localhost:8080/gameFranchises/2`

# Application

Build the app :

  - directly with IntelliJ
  - with maven `mvn clean package`

Run the app :

  - copy the .war in `/var/lib/tomcat8/webapps`, then restart tomcat server
  - directly run `mvn spring-boot:run` (don't forget to stop **tomcat** service before)

Access to the app :

  - with tomcat server and deployed war : http://localhost:8080/{app-name}/
  - with the "mvn solution" : http://localhost:8080/

